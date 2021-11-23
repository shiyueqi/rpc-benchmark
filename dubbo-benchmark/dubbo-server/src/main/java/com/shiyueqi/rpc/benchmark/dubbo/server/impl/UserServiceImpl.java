package com.shiyueqi.rpc.benchmark.dubbo.server.impl;

import com.shiyueqi.rpc.benchmark.dubbo.api.dto.UserDto;
import com.shiyueqi.rpc.benchmark.dubbo.api.service.UserService;
import com.shiyueqi.rpc.benchmark.dubbo.common.Users;

/**
 * date: 2016/10/21 17:57.
 * author: Yueqi Shi
 */
public class UserServiceImpl implements UserService{

    public UserDto getUser(long userId) {
        return Users.getUser(userId);
    }

    public String getUserName(long userId) {
        return Users.getUserName(userId);
    }
}
