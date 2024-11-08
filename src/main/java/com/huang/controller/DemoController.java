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

import jakarta.validation.Valid;

@Controller
public class DemoController {

	private UserMapper map;

	public DemoController(UserMapper map) {

		this.map = map;

	}

	@GetMapping("/")
	public String showForm(PersonForm personForm, Model model) {
		return "form";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult,Model model) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		User user = new User();
		user.setAge(2);
		user.setName("wang");
		model.addAttribute("user", user);
		
//		return "redirect:/results";
		return "/results";
	}

	@GetMapping("/results")
	public String showForm2() {

		return "results2";
	}


}