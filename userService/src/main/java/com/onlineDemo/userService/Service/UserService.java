package com.onlineDemo.userService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.onlineDemo.userService.Entity.User;

public interface UserService {

	public User fetchUser(Long userId);
	
	public User addUser(User user);
	
	public List<User> getAllUser();
	
	public List<User> getUser(Long userId);
	
	public User updateUser(User updatedUser,Long userId);
	
	public void deleteUser(Long userId);
	
	public Page<User> getUserByPage(Optional<Integer> pageNo, Optional<String> sortColumn);
	
	public List<User> searchUser(String query);
}
