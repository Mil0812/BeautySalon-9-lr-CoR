package com.mil0812.beautySalon.domain.validatior.contract.AssistanceTypeHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.AssistanceTypeHandler;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;

public class SalarysHandler implements AssistanceTypeHandler {

	private AssistanceTypeHandler nextAssistanceTypeHandler;

	@Override
	public void validate(AssistanceType assistanceType) {
		if (assistanceType.getSalary() < 0) {
			assistanceType.getValidationMessages()
			    .add("Заробітна плата не може бути від'ємною");
		}
		if (nextAssistanceTypeHandler != null) {
			nextAssistanceTypeHandler.validate(assistanceType);
		}
	}

	@Override
	public void setNextHandler(AssistanceTypeHandler assistanceTypeHandler) {
		this.nextAssistanceTypeHandler = assistanceTypeHandler;
	}
}
