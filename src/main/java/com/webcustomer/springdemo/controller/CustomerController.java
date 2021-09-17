package com.webcustomer.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webcustomer.springdemo.dao.CustomerDAO;
import com.webcustomer.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject CustomerDAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get Customers from DAO
		
		List<Customer> theCustomers=customerDAO.getCustomers();
		
		// add customer to model
		
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
		
	}

}
