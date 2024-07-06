package com.onlineDemo.userService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineDemo.userService.Entity.User;
import com.onlineDemo.userService.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/{userId}")
	public List<User> getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}
	
	@PutMapping("/{userId}")
	public void updateUser(@RequestBody User updatedUser,@PathVariable Long userId) {
		  userService.updateUser(updatedUser,userId);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/page")
	public  Page<User> getUserByPage(@RequestParam("pageNo") Optional<Integer> pageNo,
			@RequestParam("sortBy") Optional<String> sortBy) {
		return userService.getUserByPage(pageNo,sortBy);
	}
	
	@GetMapping("/search")
	public List<User> searchUser(@RequestParam("query") String query){
		return userService.searchUser(query);

	}
	
	// Rest Template
	
	@GetMapping("/user/{userId}")
	public User fetchUser(@PathVariable Long userId){
		return userService.fetchUser(userId);
	}
	
}
