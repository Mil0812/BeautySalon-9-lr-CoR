package com.mil0812.beautySalon;

import com.mil0812.beautySalon.persistence.dao.AssistanceDao;
import com.mil0812.beautySalon.persistence.dao.AssistanceTypeDao;
import com.mil0812.beautySalon.persistence.dao.BeautyMasterDao;
import com.mil0812.beautySalon.persistence.dao.ClientDao;
import com.mil0812.beautySalon.persistence.entity.Assistance;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;
import com.mil0812.beautySalon.persistence.entity.BeautyMaster;
import com.mil0812.beautySalon.persistence.entity.Client;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

	private static final ClientDao clientDao = ClientDao.getInstance();
	private static final BeautyMasterDao beautyMasterDao = BeautyMasterDao.getInstance();
	private static final AssistanceTypeDao assistanceTypeDao = AssistanceTypeDao.getInstance();
	private static final AssistanceDao assistanceDao = AssistanceDao.getInstance();

	public static void main(String[] args) {
		////////////////////////////////////

//		createClient();
//		getAllClients();
//		getClientById();
//		updateClient();
//		deleteClient();

		////////////////////////////////////

//		createBeautyMaster();
//		getAllBeautyMasters();
//		getBeautyMasterById();
//		updateBeautyMaster();
//		deleteBeautyMaster();

		////////////////////////////////////

//		createAssistanceType();
//		getAllAssistanceTypes();
//		getAssistanceById();
//		updateAssistanceType();
//		deleteAssistanceType();

		////////////////////////////////////

//		createAssistance();
//		getAllAssistances();
//		getAllAssistances();
//		updateAssistance();
//		deleteAssistance();

		////////////////////////////////////
	}

	private static void createClient() {
		Client client = Client.builder()
		    .fullName("John Doe")
		    .password("123456789")
		    .phoneNumber("password")
		    .build();
		clientDao.create(client);
	}

	private static void getClientById() {
		Client client = clientDao.getById(1);
		System.out.println("Client with ID 1:");
		System.out.println(client);
	}

	private static void getBeautyMasterById() {
		BeautyMaster beautyMaster = beautyMasterDao.getById(1);
		System.out.println("Beauty Master with ID 1:");
		System.out.println(beautyMaster);
	}

	private static void getAssistanceTypeById() {
		AssistanceType assistanceType = assistanceTypeDao.getById(1);
		System.out.println("Assistance Type with ID 1:");
		System.out.println(assistanceType);
	}

	private static void getAssistanceById() {
		Assistance assistance = assistanceDao.getById(1);
		System.out.println("Assistance with ID 1:");
		System.out.println(assistance);
	}

	private static void getAllClients() {
		List<Client> allClients = clientDao.getAll();
		System.out.println("All Clients:");
		for (Client c : allClients) {
			System.out.println(c);
		}
	}

	private static void createBeautyMaster() {
		Client client = clientDao.getById(2);
		BeautyMaster beautyMaster = BeautyMaster.builder()
		    .client(client)
		    .salary(1000)
		    .experienceYear(5)
		    .build();
		beautyMasterDao.create(beautyMaster);
	}

	private static void getAllBeautyMasters() {
		List<BeautyMaster> allBeautyMasters = beautyMasterDao.getAll();
		System.out.println("All Beauty Masters:");
		for (BeautyMaster bm : allBeautyMasters) {
			System.out.println(bm);
		}
	}

	private static void createAssistanceType() {
		AssistanceType assistanceType = AssistanceType.builder()
		    .name("Haircut")
		    .description("Hair cutting service")
		    .salary(50)
		    .build();
		assistanceTypeDao.create(assistanceType);
	}

	private static void getAllAssistanceTypes() {
		List<AssistanceType> allAssistanceTypes = assistanceTypeDao.getAll();
		System.out.println("All Assistance Types:");
		for (AssistanceType at : allAssistanceTypes) {
			System.out.println(at);
		}
	}

	private static void createAssistance() {
		Client client = clientDao.getById(2);
		BeautyMaster beautyMaster = beautyMasterDao.getById(1);
		AssistanceType assistanceType = assistanceTypeDao.getById(1);
		Assistance assistance = Assistance.builder()
		    .client(client)
		    .beautyMaster(beautyMaster)
		    .localDateTime(LocalDateTime.now())
		    .assistanceType(assistanceType)
		    .build();
		assistanceDao.create(assistance);
	}

	private static void getAllAssistances() {
		List<Assistance> allAssistances = assistanceDao.getAll();
		System.out.println("All Assistances:");
		for (Assistance a : allAssistances) {
			System.out.println(a);
		}
	}

	private static void updateClient() {
		Client client = clientDao.getById(1);
		client.setFullName("Updated Name");
		clientDao.update(client);
	}

	private static void updateBeautyMaster() {
		BeautyMaster beautyMaster = beautyMasterDao.getById(1);
		beautyMaster.setSalary(1500);
		beautyMasterDao.update(beautyMaster);
	}

	private static void updateAssistanceType() {
		AssistanceType assistanceType = assistanceTypeDao.getById(1);
		assistanceType.setSalary(60);
		assistanceTypeDao.update(assistanceType);
	}

	private static void updateAssistance() {
		Assistance assistance = assistanceDao.getById(1);
		assistance.setLocalDateTime(LocalDateTime.now().minusDays(1));
		assistanceDao.update(assistance);
	}

	private static void deleteClient() {
		clientDao.delete(1);
	}

	private static void deleteBeautyMaster() {
		beautyMasterDao.delete(1);
	}

	private static void deleteAssistanceType() {
		assistanceTypeDao.delete(1);
	}

	private static void deleteAssistance() {
		assistanceDao.delete(1);
	}
}
