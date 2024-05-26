package com.mil0812.beautySalon.domain.validatior.contract.ClientHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.ClientHandler;
import com.mil0812.beautySalon.persistence.entity.Client;

public class PhoneNumberHandler implements ClientHandler {

	private ClientHandler nextClientHandler;

	@Override
	public void validate(Client client) {
		if (client.getPhoneNumber() == null) {
			client.getValidationMessages().add("Поле номер телефона не може бути пустим");
		} else if (client.getPhoneNumber().length() < 5) {
			client.getValidationMessages()
			    .add("Номер телефона не може бути меншим ніж 8 символів");
		}
		if (nextClientHandler != null) {
			nextClientHandler.validate(client);
		}
	}

	@Override
	public void setNextHandler(ClientHandler clientHandler) {
		nextClientHandler = clientHandler;
	}
}
