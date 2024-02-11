//package com.sprint.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import com.sprint.beans.Customer;
//import com.sprint.beans.Menu;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@TestMethodOrder(OrderAnnotation.class)
//public class MenuRepositoryTest {
//
//	@Autowired
//	private MenuRepository mrepo;
//	
//	
//	@Test
//	@DisplayName("Testcase to add new menu in database.")
//	@Rollback(false)
//	@Order(1)
//	public void testAddMenu() {
//		Menu menu = new Menu(1l,"French Fries", 45);
//		Menu savedmenu = mrepo.saveAndFlush(menu);
//		
//		//Assert that the customer saved is not null.
//		assertNotNull(savedmenu);		
//	}
//	
//	@Test
//	@DisplayName("Testcase to find all menu.")
//	@Order(2)
//	public void testGetAllMenu() {
//		List<String> list = new ArrayList<>();
//		list = mrepo.getMenu();
//		long rowCount = mrepo.count();
//		
//		//Assert that the size of list of menu is equal to the size of count of rows in database.
//		assertThat(list.size()).isEqualTo(rowCount);
//	}
//	
//	@Test
//	@DisplayName("Testcase to find menu by id.")
//	@Order(3)
//	public void testFindMenuById() {
//		Long id = 1l;
//		Optional<Menu> menu = mrepo.findById(id);
//		
//		//Assert that customer fetched from database has same id equal to id entered by user.
//		assertThat(menu.get().getM_id()).isEqualTo(id);	
//	}
//		
//	@Test
//    @DisplayName("Testcase to get menu by price.")
//	@Order(4)
//    public void testFindMenuByPrice() {
//    	double price = 45;
//    	List<Menu> menuList = new ArrayList<>();
//    	menuList = mrepo.findByfoodPrice(price);
//    	
//    	//Assert that size of list of menu with same price is greater than 0..
//    	assertThat(menuList.size()).isGreaterThan(0);
//    }
//	
//	@Test
//	@DisplayName("Testcase to get price of food by food name.")
//	@Order(5)
//	public void testFindPriceByFood() {
//		String foodName = "Pasta";
//		double price = mrepo.itemPrice(foodName);
//		
//		//Assert that the price fetched is not null.
//		assertNotNull(price);
//	}
//}
