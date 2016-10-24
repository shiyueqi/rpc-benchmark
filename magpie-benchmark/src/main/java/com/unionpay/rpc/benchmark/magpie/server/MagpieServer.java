package com.unionpay.rpc.benchmark.magpie.server;

import com.unionpay.magpie.bootstrap.MagpieBootStrap;
import com.unionpay.magpie.common.Constants;

/**
 * date: 2016/10/20 10:27.
 * author: Yueqi Shi
 */
public class MagpieServer {

    private static String configFile = System.getProperty(Constants.MAGPIE_CONFIG_FILE_KEY, "magpie_server.xml");

    public static void main(String[] args) {
        System.setProperty(Constants.MAGPIE_CONFIG_FILE_KEY, configFile);
        MagpieBootStrap.getBootStrap().start();
        System.getProperties().remove(Constants.MAGPIE_CONFIG_FILE_KEY);
    }
}
