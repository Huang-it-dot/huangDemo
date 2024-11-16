package com.huang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.huang.Form.PersonForm;
import com.huang.Mapper.UserMapper;
import com.huang.Model.User;
import com.huang.Service.UserService;

import jakarta.validation.Valid;

@Controller
public class DemoController {
	

	@Autowired
	private UserService service;
	// 登録画面表示
	@GetMapping("/login")
	public String showUserPage(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "login";
	}	
	//登録処理
    @PostMapping("/login")
    public String registerUser(@ModelAttribute PersonForm personForm, BindingResult result, Model model) { 	
        if (result.hasErrors()) {
            return "login";
        }
      User foundUser = service.findUser(personForm.getUserId(),personForm.getPwd());

        if (foundUser != null) {
            // 用户存在且密码匹配
            model.addAttribute("message", "Login successful!");
            return "myForm"; // 登录成功后跳转到成功页面
        } else {
            // 用户不存在或密码错误
            model.addAttribute("error", "Invalid username or password");
            return "login"; // 返回登录页面并显示错误
        }
    }
//	// 入力項目チェック
//	@PostMapping("/updateUser")
//	public String updatePersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {
////		//UserIdでuser情報取得
////		User user = service.selectUser(personForm.getUserId());
////
////		model.addAttribute("user", user);
//
////		return "/results";
//		//確認画面に遷移
//		return "/results";
//	}
	
//	//セキュリティーより遷移した画面
//	@GetMapping("/home")
//	public String showForm2(Model model) {
//		
//		List<User> userInfo =service.selectAllUser();  
//		   model.addAttribute("users", userInfo);
//		return "home";
//	}	
}