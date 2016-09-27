package com.example.ws.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
	
	List<User> findByIdToken(String idToken);

}
