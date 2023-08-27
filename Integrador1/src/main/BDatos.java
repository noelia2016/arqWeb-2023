package main;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.iapi.sql.PreparedStatement;

public class BDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// para configurar los driver de la BD
		String driver="org.apache.derby.jdbc.EmbeddedDriver";
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e  ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		// donde nos conectamos si no esta la crea a la DB
		String url = "jdbc:derby:MyDerbyDb;create=true";
		
		// nos conectamos a la BD y por si las dudas le damos una exception con try catch
		try {
			Connection conn = DriverManager.getConnection(url);
			createTablaCliente(conn);
			addPerson(conn, 1, "Juan", 20);
			addPerson(conn, 2, "Juan Pedro", 30);
			addPerson(conn, 3, "Marta", 40);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* actualizo un valor de la BD */
	private static void updatePerson(Connection conn, int id, String nombre, int edad) throws SQLException {
		// TODO Auto-generated method stub
		String update = "UPDATE persona set (nombre, edad) VALUES (?,?) WHERE id = ?";
		java.sql.PreparedStatement ps = conn.prepareStatement(update);
		ps.setString(1, nombre);
		ps.setInt(2, edad);
		ps.setInt(3, id);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}
	
	/* actualizo un valor de la BD */
	private static void deleteupdatePerson(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM persona WHERE id = ?";
		java.sql.PreparedStatement ps = conn.prepareStatement(delete);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}
	
	private static void addPerson(Connection conn, int id, String nombre, int edad) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?,?,?)";
		java.sql.PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setInt(3, edad);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

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
		"cantidad INT")";
		conn.prepareStatement(table).execute();
		conn.commit();
	}

}
