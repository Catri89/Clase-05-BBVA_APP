package demo.mapping;

public class Proveedor_Categoria
{
	private int idProveedorCategoria;
	public int getIdProveedorCategoria()
	{
		return idProveedorCategoria;
	}
	public void setIdProveedorCategoria(int idProveedorCategoria)
	{
		this.idProveedorCategoria=idProveedorCategoria;
	}
	@Override
	public String toString()
	{
		return "Proveedor_categoria [idProveedorCategoria="+idProveedorCategoria+"]";
	}
}