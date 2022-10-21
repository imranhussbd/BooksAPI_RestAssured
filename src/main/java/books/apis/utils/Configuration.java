package books.apis.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private static Configuration configuration;
	private Properties properties;
	private final String defaultPath = "configuration/config.properties";
	
	private Configuration() {
		loadProperty();
	}

	private void loadProperty() {
		properties = new Properties();
		try {
			InputStream iStream = new FileInputStream(defaultPath);
			properties.load(iStream);
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration getInstance() {
		if(configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}
	
	public String get(String key) {
		if(key != null) {
			return properties.getProperty(key);
		}else {
			return null;
		}
	}
}
