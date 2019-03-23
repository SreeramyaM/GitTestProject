package org.fwcms.cdc.privilegeduser;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetOperatorUsersDetailsPageProp;
import org.fwcms.initiators.CDCInitiator;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Test method to verify elements present in operator user details page as privileged user
 */
public class VerifyElementsPresentTest extends CDCInitiator{
	
	@Test(description="Bestinet_Operator_AddUpdt_01, Bestinet_Operator_AddUpdt_02, Bestinet_Operator_AddUpdt_18, Bestinet_Operator_AddUpdt_19")
	public void verifyElementsInUserDetailsAsPrivilegedUser() throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.assertSignOutLinkVisible();
		hp.clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.verifyElementsPresenceInDetailsPage(BestInetOperatorUsersDetailsPageProp.getpageHeading());
		ud.clickAddUserLink();
		ud.verifyElementsInAddUserModel();
	}
	
}
