package com.mil0812.beautySalon;

import com.mil0812.beautySalon.domain.validatior.contract.AssistanceTypeHandlerImpl.DescriptionHandler;
import com.mil0812.beautySalon.domain.validatior.contract.AssistanceTypeHandlerImpl.NameHandler;
import com.mil0812.beautySalon.domain.validatior.contract.AssistanceTypeHandlerImpl.SalarysHandler;
import com.mil0812.beautySalon.domain.validatior.contract.BeautyMasterHandlerImpl.ExperienceYearHandler;
import com.mil0812.beautySalon.domain.validatior.contract.BeautyMasterHandlerImpl.SalaryHandler;
import com.mil0812.beautySalon.domain.validatior.contract.ClientHandlerImpl.FullNameHandler;
import com.mil0812.beautySalon.domain.validatior.contract.ClientHandlerImpl.PasswordHandler;
import com.mil0812.beautySalon.domain.validatior.contract.ClientHandlerImpl.PhoneNumberHandler;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;
import com.mil0812.beautySalon.persistence.entity.BeautyMaster;
import com.mil0812.beautySalon.persistence.entity.Client;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		//testClientValidation();

		//testBeautyMasterValidation();

		//testAssistanceTypeValidation();
	}

	private static void testAssistanceTypeValidation() {
		DescriptionHandler descriptionHandler = new DescriptionHandler();
		NameHandler nameHandler = new NameHandler();
		SalarysHandler salaryHandler = new SalarysHandler();

		descriptionHandler.setNextHandler(nameHandler);
		nameHandler.setNextHandler(salaryHandler);

		AssistanceType assistanceType = AssistanceType.builder()
		    .description("Test")
		    .name("Test")
		    .salary(123)
		    .build();

		printValidationMessagesIfAny(assistanceType.getValidationMessages());
	}

	private static void testBeautyMasterValidation() {
		ExperienceYearHandler experienceYearHandler = new ExperienceYearHandler();
		SalaryHandler salaryHandler = new SalaryHandler();

		experienceYearHandler.setNextHandler(salaryHandler);

		BeautyMaster beautyMaster = BeautyMaster.builder()
		    .experienceYear(10)
		    .salary(4000)
		    .build();

		printValidationMessagesIfAny(beautyMaster.getValidationMessages());
	}

	private static void testClientValidation() {
		FullNameHandler fullNameHandler = new FullNameHandler();
		PasswordHandler passwordHandler = new PasswordHandler();
		PhoneNumberHandler phoneNumberHandler = new PhoneNumberHandler();

		fullNameHandler.setNextHandler(passwordHandler);
		passwordHandler.setNextHandler(phoneNumberHandler);

		Client client = Client.builder()
		    .id(1)
		    .fullName("Q")
		    .password("1234")
		    .phoneNumber("qqqq")
		    .build();

		fullNameHandler.validate(client);

		printValidationMessagesIfAny(client.getValidationMessages());
	}

	public static void printValidationMessagesIfAny(List<String> validationMessages) {
		if (validationMessages != null && !validationMessages.isEmpty()) {
			System.out.println("Помилки: ");
			for (String validateMessage : validationMessages) {
				System.out.println("    - " + validateMessage);
			}
		} else {
			System.out.println("Успішне створення!");
		}
	}
}
