package com.huang.Service;



import java.util.List;

import com.huang.Model.User;



public interface UserService {

	public User selectUser(String userId,String pwd);
	
	public int selectUserCount(String userId);

	public List<User> selectAllUser();
	
	
}