package com.setup;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by
 */
public class GetIp {

    public String getIP() {
        InetAddress ip;
        String result = null;
        try {
            ip = InetAddress.getLocalHost();
            result = ip.getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return result;
    }
}
