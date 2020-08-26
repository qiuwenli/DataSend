package com.lgom.transport.thrift;

import com.google.gson.GsonBuilder;
import com.lgom.transport.config.DateFormatConfig;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Mr qiu
 * @description 客户端
 * @date 2020-06-11 15:09
 */
@Component
public class ThriftDataClient {
    @Value("${thrift.serverIp}")
    public String serverIp;
    @Value("${thrift.serverPort}")
    public int serverPort;
    @Value("${thrift.timeout}")
    public int timeout;
    @Value("${thrift.username}")
    private String userName;
    @Value("${thrift.password}")
    private String password;

    /**
     *
     * @param oName name
     * @param tableName 表名称
     * @param dataList 数据列表
     * @throws TException 异常
     */
    public synchronized void sendData2(String oName, String tableName, List<?> dataList) throws TException {
        System.out.println("11111111111111111");
        GsonBuilder gsonbuilder = new GsonBuilder();
        TTransport transport = new TFramedTransport(new TSocket(serverIp, serverPort, timeout));
        TProtocol tProtocol = new TBinaryProtocol(transport);
        THServProxy.Client client = new THServProxy.Client(tProtocol);
        transport.open();
        System.out.println(1111111);
        int login = client.login(userName, password);
        System.out.println(login);

        gsonbuilder.registerTypeAdapter(Date.class, new DateFormatConfig.DateJsonSerializer());
        int result=client.Db_addData(oName, tableName, gsonbuilder.create().toJson(dataList));
        System.out.println(result);
        transport.close();
    }


    /**
     *
     * @param oName name
     * @param tableName 表名称
     * @param dataList 数据列表
     * @throws TException 异常
     */
    public synchronized void sendData(String oName, String tableName, List<?> dataList){
        GsonBuilder gsonbuilder = new GsonBuilder();
        try (TTransport transport = new TSocket(serverIp, serverPort, timeout)) {
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            THServProxy.Client client = new THServProxy.Client(protocol);
            transport.open();
            int login = client.login(userName, password);
            System.out.println(login);
            int result = client.Db_addData(oName, tableName, gsonbuilder.create().toJson(dataList));
            System.out.println("Thrift client result =: " + result);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param <T> 返回类型
     * @param oName 标记
     * @param tableName 表名
     * @param t t
     */
    public synchronized <T> void queryData(String oName, String tableName, T t){
        GsonBuilder gsonbuilder = new GsonBuilder();
        Class<? extends Object> clazz = t.getClass();

        List<T>  list=new ArrayList<>();
        try (TTransport transport = new TSocket(serverIp, serverPort, timeout)) {

            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            THServProxy.Client client = new THServProxy.Client(protocol);
            transport.open();
            int login = client.login(userName, password);
            System.out.println(login);
//            List<String> result = client.Db_query(oName, tableName, gsonbuilder.serializeNulls().create().toJson(t), "");
            List<String> result = client.Db_queryEx(oName, tableName, "", "", 0);
            result.forEach(s -> gsonbuilder.create().toJson(s));
            result.stream().map(s -> (T) gsonbuilder.create().fromJson(s, t.getClass())).forEach(list::add);

            list.forEach(System.out::println);
        } catch (TException e) {
            e.printStackTrace();
        }


    }


}
