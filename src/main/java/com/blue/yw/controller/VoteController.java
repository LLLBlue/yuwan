package com.blue.yw.controller;

import com.blue.yw.model.VoteEntity;
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
@RequestMapping(value = "vote")
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @RequestMapping(value = "vote")
    public String nomination(Model uiModel, HttpServletRequest request) {
        return "vote";
    }

    @RequestMapping(value = "voteSubmit")
    @ResponseBody
    public String voteSubmit(HttpServletRequest request) {
        String nominationId = request.getParameter("nominationId");
        String userIp = request.getRemoteAddr();

        List<VoteEntity> voteEntityList = voteRepository.findByState("1");
        for (VoteEntity entity : voteEntityList) {
            if (userIp.equals(entity.getUserIp())) {
                return "每人只可投一票";
            }
        }

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setNominationId(Integer.parseInt(nominationId));
        voteEntity.setUserIp(userIp);
        voteEntity.setState("1");
        voteEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        voteRepository.saveAndFlush(voteEntity);

        return "成功";
    }
}
