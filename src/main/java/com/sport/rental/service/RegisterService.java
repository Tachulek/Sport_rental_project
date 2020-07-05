package com.sport.rental.service;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.rental.model.User;
import com.sport.rental.repository.UserRepository;

@Service
public class RegisterService {

	@Autowired
	private UserRepository userRepository;

	public boolean register(String firstName, String lastName, String email, String password1, String password2) {
		if (checkForExist(email) && confirmPassword(password1, password2)) {
			userRepository
					.save(new User(null, firstName, lastName, email, DigestUtils
							.md5Hex(password1).toUpperCase(), 2,
							new ArrayList<>(),
							new ArrayList<>()));
			return true;
		}
		return false;
	}

	public boolean confirmPassword(String password, String password2) {
		return password.equals(password2);
	}

	public boolean checkForExist(String email) {
		return !userRepository.findByEmail(email).isPresent();
	}
}