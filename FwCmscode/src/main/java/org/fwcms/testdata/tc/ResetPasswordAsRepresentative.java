package org.fwcms.testdata.tc;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResetPasswordAsRepresentative {
	
	private JSONArray invalidPasswords;
	private JSONArray invaliedOldPasswords;
	private JSONArray invaliedSecurityAnswers;
	private String password;
	private String securityAnswer;
	
	public ResetPasswordAsRepresentative(JSONObject data) throws Exception{
		this.invaliedOldPasswords = data.getJSONArray("invaliedOldPasswords");
		this.invalidPasswords = data.getJSONArray("invalidPasswords");
		this.invaliedSecurityAnswers = data.getJSONArray("invaliedSecurityAnswers");
		this.password = data.getString("password");
		this.securityAnswer = data.getString("securityAnswer");
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

	public JSONArray getInvaliedSecurityAnswers() {
		return invaliedSecurityAnswers;
	}

	public void setInvaliedSecurityAnswers(JSONArray invaliedSecurityAnswers) {
		this.invaliedSecurityAnswers = invaliedSecurityAnswers;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	
}
