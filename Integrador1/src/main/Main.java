package main;

import main.DAO.ClienteDAO;
import main.DAO.DAOFactory;
import main.DAO.FacturaDAO;
import main.DAO.Factura_ProductoDAO;
import main.DAO.ProductoDAO;
import main.modelos.Cliente;
import main.modelos.Factura;
import main.modelos.Factura_Producto;
import main.modelos.Producto;

public class Main {

	public static void main(String[] args)  {
	
		// elegimos el motor de BD a trabajar
		final String motor = "mysql";
		// final String motor = "derby";
		
		DAOFactory miDao=DAOFactory.getInstance(motor);

		// ClienteDAO miDaoCliente = miDao.getClienteDAO();
		// miDaoCliente.crear_tabla();
		// Cliente pedro=new Cliente("pedro","ped@ped");
		// miDaoCliente.insertar(pedro);
		// miDaoCliente.listar();

		// FacturaDAO miDaoFactura= miDao.getFacturaDAO();
		// miDaoFactura.crear_tabla();
		// Factura fact1=new Factura(4,5);
		// miDaoFactura.insertar(fact1);
		// miDaoFactura.listar();

		// Factura_ProductoDAO miDaoFP= miDao.getFactura_ProductoDAO();
		// miDaoFP.crear_tabla();
		// Factura_Producto miFP1=new Factura_Producto(1,2, 3);
		// miDaoFP.insertar(miFP1);
		// miDaoFP.listar();

		ProductoDAO miDaoProducto=miDao.getProductoDAO();
		// miDaoProducto.crear_tabla();
		Producto p1=new Producto("pan", (float) 35.0);
		miDaoProducto.insertar(p1);
		miDaoProducto.listar();

	}

}
