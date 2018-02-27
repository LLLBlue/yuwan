package com.blue.yw.controller;

import com.blue.yw.constants.Constants;
import com.blue.yw.model.NoticeResponse;
import com.blue.yw.model.SysConfigEntity;
import com.blue.yw.repository.SysConfigRepository;
import com.blue.yw.utils.AgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    SysConfigRepository sysConfigRepository;

    @RequestMapping(value = "home")
    public String nomination(Model uiModel, HttpServletRequest request, HttpSession httpSession) {
        String header = request.getHeader("user-agent");
        String ip = AgentUtils.getUserIp(request);

        Object sessionName = httpSession.getAttribute("userName");
        Object sessionId = httpSession.getAttribute("userId");
        if (null == sessionName) {
            uiModel.addAttribute("isLogin", "0");
            uiModel.addAttribute("userName", "");
            uiModel.addAttribute("userId", "");
        } else {
            uiModel.addAttribute("isLogin", "1");
            uiModel.addAttribute("userName", String.valueOf(sessionName));
            uiModel.addAttribute("userId", String.valueOf(sessionId));
        }

        System.out.println("user-agent: " + header);
        System.out.println("user-ip: " + ip);
        return "home";
    }

    @RequestMapping(value = "queryNotice")
    @ResponseBody
    public NoticeResponse queryNotice(HttpServletRequest request) {
        List<SysConfigEntity> sysConfigEntityList = sysConfigRepository.findByGuideKeyOrderBySortAsc(Constants.ConfigGuideKey.HOME_NOTICE);

        NoticeResponse response = new NoticeResponse();
        response.setSysConfigEntityList(sysConfigEntityList);
        return response;
    }
}
