package demo.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class ProductoDAO
{
	Connection con = Conexion.connection;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public List<Orden> buscarTodos()
	{
		try
		{
			// preparo una sentencia
			String sql="SELECT id_producto, descripcion, id_proveedor, id_categoria"
					+ ", precio_unitario, unidades_stock, unidades_pedidas, flg_discontinuo "
					+ " FROM producto ";
			pstm = con.prepareStatement(sql);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			ArrayList<Producto> ret = new ArrayList<>();
			
			// iterar el resultSet
			while( rs.next() )
			{
				int idProducto = rs.getInt("id_producto");
				String descripcion = rs.getString("descripcion");
				int idProveedor = rs.getInt("id_proveedor");
				int precioUnitario = rs.getInt("precio_unitario");
				int unidadesStock = rs.getInt("unidades_stock");
				int unidadesPedidas = rs.getInt("unidades_pedidas");
				boolean flgDiscontinuo = rs.getBoolean("flg_discontinuo");

				Producto c = new Producto();
				c.setIdOrden(idOrden);
				c.setFechaGenerada(fechaGenerada);
				c.setFechaEntregada(fechaEntregada);
				int idProducto = rs.getInt("id_producto");
				String descripcion = rs.getString("descripcion");
				int idProveedor = rs.getInt("id_proveedor");
				int precioUnitario = rs.getInt("precio_unitario");
				int unidadesStock = rs.getInt("unidades_stock");
				int unidadesPedidas = rs.getInt("unidades_pedidas");
				boolean flgDiscontinuo = rs.getBoolean("flg_discontinuo");
			
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
	
	public Orden buscar(int idOrden)
	{
		try
		{
			// preparo una sentencia
			String sql="";
			sql+="SELECT id_orden, fecha_generada, fecha_entregada ";
		    sql+="FROM orden ";
		    sql+="WHERE id_orden=? ";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idOrden);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			Orden ret = null;
			
			// iterar el resultSet
			if( rs.next() )
			{
				int id = rs.getInt("idOrden");
				Date fechaGenerada = rs.getDate("fechaGenerada");
				Date fechaEntregada = rs.getDate("fechaEntregada");

				Orden o = new Orden();
				o.setIdOrden(id);
				o.setFechaGenerada(fechaGenerada);
				o.setFechaEntregada(fechaEntregada);

				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con el mismo id ("+idOrden+")");
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
		
	public int update(int idOrden, Date fechaGenerada, Date fechaEntregada)
	{
			try
			{
				// preparo una sentencia
				String sql="UPDATE orden "
						+ "SET fecha_generada = ?"
						+ " , fecha_entregada = ?"
						+ " WHERE id_orden = ?";
				pstm = con.prepareStatement(sql);

				
				// seteo el valor del parametro
				pstm.setDate(1,fechaGenerada);
				pstm.setDate(2,fechaEntregada);
				pstm.setInt(3,idOrden);
				
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
	
	public int insert(int idOrden, Date fechaGenerada, Date fechaEntregada)
	{
		try	
		{	
			// preparo una sentencia
			String sql="INSERT INTO orden "
					+ " VALUES (?, ?, ?)";
			pstm = con.prepareStatement(sql);
	
			// seteo el valor del parametro
			pstm.setInt(1,idOrden);
			pstm.setDate(2,fechaGenerada);
			pstm.setDate(3,fechaEntregada);
					
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