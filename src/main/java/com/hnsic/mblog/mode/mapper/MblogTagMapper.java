package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogTag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogTagMapper {
    @Delete({
        "delete from mblog_tag",
        "where tag_id = #{tagId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long tagId);

    @Insert({
        "insert into mblog_tag (tag_id, created, ",
        "last_article_id, name, ",
        "articles, updated)",
        "values (#{tagId,jdbcType=BIGINT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{lastArticleId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{articles,jdbcType=INTEGER}, #{updated,jdbcType=TIMESTAMP})"
    })
    int insert(MblogTag record);

    @Select({
        "select",
        "tag_id, created, last_article_id, name, articles, updated",
        "from mblog_tag",
        "where tag_id = #{tagId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="tag_id", property="tagId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="last_article_id", property="lastArticleId", jdbcType= JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="articles", property="articles", jdbcType= JdbcType.INTEGER),
        @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP)
    })
    MblogTag selectByPrimaryKey(Long tagId);

    @Select({
        "select",
        "tag_id, created, last_article_id, name, articles, updated",
        "from mblog_tag"
    })
    @Results({
        @Result(column="tag_id", property="tagId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="last_article_id", property="lastArticleId", jdbcType= JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="articles", property="articles", jdbcType= JdbcType.INTEGER),
        @Result(column="updated", property="updated", jdbcType= JdbcType.TIMESTAMP)
    })
    List<MblogTag> selectAll();

    @Update({
        "update mblog_tag",
        "set created = #{created,jdbcType=TIMESTAMP},",
          "last_article_id = #{lastArticleId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "articles = #{articles,jdbcType=INTEGER},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where tag_id = #{tagId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogTag record);
}