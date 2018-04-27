package backend.database.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import backend.database.domain.Wish;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@RestController
public interface WishRepository extends CrudRepository<Wish, Long> {
	
	public List<Wish> findAll();

}