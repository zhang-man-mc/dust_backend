package com.flightfeather.monitor.controller;

import com.flightfeather.monitor.pojo.LoginUser;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dust")
@CrossOrigin
@RestController
@Slf4j
public class LoginController {
    //依赖业务层对象
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginUser loginUser) {
        //调用业务层：登录功能
        LoginUser login = loginService.login(loginUser);

        //判断：登录用户是否存在
        if(login !=null ){

            return Result.success(login.getUiRealName());
        }
        return Result.error("用户名或密码错误");
    }
}