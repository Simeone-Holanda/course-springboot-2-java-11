package com.empresa.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.webservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
