package com.shiyueqi.rpc.benchmark.thrift.server;

import com.shiyueqi.rpc.benchmark.thrift.api.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * date: 2016/10/21 11:58.
 * author: Yueqi Shi
 */
public class ThriftServer {
    private static final int bossThreads = 10;
    private static final int workerThreads = 200;

    public static void main(String[] args) {
        TNonblockingServerTransport serverTransport;
        try {
            serverTransport = new TNonblockingServerSocket(9966);
            UserService.Processor processor = new UserService.Processor(new UserServiceImpl());

            //多线程半同步半异步
            TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverTransport)
                    .selectorThreads(bossThreads).workerThreads(workerThreads);
            tArgs.processor(processor);
            tArgs.transportFactory(new TFramedTransport.Factory());

            //二进制协议
            tArgs.protocolFactory(new TBinaryProtocol.Factory());


            System.out.println("Thrift Server bossThreads: " + bossThreads
                    + ", workThreads: " + workerThreads + ". Server start....");

            // 多线程半同步半异步的服务模型
            TServer server = new TThreadedSelectorServer(tArgs);
            server.serve(); // 启动服务
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
