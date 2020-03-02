package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogArticleResource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogArticleResourceMapper {
    @Insert({
        "insert into mblog_article_resource (article_resource_id, path, ",
        "article_id, resource_id)",
        "values (#{articleResourceId,jdbcType=BIGINT}, #{path,jdbcType=VARCHAR}, ",
        "#{articleId,jdbcType=BIGINT}, #{resourceId,jdbcType=BIGINT})"
    })
    int insert(MblogArticleResource record);

    @Select({
        "select",
        "article_resource_id, path, article_id, resource_id",
        "from mblog_article_resource"
    })
    @Results({
        @Result(column="article_resource_id", property="articleResourceId", jdbcType= JdbcType.BIGINT),
        @Result(column="path", property="path", jdbcType= JdbcType.VARCHAR),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="resource_id", property="resourceId", jdbcType= JdbcType.BIGINT)
    })
    List<MblogArticleResource> selectAll();
}