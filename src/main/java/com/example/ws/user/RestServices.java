package com.example.ws.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServices {
	
	private UserRepository userRepository;
	private TeamRepository teamRepository;
	private MembershipRepository membershipRepositiry;
	private TokenRepository tokenRepository;
	
	@Autowired
	private void enableRepositories(UserRepository userRepository,
			TeamRepository teamRepository,
			MembershipRepository membershipRepository,
			TokenRepository tokenRepository){
		this.userRepository = userRepository;
		this.teamRepository = teamRepository;
		this.membershipRepositiry = membershipRepository;
		this.tokenRepository = tokenRepository;
	}
	
	@RequestMapping(value="createuser", method=RequestMethod.POST)
	public String createUser(User user){
		
		userRepository.save(user);
		
		return "OK";
	}
	
	@RequestMapping(value="createteam" , method = RequestMethod.POST)
	public String createTeam(Team team,@RequestParam(value="idToken") String idToken){
		
		teamRepository.save(team);
		
		List<User> userList = userRepository.findByIdToken(idToken);
		User user = userList.get(0);
		
		Membership membership = new Membership();
		membership.setTeam(team);
		membership.setUser(user);
		membership.addTokens(new Token(idToken));
		membershipRepositiry.save(membership);
		
		return "Tteam Created";
	}
	
	@RequestMapping(value="membership" , method = RequestMethod.GET)
	public String getMembership(@RequestParam(value="idToken") String idToken){
		
		Token token = tokenRepository.findByToken(idToken).get(0); 
		Membership membership = token.getMembership();
		
		return membership.toString();
	}
}
