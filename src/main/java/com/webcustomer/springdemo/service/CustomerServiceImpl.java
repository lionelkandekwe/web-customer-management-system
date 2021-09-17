package com.webcustomer.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcustomer.springdemo.dao.CustomerDAO;
import com.webcustomer.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//Inject CustomerDAO
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
