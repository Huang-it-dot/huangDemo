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



    public User selectUser(String userId,String pwd) {
        return userMapper.selectUser(userId,pwd);
    }

    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

	@Override
	public int selectUserCount(String userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserCount(userId);
	}
	
}