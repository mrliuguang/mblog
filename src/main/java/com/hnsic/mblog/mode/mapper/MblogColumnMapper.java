package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogColumn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogColumnMapper {
    @Insert({
        "insert into mblog_column (column_id, column_name, ",
        "column_value, column_status, ",
        "weight)",
        "values (#{columnId,jdbcType=INTEGER}, #{columnName,jdbcType=VARCHAR}, ",
        "#{columnValue,jdbcType=VARCHAR}, #{columnStatus,jdbcType=INTEGER}, ",
        "#{weight,jdbcType=INTEGER})"
    })
    int insert(MblogColumn record);

    @Select({
        "select",
        "column_id, column_name, column_value, column_status, weight",
        "from mblog_column"
    })
    @Results({
        @Result(column="column_id", property="columnId", jdbcType= JdbcType.INTEGER),
        @Result(column="column_name", property="columnName", jdbcType= JdbcType.VARCHAR),
        @Result(column="column_value", property="columnValue", jdbcType= JdbcType.VARCHAR),
        @Result(column="column_status", property="columnStatus", jdbcType= JdbcType.INTEGER),
        @Result(column="weight", property="weight", jdbcType= JdbcType.INTEGER)
    })
    List<MblogColumn> selectAll();
}