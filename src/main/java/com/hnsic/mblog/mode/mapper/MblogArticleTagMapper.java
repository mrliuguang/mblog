package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogArticleTag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogArticleTagMapper {
    @Delete({
        "delete from mblog_article_tag",
        "where tag_article_id = #{tagArticleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long tagArticleId);

    @Insert({
        "insert into mblog_article_tag (tag_article_id, article_id, ",
        "tag_id, weight)",
        "values (#{tagArticleId,jdbcType=BIGINT}, #{articleId,jdbcType=BIGINT}, ",
        "#{tagId,jdbcType=BIGINT}, #{weight,jdbcType=INTEGER})"
    })
    int insert(MblogArticleTag record);

    @Select({
        "select",
        "tag_article_id, article_id, tag_id, weight",
        "from mblog_article_tag",
        "where tag_article_id = #{tagArticleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="tag_article_id", property="tagArticleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="tag_id", property="tagId", jdbcType= JdbcType.BIGINT),
        @Result(column="weight", property="weight", jdbcType= JdbcType.INTEGER)
    })
    MblogArticleTag selectByPrimaryKey(Long tagArticleId);

    @Select({
        "select",
        "tag_article_id, article_id, tag_id, weight",
        "from mblog_article_tag"
    })
    @Results({
        @Result(column="tag_article_id", property="tagArticleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="tag_id", property="tagId", jdbcType= JdbcType.BIGINT),
        @Result(column="weight", property="weight", jdbcType= JdbcType.INTEGER)
    })
    List<MblogArticleTag> selectAll();

    @Update({
        "update mblog_article_tag",
        "set article_id = #{articleId,jdbcType=BIGINT},",
          "tag_id = #{tagId,jdbcType=BIGINT},",
          "weight = #{weight,jdbcType=INTEGER}",
        "where tag_article_id = #{tagArticleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogArticleTag record);
}