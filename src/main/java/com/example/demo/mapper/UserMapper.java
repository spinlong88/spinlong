package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //获取用户名单
	@Select("select * from user ")  
    public List<User> getUser() throws Exception;
    
    
    //根据id删除用户
	@Delete(" delete from user where id =#{id}")
    public void deleteUser(int id)throws Exception;
    
    
    //新增用户
    @Options(useGeneratedKeys=true,keyProperty="id")  
    @Insert("insert into user(username,age) values(#{username},#{age})")  
    public void addUser(User user)throws Exception;
}