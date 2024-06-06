package donation.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import donation.entity.Donation;
import donation.entity.PaginationForm;
import donation.entity.Role;
import donation.entity.StatusDonation;
import donation.entity.User;
import donation.entity.UserDonation;
import donation.service.DonationService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DonationService donationService;

	@RequestMapping("")
	public String adminPage() {
		return "admin-page";
	}

	@RequestMapping("/listUser")
	public String listUser(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
			@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<User> users;
		Long totalUsers;
		if (keyword != null && !keyword.isEmpty()) {
			users = donationService.searchUser(keyword, pageSize, pageNumber);
			totalUsers = donationService.getTotalSearchUsers(keyword);
		} else {
			users = donationService.getUsers(pageSize, pageNumber);
			totalUsers = donationService.getTotalUser();
		}
		List<Integer> pageSizes = Arrays.asList(3, 5, 10, 15, 20);
		int numSize = pageSize;
		int firstResult = ((pageNumber - 1) * numSize) + 1;
		int lastResult = firstResult + numSize - 1;
		if (lastResult > totalUsers)
			lastResult = totalUsers.intValue();
		int totalPages = (int) Math.ceil((double) totalUsers / numSize);
		model.addAttribute("users", users);
		model.addAttribute("pagination", new PaginationForm(pageNumber, numSize));
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("numSize", numSize);
		model.addAttribute("firstResult", firstResult);
		model.addAttribute("lastResult", lastResult);
		model.addAttribute("totalUsers", totalUsers);
		model.addAttribute("keyword", keyword);
		return "user-list";
	}

	@RequestMapping("/listDonation")
	public String listDonation(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
			@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<Donation> donations;
		StatusDonation statusDonation = new StatusDonation();
		Long totalDonations;
		if (keyword != null && !keyword.isEmpty()) {
			donations = donationService.searchDonation(keyword, pageSize, pageNumber);
			totalDonations = donationService.getTotalSearchDonation(keyword);
		} else {
			donations = donationService.getDonations(pageSize, pageNumber);
			totalDonations = donationService.getTotalDonations();
		}
		List<Integer> pageSizes = Arrays.asList(3, 5, 10, 15, 20);
		int numSize = pageSize;
		int firstResult = ((pageNumber - 1) * numSize) + 1;
		int lastResult = (firstResult + numSize) - 1;
		if (lastResult > totalDonations)
			lastResult = totalDonations.intValue();
		if (firstResult > totalDonations)
			firstResult = totalDonations.intValue();
		int totalPages = (int) Math.ceil((double) totalDonations / numSize);
		model.addAttribute("donations", donations);
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("numSize", numSize);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("firstResult", firstResult);
		model.addAttribute("lastResult", lastResult);
		model.addAttribute("keyword", keyword);
		model.addAttribute("totalDonations", totalDonations);
		model.addAttribute("statusDonation", statusDonation);
		model.addAttribute("pagination", new PaginationForm(pageNumber, numSize));
		return "donation-list";
	}

	@RequestMapping("/formToAddUser")
	public String formToAddUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		List<Role> roles = donationService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("edit", false);
		return "user-form";
	}

	@RequestMapping("/formToAddDonation")
	public String formToAddDonation(Model model) {
		Donation donation = new Donation();
		model.addAttribute("donation", donation);
		model.addAttribute("edit", false);
		return "donation-form";
	}

	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user, @RequestParam("role") int roleId) {
		Role role = donationService.getRole(roleId);
		user.setRole(role);
		donationService.addOrUpdateUser(user);
		return "redirect:/admin/listUser";
	}

	@RequestMapping("/addDonation")
	public String addDonation(@ModelAttribute("donation") Donation donation) {
		donationService.addOrUpdateDonation(donation);
		return "redirect:/admin/listDonation";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		donationService.deleteUser(userId);
		return "redirect:listUser";
	}

	@RequestMapping("/deleteDonation")
	public String deleteDonation(@RequestParam("donationId") int donationId) {
		donationService.deleteDonation(donationId);
		return "redirect:listDonation";
	}

	@RequestMapping("/editForm")
	public String formToEdit(@RequestParam("userId") int userId, Model model) {
		User user = donationService.getUser(userId);
		List<Role> roles = donationService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "user-form";
	}

	@RequestMapping("/updateDonation")
	public String updateDonation(@RequestParam("donationId") int donationId, Model model) {
		Donation donation = donationService.getDonation(donationId);
		model.addAttribute("donation", donation);
		model.addAttribute("edit", true);
		return "donation-form";
	}

	@RequestMapping("/changeStatusUser")
	public String changeStatusUser(@RequestParam("userId") int userId, HttpServletRequest request) {
		User user = donationService.getUser(userId);
		if (user.getStatus() == 0) {
			user.setStatus(1);
		} else {
			user.setStatus(0);
		}
		donationService.addOrUpdateUser(user);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping("/detailUser")
	public String detailUser(@RequestParam("userId") int userId, Model model,
			@RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "keyword", required = false) String keyword) {
		User user = donationService.getUser(userId);
		List<UserDonation> userDonations;
		List<Integer> pageSizes = Arrays.asList(3, 5, 10, 15, 20);
		Long totalUserDonation;
		if (keyword != null && !keyword.isEmpty()) {
			userDonations = donationService.searchUserDonationU(userId, keyword, pageSize, pageNumber);
			totalUserDonation = donationService.getTotalSearchUserDonationU(userId, keyword);
		} else {
			userDonations = donationService.getUserDonationsU(userId, pageSize, pageNumber);
			totalUserDonation = donationService.getTotalSearchUserDonationU(userId, keyword);
		}
		int totalPages = (int) Math.ceil((double) totalUserDonation / pageSize);
		model.addAttribute("user", user);
		model.addAttribute("role", new Role());
		model.addAttribute("userDonations", userDonations);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("paginationForm", new PaginationForm(pageSize, pageNumber));
		model.addAttribute("keyword", keyword);
		return "user-detail";
	}

	@RequestMapping("/detailDonation")
	public String detailDonation(@RequestParam("donationId") int donationId, Model model,
			@RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(value = "keyword", required = false) String keyword) {
		Donation donation = donationService.getDonation(donationId);
		List<Integer> pageSizes = Arrays.asList(3, 5, 10, 15, 20);
		List<UserDonation> userDonations;
		Long totalUserDonation;
		if (keyword != null && !keyword.isEmpty()) {
			userDonations = donationService.searchUserDonationD(donationId, keyword, pageSize, pageNumber);
			totalUserDonation = donationService.getTotalSearchUserDonationD(donationId, keyword);
		} else {
			userDonations = donationService.getUserDonationsD(donationId, pageSize, pageNumber);
			totalUserDonation = donationService.getTotalUserDonations(donationId);
		}
		int totalPages = (int) Math.ceil((double) totalUserDonation / pageSize);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("donation", donation);
		model.addAttribute("userDonations", userDonations);
		model.addAttribute("pagination", new PaginationForm(pageSize, pageNumber));
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("keyword", keyword);
		return "donation-detail";
	}

	@RequestMapping("/changeStatusUD")
	public String changeStatusUserDonation(@RequestParam("udId") int udId, HttpServletRequest request) {
		UserDonation userDonation = donationService.getUserDonation(udId);
		boolean isChangedStatus = (userDonation.getStatus()==0);
		userDonation.setStatus(isChangedStatus?1:0);
		if(isChangedStatus) {
			donationService.updateDonationMoney(udId, true);
		}else {
			donationService.updateDonationMoney(udId, false);
		}
		donationService.addOrUpdateUserDonation(userDonation);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
	
	@RequestMapping("/cancelStatusUD")
	public String cancelStatusUserDonation(@RequestParam("udId") int udId, HttpServletRequest request) {
		UserDonation userDonation = donationService.getUserDonation(udId);
		userDonation.setStatus(2);
		donationService.addOrUpdateUserDonation(userDonation);
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}

	@RequestMapping("/changeStatusDonation")
	public String changeStatusDonation(@RequestParam("donationId") int donationId, HttpServletRequest request) {
		Donation donation = donationService.getDonation(donationId);
		if (donation.getStatus() == 0) {
			donation.setStatus(1);
		} else if (donation.getStatus() == 1) {
			donation.setStatus(2);
		} else if (donation.getStatus() == 2) {
			donation.setStatus(3);
		}
		donationService.addOrUpdateDonation(donation);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
}
