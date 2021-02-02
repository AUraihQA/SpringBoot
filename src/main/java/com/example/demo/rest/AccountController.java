package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.domain.Account;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	private List<Account> accountList = new ArrayList<>();
	
	//GET
	@GetMapping("/getAccounts")
	public List<Account> readAll() {
		return accountList;
	}
	
	//POST
	@PostMapping("/create")
	public boolean create(@RequestBody Account account) {
		return accountList.add(account);
	}
	
	//PUT
	@PutMapping("/update")
	public Account updateCat(@PathParam("id") int id, @RequestBody Account account) {
		this.accountList.remove(id);
		this.accountList.add(id, account);
		return this.accountList.get(id);
	}
	
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public Account delete(@PathVariable int id) {
		return this.accountList.remove(id);
	}
	

}
