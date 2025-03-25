package com.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dl.model.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

	Users findByUsername(String username);
	
	
	
}