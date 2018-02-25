package com.blue.yw.controller;

import com.blue.yw.constants.Constants;
import com.blue.yw.model.NominationListEntity;
import com.blue.yw.model.NominationResponse;
import com.blue.yw.model.VoteEntity;
import com.blue.yw.model.VoteResponse;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "vote")
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    NominationListRepository nominationListRepository;

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

    @RequestMapping(value = "queryNomination")
    @ResponseBody
    public NominationResponse queryNomination(HttpServletRequest request) {
        List<NominationListEntity> nominationList = nominationListRepository.findByStateOrderByVoteCountDesc("1");

        NominationResponse response = new NominationResponse();
        response.setNominationList(nominationList);

        return response;
    }

    @RequestMapping(value = "queryVoteState")
    @ResponseBody
    public VoteResponse queryVoteState(HttpServletRequest request, HttpSession httpSession) {
        VoteResponse response = new VoteResponse();

        String nominationId = request.getParameter("nominationId");

        Object sessionName = httpSession.getAttribute("userName");
        Object sessionId = httpSession.getAttribute("userId");
        if (null == sessionName) {
            response.setVoteState(Constants.LOGIN_ERROR);
            return response;
        }

        List<VoteEntity> voteList = new ArrayList<>();
        List<VoteEntity> voteEntityList = voteRepository.findByState("1");
        for (VoteEntity entity : voteEntityList) {
            if (sessionName.equals(entity.getUserName()) || sessionId.equals(entity.getUserId())) {
                for (VoteEntity ey : voteEntityList) {
                    if (ey.getNominationId() == Integer.parseInt(nominationId)) {
                        voteList.add(ey);
                    }
                }
                response.setVoteList(voteList);
                response.setVoteState(Constants.VoteResultCode.VOTE);
                return response;
            }
        }

        response.setVoteState(Constants.VoteResultCode.NO_VOTE);
        return response;
    }

    @RequestMapping(value = "voteSubmit")
    @ResponseBody
    public String voteSubmit(HttpServletRequest request, HttpSession httpSession) {
        return "投票时间未到或已截止";

//        String nominationId = request.getParameter("nominationId");
//        String userIp = AgentUtils.getUserIp(request);
//
//        Object sessionName = httpSession.getAttribute("userName");
//        Object sessionId = httpSession.getAttribute("userId");
//        if (null == sessionName) {
//            return "登录状态失效，请重新登录";
//        }
//
//        List<VoteEntity> voteEntityList = voteRepository.findByState("1");
//        for (VoteEntity entity : voteEntityList) {
//            if (sessionName.equals(entity.getUserName()) || sessionId.equals(entity.getUserId())) {
//                return "每人只可投一票";
//            }
//        }
//
//        VoteEntity voteEntity = new VoteEntity();
//        voteEntity.setNominationId(Integer.parseInt(nominationId));
//        voteEntity.setUserIp(userIp);
//        voteEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
//        voteEntity.setState("1");
//        voteEntity.setUserName(String.valueOf(sessionName));
//        voteEntity.setUserId(Integer.parseInt(sessionId.toString()));
//        voteRepository.saveAndFlush(voteEntity);
//
//        Long voteCount = voteRepository.countByNominationId(Integer.parseInt(nominationId));
//        NominationListEntity nominationListEntity = nominationListRepository.findByNominationId(Integer.parseInt(nominationId));
//        nominationListEntity.setVoteCount(String.valueOf(voteCount));
//        nominationListRepository.saveAndFlush(nominationListEntity);
//        return "成功";
    }
}
