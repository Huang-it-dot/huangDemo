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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("user", new User());
		return "login";
	}	
	//登録処理
    @PostMapping("/login")
    public String registerUser(@ModelAttribute PersonForm personForm, BindingResult result, Model model) { 	
        if (result.hasErrors()) {
            return "login";
        }
      User foundUser = service.findUser(personForm.getUserId(),personForm.getPwd());

        if (foundUser == null) {
            // 用户不存在	
        	model.addAttribute("error", "Invalid username or password");
            return "login"; // 跳转到登録页面         
        } else {
            // 用户存在且密码匹配
        	model.addAttribute("user", foundUser);    
            return "myForm"; // 登录成功后跳转到成功页面
        }
    }
    
    // 处理用户更新请求
    @PostMapping("/processUserAction")
    public String updateUserDetails(@ModelAttribute PersonForm personForm, @RequestParam String action,Model model,RedirectAttributes redirectAttributes) {
    	
    	 if ("update".equals(action)) {
             // 执行更新操作
           User user = new User();
    	    	user.setId(personForm.getUserId());
    			user.setName(personForm.getName());
    			user.setMail(personForm.getMail());
    			user.setAddress(personForm.getAddress());
    			user.setAge(personForm.getAge());
    			user.setTel(personForm.getTel());  	
    	        service.updateUser(user);
    	        model.addAttribute("updateSuccess", true);
    	        return "updateResult"; // 返回带有 JavaScript 弹窗的页面
         } else if ("delete".equals(action)) {
             // 执行删除操作
              service.deleteUser(personForm.getUserId());
              model.addAttribute("deleteSuccess", true);
              return "deleteResult"; // 返回带有 JavaScript 弹窗的页面

         }
		return null;
    }
}