package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogUserRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogUserRoleMapper {
    @Delete({
        "delete from mblog_user_role",
        "where user_role_id = #{userRoleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userRoleId);

    @Insert({
        "insert into mblog_user_role (user_role_id, user_id, ",
        "role_id)",
        "values (#{userRoleId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{roleId,jdbcType=BIGINT})"
    })
    int insert(MblogUserRole record);

    @Select({
        "select",
        "user_role_id, user_id, role_id",
        "from mblog_user_role",
        "where user_role_id = #{userRoleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.BIGINT)
    })
    MblogUserRole selectByPrimaryKey(Long userRoleId);

    @Select({
        "select",
        "user_role_id, user_id, role_id",
        "from mblog_user_role"
    })
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.BIGINT)
    })
    List<MblogUserRole> selectAll();

    @Update({
        "update mblog_user_role",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "role_id = #{roleId,jdbcType=BIGINT}",
        "where user_role_id = #{userRoleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogUserRole record);
}