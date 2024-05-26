package com.mil0812.beautySalon.persistence.entity;

import java.util.List;

public abstract class Entity {
	private Integer id;
	List<String> validationMessages;

	public Entity(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<String> validationMessages) {
		this.validationMessages = validationMessages;
	}
}
