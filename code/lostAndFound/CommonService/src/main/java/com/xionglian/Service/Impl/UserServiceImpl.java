package com.xionglian.Service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xionglian.Entity.UserEntity;
import com.xionglian.Service.UserService;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by  xionglian on 2018-04-25.
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{

    @Override
    public UserEntity login(HttpServletRequest loginReq) {
        return null;
    }
}
