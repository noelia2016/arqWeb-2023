package main.DAO;

import java.util.List;
import main.modelos.Factura_Producto;

public interface Factura_ProductoDAO {
	public void crear_tabla();

	public void insertar(Factura_Producto factura_Producto);

	public void actualizar(Factura_Producto factura_Producto);

	public void eliminar(Factura_Producto factura_Producto);

	public List<Factura_Producto> listar();
}