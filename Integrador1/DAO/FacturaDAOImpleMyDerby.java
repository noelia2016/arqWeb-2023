package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Factura;
import util.ConnectionFactory;

public class FacturaDAOImpleMyDerby implements FacturaDAO {
	private Connection connection;

	public FacturaDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			String table = "CREATE TABLE Factura (idFactura INT, int idCliente, PRIMARY KEY(idFactura))";
			stmt.executeUpdate(table);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Factura Factura) {
		// código para insertar un Factura en la base de datos
	}

	@Override
	public void actualizar(Factura Factura) {
		// código para actualizar un Factura en la base de datos
	}

	@Override
	public void eliminar(Factura Factura) {
		// código para eliminar un Factura de la base de datos
	}

	@Override
	public List<Factura> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
