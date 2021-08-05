package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/java/com/resources/config.properties");
			prop.load(ip);
		} catch ( IOException e) {
			System.out.println("File not found " + e.getMessage());
		}
		return prop;
	}

}
