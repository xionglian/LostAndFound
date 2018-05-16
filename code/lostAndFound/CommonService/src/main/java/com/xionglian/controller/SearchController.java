package com.xionglian.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.google.gson.Gson;
import com.xionglian.common.response.ResMessage;
import com.xionglian.model.Found;
import com.xionglian.model.User;
import com.xionglian.service.FoundService;
import com.xionglian.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */
@RestController

public class SearchController {
    @Autowired
    private FoundService foundService;
    @Autowired
    private LostService lostService;

    /**
     * 发布事务招领
     * @param
     * @return
     */

    @RequestMapping(value = "/search" ,method = RequestMethod.GET)
    public ResMessage add(HttpServletRequest request,HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            String keyword = request.getParameter("keyword");//为空不查找
            String address = request.getParameter("address");//为空查询所有校区
            String type = request.getParameter("type");//1--查找lost 2--查找found 3--查找lost+found
            List found = foundService.getByCondition(address,keyword);
            List lost = lostService.getByCondition(address,keyword);
            HashMap map = new HashMap();
            map.put("foundList",found);
            map.put("lostList",lost);
            resMessage.setResult("success");
            resMessage.setData(map);

        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e.getStackTrace());
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }


}
