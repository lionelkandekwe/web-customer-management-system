package com.webcustomer.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.webcustomer.springdemo.entity.Customer;
import com.webcustomer.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject CustomerService
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get Customers from DAO
		
		List<Customer> theCustomers=customerService.getCustomers();
		
		// add customer to model
		
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
		
	}

}
