package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Login;
import com.nissan.repo.LoginDTO;
import com.nissan.repo.UserDTO;
//import com.nissan.repo.UserDetailsDTO;
import com.nissan.service.ILoginService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class LoginController {

//	@Autowired
//	private IUserService userService;
	@Autowired
	private ILoginService loginService;
	@PostMapping("signup")
	public ResponseEntity<APIResponse> signUp(@RequestBody Login signUpRequestDTO){
		APIResponse apiResponse = loginService.signUp(signUpRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@PostMapping("login")
	public ResponseEntity<APIResponse> login(@RequestBody LoginDTO loginDTO) {
		APIResponse apiResponse = loginService.findByUserNameAndPassword(loginDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
}
