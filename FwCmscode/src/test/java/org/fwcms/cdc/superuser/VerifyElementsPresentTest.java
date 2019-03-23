package org.fwcms.cdc.superuser;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetPrivilegedUsersDetailsPageProp;
import org.fwcms.initiators.CDCInitiator;
import org.fwcms.util.BestinetSuperUserCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Test method to verify elements present in privileged user details page as super user
 */
public class VerifyElementsPresentTest extends CDCInitiator{
	
	@Test(description="PrivUser_AddUpdt_01, PrivUser_AddUpdt_02, PrivUser_AddUpdt_13, PrivUser_AddUpdt_14")
	public void verifyElementsInUserDetailsAsSuperUser() throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.assertSignOutLinkVisible();
		hp.clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.verifyElementsPresenceInDetailsPage(BestInetPrivilegedUsersDetailsPageProp.getpageHeading());
		ud.clickAddUserLink();
		ud.verifyElementsInAddUserModel();
	}
	
}
