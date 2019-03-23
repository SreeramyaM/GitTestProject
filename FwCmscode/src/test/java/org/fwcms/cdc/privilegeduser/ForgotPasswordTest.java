package org.fwcms.cdc.privilegeduser;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.cdc.ForgotPasswordPage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.prop.cdc.ForgotPasswordPageProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a privileged user has forgotten his/her password
 */
public class ForgotPasswordTest extends CDCInitiator{
	
	@Test(description="PrivUserOper_ForgPwd_07, PrivUserOper_ForgPwd_09, PrivUserOper_ForgPwd_16")
	public void forgotPasswordAsPrivilegedUser() throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().clickForgotPassword();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver).initElements();
		String successExpectedData = ForgotPasswordPageProp.getforgotPasswordSuccess();
		fpp.forgotPasswordFunctionality(BestinetPrivilegedUserCredentialsProp.getForgotPasswordBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getForgotPasswordBestInetPrivilegedUserEmail(), BestinetPrivilegedUserCredentialsProp.getForgotPasswordBestInetPrivilegedUserContactNumber(), successExpectedData);
		
	}
	
}
