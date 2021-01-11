package com.empresa.webservices.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Relebrando smp importa o javax.pesistence para o jpa 

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	// definindo a chave primaria da tabela do banco de dados
	// anotação para ele auto preencher GeneratedValue( strategy = GenerationType.IDENTITY) 
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	private String email;
	private String fone;
	private String password;
	
	@OneToMany(mappedBy = "client") // sabendo q a relação de muitos para 1 na classe Order esta na variavel cliente ent colocamos ela no parentes
	private List<Order> orders = new ArrayList<>();
	
	public User() { // quando se trabalha com frameworks é importante o uso de um construtor vazio
	}

	public User(Long id, String name, String email, String fone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.fone = fone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
