package com.sprint.service;

import java.util.HashMap;
import java.util.List;

import com.sprint.beans.Customer;

public interface CustomerService {

String saveOrUpdate(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer loginCustomer(int customerId, String password);
	
	Customer findOneById(int customerId);
}
