package com.xionglian.mapper;

import com.xionglian.model.Lost;
import com.xionglian.model.LostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LostMapper {
    long countByExample(LostExample example);

    int deleteByExample(LostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lost record);

    int insertSelective(Lost record);

    List<Lost> selectByExample(LostExample example);

    List selectAllWithUser();

    Lost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lost record, @Param("example") LostExample example);

    int updateByExample(@Param("record") Lost record, @Param("example") LostExample example);

    int updateByPrimaryKeySelective(Lost record);

    int updateByPrimaryKey(Lost record);
}