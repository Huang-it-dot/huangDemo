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
	
    //UserServiceクラスを依存性注入する
	@Autowired
	private UserService service;
	// 登録画面を表示する
	@GetMapping("/login")
	public String showUserPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}	
	//登録処理する
    @PostMapping("/login")
    public String registerUser(@ModelAttribute PersonForm personForm, BindingResult result, Model model) { 	
//        if (result.hasErrors()) {
//            return "login";
//        }
    	//UserServiceを呼び出し、ユーザー情報を抽出する
      User foundUser = service.findUser(personForm.getUserId(),personForm.getPwd());
        // ユーザー情報がnullの場合	
        if (foundUser == null) {
        	model.addAttribute("error", "Invalid username or password");
            return "login"; // 登録画面に遷移する         
        } else {
            // ユーザー情報がある場合
        	model.addAttribute("user", foundUser);    
            return "myForm"; // 登录後、ユーザー詳細页面に遷移する
        }
    }
    
    // ユーザー情報処理
    @PostMapping("/processUserAction")
    public String updateUserDetails(@ModelAttribute PersonForm personForm, @RequestParam String action,Model model,RedirectAttributes redirectAttributes) {
    	
    	 if ("update".equals(action)) {
    		// ユーザー情報を更新処理
           User user = new User();
    	    	user.setId(personForm.getUserId());
    			user.setName(personForm.getName());
    			user.setMail(personForm.getMail());
    			user.setAddress(personForm.getAddress());
    			user.setAge(personForm.getAge());
    			user.setTel(personForm.getTel());  	
    	        service.updateUser(user);
    	        model.addAttribute("updateSuccess", true);
    	        return "updateResult"; //ユーザー情報を更新成功画面に遷移する
         } else if ("delete".equals(action)) {
             // ユーザー情報を削除処理
              service.deleteUser(personForm.getUserId());
              model.addAttribute("deleteSuccess", true);
              return "deleteResult"; // ユーザー情報を削除成功画面に遷移する

         }
		return null;
    }
    
    
	// ajax画面を表示する
	@GetMapping("/index")
	public String showIndexPage() {
//		model.addAttribute("user", new User());
		return "index";
	}	
}