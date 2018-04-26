package backend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.database.domain.User;
import backend.database.repositories.UserRepository;

@RestController()
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		userRepo.save(user);
		return user.getId().toString();
	}
	
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> allUsers = userRepo.findAll();
		return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
		}
}
