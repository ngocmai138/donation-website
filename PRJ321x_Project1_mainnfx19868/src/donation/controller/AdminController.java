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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String listUser(Model model) {
		List<User> users = donationService.getUsers();
		List<Role> roles = donationService.getRoles();
		model.addAttribute("roles",roles);
		model.addAttribute("users", users);
		return "user-list";
	}

	@RequestMapping("/listDonation")
	public String listDonation(Model model) {
		List<Donation> donations = donationService.getDonations();
		StatusDonation statusDonation = new StatusDonation();
		model.addAttribute("donations", donations);
		model.addAttribute("statusDonation", statusDonation);
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
	public String addUser(@ModelAttribute("user") User user, 
							@RequestParam("role") int roleId, 
							HttpServletRequest request,
							RedirectAttributes redirectAttributes) {
		Role role = donationService.getRole(roleId);
		user.setRole(role);
		donationService.addOrUpdateUser(user);
		String referer = request.getHeader("Referer");
		redirectAttributes.addFlashAttribute("message","Thành công");
		return "redirect:"+referer;
	}

	@RequestMapping("/addDonation")
	public String addDonation(@ModelAttribute("donation") Donation donation, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("DDDDDDDDDDDDDonation id: " +donation.getId());
		donationService.addOrUpdateDonation(donation);
		String referer = request.getHeader("Referer");
		redirectAttributes.addFlashAttribute("message","Thành công");
		return "redirect:"+referer;
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId, RedirectAttributes redirectAttributes) {
		donationService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("message","Xóa thành công");
		return "redirect:listUser";
	}

	@RequestMapping("/deleteDonation")
	public String deleteDonation(@RequestParam("donationId") int donationId, 
									RedirectAttributes redirectAttributes,
									HttpServletRequest request) {
		donationService.deleteDonation(donationId);
		redirectAttributes.addFlashAttribute("message","Xóa thành công");
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
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
	public String changeStatusUser(@RequestParam("userId") int userId, 
										HttpServletRequest request) {
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
		StatusDonation statusDonation = new StatusDonation();
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
		model.addAttribute("statusDonation",statusDonation);
		model.addAttribute("keyword", keyword);
		return "donation-detail";
	}

	@RequestMapping("/changeStatusUD")
	public String changeStatusUserDonation(@RequestParam("udId") int udId, 
												HttpServletRequest request,
												RedirectAttributes redirectAttributes) {
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
		redirectAttributes.addFlashAttribute("message","Thành công");
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
