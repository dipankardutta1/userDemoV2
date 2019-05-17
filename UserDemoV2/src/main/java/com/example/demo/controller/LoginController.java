package com.example.demo.controller;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
	/*@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public String validateUser(Model model,HttpSession httpSession,@RequestParam("username")String username,@RequestParam("password")String password) {
		
		UserDto userDto = loginService.getUserByUsernameAndPassword(username,password);
		
		
		if(userDto == null) {
			return "redirect:login?msg= Wrong Username and Password"; 
		}else {
			List<UserDto> userDtos = loginService.findAllUsers();
			
			UserDto formDto = new UserDto();
			
			model.addAttribute("formDto", formDto);
			model.addAttribute("userDtoList", userDtos);
			
			httpSession.setAttribute("loginUser", userDto);
			return "dashboard"; // 
		}
		
		
	}*/
	
	
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String validateUser(Model model,HttpSession session,Principal principal) {
		
		
		
		UserDto userDto = loginService.findUserByUsername(principal.getName());
		
		List<UserDto> userDtos = loginService.findAllUsers();
			
		UserDto formDto = new UserDto();
		
		model.addAttribute("formDto", formDto);
		model.addAttribute("userDtoList", userDtos);
		
		session.setAttribute("loginUser", userDto);
			
			
		return "dashboard";
		
		
		
	}
	
	/*@RequestMapping(value="/logout")
	public String logout(HttpSession httpSession) {
		System.out.println("logout controller");
		
		httpSession.invalidate();
		
		return "redirect:login?msg= Logout Successful"; 
	}*/
	
	
}
