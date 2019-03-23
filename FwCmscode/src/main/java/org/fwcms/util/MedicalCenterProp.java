package org.fwcms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.olo.util.PropertyReader;


public class MedicalCenterProp {
	
	private static final Logger logger = LogManager.getLogger(MedicalCenterProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading medicalCenter.properties");
				prop.load(PropertyReader.class.getResourceAsStream("/config/medicalCenter.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	public static String getActiveMedicalCenterId(){
		return prop.getProperty("activeMedicalCenterId");
	}
	
	public static String getActiveMedicalCenterRepUserName(){
		return prop.getProperty("activeMedicalCenterRepresentativeUserName");
	}
	
	public static String getActiveMedicalCenterRepPassword(){
		return prop.getProperty("activeMedicalCenterRepresentativePassword");
	}
	
	public static String getSearchMCByName(){
		return prop.getProperty("searchMCByName");
	}
	
	
	
	//Set The Value Of Active Medical Center Id In prerequisitedata.properties
	public static  void setActiveMedicalCenterId(String newValue) throws IOException{
		logger.info("Save activeMedicalCenterId ");
		prop.setProperty("activeMedicalCenterId", newValue);
		String path = System.getProperty("user.dir");
		logger.info(path);
		File configFile = new File(path+"\\src\\main\\resources\\config\\medicalCenter.properties");
		FileWriter writer = null;
		try {
			writer = new FileWriter(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  prop.store(writer, "host settings");
	}
}
