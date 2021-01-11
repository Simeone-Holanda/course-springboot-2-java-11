package com.empresa.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.webservices.entities.User;


// so com o extends nesse classe ja consigo criar varias e varias operações com o usuario 
// pq a classe JpaRepository é responsavel por fzr as operações de banco de dados
public interface UserRepository extends JpaRepository<User, Long>{
	
	// sabendo q essa interface é uma dependencia dos serviços poderia usar uma anotação para mostrar ao spring
	// que esta registrada contudo como estamos herdando a JpaRepository que ja esta cadastrada como uma classe
	// do spring então n precisamos

}
