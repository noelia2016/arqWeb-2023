package main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// import main.ConnectionFactory;
import main.modelos.Cliente;
import main.modelos.Factura;


public class FacturaDAOImpleMySQL implements FacturaDAO {
	private Connection connection;

	public FacturaDAOImpleMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		
		try {
			String table = "CREATE OR REPLACE TABLE factura (idFactura INT NOT NULL, idCliente INT NOT NULL, PRIMARY KEY(idFactura, idCliente))";
			PreparedStatement stmt = this.connection.prepareStatement(table);
			
			// para crear la tabla en la BD
			stmt.executeUpdate(table);
			// ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertar(Factura factura) {
		
		try {
			String insertar="INSERT IGNORE INTO factura (idCliente) VALUES (?)";
			PreparedStatement prepared = connection.prepareStatement(insertar);
			prepared.setInt(1,factura.getCliente());
			prepared.executeUpdate();
			prepared.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void actualizar(Factura factura) {
		// código para actualizar un Cliente en la base de datos
	}

	@Override
	public void eliminar(Factura factura) {
		// código para eliminar un Cliente de la base de datos
	}

	@Override
	public List<Factura> listar() {
		// TODO Auto-generated method stub
		String select="SELECT * FROM factura";
			try (Statement pre = this.connection.createStatement()) {
				ResultSet resultado=pre.executeQuery(select);

				while (resultado.next()){
					System.out.println(resultado.getInt(1)+" "+resultado.getInt(2));
				}
				// this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		return null;
	}

	

	
}
