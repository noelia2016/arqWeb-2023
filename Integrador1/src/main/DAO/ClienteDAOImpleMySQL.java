package main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// import main.ConnectionFactory;
import main.modelos.Cliente;


public class ClienteDAOImpleMySQL implements ClienteDAO {
	private Connection connection;

	public ClienteDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		
		try {
			String table = "CREATE OR REPLACE TABLE cliente (idCliente INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(500), email VARCHAR(150), PRIMARY KEY(idCliente))";
			PreparedStatement stmt = this.connection.prepareStatement(table);
			// para crear la tabla en la BD
			stmt.executeUpdate(table);
			// ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Cliente cliente) {
		
		try {
			String insertar="INSERT IGNORE INTO cliente (nombre, email) VALUES (?,?)";
			PreparedStatement prepared = connection.prepareStatement(insertar);
			prepared.setString(1,cliente.getNombre());
			prepared.setString(2,cliente.getEmail());
			prepared.executeUpdate();
			prepared.close();
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
		String select="SELECT * FROM cliente";
			try (Statement pre = this.connection.createStatement()) {
				ResultSet resultado=pre.executeQuery(select);

				while (resultado.next()){
					System.out.println(resultado.getInt(1)+" "+resultado.getString(2)+" "+resultado.getString(3));
				}
				// this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		return null;
	}

	

	
}
