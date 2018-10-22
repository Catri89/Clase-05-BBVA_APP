package demo.mapping;

import java.util.List;

public interface ClienteDAO
{
	public List<Producto> buscarProductos(int idCliente);
	public Cliente buscar(int idCliente);
}
