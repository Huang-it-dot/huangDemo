package com.huang.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.huang.Model.Student;

@Mapper
public interface StudentRepository{
	
	
	public List<Student> findAll();
	
	public void save(Student student);
	
	
	
}
