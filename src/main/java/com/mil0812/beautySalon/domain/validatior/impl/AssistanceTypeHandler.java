package com.mil0812.beautySalon.domain.validatior.impl;

import com.mil0812.beautySalon.domain.validatior.Handler;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;

public interface AssistanceTypeHandler extends Handler<AssistanceType, AssistanceTypeHandler> {

	@Override
	void validate(AssistanceType assistanceType);

	@Override
	void setNextHandler(AssistanceTypeHandler assistanceTypeHandler);
}
