package demo.mapping;

public class Promocion_Producto
{
	private boolean flgActiva;
	
	public boolean isFlgActiva()
	{
		return flgActiva;
	}
	public void setFlgActiva(boolean flgActiva)
	{
		this.flgActiva=flgActiva;
	}
	@Override
	public String toString()
	{
		return "Promocion_Producto [Activa="+flgActiva+"]";
	}
}