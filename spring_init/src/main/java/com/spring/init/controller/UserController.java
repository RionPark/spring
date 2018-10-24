package com.spring.init.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.init.vo.UserInfoVO;

@Controller
public class UserController {
	
	@PostMapping(value="/login")
	public String login(@Valid UserInfoVO ui, HttpSession hs) {
		hs.setAttribute("userInfo", ui);
		return "ws/bs-test";
	}
}
