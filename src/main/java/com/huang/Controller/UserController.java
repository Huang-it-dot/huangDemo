package com.huang.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.huang.Model.Student;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/getData")
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("服务器返回的数据");
    }
    @PostMapping("/postData")
    public ResponseEntity<String> handlePostRequest(@RequestBody Student student) {
//        System.out.println("Received user data: " + user);
//    	user.setId(1L); // 假设数据库生成的 ID
    	
    	student.setId(123L);
    	student.setName("guan");
    	return ResponseEntity.ok("收到的数据: " + student.getName());
        // 模拟处理逻辑（例如存储到数据库）
//        user.setId(1L); // 假设数据库生成的 ID

        // 返回结果给前端
//        return user;
    }
}
