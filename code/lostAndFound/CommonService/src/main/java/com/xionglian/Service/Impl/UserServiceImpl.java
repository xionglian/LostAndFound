package com.xionglian.service.impl;


import com.google.gson.Gson;
import com.xionglian.common.util.Md5;
import com.xionglian.mapper.UserMapper;
import com.xionglian.model.User;
import com.xionglian.model.UserExample;
import com.xionglian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private String loginName;

    @Override
    public boolean isRegistered(String username, Byte role) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(username)
                .andRoleEqualTo(role);
        List list =  userMapper.selectByExample(userExample);
        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public int register(User user) throws Exception {
        String orginalPassword = user.getPassword();
        user.setPassword(Md5.getMD5Str(orginalPassword));
        return userMapper.insertSelective(user);
    }

    /**
     *
     * @param loginName
     * @param password
     * @param role
     * @return
     * @throws Exception
     */
    @Override
    public User login(String loginName, String password, Byte role) throws Exception{
        password = Md5.getMD5Str(password);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPasswordEqualTo(password)
                .andRoleEqualTo(role).andLoginNameEqualTo(loginName);
        List<User> list = userMapper.selectByExample(userExample);
        if(list.isEmpty()||list.size()>1)
            return null;
        User u = list.get(0);
        u.setIsLogin(true);
        userMapper.updateByPrimaryKeySelective(u);
        return u;
    }

    @Override
    public int logout(int userId) {
        User u = new User();
        u.setId(userId);
        u.setIsLogin(false);
        userMapper.updateByPrimaryKeySelective(u);
        return 0;
    }

    @Override
    public List<User> selectAll() {
        UserExample u = new UserExample();
        return userMapper.selectByExample(u);
    }

    @Override
    public int upateUserByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


}
