package backend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.database.domain.User;
import backend.database.repositories.UserRepository;
import backend.firebase.AndroidPushNotificationsService;

@RestController()
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public Long createUser(@RequestBody User user) {
		user = userRepo.save(user);
		if (user != null) 
			return user.getId();
		else
			return -1L;
	}

	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> allUsers = userRepo.findAll();
		return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/email/{mail}", method = RequestMethod.GET)
	public ResponseEntity<User> getByMail(@PathVariable String mail) {
		User user = null;
		List<User> allUsers = userRepo.findByEmail(mail);
		if (allUsers.size() > 0) {
			user = allUsers.get(0);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		
	}
}
