package org.fwcms.testdata.tc;

import org.json.JSONArray;
import org.json.JSONObject;

public class AddEditDeleteOperatorAsRepresentative {
	
	private JSONArray invalidUserFullNames;
	private JSONArray invalidEmails;
	private JSONArray invalidMobileNumbers;
	private String fullName;
	private String email;
	private String mobileNumber;
	private JSONArray invalidReasons;
	private String reason;
	
	public AddEditDeleteOperatorAsRepresentative(JSONObject data) throws Exception{
		this.invalidUserFullNames = data.getJSONArray("invalidUserFullNames");
		this.invalidEmails = data.getJSONArray("invalidEmails");
		this.invalidMobileNumbers = data.getJSONArray("invalidMobileNumbers");
		this.fullName = data.getString("fullName");
		this.email = data.getString("email");
		this.mobileNumber = data.getString("mobileNumber");
		this.invalidReasons = data.getJSONArray("invalidReasons");
		this.reason = data.getString("reason");
	}
	
	public JSONArray getInvalidUserFullNames() {
		return invalidUserFullNames;
	}
	
	public void setInvalidUserFullNames(JSONArray invalidUserFullNames) {
		this.invalidUserFullNames = invalidUserFullNames;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public JSONArray getInvalidReasons() {
		return invalidReasons;
	}

	public void setInvalidReasons(JSONArray invalidReasons) {
		this.invalidReasons = invalidReasons;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
