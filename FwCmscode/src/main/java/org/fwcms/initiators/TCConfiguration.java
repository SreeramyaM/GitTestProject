package org.fwcms.initiators;

import static com.olo.util.PropertyReader.configProp;

import com.olo.initiator.InitiatorUtil;

public class TCConfiguration extends InitiatorUtil{
	
	public static final String tcUrl = configProp.getProperty("tcUser");
	
}
