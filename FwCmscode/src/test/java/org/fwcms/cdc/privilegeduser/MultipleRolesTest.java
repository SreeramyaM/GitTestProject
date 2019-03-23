package org.fwcms.cdc.privilegeduser;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.AccessDeniedPage;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.LogoutPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetOperatorUsersDetailsPageProp;
import org.fwcms.prop.cdc.BestInetPrivilegedUsersDetailsPageProp;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.fwcms.util.BestinetSuperUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a privileged user is assigned and revoked the additional role of an operator
 */
public class MultipleRolesTest extends CDCInitiator{
	
	@DataProvider(name="assignAndRevokeRole")
	public Object[][] assignAndRevokeRoleData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MultipleRolesTest.class.getResource("/org/fwcms/cdc/privilegeduser/addEditDeleteOperatorUserAsPrivilegedUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	/**
	 * Iteration 2 - UserManagement Bestinet Privileged User Multiple Roles
	 */
	@Test(dataProvider="assignAndRevokeRole")
	public void assignAndRevokeBestInetPrivilegedUserRole(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.clickAddEditDeleteUsersLink();
		UserDetailsPage udp = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.clickAddUserLink();
		udp.createUser(data.get("fullName") , data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetOperatorUsersDetailsPageProp.getaddSuccess());
		udp.searchByCreatedUserAndVerifyUserInList();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(false);
		udp.assignAdditionalRole(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		udp.searchByCreatedUser();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.removeAdditionalRole(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		udp.searchByCreatedUser();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleNotAssigned();
	}
	
	@Test(dataProvider="assignAndRevokeRole",description="13")
	public void verifyBestInetOperatorAsOnlyPriviligedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userFullName = BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorName();
		CommonElements cm = new CommonElements(driver).initElements();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.clickAddEditDeleteUsersLink();
		UserDetailsPage udp = new UserDetailsPage(driver).initElements();
		cm.waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(false);
		udp.assignAdditionalRole(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		LogoutPage loutp = new LogoutPage(driver).initElements();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		hp.assertSignOutLinkVisible();
		hp.clickSignOutLink();
		loutp.clickBackToLogin();
		
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		org.fwcms.pages.tc.HomePage tchp = new org.fwcms.pages.tc.HomePage(driver).initElements();
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
						
		driver.get(cdcUrl);
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		
 		hp.clickRolesAndPrivilegesLink();
		cm.waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(true);
		udp.removeAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleNotAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		hp.assertSignOutLinkVisible();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(cdcUrl); //changed here
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		hp.clickRolesAndPrivilegesLink();
		cm.waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(true);
		udp.assignAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		hp.assertSignOutLinkVisible();
		udp.clickSignOutLink();
		loutp.clickBackToLogin(); //added
		
		driver.get(configProp.getProperty("tcUser"));//failed here
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(cdcUrl);
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		hp.clickAddEditDeleteUsersLink();
		cm.waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(false);
		udp.removeAdditionalRole(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleNotAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		AccessDeniedPage adp = new AccessDeniedPage(driver).initElements();
		adp.verifyErrorMessageVisible();
		
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getmultipleRoleBestInetOperatorPassword());
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
		
	} 
	
	@Test(dataProvider="assignAndRevokeRole",description="14")
	public void verifyBestInetPriviligedUserAsOnlyOperator(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userFullName = BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserFullName();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.clickRolesAndPrivilegesLink();
		UserDetailsPage udp = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(true);
		udp.assignAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		LogoutPage loutp = new LogoutPage(driver).initElements();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		hp.assertSignOutLinkVisible();
		udp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		org.fwcms.pages.tc.HomePage tchp = new org.fwcms.pages.tc.HomePage(driver).initElements();
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(cdcUrl);
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		hp.clickAddEditDeleteUsersLink();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(false);
		udp.removeAdditionalRole(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleNotAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		AccessDeniedPage adp = new AccessDeniedPage(driver).initElements();
		adp.verifyErrorMessageText();
		//lp.verifyInvaliedLoginAccess();
		
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
		
		
		 // Rolling back the assigned roles, not part of test case
		driver.manage().deleteAllCookies();
		driver.get(cdcUrl);
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		hp.clickAddEditDeleteUsersLink();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.assignAdditionalRole(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		hp.assertSignOutLinkVisible();
		udp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(cdcUrl);
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		hp.clickRolesAndPrivilegesLink();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.removeAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByName(userFullName);
		udp.clickEditIconWithUserNameInList(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName());
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleNotAssigned();
		udp.clickCancelButonInEditUserModel();
		udp.clickSignOutLink();
		loutp.clickBackToLogin();
		loutp.navigateToLoginPage();
		
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		hp.assertSignOutLinkVisible();
		udp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(configProp.getProperty("tcUser"));
		new org.fwcms.pages.tc.LoginPage(driver).initElements().loginToTC(BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getmultipleRoleBestInetPrivilegedUserPassword());
		tchp.assertSignOutVisible();
		tchp.clickSignOutLink(); 
	} 
	
	
	@Test(dataProvider="assignAndRevokeRole",description="2, 4")
	public void assignAndRevokeBestInetOperatorRoleAsBestInetPrivilegedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.clickAddEditDeleteUsersLink();
		UserDetailsPage udp = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.clickAddUserLink();
		udp.createUser(data.get("fullName") , data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetPrivilegedUsersDetailsPageProp.getaddSuccess());
		hp.clickSignOutLink();
		
		LogoutPage lop = new LogoutPage(driver).initElements();
		lop.clickBackToLogin();
		lop.navigateToLoginPage();
		
		
		lp.loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		hp.clickRolesAndPrivilegesLink();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.searchByCreatedUser();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(true);
		udp.assignAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByCreatedUser();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.removeAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.verifyAdditionalRoleNotAssigned();
	}

}
