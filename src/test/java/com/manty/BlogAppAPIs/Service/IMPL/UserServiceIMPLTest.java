package com.manty.BlogAppAPIs.Service.IMPL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.manty.BlogAppAPIs.Entity.User;
import com.manty.BlogAppAPIs.Repository.UserRepository;

class UserServiceIMPLTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceIMPL userServiceIMPL;
	
	@Test
	public void testgetAllUser() {
		List<User> myUser=new ArrayList<User>();
		myUser.add(new User(10,"Namita","deyNamita4512","gfhdsf","SoftwareEngeneer"));
		myUser.add(new User(12,"Balia","senBalia4512","jyt6j","Painter"));
		
		when(userRepository.findAll()).thenReturn(myUser);
		int actual = userServiceIMPL.getAllUser().size();
		assertEquals(2, actual);
		
	}
}
