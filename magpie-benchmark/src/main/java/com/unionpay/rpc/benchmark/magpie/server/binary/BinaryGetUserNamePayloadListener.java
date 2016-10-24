package com.unionpay.rpc.benchmark.magpie.server.binary;

import com.unionpay.magpie.common.DcType;
import com.unionpay.magpie.server.AbstractServerPayloadListener;
import com.unionpay.rpc.benchmark.magpie.common.Users;

/**
 * date: 2016/10/20 11:01.
 * author: Yueqi Shi
 */
public class BinaryGetUserNamePayloadListener extends AbstractServerPayloadListener {

    @Override
    public byte[] handle(String serviceId, String serviceVersion, byte[] requestBytes, DcType sourceDc) {

        return Users.getUserName(Long.valueOf(new String(requestBytes))).getBytes();

    }
}
