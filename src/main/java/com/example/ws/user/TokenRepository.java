package com.example.ws.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token,Long> {
	List<Token> findByToken(String idToken);
}
