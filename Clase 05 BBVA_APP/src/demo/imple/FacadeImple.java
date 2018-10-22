package demo.imple;

import java.util.List;
import demo.def.Facade;
import demo.mapping.*;

public class FacadeImple implements Facade
{
	@Override
	public List<Producto> obtenerProductosXCliente(int idCliente)
	{
		ClienteDAO cliDao = new ClienteDAOImple();
		List<Producto> productosXCliente = cliDao.buscarProductos(idCliente);
		return productosXCliente;
	}
	
	@Override
	public Cliente obtenerCliente(int idCliente)
	{
		ClienteDAO cliDao = new ClienteDAOImple();
		Cliente c = cliDao.buscar(idCliente);
		return c;
	}
}
