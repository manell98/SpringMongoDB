package br.com.mongodb.spring.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mongodb.spring.domain.Post;
import br.com.mongodb.spring.domain.services.exception.ObjectNotFoundException;
import br.com.mongodb.spring.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post find(String id) {
		
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException(
								"Objeto não encontrado! Id: " + id));
	}
}
