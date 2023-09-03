package main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.modelos.Factura;

public class FacturaDAOImpleDerby implements FacturaDAO {

    private Connection connection;

    public FacturaDAOImpleDerby(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear_tabla() {
        try {
            // Define la tabla "factura" sin AUTO_INCREMENT
            String table = "CREATE TABLE factura (idFactura INT, idCliente INT NOT NULL, PRIMARY KEY(idFactura, idCliente))";
            PreparedStatement stmt = this.connection.prepareStatement(table);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Factura factura) {
        try {
            String insertar = "INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
            PreparedStatement prepared = connection.prepareStatement(insertar);
            prepared.setInt(1, factura.getFactura());
            prepared.setInt(2, factura.getCliente());
            prepared.executeUpdate();
            prepared.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Factura factura) {
        // Código para actualizar una factura en la base de datos
        // Implementa la lógica de actualización aquí
    }

    @Override
    public void eliminar(Factura factura) {
        // Código para eliminar una factura de la base de datos
        // Implementa la lógica de eliminación aquí
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
