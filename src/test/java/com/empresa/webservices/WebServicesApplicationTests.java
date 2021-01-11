package com.empresa.webservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* Banco de dados H2
 * É um banco totalmente feito em java q faz a converção de objeto para tabelas SQL automaticamente
 * É necessario baixar as dependencias desse database colocando la no pom.xml 
 * É bastante usado para fazer os perfils de test da apliação 
 * Para seu uso temos q ter alguns arquivos de config entre eles o application.properties que configura o nome do per-
   fil do nosso projeto que vai ser o "test".
 * Outro arquivo q iremos usar bastante é o application-test.properties esse test ja indicia q é o nome de perfil do 
   do usuario nele temos a string de conexão com o banco o nome e senha de usuario, mostramos que esta habilitado ao 
   console e obviamente o caminho para ser visto no google.
 * */
@SpringBootTest
class WebServicesApplicationTests {

	@Test
	void contextLoads() {
	}

}
