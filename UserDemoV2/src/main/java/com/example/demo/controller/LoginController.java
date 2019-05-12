package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/login")
	public String goToLoginPage() {
		System.out.println("Login controller");
		
		
		return "index";
	}

	
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public String validateUser(Model model,@RequestParam("username")String username,@RequestParam("password")String password) {
		
		UserDto userDto = loginService.getUserByUsernameAndPassword(username,password);
		
		
		if(userDto == null) {
			return "redirect:login?msg= Wrong Username and Password"; 
		}else {
			List<UserDto> userDtos = loginService.findAllUsers();
			
			UserDto formDto = new UserDto();
			
			model.addAttribute("formDto", formDto);
			model.addAttribute("userDtoList", userDtos);
			
			
			return "dashboard"; // 
		}
		
		
	}
	
	
}