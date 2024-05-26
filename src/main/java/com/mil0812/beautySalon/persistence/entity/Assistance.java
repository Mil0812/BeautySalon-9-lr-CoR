package com.mil0812.beautySalon.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assistance extends Entity {
	private Client client;
	private BeautyMaster beautyMaster;
	private LocalDateTime localDateTime;
	private AssistanceType assistanceType;

	public Assistance(AssistanceBuilder builder) {
		super(builder.id);
		this.client = builder.client;
		this.beautyMaster = builder.beautyMaster;
		this.localDateTime = builder.localDateTime;
		this.assistanceType = builder.assistanceType;
		this.validationMessages =new ArrayList<>();
	}

	public Client getClient() {
		return client;
	}

	public BeautyMaster getBeautyMaster() {
		return beautyMaster;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public AssistanceType getAssistanceType() {
		return assistanceType;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setBeautyMaster(BeautyMaster beautyMaster) {
		this.beautyMaster = beautyMaster;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public void setAssistanceType(AssistanceType assistanceType) {
		this.assistanceType = assistanceType;
	}

	@Override
	public String toString() {
		return "Assistance{" +
		    "client=" + client +
		    ", beautyMaster=" + beautyMaster +
		    ", localDateTime=" + localDateTime +
		    ", assistanceType=" + assistanceType +
		    '}';
	}

	public static AssistanceBuilder builder() {
		return new AssistanceBuilder();
	}

	public static class AssistanceBuilder {
		private Integer id;
		private Client client;
		private BeautyMaster beautyMaster;
		private LocalDateTime localDateTime;
		private AssistanceType assistanceType;

		public AssistanceBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public AssistanceBuilder client(Client client) {
			this.client = client;
			return this;
		}

		public AssistanceBuilder beautyMaster(BeautyMaster beautyMaster) {
			this.beautyMaster = beautyMaster;
			return this;
		}

		public AssistanceBuilder localDateTime(LocalDateTime localDateTime) {
			this.localDateTime = localDateTime;
			return this;
		}

		public AssistanceBuilder assistanceType(AssistanceType assistanceType) {
			this.assistanceType = assistanceType;
			return this;
		}

		public Assistance build() {
			return new Assistance(this);
		}
	}
}
