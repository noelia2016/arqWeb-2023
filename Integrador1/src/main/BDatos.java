package main;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.iapi.sql.PreparedStatement;

public class BDatos {

	// Creo tabla cliente
	private static void createTableCliente(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "CREATE TABLE cliente(" +
		"idCliente INT," +
		"nombre VARCHAR(500)," +
		"email VARCHAR(150)," +
		"PRIMARY KEY(idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}
	
	// Creo tabla producto
	private static void createTableProducto(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "CREATE TABLE producto(" +
		"idProducto INT," +
		"nombre VARCHAR(500)," +
		"valor FLOAT," +
		"PRIMARY KEY(idProducto))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}
	
	// Creo tabla factura
	private static void createTableFactura(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "CREATE TABLE factura(" +
		"idFactura INT," +
		"idCliente INT," +
		"PRIMARY KEY(idFactura))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}
	
	// Creo tabla producto - factura
	private static void createTableFactura_Producto(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "CREATE TABLE factura_producto(" +
		"idFactura INT," +
		"idCliente INT," +
		"cantidad INT)";
		conn.prepareStatement(table).execute();
		conn.commit();
	}

	// Inserto datos en la tabla cliente
	private static void insertCliente(Connection conn, String nombre, String email) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "INSERT INTO cliente (nombre, email) values (?,?)";
		// faltan los parametros
		conn.prepareStatement(table).execute();
		conn.commit();
	}

	// Inserto datos en la tabla factura
	private static void insertFactura(Connection conn, Int cliente) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "INSERT INTO factura (idCliente) values (?)";
		// faltan los parametros
		conn.prepareStatement(table).execute();
		conn.commit();
	}

	// Inserto datos en la tabla producto
	private static void insertProducto(Connection conn, String nombre, Float valor) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "INSERT INTO producto (nombre, valor) values (?,?)";
		// faltan los parametros
		conn.prepareStatement(table).execute();
		conn.commit();
	}

	// Inserto datos en la tabla producto - factura
	private static void insertFactura_Producto(Connection conn, int factura, int cliente, int cantidad) throws SQLException {
		// TODO Auto-generated method stub
		
		String table = "INSERT INTO factura_producto (idFactura, idCliente,cantidad) values (?,?,?)";
		// faltan los parametros
		conn.prepareStatement(table).execute();
		conn.commit();
	}


}
