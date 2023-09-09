package main.DAO;

import java.util.List;
import main.modelos.Producto;

public interface ProductoDAO {
	public void crear_tabla();

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(Producto producto);

	public List<Producto> listar();
}