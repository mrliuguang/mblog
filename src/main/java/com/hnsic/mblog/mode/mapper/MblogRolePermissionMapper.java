package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogRolePermission;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogRolePermissionMapper {
    @Delete({
        "delete from mblog_role_permission",
        "where role_perms_id = #{rolePermsId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long rolePermsId);

    @Insert({
        "insert into mblog_role_permission (role_perms_id, permission_id, ",
        "role_id)",
        "values (#{rolePermsId,jdbcType=BIGINT}, #{permissionId,jdbcType=BIGINT}, ",
        "#{roleId,jdbcType=BIGINT})"
    })
    int insert(MblogRolePermission record);

    @Select({
        "select",
        "role_perms_id, permission_id, role_id",
        "from mblog_role_permission",
        "where role_perms_id = #{rolePermsId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="role_perms_id", property="rolePermsId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="permission_id", property="permissionId", jdbcType= JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.BIGINT)
    })
    MblogRolePermission selectByPrimaryKey(Long rolePermsId);

    @Select({
        "select",
        "role_perms_id, permission_id, role_id",
        "from mblog_role_permission"
    })
    @Results({
        @Result(column="role_perms_id", property="rolePermsId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="permission_id", property="permissionId", jdbcType= JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType= JdbcType.BIGINT)
    })
    List<MblogRolePermission> selectAll();

    @Update({
        "update mblog_role_permission",
        "set permission_id = #{permissionId,jdbcType=BIGINT},",
          "role_id = #{roleId,jdbcType=BIGINT}",
        "where role_perms_id = #{rolePermsId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogRolePermission record);
}