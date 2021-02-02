package com.example.demo.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.domain.AccountDomain;

@Repository
public interface AccountRepo extends JpaRepository<AccountDomain, Long>{
	

}
