package org.fwcms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BestinetPrivilegedUserCredentialsProp {
	
private static final Logger logger = LogManager.getLogger(BestinetPrivilegedUserCredentialsProp.class.getName());
private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading bestinetprivilegedusercredentials.properties");
				prop.load(BestinetPrivilegedUserCredentialsProp.class.getResourceAsStream("/config/credentials/bestinetprivilegedusercredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	//Bestinet Privileged User 
	public static String getbestInetPrivilegedUserFullName(){
		return prop.getProperty("bestInetPrivilegedUserFullName");
	}
	
	public static String getBestInetPrivilegedUserUserName(){
		return prop.getProperty("bestInetPrivilegedUserUserName");
	}
	
	public static String getBestInetPrivilegedUserPassword(){
		return prop.getProperty("bestInetPrivilegedUserPassword");
	}
	
	public static String getBestInetPrivilegedUserEmail(){
		return prop.getProperty("bestInetPrivilegedUserEmail");
	}
	
	public static String getBestInetPrivilegedUserMobileNumber(){
		return prop.getProperty("bestInetPrivilegedUserMobileNumber");
	}
	
	//Bestinet Multiple Role Privileged User	
	public static String getmultipleRoleBestInetPrivilegedUserFullName(){
		return prop.getProperty("multipleRoleBestInetPrivilegedUserFullName");
	}
	
	public static String getmultipleRoleBestInetPrivilegedUserUserName(){
		return prop.getProperty("multipleRoleBestInetPrivilegedUserUserName");
	}
	
	public static String getmultipleRoleBestInetPrivilegedUserPassword(){
		return prop.getProperty("multipleRoleBestInetPrivilegedUserPassword");
	}
	
	public static String getmultipleRoleBestInetPrivilegedUserEmail(){
		return prop.getProperty("multipleRoleBestInetPrivilegedUserEmail");
	}
	
	public static String getmultipleRoleBestInetPrivilegedUserMobileNumber(){
		return prop.getProperty("multipleRoleBestInetPrivilegedUserMobileNumber");
	}
	
	//New Bestinet Privileged User
	public static String getNewBestInetPrivilegedUserUserName(){
		return prop.getProperty("newBestInetPrivilegedUserUserName");
	}
	
	public static String getNewBestInetPrivilegedUserPassword(){
		return prop.getProperty("newBestInetPrivilegedUserPassword");
	}
	
	//Forgot Password - Bestinet Privileged User
	public static String getForgotPasswordBestInetPrivilegedUserUserName(){
		return prop.getProperty("forgotPasswordBestInetPrivilegedUserUserName");
	}
	
	public static String getForgotPasswordBestInetPrivilegedUserEmail(){
		return prop.getProperty("forgotPasswordBestInetPrivilegedUserEmail");
	}
	
	public static String getForgotPasswordBestInetPrivilegedUserContactNumber(){
		return prop.getProperty("forgotPasswordBestInetPrivilegedUserContactNumber");
	}
	
	//Change Password - Bestinet Privileged User
	public static String getChangePasswordBestInetPrivilegedUserUserName(){
		return prop.getProperty("changePasswordBestinetPrivilegedUserUserName");
	}
	
	public static String getChangePasswordBestInetPrivilegedUserPassword(){
		return prop.getProperty("changePasswordBestinetPrivilegedUserPassword");
	}
	
	//Setting the value of property bestInetPrivilegedUserUserName in bestinetprivilegedusercredentials.properties
	public static void setBestInetPrivilegedUserUserName(String newValue) throws IOException{
		logger.info("Save bestInetPrivilegedUserUserName");
		  prop.setProperty("bestInetPrivilegedUserUserName", newValue);
		  String path = System.getProperty("user.dir");
		  logger.info(path);
		  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetprivilegedusercredentials.properties");
		  FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
	
	//Setting the value of property bestInetPrivilegedUserPassword in bestinetprivilegedusercredentials.properties
	public static  void setBestInetPrivilegedUserPassword(String newValue) throws IOException{
		logger.info("Save BestInetPrivilegedUserPassword ");
		  prop.setProperty("bestInetPrivilegedUserPassword", newValue);
		  String path = System.getProperty("user.dir");
		  logger.info(path);
		  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetprivilegedusercredentials.properties");
		  FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
	
	//Setting the value of property newBestInetPrivilegedUserPassword in bestinetprivilegedusercredentials.properties
	public static  void setnewBestInetPrivilegedUserPassword(String newValue) throws IOException{
		logger.info("Save newBestInetPrivilegedUserPassword ");
		  prop.setProperty("newBestInetPrivilegedUserPassword", newValue);
		  String path = System.getProperty("user.dir");
		  logger.info(path);
		  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetprivilegedusercredentials.properties");
		  FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
	
	//Setting the value of property newBestInetPrivilegedUserUserName in bestinetprivilegedusercredentials.properties
	public static void setnewBestInetPrivilegedUserUserName(String newValue) throws IOException{
		logger.info("Save newBestInetPrivilegedUserUserName");
		  prop.setProperty("newBestInetPrivilegedUserUserName", newValue);
		  String path = System.getProperty("user.dir");
		  logger.info(path);
		  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetprivilegedusercredentials.properties");
		  FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
		 
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
	
	//Setting the value of property changePasswordBestinetPrivilegedUserPassword in bestinetprivilegedusercredentials.properties
		public static void setChangePasswordBestinetPrivilegedUserPassword(String newValue) throws IOException{
			logger.info("Save changePasswordBestinetPrivilegedUserPassword");
			  prop.setProperty("changePasswordBestinetPrivilegedUserPassword", newValue);
			  String path = System.getProperty("user.dir");
			  logger.info(path);
			  File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\bestinetprivilegedusercredentials.properties");
			  FileWriter writer = null;
			try {
				writer = new FileWriter(configFile);
			} catch (IOException e) {
			 
				e.printStackTrace();
			}
			  prop.store(writer, "host settings");
		}
}
