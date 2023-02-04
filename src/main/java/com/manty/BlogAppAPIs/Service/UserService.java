package com.manty.BlogAppAPIs.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manty.BlogAppAPIs.Payload.UserDto;
@Service
public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUserDto(Integer userId);
}
