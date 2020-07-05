package com.sport.rental.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.service.LoginService;


@Controller
public class LoginViewController {

	@Autowired
	private LoginService loginService;

	@GetMapping("login")
	public ModelAndView loginView() {
		return new ModelAndView("login");
	}

	@PostMapping("login")
	public String login(String email, String password, HttpServletRequest req, Model model) {
		if (loginService.login(email, password, req)) {
			return "redirect:home";
		}

		model.addAttribute("messageType", "danger");
		model.addAttribute("message", "Podano nieprawidłowe dane logowania");
		return "login";
	}
}