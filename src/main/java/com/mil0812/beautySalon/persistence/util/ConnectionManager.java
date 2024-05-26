package com.mil0812.beautySalon.persistence.util;

import com.mil0812.beautySalon.persistence.exception.ConnectionCloseException;
import com.mil0812.beautySalon.persistence.exception.ConnectionPoolException;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionManager {

	private static final String URL_KEY = "db.url";
	private static final String POOL_SIZE_KEY = "db.pool.size";
	private static final Integer DEFAULT_POOL_SIZE = 10;
	private static BlockingQueue<Connection> pool;
	private static List<Connection> sourceConnection;

	static {
		initConnectionPool();
	}

	private ConnectionManager() {
	}

	public static Connection getConnection() {
		try {
			return pool.take();
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Помилка при отриманні пула: " + e);
		}
	}

	public static Connection open() {
		try {
			return DriverManager.getConnection(
			    PropertiesUtil.getProperty(URL_KEY)
			);
		} catch (SQLException e) {
			throw new ConnectionCloseException("Помилка при відкритті конекшена: " + e);
		}
	}

	private static void initConnectionPool() {
		var poolSize = PropertiesUtil.getProperty(POOL_SIZE_KEY);
		var size = poolSize == null ? DEFAULT_POOL_SIZE : Integer.parseInt(poolSize);

		pool = new ArrayBlockingQueue<>(Integer.parseInt(Objects.requireNonNull(poolSize)));
		sourceConnection = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			var connection = open();
			var proxyConnection = (Connection)
			    Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(),
				  new Class[]{Connection.class},
				  (proxy, method, args) -> method.getName().equals("close")
					? pool.add((Connection) proxy)
					: method.invoke(connection, args));
			pool.add(proxyConnection);
			sourceConnection.add(connection);
		}
	}

	public static void closePool() {
		try {
			for (Connection sourceConnection : sourceConnection) {
				sourceConnection.close();
			}
		} catch (SQLException e) {
			throw new ConnectionCloseException("Помилка під час закривання пула: " + e);
		}
	}
}
