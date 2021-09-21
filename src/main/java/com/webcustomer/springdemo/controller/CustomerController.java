package com.webcustomer.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcustomer.springdemo.entity.Customer;
import com.webcustomer.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject CustomerService

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// Get Customers from DAO

		List<Customer> theCustomers = customerService.getCustomers();

		// add customer to model

		theModel.addAttribute("customers", theCustomers);

		return "list-customers";

	}

	// Show Form for Add customer

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";

	}

	// save customer

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer

		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		//get customer from Service
		
		Customer theCustomer=customerService.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the from
		
		theModel.addAttribute("customer",theCustomer);
		
		//send to form
		
		return "customer-form";

	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		//delete customer from Service
		
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";

	}

}
