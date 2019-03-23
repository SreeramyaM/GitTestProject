package org.fwcms.tc.operator;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.ChangePasswordPage;
import org.fwcms.pages.tc.HomePage;
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

public class ChangePasswordTest extends TCInitiator{
	
	@DataProvider(name="changePasswordAsOperatorUser")
	public Object[][] changePasswordAsOperatorUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordTest.class.getResource("/org/fwcms/tc/operator/changePasswordAsOperatorUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="changePasswordAsOperatorUser",description="PrivUserOper_ChngPwd_01, PrivUserOper_ChngPwd_03, PrivUserOper_ChngPwd_07, PrivUserOper_ChngPwd_08")
	public void changePasswordAsOperatorUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userName = BestinetOperatorUserCredentialsProp.getChangePasswordBestInetOperatorUserName();
		String oldPassword = BestinetOperatorUserCredentialsProp.getChangePasswordBestInetOperatorPassword();
		new LoginPage(driver).initElements().loginToTC(userName, oldPassword);
		new HomePage(driver).initElements().clickChangePasswordOption();
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		String newPassword=data.get("newPassword")+new Random().nextInt((1000-1)+1);
		cpp.changePasswordFillDetailsAndClickSubmit(oldPassword, newPassword,newPassword);
		cpp.verifyMessageAfterChangePassword();
		BestinetOperatorUserCredentialsProp.setChangePasswordBestinetOperatorPassword(newPassword);
		
	}
	
}
