package com.xionglian.controller;

import com.xionglian.common.response.ResMessage;
import com.xionglian.model.Lost;
import com.xionglian.model.User;
import com.xionglian.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by  xionglian on 2018-05-08.
 */
@RestController

@RequestMapping("/lost")
public class LostController {
    @Autowired
    private LostService lostService;

    /**
     * 发布寻物启事
     * @param lost
     * @return
     */
    @RequestMapping(value = "add" ,method = RequestMethod.POST)
    public ResMessage add(@RequestBody Lost lost,HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            User user = (User)session.getAttribute("user");
            if(null == user){
                resMessage.setResult("fail");
                resMessage.setData("用户未登录");
                return  resMessage;
            }
            lost.setReleaseUserId(user.getId());
            lost.setCreateTime(new Date());
            lost.setClickNum(0);
            if(lostService.add(lost)>0){
                resMessage.setResult("success");
                resMessage.setData(lost.getId());
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
     * 分页获取寻物启事
     * @param request
     * @return
     */
    @RequestMapping(value = "getAll" ,method = RequestMethod.GET)
    public ResMessage getAll(HttpServletRequest request, HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
                Integer currentPage = request.getParameter("currentPage") == null ? 1:Integer.parseInt(request.getParameter("currentPage"));
                Integer pageSize = request.getParameter("pageSize") == null ? 5:Integer.parseInt(request.getParameter("pageSize"));
                resMessage.setResult("success");
                HashMap map = new HashMap();
                map.put("count",lostService.countAll());
                map.put("lostList",lostService.getAllWithUser(currentPage,pageSize));
                resMessage.setData(map);
        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 分页获取寻物启事
     * @param request
     * @return
     */
    @RequestMapping(value = "getAllByUser" ,method = RequestMethod.GET)
    public ResMessage getAllByUser(HttpServletRequest request, HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            Integer currentPage = request.getParameter("currentPage") == null ? 1:Integer.parseInt(request.getParameter("currentPage"));
            Integer pageSize = request.getParameter("pageSize") == null ? 5:Integer.parseInt(request.getParameter("pageSize"));
            User user = (User)session.getAttribute("user");
            if(null == user){
                resMessage.setResult("fail");
                resMessage.setData("用户未登录");
                return  resMessage;
            }
            resMessage.setResult("success");
            HashMap map = new HashMap();
            map.put("count",lostService.countAll(user.getId()));
            map.put("lostList",lostService.getAllWithUser(currentPage,pageSize,user.getId()));
            resMessage.setData(map);
        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }
    /**
     * 修改状态
     * @param lost
     * @return
     */
    @RequestMapping(value = "update" ,method = RequestMethod.POST)
    public ResMessage update(@RequestBody Lost lost,HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            if(lost.getState() == 2){
                lost.setConfirmFoundUserId(((User)session.getAttribute("user")).getId());
                lost.setCreateTime(new Date());
            }
            if(null == lost.getId()){
                resMessage.setResult("fail");
                resMessage.setData("id不能为空");
            }else if(lostService.upateByPrimaryKey(lost)>0){
                resMessage.setResult("success");

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

}
