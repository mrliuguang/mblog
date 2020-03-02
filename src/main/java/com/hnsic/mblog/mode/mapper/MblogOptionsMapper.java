package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogOptions;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogOptionsMapper {
    @Delete({
        "delete from mblog_options",
        "where option_id = #{optionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer optionId);

    @Insert({
        "insert into mblog_options (option_id, option_name, ",
        "option_value)",
        "values (#{optionId,jdbcType=INTEGER}, #{optionName,jdbcType=VARCHAR}, ",
        "#{optionValue,jdbcType=VARCHAR})"
    })
    int insert(MblogOptions record);

    @Select({
        "select",
        "option_id, option_name, option_value",
        "from mblog_options",
        "where option_id = #{optionId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="option_id", property="optionId", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="option_name", property="optionName", jdbcType= JdbcType.VARCHAR),
        @Result(column="option_value", property="optionValue", jdbcType= JdbcType.VARCHAR)
    })
    MblogOptions selectByPrimaryKey(Integer optionId);

    @Select({
        "select",
        "option_id, option_name, option_value",
        "from mblog_options"
    })
    @Results({
        @Result(column="option_id", property="optionId", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="option_name", property="optionName", jdbcType= JdbcType.VARCHAR),
        @Result(column="option_value", property="optionValue", jdbcType= JdbcType.VARCHAR)
    })
    List<MblogOptions> selectAll();

    @Update({
        "update mblog_options",
        "set option_name = #{optionName,jdbcType=VARCHAR},",
          "option_value = #{optionValue,jdbcType=VARCHAR}",
        "where option_id = #{optionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MblogOptions record);
}