package com.blue.yw.controller;

import com.blue.yw.model.SysConfigEntity;
import com.blue.yw.model.SysConfigResponse;
import com.blue.yw.repository.SysConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ConfigController
 *
 * @author Nozomi
 * @date 4/23/2018
 */
@Controller
@RequestMapping(value = "config")
public class ConfigController {

    @Autowired
    SysConfigRepository sysConfigRepository;

    @RequestMapping(value = "config")
    public String nomination(Model uiModel, HttpServletRequest request, HttpSession httpSession) {
        return "config";
    }

    @RequestMapping(value = "queryConfig")
    @ResponseBody
    public SysConfigResponse queryNomination(HttpServletRequest request) {
        List<SysConfigEntity> configEntityList = sysConfigRepository.findAll();

        SysConfigResponse response = new SysConfigResponse();
        response.setConfigEntityList(configEntityList);

        return response;
    }

    @RequestMapping(value = "configSubmit")
    @ResponseBody
    public String configSubmit(HttpServletRequest request) {
        String nominationSwitch = request.getParameter("nominationSwitch");
        String voteSwitch = request.getParameter("voteSwitch");
        String nominationTitle = request.getParameter("nominationTitle");
        String voteTitle = request.getParameter("voteTitle");

        SysConfigEntity nominationSwitchEntity = sysConfigRepository.findByConfigId(1);
        nominationSwitchEntity.setParamValue(nominationSwitch);
        sysConfigRepository.saveAndFlush(nominationSwitchEntity);

        SysConfigEntity voteSwitchEntity = sysConfigRepository.findByConfigId(2);
        voteSwitchEntity.setParamValue(voteSwitch);
        sysConfigRepository.saveAndFlush(voteSwitchEntity);

        SysConfigEntity nominationTitleEntity = sysConfigRepository.findByConfigId(4);
        nominationTitleEntity.setParamValue(nominationTitle);
        sysConfigRepository.saveAndFlush(nominationTitleEntity);

        SysConfigEntity voteTitleEntity = sysConfigRepository.findByConfigId(5);
        voteTitleEntity.setParamValue(voteTitle);
        sysConfigRepository.saveAndFlush(voteTitleEntity);

        return "SUCCESS";
    }
}
