package org.fwcms.tc.representative;

import java.io.FileReader;
import java.util.Random;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.ChangePasswordPage;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.testdata.tc.ResetPasswordAsRepresentative;
import org.fwcms.util.MCRepresentativeCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *Confirm the change password functionality when
 *1. MC Representative logs in to the system for the first time
 
 **/
public class ChangePasswordTest extends TCInitiator{
	
	@DataProvider(name="resetPasswordAsRepresentative")
	public Object[][] resetPasswordAsRepresentativeData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordTest.class.getResource("/org/fwcms/tc/representative/resetPasswordAsRepresentative.json").getFile()));
		org.json.JSONArray jaa = new org.json.JSONArray(ja.toJSONString());
		Object[][] result = new Object[jaa.length()][1];
		for(int i=0;i<jaa.length();i++){
			result[i][0] = new ResetPasswordAsRepresentative(jaa.getJSONObject(i));
		}
		return result;
	}
	/**
	 * Iteration 1 - UC 5.1 
	 */
	@Test(dataProvider="resetPasswordAsRepresentative",description="Representative_ChngPwd_02, Representative_ChngPwd_04, Representative_ChngPwd_05, Representative_ChngPwd_06, Representative_ChngPwd_07, Representative_ChngPwd_08, Representative_ChngPwd_09, Representative_ChngPwd_10, Representative_ChngPwd_11, Representative_ChngPwd_13, Representative_ChngPwd_15, Representative_ChngPwd_16")
	public void resetPasswordFlowAsRepresentative(ResetPasswordAsRepresentative data) throws Exception{
		WebDriver driver = getDriver();
		String userName = MCRepresentativeCredentialsProp.getChangePasswordMcRepresentativeUserName();
		String oldPassword = MCRepresentativeCredentialsProp.getChangePasswordMcRepresentativePassword();
		String newPassword = MCRepresentativeCredentialsProp.getNewMcRepresentativeNewPassword();
		newPassword=newPassword+new Random().nextInt((1000-1)+1);
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToTC(userName, oldPassword);
		new HomePage(driver).initElements().clickChangePasswordOption();
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		cpp.changePasswordFillDetailsAndClickSubmit(oldPassword, newPassword, newPassword);
		cpp.verifySecurityQuestionAndAnswer();
		cpp.answerFirstTimeQuestion(MCRepresentativeCredentialsProp.getNewMcRepresentativeSecurityQuestion(), MCRepresentativeCredentialsProp.getNewMcRepresentativeSecurityAnswer());
		cpp.verifyMessageAfterChangePassword();
		MCRepresentativeCredentialsProp.setChangePasswordMCRepresentativePassword(newPassword);
	}
}
