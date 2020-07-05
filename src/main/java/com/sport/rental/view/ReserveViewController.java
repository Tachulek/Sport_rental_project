package com.sport.rental.view;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sport.rental.model.Item;
import com.sport.rental.model.Reservation;
import com.sport.rental.model.User;
import com.sport.rental.repository.ReservationRepository;
import com.sport.rental.service.ItemService;
import com.sport.rental.service.LoginService;


@Controller
public class ReserveViewController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping("reserve")
	public ModelAndView reserveList(HttpServletRequest req, Model model) {
		User user = loginService.sessionUser(req);
		model.addAttribute("reserveList", reservationRepository.findAllByUserAndEndDate(user, null));
		return new ModelAndView("reserve");
	}

	@GetMapping("reserveCancel")
	public ModelAndView reserveListRemove(HttpServletRequest req, Model model) {
		model.addAttribute("reserveList", reservationRepository.findAll());
		return new ModelAndView("reserveCancel");
	}

	@PostMapping("reserve")
	public String reserve(Integer itemId, HttpServletRequest req, Model model) {
		User user = loginService.sessionUser(req);

		Item item = itemService.updateItemStatus(itemId, false);
		Reservation reservation = new Reservation(null, LocalDate.now(), null, 0, user, item);
		reservationRepository.save(reservation);

		model.addAttribute("messageType", "info");
		model.addAttribute("message",
				"Urządzenie zostało zarezerwowane dla: " + user.getFirstName() + " " + user.getLastName());
		return "home";
	}

	@PostMapping("reserveRemove")
	public String reserveRemove(Integer reserveId, Integer itemId, Model model) {

		Item item = itemService.updateItemStatus(itemId, true);
		Reservation reservation = reservationRepository.findAllById(reserveId);
		reservation.setEndDate(LocalDate.now());
		int daysBetween = (int) (DAYS.between(reservation.getStartDate(), reservation.getEndDate()) + 1);
		reservation.setIncome(Integer.valueOf(daysBetween) * item.getPrice());
		reservationRepository.save(reservation);

		model.addAttribute("messageType", "info");
		model.addAttribute("message",
				"Sprzęt został oddany, do kasy należy wpłacić " + reservation.getIncome() + " zł");
		return "home";
	}

	@PostMapping("reserveCancel")
	public String reserveCancel(Integer reserveId, Model model) {
		Reservation reservation = reservationRepository.findAllById(reserveId);
		reservationRepository.delete(reservation);
		itemService.updateItemStatus(reservation.getItem().getId(), true);

		model.addAttribute("messageType", "info");
		model.addAttribute("message", "Rezerwacja została anulowana");
		return "home";
	}

	@GetMapping("reserveHistory")
	public ModelAndView reserveRemove(HttpServletRequest req, Model model) {
		User user = loginService.sessionUser(req);
		model.addAttribute("reserveList", reservationRepository.findAllByUser(user));
		return new ModelAndView("reserveHistory");
	}
}