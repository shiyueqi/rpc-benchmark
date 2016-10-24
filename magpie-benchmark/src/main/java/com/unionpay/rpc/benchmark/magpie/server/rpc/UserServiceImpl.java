package com.unionpay.rpc.benchmark.magpie.server.rpc;

import com.unionpay.rpc.benchmark.magpie.api.dto.UserDto;
import com.unionpay.rpc.benchmark.magpie.api.service.UserService;
import com.unionpay.rpc.benchmark.magpie.common.Users;

/**
 * date: 2016/10/20 10:31.
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
