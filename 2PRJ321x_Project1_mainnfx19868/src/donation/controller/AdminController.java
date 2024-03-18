package donation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import donation.entity.User;
import donation.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping()
	public String adminMenu() {
		return "admin-menu";
	}
	@RequestMapping("/listUser")
	public String listUser(Model model) {
		List<User> users = adminService.getUsers();
		model.addAttribute("users",users);
		return "user-list";
	}
}
