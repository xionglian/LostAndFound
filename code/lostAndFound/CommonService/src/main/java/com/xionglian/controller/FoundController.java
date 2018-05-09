package com.xionglian.controller;

import com.google.gson.Gson;
import com.xionglian.common.response.ResMessage;
import com.xionglian.model.Found;
import com.xionglian.model.User;
import com.xionglian.service.FoundService;
import com.xionglian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by  xionglian on 2018-05-08.
 */
@RestController
@RequestMapping("/found")
public class FoundController {
    @Autowired
    private FoundService foundService;

    /**
     * 发布事务招领
     * @param found
     * @return
     */
    @RequestMapping(value = "add" ,method = RequestMethod.POST)
    public ResMessage add(@RequestBody Found found,HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            found.setReleaseUserId(((User)session.getAttribute("user")).getId());
            found.setCreateTime(new Date());
            found.setClickNum(0);
            if(foundService.add(found)>0){
                resMessage.setResult("success");
                resMessage.setData(found.toString());
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
     * 分页获取失物招领
     * @param request
     * @return
     */
    @RequestMapping(value = "getAll" ,method = RequestMethod.GET)
    public ResMessage getAll(HttpServletRequest request,HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            Integer currentPage = request.getParameter("currentPage") == null ? 1:Integer.parseInt(request.getParameter("currentPage"));
            Integer pageSize = request.getParameter("pageSize") == null ? 5:Integer.parseInt(request.getParameter("pageSize"));
            resMessage.setResult("success");
            resMessage.setData(foundService.getAll(currentPage,pageSize));
        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 修改状态
     * @param found
     * @return
     */
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public ResMessage update(@RequestBody Found found,HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            if(found.getState() == 2){
                found.setConfirmFoundUserId(((User)session.getAttribute("user")).getId());
                found.setCreateTime(new Date());
            }
            if(null == found.getId()){
                resMessage.setResult("fail");
                resMessage.setData("id不能为空");
            }else if(foundService.upateByPrimaryKey(found)>0){
                resMessage.setResult("success");

            }else{
                resMessage.setResult("fail");
                resMessage.setData("数据库修改失败");
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
