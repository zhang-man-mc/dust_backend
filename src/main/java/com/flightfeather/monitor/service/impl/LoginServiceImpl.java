package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.mapper.LoginMapper;
import com.flightfeather.monitor.pojo.LoginUser;
import com.flightfeather.monitor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public LoginUser login(LoginUser loginUser) {
        LoginUser login = loginMapper.getByUsernameAndPassword(loginUser);
        return login;
    }
}
