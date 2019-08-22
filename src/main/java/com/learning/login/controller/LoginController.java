package com.learning.login.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value={"/login"})
public class LoginController {
	@RequestMapping(method = RequestMethod.POST, headers="Accept=application/json")
	public Map<String,String> authenticateUser(@RequestBody Object obj){
		HashMap<String,String> userCred = new HashMap<String,String>();
		userCred = (HashMap<String,String>)obj;
		String username = userCred.get("username");
		String password = userCred.get("password");
		String usernames[] = {"shebeen","user","admin","user1","guest"};
		String passwords[] = {"123456","admin","password","password123","abc123"};
		HashMap<String,String> response= new HashMap<String,String>();
		if(Arrays.asList(usernames).contains(username) &&
				Arrays.asList(passwords).contains(password)) {
			response.put("response","Welcome "+username);
		}
		else{
			response.put("response", "failed");
		}
		return response;
	}
}
