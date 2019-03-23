package org.fwcms.cdc.operator;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.cdc.AccessDeniedPage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when Bestinet Operator User logins to CDC
 */
public class MultipleRolesTest extends CDCInitiator{
	
	@Test(description="7, 9")
	public void loginAccess() throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetOperatorUserCredentialsProp.getBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getBestInetOperatorPassword());
		AccessDeniedPage adp = new AccessDeniedPage(driver).initElements();
		adp.verifyErrorMessageVisible();
		adp.verifyErrorMessageText();
		 
	}
	
}
