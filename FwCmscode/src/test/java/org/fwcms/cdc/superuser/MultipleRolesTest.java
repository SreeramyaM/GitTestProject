package org.fwcms.cdc.superuser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetPrivilegedUsersDetailsPageProp;
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
	
	@DataProvider(name="assignAndRevokeBestInetOperatorRole")
	public Object[][] assignAndRevokeBestInetOperatorRoleData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MultipleRolesTest.class.getResource("/org/fwcms/cdc/superuser/addEditDeletePrivilegedUserAsSuperUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	/**
	 * Iteration 2 - UserManagement Multiple Roles
	 */
	@Test(dataProvider="assignAndRevokeBestInetOperatorRole",description="1, 6")
	public void assignAndRevokeBestInetOperatorRole(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		hp.clickAddEditDeleteUsersLink();
		UserDetailsPage udp = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		udp.clickAddUserLink();
		udp.createUser(data.get("fullName") , data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetPrivilegedUsersDetailsPageProp.getaddSuccess());
		udp.searchByCreatedUserAndVerifyUserInList();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.checkAdditionalRoleOption(true);
		udp.assignAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByCreatedUser();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleAssigned();
		udp.removeAdditionalRole(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		udp.searchByCreatedUser();
		udp.clickEditIconFirstVisibleUserInList();
		udp.waitForEditUserModelHeaderVisible();
		udp.verifyAdditionalRoleNotAssigned();
	}

}
