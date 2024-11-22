package com.huang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huang.Model.Student;
import com.huang.Service.StudentService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
//        	 model.addAttribute("students", students);
            // 处理 student
        }

        
        
        System.out.print("yui");;
		return null; 
     
        
       
        
    
    }

//    @PostMapping
//    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        Student savedStudent = studentService.saveStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
//        Student student = studentService.getStudentById(id);
//        return ResponseEntity.ok(student);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }
}
