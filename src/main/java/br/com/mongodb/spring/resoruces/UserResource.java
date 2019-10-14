package br.com.mongodb.spring.resoruces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mongodb.spring.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		
		User maria = new User("1", "Maria Joaquina", "maria@gmail.com");
		User joao = new User("2", "João Pedro", "joao@gmail.com");
		
		List<User> listUser = new ArrayList<>();
		listUser.addAll(Arrays.asList(maria, joao));
		
		return ResponseEntity.ok().body(listUser);
	}
	
}
