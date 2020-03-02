package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogResource;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogResourceMapper {
    @Delete({
        "delete from mblog_resource",
        "where mblog_resource_id = #{mblogResourceId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long mblogResourceId);

    @Insert({
        "insert into mblog_resource (mblog_resource_id, create, ",
        "md5, path)",
        "values (#{mblogResourceId,jdbcType=BIGINT}, #{create,jdbcType=TIMESTAMP}, ",
        "#{md5,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR})"
    })
    int insert(MblogResource record);

    @Select({
        "select",
        "mblog_resource_id, create, md5, path",
        "from mblog_resource",
        "where mblog_resource_id = #{mblogResourceId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="mblog_resource_id", property="mblogResourceId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="create", property="create", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="md5", property="md5", jdbcType= JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType= JdbcType.VARCHAR)
    })
    MblogResource selectByPrimaryKey(Long mblogResourceId);

    @Select({
        "select",
        "mblog_resource_id, create, md5, path",
        "from mblog_resource"
    })
    @Results({
        @Result(column="mblog_resource_id", property="mblogResourceId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="create", property="create", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="md5", property="md5", jdbcType= JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType= JdbcType.VARCHAR)
    })
    List<MblogResource> selectAll();

    @Update({
        "update mblog_resource",
        "set create = #{create,jdbcType=TIMESTAMP},",
          "md5 = #{md5,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR}",
        "where mblog_resource_id = #{mblogResourceId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogResource record);
}