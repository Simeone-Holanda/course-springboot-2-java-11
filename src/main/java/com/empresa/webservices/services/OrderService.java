package com.empresa.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.webservices.entities.Order;
import com.empresa.webservices.repositories.OrderRepository;

// sabendo que essa classe é uma dependencia do OrderReour..., temos q mostrar q essa classe esta registrada como compo
// nente do spring, então para que tudo der certo nas injeções de dependencia com o Autowired usamos a notação @Service
// foi usada essa pq é um serviso, porem poderia ser usado o @Component

@Service
public class OrderService {

	// Vamos criar alguns camadas de servisos para o usuario, logo temos a injeção de dependencia do UseRepository
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id); // esse metodo retorna um elemento do tipoi Optional
		return obj.get();
	}
}
