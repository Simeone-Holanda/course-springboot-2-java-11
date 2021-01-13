package com.empresa.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.webservices.entities.Category;
import com.empresa.webservices.services.CategoryService;

// Assim como em javafx precisamos de controllers para controlar os elementos da tela, aq teremos os recursos
// para falarmos que essa classe é um recurso web e que é implementado por um controlador rest 
// usamos a notação RestController
// E precisamos colocar um caminho desse recurso com o @RequestMapping
@RestController
@RequestMapping(value = "/categories") // caminho do meu recurso 
public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	//vms criar um metodo agr para acessar os usuarios
	// o tipo de resposta vai ser o metodo ResponseEntity é um tipo especifico para obter resposta de recursos web
	// para indicar q esse metodo reponde a requisição get do http usamos a notação @GetMapping
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); // vai retornar o corpo da aplicação 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
