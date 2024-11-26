package com.huang.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huang.Mapper.StudentRepository;
import com.huang.Model.Student;

import jakarta.persistence.EntityNotFoundException;


public interface StudentService {

	public List<Student> getAllStudents();


   public  void saveStudent(Student student);

    public Student getStudentById(Long id);

    public void deleteStudent(Long id);
}
