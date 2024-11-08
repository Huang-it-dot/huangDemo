package com.huang.Service;

import org.springframework.stereotype.Service;

import com.huang.Model.User;

public interface UserService {

	public User getUserById(Integer id);
	public int createUser(User user);
}
