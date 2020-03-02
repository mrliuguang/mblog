package com.hnsic.mblog.mode.mapper;

import com.hnsic.mblog.mode.bean.MblogUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MblogUserMapper {
    @Delete({
            "delete from mblog_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
            "insert into mblog_user ( username, ",
            "email, password, ",
            "status, birthday, ",
            "gender, createdate, ",
            "last_login, comments, ",
            "posts, icon, signature)",
            "values (#{username,jdbcType=VARCHAR}, ",
            "#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
            "#{gender,jdbcType=INTEGER}, #{createdate,jdbcType=TIMESTAMP}, ",
            "#{lastLogin,jdbcType=TIMESTAMP}, #{comments,jdbcType=INTEGER}, ",
            "#{posts,jdbcType=INTEGER}, #{icon,jdbcType=VARCHAR}, #{signature,jdbcType=VARCHAR})"
    })
    int insert(MblogUser record);

    @Select({
            "select",
            "user_id, username, email, password, status, birthday, gender, createdate, last_login, ",
            "comments, posts, icon, signature",
            "from mblog_user",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
            @Result(column="createdate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_login", property="lastLogin", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="comments", property="comments", jdbcType=JdbcType.INTEGER),
            @Result(column="posts", property="posts", jdbcType=JdbcType.INTEGER),
            @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
            @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR)
    })
    MblogUser selectByPrimaryKey(Long userId);

    @Select({
            "select",
            "user_id, username, email, password, status, birthday, gender, createdate, last_login, ",
            "comments, posts, icon, signature",
            "from mblog_user"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
            @Result(column="createdate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_login", property="lastLogin", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="comments", property="comments", jdbcType=JdbcType.INTEGER),
            @Result(column="posts", property="posts", jdbcType=JdbcType.INTEGER),
            @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
            @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR)
    })
    List<MblogUser> selectAll();

    @Update({
            "update mblog_user",
            "set username = #{username,jdbcType=VARCHAR},",
            "email = #{email,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=INTEGER},",
            "birthday = #{birthday,jdbcType=TIMESTAMP},",
            "gender = #{gender,jdbcType=INTEGER},",
            "createdate = #{createdate,jdbcType=TIMESTAMP},",
            "last_login = #{lastLogin,jdbcType=TIMESTAMP},",
            "comments = #{comments,jdbcType=INTEGER},",
            "posts = #{posts,jdbcType=INTEGER},",
            "icon = #{icon,jdbcType=VARCHAR},",
            "signature = #{signature,jdbcType=VARCHAR}",
            "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MblogUser record);

    @Select({
            "select",
            "user_id, username, email, password, status, birthday, gender, createdate, last_login, ",
            "comments, posts, icon, signature",
            "from mblog_user where username =#{userName}"
    })
    @Results({
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
            @Result(column="createdate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_login", property="lastLogin", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="comments", property="comments", jdbcType=JdbcType.INTEGER),
            @Result(column="posts", property="posts", jdbcType=JdbcType.INTEGER),
            @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
            @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR)
    })
    MblogUser findByUsername(String userName);
}