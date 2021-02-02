package com.example.demo.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private int speechVolume;

	// alt + shift + S

	// CONSTRUCTOR
	// No Args
	public Cat() {
		super();
	}

	// All Args
	public Cat(Long id, String name, int age, int speechVolume) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}

	// METHODS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSpeechVolume() {
		return speechVolume;
	}

	public void setSpeechVolume(int speechVolume) {
		this.speechVolume = speechVolume;
	}



}
