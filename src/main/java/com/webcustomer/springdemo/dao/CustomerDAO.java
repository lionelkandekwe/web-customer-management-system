package com.webcustomer.springdemo.dao;

import java.util.List;

import com.webcustomer.springdemo.entity.Customer;

public interface CustomerDAO {

	

	public List<Customer>getCustomers();

	public void saveCustomer(Customer theCustomer);

	
}
