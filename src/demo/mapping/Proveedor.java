package demo.mapping;

public class Proveedor
{
	private int idProveedor;
	private String empresa;
	private String contacto;
	private String direccion;
	public int getIdProveedor()
	{
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor)
	{
		this.idProveedor=idProveedor;
	}
	public String getEmpresa()
	{
		return empresa;
	}
	public void setEmpresa(String empresa)
	{
		this.empresa=empresa;
	}
	public String getContacto()
	{
		return contacto;
	}
	public void setContacto(String contacto)
	{
		this.contacto=contacto;
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
		return "Proveedor [idProveedor="+idProveedor+", empresa="+empresa+", contacto="+contacto+", direccion="+direccion+"]";
	}
	public String toStringLindo()
	{
		return "ID Proveedor: "+idProveedor
			+"\nEmpresa     : "+empresa
			+"\nContacto    : "+contacto
			+"\nDireccion   : "+direccion;
	}
}