package com.salesianostriana.dam.users.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class GetUserDto {
	
	private String username;
	private String avatar;
	private String fullName;
	private String email;
	private Set<String> roles;
	
	

}
