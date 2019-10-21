package br.com.mongodb.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.mongodb.spring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
