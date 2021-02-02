package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.domain.AccountDomain;
import com.example.demo.persistence.dtos.AccountDTO;
import com.example.demo.services.AccountServices;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	private AccountServices service;
	
	public AccountController(AccountServices service) {
		super();
		this.service = service;
	}


	private List<AccountDomain> accountList = new ArrayList<>();
	
	
	//POST
	@PostMapping("/create")
	public ResponseEntity<AccountDTO> create(@RequestBody AccountDomain account) {
		return new ResponseEntity<AccountDTO> (this.service.create(account), HttpStatus.CREATED);
	}
	//GET
	@GetMapping("/getAccounts")
	public List<AccountDomain> readAll() {
		return accountList;
	}
	
	@GetMapping("/read/{id}")
	public AccountDomain read(@PathParam("name") String name, @PathParam("accountNumber") String accountNumber, @PathVariable("id") Long id) {
		return this.accountList.get(id.intValue());
	}
		

	
	//PUT
	@PutMapping("/update")
	public AccountDomain updateCat(@PathParam("id") int id, @RequestBody AccountDomain account) {
		this.accountList.remove(id);
		this.accountList.add(id, account);
		return this.accountList.get(id);
	}
	
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public AccountDomain delete(@PathVariable int id) {
		return this.accountList.remove(id);
	}
	

}
