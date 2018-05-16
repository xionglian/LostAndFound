package com.xionglian.service.impl;

import com.github.pagehelper.PageHelper;
import com.xionglian.mapper.FoundMapper;
import com.xionglian.model.Found;
import com.xionglian.model.FoundExample;
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
        found.setState((byte)1);//状态（1-招领中，2-确认找到）
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

    @Override
    public List getAllWithUser(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return foundMapper.selectAllWithUser();
    }

    @Override
    public List<Found> getByCondition( String address, String keyword) {
        if(keyword == null)
            return null;
        FoundExample foundExample = new FoundExample();
        FoundExample.Criteria c = foundExample.createCriteria();
        if(address != null){
            c.andFoundAddressLike(address);
        }
        if(keyword != null){
            foundExample.or().andKeyWord01Like("%"+keyword+"%");
            foundExample.or().andKeyWord02Like("%"+keyword+"%");
            foundExample.or().andKeyWord03Like("%"+keyword+"%");
            foundExample.or().andGoodNameLike("%"+keyword+"%");
        }
        return foundMapper.selectByExample(foundExample);
    }

    @Override
    public long countAll() {
        return foundMapper.countByExample(null);
    }
}
