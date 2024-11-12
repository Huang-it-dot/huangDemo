
package com.huang.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.huang.Model.User;


@Mapper
public interface UserMapper {
	
	public User selectUser(String userId,String pwd);
	
	public int selectUserCount(String userId);	

	public User selectAllUser();
}
