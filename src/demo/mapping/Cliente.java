package demo.mapping;

public class Cliente
{
	private int idCliente;
	private String nombre;
	private String direccion;
	
	public int getIdCliente()
	{
		return idCliente;
	}
	public void setIdCliente(int idCliente)
	{
		this.idCliente=idCliente;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public String getDireccion()
	{
		return direccion;
	}
	public void setDireccion(String direccion)
	{
		this.direccion=direccion;
	}
	@Override
	public String toString()
	{
		return "Cliente [idCliente="+idCliente+", nombre="+nombre+", direccion="+direccion+"]";
	}
	public String toStringLindo()
	{
		return "ID Cliente : "+idCliente
			+"\nNombre     : "+nombre
			+"\nDireccion  : "+direccion;
	}
}