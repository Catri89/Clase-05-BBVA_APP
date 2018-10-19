package demo.mapping;

public class Tipo_Cliente
{
	private int idTipoCliente;
	private String descripcion;
	
	public int getIdTipoCliente()
	{
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente)
	{
		this.idTipoCliente=idTipoCliente;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	@Override
	public String toString()
	{
		return "TipoCliente [idTipoCliente="+idTipoCliente+", descripcion="+descripcion+"]";
	}
	public String toStringLindo()
	{
		return "ID Tipo Cliente : "+idTipoCliente
			+"\nDescripcion     : "+descripcion;
	}
}
