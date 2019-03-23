package org.fwcms.prop.tc;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ForgotPasswordPageProp {
	
	private static final Logger logger = LogManager.getLogger(ForgotPasswordPageProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading ForgotPasswordPageProp.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(ForgotPasswordPageProp.class.getResourceAsStream("/language/"+lang+"/tc/ForgotPasswordPage.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	public static String getuserNameEmpty(){
		return prop.getProperty("userNameEmpty");
	}
	
	public static String getuserNameSpecialAndMinChar(){
		return prop.getProperty("userNameSpecialAndMinChar");
	}
	
	public static String getuserNameSpecialChar(){
		return prop.getProperty("userNameSpecialChar");
	}
	
	public static String getuserNameMinChar(){
		return prop.getProperty("userNameMinChar");
	}
	
	public static String getregEmailEmpty(){
		return prop.getProperty("regEmailEmpty");
	}
	
	public static String getregEmailInvaliedAndMinChar(){
		return prop.getProperty("regEmailInvaliedAndMinChar");
	}
	
	public static String getregEmailInvaliedChar(){
		return prop.getProperty("regEmailInvaliedChar");
	}
	
	public static String getregMobileEmpty(){
		return prop.getProperty("regMobileEmpty");
	}
	
	public static String getregMobileMinCharAndNumbersOnly(){
		return prop.getProperty("regMobileMinCharAndNumbersOnly");
	}
	
	public static String getregMobileMinChar(){
		return prop.getProperty("regMobileMinChar");
	}
	
	public static String getregMobileNumbersOnly(){
		return prop.getProperty("regMobileNumbersOnly");
	}
	
	public static String getinvaliedDetailsError(){
		return prop.getProperty("invaliedDetailsError");
	}
	
	public static String getSuucessMessage(){
		return prop.getProperty("forgotPasswordSuccess");
	}

}
