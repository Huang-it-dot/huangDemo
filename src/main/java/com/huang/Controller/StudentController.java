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

	// 全ての学生情報を取得する
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		
		List<Student> students = studentService.getAllStudents();
		return students;
	}

	// 学生情報を保存する
	@PostMapping("/addStudent")
	public List<Student> addStudent(@RequestBody Student student) {

		studentService.saveStudent(student);

		List<Student> students = studentService.getAllStudents();
		return students;
	}

	// IDで学生情報を取得する
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(student);
	}
}
