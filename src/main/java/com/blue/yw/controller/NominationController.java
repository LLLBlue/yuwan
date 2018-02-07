package com.blue.yw.controller;

import com.blue.yw.model.NominationListEntity;
import com.blue.yw.model.NominationResponse;
import com.blue.yw.repository.NominationListRepository;
import com.blue.yw.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String nomination(Model uiModel, HttpServletRequest request) {
        String address = request.getRemoteAddr();
        System.out.println("user session: " + address);
        return "nomination";
    }

    @RequestMapping(value = "nominateSubmit")
    @ResponseBody
    public String nominateSubmit(HttpServletRequest request) {
        String shortName = request.getParameter("shortName");
        String userName = request.getParameter("userName");
        String userIp = request.getRemoteAddr();

        NominationListEntity nominationListEntity = new NominationListEntity();
        nominationListEntity.setShortName(shortName);
        nominationListEntity.setUserName(userName);
        nominationListEntity.setUserIp(userIp);
        nominationListEntity.setState("1");
        nominationListEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        nominationListRepository.saveAndFlush(nominationListEntity);

        return "成功";
    }

    @RequestMapping(value = "queryNomination")
    @ResponseBody
    public NominationResponse queryNomination(HttpServletRequest request) {
        List<NominationListEntity> nominationList = nominationListRepository.findByState("1");

        for (NominationListEntity entity : nominationList) {
            Long votes = voteRepository.countByNominationId(entity.getNominationId());
            entity.setState(String.valueOf(votes));
        }

        NominationResponse response = new NominationResponse();
        response.setNominationList(nominationList);

        return response;
    }
}
