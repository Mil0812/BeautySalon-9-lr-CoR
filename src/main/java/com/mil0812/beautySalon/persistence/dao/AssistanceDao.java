package com.mil0812.beautySalon.persistence.dao;

import com.mil0812.beautySalon.persistence.entity.Assistance;
import com.mil0812.beautySalon.persistence.entity.AssistanceType;
import com.mil0812.beautySalon.persistence.entity.BeautyMaster;
import com.mil0812.beautySalon.persistence.entity.Client;
import com.mil0812.beautySalon.persistence.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AssistanceDao implements Dao<Integer, Assistance> {


	private AssistanceDao() {
	}

	private static class AssistanceDaoHolder {

		public static final AssistanceDao INSTANCE = new AssistanceDao();
	}

	public static AssistanceDao getInstance() {
		return AssistanceDaoHolder.INSTANCE;
	}

	@Override
	public boolean create(Assistance assistance) {
		String sql = "INSERT INTO assistance(client_id, beauty_master_id, assistance_type_id, localDateTime) VALUES (?, ?, ?, ?)";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, assistance.getClient().getId());
			preparedStatement.setInt(2, assistance.getBeautyMaster().getId());
			preparedStatement.setInt(3, assistance.getAssistanceType().getId());
			preparedStatement.setTimestamp(4,
			    Timestamp.valueOf(assistance.getLocalDateTime()));

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Assistance> getAll() {
		String sql = "SELECT * FROM assistance";
		List<Assistance> assistanceList = new ArrayList<>();
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int clientId = resultSet.getInt("client_id");
				int beautyMasterId = resultSet.getInt("beauty_master_id");
				int assistanceTypeId = resultSet.getInt("assistance_type_id");
				LocalDateTime localDateTime = resultSet.getTimestamp("localDateTime")
				    .toLocalDateTime();

				Client client = Client.builder()
				    .id(clientId)
				    .build();
				BeautyMaster beautyMaster = BeautyMaster.builder()
				    .id(beautyMasterId)
				    .client(client)
				    .salary(0)
				    .experienceYear(0)
				    .build();
				AssistanceType assistanceType = AssistanceType.builder()
				    .id(assistanceTypeId)
				    .salary(0)
				    .build();

				Assistance assistance = Assistance.builder()
				    .id(id)
				    .client(client)
				    .beautyMaster(beautyMaster)
				    .localDateTime(localDateTime)
				    .assistanceType(assistanceType)
				    .build();
				assistanceList.add(assistance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assistanceList;
	}

	@Override
	public Assistance getById(Integer id) {
		String sql = "SELECT * FROM assistance WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int clientId = resultSet.getInt("client_id");
				int beautyMasterId = resultSet.getInt("beauty_master_id");
				int assistanceTypeId = resultSet.getInt("assistance_type_id");
				LocalDateTime localDateTime = resultSet.getTimestamp("localDateTime")
				    .toLocalDateTime();

				Client client = Client.builder()
				    .id(clientId)
				    .build();
				BeautyMaster beautyMaster = BeautyMaster.builder()
				    .id(beautyMasterId)
				    .client(client)
				    .salary(0)
				    .experienceYear(0)
				    .build();
				AssistanceType assistanceType = AssistanceType.builder()
				    .id(assistanceTypeId)
				    .salary(0)
				    .build();

				return Assistance.builder()
				    .id(id)
				    .client(client)
				    .beautyMaster(beautyMaster)
				    .localDateTime(localDateTime)
				    .assistanceType(assistanceType)
				    .build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Assistance update(Assistance assistance) {
		String sql = "UPDATE assistance SET client_id = ?, beauty_master_id = ?, assistance_type_id = ?, localDateTime = ? WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, assistance.getClient().getId());
			preparedStatement.setInt(2, assistance.getBeautyMaster().getId());
			preparedStatement.setInt(3, assistance.getAssistanceType().getId());
			preparedStatement.setTimestamp(4,
			    Timestamp.valueOf(assistance.getLocalDateTime()));
			preparedStatement.setInt(5, assistance.getId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				return assistance;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "DELETE FROM assistance WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
