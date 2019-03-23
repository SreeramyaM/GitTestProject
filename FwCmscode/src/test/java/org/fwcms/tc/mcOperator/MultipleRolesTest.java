package org.fwcms.tc.mcOperator;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.AccessDeniedPage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.util.MCOperatorCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when MC Operator logins to TC
 */
public class MultipleRolesTest extends TCInitiator{
	
	@Test(description="8")
	public void loginAccess() throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToTC(MCOperatorCredentialsProp.getMcOperatorUserName(), MCOperatorCredentialsProp.getMcOperatorPassword());
		AccessDeniedPage adp = new AccessDeniedPage(driver).initElements();
		adp.verifyErrorMessageVisible();
		adp.verifyErrorMessageText();
	}
	
}
