package com.simonsays.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Command {

	@Id
	@Column
	private int id;

	@Column
	private String name;



	public String getName() {
		return name;
	}

	public Command setName(String name) {
		this.name = name;
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
