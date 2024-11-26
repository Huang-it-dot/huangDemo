package com.huang.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.huang.Form.StudentForm;
import com.huang.Model.Student;
import com.huang.Service.StudentService;

@Controller
public class EditController {
	@Autowired
	private StudentService studentService;

	// IDで学生情報を取得する
	@GetMapping("/edit/{id}")
	public String getAllStudents(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);

		// 取得したデータをモデルにセット
		if (student != null) {
			model.addAttribute("student", student);
		} else {
			model.addAttribute("error", "Student not found!");
		}
		// 編集画面に遷移
		return "edit";
	}

	@PostMapping("/edit/{id}")
	public String getStudents(Long id, Model model) {
		return "/edit";
	}

//学生情報を更新して保存する
	@PostMapping("/students/update")
	public String saveUser(@ModelAttribute StudentForm studentForm, BindingResult result, Model model) {

		Student student = new Student();
		student.setId(studentForm.getId().longValue());
		student.setName(studentForm.getName());
		student.setEmail(studentForm.getEmail());
		student.setAge(studentForm.getAge());
		studentService.saveStudent(student);
		return "/index";

	}

	// 学生情報を削除する
	@DeleteMapping("/edit/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}
}
