package demo.mapping;

public class Producto
{
	private int idProducto;
	private String descripcion;
	private double precioUnitario;
	private int unidadesStock;
	private int unidadesPedidas;
	private boolean flgDiscontinuo;
	
	public int getIdProducto()
	{
		return idProducto;
	}
	public void setIdProducto(int idProducto)
	{
		this.idProducto=idProducto;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	public double getPrecioUnitario()
	{
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario)
	{
		this.precioUnitario=precioUnitario;
	}
	public int getUnidadesStock()
	{
		return unidadesStock;
	}
	public void setUnidadesStock(int unidadesStock)
	{
		this.unidadesStock=unidadesStock;
	}
	public int getUnidadesPedidas()
	{
		return unidadesPedidas;
	}
	public void setUnidadesPedidas(int unidadesPedidas)
	{
		this.unidadesPedidas=unidadesPedidas;
	}
	public boolean isFlgDiscontinuo()
	{
		return flgDiscontinuo;
	}
	public void setFlgDiscontinuo(boolean flgDiscontinuo)
	{
		this.flgDiscontinuo=flgDiscontinuo;
	}
	@Override
	public String toString()
	{
		return "Producto [idProducto="+idProducto+", descripcion="+descripcion+", precio unitario="+precioUnitario+", unidadesStock="+unidadesStock+", unidadesPedidas="+unidadesPedidas+", flgDiscontinuo="+flgDiscontinuo+"]";
	}
	public String toStringLindo()
	{
		return "Id Producto: "+idProducto
			+"\nDescripcion="+descripcion
			+"\nPrecio unitario="+precioUnitario
			+"\nUnidadesStock="+unidadesStock
			+"\nUnidadesPedidas="+unidadesPedidas
			+"\nDiscontinuo="+flgDiscontinuo;
	}
}