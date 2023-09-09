package main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// import main.ConnectionFactory;
import main.modelos.Factura_Producto;


public class Factura_ProductoDAOImpleMySQL implements Factura_ProductoDAO {
	private Connection connection;

	public Factura_ProductoDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		
		try {
			String table = "CREATE OR REPLACE TABLE Factura_Producto (idFactura INT NOT NULL, idProducto INT , cantidad INT)";
			PreparedStatement stmt = this.connection.prepareStatement(table);
			// para crear la tabla en la BD
			stmt.executeUpdate(table);
			// ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Factura_Producto factura_Producto) {
		
		try {
			String insertar="INSERT IGNORE INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES (?,?,?)";
			PreparedStatement prepared = connection.prepareStatement(insertar);
			prepared.setInt(1,factura_Producto.getFactura());
			prepared.setInt(2,factura_Producto.getProducto());
			prepared.setInt(3,factura_Producto.getCantidad());
			prepared.executeUpdate();
			prepared.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

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
		String select="SELECT * FROM Factura_Producto";
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
