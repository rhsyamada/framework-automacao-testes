package br.com.desafio.netshoes.core.selenium.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	
	private static PropertiesLoader instance = null;
    private Properties properties;

    private PropertiesLoader() throws IOException{
    }

    public static PropertiesLoader getInstance() {
        if(instance == null) {
            try {
                instance = new PropertiesLoader();
            } catch (IOException e) {
                throw new IllegalArgumentException("Erro, ao processar o application.properties");
            }
        }
        return instance;
    }

    public String getValue(String path, String key) {
    	try {
    		load(path);
            return properties.getProperty(key);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
    
    private void load(String path) {
    	try {
    		properties = new Properties();
            properties.load(getClass().getResourceAsStream(path));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

}
