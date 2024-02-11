package com.sprint.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sprint.beans.Restaurant;
import com.sprint.repository.RestaurantRepository;
import com.sprint.service.RestaurantService;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	Restaurant restaurant;
	@MockBean
	RestaurantRepository rRepo;
	
	@MockBean
	RestaurantService rService;

	@Test
	@DisplayName("Testcase for get request method.")
	public void getAllRestaurant() throws Exception{
		mockMvc.perform(get("http://localhost:8080/restaurant/getRestaurant"))
		.andExpect(status().isOk())
		.andExpect(content().json("[]"));
		
	}
}