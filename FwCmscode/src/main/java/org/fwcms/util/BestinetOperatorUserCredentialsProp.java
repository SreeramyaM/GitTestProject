package org.fwcms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BestinetOperatorUserCredentialsProp {
	
private static final Logger logger = LogManager.getLogger(BestinetOperatorUserCredentialsProp.class.getName());
private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading bestinetoperatorusercredentials.properties");
				prop.load(BestinetOperatorUserCredentialsProp.class.getResourceAsStream("/config/credentials/bestinetoperatorusercredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	//Bestinet Operator User 
	public static String getBestInetOperatorName(){
		return prop.getProperty("bestInetOperatorName");
	}
	
	public static String getBestInetOperatorUserName(){
		return prop.getProperty("bestInetOperatorUserName");
	}
	
	public static String getBestInetOperatorPassword(){
		return prop.getProperty("bestInetOperatorPassword");
	}
	
	public static String getBestInetOperatorEmail(){
		return prop.getProperty("bestInetOperatorEmail");
	}
	
	public static String getBestInetOperatorMobileNumber(){
		return prop.getProperty("bestInetOperatorMobileNumber");
	}
	
	
	//Bestinet Multiple Role Operator User
	public static String getmultipleRoleBestInetOperatorName(){
		return prop.getProperty("multipleRoleBestInetOperatorName");
	}
	
	public static String getmultipleRoleBestInetOperatorUserName(){
		return prop.getProperty("multipleRoleBestInetOperatorUserName");
	}
	
	public static String getmultipleRoleBestInetOperatorPassword(){
		return prop.getProperty("multipleRoleBestInetOperatorPassword");
	}
	
	public static String getmultipleRoleBestInetOperatorEmail(){
		return prop.getProperty("multipleRoleBestInetOperatorEmail");
	}
	
	public static String getmultipleRoleBestInetOperatorMobileNumber(){
		return prop.getProperty("multipleRoleBestInetOperatorMobileNumber");
	}
	
	//New Bestinet Operator User
	public static String getNewBestInetOperatorUserName(){
		return prop.getProperty("newBestinetOperatorUserUserName");
	}
	
	public static String getNewBestInetOperatorPassword(){
		return prop.getProperty("newBestinetOperatorUserPassword");
	}
	
	//Change Password - Bestinet Operator User
	public static String getChangePasswordBestInetOperatorUserName(){
		return prop.getProperty("changePasswordBestinetOperatorUserName");
	}
	
	public static String getChangePasswordBestInetOperatorPassword(){
		return prop.getProperty("changePasswordBestinetOperatorPassword");
	}
		
	//Forgot Password - Bestinet Operator User
	public static String getForgotPasswordBestInetOperatorUserName(){
		return prop.getProperty("forgotPasswordBestinetOperatorUserName");
	}
	
	public static String getForgotPasswordBestInetOperatorEmail(){
		return prop.getProperty("forgotPasswordBestinetOperatorEmail");
	}
	
	public static String getForgotPasswordBestInetOperatorContact(){
		return prop.getProperty("forgotPasswordBestinetOperatorContact");
	}
	
	//Set The Value Of New Bestinet Operator User Name In bestinetoperatorusercredentials.properties	
	public static void setnewBestInetOperatorUserUserName(String newValue) throws IOException{
		logger.info("Save newBestInetOperatorUserUserName");
		  prop.setProperty("newBestinetOperatorUserUserName", newValue);
		  String path = System.getProperty("user.dir");
		  logger.info(path);
		  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetoperatorusercredentials.properties");
		  FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
	
	//Set The Value Of New Bestinet Operator User Password In bestinetoperatorusercredentials.properties
	public static  void setnewBestInetOperatorUserPassword(String newValue) throws IOException{
		logger.info("Save newBestInetOperatorUserPassword ");
		  prop.setProperty("newBestinetOperatorUserPassword", newValue);
		  String path = System.getProperty("user.dir");
		  logger.info(path);
		  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetoperatorusercredentials.properties");
		  FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
	
	//Set The Value Of Bestinet Operator User Name In bestinetoperatorusercredentials.properties	
	public static void setBestInetOperatorUserUserName(String newValue) throws IOException{
			logger.info("Save bestInetOperatorUserName");
			prop.setProperty("bestInetOperatorUserName", newValue);
			String path = System.getProperty("user.dir");
			logger.info(path);
			File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetoperatorusercredentials.properties");
			FileWriter writer = null;
			try {
				writer = new FileWriter(configFile);
			} catch (IOException e) {
			 
				e.printStackTrace();
			}
			  prop.store(writer, "host settings");
	}
		
	//Set The Value Of Bestinet Operator User Password In bestinetoperatorusercredentials.properties
	public static  void setBestInetOperatorUserPassword(String newValue) throws IOException{
		logger.info("Save bestInetOperatorPassword ");
		prop.setProperty("bestInetOperatorPassword", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetoperatorusercredentials.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			 
		e.printStackTrace();
	}
		prop.store(writer, "host settings");
	}
	
	//Set The Value Of changePasswordBestinetOperatorPassword In bestinetoperatorusercredentials.properties
	public static  void setChangePasswordBestinetOperatorPassword(String newValue) throws IOException{
			logger.info("Save changePasswordBestinetOperatorPassword ");
			prop.setProperty("changePasswordBestinetOperatorPassword", newValue);
			String path = System.getProperty("user.dir");
			logger.info(path);
			File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetoperatorusercredentials.properties");
			FileWriter writer = null;
			try {
				writer = new FileWriter(configFile);
			} catch (IOException e) {
				 
			e.printStackTrace();
		}
			prop.store(writer, "host settings");
		}

}
