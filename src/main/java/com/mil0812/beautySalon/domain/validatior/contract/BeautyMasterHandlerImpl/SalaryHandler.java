package com.mil0812.beautySalon.domain.validatior.contract.BeautyMasterHandlerImpl;

import com.mil0812.beautySalon.domain.validatior.impl.BeautyMasterHandler;
import com.mil0812.beautySalon.persistence.entity.BeautyMaster;

public class SalaryHandler implements BeautyMasterHandler {

	private BeautyMasterHandler nextBeautyMaster;

	@Override
	public void validate(BeautyMaster beautyMaster) {
		if (beautyMaster.getSalary() <= 0) {
			beautyMaster.getValidationMessages().add("Зарплата має бути більше 0");
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
