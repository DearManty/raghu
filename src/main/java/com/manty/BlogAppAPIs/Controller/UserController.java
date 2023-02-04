package com.manty.BlogAppAPIs.Controller;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manty.BlogAppAPIs.Helper.Constant;
import com.manty.BlogAppAPIs.Payload.UserDto;
import com.manty.BlogAppAPIs.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		logger.info("Intiating request for save user");
		UserDto createUser = this.userService.createUser(userDto);
		logger.info("Completed request for save user");
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);

	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.CREATED);

	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@Valid @PathVariable Integer userId) {
		UserDto userById = this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userById, HttpStatus.OK);

	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> allUser = this.userService.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable Integer userId) {

		this.userService.deleteUserDto(userId);

		return new ResponseEntity<String>(Constant.USER_DELETE, HttpStatus.OK);
	}

}
