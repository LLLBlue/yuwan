package com.blue.yw.controller;

import com.blue.yw.model.VoteEntity;
import com.blue.yw.repository.VoteRepository;
import com.blue.yw.utils.AgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "vote")
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @RequestMapping(value = "vote")
    public String nomination(Model uiModel, HttpServletRequest request, HttpSession httpSession) {
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
        return "vote";
    }

    @RequestMapping(value = "voteSubmit")
    @ResponseBody
    public String voteSubmit(HttpServletRequest request) {
        return "时间未到";

//        String nominationId = request.getParameter("nominationId");
//        String userIp = AgentUtils.getUserIp(request);
//
//        List<VoteEntity> voteEntityList = voteRepository.findByState("1");
//        for (VoteEntity entity : voteEntityList) {
//            if (userIp.equals(entity.getUserIp())) {
//                return "每人只可投一票";
//            }
//        }
//
//        VoteEntity voteEntity = new VoteEntity();
//        voteEntity.setNominationId(Integer.parseInt(nominationId));
//        voteEntity.setUserIp(userIp);
//        voteEntity.setState("1");
//        voteEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
//        voteRepository.saveAndFlush(voteEntity);
//
//        return "成功";
    }
}
