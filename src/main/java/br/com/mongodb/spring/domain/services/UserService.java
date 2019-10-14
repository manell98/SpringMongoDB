package br.com.mongodb.spring.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mongodb.spring.domain.User;
import br.com.mongodb.spring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {	
		return repo.findAll();
	}
	
}
