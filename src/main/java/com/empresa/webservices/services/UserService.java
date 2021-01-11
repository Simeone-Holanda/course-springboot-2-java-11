package com.empresa.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.webservices.entities.User;
import com.empresa.webservices.repositories.UserRepository;

// sabendo que essa classe é uma dependencia do UserReour..., temos q mostrar q essa classe esta registrada como compo
// nente do spring, então para que tudo der certo nas injeções de dependencia com o Autowired usamos a notação @Service
// foi usada essa pq é um serviso, porem poderia ser usado o @Component

@Service
public class UserService {

	// Vamos criar alguns camadas de servisos para o usuario, logo temos a injeção de dependencia do UseRepository
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); // esse metodo retorna um elemento do tipoi Optional
		return obj.get();
	}
}
