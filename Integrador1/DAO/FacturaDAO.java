package DAO;

import java.util.List;
import Modelo.Factura;

public interface FacturaDAO {
	
	public void crear_tabla();

	public void insertar(Factura Factura);

	public void actualizar(Factura Factura);

	public void eliminar(Factura Factura);

	public List<Factura> listar();
}