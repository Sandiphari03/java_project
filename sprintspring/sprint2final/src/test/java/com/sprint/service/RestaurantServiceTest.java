package com.sprint.service;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprint.beans.Restaurant;
import com.sprint.repository.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RestaurantServiceTest {

	@Autowired
	private RestaurantServiceImpl restService;
	
	@MockBean
	private RestaurantRepository rsRepo;
	
	@Test
	@DisplayName("Testcase to register or save restaurant.")
	@Order(1)
	public void testSaveOrUpdateRestaurant() {
		
		Restaurant rest = new Restaurant();
		rest.setRid(1);
		rest.setRestaurantName("6STAR");
		rest.setRestaurantPwd("6star@1234");
		rest.setRestaurantEmail("star6@gmail.com");
		rest.setRestaurantAddress("Mumbai");
		
		Mockito.when(rsRepo.saveAndFlush(rest)).thenReturn(rest);
		assertThat(restService.saveOrUpdate(rest)).isEqualTo("Restaurant Registered successfully");
	}
	
	@Test
	@DisplayName("Testcase to get all registered restaurants.")
	@Order(2)
	public void testGetAllRestaurant() {
		
		Restaurant rest1 = new Restaurant();
		rest1.setRid(1);
		rest1.setRestaurantName("5STAR");
		rest1.setRestaurantPwd("5star@1234");
		rest1.setRestaurantEmail("star5@gmail.com");
		rest1.setRestaurantAddress("Delhi");
		
		Restaurant rest2 = new Restaurant();
		rest2.setRid(2);
		rest2.setRestaurantName("6STAR");
		rest2.setRestaurantPwd("6star@1234");
		rest2.setRestaurantEmail("star6@gmail.com");
		rest2.setRestaurantAddress("Mumbai");
		
		List<Restaurant> restaurant = new ArrayList<>();
		restaurant.add(rest1);
		restaurant.add(rest2);
		
		Mockito.when(rsRepo.findAll()).thenReturn(restaurant);
		assertThat(restService.getAllRestaurant()).isEqualTo(restaurant);
	}
	
	@Test
	@DisplayName("Testcase to login restaurant.")
	@Order(3)
	public void testLoginRestaurant() {
		
		Restaurant rest = new Restaurant();
		rest.setRid(1);
		rest.setRestaurantName("6STAR");
		rest.setRestaurantPwd("6star@1234");
		rest.setRestaurantEmail("star6@gmail.com");
		rest.setRestaurantAddress("Mumbai");
		
		Mockito.when(rsRepo.loginRestaurant(1, "6star@1234")).thenReturn(rest);
		assertThat(restService.loginRestaurant(1, "6star@1234")).isEqualTo(rest);
	}
	
	@Test
	@DisplayName("Testcase to fetch restaurant by their id.")
	@Order(4)
	public void testFindRestaurantById() {
		
		Restaurant rest = new Restaurant();
		rest.setRid(1);
		rest.setRestaurantName("6STAR");
		rest.setRestaurantPwd("6star@1234");
		rest.setRestaurantEmail("star6@gmail.com");
		rest.setRestaurantAddress("Mumbai");
		
		Mockito.when(rsRepo.findByrid(1)).thenReturn(rest);
	    assertThat(restService.findOneById(1)).isEqualTo(rest);
	}
}
