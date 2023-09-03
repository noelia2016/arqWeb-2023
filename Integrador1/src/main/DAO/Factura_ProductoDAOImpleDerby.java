package main.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.modelos.Factura_Producto;

public class Factura_ProductoDAOImpleDerby implements Factura_ProductoDAO {
    private Connection connection;

	public Factura_ProductoDAOImpleDerby(Connection connection) {
		this.connection = connection;
	}
    @Override
    public void crear_tabla() {
        

        try {
                String table = "CREATE TABLE Factura_Producto (idFactura INT NOT NULL, idProducto INT, cantidad INT)";
                PreparedStatement stmt = this.connection.prepareStatement(table);
                stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Factura_Producto factura_Producto) {
        try {
            String insertar = "INSERT INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
            PreparedStatement prepared = connection.prepareStatement(insertar);
            prepared.setInt(1, factura_Producto.getFactura());
            prepared.setInt(2, factura_Producto.getProducto());
            prepared.setInt(3, factura_Producto.getCantidad());
            prepared.executeUpdate();
            prepared.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Factura_Producto Factura_Producto) {
        // Código para actualizar un Factura_Producto en la base de datos
        // Implementa la lógica de actualización aquí
    }

    @Override
    public void eliminar(Factura_Producto Factura_Producto) {
        // Código para eliminar un Factura_Producto de la base de datos
        // Implementa la lógica de eliminación aquí
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
