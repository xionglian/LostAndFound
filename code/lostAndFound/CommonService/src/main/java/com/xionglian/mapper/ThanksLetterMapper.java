package com.xionglian.mapper;

import com.xionglian.model.ThanksLetter;
import com.xionglian.model.ThanksLetterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThanksLetterMapper {
    long countByExample(ThanksLetterExample example);

    int deleteByExample(ThanksLetterExample example);

    int insert(ThanksLetter record);

    int insertSelective(ThanksLetter record);

    List<ThanksLetter> selectByExample(ThanksLetterExample example);

    int updateByExampleSelective(@Param("record") ThanksLetter record, @Param("example") ThanksLetterExample example);

    int updateByExample(@Param("record") ThanksLetter record, @Param("example") ThanksLetterExample example);
}