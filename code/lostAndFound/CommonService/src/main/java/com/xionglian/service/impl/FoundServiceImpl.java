package com.xionglian.service.impl;

import com.github.pagehelper.PageHelper;
import com.xionglian.mapper.FoundMapper;
import com.xionglian.model.Found;
import com.xionglian.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */
@Service
public class FoundServiceImpl implements FoundService{
    @Autowired
    private FoundMapper foundMapper;
    @Override
    public int add(Found found) {
        return foundMapper.insert(found);
    }

    @Override
    public int upateByPrimaryKey(Found found) {
        return foundMapper.updateByPrimaryKeySelective(found);
    }

    @Override
    public List<Found> getAll(Integer currentPage, Integer pageSize) {
       PageHelper.startPage(currentPage,pageSize);
       return foundMapper.selectByExample(null);
    }
}
