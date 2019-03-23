package org.fwcms.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BestinetSuperUserCredentialsProp {
	
private static final Logger logger = LogManager.getLogger(BestinetSuperUserCredentialsProp.class.getName());
private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading bestinetsuperusercredentials.properties");
				prop.load(BestinetSuperUserCredentialsProp.class.getResourceAsStream("/config/credentials/bestinetsuperusercredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	//Bestinet Super User 
	public static String getBestInetSuperUserUserName(){
		return prop.getProperty("bestInetSuperUserUserName");
	}
	
	public static String getBestInetSuperUserPassword(){
		return prop.getProperty("bestInetSuperUserPassword");
	}

}
