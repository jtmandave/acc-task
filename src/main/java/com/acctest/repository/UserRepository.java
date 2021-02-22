package com.acctest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acctest.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
