package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDto getUserByUsernameAndPassword(String username, String password) {
		
		User user = userRepository.findByUsernameAndPassword(username,password);
		
		if(user == null) {
			return null;
		}else {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			return userDto;
		}
		
		
		
		
	}

	public List<UserDto> findAllUsers() {
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		List<User> users = userRepository.findAll();
		
		for(User user:users) {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			userDtos.add(userDto);
		}
		return userDtos;
	}

	public void insert(UserDto userDto) {
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		
		/*if(user.getId() == null) {
			userRepository.save(user);
		}else {
			userRepository.save(user);
		}*/
		
		
		userRepository.save(user);
		
		
		
	}

	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}

	public UserDto findUserById(Integer id) {
		User user =  userRepository.getOne(id);
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
		
	}
	
	

}
