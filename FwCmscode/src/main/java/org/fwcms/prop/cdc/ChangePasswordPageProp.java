package org.fwcms.prop.cdc;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChangePasswordPageProp {
	
	private static final Logger logger = LogManager.getLogger(ChangePasswordPageProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading ChangePasswordPageProp.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(ChangePasswordPageProp.class.getResourceAsStream("/language/"+lang+"/cdc/ChangePasswordPage.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	public static String getpageTitleContains(){
		return prop.getProperty("pageTitleContains");
	}
	
	public static String getchangedPasswordSuccess(){
		return prop.getProperty("changedPasswordSuccess");
	}
	
	public static String getoldPasswordEmpty(){
		return prop.getProperty("oldPasswordEmpty");
	}
	
	public static String getnewPasswordEmpty(){
		return prop.getProperty("newPasswordEmpty");
	}
	
	public static String getconfirmPasswordEmpty(){
		return prop.getProperty("confirmPasswordEmpty");
	}
	
	public static String getspecialCharAndMinChar(){
		return prop.getProperty("specialCharAndMinChar");
	}
	
	public static String getspecialChar(){
		return prop.getProperty("specialChar");
	}
	
	public static String getminChar(){
		return prop.getProperty("minChar");
	}
	
	public static String getconfirmSpecialAndMinAndNotMatchingPassword(){
		return prop.getProperty("confirmSpecialAndMinAndNotMatchingPassword");
	}
	
	public static String getconfirmMinAndNotMatchingPassword(){
		return prop.getProperty("confirmMinAndNotMatchingPassword");
	}
	
	public static String getconfirmNotMatchingPassword(){
		return prop.getProperty("confirmNotMatchingPassword");
	}

}
