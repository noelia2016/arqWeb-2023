package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Producto;
import util.ConnectionFactory;

public class ProductoDAOImpleMyDerby implements ProductoDAO {
	private Connection connection;

	public ProductoDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			String table = "CREATE TABLE Producto (idProducto INT, nombre VARCHAR(500),valor FLOAT, PRIMARY KEY(idProducto))";
			stmt.executeUpdate(table);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Producto Producto) {
		// código para insertar un Producto en la base de datos
	}

	@Override
	public void actualizar(Producto Producto) {
		// código para actualizar un Producto en la base de datos
	}

	@Override
	public void eliminar(Producto Producto) {
		// código para eliminar un Producto de la base de datos
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
