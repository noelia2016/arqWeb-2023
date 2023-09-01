package main.DAO;

import main.ConnectionFactory;

import java.sql.Connection;

public class DAOFactory {

    private static DAOFactory daoFactory = null;
    private static String motor = null;

    // este es el contructor que se llama de afuera
    public static DAOFactory getInstance(String moto) {

        if (daoFactory == null) {
            daoFactory = new DAOFactory();
            motor = moto;
        }
        return daoFactory;
    }

    private DAOFactory() {
    }

    // por cada ObjetoDAO se elige que tipo de conexion se usa (Derby o Mysql)

    public ClienteDAO getClienteDAO() {
        Connection connection = ConnectionFactory.getInstance(motor).conectar();

        if (motor.equals("mysql")) {
            return new ClienteDAOImpleMySQL(connection);
        } else if (motor.equals("derby")) {
            return null;
            // return new ClienteDAOImplMySQL(connection);
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + motor);
        }
    }

    public static FacturaDAO getFacturaDAO() {
        Connection connection = ConnectionFactory.getInstance(motor).conectar();

        if (motor.equals("mysql")) {

            return new FacturaDAOImpleMySQL(connection);
        } else if (motor.equals("derby")) {
            return null;
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + motor);
        }
    }

    public static Factura_ProductoDAO getFactura_ProductoDAO() {
        Connection connection = ConnectionFactory.getInstance(motor).conectar();
        
        if (motor.equals("mysql")) {
            return new Factura_ProductoDAOImpleMySQL(connection);
        } else if (motor.equals("derby")) {
            // return new Factura_ProductoDAOImplMySQL(connection);
            return null;
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + motor);
        }
    }
 
    public static ProductoDAO getProductoDAO() {
        Connection connection = ConnectionFactory.getInstance(motor).conectar();
        
        if (motor.equals("mysql")) {
            return new ProductoDAOImpleMySQL(connection);
        } else if (motor.equals("derby")) {
            return null;
        } else {
            throw new IllegalArgumentException("Tipo de DAO no válido: " + motor);
        }
    }
}