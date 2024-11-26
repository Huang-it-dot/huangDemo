package com.huang.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huang.Mapper.StudentRepository;

import com.huang.Model.Student;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	// 全ての学生情報取得する
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	// 学生情報保存する
	public void saveStudent(Student student) {
		studentRepository.save(student);

	}

	// idで学生情報取得する
	public Student getStudentById(Long id) {
		return studentRepository.getStudentById(id);
	}

	// idで学生情報削除する
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}