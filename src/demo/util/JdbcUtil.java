package demo.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil
{
	private static Connection con = null;

	public static Connection getConnection()
	{		
		try
		{
			if( con==null || con.isClosed() )
			{
				Runtime.getRuntime().addShutdownHook(new MiShutDownHook());
				
				
				Properties p = new Properties();
				p.load(new FileInputStream("jdbc.properties"));
				
				String driver=p.getProperty("driver");
				String url=p.getProperty("url");
				String usr=p.getProperty("usr");
				String pwd=p.getProperty("pwd");
				
				// registro el driver JDBC
				Class.forName(driver);

				// me conecto
				con = DriverManager.getConnection(url,usr,pwd);			
			}
			
			return con;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	static class MiShutDownHook extends Thread
	{
		@Override
		public void run()
		{
			try
			{
				if(con!=null) con.close();
				System.out.println("Chauuu!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
}
