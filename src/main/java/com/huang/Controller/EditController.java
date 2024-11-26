package com.huang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huang.Form.StudentForm;
import com.huang.Model.Student;
import com.huang.Service.StudentService;

@Controller
public class EditController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/edit/{id}")
    public String getAllStudents(@PathVariable Long id,Model model) {
     Student student = studentService.getStudentById(id);
     
     // 将学生数据添加到模型中
     if (student != null) {
         model.addAttribute("student", student);
     } else {
         model.addAttribute("error", "Student not found!");
     }
     // 返回编辑页面视图
     return "edit"; // 假设模板名是 edit.html
        }
    
    @PostMapping("/edit/{id}")
    public String getStudents(Long id,Model model) {
        return "/edit"; // 返回
        }
    

    @PostMapping("/students/update")
    public String saveUser(@ModelAttribute StudentForm studentForm, BindingResult result, Model model) { 	
    	
    	Student student = new Student();
    	student.setId(studentForm.getId().longValue());
    	student.setName(studentForm.getName());
    	student.setEmail(studentForm.getEmail());
    	student.setAge(studentForm.getAge());
    	studentService.saveStudent(student);
		 return "/index"; // 返回

    }
//    @PostMapping("/addStudent")
//    public List<Student> addStudent(@RequestBody Student student) {
//        // 假设你有一个保存学生的服务
//        studentService.saveStudent(student);
//        // 返回已保存的学生对象
//        List<Student> students = studentService.getAllStudents();
////        return ResponseEntity.status(HttpStatus.CREATED).body(student);
//        return students;
//    }
//    @GetMapping("/students/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
//        Student student = studentService.getStudentById(id);
//        if (student == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        return ResponseEntity.ok(student);
//    }
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
//        Student existingStudent = studentService.getStudentById(id);
//        if (existingStudent == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
//        }
////        updatedStudent.setId(id); // 确保 ID 不变
////        Student savedStudent = studentService.save(updatedStudent);
////        return ResponseEntity.ok(savedStudent);
//		return null;
//    }
}
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.noContent().build();
//    }

