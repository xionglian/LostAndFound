package com.xionglian.aop;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * Created by lenovo on 2018/3/31.
 * 可以自定义切面日志
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class LogAspect
{
    private Gson gson = new Gson();
    @Pointcut("execution(public * com.xionglian.controller.*.*(..))")
    public void CutPoint() {
    }
    @Before(value = "CutPoint()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("===============请求内容===============");
        log.info("请求地址:"+request.getRequestURL().toString());
        log.info("请求方式:"+request.getMethod());
        log.info("请求类方法:"+joinPoint.getSignature());
        log.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        log.info("===============请求内容===============");
    }
    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o",pointcut = "CutPoint()")
    public void methodAfterReturing(Object o ){
        log.info("--------------返回内容----------------");
        log.info("Response内容:"+gson.toJson(o));
        log.info("--------------返回内容----------------");
    }
}
