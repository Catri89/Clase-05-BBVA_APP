package demo.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Detalle_OrdenDAO
{
	Connection con = Conexion.connection;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public List<Detalle_Orden> buscarTodos()
	{
		try
		{
			// preparo una sentencia
			String sql="SELECT id_detalle_orden, cantidad "
					+ " FROM detalle_orden ";
			pstm = con.prepareStatement(sql);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			ArrayList<Detalle_Orden> ret = new ArrayList<>();
			
			// iterar el resultSet
			while( rs.next() )
			{
				int id = rs.getInt("idDetalleOrden");
				int cantidad = rs.getInt("cantidad");

				Detalle_Orden c = new Detalle_Orden();
				c.setIdDetalleOrden(id);
				c.setCantidad(cantidad);
			
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
	
	public Detalle_Orden buscar(int idDetalleOrden)
	{
		try
		{
			// preparo una sentencia
			String sql="";
			sql+="SELECT cantidad";
		    sql+="FROM detalle_orden ";
		    sql+="WHERE id_detalle_orden=? ";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idDetalleOrden);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			Detalle_Orden ret = null;
			
			// iterar el resultSet
			if( rs.next() )
			{
				int cantidad = rs.getInt("cantidad");

				Detalle_Orden o = new Detalle_Orden();
				o.setIdDetalleOrden(idDetalleOrden);
				o.setCantidad(cantidad);

				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con el mismo id ("+idDetalleOrden+")");
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
		
	public int update(int idDetalleOrden, int cantidad)
	{
			try
			{
				// preparo una sentencia
				String sql="UPDATE detalle_orden "
						+ "SET cantidad = ?"
						+ " WHERE id_detalle_orden = ?";
				pstm = con.prepareStatement(sql);

				
				// seteo el valor del parametro
				pstm.setInt(1,cantidad);
				pstm.setInt(2,idDetalleOrden);
				
				
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
	
	public int insert(int idDetalleOrden, int idOrden, int idProducto, int cantidad)
	{
		try	
		{	
			// preparo una sentencia
			String sql="INSERT INTO detalle_orden"
					+ " VALUES (?, ?, ?, ?)";
			pstm = con.prepareStatement(sql);
	
			// seteo el valor del parametro
			pstm.setInt(1,idDetalleOrden);
			pstm.setInt(2,idOrden);
			pstm.setInt(3,idProducto);
			pstm.setInt(4,cantidad);
					
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