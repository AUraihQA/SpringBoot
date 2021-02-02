package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.domain.AccountDomain;
import com.example.demo.persistence.dtos.AccountDTO;
import com.example.demo.persistence.repos.AccountRepo;

@Service
public class AccountServices {
	
	private AccountRepo repo;
	private ModelMapper mapper;
	
	
	@Autowired
	public AccountServices(AccountRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private AccountDTO map(AccountDomain model) {
		return this.mapper.map(model, AccountDTO.class);
	}
	
	//POST
	public AccountDTO create(AccountDomain account) {
		return this.map(this.repo.save(account));
	}
	
	

}
