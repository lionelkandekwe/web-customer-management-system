package com.webcustomer.springdemo.service;

import java.util.List;

import com.webcustomer.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer>getCustomers();

	public void saveCustomer(Customer theCustomer);



	
}