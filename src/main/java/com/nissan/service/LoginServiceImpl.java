package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.dao.LoginDao;
import com.nissan.dao.UserDao;
import com.nissan.model.Login;
import com.nissan.repo.LoginDTO;
import com.nissan.util.JwtUtils;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	// for login credentials - password, username
	@Autowired
	private LoginDao loginDao;
	
	// for user registration - name, adress
	@Autowired
	private UserDao userDao;
	
	private LoginDTO loginDTO;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public APIResponse findByUserNameAndPassword(LoginDTO loginDTO) {
		APIResponse apiResponse = new APIResponse();

		// verify user exist with given email and password
		Login userLogin = loginDao.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

		// response
		if (userLogin == null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("User login failed!!!");
		} else {
			// Storing more details
			Map<String, Object> data = new HashMap<>();
			data.put("UserType", userLogin.getUt_id());
			data.put("Username", userLogin.getUsername());
			apiResponse.setData(data);
		}
		return apiResponse;

	}
	
	@Override
	public APIResponse signUp(Login UserDTO) {
		APIResponse apiResponse = new APIResponse();
		//Save to Entity ---ORM --Database
		loginDao.save(UserDTO);
//		Login login = new Login();
		//generate token
		
		String token = jwtUtils.generateJwt(UserDTO);
		
		//Store more details
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);
		data.put("UserType", UserDTO.getUserType());
		data.put("UserName", UserDTO.getUsername());
		
		apiResponse.setData(data);
		return apiResponse;
	}

	@Override
	public APIResponse login(LoginDTO login) {
		APIResponse apiResponse = new APIResponse();
		Login user=loginDao.findByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword());  // avoided either use Autowired --- anonymous

        if(user==null) {
            apiResponse.setData("User login failed");
            return apiResponse;
        }
        	//genrate token
      		String token = jwtUtils.generateJwt(user);
      		
      		//Store more details
      		Map<String, Object> data = new HashMap<>();
      		data.put("accessToken", token);
      		data.put("UserType", user.userType.getUserType());
    		data.put("UserName", user.getUsername());
      		
      		apiResponse.setData(data);
      		return apiResponse;
	}

}
