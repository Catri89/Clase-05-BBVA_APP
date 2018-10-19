package demo.mapping;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion
{
	public static Connection connection = null;
	
	public static void abreConexion()
	{
		
		try
		{
			Runtime.getRuntime().addShutdownHook(new MiShutDownHook());
			
			Properties p = new Properties();
			p.load(new FileInputStream("conexion.properties"));
			
			String driver=p.getProperty("driver");
			String url=p.getProperty("url");
			String usr=p.getProperty("usr");
			String pwd=p.getProperty("pwd");
			
			// registro el driver JDBC
			Class.forName(driver);

			// me conecto
			connection = DriverManager.getConnection(url,usr,pwd);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	static class MiShutDownHook extends Thread 
	{
		@Override
		public void run()
		{
			try
			{
				if( connection!=null ) connection.close();				
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
}
