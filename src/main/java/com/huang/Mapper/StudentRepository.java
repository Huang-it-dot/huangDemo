package com.huang.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.huang.Model.Student;

@Mapper
public interface StudentRepository {

	// 全ての学生情報取得する
	public List<Student> findAll();

	// 学生情報保存する
	public void save(Student student);

	// idで学生情報取得する
	public Student getStudentById(Long id);

	// idで学生情報削除する
	public void deleteById(Long id);

}
