package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.model.Login;

public interface ILoginService {


	APIResponse findByUserNameAndPassword(LoginDTO loginDTO);
	//SignUp
		APIResponse signUp(Login SignUpRequestDTO);
		//Login
		APIResponse login(LoginDTO login);
}
