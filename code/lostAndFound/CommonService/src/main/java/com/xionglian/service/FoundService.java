package com.xionglian.service;


import com.xionglian.model.Found;
import com.xionglian.model.Lost;
import com.xionglian.model.User;

import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */

public interface FoundService {

    public int add(Found found);

    public int upateByPrimaryKey(Found found);

    public List<Found> getAll(Integer currentPage,Integer pageSize);

    public List getAllWithUser(Integer currentPage,Integer pageSize);

    public List<Found> getByCondition(String address,String keyword);

    public long countAll();

}
