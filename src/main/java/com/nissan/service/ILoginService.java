package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.model.Login;
import com.nissan.repo.LoginDTO;
import com.nissan.repo.UserDetailsDTO;
import com.nissan.repo.UserDTO;

public interface ILoginService {

	APIResponse findByUserNameAndPassword(LoginDTO loginDTO);
	//SignUp
		APIResponse signUp(Login SignUpRequestDTO);
		//Login
		APIResponse login(LoginDTO login);
}
