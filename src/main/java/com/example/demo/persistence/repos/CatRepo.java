package com.example.demo.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.domain.CatDomain;

@Repository
public interface CatRepo extends JpaRepository<CatDomain, Long> {
	
	//CRUD -> h2 Database

	
}
