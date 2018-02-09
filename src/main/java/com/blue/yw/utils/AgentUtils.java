package com.blue.yw.utils;

import javax.servlet.http.HttpServletRequest;

public class AgentUtils {

    public static String getUserIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                ip = ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
