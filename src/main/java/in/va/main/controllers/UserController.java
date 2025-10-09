package in.va.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.va.main.entities.User;
import in.va.main.services.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		user.setUserRole("user");
		return userService.createUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable long id){
		userService.deleteUser(id);
		Map<String, String> response = new HashMap<>();
	    response.put("message", "User deleted successfully");
	    
	    return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
	    Optional<User> existingUser = userService.findByEmail(user.getEmail());

	    if (existingUser.isPresent()) {
	        User foundUser = existingUser.get();

	        if (foundUser.getPassword().equals(user.getPassword())) {
	            // Do NOT return the password in the response
	            foundUser.setPassword(null);
	            return ResponseEntity.ok(foundUser);
	        } else {
	            return ResponseEntity.status(401).body("Invalid password!");
	        }
	    } else {
	        return ResponseEntity.status(404).body("User not found!");
	    }
	}
	
	@PutMapping("/user_role/{id}")
	public ResponseEntity<?> updateUserRole(@PathVariable long id, @RequestBody User updatedUser) {
	    Optional<User> optionalUser = userService.getUser(id);

	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setUserRole(updatedUser.getUserRole()); // use only role from body

	        User savedUser = userService.createUser(user);
	        return ResponseEntity.ok(savedUser);
	    } else {
	        return ResponseEntity.status(404).body("User not found!");
	    }
	}
}
