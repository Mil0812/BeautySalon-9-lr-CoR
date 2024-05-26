package com.mil0812.beautySalon.domain.validatior.contract.BeautyMasterHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.BeautyMasterHandler;
import com.mil0812.beautySalon.persistence.entity.BeautyMaster;

public class ExperienceYearHandler implements BeautyMasterHandler {

	private BeautyMasterHandler nextBeautyMaster;

	@Override
	public void validate(BeautyMaster beautyMaster) {
		if (beautyMaster.getExperienceYear() < 0) {
			beautyMaster.getValidationMessages().add("Рік досвіду має бути не менше 0");
		}
		if (nextBeautyMaster != null) {
			nextBeautyMaster.validate(beautyMaster);
		}
	}

	@Override
	public void setNextHandler(BeautyMasterHandler beautyMasterHandler) {
		nextBeautyMaster = beautyMasterHandler;
	}
}
