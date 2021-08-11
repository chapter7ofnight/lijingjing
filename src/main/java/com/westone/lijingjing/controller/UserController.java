package com.westone.lijingjing.controller;

import com.westone.lijingjing.exception.LijingjingException;
import com.westone.lijingjing.model.HTTPResponse;
import com.westone.lijingjing.model.User;
import com.westone.lijingjing.model.UserLoginRequest;
import com.westone.lijingjing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public HTTPResponse<User> login(@RequestBody UserLoginRequest userLoginRequest) {
        HTTPResponse<User> response = new HTTPResponse<>();
        logger.info("user try to login|request={}", userLoginRequest);

        if (!StringUtils.hasLength(userLoginRequest.getUsername()) || !StringUtils.hasLength(userLoginRequest.getPassword())) {
            response.setSuccess(false);
            response.setMessage("username and password cannot be empty");
            return response;
        }

        try {
            User user = userService.login(userLoginRequest.getUsername(), userLoginRequest.getPassword());
            response.setSuccess(true);
            response.setMessage("login successfully");
            response.setData(user);
            logger.info("user login successfully|username={}", userLoginRequest.getUsername());
        } catch (LijingjingException e) {
            logger.warn("user login error|msg={}", e.getMessage());
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
