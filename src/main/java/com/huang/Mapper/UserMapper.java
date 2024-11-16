
package com.huang.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huang.Model.User;


@Mapper
public interface UserMapper {
	
	public User findUser(String userId,String pwd);

}