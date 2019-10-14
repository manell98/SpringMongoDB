package br.com.mongodb.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.mongodb.spring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
