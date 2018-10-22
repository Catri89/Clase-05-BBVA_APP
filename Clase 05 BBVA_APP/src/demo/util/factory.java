package demo.util;

import java.io.FileInputStream;
import java.util.Properties;

public class factory
{
	public class Object get(String objName)
	{
		Properties p = new Properties();
		p.load(new FileInputStream("jdbc.properties"));
		
		String pack=p.getProperty(objName);
		Object obj 
		return 

	}
	
}
