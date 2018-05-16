package com.xionglian.service.impl;

import com.github.pagehelper.PageHelper;
import com.xionglian.mapper.FoundMapper;
import com.xionglian.mapper.LostMapper;
import com.xionglian.model.Found;
import com.xionglian.model.FoundExample;
import com.xionglian.model.Lost;
import com.xionglian.model.LostExample;
import com.xionglian.service.FoundService;
import com.xionglian.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  xionglian on 2018-05-08.
 */
@Service
public class LostServiceImpl implements LostService{
    @Autowired
    private LostMapper lostMapper;
    @Override
    public int add(Lost lost) {
        return lostMapper.insert(lost);
    }

    @Override
    public int upateByPrimaryKey(Lost lost) {
        return lostMapper.updateByPrimaryKeySelective(lost);
    }

    @Override
    public List<Lost> getAll(Integer currentPage, Integer pageSize) {
       PageHelper.startPage(currentPage,pageSize);
       return lostMapper.selectByExample(null);
    }

    @Override
    public List
    getAllWithUser(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return lostMapper.selectAllWithUser();

    }

    @Override
    public List<Lost> getByCondition( String address, String keyword) {
        if( keyword == null)
            return null;
        LostExample lostExample = new LostExample();
        LostExample.Criteria c = lostExample.createCriteria();
        if(address != null){
            c.andLostAddressLike(address);
        }
        if(keyword != null){
            lostExample.or().andKeyWord01Like("%"+keyword+"%");
            lostExample.or().andKeyWord02Like("%"+keyword+"%");
            lostExample.or().andKeyWord03Like("%"+keyword+"%");
            lostExample.or().andGoodNameLike("%"+keyword+"%");
        }
        return lostMapper.selectByExample(lostExample);
    }

    @Override
    public long countAll() {
        return lostMapper.countByExample(null);
    }
}
