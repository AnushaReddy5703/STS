package com.onlineDemo.userService.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineDemo.userService.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@Query(value="select*from Users where full_name like '%'|| :query ||'%'",nativeQuery=true)
	List<User> searchUser(String query);



}