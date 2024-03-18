package com.example.springdemo.dao;

import java.util.List;


import com.example.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
}
