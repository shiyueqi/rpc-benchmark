package com.unionpay.rpc.benchmark.magpie.client;

import com.alibaba.fastjson.JSON;
import com.unionpay.magpie.bootstrap.MagpieBootStrap;
import com.unionpay.magpie.client.ServiceController;
import com.unionpay.magpie.client.ServiceRegistry;
import com.unionpay.magpie.common.Constants;
import com.unionpay.magpie.remoting.RemotingException;
import com.unionpay.rpc.benchmark.magpie.api.dto.UserDto;
import com.unionpay.rpc.benchmark.magpie.api.service.UserService;

/**
 * date: 2016/10/20 10:27.
 * author: Yueqi Shi
 */
public class MagpieClient {

    private static String configFile = System.getProperty(Constants.MAGPIE_CONFIG_FILE_KEY, "magpie_client.xml");
    private static final Long userId = 123L;

    public MagpieClient() {
        System.setProperty(Constants.WAIT_ALL_URLS_CONNECTED, "true");
        System.setProperty(Constants.MAGPIE_CONFIG_FILE_KEY, configFile);
        MagpieBootStrap.getBootStrap().start();
        System.getProperties().remove(Constants.MAGPIE_CONFIG_FILE_KEY);
    }

    /**
     * call rpc service getUser method
     * @param callCount
     */
    private void callRpcGetUser(int callCount) {
        UserService userService = ServiceRegistry.getService(UserService.class);
        UserDto userDto = null;

        for(int i = 0; i < callCount; i++) {
            userDto = userService.getUser(userId);
            //System.out.println(userDto.toString());
        }
    }

    /**
     * call rpc service getUserName method
     * @param callCount
     */
    private void callRpcGetUserName(int callCount) {
        UserService userService = ServiceRegistry.getService(UserService.class);
        String userName = "";

        for(int i = 0; i < callCount; i++) {
            userName = userService.getUserName(userId);
            //System.out.println(userName);
        }
    }

    /**
     * call binary service getUser method
     * @param callCount
     */
    private void callBinaryGetUser(int callCount) {
        ServiceController binaryGetUserService = ServiceRegistry.getService("get_user_binaryA");
        UserDto userDtoBinary = null;

        for(int i = 0; i < callCount; i++) {
            try {
                userDtoBinary = JSON.parseObject(binaryGetUserService.call(userId.toString().getBytes()), UserDto.class);
                //System.out.println(userDtoBinary.toString());
            } catch (RemotingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * call binary service getUserName method
     * @param callCount
     */
    private void callBinaryGetUserName(int callCount) {
        ServiceController binaryGetUserNameService = ServiceRegistry.getService("get_username_binaryA");
        String userNameBinary = "";

        for(int i = 0; i < callCount; i++) {
            try {
                userNameBinary = new String(binaryGetUserNameService.call(userId.toString().getBytes()));
                //System.out.println(userNameBinary);
            } catch (RemotingException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(int callCount, boolean isRpc, boolean isBinary, boolean isGetUser, boolean isGetUserName) {

        try {
            long startTime = System.currentTimeMillis();

            if (isRpc && isGetUser) {
                this.callRpcGetUser(callCount);
            }

            if (isRpc && isGetUserName) {
                this.callRpcGetUserName(callCount);
            }

            if (isBinary && isGetUser) {
                this.callBinaryGetUser(callCount);
            }

            if (isBinary && isGetUserName) {
                this.callBinaryGetUserName(callCount);
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("tps: " + callCount * 1000.0 / totalTime + ",   startTime: "
                    + startTime + ", endTime: " + endTime + ", total time: " + totalTime / 1000.0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MagpieBootStrap.getBootStrap().shutDown();
        }
    }
}
