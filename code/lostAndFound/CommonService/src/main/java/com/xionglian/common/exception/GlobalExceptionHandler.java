package com.xionglian.common.exception;

import com.xionglian.common.enums.ResCodeEnum;
import com.xionglian.common.response.ResMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by lenovo on 2018/4/11.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler
{
    //对于未考虑到的异常的捕获
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResMessage handleBizExp(HttpServletRequest request, Exception ex){
        ResMessage resMessage = new ResMessage();
//        resMessage.setErrCode(ResCodeEnum.ERROR99.getCode());
//        resMessage.setErrMsg(ResCodeEnum.ERROR99.getDesc()+ex.getMessage());
        log.info("exception handler:{}",ex.getStackTrace());
        return  resMessage;
    }
}
