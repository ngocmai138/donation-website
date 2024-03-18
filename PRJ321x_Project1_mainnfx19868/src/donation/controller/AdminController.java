package donation.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import donation.entity.Donation;
import donation.entity.PaginationForm;
import donation.entity.Role;
import donation.entity.User;
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
	public String listUser(@RequestParam(value="pageNumber", defaultValue="1") int pageNumber, 
							@RequestParam(value="pageSize", defaultValue="3") int pageSize, 
							@RequestParam(value="keyword", required=false) String keyword ,
							Model model) {
		List<User> users;
		Long totalUsers;
		if(keyword!=null && !keyword.isEmpty()) {			
			users = donationService.searchUser(keyword, pageSize, pageNumber);
			totalUsers = donationService.getTotalSearchUsers(keyword);
		}else {
			users = donationService.getUsers(pageSize, pageNumber);
			totalUsers =  donationService.getTotalUser();
		}
		List<Integer> pageSizes = Arrays.asList(5,10,15,20);
		int numSize = pageSize;
		int totalPages = (int) Math.ceil((double)totalUsers/numSize);
		model.addAttribute("users", users);
		model.addAttribute("pagination", new PaginationForm(pageNumber, numSize));
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("numSize", numSize);
		model.addAttribute("keyword",keyword);
		return "user-list";
	}
	@RequestMapping("/listDonation")
	public String listDonation(@RequestParam(value="pageNumber", defaultValue="1") int pageNumber,
								@RequestParam(value="pageSize", defaultValue="3") int pageSize,
								@RequestParam(value="keyword", required =false) String keyword,
								Model model) {
		List<Donation> donations = donationService.getDonations(pageSize,pageNumber);
		Long totalDonations;
		totalDonations = donationService.getTotalDonations();
		List<Integer> pageSizes= Arrays.asList(5,10,15,20);
		int numSize = pageSize;
		int totalPages = (int) Math.ceil((double)totalDonations/numSize);
		model.addAttribute("donations",donations);
		model.addAttribute("pageSizes",pageSizes);
		model.addAttribute("pageNumber",numSize);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("pagination", new PaginationForm(pageNumber, pageSize));
		return "donation-list";
	}
	@RequestMapping("/formToAddUser")
	public String formToAddUser(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		List<Role> roles = donationService.getRoles();
		model.addAttribute("roles",roles);
		model.addAttribute("edit",false);
		return "user-form";
	}
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user, @RequestParam("role") int roleId) {
		Role role = donationService.getRole(roleId);
		user.setRole(role);
		donationService.addOrUpdateUser(user);
		return "redirect:/admin/listUser";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("userId") int userId) {
		donationService.deleteUser(userId);
		return "redirect:listUser";
	}
	@RequestMapping("/editForm")
	public String formToEdit(@RequestParam("userId") int userId, Model model) {
		User user = donationService.getUser(userId);
		List<Role> roles = donationService.getRoles();
		model.addAttribute("roles",roles);
		model.addAttribute("user",user);
		model.addAttribute("edit",true);
		return "user-form";
	}
	@RequestMapping("/changeStatus")
	public String changeStatus(@RequestParam("userId") int userId, HttpServletRequest request) {
		User user = donationService.getUser(userId);
		if(user.getStatus()==0) {
			user.setStatus(1);
		}else {
			user.setStatus(0);
		}
		donationService.addOrUpdateUser(user);
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}
	
}
