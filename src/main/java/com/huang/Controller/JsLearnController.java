package com.huang.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.huang.Form.PersonForm;
import com.huang.Model.User;
import com.huang.Service.UserService;

@Controller
public class JsLearnController {
    // href="/"で画面遷移
	//index.htmlに遷移
    @GetMapping("/weather")
    public String showWeather() {
        return "weather"; 
    }
}
