package br.com.mongodb.spring.resoruces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mongodb.spring.domain.User;
import br.com.mongodb.spring.domain.services.UserService;
import br.com.mongodb.spring.dto.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		User user = service.find(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
		
		User user = service.fromDto(userDto);
		user = service.insert(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDto) {
		
		User user = service.fromDto(userDto);
		user.setId(id);
		user = service.update(user);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
