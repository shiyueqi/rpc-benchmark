package com.unionpay.rpc.benchmark.magpie.common;

import com.unionpay.rpc.benchmark.AbstractTest;
import com.unionpay.rpc.benchmark.magpie.client.MagpieClient;

import java.util.concurrent.CountDownLatch;

/**
 * date: 2016/10/20 11:48.
 * author: Yueqi Shi
 */
public class MagpieTest extends AbstractTest {

    private boolean isRpc = false;
    private boolean isBinary = false;
    private boolean isGetUser = false;
    private boolean isGetUserName = false;

    public MagpieTest(String rpc, String[] args) {
        super(rpc, args);

        isRpc = Boolean.parseBoolean(args[2]);
        isBinary = Boolean.parseBoolean(args[3]);
        isGetUser = Boolean.parseBoolean(args[4]);
        isGetUserName = Boolean.parseBoolean(args[5]);
    }

    @Override
    public void exec(CountDownLatch startLatch, CountDownLatch endLatch) {
        try {
            startLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new MagpieClient().start(getCallCount(), isRpc, isBinary, isGetUser, isGetUserName);
        endLatch.countDown();
    }


    public static void main(String[] args) {
        new MagpieTest("magpie", args).start();
    }
}
