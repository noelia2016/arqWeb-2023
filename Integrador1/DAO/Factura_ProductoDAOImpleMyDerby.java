package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Modelo.Factura_Producto;
import util.ConnectionFactory;

public class Factura_ProductoDAOImpleMyDerby implements Factura_Factura_ProductoDAO {
	private Connection connection;

	public Factura_ProductoDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			String table = "CREATE TABLE factura_producto(idFactura INT, idCliente INT, cantidad INT)";
			stmt.executeUpdate(table);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Factura_Producto Factura_Producto) {
		// código para insertar un Factura_Producto en la base de datos
	}

	@Override
	public void actualizar(Factura_Producto Factura_Producto) {
		// código para actualizar un Factura_Producto en la base de datos
	}

	@Override
	public void eliminar(Factura_Producto Factura_Producto) {
		// código para eliminar un Factura_Producto de la base de datos
	}

	@Override
	public List<Factura_Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
