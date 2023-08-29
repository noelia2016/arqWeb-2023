package DAO;

import java.util.List;
import Modelo.Factura_Producto_Producto;

public interface Factura_Producto_ProductoDAO {
	
	public void crear_tabla();

	public void insertar(Factura_Producto Factura_Producto);

	public void actualizar(Factura_Producto Factura_Producto);

	public void eliminar(Factura_Producto Factura_Producto);

	//public List<Factura_Producto> listar();
}