package org.fwcms.testdata.cdc;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChangePasswordValidationsData {
	
	private JSONArray invalidPasswords;
	private JSONArray invaliedOldPasswords;
	
	public ChangePasswordValidationsData(JSONObject data) throws Exception{
		this.invaliedOldPasswords = data.getJSONArray("invaliedOldPasswords");
		this.invalidPasswords = data.getJSONArray("invalidPasswords");
	}
		
	public JSONArray getInvalidPasswords() {
		return invalidPasswords;
	}
	public void setInvaliedPasswords(JSONArray invalidPasswords) {
		this.invalidPasswords = invalidPasswords;
	}

	public JSONArray getInvaliedOldPasswords() {
		return invaliedOldPasswords;
	}

	public void setInvaliedOldPasswords(JSONArray invaliedOldPasswords) {
		this.invaliedOldPasswords = invaliedOldPasswords;
	}
	
	
	
}
