package com.sport.rental.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.rental.model.User;
import com.sport.rental.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public boolean login(String email, String password, HttpServletRequest req) {
		if (userRepository.findByEmail(email).isPresent()) {
			User user = userRepository.findByEmail(email).get();
			String myPassword = DigestUtils.md5Hex(password).toUpperCase();
			if (user.getPassword().equals(myPassword)) {
				req.getSession().setAttribute("email", user.getEmail());
				req.getSession().setAttribute("role", String.valueOf(user.getRole()));
				return true;
			}
		}
		return false;
	}

	public User sessionUser(HttpServletRequest req) {
		String email = (String) req.getSession().getAttribute("email");
		return userRepository.findByEmail(email).get();
	}
}