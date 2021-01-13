package com.empresa.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.empresa.webservices.entities.Order;
import com.empresa.webservices.entities.User;
import com.empresa.webservices.entities.enums.OrderStatus;
import com.empresa.webservices.repositories.OrderRepository;
import com.empresa.webservices.repositories.UserRepository;

// para falar para o spring que essa é uma classe especifica de configuração  usamos a notação @Configuration

@Configuration
@Profile("test") // especificando para o spring que essa é uma classe de config do perfil test
public class TestConfig implements CommandLineRunner{
	//sabendo que uma para add os dados eu preciso da classe UserRepository, aq entra a questão da injeção de dependencia
	// Lembrando dos principios basico de O.O, quando uma classe depende da outra n podemos ter uma relação muito forte
	// ent usamos um construtor ou sett algo desse estilo contudo na maioria dos frameworks temos algo para fzr toda essa
	// parte de injeção de dependencia e ent vms la usando a notação @Autowired ja aplicação uma instancia dessa classe 
	// de forma automatica aplicando o conceito de injeção de dependencia.
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public void run(String... args) throws Exception { 
		//Esse metodo é implementação do CommandLineRunner que é um metodo para ser executado qnd o programa for iniciado
		
		
		User u1 = new User(null,"Simeone", "simeone@gmail.com","999878378","123456");
		User u2 = new User(null,"Simes", "simes@gmail.com","9998556378","6543210");
		
		//O Instant é como se fosse um Date porem no formato de string, o T e o Z é para indica o formato UTC
		// e smp vai pegar o formato local do país
		
		Order o1 = new Order(null, Instant.parse("2020-01-03T15:30:19Z"),OrderStatus.PAID,u1); 		
		Order o2 = new Order(null, Instant.parse("2020-01-01T16:40:13Z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2020-01-02T17:58:09Z"),OrderStatus.CANCELED,u1);
		// adicionando os elementos ao bd, vale lembrar que o atributo userRe... é um é tipo da nossa interface UserR...,
		// que herda todos os atributos para manipular nosso banco e dessa forma fazemos a injeção de dependencia
		// mais organizada.
		
		 userRepository.saveAll(Arrays.asList(u1, u2));
		 orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
