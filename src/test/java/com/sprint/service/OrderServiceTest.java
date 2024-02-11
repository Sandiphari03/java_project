//package com.sprint.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.sprint.beans.Customer;
//import com.sprint.beans.Order;
//import com.sprint.repository.OrderRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OrderServiceTest {
//
//	@Autowired
//	private OrderServiceImpl orderService;
//	
//	@MockBean
//	private OrderRepository oRepo;
//	
//	@Test
//	@DisplayName("Testcase to add order.")
//	public void testAddOrder() {
//		
//		Customer cust = new Customer();
//		cust.setCustomerId(1);;
//		cust.setFirstName("Sneha");
//		cust.setLastName("Chaturvedi");
//		cust.setPassword("Sneha%1234");
//		cust.setMailId("sneha@gmail.com");
//		cust.setMailId("9876543210");
//		cust.setAddress("Mumbai");
//		
//		Order order = new Order();
//		order.setOrder_id(2);
//		order.setName("Pizza");
//		order.setQuantity(2);
//		order.setPrice(45);
//		order.setCustomers(cust);
//		
//		
//		Map<String, Double> res = new HashMap<>(); 
//		String name = order.getName();
//		Double price = (order.getPrice())*(order.getQuantity());
//		res.put(name, price);
//				
//		Mockito.when(oRepo.save(order)).thenReturn(order);
//		assertThat(orderService.addOrder(order)).isEqualTo(res);			
//
//	}
//}
