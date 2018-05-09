package com.xionglian.controller;

import com.google.gson.Gson;
import com.xionglian.common.response.ResMessage;
import com.xionglian.model.User;
import com.xionglian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by  xionglian on 2018-05-08.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户名是否被注册
     * @param request
     * @return
     */
    @RequestMapping(value = "isRegistered" ,method = RequestMethod.GET)
    public ResMessage isRegistered(HttpServletRequest request){
        ResMessage resMessage = new ResMessage();
        try {
            String username = request.getParameter("loginName");
            Byte role = null == request.getParameter("role")?0:Byte.parseByte(request.getParameter("role"));
            boolean result = userService.isRegistered(username,role);
            resMessage.setResult("success");
            resMessage.setData(result);
        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 注册
     * @param request
     * @return
     */
    @RequestMapping(value = "register" ,method = RequestMethod.POST)
    public ResMessage register(@RequestBody String request){
        ResMessage resMessage = new ResMessage();
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(request, User.class);
            if(userService.register(user)>0){
                resMessage.setResult("success");
                resMessage.setData(true);
            }else{
                resMessage.setResult("success");
                resMessage.setData(false);
            }

        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 登录
     * @param request
     * @return
     */
    @RequestMapping(value = "login" ,method = RequestMethod.GET)
    public ResMessage login(HttpServletRequest request, HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            String loginName = request.getParameter("loginName");
            String password = request.getParameter("password");
            Byte role = null == request.getParameter("role")?0:Byte.parseByte(request.getParameter("role"));
            User user = userService.login(loginName,password,role);
            if(null == user){
                resMessage.setResult("fail");
                resMessage.setData("用户名或密码不正确");
            }else{
                session.setAttribute("user",user);
                resMessage.setResult("success");
                resMessage.setData(user);
            }

        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 注销
     * @param
     * @return
     */
    @RequestMapping(value = "logout" ,method = RequestMethod.GET)
    public ResMessage logout(HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            User user = (User)session.getAttribute("user");
            if(null == user){
                resMessage.setResult("fail");
                resMessage.setData("用户未登录");
            }else if(userService.logout(user.getId())>0){
                session.removeAttribute("user");
                resMessage.setResult("success");
                resMessage.setData(user);
            }else{
                resMessage.setResult("fail");
                resMessage.setData("注销失败");
            }

        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "updateUser" ,method = RequestMethod.POST)
    public ResMessage update(@RequestBody User record){
        ResMessage resMessage = new ResMessage();
        try {
            if(userService.upateUserByPrimaryKey(record)>0){
                resMessage.setResult("success");
            }else{
                resMessage.setResult("fail");
                resMessage.setData("修改失败");
            }

        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
}
