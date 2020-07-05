package com.sport.rental.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.service.RegisterService;


@Controller
public class RegisterViewController {

	@Autowired
	private RegisterService registerService;

	@GetMapping("register")
	public ModelAndView registerView() {
		return new ModelAndView("register");
	}

	@PostMapping("register")
	public String register(String firstName, String lastName, String email, String password1, String password2,
	                       Model model) {
        if (registerService.register(firstName, lastName, email, password1, password2)) {
            return "redirect:login";
        }

		model.addAttribute("messageType", "danger");
		model.addAttribute("message", "Podano złe dane wejściowe");
		return "register";
	}
}
