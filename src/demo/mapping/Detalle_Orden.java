package demo.mapping;

public class Detalle_Orden
{
	private int idDetalleOrden;
	private int cantidad;
	
	public int getIdDetalleOrden()
	{
		return idDetalleOrden;
	}
	public void setIdDetalleOrden(int idDetalleOrden)
	{
		this.idDetalleOrden=idDetalleOrden;
	}
	public int getCantidad()
	{
		return cantidad;
	}
	public void setCantidad(int cantidad)
	{
		this.cantidad=cantidad;
	}
	@Override
	public String toString()
	{
		return "Detalle Orden [idDetalleOrden="+idDetalleOrden+", cantidad="+cantidad+"]";
	}
	public String toStringLindo()
	{
		return "ID Detalle Orden: "+idDetalleOrden
			+"\nCantidad        : "+cantidad;
	}
}