package org.fwcms.prop.tc;

import static com.olo.util.PropertyReader.configProp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OperatorDetailsPageProp {
	
	private static final Logger logger = LogManager.getLogger(OperatorDetailsPageProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading OperatorDetailsPage.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(OperatorDetailsPageProp.class.getResourceAsStream("/language/"+lang+"/tc/OperatorDetailsPage.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	public static String getpageHeading(){
		return prop.getProperty("pageHeading");
	}
	
	public static String getfullNameEmptyExpectedMessage(){
		return prop.getProperty("fullNameEmptyExpectedMessage");
	}
	
	public static String getfullNameLettersAndMinCharExpectedMessage(){
		return prop.getProperty("fullNameLettersAndMinCharExpectedMessage");
	}
	
	public static String getfullNameLettersOnlyExpectedMessage(){
		return prop.getProperty("fullNameLettersOnlyExpectedMessage");
	}
	
	public static String getfullNameMinCharExpectedMessage(){
		return prop.getProperty("fullNameMinCharExpectedMessage");
	}
	
	public static String getemailEmptyExpectedMessage(){
		return prop.getProperty("emailEmptyExpectedMessage");
	}
	
	public static String getemailInvaliedAndMinCharExpectedMessage(){
		return prop.getProperty("emailInvaliedAndMinCharExpectedMessage");
	}
	
	public static String getemailInvaliedExpectedMessage(){
		return prop.getProperty("emailInvaliedExpectedMessage");
	}
	
	public static String getcontactNumberEmptyExpectedMessage(){
		return prop.getProperty("contactNumberEmptyExpectedMessage");
	}
	
	public static String getcontactNumberMinAndNumbersOnlyExpectedMessage(){
		return prop.getProperty("contactNumberMinAndNumbersOnlyExpectedMessage");
	}
	
	public static String getcontactNumberMinCharExpectedMessage(){
		return prop.getProperty("contactNumberMinCharExpectedMessage");
	}
	
	public static String getcontactNumberNumbersOnlyExpectedMessage(){
		return prop.getProperty("contactNumberNumbersOnlyExpectedMessage");
	}
	
	public static String getaddOperatorMessage(){
		return prop.getProperty("addOperatorMessage");
	}
	
	public static String geteditOperatorMessage(){
		return prop.getProperty("editOperatorMessage");
	}
	
	public static String getdeleteOperatorConfirmMessage(){
		return prop.getProperty("deleteOperatorConfirmMessage");
	}
	
	public static String getdeleteOperatorMessage(){
		return prop.getProperty("deleteOperatorMessage");
	}
	
	public static String getchangePasswordMessage(){
		return prop.getProperty("changePasswordMessage");
	}
	
	public static String getreasonEmptyMessage(){
		return prop.getProperty("reasonEmptyMessage");
	}
	
	public static String getreasonValiedAndMinCharMessage(){
		return prop.getProperty("reasonValiedAndMinCharMessage");
	}
	
	public static String getreasonValiedCharMessage(){
		return prop.getProperty("reasonValiedCharMessage");
	}
	
	public static String getreasonMinCharMessage(){
		return prop.getProperty("reasonMinCharMessage");
	}
	
}
