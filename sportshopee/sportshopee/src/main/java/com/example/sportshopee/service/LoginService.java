package com.example.sportshopee.service;

import com.example.sportshopee.entity.Login;

public interface LoginService {
		Login login(Login login);
		
		Login logout(String email);
		
		String changePassword(String email, String newPassword);

	}

