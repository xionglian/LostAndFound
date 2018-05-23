package com.xionglian.controller;

import com.google.gson.Gson;
import com.xionglian.common.response.ResMessage;
import com.xionglian.model.User;
import com.xionglian.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by  xionglian on 2018-05-08.
 */
@Slf4j
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
        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "register" ,method = RequestMethod.POST)
    public ResMessage register(@RequestBody User user){
        ResMessage resMessage = new ResMessage();
        try {
            log.info("===============请求内容==============="+user);
            if(null ==user.getLoginName()||null ==user.getRole()||null == user.getPassword()){
                resMessage.setResult("fail");
                resMessage.setData("请求缺少必要参数");
                return resMessage;
            }
            int returncode = userService.register(user);
            if(returncode>0){
                resMessage.setResult("success");
                resMessage.setData(true);
            }else if(returncode == -2){
                resMessage.setResult("fail");
                resMessage.setData("用户名已被注册");
            }else{
                resMessage.setResult("fail");
                resMessage.setData("数据库修改失败");
            }

        } catch (Exception e) {
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

        } catch (Exception e) {
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

        } catch (Exception e) {
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

        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 查询所有用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "getAll" ,method = RequestMethod.GET)
    public ResMessage getAll(HttpServletRequest request){
        ResMessage resMessage = new ResMessage();
        try {
            Integer currentPage = request.getParameter("currentPage") == null ? 1:Integer.parseInt(request.getParameter("currentPage"));
            Integer pageSize = request.getParameter("pageSize") == null ? 5:Integer.parseInt(request.getParameter("pageSize"));
           resMessage.setResult("success");
            HashMap map = new HashMap();
            map.put("count",userService.countAll());
            map.put("foundList",userService.selectAll(currentPage,pageSize));
            resMessage.setData(map);
        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
}
