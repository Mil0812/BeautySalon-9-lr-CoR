package com.mil0812.beautySalon.domain.validatior.contract.AssistanceTypeHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.AssistanceTypeHandler;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;

public class NameHandler implements AssistanceTypeHandler {

	private AssistanceTypeHandler nextAssistanceTypeHandler;

	@Override
	public void validate(AssistanceType assistanceType) {
		if (assistanceType.getName() == null || assistanceType.getName().isEmpty()) {
			assistanceType.getValidationMessages().add("Назва не може бути порожньою");
		} else if (assistanceType.getName().length() > 100) {
			assistanceType.getValidationMessages().add("Назва перевищує 100 символів");
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
