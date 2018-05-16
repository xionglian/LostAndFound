package com.xionglian.controller;

import com.xionglian.common.response.ResMessage;
import com.xionglian.mapper.PushMessageMapper;
import com.xionglian.model.ThanksLetter;
import com.xionglian.model.User;
import com.xionglian.service.PushMessageService;
import com.xionglian.service.ThanksLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by  xionglian on 2018-05-08.
 */
@RestController

@RequestMapping("/pushMessage")
public class PushMessageController {
    @Autowired
    private PushMessageService pushMessageService ;


    /**
     * 分页获取感谢信
     * @param
     * @return
     */
    @RequestMapping(value = "getAll" ,method = RequestMethod.GET)
    public ResMessage getAll( HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            User user = (User)session.getAttribute("user");
            if(null == user){
                resMessage.setResult("fail");
                resMessage.setData("用户未登录");
                return  resMessage;
            }
            resMessage.setResult("success");
            resMessage.setData(pushMessageService.getAll(session));
        } catch (Exception e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }


}
