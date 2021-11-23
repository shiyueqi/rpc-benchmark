package com.shiyueqi.rpc.benchmark.grpc.common;

import com.shiyueqi.rpc.benchmark.grpc.user.User;

import java.util.Random;

/**
 * date: 2016/10/19 11:37.
 * author: Yueqi Shi
 */
public class Users {
    public static final User DEFAULT_USER;

    static {
        DEFAULT_USER = User.newBuilder()
                .setUserId(new Random().nextInt(1000))
                .setUserName("testUserName")
                .setPhone("13012345678")
                .setEmail("testEmail@gmail.com")
                .setAddress("CHINA SHANGHAI")
                .setAge(25)
                .setGender(1)
                .setUserStatus(1)
                .setCreatedAt(System.currentTimeMillis())
                .setLastModified(System.currentTimeMillis())
                .build();
    }

    public static final String USER_NAME_PREFIX = "testUserName_";

    /**
     * grpc getUser
     * @param userId
     * @return default user, to avoid new to much objects
     */
    public static User getUser(long userId) {
        return DEFAULT_USER;
    }

    /**
     * grpc getUserName
     * @param userId
     * @return
     */
    public static String getUserName(long userId) {
        return USER_NAME_PREFIX + userId;
    }
}
