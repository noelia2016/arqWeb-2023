package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static final String DERBY = "derby";
	public static final String MYSQL = "mysql";

	private static ConnectionFactory instance = null;
	private Connection connection=null;
	private String motor=null;

	public static ConnectionFactory getInstance(String motor) {
	
		if (instance == null) {
			instance = new ConnectionFactory(motor);
		}
		return instance;
	}
	public static ConnectionFactory getInstance(){
		return instance;
	}

	private ConnectionFactory (String moto){
		motor=moto;
	}
	// conectar a la BD
	public Connection conectar() {

		if (this.connection != null) {
			this.disconnect();
		}

		// si eleijo conectarme con DERBY -- base embebida
		if (motor.equals(DERBY)) {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				this.connection = DriverManager.getConnection("jdbc:derby:midb;create=true");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// si elijo conectarme a traves de MysSQL
		if (motor.equals(MYSQL)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/midb", "root","");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.connection;
	}

	// retorna si conecta
	public Connection connection() {
		return this.connection;
	}

	// para desconectarse de la BD
	public void disconnect() {

		// si esta conectado realizo la desconexion
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
