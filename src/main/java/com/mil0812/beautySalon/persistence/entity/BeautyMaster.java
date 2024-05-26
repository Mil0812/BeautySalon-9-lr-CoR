package com.mil0812.beautySalon.persistence.entity;

import java.util.ArrayList;

public class BeautyMaster extends Entity {
	private Client client;
	private int salary;
	private int experienceYear;

	public BeautyMaster(BeautyMasterBuilder builder) {
		super(builder.id);
		this.client = builder.client;
		this.salary = builder.salary;
		this.experienceYear = builder.experienceYear;
		this.validationMessages =new ArrayList<>();
	}

	public Client getClient() {
		return client;
	}

	public int getSalary() {
		return salary;
	}

	public int getExperienceYear() {
		return experienceYear;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setExperienceYear(int experienceYear) {
		this.experienceYear = experienceYear;
	}

	@Override
	public String toString() {
		return "BeautyMaster{" +
		    "client=" + client +
		    ", salary=" + salary +
		    ", experienceYear=" + experienceYear +
		    '}';
	}

	public static BeautyMasterBuilder builder() {
		return new BeautyMasterBuilder();
	}

	public static class BeautyMasterBuilder {
		private Integer id;
		private Client client;
		private int salary;
		private int experienceYear;

		public BeautyMasterBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public BeautyMasterBuilder client(Client client) {
			this.client = client;
			return this;
		}

		public BeautyMasterBuilder salary(int salary) {
			this.salary = salary;
			return this;
		}

		public BeautyMasterBuilder experienceYear(int experienceYear) {
			this.experienceYear = experienceYear;
			return this;
		}

		public BeautyMaster build() {
			return new BeautyMaster(this);
		}
	}
}
