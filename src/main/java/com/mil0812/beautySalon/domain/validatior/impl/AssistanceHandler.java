package com.mil0812.beautySalon.domain.validatior.impl;

import com.mil0812.beautySalon.domain.validatior.Handler;
import com.mil0812.beautySalon.persistence.entity.Assistance;

public interface AssistanceHandler extends Handler<Assistance, AssistanceHandler> {

	@Override
	void validate(Assistance assistance);

	@Override
	void setNextHandler(AssistanceHandler assistanceHandler);
}
