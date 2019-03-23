package org.fwcms.prop.cdc;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BestInetOperatorUsersDetailsPageProp {
	
	private static final Logger logger = LogManager.getLogger(BestInetOperatorUsersDetailsPageProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading BestInetOperatorUsersDetailsPage.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(BestInetOperatorUsersDetailsPageProp.class.getResourceAsStream("/language/"+lang+"/cdc/BestInetOperatorUsersDetailsPage.properties"));
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
	
	public static String getfullnameEmpty(){
		return prop.getProperty("fullnameEmpty");
	}
	
	public static String getfullnameMinCharAndLettersOnly(){
		return prop.getProperty("fullnameMinCharAndLettersOnly");
	}
	
	public static String getfullnameMinChar(){
		return prop.getProperty("fullnameMinChar");
	}
	
	public static String getfullnameLettersOnly(){
		return prop.getProperty("fullnameLettersOnly");
	}
	
	public static String getemailEmpty(){
		return prop.getProperty("emailEmpty");
	}
	
	public static String getemailInvaliedAndMinChar(){
		return prop.getProperty("emailInvaliedAndMinChar");
	}
	
	public static String getemailInvalied(){
		return prop.getProperty("emailInvalied");
	}
	
	public static String getcontactNumberEmpty(){
		return prop.getProperty("contactNumberEmpty");
	}
	
	public static String getcontactNumberMinandNumbersOnly(){
		return prop.getProperty("contactNumberMinandNumbersOnly");
	}
	
	public static String getcontactNumberMinChar(){
		return prop.getProperty("contactNumberMinChar");
	}
	
	public static String getcontactNumberNumberOnly(){
		return prop.getProperty("contactNumberNumberOnly");
	}
	
	public static String getaddressEmpty(){
		return prop.getProperty("addressEmpty");
	}
	
	public static String getaddressSpecialChar(){
		return prop.getProperty("addressSpecialChar");
	}
	
	public static String getaddModelHeader(){
		return prop.getProperty("addModelHeader");
	}
	
	public static String getaddSuccess(){
		return prop.getProperty("addSuccess");
	}
	
	public static String geteditModelHeader(){
		return prop.getProperty("editModelHeader");
	}
	
	public static String geteditSuccess(){
		return prop.getProperty("editSuccess");
	}
	
	public static String getdeleteModelHeader(){
		return prop.getProperty("deleteModelHeader");
	}
	
	public static String getdeleteConfirmation(){
		return prop.getProperty("deleteConfirmation");
	}
	
	public static String getdeleteSuccess(){
		return prop.getProperty("deleteSuccess");
	}
	
	public static String getsearchEmpty(){
		return prop.getProperty("searchEmpty");
	}

}
