package com.huang.Service;



import com.huang.Model.User;



public interface UserService {

	public User selectUser(String userId,String pwd);
	
	public int selectUserCount(String userId);

	public User selectAllUser();
	
	
}