package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Cliente;
import util.ConnectionFactory;

public class ClienteDAOImpleMySQL implements ClienteDAO {
	private Connection connection;

	public ClienteDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		
		try {
			Statement stmt = this.connection.createStatement();
			// para crear la tabla en la BD
			String table = "CREATE TABLE cliente(idCliente INT, nombre VARCHAR(500), email VARCHAR(150), PRIMARY KEY(idCliente)";
			stmt.executeUpdate(table);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Cliente Cliente) {
		
		try {
			// nos conectamos
			Statement stmt = this.connection.createStatement();
			
			// código para insertar un Cliente en la base de datos
			String tableC = "INSERT INTO cliente (nombre, email) values (?,?)";
			ps = conn.prepareStatement(tableC);
			ps.setString(1, Cliente.getNombre);
			ps.setStrging(2, Cliente.getEmail);
			conn.prepareStatement(table).execute();
			stmt.executeUpdate(tableC);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void actualizar(Cliente Cliente) {
		// código para actualizar un Cliente en la base de datos
	}

	@Override
	public void eliminar(Cliente Cliente) {
		// código para eliminar un Cliente de la base de datos
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
