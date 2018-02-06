package com.blue.yw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @RequestMapping(value = "home")
    public String nomination(Model uiModel, HttpServletRequest request) {
        String header = request.getHeader("user-agent");

        String ip = request.getHeader("X-Real-IP");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
//            ip = ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                ip = ip.substring(0, index);
            } else {
//            ip = ip;
            }
        } else {
            ip = request.getRemoteAddr();
        }

        System.out.println("user-agent: " + header);
        System.out.println("user-ip: " + ip);
        return "home";
    }
}
