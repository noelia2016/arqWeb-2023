package main.DAO;

import java.util.List;
import main.modelos.Factura;

public interface FacturaDAO {
	public void crear_tabla();

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Factura factura);

	public List<Factura> listar();
}