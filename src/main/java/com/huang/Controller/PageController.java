package com.huang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    // href="/"跳转页面
	//访问根路径时跳转到 index.html
    @GetMapping("/")
    public String index() {
        return "hello"; // 返回视图名称 "index" -> src/main/resources/templates/hello.html
    }

    // 表单提交后跳转到 success.html
    @PostMapping("/submit")
    public String submitForm() {
        return "success"; // 返回视图名称 "success" -> src/main/resources/templates/success.html
    }
    // window.location.href = "/success";跳转页面
    @GetMapping("/success")
    public String showSuccessPage() {
        // 返回视图名称，对应的模板文件为 src/main/resources/templates/success.html
        return "success";
    }
}
