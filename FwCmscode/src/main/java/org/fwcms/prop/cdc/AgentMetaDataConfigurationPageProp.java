package org.fwcms.prop.cdc;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AgentMetaDataConfigurationPageProp {
	
	private static final Logger logger = LogManager.getLogger(AgentMetaDataConfigurationPageProp.class.getName());
	
	private static Properties prop = new Properties();
	
	static{
		try {
			if(prop.isEmpty()){
				logger.info("Loading AgentMetaDataConfigurationPage.properties");
				String lang = "en";
				if(configProp.containsKey("language")){
					lang = configProp.getProperty("language");
				}
				prop.load(AgentMetaDataConfigurationPageProp.class.getResourceAsStream("/language/"+lang+"/cdc/AgentMetaDataConfigurationPage.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.error("File Not Found in the specified location "+e.getMessage());
		} catch (IOException e) {
			logger.error("Could not able to open file "+e.getMessage());
		}
	}
	
	public static String getaddAgentMessage(){
		return prop.getProperty("addAgentMessage");
	}
	
	public static String geteditAgentMessage(){
		return prop.getProperty("editAgentMessage");
	}
	
	public static String getdeleteAgentMessage(){
		return prop.getProperty("deleteAgentMessage");
	}

}
