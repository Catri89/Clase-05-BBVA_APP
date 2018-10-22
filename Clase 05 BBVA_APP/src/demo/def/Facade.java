package demo.def;

import java.util.List;

import demo.mapping.Cliente;
import demo.mapping.Producto;

public interface Facade
{
	public List<Producto> obtenerProductosXCliente(int idCliente);
	public Cliente obtenerCliente(int idCliente);
}
