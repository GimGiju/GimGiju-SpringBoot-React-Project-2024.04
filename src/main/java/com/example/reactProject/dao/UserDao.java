package com.example.reactProject.dao;

import com.example.reactProject.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from users where isDeleted=0 order by regDate DESC")
    List<User> userList();

}
