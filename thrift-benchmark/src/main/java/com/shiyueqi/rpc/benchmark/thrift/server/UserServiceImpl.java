package com.shiyueqi.rpc.benchmark.thrift.server;

import com.shiyueqi.rpc.benchmark.thrift.common.Users;
import com.shiyueqi.rpc.benchmark.thrift.api.UserDto;
import com.shiyueqi.rpc.benchmark.thrift.api.UserService;
import org.apache.thrift.TException;

/**
 * date: 2016/10/21 11:59.
 * author: Yueqi Shi
 */
public class UserServiceImpl implements UserService.Iface {
    public UserDto getUser(long userId) throws TException {
        return Users.getUser(userId);
    }

    public String getUserName(long userId) throws TException {
        return Users.getUserName(userId);
    }
}
