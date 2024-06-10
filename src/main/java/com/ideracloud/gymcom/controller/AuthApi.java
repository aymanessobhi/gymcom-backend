package com.ideracloud.gymcom.controller;


import com.ideracloud.gymcom.domain.User;
import com.ideracloud.gymcom.dto.*;
import com.ideracloud.gymcom.exception.BadRequestException;
import com.ideracloud.gymcom.exception.ResourceUtil;
import com.ideracloud.gymcom.repository.UserRepository;
import com.ideracloud.gymcom.security.TokenProvider;
import com.ideracloud.gymcom.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@Slf4j
public class AuthApi {

	@Autowired
	TokenProvider jwtUtil;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;


	@GetMapping("/list")
	public ApiResponse<List<UserDto>> listUsers() {
		return ApiResponse.ok(userService.listUsers());
	}

	@GetMapping("/{id}")
	public ApiResponse<UserDto> getUserById(@PathVariable Long id) {
		return ApiResponse.ok(userService.findUserById(id));
	}

	@PostMapping("/signin")
	public ApiResponse<UserDto> signIn(@RequestBody @Valid UserDto dto, BindingResult result) {
		try{
			return ApiResponse.ok(HttpStatus.CREATED, userService.save(dto));
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			throw new BadRequestException(result, ResourceUtil.getMessage("Invalid request"));
		}
	}

	@PutMapping("/updateU")
	public ApiResponse<UserDto> updateUser(@RequestBody @Valid UserDto dto) {
		return ApiResponse.ok(userService.updateUser(dto));
	}

	@PostMapping({"searchU"})
	public ApiResponse<Pager<UserDto>> searchUser(@RequestBody SearchRequest<UserSearchDto> dto) {
		return ApiResponse.ok(userService.searchUser(dto));
	}
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
		try {
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken( request.getUsername(), request.getPassword() )
			);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtUtil.generateToken(authentication);
			final String userName = request.getUsername();
			User usr = userRepository.findByUsername(userName).orElse(null);
			AuthResponse response = new AuthResponse(userName,token, usr.getEmail());
			return ResponseEntity.ok(response);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto user) {
		return ResponseEntity.ok(userService.save(user));
	}
}
