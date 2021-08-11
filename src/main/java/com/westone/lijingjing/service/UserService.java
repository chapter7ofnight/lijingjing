package com.westone.lijingjing.service;

import com.westone.lijingjing.dao.UserDao;
import com.westone.lijingjing.exception.EmptyParamException;
import com.westone.lijingjing.exception.LijingjingException;
import com.westone.lijingjing.exception.PasswordErrorException;
import com.westone.lijingjing.exception.UserNotFoundException;
import com.westone.lijingjing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User login(String username, String password) throws LijingjingException {
        if (!StringUtils.hasLength(username)) {
            throw new EmptyParamException("username cannot be empty");
        }
        if (!StringUtils.hasLength(password)) {
            throw new EmptyParamException("password cannot be empty");
        }

        User user = userDao.selectUser(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }

        String encryptPassword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (encryptPassword.equals(user.getPassword())) {
            user.setPassword(null);
            return user;
        } else {
            throw new PasswordErrorException(username);
        }
    }
}
