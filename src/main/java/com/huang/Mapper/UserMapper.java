package com.huang.Mapper;
import org.apache.ibatis.annotations.Mapper;

import com.huang.Model.User;

@Mapper
public interface UserMapper {
	public int createUser(String username, String password);
	public User getUserById(Integer id);
}
