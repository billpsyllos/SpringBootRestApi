package com.example.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private final Long id;
	private String email;
	private String idToken;
	
	protected User(){
		id = null;
	}
	
	public User(String email, String idToken) {
		this();
		this.email = email;
		this.idToken = idToken;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	
	
	
	
	
}
