
package com.huang.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.huang.Model.User;


@Mapper
public interface UserMapper {
	
	User selectUser(String userId);
	
	
//	   void createCard(Card card);
//
//	    void updateCard(Card card);
//
//	    void deleteCard(String id);
//
//	    int getNumOfCards();
//	
	
	
	
	

}
