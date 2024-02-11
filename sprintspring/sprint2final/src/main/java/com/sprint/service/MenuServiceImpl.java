package com.sprint.service;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.beans.Customer;
import com.sprint.beans.Order;
import com.sprint.repository.CustomerRepository;
import com.sprint.repository.MenuRepository;
import com.sprint.repository.OrderRepository;


@Transactional
@Service
public class MenuServiceImpl implements MenuService{

	HashMap<String,Double> selectedMenu = new HashMap<String,Double>();
	@Autowired
	MenuRepository mRepo;
	
	
	@Autowired
	OrderRepository oRepo;
	
	@Autowired
	CustomerRepository cRepo;

	@Override
	public List<String> getMenu() {
		List<String> menu = mRepo.getMenu();
		return menu;
	}



}
