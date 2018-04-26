package backend.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import backend.database.domain.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@RestController
public interface UserRepository extends CrudRepository<User, Long> {

}