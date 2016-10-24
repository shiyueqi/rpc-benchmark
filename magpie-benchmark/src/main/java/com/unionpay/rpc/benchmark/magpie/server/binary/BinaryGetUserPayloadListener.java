package com.unionpay.rpc.benchmark.magpie.server.binary;

import com.alibaba.fastjson.JSON;
import com.unionpay.magpie.common.DcType;
import com.unionpay.magpie.server.AbstractServerPayloadListener;
import com.unionpay.rpc.benchmark.magpie.common.Users;

public class BinaryGetUserPayloadListener extends AbstractServerPayloadListener {

    @Override
    public byte[] handle(String serviceId, String serviceVersion, byte[] requestBytes, DcType sourceDc) {

        return JSON.toJSONBytes(Users.getUser(Long.valueOf(new String(requestBytes))));
    }
}
