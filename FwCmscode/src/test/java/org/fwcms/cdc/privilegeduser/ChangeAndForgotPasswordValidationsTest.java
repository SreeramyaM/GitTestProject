package org.fwcms.cdc.privilegeduser;

import java.io.FileReader;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.cdc.ChangePasswordPage;
import org.fwcms.pages.cdc.ForgotPasswordPage;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.testdata.cdc.ChangePasswordValidationsData;
import org.fwcms.testdata.cdc.ForgotPasswordValidationsData;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test method to validate Change Password form as Privileged User
 * Test method to validate Forgot Password form as Privileged User
 */
public class ChangeAndForgotPasswordValidationsTest extends CDCInitiator{
	
	@DataProvider(name="changePasswordFormValidationsAsPrivilegedUser")
	public Object[][] changePasswordFormValidationsAsPrivilegedUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangeAndForgotPasswordValidationsTest.class.getResource("/org/fwcms/cdc/privilegeduser/changePasswordFormValidationsAsPrivilegedUser.json").getFile()));
		org.json.JSONArray jaa = new org.json.JSONArray(ja.toJSONString());
		Object[][] result = new Object[jaa.length()][1];
		for(int i=0;i<jaa.length();i++){
			result[i][0] = new ChangePasswordValidationsData(jaa.getJSONObject(i));
		}
		return result;
	}
	
	//Test method to validate change password form as privileged user
	@Test(dataProvider="changePasswordFormValidationsAsPrivilegedUser",description="PrivUserOper_ChngPwd_04, PrivUserOper_ChngPwd_05, PrivUserOper_ChngPwd_06")
	public void changePasswordFormValidationsAsPrivilegedUser(ChangePasswordValidationsData data) throws Exception{
		WebDriver driver = getDriver();
		String userName = BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName();
		String oldPassword = BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword();
		new LoginPage(driver).initElements().loginToCDC(userName, oldPassword);
		
		new HomePage(driver).initElements().clickChangePassword();
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		cpp.validateOldPasswordFieldOnSubmitClick(data.getInvaliedOldPasswords());
		cpp.validateNewPasswordFieldOnSubmitclick(data.getInvalidPasswords());
		cpp.validateConfirmPasswordFieldOnSubmitClick(data.getInvalidPasswords());
	}
	
	@DataProvider(name="forgotPasswordFormValidationsAsPrivilegedUser")
	public Object[][] forgotPasswordFormValidationsAsPrivilegedUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangeAndForgotPasswordValidationsTest.class.getResource("/org/fwcms/cdc/privilegeduser/forgotPasswordFormValidationsAsPrivilegedUser.json").getFile()));
		org.json.JSONArray jaa = new org.json.JSONArray(ja.toJSONString());
		Object[][] result = new Object[jaa.length()][1];
		for(int i=0;i<jaa.length();i++){
			result[i][0] = new ForgotPasswordValidationsData(jaa.getJSONObject(i));
		}
		return result;
	}
	
	//Test method to validate forgot password form as privileged user
	@Test(dataProvider="forgotPasswordFormValidationsAsPrivilegedUser",description="PrivUserOper_ForgPwd_01, PrivUserOper_ForgPwd_02, PrivUserOper_ForgPwd_03, PrivUserOper_ForgPwd_04, PrivUserOper_ForgPwd_05, PrivUserOper_ForgPwd_06" )
	public void forgotPasswordFormValidationsAsPrivilegedUser(ForgotPasswordValidationsData data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().clickForgotPassword();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver).initElements();
		fpp.verifyPageHeader();
		fpp.verifyElementsPresentInForgotPasswordForm();
		fpp.validateUserNameFieldOnSubmitClick(data.getInvalidUserNames());
		fpp.validateRegisteredEmailFieldOnSubmitClick(data.getInvalidEmails());
		fpp.validateRegisteredMobileFieldOnSubmitClick(data.getInvalidMobileNumbers());
	}
	
}
