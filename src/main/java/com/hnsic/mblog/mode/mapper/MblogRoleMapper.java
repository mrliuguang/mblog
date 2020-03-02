package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogRoleMapper {
    @Delete({
        "delete from mblog_role",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    @Insert({
        "insert into mblog_role (role_id, description, ",
        "name, status)",
        "values (#{roleId,jdbcType=BIGINT}, #{description,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(MblogRole record);

    @Select({
        "select",
        "role_id, description, name, status",
        "from mblog_role",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType= JdbcType.INTEGER)
    })
    MblogRole selectByPrimaryKey(Long roleId);

    @Select({
        "select",
        "role_id, description, name, status",
        "from mblog_role"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType= JdbcType.INTEGER)
    })
    List<MblogRole> selectAll();

    @Update({
        "update mblog_role",
        "set description = #{description,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where role_id = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogRole record);
}