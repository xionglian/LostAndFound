package com.xionglian.controller;

import com.xionglian.common.response.ResMessage;
import com.xionglian.model.Found;
import com.xionglian.model.ThanksLetter;
import com.xionglian.model.User;
import com.xionglian.service.FoundService;
import com.xionglian.service.ThanksLetterService;
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
@RequestMapping("/thanks")
public class ThanksLetterController {
    @Autowired
    private ThanksLetterService thanksLetterService ;

    /**
     * 新增感谢信
     * @param thanksLetter
     * @return
     */
    @RequestMapping(value = "add" ,method = RequestMethod.POST)
    public ResMessage add(@RequestBody ThanksLetter thanksLetter, HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {

            if(thanksLetterService.add(thanksLetter,session)>0){
                resMessage.setResult("success");
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
     * 分页获取感谢信
     * @param request
     * @return
     */
    @RequestMapping(value = "getAll" ,method = RequestMethod.POST)
    public ResMessage getAll(HttpServletRequest request, HttpSession session){
        ResMessage resMessage = new ResMessage();
        try {
            Integer currentPage = request.getParameter("currentPage") == null ? 1:Integer.parseInt(request.getParameter("currentPage"));
            Integer pageSize = request.getParameter("pageSize") == null ? 5:Integer.parseInt(request.getParameter("pageSize"));
            resMessage.setResult("success");
            resMessage.setData(thanksLetterService.selectAll(currentPage,pageSize));
        } catch (NumberFormatException e) {
            resMessage.setResult("fail");
            resMessage.setData(e);
            e.printStackTrace();
        }finally {
            return resMessage;
        }
    }


}
