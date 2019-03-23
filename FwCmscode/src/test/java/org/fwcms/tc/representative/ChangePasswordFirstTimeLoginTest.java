package org.fwcms.tc.representative;

import java.io.FileReader;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.ChangePasswordPage;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.LogoutPage;
import org.fwcms.prop.tc.ChangePasswordPageProp;
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
public class ChangePasswordFirstTimeLoginTest extends TCInitiator{
	
	@DataProvider(name="resetPasswordAsRepresentative")
	public Object[][] resetPasswordAsRepresentativeData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordFirstTimeLoginTest.class.getResource("/org/fwcms/tc/representative/resetPasswordAsRepresentative.json").getFile()));
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
	public void resetPasswordFlowAsFirstTimeRepresentative(ResetPasswordAsRepresentative data) throws Exception{
		WebDriver driver = getDriver();
		String userName = MCRepresentativeCredentialsProp.getNewMcRepresentativeUserName();
		String oldPassword = MCRepresentativeCredentialsProp.getNewMcRepresentativePassword();
		String newPassword = MCRepresentativeCredentialsProp.getNewMcRepresentativeNewPassword();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToTC(userName, oldPassword);
		new HomePage(driver).initElements().clickSignOutLink();
		new LogoutPage(driver).initElements().clickBackToLogin();
		new LogoutPage(driver).initElements().navigateToLoginPage();
		lp.loginToTC(userName, oldPassword);
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		cpp.verifyElementsPresentInChangePasswordPage();
		cpp.changePasswordFillDetailsAndClickSubmit(data.getPassword(), data.getPassword(), data.getPassword());
		cpp.verifyInvaliedOldPassword(ChangePasswordPageProp.getinvaliedOldPassword());
		cpp.changePasswordFillDetailsAndClickSubmit(oldPassword, newPassword, newPassword);
		cpp.verifySecurityQuestionAndAnswer();
		cpp.answerFirstTimeQuestion(MCRepresentativeCredentialsProp.getNewMcRepresentativeSecurityQuestion(), MCRepresentativeCredentialsProp.getNewMcRepresentativeSecurityAnswer());
		cpp.verifyMessageAfterChangePassword();
		MCRepresentativeCredentialsProp.setnewMCRepPassword(newPassword);
	}
}
