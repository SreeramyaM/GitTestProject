package org.fwcms.tc.operator;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.ForgotPasswordPage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when an operator user has forgotten his/her password
 */
public class ForgotPasswordTest extends TCInitiator{
	
	@Test
	public void forgotPasswordAsOperatorUser() throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().clickForgotPasswordLink();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver).initElements();
		fpp.enterDetailsInForgotPasswordFormAndClickSubmit(BestinetOperatorUserCredentialsProp.getForgotPasswordBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getForgotPasswordBestInetOperatorEmail(), BestinetOperatorUserCredentialsProp.getForgotPasswordBestInetOperatorContact());
		
	}
	
}
