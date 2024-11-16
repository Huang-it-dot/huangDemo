package com.huang.Service;



import java.util.List;

import com.huang.Form.PersonForm;
import com.huang.Model.User;



public interface UserService {

	public User findUser(String userId,String pwd);
	
	public void updateUser(User user);
	

	
	
}