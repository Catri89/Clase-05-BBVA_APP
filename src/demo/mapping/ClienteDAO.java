package demo.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO
{
	
	Connection con = Conexion.connection;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public List<Cliente> buscarTodos()
	{
		try
		{
			//preparo una sentencia
			String sql="SELECT id_cliente, nombre, direccion FROM cliente ";
			pstm = con.prepareStatement(sql);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			ArrayList<Cliente> ret = new ArrayList<>();
			
			// iterar el resultSet
			while( rs.next() )
			{
				int idCliente = rs.getInt("id_cliente");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");

				Cliente c = new Cliente();
				c.setIdCliente(idCliente);
				c.setNombre(nombre);
				c.setDireccion(direccion);
			
				ret.add(c);
			}
			
			return ret;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
		
	}
	
	public Cliente buscar(int idCliente)
	{
		try
		{
			// preparo una sentencia
			String sql="";
			sql+="SELECT id_cliente, nombre, direccion ";
		    sql+="FROM cliente ";
		    sql+="WHERE id_cliente=? ";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idCliente);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			Cliente ret = null;
			
			// iterar el resultSet
			if( rs.next() )
			{
				int id= rs.getInt("id_cliente");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");

				ret = new Cliente();
				ret.setIdCliente(id);
				ret.setNombre(nombre);
				ret.setDireccion(direccion);

				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con el mismo id ("+idCliente+")");
				}
			}
			
			return ret;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
		
	public int update(int idCliente, String nombre, String direccion, int tipoCliente)
	{
		try
		{
			String sql="UPDATE cliente "
					+ "SET nombre = ?"
					+ ",   direccion = ?"
					+ ",   id_tipo_cliente = ?"
					+ " WHERE id_cliente = ?";
			pstm = con.prepareStatement(sql);

			pstm.setString(1,nombre);
			pstm.setString(2,direccion);
			pstm.setInt(3,tipoCliente);
			pstm.setInt(4,idCliente);
			
			return pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	public int insert(int idCliente, String nombre, String direccion, int tipoCliente)
	{
		try
		{
			// preparo una sentencia
			
			String sql="INSERT INTO cliente "//(id_cliente, id_empleado, fecha_generada, fecha_entregada)"
					+ " VALUES (?, ?, ?, ?)";
			pstm = con.prepareStatement(sql);
		
			// seteo el valor del parametro
			pstm.setInt(1,idCliente);
			pstm.setString(2,nombre);
			pstm.setString(3,direccion);
			pstm.setInt(4,tipoCliente);
			
			
			return pstm.executeUpdate();
 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if( rs!=null ) rs.close();
				if( pstm!=null ) pstm.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}	
		}
	}

}