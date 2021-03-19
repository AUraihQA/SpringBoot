package com.example.demo.rest;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.persistence.domain.CatDomain;
import com.example.demo.persistence.dtos.CatDTO;
import com.example.demo.services.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {
	
	private CatService service;
	
	@Autowired
	public CatController(CatService service) {
		super();
		this.service = service;
	}

	
	//POST
	@PostMapping("/create")
	public ResponseEntity<CatDTO> create(@RequestBody CatDomain cat) {
		return new ResponseEntity<CatDTO> (this.service.create(cat), HttpStatus.CREATED);
	}
	
	//GET
	@GetMapping("/getCats")
	public ResponseEntity<List<CatDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<CatDTO> readOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}
	
	
	//PUT
	@PutMapping("/update/{id}")
	public ResponseEntity <CatDTO> update(@PathVariable("id") Long id, @RequestBody CatDomain cat) {
		return new ResponseEntity<CatDTO>(this.service.update(id, cat), HttpStatus.ACCEPTED);
	}
	
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable ("id") Long id) {
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT):
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
