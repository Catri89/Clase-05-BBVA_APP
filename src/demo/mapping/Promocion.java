package demo.mapping;

public class Promocion
{
	private int idPromocion;
	private String descripcion;
	private int porcDescuento;
	
	public int getIdPromocion()
	{
		return idPromocion;
	}

	public void setIdPromocion(int idPromocion)
	{
		this.idPromocion=idPromocion;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}

	public int getPorcDescuento()
	{
		return porcDescuento;
	}

	public void setPorcDescuento(int porcDescuento)
	{
		this.porcDescuento=porcDescuento;
	}

	@Override
	public String toString()
	{
		return "Promocion [idPromocion="+idPromocion+", Descripcion"+descripcion+", Porcentaje descuento"+porcDescuento+"]";
	}
	public String toStringLindo()
	{
		return "idPromocion         : "+idPromocion
			+"\nDescripcion         : "+descripcion
			+"\nPorcentaje descuento: "+porcDescuento;
	}
}