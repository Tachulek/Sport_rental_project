package com.sport.rental.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.model.User;
import com.sport.rental.repository.UserRepository;

@Controller
public class UserViewController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("user")
	public ModelAndView userView(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		return new ModelAndView("user");
	}

	@PostMapping("userRemove")
	public String removeUser(Integer userId, Model model) {
		List<User> userList = userRepository.findAllById(userId);

		for(User user : userList){
			userRepository.delete(user);
		}

		model.addAttribute("messageType", "info");
		model.addAttribute("message", "Użytkownik został usunięty");
		return "home";
	}
}