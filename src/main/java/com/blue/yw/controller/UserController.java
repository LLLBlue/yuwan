package com.blue.yw.controller;

import com.blue.yw.constants.Constants;
import com.blue.yw.model.UserEntity;
import com.blue.yw.repository.UserRepository;
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
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "user")
    public String user(Model uiModel, HttpServletRequest request) {
        return "user";
    }

    @RequestMapping(value = "signUpAndSignIn")
    @ResponseBody
    public String signUpAndSignIn(HttpServletRequest request, HttpSession httpSession) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        List<UserEntity> userList = userRepository.findAll();
        for (UserEntity entity : userList) {
            if (entity.getUserName().equalsIgnoreCase(userName)) {
                if (entity.getUserPassword().equals(password)) {
                    entity.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
                    userRepository.saveAndFlush(entity);
                    httpSession.setAttribute("userName", entity.getUserName());
                    httpSession.setAttribute("userId", entity.getUserId());
                    return Constants.UserResultCode.SUCCESS;
                } else {
                    return Constants.UserResultCode.PASSWORD_ERROR;
                }
            }
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setUserPassword(password);
        userEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        userEntity.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
        userEntity.setCreateIp(AgentUtils.getUserIp(request));
        userEntity = userRepository.saveAndFlush(userEntity);
        httpSession.setAttribute("userName", userEntity.getUserName());
        httpSession.setAttribute("userId", userEntity.getUserId());
        return Constants.UserResultCode.SUCCESS;
    }

    @RequestMapping(value = "logOut")
    @ResponseBody
    public String logOut(HttpServletRequest request, HttpSession httpSession) {
        httpSession.invalidate();
        return "成功";
    }
}
