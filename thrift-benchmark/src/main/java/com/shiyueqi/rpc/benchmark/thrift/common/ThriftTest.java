package com.shiyueqi.rpc.benchmark.thrift.common;

import com.shiyueqi.rpc.benchmark.AbstractTest;
import com.shiyueqi.rpc.benchmark.thrift.client.ThriftClient;
//import com.unionpay.rpc.benchmark.magpie.client.ClientMain;

import java.util.concurrent.CountDownLatch;

/**
 * date: 2016/10/20 11:48.
 * author: Yueqi Shi
 */
public class ThriftTest extends AbstractTest {
    private boolean isGetUser = false;
    private boolean isGetUserName = false;

    public ThriftTest(String rpc, String[] args) {
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

        new ThriftClient().start(getCallCount(), isGetUser, isGetUserName);
        endLatch.countDown();
    }


    public static void main(String[] args) {
        new ThriftTest("thrift", args).start();
    }
}
