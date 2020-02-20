/**
 * 
 */
package fr.eni.demoJdbc.dal;

import java.util.Properties;

/**
 * @author Eni Ecole
 *
 */
public class Settings {
	private static Properties properties;
	
	//bloc d'initialisation static
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
			//properties.loadFromXML(Settings.class.getResourceAsStream("settings.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key);
		return parametre;
	}

}
