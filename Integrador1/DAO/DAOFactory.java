package DAO;

import java.sql.Connection;

import ConnectionFactory;

public class DAOFactory {
	
	private static DAOFactory daoFactory = null;
	
	// este es el contructor que se llama de afuera
	public static DAOFactory getInstance() {
		
		if (daoFactory == null) new DaoFactory();
		return daoFatory;
	}
	
    private DAOFactory() {}

    // por cada ObjetoDAO se elige que tipo de conexion se usa (Derby o Mysql)
    
    public static ClienteDAO getClienteDAO(String type) {

        if (type.equals("mysql")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
            return new ClienteDAOImplMySQL(connection);
        } else if (type.equals("derby")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
            return new ClienteDAOImplMySQL(connection);
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
        }
    }

    public static FacturaDAO getFacturaDAO(String type) {

        if (type.equals("mysql")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
            return new FacturaDAOImplMySQL(connection);
        } else if (type.equals("derby")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
            return new FacturaDAOImplMySQL(connection);
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
        }
    }

    public static ProductoDAO getProductoDAO(String type) {

        if (type.equals("mysql")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
            return new ProductoDAOImplMySQL(connection);
        } else if (type.equals("derby")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
            return new ProductoDAOImplMySQL(connection);
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
        }
    }
    
    public static Factura_ProductoDAO getFactura_ProductoDAO(String type) {

        if (type.equals("mysql")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
            return new Factura_ProductoDAOImplMySQL(connection);
        } else if (type.equals("derby")) {
        	Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
            return new Factura_ProductoDAOImplMySQL(connection);
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
        }
    }
}
