package com.manty.BlogAppAPIs.Payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
private int id;
	@NotEmpty
	@Size(min=4,message="Username Mustbe min of 4 Characters ")
	private String name;
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10,message="Password Mustbe min of 3 Characters and Must be 10 Characters")
	private String password;
	@NotEmpty
	private String about;
}
