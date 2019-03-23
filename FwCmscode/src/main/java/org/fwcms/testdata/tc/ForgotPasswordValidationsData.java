package org.fwcms.testdata.tc;

import org.json.JSONArray;
import org.json.JSONObject;

public class ForgotPasswordValidationsData {
	
	private JSONArray invalidUserNames;
	private JSONArray invalidEmails;
	private JSONArray invalidMobileNumbers;
	
	public ForgotPasswordValidationsData(JSONObject data) throws Exception{
		this.invalidUserNames = data.getJSONArray("invalidUserNames");
		this.invalidEmails = data.getJSONArray("invalidEmails");
		this.invalidMobileNumbers = data.getJSONArray("invalidMobileNumbers");
	}
		
	public JSONArray getInvalidUserNames() {
		return invalidUserNames;
	}
	public void setInvaliedUserNames(JSONArray invaliedUserNames) {
		this.invalidUserNames = invaliedUserNames;
	}
	public JSONArray getInvalidEmails() {
		return invalidEmails;
	}
	public void setInvalidEmails(JSONArray invalidEmails) {
		this.invalidEmails = invalidEmails;
	}
	public JSONArray getInvalidMobileNumbers() {
		return invalidMobileNumbers;
	}
	public void setInvaliedMobileNumbers(JSONArray invalidMobileNumbers) {
		this.invalidMobileNumbers = invalidMobileNumbers;
	}
	
	
	
}
