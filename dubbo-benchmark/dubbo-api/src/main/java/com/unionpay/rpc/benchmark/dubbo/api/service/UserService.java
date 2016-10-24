package com.unionpay.rpc.benchmark.dubbo.api.service;

import com.unionpay.rpc.benchmark.dubbo.api.dto.UserDto;

/**
 * date: 2016/10/21 17:55.
 * author: Yueqi Shi
 */
public interface UserService {

    public UserDto getUser(long userId);

    public String getUserName(long userId);
}
