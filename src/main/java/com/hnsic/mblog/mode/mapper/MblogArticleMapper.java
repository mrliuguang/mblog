package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogArticle;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogArticleMapper {
    @Delete({
        "delete from mblog_article",
        "where article_id = #{articleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long articleId);

    @Insert({
        "insert into mblog_article (article_id, author_id, ",
        "column_id, comments, ",
        "created, favors, ",
        "status, summary, ",
        "tags, thumbnail, ",
        "title, views, weight)",
        "values (#{articleId,jdbcType=BIGINT}, #{authorId,jdbcType=BIGINT}, ",
        "#{columnId,jdbcType=INTEGER}, #{comments,jdbcType=INTEGER}, ",
        "#{created,jdbcType=TIMESTAMP}, #{favors,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{summary,jdbcType=VARCHAR}, ",
        "#{tags,jdbcType=VARCHAR}, #{thumbnail,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{views,jdbcType=INTEGER}, #{weight,jdbcType=INTEGER})"
    })
    int insert(MblogArticle record);

    @Select({
        "select",
        "article_id, author_id, column_id, comments, created, favors, status, summary, ",
        "tags, thumbnail, title, views, weight",
        "from mblog_article",
        "where article_id = #{articleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="author_id", property="authorId", jdbcType= JdbcType.BIGINT),
        @Result(column="column_id", property="columnId", jdbcType= JdbcType.INTEGER),
        @Result(column="comments", property="comments", jdbcType= JdbcType.INTEGER),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="favors", property="favors", jdbcType= JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType= JdbcType.INTEGER),
        @Result(column="summary", property="summary", jdbcType= JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType= JdbcType.VARCHAR),
        @Result(column="thumbnail", property="thumbnail", jdbcType= JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType= JdbcType.VARCHAR),
        @Result(column="views", property="views", jdbcType= JdbcType.INTEGER),
        @Result(column="weight", property="weight", jdbcType= JdbcType.INTEGER)
    })
    MblogArticle selectByPrimaryKey(Long articleId);

    @Select({
        "select",
        "article_id, author_id, column_id, comments, created, favors, status, summary, ",
        "tags, thumbnail, title, views, weight",
        "from mblog_article"
    })
    @Results({
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="author_id", property="authorId", jdbcType= JdbcType.BIGINT),
        @Result(column="column_id", property="columnId", jdbcType= JdbcType.INTEGER),
        @Result(column="comments", property="comments", jdbcType= JdbcType.INTEGER),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="favors", property="favors", jdbcType= JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType= JdbcType.INTEGER),
        @Result(column="summary", property="summary", jdbcType= JdbcType.VARCHAR),
        @Result(column="tags", property="tags", jdbcType= JdbcType.VARCHAR),
        @Result(column="thumbnail", property="thumbnail", jdbcType= JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType= JdbcType.VARCHAR),
        @Result(column="views", property="views", jdbcType= JdbcType.INTEGER),
        @Result(column="weight", property="weight", jdbcType= JdbcType.INTEGER)
    })
    List<MblogArticle> selectAll();

    @Update({
        "update mblog_article",
        "set author_id = #{authorId,jdbcType=BIGINT},",
          "column_id = #{columnId,jdbcType=INTEGER},",
          "comments = #{comments,jdbcType=INTEGER},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "favors = #{favors,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "summary = #{summary,jdbcType=VARCHAR},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "thumbnail = #{thumbnail,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "views = #{views,jdbcType=INTEGER},",
          "weight = #{weight,jdbcType=INTEGER}",
        "where article_id = #{articleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogArticle record);
}