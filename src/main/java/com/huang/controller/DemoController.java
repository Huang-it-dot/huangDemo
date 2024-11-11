package com.huang.controller;

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
	@GetMapping("/")
	public String showForm(PersonForm personForm, Model model) {
		return "form";
	}

	// 入力項目チェック
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		//UserIdでuser情報取得
		User user = service.selectUser(personForm.getUserId());

		model.addAttribute("user", user);

//		return "/results";
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

	@GetMapping("/results")
	public String showForm2() {

		return "results2";
	}

}