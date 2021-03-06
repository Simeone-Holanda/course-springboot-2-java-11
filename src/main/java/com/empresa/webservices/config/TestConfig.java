package com.empresa.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.empresa.webservices.entities.Category;
import com.empresa.webservices.entities.Order;
import com.empresa.webservices.entities.Product;
import com.empresa.webservices.entities.User;
import com.empresa.webservices.entities.enums.OrderStatus;
import com.empresa.webservices.repositories.CategoryRepository;
import com.empresa.webservices.repositories.OrderRepository;
import com.empresa.webservices.repositories.ProductRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception { 
		//Esse metodo é implementação do CommandLineRunner que é um metodo para ser executado qnd o programa for iniciado
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
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
