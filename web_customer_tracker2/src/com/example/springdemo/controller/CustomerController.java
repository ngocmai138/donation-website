package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
@ComponentScan("com.example.springdemo.service")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers",customers);
		return "list-customer";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute(customer);
		return "customer-form";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		System.out.print(customer);
		return "redirect:/customer/list";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("customerId") int id,Model model) {
		Customer cus = customerService.getCustomer(id);
		model.addAttribute("customer",cus);
		return "customer-form";
	}
	@RequestMapping("/delete")
	public String deleteCustomer(@ModelAttribute("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
