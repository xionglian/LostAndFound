package com.xionglian.service;


import com.xionglian.model.Found;
import com.xionglian.model.Lost;

import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */

public interface LostService {

    public int add(Lost lost);

    public int upateByPrimaryKey(Lost lost);

    public List<Lost> getAll(Integer currentPage, Integer pageSize);

}
