package org.fwcms.prop.cdc;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EmployerManagementProp {

	private static final Logger logger = LogManager.getLogger(EmployerManagementProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading EmployerManagementProp.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(EmployerManagementProp.class.getResourceAsStream("/language/"+lang+"/cdc/EmployerManagement.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	public static String getTextDisplay1()
	{
		return prop.getProperty("TextDisplay1");
	}
	
	public static String getTextDisplay2()
	{
		return prop.getProperty("TextDisplay2");
	}
	
	public static String getNote()
	{
		return prop.getProperty("Note");
	}
	
	public static String getPostemployerRegistrationStatusMessage()
	{
		return prop.getProperty("PostemployerRegistrationStatusMessage");
	}
}
