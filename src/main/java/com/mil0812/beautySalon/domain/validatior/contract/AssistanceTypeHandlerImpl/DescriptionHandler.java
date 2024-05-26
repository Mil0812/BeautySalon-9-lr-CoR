package com.mil0812.beautySalon.domain.validatior.contract.AssistanceTypeHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.AssistanceTypeHandler;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;

public class DescriptionHandler implements AssistanceTypeHandler {

	private AssistanceTypeHandler nextAssistanceTypeHandler;

	@Override
	public void validate(AssistanceType assistanceType) {
		if (assistanceType.getDescription() == null || assistanceType.getDescription()
		    .isEmpty()) {
			assistanceType.getValidationMessages().add("Опис не може бути порожнім");
		} else if (assistanceType.getName().length() > 150) {
			assistanceType.getValidationMessages()
			    .add("Опис перевищує максимальний розмір в 150 символів");
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
