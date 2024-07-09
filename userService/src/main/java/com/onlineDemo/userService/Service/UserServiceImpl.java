package com.onlineDemo.userService.Service;

import java.util.ArrayList;







import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

 import com.onlineDemo.userService.Entity.Event;
 import com.onlineDemo.userService.Entity.Ticket;
 import com.onlineDemo.userService.Entity.User;
import com.onlineDemo.userService.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository;
	
	 @Autowired
	private RestTemplate restTemplate;
	
	public User fetchUser(Long userId) {

		
		User user=userRepository.findById(userId).get(); // id ,fullname, email, ticketId, eventId
		
		Ticket ticket=restTemplate.getForObject("http://ticketService/tickets/"+user.getTicketId(),Ticket.class );
		user.setTicket(ticket);
		
		Event event=restTemplate.getForObject("http://eventService/events/"+user.getEventId(), Event.class);
		user.setEvent(event);
		
		return user;
		
	}
	
	public User addUser(User user) {
		return userRepository.save(user) ;
	}

	public List<User> getAllUser() {
		List<User> userList=new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}

	public List<User> getUser(Long userId) {
		List<User> getUser= userRepository.findAll().stream()
                .filter(user->user.getUserId().equals(userId))
                .collect(Collectors.toList());
        return getUser;
		
	}

	
	public User updateUser(User updatedUser,Long userId) {
        List<User> users = userRepository.findAll();

        Optional<User> userToUpdate = users.stream()
                                           .filter(user -> user.getUserId().equals(updatedUser.getUserId()))
                                           .findFirst();

        return userToUpdate.map(user -> {
            user.setEmail(updatedUser.getEmail());
            user.setFullName(updatedUser.getFullName());
       
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("User with ID " + updatedUser.getUserId() + " not found"));
	}	
	
	
	
	public void deleteUser(Long userId) {
		List<User> userList=userRepository.findAll();
		
		User userToDelete= userList.stream()
		        .filter(user -> user.getUserId().equals(userId))
		        .findFirst()
	    .orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found"));
	    userRepository.delete(userToDelete);
	}

	public Page<User> getUserByPage(Optional<Integer> pageNo, Optional<String> sortColumn) {
		return userRepository.findAll(PageRequest.of
		          (pageNo.orElse(0),
		        		  2,
		        		  Direction.DESC,
		        		  sortColumn.orElse("userId")			        		
		        		  ));
	}

	public List<User> searchUser(String query) {
		return userRepository.searchUser(query);
		
	}
				  
}
