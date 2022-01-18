package com.salesianostriana.dam.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateUserDto {
	
	private String username;
	private String avatar;
	private String fullname;
	private String email;
	private String password;
	private String password2;

}
