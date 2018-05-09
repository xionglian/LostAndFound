package com.xionglian.service;


import com.xionglian.model.PushMessage;
import com.xionglian.model.ThanksLetter;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */

public interface PushMessageService {
    /**
     * 根据用户id获取推荐信息
     * @param session
     * @return
     */
    public List<PushMessage> getAll(HttpSession session);
    /**
     * 根据用户id获取推荐信息
     * @param userId
     * @return
     */
    public List<PushMessage> getAll(Integer userId);




}
