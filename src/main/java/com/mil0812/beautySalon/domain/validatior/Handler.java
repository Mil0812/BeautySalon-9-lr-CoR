package com.mil0812.beautySalon.domain.validatior;

public interface Handler<E, T extends Handler<E, T>>{

	void validate(E e);

	void setNextHandler(T t);
}
