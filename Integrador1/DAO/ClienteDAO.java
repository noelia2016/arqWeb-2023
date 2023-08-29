package DAO;

import java.util.List;
import Modelo.Cliente;

public interface ClienteDAO {
	public void crear_tabla();

	public void insertar(Cliente Cliente);

	public void actualizar(Cliente Cliente);

	public void eliminar(Cliente Cliente);

	public List<Cliente> listar();
}