package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomer();
	public void addCustomer(Customer customer);
}
