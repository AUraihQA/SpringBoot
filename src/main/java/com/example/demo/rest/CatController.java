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

import com.example.demo.persistence.domain.Cat;

@RestController
@RequestMapping("/cat")
public class CatController {
	
	private List<Cat> catList = new ArrayList<>();
	
	//GET
	@GetMapping("/getCats")
	public List<Cat> helloWorld() {
		return catList;
	}
	
	//POST
	@PostMapping("/create")
	public boolean create(@RequestBody Cat cat) {
		return catList.add(cat);
	}
	
	//PUT
	@PutMapping("/update")
	public Cat updateCat(@PathParam("id") int id, @RequestBody Cat cat) {
		this.catList.remove(id);
		this.catList.add(id, cat);
		return this.catList.get(id);
	}
	
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public Cat delete(@PathVariable int id) {
		return this.catList.remove(id);
	}

}
