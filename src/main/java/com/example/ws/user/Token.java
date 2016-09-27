package com.example.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Token {
	@Id
	@GeneratedValue
	private final Long id;
	private String token;
	@ManyToOne
	private Membership membership;
	
	protected Token(){
		id = null;
	}
	
	public Token(String token){
		this();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	
	
	
	
	
}
