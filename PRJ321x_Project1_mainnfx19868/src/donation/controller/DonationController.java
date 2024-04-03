package donation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import donation.entity.Donation;
import donation.entity.StatusDonation;
import donation.entity.UserDonation;
import donation.service.DonationService;

@Controller
public class DonationController {
	@Autowired
	private DonationService donationService;
	
	@RequestMapping("/main")
	public String MainNenu(@RequestParam(name="pageSize", defaultValue = "5") int pageSize,
							@RequestParam(name="pageNumber", defaultValue = "1") int pageNumber,
							Model model) {
		List<Donation> donations = donationService.getDonations(pageSize, pageNumber);
		Long totalDonations = donationService.getTotalDonations();
		int totalPage = (int)Math.ceil((double)totalDonations/pageSize);
		model.addAttribute("donations",donations);
		model.addAttribute("status", new StatusDonation());
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("pageNumber", pageNumber);
		return "main-menu";
	}
	
	@RequestMapping("/detailDonation")
	public String detailDonation(@RequestParam("donationId") int donationId, Model model) {
		Donation donation = donationService.getDonation(donationId);
		List<UserDonation> userDonations = donationService.getUserDonationsD(donationId,5,1);
		model.addAttribute("donation",donation);
		model.addAttribute("status", new StatusDonation());
		model.addAttribute("userDonations",userDonations);
		return "detail-donation-main";
	}

}
