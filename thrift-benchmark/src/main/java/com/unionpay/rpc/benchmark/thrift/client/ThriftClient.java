package com.unionpay.rpc.benchmark.thrift.client;

import com.unionpay.rpc.benchmark.thrift.api.UserDto;
import com.unionpay.rpc.benchmark.thrift.api.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * date: 2016/10/21 13:24.
 * author: Yueqi Shi
 */
public class ThriftClient {
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 9966;
    public static final int TIMEOUT = 30000;

    private void callGetUser(UserService.Client client, int callCount) {
        UserDto userDto = null;
        Long userId = 123L;

        for(int i = 0; i < callCount; i++) {
            try {
                userDto = client.getUser(userId);
            } catch (TTransportException e) {
                e.printStackTrace();
            } catch (TException e) {
                e.printStackTrace();
            }
        }
    }

    private void callGetUserName(UserService.Client client, int callCount) {
        String userName = "";
        Long userId = 123L;

        for(int i = 0; i < callCount; i++) {
            try {
                userName = client.getUserName(userId);
            } catch (TTransportException e) {
                e.printStackTrace();
            } catch (TException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(int callCount, boolean isGetUser, boolean isGetUserName) {

        //设置传输通道，对于非阻塞服务，需要使用TFramedTransport，它将数据分块发送
        TTransport transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));
        // 协议要和服务端一致
        //HelloTNonblockingServer
        ////使用高密度二进制协议
        // TProtocol protocol = new TCompactProtocol(transport);
        //HelloTHsHaServer
        ////使用二进制协议
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        try {
            transport.open();

            long startTime = System.currentTimeMillis();

            if (isGetUser) {
                this.callGetUser(client, callCount);
            }

            if (isGetUserName) {
                this.callGetUserName(client, callCount);
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("tps: " + callCount * 1000.0 / totalTime + ",   startTime: "
                    + startTime + ", endTime: " + endTime + ", total time: " + totalTime / 1000.0);
        } catch (TTransportException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            transport.close();
        }

    }
}
