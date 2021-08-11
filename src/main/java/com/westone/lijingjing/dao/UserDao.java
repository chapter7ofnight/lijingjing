package com.westone.lijingjing.dao;

import com.westone.lijingjing.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where username = #{username}")
    User selectUser(@Param("username") String username);
}
