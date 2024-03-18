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
@ComponentScan(basePackages={"com.example.springdemo.service"})
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Customer> customers = customerService.getCustomer();
		model.addAttribute("customers",customers);
		return "list-customer";
	}
	@RequestMapping("/showFortoAdd")
	public String showFormtoAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute(customer);
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	@RequestMapping("/delete")
	public String delete(@ModelAttribute("customerId") int id) {
		return "redirect:/customer/list";
	}
}
