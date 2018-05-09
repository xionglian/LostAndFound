package com.xionglian.service.impl;

import com.xionglian.mapper.PushMessageMapper;
import com.xionglian.model.PushMessage;
import com.xionglian.model.PushMessageExample;
import com.xionglian.model.User;
import com.xionglian.service.PushMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by  xionglian on 2018-05-09.
 */
@Service
public class PushMessageServiceImpl implements PushMessageService {
    @Autowired
    private PushMessageMapper pushMessageMapper;
    /**
     * 根据用户id获取推荐信息
     *
     * @param session
     * @return
     */
    @Override
    public List<PushMessage> getAll(HttpSession session) {
        User u = (User) session.getAttribute("user");
        return getAll(u.getId());
    }

    /**
     * 根据用户id获取推荐信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<PushMessage> getAll(Integer userId) {
        PushMessageExample pushMessageExample = new PushMessageExample();
        pushMessageExample.createCriteria().andUserIdEqualTo(userId);
        return pushMessageMapper.selectByExample(pushMessageExample);
    }
}
