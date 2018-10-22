package demo.mapping;

import java.sql.Date;

public class Orden
{
	private int idOrden;
	private Date fechaGenerada;
	private Date fechaEntregada;
	
	public int getIdOrden()
	{
		return idOrden;
	}
	public void setIdOrden(int idOrden)
	{
		this.idOrden=idOrden;
	}
	public Date getFechaGenerada()
	{
		return fechaGenerada;
	}
	public void setFechaGenerada(Date fechaGenerada)
	{
		this.fechaGenerada=fechaGenerada;
	}
	public Date getFechaEntregada()
	{
		return fechaEntregada;
	}
	public void setFechaEntregada(Date fechaEntregada)
	{
		this.fechaEntregada=fechaEntregada;
	}
	
	@Override
	public String toString()
	{
		return "Orden [idOrden="+idOrden+", fecha generada="+fechaGenerada+", fechaEntregada="+fechaEntregada+"]";
	}
	public String toStringLindo()
	{
		return "ID Orden       : "+idOrden
			+"\nFecha Generada : "+fechaGenerada
			+"\nFecha Entregada: "+fechaEntregada;
	}
}