package com.mil0812.beautySalon.persistence.dao;

import com.mil0812.beautySalon.persistence.entity.BeautyMaster;
import com.mil0812.beautySalon.persistence.entity.Client;
import com.mil0812.beautySalon.persistence.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeautyMasterDao implements Dao<Integer, BeautyMaster> {

	private BeautyMasterDao() {
	}

	private static class BeautyMasterDaoHolder {

		public static final BeautyMasterDao INSTANCE = new BeautyMasterDao();
	}

	public static BeautyMasterDao getInstance() {
		return BeautyMasterDaoHolder.INSTANCE;
	}

	@Override
	public boolean create(BeautyMaster beautyMaster) {
		String sql = "INSERT INTO beauty_master(client_id, salary, experience_year) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, beautyMaster.getClient().getId());
			preparedStatement.setInt(2, beautyMaster.getSalary());
			preparedStatement.setInt(3, beautyMaster.getExperienceYear());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BeautyMaster> getAll() {
		String sql = "SELECT * FROM beauty_master";
		List<BeautyMaster> beautyMasters = new ArrayList<>();
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int clientId = resultSet.getInt("client_id");
				int salary = resultSet.getInt("salary");
				int experienceYear = resultSet.getInt("experience_year");
				Client client = Client.builder()
				    .id(clientId)
				    .build();
				BeautyMaster beautyMaster = BeautyMaster.builder()
				    .id(id)
				    .client(client)
				    .salary(salary)
				    .experienceYear(experienceYear)
				    .build();
				beautyMasters.add(beautyMaster);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beautyMasters;
	}

	@Override
	public BeautyMaster getById(Integer id) {
		String sql = "SELECT * FROM beauty_master WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int clientId = resultSet.getInt("client_id");
				int salary = resultSet.getInt("salary");
				int experienceYear = resultSet.getInt("experience_year");
				Client client = Client.builder()
				    .id(clientId)
				    .build();
				return BeautyMaster.builder()
				    .id(id)
				    .client(client)
				    .salary(salary)
				    .experienceYear(experienceYear)
				    .build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BeautyMaster update(BeautyMaster beautyMaster) {
		String sql = "UPDATE beauty_master SET client_id = ?, salary = ?, experience_year = ? WHERE id = ?";
		try (Connection connection = ConnectionManager.getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, beautyMaster.getClient().getId());
			preparedStatement.setInt(2, beautyMaster.getSalary());
			preparedStatement.setInt(3, beautyMaster.getExperienceYear());
			preparedStatement.setInt(4, beautyMaster.getId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				return beautyMaster;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		String sql = "DELETE FROM beauty_master WHERE id = ?";
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
