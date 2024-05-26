package com.mil0812.beautySalon.persistence.entity;

import java.util.ArrayList;

public class Client extends Entity {
	private String fullName;
	private String phoneNumber;
	private String password;

	public Client(ClientBuilder builder) {
		super(builder.id);
		this.fullName = builder.fullName;
		this.phoneNumber = builder.phoneNumber;
		this.password = builder.password;
		this.validationMessages =new ArrayList<>();
	}

	public String getFullName() {
		return fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client{" +
		    "id=" + getId() +
		    ", fullName='" + fullName + '\'' +
		    ", phoneNumber='" + phoneNumber + '\'' +
		    ", password='" + password + '\'' +
		    '}';
	}

	public static ClientBuilder builder() {
		return new ClientBuilder();
	}

	public static class ClientBuilder {
		private Integer id;
		private String fullName;
		private String phoneNumber;
		private String password;

		public ClientBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public ClientBuilder fullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public ClientBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public ClientBuilder password(String password) {
			this.password = password;
			return this;
		}

		public Client build() {
			return new Client(this);
		}
	}
}
