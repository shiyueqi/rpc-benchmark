package com.unionpay.rpc.benchmark.magpie.api.service;

import com.unionpay.rpc.benchmark.magpie.api.dto.UserDto;

/**
 * date: 2016/10/20 10:26.
 * author: Yueqi Shi
 */
public interface UserService {

    public UserDto getUser(long userId);

    public String getUserName(long userId);
}
