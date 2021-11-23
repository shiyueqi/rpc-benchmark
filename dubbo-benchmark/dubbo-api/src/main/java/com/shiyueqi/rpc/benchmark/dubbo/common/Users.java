package com.shiyueqi.rpc.benchmark.dubbo.common;

import com.shiyueqi.rpc.benchmark.dubbo.api.dto.UserDto;

import java.util.Random;

/**
 * date: 2016/10/21 17:53.
 * author: Yueqi Shi
 */
public class Users {
    public static final UserDto DEFAULT_USER;

    static {
        DEFAULT_USER = new UserDto();
        DEFAULT_USER.setUserId(new Random().nextInt(1000));
        DEFAULT_USER.setUserName("testUserName");
        DEFAULT_USER.setPhone("13012345678");
        DEFAULT_USER.setEmail("testEmail@gmail.com");
        DEFAULT_USER.setAddress("CHINA SHANGHAI");
        DEFAULT_USER.setAge(25);
        DEFAULT_USER.setGender(1);
        DEFAULT_USER.setUserStatus(1);
        DEFAULT_USER.setCreatedAt(System.currentTimeMillis());
        DEFAULT_USER.setLastModified(System.currentTimeMillis());
    }

    public static final String USER_NAME_PREFIX = "testUserName_";

    /**
     * magpie getUser
     * @param userId
     * @return default user, to avoid new to much objects
     */
    public static UserDto getUser(long userId) {
        return DEFAULT_USER;
    }

    /**
     * magpie getUserName
     * @param userId
     * @return
     */
    public static String getUserName(long userId) {
        return USER_NAME_PREFIX + userId;
    }
}
