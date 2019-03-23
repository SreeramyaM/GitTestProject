package org.fwcms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EmployerCredentialsProp {
	
private static final Logger logger = LogManager.getLogger(EmployerCredentialsProp.class.getName());
private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading employercredentials.properties");
				prop.load(EmployerCredentialsProp.class.getResourceAsStream("/config/credentials/employercredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	//Employer
	public static String getemployerUserName(){
		return prop.getProperty("employerUserName");
	}
	
	public static String getemployerPassword(){
		return prop.getProperty("employerPassword");
	}
	
	public static String getNewEmployerUserName(){
		return prop.getProperty("newEmployerUserName");
	}
	
	public static String getNewEmployerPassword(){
		return prop.getProperty("newEmployerPassword");
	}
	
	
	//Set The Value Of New Employer User Name In employercredentials.properties	
	public static void setNewEmployerUserName(String newValue) throws IOException{
		logger.info("Save newEmployerUserName");
		prop.setProperty("newEmployerUserName", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\employercredentials.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
			
	//Set The Value Of Employer Password In employercredentials.properties
	public static  void setNewEmployerPassword(String newValue) throws IOException{
		logger.info("Save newEmployerPassword ");
		prop.setProperty("newEmployerPassword", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\employercredentials.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		prop.store(writer, "host settings");
	}
}
