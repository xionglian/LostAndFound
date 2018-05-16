package com.xionglian.mapper;

import com.xionglian.model.Found;
import com.xionglian.model.FoundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoundMapper {
    long countByExample(FoundExample example);

    int deleteByExample(FoundExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Found record);

    int insertSelective(Found record);

    List<Found> selectByExample(FoundExample example);

    List selectAllWithUser();

    Found selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Found record, @Param("example") FoundExample example);

    int updateByExample(@Param("record") Found record, @Param("example") FoundExample example);

    int updateByPrimaryKeySelective(Found record);

    int updateByPrimaryKey(Found record);
}