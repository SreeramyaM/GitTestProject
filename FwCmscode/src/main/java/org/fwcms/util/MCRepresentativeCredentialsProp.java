package org.fwcms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MCRepresentativeCredentialsProp {
	
private static final Logger logger = LogManager.getLogger(MCRepresentativeCredentialsProp.class.getName());
private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading mcrepresentativecredentials.properties");
				prop.load(MCRepresentativeCredentialsProp.class.getResourceAsStream("/config/credentials/mcrepresentativecredentials.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	//MC Representative 
	public static String getMcRepresentativeName(){
		return prop.getProperty("mcRepresentativeName");
	}
	
	public static String getMcRepresentativeUserName(){
		return prop.getProperty("mcRepresentativeUserName");
	}
	
	public static String getMcRepresentativePassword(){
		return prop.getProperty("mcRepresentativePassword");
	}
	
	public static String getMcRepresentativeEmail(){
		return prop.getProperty("mcRepresentativeEmail");
	}
	
	public static String getMcRepresentativeMobileNumber(){
		return prop.getProperty("mcRepresentativeMobileNumber");
	}
	
	//MC Representative One
	public static String getmcRepresentativeUserName1(){
		return prop.getProperty("mcRepresentativeUserName1");
	}
	
	public static String getmcRepresentativePassword1(){
		return prop.getProperty("mcRepresentativePassword1");
	}
	
	//MC Representative Two
	public static String getmcRepresentativeUserName2(){
		return prop.getProperty("mcRepresentativeUserName2");
	}
	
	public static String getmcRepresentativePassword2(){
		return prop.getProperty("mcRepresentativePassword2");
	}
	
	//New MC Representative
	public static String getNewMcRepresentativeUserName(){
		return prop.getProperty("newMcRepresentativeUserName");
	}
	
	public static String getNewMcRepresentativePassword(){
		return prop.getProperty("newMcRepresentativePassword");
	}
	
	public static String getNewMcRepresentativeNewPassword(){
		return prop.getProperty("newMcRepresentativeNewPassword");
	}
	
	public static String getNewMcRepresentativeSecurityQuestion(){
		return prop.getProperty("newMcRepresentativeSecurityQuestion");
	}
	
	public static String getNewMcRepresentativeSecurityAnswer(){
		return prop.getProperty("newMcRepresentativeSecurityAnswer");
	}
	
	//Forgot Password MC Representative
	public static String getForgotPasswordMcRepresentativeUserName(){
		return prop.getProperty("forgotPasswordMcRepresentativeUserName");
	}
	
	public static String getforgotPasswordMcRepresentativeNewPassword(){
		return prop.getProperty("forgotPasswordMcRepresentativeNewPassword");
	}
	
	public static String getForgotPasswordMcRepresentativeEmail(){
		return prop.getProperty("forgotPasswordMcRepresentativeEmail");
	}
	
	public static String getForgotPasswordMcRepresentativeContactNumber(){
		return prop.getProperty("forgotPasswordMcRepresentativeContactNumber");
	}
	
	public static String getForgotPasswordMcRepresentativeSecurityQuestion(){
		return prop.getProperty("forgotPasswordMcRepresentativeSecurityQuestion");
	}
	
	public static String getForgotPasswordMcRepresentativeSecurityAnswer(){
		return prop.getProperty("forgotPasswordMcRepresentativeSecurityAnswer");
	}
	
	//Change Password - MC Representative
	public static String getChangePasswordMcRepresentativeUserName(){
		return prop.getProperty("changePasswordMCRepresentativeUserName");
	}
	
	public static String getChangePasswordMcRepresentativePassword(){
		return prop.getProperty("changePasswordMCRepresentativePassword");
	}
	
	//Set The Value Of New MC Rep User Name In mcrepresentativecredentials.properties	
	public static void setnewMCRepUserName(String newValue) throws IOException{
		logger.info("Save newMCRepUserName");
		prop.setProperty("newMcRepresentativeUserName", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\mcrepresentativecredentials.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
			  prop.store(writer, "host settings");
	}
		
	//Set The Value Of New MC Rep Password In mcrepresentativecredentials.properties
		public static  void setnewMCRepPassword(String newValue) throws IOException{
			logger.info("Save newMCRepPassword ");
			prop.setProperty("newMcRepresentativePassword", newValue);
			String path = System.getProperty("user.dir");
			logger.info(path);
			File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\mcrepresentativecredentials.properties");
			FileWriter writer = null;
			try {
				writer = new FileWriter(configFile);
			} catch (IOException e) {
			 
				e.printStackTrace();
			}
			  prop.store(writer, "host settings");
		}
		
		//Set The Value Of changePasswordMCRepresentativePassword In mcrepresentativecredentials.properties
				public static  void setChangePasswordMCRepresentativePassword(String newValue) throws IOException{
					logger.info("Save changePasswordMCRepresentativePassword ");
					prop.setProperty("changePasswordMCRepresentativePassword", newValue);
					String path = System.getProperty("user.dir");
					logger.info(path);
					File configFile = new File(path+"\\src\\main\\resources\\config\\credentials\\mcrepresentativecredentials.properties");
					FileWriter writer = null;
					try {
						writer = new FileWriter(configFile);
					} catch (IOException e) {
					 
						e.printStackTrace();
					}
					  prop.store(writer, "host settings");
				}

}
