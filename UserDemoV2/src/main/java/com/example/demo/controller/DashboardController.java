package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class DashboardController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/processUserDetails",method=RequestMethod.POST)
	public String processUserDetails(Model model,@ModelAttribute("formDto") UserDto userDto) {
		
		
		// insert
		loginService.insert(userDto);
		
		List<UserDto> userDtos = loginService.findAllUsers();
		model.addAttribute("userDtoList", userDtos);
		
		return "dashboard";
		
	}
}
