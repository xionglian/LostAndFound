package com.xionglian.Service;

import com.xionglian.Entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by  xionglian on 2018-04-23.
 */
public interface UserService {
    public UserEntity login(HttpServletRequest loginReq);
}
