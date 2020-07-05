package com.sport.rental.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.service.CategoryService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
public class HomeViewController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("home")
	public ModelAndView homeView(HttpServletRequest req, Model model) {
		model.addAttribute("categoryList", categoryService.getAllCategories());
		return new ModelAndView("home");
	}
}