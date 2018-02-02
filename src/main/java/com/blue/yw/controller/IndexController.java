package com.blue.yw.controller;

import com.blue.yw.model.NominationVO;
import com.blue.yw.utils.SQLUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "article")
public class IndexController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String indexPage(Model uiModel, HttpServletRequest request) {
        String address = request.getRemoteAddr();
        System.out.println("user session: " + address);
        uiModel.addAttribute("yw", "MVC Controller Test");
        uiModel.addAttribute("address", address);
        return "indexPage";
    }

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
        System.out.println("shortName: " + shortName);
        System.out.println("userName: " + userName);

        NominationVO nominationVO = new NominationVO();
        nominationVO.setShortName(shortName);
        nominationVO.setUserName(userName);

        SQLUtils.insertNomination(nominationVO);
        return "SUCCESS";
    }

    @RequestMapping(value = "queryNomination")
    @ResponseBody
    public String queryNomination(HttpServletRequest request) {
        List<NominationVO> nominationVOList = SQLUtils.queryNomination();
        StringBuilder res = new StringBuilder();
        for (NominationVO vo : nominationVOList) {
            res.append(vo.getShortName()).append(" ").append(vo.getUserName()).append("\n");
        }
        return res.toString();
    }
}
