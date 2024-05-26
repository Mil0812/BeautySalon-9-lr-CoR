package com.mil0812.beautySalon.domain.validatior.contract.ClientHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.ClientHandler;
import com.mil0812.beautySalon.persistence.entity.Client;

public class FullNameHandler implements ClientHandler {

	private ClientHandler nextClientHandler;

	@Override
	public void validate(Client client) {
		if (client.getFullName() == null) {
			client.getValidationMessages().add("ПІБ не може бути пустим");
		} else if (client.getFullName().length() <= 10) {
			client.getValidationMessages().add("ПІБ не може бути меншим ніж 10 символів");
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
