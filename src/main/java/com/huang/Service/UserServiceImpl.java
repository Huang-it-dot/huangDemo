package com.huang.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huang.Form.PersonForm;
import com.huang.Mapper.UserMapper;
import com.huang.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	


	@Override
	public User findUser(String userId, String pwd) {
		return userMapper.findUser(userId, pwd);
	}

	@Override
	public void updateUser(User user) {

	    userMapper.updateUser(user);
		
	}
	
}