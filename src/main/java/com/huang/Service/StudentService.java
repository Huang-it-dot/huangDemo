package com.huang.Service;

import java.util.List;

import com.huang.Model.Student;


public interface StudentService {

	// 全ての学生情報取得する
	public List<Student> getAllStudents();

	// 学生情報保存する
	public void saveStudent(Student student);

	// idで学生情報取得する
	public Student getStudentById(Long id);

	// idで学生情報削除する
	public void deleteStudent(Long id);
}
