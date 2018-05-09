package com.xionglian.service;


import com.xionglian.model.ThanksLetter;
import com.xionglian.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */

public interface ThanksLetterService {
    /**
     * 新增感谢信
     * @param thanksLetter
     * @return
     */
    public int add(ThanksLetter thanksLetter, HttpSession session);

    /**
     * 获取所有感谢信
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<ThanksLetter> selectAll(Integer currentPage,Integer pageSize);


}
