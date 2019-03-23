package org.fwcms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MCOperatorCredentialsProp {
	
private static final Logger logger = LogManager.getLogger(MCOperatorCredentialsProp.class.getName());
private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading mcoperatorcredentials.properties");
				prop.load(MCOperatorCredentialsProp.class.getResourceAsStream("/config/credentials/mcoperatorcredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	//MC Operator  
	public static String getMcOperatorName(){
		return prop.getProperty("mcOperatorName");
	}
	
	public static String getMcOperatorUserName(){
		return prop.getProperty("mcOperatorUserName");
	}
	
	public static String getMcOperatorPassword(){
		return prop.getProperty("mcOperatorPassword");
	}
	
	public static String getMcOperatorEmail(){
		return prop.getProperty("mcOperatorEmail");
	}
	
	public static String getMcOperatorMobileNumber(){
		return prop.getProperty("mcOperatorMobileNumber");
	}
	
	//Set The Value Of New MC Operator User Name In mcoperatorcredentials.properties	
	public static void setMCOperatorUserName(String newValue) throws IOException{
		logger.info("Save newMCOperatorUserName");
		prop.setProperty("mcOperatorUserName", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\mcoperatorcredentials.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
			  prop.store(writer, "host settings");
	}
			
	//Set The Value Of New MC Operator Password In mcoperatorcredentials.properties
	public static  void setMCOperatorPassword(String newValue) throws IOException{
		logger.info("Save newMCOperatorPassword ");
		prop.setProperty("mcOperatorPassword", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\mcoperatorcredentials.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
			prop.store(writer, "host settings");
	}


}
