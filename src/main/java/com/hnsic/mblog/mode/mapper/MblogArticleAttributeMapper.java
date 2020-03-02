package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogArticleAttribute;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogArticleAttributeMapper {
    @Delete({
        "delete from mblog_article_attribute",
        "where attribute_id = #{attributeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long attributeId);

    @Insert({
        "insert into mblog_article_attribute (attribute_id, editor, ",
        "article_id, content)",
        "values (#{attributeId,jdbcType=BIGINT}, #{editor,jdbcType=VARCHAR}, ",
        "#{articleId,jdbcType=BIGINT}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(MblogArticleAttribute record);

    @Select({
        "select",
        "attribute_id, editor, article_id, content",
        "from mblog_article_attribute",
        "where attribute_id = #{attributeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="attribute_id", property="attributeId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="editor", property="editor", jdbcType= JdbcType.VARCHAR),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType= JdbcType.LONGVARCHAR)
    })
    MblogArticleAttribute selectByPrimaryKey(Long attributeId);

    @Select({
        "select",
        "attribute_id, editor, article_id, content",
        "from mblog_article_attribute"
    })
    @Results({
        @Result(column="attribute_id", property="attributeId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="editor", property="editor", jdbcType= JdbcType.VARCHAR),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType= JdbcType.LONGVARCHAR)
    })
    List<MblogArticleAttribute> selectAll();

    @Update({
        "update mblog_article_attribute",
        "set editor = #{editor,jdbcType=VARCHAR},",
          "article_id = #{articleId,jdbcType=BIGINT},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where attribute_id = #{attributeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogArticleAttribute record);
}