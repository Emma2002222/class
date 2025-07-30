package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.UserService;


//在WEB-INF資料夾裡的JSP檔，只能用controller新增
//在網址上打名稱時要打http://localhost:8080/2_springMVC/login，不能打http://localhost:8080/2_springMVC/login.jsp
@Controller
public class UserController {
	
	@Autowired //要用spring 管理 需要有元件(?
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username")/*對應到index的username*/ String username, @RequestParam("password")/*對應到index的password*/ String password) {
		// "/WEB-INF/views/login.jsp" 
		
		System.out.println(username);
		System.out.println(password);
		/*if ("aaa".equals(username) && "111".equals(password)) {
			return "loginSuccess";
		} else {
			return "loginFail";
		}
		
	}*/
		
		if (userService.checkLogin(username,password)) {
			return "loginSuccess";
		} else {
			return "loginFail";
		}
		
	}
}
