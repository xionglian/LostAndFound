package com.xionglian.service.impl;


import com.github.pagehelper.PageHelper;
import com.xionglian.mapper.ThanksLetterMapper;
import com.xionglian.model.ThanksLetter;
import com.xionglian.model.User;
import com.xionglian.service.ThanksLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */
@Service
public class ThanksLetterServiceImpl implements ThanksLetterService{
    @Autowired
    private ThanksLetterMapper thanksLetterMapper;
    /**
     * 新增感谢信
     *
     * @param thanksLetter
     * @return
     */
    @Override
    public int add(ThanksLetter thanksLetter, HttpSession session) {
        User u = (User)session.getAttribute("user");
        thanksLetter.setLoginUser(u.getId());
        thanksLetter.setUserImgUrl(u.getUserImg());
        thanksLetter.setCreateTime(new Date());

        return thanksLetterMapper.insert(thanksLetter);
    }

    /**
     * 获取所有感谢信
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<ThanksLetter> selectAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return thanksLetterMapper.selectByExample(null);
    }
}
