package org.fwcms.tc.operator;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.ChangePasswordPage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when an operator user changes his/her password
 */

public class ChangePasswordFirstTimeLoginTest extends TCInitiator{
	
	@DataProvider(name="changePasswordAsOperatorUser")
	public Object[][] changePasswordAsOperatorUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordFirstTimeLoginTest.class.getResource("/org/fwcms/tc/operator/changePasswordAsOperatorUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="changePasswordAsOperatorUser",description="PrivUserOper_ChngPwd_01, PrivUserOper_ChngPwd_03, PrivUserOper_ChngPwd_07, PrivUserOper_ChngPwd_08")
	public void changePasswordAsOperatorUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userName = BestinetOperatorUserCredentialsProp.getNewBestInetOperatorUserName();
		String oldPassword = BestinetOperatorUserCredentialsProp.getNewBestInetOperatorPassword();
		new LoginPage(driver).initElements().loginToTC(userName, oldPassword);
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		cpp.verifyElementsPresentInChangePasswordPage();
		cpp.changePasswordFillDetailsAndClickSubmit(oldPassword, data.get("newPassword"), data.get("confirmPassword"));
		cpp.verifyMessageAfterChangePassword();
		BestinetOperatorUserCredentialsProp.setBestInetOperatorUserPassword(data.get("newPassword"));
		BestinetOperatorUserCredentialsProp.setnewBestInetOperatorUserPassword(data.get("newPassword"));
	}
	
}
