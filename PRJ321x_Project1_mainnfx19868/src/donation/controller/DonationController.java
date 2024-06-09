package donation.controller;

import java.util.Arrays;
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
import donation.entity.User;
import donation.entity.StatusDonation;
import donation.entity.UserDonation;
import donation.service.DonationService;

@Controller
public class DonationController {
	@Autowired
	private DonationService donationService;
	private User user;
	
	@RequestMapping("/main")
	public String MainNenu(Model model) {
		List<Donation> donations = donationService.getDonations();
		user = donationService.getUser(5);
		model.addAttribute("donations",donations);
		model.addAttribute("status", new StatusDonation());
		model.addAttribute("user",user);
		return "main-menu";
	} 
	@RequestMapping("/detailDonation")
	public String detailDonation(@RequestParam("donationId") int donationId, 
									Model model) {
		Donation donation = donationService.getDonation(donationId);
		List<Integer> pageSizes = Arrays.asList(3,5,10,15,20);
		List<UserDonation> userDonations = donationService.getUserDonations(donationId);
		user = donationService.getUser(5);
		model.addAttribute("donation",donation);
		model.addAttribute("status", new StatusDonation());
		model.addAttribute("userDonations",userDonations);
		model.addAttribute("pageSizes",pageSizes);
		model.addAttribute("user",user);
		return "detail-donation-main";
	}
	
	@RequestMapping("/addDonate")
	public String addDonate(@RequestParam("donationId") int donationId,
								@RequestParam("userId") int userId,
								HttpServletRequest request, 
								@ModelAttribute("donate") UserDonation donate,
								RedirectAttributes redirectAttributes) {
		String referer = request.getHeader("Referer");
		User user = donationService.getUser(userId);
		Donation donation = donationService.getDonation(donationId);
		donate.setUser(user);
		donate.setDonation(donation);
		donationService.addOrUpdateUserDonation(donate);
		redirectAttributes.addFlashAttribute("message","Quyên góp thành công");
		return "redirect:"+referer;
	}

}
