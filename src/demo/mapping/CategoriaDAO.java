package demo.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO
{
	
	Connection con = Conexion.connection;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public List<Categoria> buscarTodos()
	{
		try
		{
			String sql="SELECT id_categoria, descripcion"
					+ " FROM categoria";
			pstm = con.prepareStatement(sql);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			ArrayList<Categoria> ret = new ArrayList<>();
			
			// iterar el resultSet
			while( rs.next() )
			{
				int id = rs.getInt("id_categoria");
				String descripcion = rs.getString("descripcion");

				Categoria cat = new Categoria();
				cat.setIdCategoria(id);
				cat.setDescripcion(descripcion);
			
				ret.add(cat);
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
	
	public Categoria buscar(int idCategoria)
	{
		try
		{
			String sql="";
			sql+="SELECT id_categoria, descripcion ";
		    sql+="FROM categoria ";
		    sql+="WHERE id_categoria=? ";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idCategoria);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			Categoria cat = null;
			
			// iterar el resultSet
			if( rs.next() )
			{
				int id= rs.getInt("id_categoria");
				String descripcion = rs.getString("descripcion");

				cat = new Categoria();
				cat.setIdCategoria(id);
				cat.setDescripcion(descripcion);

				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con el mismo id ("+idCategoria+")");
				}
			}
			
			return cat;
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
		
	public int update(int idCategoria, String descripcion)
	{
		try
		{
			String sql="UPDATE categoria "
					+ "SET descripcion = ?"
					+ " WHERE id_categoria = ?";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
				pstm.setString(1,descripcion);
				pstm.setInt(2,idCategoria);
				
				
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
	
	public int insert(int idCategoria, String descripcion)
	{
		try
		{
			String sql="INSERT INTO categoria "//(id_cliente, id_empleado, fecha_generada, fecha_entregada)"
					+ " VALUES (?, ?)";
			pstm = con.prepareStatement(sql);
		
			// seteo el valor del parametro
			pstm.setInt(1,idCategoria);
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