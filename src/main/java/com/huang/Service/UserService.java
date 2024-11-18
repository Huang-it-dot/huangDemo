package com.huang.Service;
import java.util.List;

import com.huang.Model.User;
public interface UserService {

	//ユーザー情報を取得する
	public User findUser(String userId,String pwd);
	//ユーザー情報を更新する
	public void updateUser(User user);
	//ユーザー情報を削除する
	public void deleteUser(String userId);	
}