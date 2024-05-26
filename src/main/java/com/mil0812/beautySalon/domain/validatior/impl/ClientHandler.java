package com.mil0812.beautySalon.domain.validatior.impl;

import com.mil0812.beautySalon.domain.validatior.Handler;
import com.mil0812.beautySalon.persistence.entity.Client;

public interface ClientHandler extends Handler<Client, ClientHandler> {

	@Override
	void validate(Client client);

	@Override
	void setNextHandler(ClientHandler clientHandler);
}
