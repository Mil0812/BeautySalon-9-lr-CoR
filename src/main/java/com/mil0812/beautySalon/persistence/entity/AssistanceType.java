package com.mil0812.beautySalon.persistence.entity;

import java.util.ArrayList;

public class AssistanceType extends Entity {
	private String name;
	private String description;
	private int salary;

	public AssistanceType(AssistanceTypeBuilder builder) {
		super(builder.id);
		this.name = builder.name;
		this.description = builder.description;
		this.salary = builder.salary;
		this.validationMessages =new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "AssistanceType{" +
		    "name='" + name + '\'' +
		    ", description='" + description + '\'' +
		    ", salary=" + salary +
		    '}';
	}

	public static AssistanceTypeBuilder builder() {
		return new AssistanceTypeBuilder();
	}

	public static class AssistanceTypeBuilder {
		private Integer id;
		private String name;
		private String description;
		private int salary;

		public AssistanceTypeBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public AssistanceTypeBuilder name(String name) {
			this.name = name;
			return this;
		}

		public AssistanceTypeBuilder description(String description) {
			this.description = description;
			return this;
		}

		public AssistanceTypeBuilder salary(int salary) {
			this.salary = salary;
			return this;
		}

		public AssistanceType build() {
			return new AssistanceType(this);
		}
	}
}
