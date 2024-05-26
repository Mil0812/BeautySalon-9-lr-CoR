package com.mil0812.beautySalon.domain.validatior.impl;

import com.mil0812.beautySalon.domain.validatior.Handler;
import com.mil0812.beautySalon.persistence.entity.BeautyMaster;

public interface BeautyMasterHandler extends Handler<BeautyMaster, BeautyMasterHandler> {

	@Override
	void validate(BeautyMaster beautyMaster);

	@Override
	void setNextHandler(BeautyMasterHandler beautyMasterHandler);
}
