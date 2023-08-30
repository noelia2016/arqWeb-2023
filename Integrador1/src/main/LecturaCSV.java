package main;

// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

// import java.io.FileReader;
import java.io.Reader;

public class LecturaCSV {

	public static void main (String [] Args) throws IOException {
		// String directorioActual = System.getProperty("user.dir");
        // System.out.println("Directorio actual: " + directorioActual);

		/**  conexion de la BD */
		String driver="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
		| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri="jdbc:mysql://localhost:3306/midb";
        /** fin de conexion de la BD */

		try {

			// Connection miConeccion=DriverManager.getConnection(uri,"arq_2023","Bp)U[.!9LBZo8QY3");
			Connection miConeccion=DriverManager.getConnection(uri,"root","");
			miConeccion.setAutoCommit(false);


			// String[]  tablas = ['producto', 'cliente', 'factura', 'factura_producto'];
			String[]  tablas = {"producto", "cliente", "factura", "facturas-producto"};

			// lee los 4 cvs que tenemos para cargar la BD
			// for (String tablas : nombre) {
			for (String tabla : tablas) {
				
				// ruta donde esta el archivo por leer
				Reader reader = new FileReader("Integrador1/archivos/" + tabla + "s.csv");
				// Reader reader = new FileReader("C:/xampp/htdocs/Proyectos/arqWeb-2023/Integrador1/archivos/" + nombre + "s.csv");
				// Reader reader = new FileReader("src/tp1/po/"+nombre+"s.csv");

				// lee el archivo elegido
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
				for (CSVRecord csvRecord : csvParser) {

					// se preparan los datos que se leen del archivo para poder insertarlo
					String idString = (csvRecord.get(0)); // Por índice

					// se obtiene el id de la misma
					Integer numeroInteger = Integer.valueOf(idString); 
					int id = numeroInteger.intValue();

					String nombre="";
					PreparedStatement statement=null;
					switch (tabla) {
						
						case "producto":
							// el nombre del producto
							nombre = csvRecord.get("nombre"); // Por nombre de columna

							// valor del producto
							String valorString = csvRecord.get("valor"); // Por nombre de columna
							Float valor= Float.parseFloat(valorString);
							// System.out.println("Id: " + id+" "+ nombre +" "+valor);

							// por cada fila leida se inserta en la BD
							statement = miConeccion.prepareStatement("INSERT INTO producto (idProducto,nombre, valor) VALUES (?, ?,?)");
							statement.setInt(1, id );
							statement.setString(2, nombre);
							statement.setFloat(3, valor);

							break;
						case "cliente":
							// el nombre del producto
							nombre = csvRecord.get("nombre"); // Por nombre de columna
							// valor del producto
							String email = csvRecord.get("email"); // Por nombre de columna

							// por cada fila leida se inserta en la BD
							statement = miConeccion.prepareStatement("INSERT INTO cliente (idCliente,nombre, email) VALUES (?, ?,?)");
							statement.setInt(1, id );
							statement.setString(2, nombre);
							statement.setString(3, email);

							break;
						case "factura":
							// el nombre del producto
							String idClString=csvRecord.get("idCliente");
							Integer idClInteger = Integer.valueOf(idClString); 
							int idCliente = idClInteger.intValue();

							// por cada fila leida se inserta en la BD
							statement = miConeccion.prepareStatement("INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)");
							statement.setInt(1, id );
							statement.setInt(2, idCliente);
							break;
						case "factura_producto":

							// id del producto
							String idProductoString=csvRecord.get("idProducto");
							Integer idProductoInteger = Integer.valueOf(idProductoString); 
							int idProducto = idProductoInteger.intValue();

							// cantidad facturada del producto
							String cantidadString=csvRecord.get("cantidad");
							Integer cantidadInteger = Integer.valueOf(cantidadString); 
							int cantidad = cantidadInteger.intValue();

							// por cada fila leida se inserta en la BD
							statement = miConeccion.prepareStatement("INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)");
							statement.setInt(1, id );
							statement.setInt(2, idProducto);
							statement.setInt(3, cantidad);

							break;

					}
				
					if (statement!=null) statement.executeUpdate();
					// statement.close();
					// hace el commit para que se guarden los datos en la tabla
					miConeccion.commit();
					} // fin del iterador recorriendo el archivo
				csvParser.close();
				}
			// se cierra la conexion
			miConeccion.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // fin del recorrido de archivos
		
	}

