package com.example.demo.persistence.dtos;

public class CatDTO {
	private Long id;
	private String name;
	private int speechVolume;
	
	
	public CatDTO() {
		super();
	}


	public CatDTO(Long id, String name, int speechVolume) {
		super();
		this.id = id;
		this.name = name;
		this.speechVolume = speechVolume;
	}


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


	public int getSpeechVolume() {
		return speechVolume;
	}


	public void setSpeechVolume(int speechVolume) {
		this.speechVolume = speechVolume;
	}


}
