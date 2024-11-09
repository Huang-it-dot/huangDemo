package com.huang.Service;



import org.springframework.beans.factory.annotation.Autowired;

import com.huang.Mapper.UserMapper;
import com.huang.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

//
//    int insert( String name,String userId);
//
//    User select ( String name,String userId);
//
//    void deleteUser ( String name,String userId);
	@Autowired
	private UserMapper userMapper;



    public User selectUser(String userId) {
        return userMapper.selectUser(userId);
    }

//    @Override
//    public void deleteUser(String userId,String name) {
//        userMapper.deleteUser(userId,name);
//    }
////
////    @Override
////    public int getNumOfCards() {
////        return cardMapper_.getNumOfCards();
////    }
////	
//
//	@Override
//	public int insert(String name, String userId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//	
//	
	
	
}