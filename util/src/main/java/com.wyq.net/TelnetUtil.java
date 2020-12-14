package com.wyq.net;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 王艳群
 * @description TelnetUtil
 * @date 2020/8/5
 */
public class TelnetUtil {

    protected static final Logger LOG = LoggerFactory.getLogger(TelnetUtil.class);

    private static Pattern JDBC_PATTERN = Pattern.compile("(?<host>[^:@/]+):(?<port>\\d+).*");
    private static final String HOST_KEY = "host";
    private static final String PORT_KEY = "port";
    private static final String SPLIT_KEY = ",";

    public static void main(String[] args) {
        // telnet("192.168.22.22", 80);
        telnet("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
    }

    public static void telnet(String ip, int port) {
        TelnetClient client = null;
        try {
            client = new TelnetClient();
            client.setConnectTimeout(3000);
            client.connect(ip, port);
        } catch (Exception e) {
            throw new RuntimeException("Unable connect to : " + ip + ":" + port);
        } finally {
            try {
                if (client != null) {
                    client.disconnect();
                }
            } catch (Exception ignore) {
            }
        }
    }

    public static void telnet(String url) {
        if (url == null || url.trim().length() == 0) {
            throw new IllegalArgumentException("url can not be null");
        }

        String host = null;
        int port = 0;

        Matcher matcher = JDBC_PATTERN.matcher(url);
        if (matcher.find()) {
            host = matcher.group(HOST_KEY);
            port = Integer.parseInt(matcher.group(PORT_KEY));
        }

        if (host == null || port == 0) {
            //oracle高可用jdbc url此处获取不到IP端口，直接return。
            return;
        }

        if (host.contains(SPLIT_KEY)) {
            String[] hosts = host.split(SPLIT_KEY);
            for (String s : hosts) {
                if (StringUtils.isNotBlank(s)) {
                    telnet(s, port);
                }
            }
        } else {
            telnet(host, port);
        }
    }
}