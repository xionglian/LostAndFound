package com.xionglian.service;


import com.google.gson.Gson;
import com.xionglian.model.User;

import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */

public interface UserService {
    /**
     * 用户名是否被注册过
     * @param username
     * @param role
     * @return
     */
    public boolean isRegistered(String username,Byte role);

    /**
     * 注册
     * @param user
     * @return
     */
    public int register(User user) throws Exception;

    /**
     *
     * @param loginName
     * @param password
     * @param role
     * @return userId -3用户名或密码错误 -2存在多个对应用户
     * @throws Exception
     */
    public User login(String loginName,String password,Byte role)throws Exception;

    public int logout(int userId);

    public long countAll();

    public List<User> selectAll(Integer currentPage, Integer pageSize);

    public int upateUserByPrimaryKey (User user)throws Exception;

}
