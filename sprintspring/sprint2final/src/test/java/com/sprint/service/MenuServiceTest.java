package com.sprint.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprint.beans.Menu;
import com.sprint.repository.MenuRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

	@Autowired
	private MenuServiceImpl menuService;
	
	@MockBean
	private MenuRepository mRepo;
	
	
	@Test
	@DisplayName("Testcase to get list of menu.")
	public void testGetMenu() {
		
		List<String> list =  new ArrayList<>();
		List<Menu> menu = new ArrayList<>();
		menu = mRepo.findAll();
		for(Menu m:menu)
		{
			String name = m.toString();
			list.add(name);
		}
		
		Mockito.when(mRepo.getMenu()).thenReturn(list);
		assertThat(menuService.getMenu()).isEqualTo(list);
	}

}
