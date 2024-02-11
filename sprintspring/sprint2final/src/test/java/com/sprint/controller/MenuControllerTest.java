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


import com.sprint.beans.Menu;
import com.sprint.repository.MenuRepository;
import com.sprint.service.MenuService;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
public class MenuControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	Menu menu;
	@MockBean
	MenuRepository mRepo;
	
	@MockBean
	MenuService mService;

	@Test
	@DisplayName("Testcase for get request method.")
	public void getAllMenu() throws Exception{
		mockMvc.perform(get("/menu/get"))
		.andExpect(status().isOk())
		.andExpect(content().json("[]"));
	}
}