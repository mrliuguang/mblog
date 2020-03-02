package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogFavorites;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogFavoritesMapper {
    @Delete({
        "delete from mblog_favorites",
        "where favorite_id = #{favoriteId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long favoriteId);

    @Insert({
        "insert into mblog_favorites (favorite_id, article_id, ",
        "user_id, created)",
        "values (#{favoriteId,jdbcType=BIGINT}, #{articleId,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=BIGINT}, #{created,jdbcType=TIMESTAMP})"
    })
    int insert(MblogFavorites record);

    @Select({
        "select",
        "favorite_id, article_id, user_id, created",
        "from mblog_favorites",
        "where favorite_id = #{favoriteId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="favorite_id", property="favoriteId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP)
    })
    MblogFavorites selectByPrimaryKey(Long favoriteId);

    @Select({
        "select",
        "favorite_id, article_id, user_id, created",
        "from mblog_favorites"
    })
    @Results({
        @Result(column="favorite_id", property="favoriteId", jdbcType= JdbcType.BIGINT, id=true),
        @Result(column="article_id", property="articleId", jdbcType= JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.BIGINT),
        @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP)
    })
    List<MblogFavorites> selectAll();

    @Update({
        "update mblog_favorites",
        "set article_id = #{articleId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where favorite_id = #{favoriteId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogFavorites record);
}