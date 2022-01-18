package com.salesianostriana.dam.users.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.salesianostriana.dam.errores.excepciones.NewUserWithDifferentPasswordsException;
import com.salesianostriana.dam.service.base.BaseService;
import com.salesianostriana.dam.users.dto.CreateUserDto;
import com.salesianostriana.dam.users.model.UserRole;
import com.salesianostriana.dam.users.repos.UserEntityRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.salesianostriana.dam.users.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

	private final PasswordEncoder passwordEncoder;

	/**
	 * Nos permite buscar un usuario por su nombre de usuario
	 * 
	 * @param username
	 * @return
	 */
	public Optional<UserEntity> findUserByUsername(String username) {
		return this.repositorio.findByUsername(username);
	}

	/**
	 * Nos permite crear un nuevo UserEntity con rol USER
	 * 
	 * @param newUser
	 * @return
	 */
	public UserEntity nuevoUsuario(CreateUserDto newUser) {

		if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
			UserEntity userEntity = UserEntity.builder().username(newUser.getUsername())
					.password(passwordEncoder.encode(newUser.getPassword())).avatar(newUser.getAvatar())
					.fullName(newUser.getFullname()).email(newUser.getEmail())
					.roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();
			try {
				return save(userEntity);
			} catch (DataIntegrityViolationException ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
			}
		} else {
			throw new NewUserWithDifferentPasswordsException();
		}

	}

}
