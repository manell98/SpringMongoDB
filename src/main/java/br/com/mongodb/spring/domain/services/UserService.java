package br.com.mongodb.spring.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mongodb.spring.domain.User;
import br.com.mongodb.spring.domain.services.exception.ObjectNotFoundException;
import br.com.mongodb.spring.dto.UserDto;
import br.com.mongodb.spring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {	
		return repo.findAll();
	}
	
	public User find(String id) {
		
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! Id: " + id));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User update(User user) {
		User newUser = find(user.getId());
		updateData(newUser, user);
		return repo.save(newUser);
	}
	
	public void delete(String id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDto(UserDto userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}	
}
