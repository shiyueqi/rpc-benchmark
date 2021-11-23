package com.shiyueqi.rpc.benchmark.dubbo.client;

import com.shiyueqi.rpc.benchmark.dubbo.api.dto.UserDto;
import com.shiyueqi.rpc.benchmark.dubbo.api.service.UserService;
import com.shiyueqi.rpc.benchmark.dubbo.common.DubboTest;

/**
 * date: 2016/10/21 17:54.
 * author: Yueqi Shi
 */
public class DubboClient {
    private static UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private void callGetUser(int callCount) {
        UserDto userDto = null;
        Long userId = 123L;

        for(int i = 0; i < callCount; i++) {
            try {
                userDto = userService.getUser(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void callGetUserName(int callCount) {
        String userName = "";
        Long userId = 123L;

        for(int i = 0; i < callCount; i++) {
            try {
                userName = userService.getUserName(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        try {

            long startTime = System.currentTimeMillis();

            if (DubboTest.isGetUser) {
                this.callGetUser(DubboTest.callCount);
            }

            if (DubboTest.isGetUserName) {
                this.callGetUserName(DubboTest.callCount);
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("tps: " + DubboTest.callCount * 1000.0 / totalTime + ",   startTime: "
                    + startTime + ", endTime: " + endTime + ", total time: " + totalTime / 1000.0);

            DubboTest.endLatch.countDown();

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
