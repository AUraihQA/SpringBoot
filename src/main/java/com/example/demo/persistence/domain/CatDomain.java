package com.example.demo.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CatDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@NotNull
	private int age;
	private Integer speechVolume;
	
	@ManyToOne
	private HouseDomain myHouse;

	// alt + shift + S

	// CONSTRUCTOR
	// No Args
	public CatDomain() {
		super();
	}

	// All Args

	public CatDomain(Long id, String name, Integer age, int speechVolume, HouseDomain myHouse) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
		this.myHouse = myHouse;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSpeechVolume() {
		return speechVolume;
	}

	public void setSpeechVolume(Integer speechVolume) {
		this.speechVolume = speechVolume;
	}

	public HouseDomain getMyHouse() {
		return myHouse;
	}

	public void setMyHouse(HouseDomain myHouse) {
		this.myHouse = myHouse;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	



}
