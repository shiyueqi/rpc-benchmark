package com.shiyueqi.rpc.benchmark.grpc.client;

import com.shiyueqi.rpc.benchmark.grpc.user.User;
import com.shiyueqi.rpc.benchmark.grpc.user.UserRequest;
import com.shiyueqi.rpc.benchmark.grpc.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * date: 2016/10/19 10:21.
 * author: Yueqi Shi
 */
public class GrpcClient {
    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private final ManagedChannel channel;
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public GrpcClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private void callGetUser(int callCount) {
        User user = null;
        UserRequest request = UserRequest.newBuilder()
                .setUserId(12L)
                .build();

        for(int i = 0; i < callCount; i++) {
            user = blockingStub.getUser(request).getUser();
        }
    }

    private void callGetUserName(int callCount) {
        String userName = "";
        UserRequest request = UserRequest.newBuilder()
                .setUserId(12L)
                .build();

        for(int i = 0; i < callCount; i++) {
            userName = blockingStub.getUserName(request).getUserName();
        }
    }

    /** Say hello to server. */
    public void start(int callCount, boolean isGetUser, boolean isGetUserName) {
        try {
            long startTime = System.currentTimeMillis();

            if (isGetUser) {
                this.callGetUser(callCount);
            }

            if (isGetUserName) {
                this.callGetUserName(callCount);
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("tps: " + callCount * 1000.0 / totalTime + ",   startTime: "
                    + startTime + ", endTime: " + endTime + ", total time: " + totalTime / 1000.0);

        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "RPC failed", e);
            return;
        } finally {
            try {
                shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
