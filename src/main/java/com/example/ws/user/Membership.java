package com.example.ws.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "membership")
public class Membership {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private final Long id;
	
	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName  = "ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "team_id", referencedColumnName  = "ID")
    private Team team;
    
    @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL)
    private List<Token> tokens;
	
	
	protected Membership(){
		id = null;
		tokens = new ArrayList();
	}
	
	
	
	


	public Membership(User user, Team team) {
		this();
		this.user = user;
		this.team = team;
	}



	
	

	public List<Token> getTokens() {
		return tokens;
	}






	public void addTokens(Token token) {
		token.setMembership(this);
		tokens.add(token);
	}






	public User getUser() {
		return user;
	}






	public void setUser(User user) {
		this.user = user;
	}






	public Team getTeam() {
		return team;
	}






	public void setTeam(Team team) {
		this.team = team;
	}






	@Override
	public String toString() {
		return "Membership [id=" + id + ", user=" + user + ", team=" + team + "]";
	}
	
	
}
