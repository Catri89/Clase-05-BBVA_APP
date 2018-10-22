package demo.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import demo.util.JdbcUtil;

public class ProductoDAO
{
	Connection con = JdbcUtil.getConnection();
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public List<Producto> buscarProductosXCliente(int idCliente)
	{
		try
		{
			// preparo una sentencia
			String sql="SELECT a.id_producto, a.descripcion, a.precio_unitario,"
					+ " a.unidades_stock, a.unidades_pedidas, a.flg_discontinuo"
					+ "	b.id_detalle_orden"
					+ " FROM producto a"
					+ "		,detalle_orden b"
					+ "		,orden c"
					+ "	WHERE c.id_cliente = ?"
					+ "	AND c.id_orden = b.id_orden"
					+ "	AND b.id_producto = a.id_producto";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idCliente);

			// obtengo el cursor
			rs = pstm.executeQuery();
			
			ArrayList<Producto> ret = new ArrayList<>();
			
			// iterar el resultSet
			while( rs.next() )
			{
				int idProducto = rs.getInt("id_producto");
				String descripcion = rs.getString("descripcion");
				int precioUnitario = rs.getInt("precio_unitario");
				int unidadesStock = rs.getInt("unidades_stock");
				int unidadesPedidas = rs.getInt("unidades_pedidas");
				boolean flgDiscontinuo = rs.getBoolean("flg_discontinuo");

				Producto p = new Producto();
				p.setIdProducto(idProducto);
				p.setDescripcion(descripcion);
				p.setPrecioUnitario(precioUnitario);
				p.setUnidadesStock(unidadesStock);
				p.setUnidadesPedidas(unidadesPedidas);
				p.setFlgDiscontinuo(flgDiscontinuo);
			
				ret.add(p);
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
	
	public List<Producto> buscarTodos()
	{
		try
		{
			// preparo una sentencia
			String sql="SELECT id_producto, descripcion, precio_unitario,"
					+ " unidades_stock, unidades_pedidas, flg_discontinuo "
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
				int precioUnitario = rs.getInt("precio_unitario");
				int unidadesStock = rs.getInt("unidades_stock");
				int unidadesPedidas = rs.getInt("unidades_pedidas");
				boolean flgDiscontinuo = rs.getBoolean("flg_discontinuo");

				Producto p = new Producto();
				p.setIdProducto(idProducto);
				p.setDescripcion(descripcion);
				p.setPrecioUnitario(precioUnitario);
				p.setUnidadesStock(unidadesStock);
				p.setUnidadesPedidas(unidadesPedidas);
				p.setFlgDiscontinuo(flgDiscontinuo);
			
				ret.add(p);
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
	
	public Producto buscar(int idProducto)
	{
		try
		{
			// preparo una sentencia
			String sql="SELECT descripcion, precio_unitario,"
					+ " unidades_stock, unidades_pedidas, flg_discontinuo "
					+ " FROM producto "
					+ " WHERE id_producto = ?";
			pstm = con.prepareStatement(sql);

			// seteo el valor del parametro
			pstm.setInt(1,idProducto);
			
			// obtengo el cursor
			rs = pstm.executeQuery();
			
			Producto ret = null;
			
			// iterar el resultSet
			if( rs.next() )
			{
				String descripcion = rs.getString("descripcion");
				int precioUnitario = rs.getInt("precio_unitario");
				int unidadesStock = rs.getInt("unidades_stock");
				int unidadesPedidas = rs.getInt("unidades_pedidas");
				boolean flgDiscontinuo = rs.getBoolean("flg_discontinuo");

				Producto p = new Producto();
				p.setIdProducto(idProducto);
				p.setDescripcion(descripcion);
				p.setPrecioUnitario(precioUnitario);
				p.setUnidadesStock(unidadesStock);
				p.setUnidadesPedidas(unidadesPedidas);
				p.setFlgDiscontinuo(flgDiscontinuo);
				
				if( rs.next() )
				{
					throw new RuntimeException("Mas de una fila con el mismo id ("+idProducto+")");
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
		
	public int update(int idProducto, String descripcion, double precioUnitario, int unidadesStock, int unidadesPedidas, boolean flgDiscontinuo)
	{
			try
			{
				// preparo una sentencia
				String  sql="UPDATE producto "
						+ "SET descripcion = ?"
						+ "   ,precio_unitario = ?"
						+ "   ,unidades_stock = ?"
						+ "   ,unidades_pedidas = ?"
						+ "   ,flg_discontinuo = ?"
						+ " WHERE id_producto = ?";
				pstm = con.prepareStatement(sql);

				
				// seteo el valor del parametro
				pstm.setString(1,descripcion);
				pstm.setDouble(2,precioUnitario);
				pstm.setInt(3,unidadesStock);
				pstm.setInt(4,unidadesPedidas);
				pstm.setBoolean(5,flgDiscontinuo);
				pstm.setInt(6,idProducto);
				
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
	
	public int insert(int idProducto, int idProveedor, int idCategoria, String descripcion, double precioUnitario, int unidadesStock, int unidadesPedidas, boolean flgDiscontinuo)
	{
		try	
		{	
			// preparo una sentencia
			String sql="INSERT INTO producto "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = con.prepareStatement(sql);
	
			// seteo el valor del parametro
			pstm.setInt(1,idProducto);
			pstm.setInt(2,idProveedor);
			pstm.setInt(2,idCategoria);
			pstm.setString(2,descripcion);
			pstm.setDouble(3,precioUnitario);
			pstm.setInt(4,unidadesStock);
			pstm.setInt(5,unidadesPedidas);
			pstm.setBoolean(6,flgDiscontinuo);
			
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