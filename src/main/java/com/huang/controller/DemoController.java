package com.huang.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.huang.Form.MyForm;
import com.huang.Model.User;


import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class DemoController implements WebMvcConfigurer{
	
@GetMapping("/")
//	@ResponseBody
	public String firstMethod(Model model) {
		model.addAttribute("name", "yuyu");
		return "Demo";
		
//		User user = userService.getUserById(1);
//		model.addAttribute("user", user);
//        return "UserResult";
	}

}
