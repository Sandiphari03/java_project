package com.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint.beans.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

	@Query(value="SELECT * from view_order v where v.customer_id=:customer_id" ,nativeQuery = true)
	public List<String> getOrderList(@Param("customer_id") int customer_id);
	
//	@Query(value="SELECT f.food_name,f.food_price from view_order f where f.m_id=:m_id" ,nativeQuery = true)
//	public List<String> getMenu();
//	
//	@Query(value="SELECT f.food_price from menu f where f.food_name=:food_name",nativeQuery = true)
//	public double itemPrice(@Param("food_name") String foodName);
	
}
