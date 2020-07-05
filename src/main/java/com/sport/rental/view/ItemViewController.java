package com.sport.rental.view;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.model.Item;
import com.sport.rental.repository.StorageRepository;
import com.sport.rental.service.CategoryService;
import com.sport.rental.service.ItemService;
import com.sport.rental.service.StorageService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
public class ItemViewController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("items")
	public ModelAndView itemsView(Model model, Integer categoryId) {
		List<Item> itemsList = itemService.getAllFreeItems(categoryId);
		model.addAttribute("itemsList", itemsList);
		return new ModelAndView("items");
	}

	@GetMapping("addItem")
	public ModelAndView addItemView(Model model, Integer categoryId) {
		model.addAttribute("categoryId", categoryId);
		return new ModelAndView("addItem");
	}

	@PostMapping("addItem")
	public String addItemView(Model model, Integer categoryId, String name, String description, Integer price, String imageUrl) {
		Item item = new Item(null, name, description, price, imageUrl, true, categoryService.getCategory(categoryId),
				storageService.getStorage(1),
				Collections.emptyList(), Collections.emptyList());

		itemService.saveItem(item);

		model.addAttribute("messageType", "info");
		model.addAttribute("message",
				"Urządzenie zostało dodane");
		return "home";
	}

	@PostMapping("removeItem")
	public String removeItemView(Model model, Integer itemId) {
		itemService.removeItem(itemId);
		model.addAttribute("messageType", "info");
		model.addAttribute("message",
				"Urządzenie zostało usunięte");
		return "home";
	}
}