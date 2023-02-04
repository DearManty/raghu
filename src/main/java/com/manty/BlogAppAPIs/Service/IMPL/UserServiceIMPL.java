package com.manty.BlogAppAPIs.Service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manty.BlogAppAPIs.Entity.User;
import com.manty.BlogAppAPIs.Exception.ResourceNotFoundException;
import com.manty.BlogAppAPIs.Payload.UserDto;
import com.manty.BlogAppAPIs.Repository.UserRepository;
import com.manty.BlogAppAPIs.Service.UserService;

@Service
public class UserServiceIMPL implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUSER(userDto);
		User saveduser = userRepository.save(user);
		return this.UserToUserDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Data Not Found On Service"+userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepository.save(user);
		UserDto userDto2 = this.UserToUserDto(updatedUser);
		return userDto2;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Data Not Found On Server"+userId));
		return this.UserToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> findAll = userRepository.findAll();
		List<UserDto> listofUserDto = findAll.stream().map(user -> this.UserToUserDto(user))
				.collect(Collectors.toList());
		return listofUserDto;
	}

	@Override
	public void deleteUserDto(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Data Not Found On Server"+userId));
		this.userRepository.delete(user);
	}

	public User userDtoToUSER(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		/*
		 * User user = new User(); user.setId(userDto.getId());
		 * user.setName(userDto.getName()); user.setEmail(userDto.getEmail());
		 * user.setPassword(userDto.getPassword()); user.setAbout(userDto.getAbout());
		 */
		return user;

	}

	public UserDto UserToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		/*
		 * UserDto userDto = new UserDto(); userDto.setId(user.getId());
		 * userDto.setName(user.getName()); userDto.setEmail(user.getEmail());
		 * userDto.setPassword(user.getPassword()); userDto.setAbout(user.getAbout());
		 */
		return userDto;
	}
}
