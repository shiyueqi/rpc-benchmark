package com.unionpay.rpc.benchmark.dubbo.common;

import com.unionpay.rpc.benchmark.AbstractTest;

import java.util.concurrent.CountDownLatch;

/**
 * date: 2016/10/21 17:54.
 * author: Yueqi Shi
 */
public class DubboTest extends AbstractTest {
    public static boolean isGetUser = false;
    public static boolean isGetUserName = false;

    public static int callCount;

    private String[] args;

    public DubboTest(String rpc, String[] args) {
        super(rpc,args);

        isGetUser = Boolean.parseBoolean(args[2]);
        isGetUserName = Boolean.parseBoolean(args[3]);

        callCount = super.getCallCount();

        this.args=args;
    }

    @Override
    public void exec(CountDownLatch startLatch, CountDownLatch endLatch) {
        try
        {
            startLatch.await();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        com.alibaba.dubbo.container.Main.main(null);
        //endLatch.countDown();
    }




    public static void main(String[] args) {
        new DubboTest("dubbo",args).start();
    }
}
