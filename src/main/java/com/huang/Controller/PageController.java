package com.huang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    // href="/"で画面遷移
	//index.htmlに遷移
    @GetMapping("/")
    public String index() {
        return "hello"; 
    }

    //success.htmlに遷移
    @PostMapping("/submit")
    public String submitForm() {
        return "success"; 
    }
    // window.location.href で画面遷移（HTMLにJavaScriptをインポートする）
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
