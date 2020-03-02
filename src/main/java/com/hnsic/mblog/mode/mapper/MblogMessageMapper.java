package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogMessage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogMessageMapper {
    @Delete({
        "delete from mblog_message",
        "where message_id = #{messageId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long messageId);

    @Insert({
        "insert into mblog_message (message_id, created, ",
        "from_id, article_id, ",
        "user_id, status)",
        "values (#{messageId,jdbcType=BIGINT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{fromId,jdbcType=BIGINT}, #{articleId,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=BIGINT}, #{status,jdbcType=INTEGER})"
    })
    int insert(MblogMessage record);

    @Select({
        "select",
        "message_id, created, from_id, article_id, user_id, status",
        "from mblog_message",
        "where message_id = #{messageId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="message_id", property="messageId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="from_id", property="fromId", jdbcType= JdbcType.BIGINT),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType= JdbcType.INTEGER)
    })
    MblogMessage selectByPrimaryKey(Long messageId);

    @Select({
        "select",
        "message_id, created, from_id, article_id, user_id, status",
        "from mblog_message"
    })
    @Results({
        @Result(column="message_id", property="messageId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="from_id", property="fromId", jdbcType= JdbcType.BIGINT),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType= JdbcType.INTEGER)
    })
    List<MblogMessage> selectAll();

    @Update({
        "update mblog_message",
        "set created = #{created,jdbcType=TIMESTAMP},",
          "from_id = #{fromId,jdbcType=BIGINT},",
          "article_id = #{articleId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER}",
        "where message_id = #{messageId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogMessage record);
}