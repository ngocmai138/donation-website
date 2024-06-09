package donation.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import donation.entity.Donation;
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
	public String listUser(Model model,	RedirectAttributes redirectAttributes) {
		List<User> users = donationService.getUsers();
		List<Role> roles = donationService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("users", users);
		redirectAttributes.addFlashAttribute("message","Thành công");
		return "user-list";
	}

	@RequestMapping("/listDonation")
	public String listDonation( Model model, RedirectAttributes redirectAttributes) {
		List<Donation> donations = donationService.getDonations();
		StatusDonation statusDonation = new StatusDonation();
		model.addAttribute("donations", donations);
		model.addAttribute("statusDonation", statusDonation);
		redirectAttributes.addFlashAttribute("message","Thành công");
		return "donation-list";
	}

	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user, @RequestParam("role") int roleId, 
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
		donationService.addOrUpdateDonation(donation);
		String referer = request.getHeader("Referer");
		redirectAttributes.addFlashAttribute("message","Thành công");
		return "redirect:"+referer;
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId, 
								HttpServletRequest request,
								RedirectAttributes redirectAttributes) {
		donationService.deleteUser(userId);
		String referer = request.getHeader("Referer");
		redirectAttributes.addFlashAttribute("message","Xóa người dùng thành công");
		return "redirect:"+referer;
	}

	@RequestMapping("/deleteDonation")
	public String deleteDonation(@RequestParam("donationId") int donationId) {
		donationService.deleteDonation(donationId);
		return "redirect:listDonation";
	}
	@RequestMapping("/changeStatusUser")
	public String changeStatusUser(@RequestParam("userId") int userId, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		User user = donationService.getUser(userId);
		if (user.getStatus() == 0) {
			user.setStatus(1);
		} else {
			user.setStatus(0);
		}
		donationService.addOrUpdateUser(user);
		String referer = request.getHeader("Referer");
		redirectAttributes.addFlashAttribute("message","Đổi trạng thái người dùng thành công");
		return "redirect:" + referer;
	}

	@RequestMapping("/detailDonation")
	public String detailDonation(@RequestParam("donationId") int donationId, Model model) {
		Donation donation = donationService.getDonation(donationId);
		List<UserDonation> userDonations = donationService.getUserDonations(donationId);
		StatusDonation statusDonation = new StatusDonation();
		model.addAttribute("donation", donation);
		model.addAttribute("userDonations", userDonations);
		model.addAttribute("statusDonation",statusDonation);
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
