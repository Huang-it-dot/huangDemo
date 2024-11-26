package com.huang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huang.Model.Student;
import com.huang.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students; // 返回
        }
    

    @PostMapping("/addStudent")
    public List<Student> addStudent(@RequestBody Student student) {
        // 假设你有一个保存学生的服务
        studentService.saveStudent(student);
        // 返回已保存的学生对象
        List<Student> students = studentService.getAllStudents();
        return students;
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(student);
    }
    
//  @DeleteMapping("/{id}")
//  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//      studentService.deleteStudent(id);
//      return ResponseEntity.noContent().build();
//  }

}


