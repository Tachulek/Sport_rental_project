package com.sport.rental.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.model.Category;
import com.sport.rental.model.Item;
import com.sport.rental.model.Reservation;
import com.sport.rental.model.Storage;
import com.sport.rental.model.User;
import com.sport.rental.repository.CategoryRepository;
import com.sport.rental.repository.ItemRepository;
import com.sport.rental.repository.ReservationRepository;
import com.sport.rental.repository.StorageRepository;
import com.sport.rental.repository.UserRepository;
import com.sport.rental.service.CategoryService;

@Controller
public class StatisticsViewController {

	@Autowired
	private StorageRepository storageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("statistics")
	public ModelAndView statsView(Model model) {

		List<User> userList = userRepository.findAll();
		List<Item> itemList = itemRepository.findAll();
		List<Reservation> reservationList = reservationRepository.findAll();
		List<Category> categoryList = categoryRepository.findAll();
		List<Storage> storageList = storageRepository.findAll();

		int income = 0;
		for(Reservation reservation : reservationList){
			income += reservation.getIncome();
		}

		model.addAttribute("userCount", userList.size());
		model.addAttribute("storageCount", storageList.size());
		model.addAttribute("itemCount", itemList.size());
		model.addAttribute("reservationCount", reservationList.size());
		model.addAttribute("categoryCount", categoryList.size());
		model.addAttribute("income", income);
		return new ModelAndView("statistics");
	}
}
