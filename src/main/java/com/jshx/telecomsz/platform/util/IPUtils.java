package com.jshx.telecomsz.platform.util;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 14:56.
 *
 * @author 王金
 * @version 1.0
 */
public class IPUtils {

    public static boolean isInRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        if (ips.length < 4) {
            return true;
        }
        int ipAddr = (Integer.parseInt(ips[0]) << 24)
                | (Integer.parseInt(ips[1]) << 16)
                | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24)
                | (Integer.parseInt(cidrIps[1]) << 16)
                | (Integer.parseInt(cidrIps[2]) << 8)
                | Integer.parseInt(cidrIps[3]);

        return (ipAddr & mask) == (cidrIpAddr & mask);
    }

    public static boolean notInRange(String ip, String cidr) {
        return !isInRange(ip, cidr);
    }
}
