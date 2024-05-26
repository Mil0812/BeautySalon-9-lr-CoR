package com.mil0812.beautySalon.domain.validatior.contract.ClientHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.ClientHandler;
import com.mil0812.beautySalon.persistence.entity.Client;

public class PasswordHandler implements ClientHandler {

	private ClientHandler nextClientHandler;

	@Override
	public void validate(Client client) {
		if (client.getPassword() == null) {
			client.getValidationMessages().add("Пароль не може бути пустим");
		} else if (client.getPassword().length() <= 4 || client.getPassword().length() >= 24) {
			client.getValidationMessages().add("Пароль не може бути меншим ніж 4 символа, "
			    + "та більший ніж 24");
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
