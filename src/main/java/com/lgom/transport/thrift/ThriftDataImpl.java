package com.lgom.transport.thrift;

import org.apache.thrift.TException;

import java.util.List;

/**
 * @author Mr qiu
 * @description 测试实现类
 * @date 2020-06-11 15:00
 */
public class ThriftDataImpl implements THServProxy.Iface{


    @Override
    public int login(String userName, String passwd) throws TException {
        return 0;
    }

    @Override
    public int Db_addData(String oname, String tableName, String data) throws TException {

        System.out.println(oname + "----tableName:  " + tableName + "-----data:  " + data);
        return 0;
    }

    @Override
    public List<String> Db_query(String oname, String tableName, String columns, String condition) throws TException {
        return null;
    }

    @Override
    public List<String> Db_queryEx(String oname, String tableName, String columns, String condition, int useOnameCond) throws TException {
        return null;
    }

}
