package com.huang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	private UserMapper map;

	public DemoController(UserMapper map) {
		this.map = map;
	}

	// 初期化
	@GetMapping("/set")
	public String showForm(PersonForm personForm, Model model) {
		return "form";
	}

	// 入力項目チェック
	@PostMapping("/set")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		//UserIdでuser数
		User user = service.selectUser(personForm.getUserId(),personForm.getPwd());
		if(user.equals(null)) {
		return "/results";
		}	
//		model.addAttribute("user", user);
		//確認画面に遷移
		return "/myForm";
	}
	// 入力項目チェック
	@PostMapping("/updateUser")
	public String updatePersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {
//		//UserIdでuser情報取得
//		User user = service.selectUser(personForm.getUserId());
//
//		model.addAttribute("user", user);

//		return "/results";
		//確認画面に遷移
		return "/results";
	}
	
	//11_11セキュリティー登録ページ
	@GetMapping("/login")
	public String showLoginPage() {
	    return "login";
	}	
	//11_11セキュリティー登録後、詳細画面
	@GetMapping("/home")
	public String showForm2(Model model) {	
		List<User> userInfo =service.selectAllUser();  
		   model.addAttribute("users", userInfo);
		return "home";
	}
    //11_11
	@GetMapping("/test")
	public String selectTest() {
		User user = service.selectUser("huang001", "1023");      
	System.out.println(user.getAddress());
	    return "login";
	}
	//11_12登録ページ
	@GetMapping("/signIn")
	public String showSignInPage(PersonForm personForm, Model model) {
	    return "signIn";
	}	
	
	
	
	
	
}