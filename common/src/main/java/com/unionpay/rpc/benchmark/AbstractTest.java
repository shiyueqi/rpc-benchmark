package com.unionpay.rpc.benchmark;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * date: 2016/10/19 10:25.
 * author: Yueqi Shi
 */
public abstract class AbstractTest {

    public static final CountDownLatch startLatch = new CountDownLatch(1);
    public static CountDownLatch endLatch;

    /**
     * 调用次数
     */
    private int callCount;

    /**
     * client端数量
     */
    private int clientNum;

    /**
     * rpc调用名称
     */
    private String rpcName;

    public AbstractTest(String rpcName, String[] args) {
        if(args == null || args.length < 2) {
            throw new IllegalArgumentException("Input paramters's size must be 2 : clientNum, perCount");
        }

        this.rpcName = rpcName;
        clientNum = Integer.parseInt(args[0]);
        callCount = Integer.parseInt(args[1]);
        endLatch = new CountDownLatch(clientNum);
    }

    public abstract void exec(CountDownLatch startLatch, CountDownLatch endLatch);

    public int getCallCount() {
        return callCount;
    }

    public int getClientNum() {
        return clientNum;
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(clientNum);
        for (int j = 0; j < clientNum; j++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    exec(AbstractTest.startLatch, AbstractTest.endLatch);
                }
            });
        }


        try {
            startLatch.countDown();
            long startTime = System.currentTimeMillis();

            endLatch.await();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println(rpcName + "--client num: " + clientNum + ", execute per client: " + callCount
                    + ", total execute:" + callCount * clientNum + ", total time: " + totalTime / 1000.0
                    + "s, tps:" + callCount * clientNum * 1000.0 / totalTime + ",   startTime: "
                    + startTime + ", endTime: " + endTime);

            executor.shutdown();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
