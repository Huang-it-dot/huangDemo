package com.huang.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huang.Mapper.UserMapper;
import com.huang.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	//ユーザー情報を取得する
	@Override
	public User findUser(String userId, String pwd) {
		return userMapper.findUser(userId, pwd);
	}
	//ユーザー情報を更新する
	@Override
	public void updateUser(User user) {
	    userMapper.updateUser(user);	
	}
	//ユーザー情報を削除する
	@Override
	public void deleteUser(String userId) {
		userMapper.deleteUser(userId);		
	}
}