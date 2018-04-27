package backend.rest.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.database.domain.Wish;
import backend.database.repositories.WishRepository;
import backend.firebase.AndroidPushNotificationsService;

@RestController()
public class WishUpdater {

	@Autowired
	WishRepository wishRepo;

	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
	
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	private ResponseEntity<List<Wish>> getWishes() {
		List<Wish> allWishes = wishRepo.findAll();
		return new ResponseEntity<List<Wish>>(allWishes, HttpStatus.OK);
	}


	@RequestMapping(value = "/wish/update", method = RequestMethod.POST)
	public ResponseEntity<String> updateWishStatus(@RequestBody Wish wish) {
		ResponseEntity<String> notifyWish = null;
		Wish existingWish = wishRepo.findById(wish.getId()).get();
//		if (wish.getWishStatusType() == existingWish.getWishStatusType()) {
//			notifyWish = notifyWish(wish.getAuthorId());
//		}
		wish = wishRepo.save(wish);
		return notifyWish;
	}

	private ResponseEntity<String> notifyWish(Long id) {
		try {
			String topic = String.valueOf(id);
			String response;

			JSONObject body = new JSONObject();
			body.put("to", "/topics/" + topic);
			body.put("priority", "high");

			JSONObject notification = new JSONObject();
			notification.put("title", "JSA Notification");
			notification.put("body", "Happy Message!");

			JSONObject data = new JSONObject();
			data.put("Key-1", "JSA Data 1");
			data.put("Key-2", "JSA Data 2");

			body.put("notification", notification);
			body.put("data", data);

			HttpEntity<String> request = new HttpEntity<>(body.toString());

			CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
			CompletableFuture.allOf(pushNotification).join();
			String firebaseResponse = pushNotification.get();
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
		}
	}

}
