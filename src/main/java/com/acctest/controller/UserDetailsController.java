package com.acctest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acctest.model.UserDetails;
import com.acctest.repository.UserRepository;


@RestController
public class UserDetailsController {

	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDetails>> getUsers() {
		
		List<UserDetails> userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "userName"));
		return new ResponseEntity<List<UserDetails>>(userList, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<UserDetails> saveUser(UserDetails userDetails){
		
		UserDetails user = userRepository.save(userDetails);
		return new ResponseEntity<UserDetails>(user, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
}
