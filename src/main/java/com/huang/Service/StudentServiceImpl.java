package com.huang.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huang.Mapper.StudentRepository;

import com.huang.Model.Student;


import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
    	studentRepository.save(student);
	
    }

    public Student getStudentById(Long id) {
		return null;
//        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found"));
    	
    }
//
//    public void deleteStudent(Long id) {
//        studentRepository.deleteById(id);
//    }
}