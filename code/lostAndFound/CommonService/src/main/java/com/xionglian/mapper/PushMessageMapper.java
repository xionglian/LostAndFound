package com.xionglian.mapper;

import com.xionglian.model.PushMessage;
import com.xionglian.model.PushMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PushMessageMapper {
    long countByExample(PushMessageExample example);

    int deleteByExample(PushMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PushMessage record);

    int insertSelective(PushMessage record);

    List<PushMessage> selectByExample(PushMessageExample example);

    PushMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PushMessage record, @Param("example") PushMessageExample example);

    int updateByExample(@Param("record") PushMessage record, @Param("example") PushMessageExample example);

    int updateByPrimaryKeySelective(PushMessage record);

    int updateByPrimaryKey(PushMessage record);
}