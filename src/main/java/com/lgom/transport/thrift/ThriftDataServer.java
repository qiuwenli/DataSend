package com.lgom.transport.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * @author Mr qiu
 * @description 服务端
 * @date 2020-06-11 14:56
 */
public class ThriftDataServer {

    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TNonblockingServer start ....");

            TProcessor tprocessor = new THServProxy.Processor<THServProxy.Iface>(new ThriftDataImpl());

            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(SERVER_PORT);
            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(tnbSocketTransport);
            tnbArgs.processor(tprocessor);
            tnbArgs.transportFactory(new TFramedTransport.Factory());
            tnbArgs.protocolFactory(new TBinaryProtocol.Factory());

            // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
            TServer server = new TNonblockingServer(tnbArgs);
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ThriftDataServer server = new ThriftDataServer();
        server.startServer();
    }



}
