package main;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import main.DAO.ClienteDAO;
import main.DAO.FacturaDAO;
import main.DAO.Factura_ProductoDAO;
import main.DAO.ProductoDAO;
import main.factory.DAOFactory;
import main.modelos.Cliente;
import main.modelos.Factura;
import main.modelos.Factura_Producto;
import main.modelos.Producto;
public class Main {
	
	// public static String ubicacion="arqWeb-2023/Integrador1/archivos/";
	public static String ubicacion="Integrador1/archivos/";

	public static void main(String[] args) {

		// elegimos el motor de BD a trabajar
		// final String motor = "mysql";
		final String motor = "derby";

		DAOFactory miDao = DAOFactory.getInstance(motor);

		// //Productos 
	 	ProductoDAO miDaoProducto = miDao.getProductoDAO();
		miDaoProducto.crear_tabla();
		incorporarProductos(miDaoProducto);
		miDaoProducto.listar();
 
		// //Clientes 
		ClienteDAO miDaoCliente = miDao.getClienteDAO();
		miDaoCliente.crear_tabla();
		incorporarClientes(miDaoCliente);
		miDaoCliente.listar();

		//Facturas
		FacturaDAO miDaoFactura = miDao.getFacturaDAO();
		miDaoFactura.crear_tabla();
		incorporarFacturas(miDaoFactura);
		miDaoFactura.listar();

		//Factura_Productos 
		Factura_ProductoDAO miDaoFactura_Producto = miDao.getFactura_ProductoDAO();
		miDaoFactura_Producto.crear_tabla();
		incorporarFactura_Productos(miDaoFactura_Producto);
		miDaoFactura_Producto.listar();

		
		consultaPunto4(miDao, motor);
		consultaPunto5(miDao);
		miDao.desconectar();
	}
	public static void incorporarProductos(ProductoDAO dao) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ubicacion+"productos.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			int id = Integer.parseInt(row.get("idProducto"));
			String nombre = row.get("nombre");
			Float valor = Float.parseFloat(row.get("valor"));
			Producto pro = new Producto(id, nombre, valor);
			dao.insertar(pro);
		}
	}

	public static void incorporarClientes(ClienteDAO dao) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ubicacion+"clientes.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			int id = Integer.parseInt(row.get("idCliente"));
			String nombre = row.get("nombre");
			String email = row.get("email");
			Cliente cli = new Cliente(id, nombre, email);
			dao.insertar(cli);
		}
	}

	public static void incorporarFacturas(FacturaDAO dao) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ubicacion+"facturas.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			int idF = Integer.parseInt(row.get("idFactura"));
			int idC = Integer.parseInt(row.get("idCliente"));
			Factura f = new Factura(idF, idC);
			dao.insertar(f);
		}

	}

	public static void incorporarFactura_Productos(Factura_ProductoDAO dao) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader()
					.parse(new FileReader(ubicacion+"facturas-productos.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			int idF = Integer.parseInt(row.get("idFactura"));
			int idP = Integer.parseInt(row.get("idProducto"));
			int idC = Integer.parseInt(row.get("cantidad"));
			Factura_Producto f = new Factura_Producto(idF, idP, idC);
			dao.insertar(f);
		}
	}

	public static void consultaPunto4(DAOFactory dao, String motor) {
		Connection connection= dao.getConnection();
		String consulta=null;
		if (motor=="mysql") consulta = "SELECT p.nombre AS producto, SUM(fp.cantidad * p.valor) AS recaudacion FROM Factura_Producto fp INNER JOIN Producto p ON fp.idProducto = p.idProducto GROUP BY p.nombre ORDER BY recaudacion DESC LIMIT 1;";
		else consulta = "SELECT p.nombre AS producto, SUM(fp.cantidad * p.valor) AS recaudacion FROM Factura_Producto fp INNER JOIN Producto p ON fp.idProducto = p.idProducto GROUP BY p.nombre ORDER BY recaudacion DESC FETCH FIRST 1 ROWS ONLY";


		try (Statement pre = connection.createStatement()) {
			ResultSet resultado = pre.executeQuery(consulta);

			while (resultado.next()) {
				String nombreProducto = resultado.getString("producto");
            	double recaudacion = resultado.getDouble("recaudacion");

				System.out.println("Producto: " + nombreProducto);
				System.out.println("Recaudación: $" + recaudacion);
				}
			// this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void consultaPunto5(DAOFactory dao) {
		Connection connection= dao.getConnection();
		String consulta= "SELECT c.idCliente, c.nombre AS nombreCliente, c.email, SUM(p.valor * fp.cantidad) AS totalFacturado FROM cliente c INNER JOIN factura f ON c.idCliente = f.idCliente INNER JOIN Factura_Producto fp ON f.idFactura = fp.idFactura INNER JOIN Producto p ON fp.idProducto = p.idProducto GROUP BY c.idCliente, c.nombre, c.email ORDER BY totalFacturado DESC";
		
		
		try (Statement pre = connection.createStatement()) {
			ResultSet resultado = pre.executeQuery(consulta);

			while (resultado.next()) {
				int idCliente = resultado.getInt("idCliente");
				String nombreCliente = resultado.getString("nombreCliente");
				double totalFacturado = resultado.getDouble("totalFacturado");

				System.out.println("ID Cliente: " + idCliente + "Nombre Cliente: " + nombreCliente + "Total Facturado: $" + totalFacturado);
				
			}
			// this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}