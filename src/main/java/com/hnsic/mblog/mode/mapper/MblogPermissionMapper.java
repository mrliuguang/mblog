package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogPermission;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogPermissionMapper {
    @Delete({
        "delete from mblog_permission",
        "where permission_id = #{permissionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long permissionId);

    @Insert({
        "insert into mblog_permission (permission_id, description, ",
        "name, permission, ",
        "parent_id, sortnum)",
        "values (#{permissionId,jdbcType=BIGINT}, #{description,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{permission,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=VARCHAR}, #{sortnum,jdbcType=INTEGER})"
    })
    int insert(MblogPermission record);

    @Select({
        "select",
        "permission_id, description, name, permission, parent_id, sortnum",
        "from mblog_permission",
        "where permission_id = #{permissionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="permission_id", property="permissionId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="sortnum", property="sortnum", jdbcType= JdbcType.INTEGER)
    })
    MblogPermission selectByPrimaryKey(Long permissionId);

    @Select({
        "select",
        "permission_id, description, name, permission, parent_id, sortnum",
        "from mblog_permission"
    })
    @Results({
        @Result(column="permission_id", property="permissionId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType= JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType= JdbcType.VARCHAR),
        @Result(column="sortnum", property="sortnum", jdbcType= JdbcType.INTEGER)
    })
    List<MblogPermission> selectAll();

    @Update({
        "update mblog_permission",
        "set description = #{description,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=VARCHAR},",
          "sortnum = #{sortnum,jdbcType=INTEGER}",
        "where permission_id = #{permissionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogPermission record);
}