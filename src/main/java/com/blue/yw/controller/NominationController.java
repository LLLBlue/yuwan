package com.blue.yw.controller;

import com.blue.yw.model.NominationListEntity;
import com.blue.yw.model.NominationResponse;
import com.blue.yw.repository.NominationListRepository;
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
@RequestMapping(value = "nomination")
public class NominationController {

    @Autowired
    NominationListRepository nominationListRepository;

    @Autowired
    VoteRepository voteRepository;

    @RequestMapping(value = "nomination")
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
        return "nomination";
    }

    @RequestMapping(value = "nominateSubmit")
    @ResponseBody
    public String nominateSubmit(HttpServletRequest request, HttpSession httpSession) {
        return "提名时间未到或已截止";

//        String shortName = request.getParameter("shortName");
//        String userIp = AgentUtils.getUserIp(request);
//
//        Object sessionName = httpSession.getAttribute("userName");
//        Object sessionId = httpSession.getAttribute("userId");
//        if (null == sessionName) {
//            return "登录状态失效，请重新登录";
//        }
//
//        NominationListEntity nominationListEntity = new NominationListEntity();
//        nominationListEntity.setShortName(shortName);
//        nominationListEntity.setUserName(String.valueOf(sessionName));
//        nominationListEntity.setUserIp(userIp);
//        nominationListEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
//        nominationListEntity.setState("1");
//        nominationListEntity.setVoteCount("0");
//        nominationListEntity.setUserId(Integer.parseInt(sessionId.toString()));
//        nominationListRepository.saveAndFlush(nominationListEntity);
//
//        return "成功";
    }

    @RequestMapping(value = "queryNomination")
    @ResponseBody
    public NominationResponse queryNomination(HttpServletRequest request) {
        List<NominationListEntity> nominationList = nominationListRepository.findByState("1");

        NominationResponse response = new NominationResponse();
        response.setNominationList(nominationList);

        return response;
    }
}
