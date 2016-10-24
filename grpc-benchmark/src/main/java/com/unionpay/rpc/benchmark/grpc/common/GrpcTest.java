package com.unionpay.rpc.benchmark.grpc.common;

import com.unionpay.rpc.benchmark.AbstractTest;
import com.unionpay.rpc.benchmark.grpc.client.GrpcClient;

import java.util.concurrent.CountDownLatch;

/**
 * date: 2016/10/19 10:34.
 * author: Yueqi Shi
 */
public class GrpcTest extends AbstractTest {

    private boolean isGetUser = false;
    private boolean isGetUserName = false;

    public GrpcTest(String rpc, String[] args) {
        super(rpc, args);

        isGetUser = Boolean.parseBoolean(args[2]);
        isGetUserName = Boolean.parseBoolean(args[3]);
    }

    @Override
    public void exec(CountDownLatch startLatch, CountDownLatch endLatch) {
        try {
            startLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new GrpcClient("127.0.0.1", 50071).start(getCallCount(), isGetUser, isGetUserName);
        endLatch.countDown();
    }


    public static void main(String[] args) {
        new GrpcTest("grpc", args).start();
    }
}
