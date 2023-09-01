package main;

import main.DAO.ClienteDAO;
import main.DAO.DAOFactory;
import main.DAO.FacturaDAO;
import main.modelos.Cliente;
import main.modelos.Factura;

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

		FacturaDAO miDaoFactura= miDao.getFacturaDAO();
		// miDaoFactura.crear_tabla();
		Factura fact1=new Factura(4,5);
		miDaoFactura.insertar(fact1);
		miDaoFactura.listar();
	}

}
