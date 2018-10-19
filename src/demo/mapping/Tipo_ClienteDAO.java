package demo.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipo_ClienteDAO
{
	Connection con = Conexion.connection;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public List<Tipo_Cliente> buscarTodos()
	{
		try
		{
			// preparo una sentencia
			String sql="SELECT id_tipo_cliente, descripcion FROM tipo_cliente ";
			pstm = con.prepareStatement(sql);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			ArrayList<Tipo_Cliente> ret = new ArrayList<>();
			
			// iterar el resultSet
			while( rs.next() )
			{
				int idTipoCliente = rs.getInt("idTipoCliente");
				String descripcion = rs.getString("descripcion");

				Tipo_Cliente c = new Tipo_Cliente();
				c.setIdTipoCliente(idTipoCliente);
				c.setDescripcion(descripcion);
			
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
	
	public Tipo_Cliente buscar(int idTipoCliente)
	{
		try
		{
			// preparo una sentencia
			String sql="";
			sql+="SELECT id_tipo_cliente, descripcion ";
		    sql+="FROM tipo_cliente ";
		    sql+="WHERE id_tipo_cliente=? ";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idTipoCliente);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			Tipo_Cliente ret = null;
			
			// iterar el resultSet
			if( rs.next() )
			{
				int id= rs.getInt("idTipoCliente");
				String descripcion = rs.getString("descripcion");

				ret = new Tipo_Cliente();
				ret.setIdTipoCliente(id);
				ret.setDescripcion(descripcion);

				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con el mismo id ("+idTipoCliente+")");
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
		
	public int update(int idTipoCliente, String descripcion)
	{
			try
			{
				// preparo una sentencia
				String sql="UPDATE tipo_cliente "
						+ "SET descripcion = ?"
						+ " WHERE id_tipo_cliente = ?";
				pstm = con.prepareStatement(sql);

				
				// seteo el valor del parametro
				pstm.setString(1,descripcion);
				pstm.setInt(2,idTipoCliente);
				
				
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
	
	public int insert(int idTipoCliente, String descripcion)
	{
		try	
		{	
			// preparo una sentencia
			String sql="INSERT INTO tipo_cliente "
					+ " VALUES (?, ?)";
			pstm = con.prepareStatement(sql);
	
			// seteo el valor del parametro
			pstm.setInt(1,idTipoCliente);
			pstm.setString(2,descripcion);
					
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