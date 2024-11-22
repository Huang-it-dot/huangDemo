package com.huang;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.huang.Controller.DemoController;
import com.huang.Model.User;
import com.huang.Service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {

	 @Autowired
	    private MockMvc mockMvc;
	 @MockBean  // 模拟 UserService，避免真正依赖
	    private UserService userService;

	   // 测试GET请求，查看注册页面
	    @Test
	    public void showUserPage() throws Exception {
	        // 模拟访问 /login 页面的 GET 请求
	        mockMvc.perform(get("/login"))
	                .andExpect(status().isOk())  // 返回200状态，表示请求成功
	                .andExpect(view().name("login"))  // 返回的视图应该是 "login"
	                .andExpect(model().attributeExists("user"));  // 确保 model 中存在 "user" 属性
	    }
}
