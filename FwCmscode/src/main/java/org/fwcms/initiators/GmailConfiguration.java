package org.fwcms.initiators;

import static com.olo.util.PropertyReader.configProp;

import com.olo.initiator.InitiatorUtil;

public class GmailConfiguration extends InitiatorUtil{
	
	public static final String gmailUrl = configProp.getProperty("gmail");
	
}
