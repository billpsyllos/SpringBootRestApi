package com.example.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private final Long id;
	private String name;
	private String serverUrl;
	
	
	protected Team(){
		id = null;
	}
	
	public Team(String name, String serverUrl) {
		this();
		this.name = name;
		this.serverUrl = serverUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	
	
}
