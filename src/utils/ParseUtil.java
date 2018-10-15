package utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParseUtil {
 
	public static Map<String,String> loadProperties(){
		
		Map<String,String> map = new HashMap<String,String>();
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new ParseUtil().getClass().getClassLoader()
                    .getResourceAsStream("parse.properties");

			// load a properties file
			prop.load(input);

			for (final String name: prop.stringPropertyNames())
			    map.put(name, prop.getProperty(name));
			 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;

	}	
	
}
