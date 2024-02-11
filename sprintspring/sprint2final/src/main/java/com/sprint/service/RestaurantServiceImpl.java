package com.sprint.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.beans.Customer;
import com.sprint.beans.Restaurant;
import com.sprint.repository.OrderRepository;
import com.sprint.repository.RestaurantRepository;
@Transactional
@Service
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	RestaurantRepository rRepo;

	@Override
	public String saveOrUpdate(Restaurant restaurant) {
		rRepo.saveAndFlush(restaurant);
		return "Restaurant Registered successfully";
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
       	return rRepo.findAll();
	}

	@Override
	public Restaurant loginRestaurant(int rid, String restaurantPwd) {
		return rRepo.loginRestaurant(rid, restaurantPwd);
	}

	@Override
	public Restaurant findOneById(int rid) {
		return rRepo.findByrid(rid);
	}


	
}
