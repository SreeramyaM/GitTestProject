package org.fwcms.cdc.privilegeduser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetOperatorUsersDetailsPageProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.fwcms.initiators.CDCInitiator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a privileged user searches for an operator user in the system using
 * 1. Name
 * 2. Email
 * 3. Contact Number
 * 4. Empty Data
 */
public class SearchFunctionalityTest extends CDCInitiator{
	
	@DataProvider(name="createOperatorUserAsPriviligedUser")
	public Object[][] addEditDeletePrivilegedUserAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(SearchFunctionalityTest.class.getResource("/newdb/createBestInetOperatorUsers.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	//Test method to search operator user as privileged user
	@Test(dataProvider="createOperatorUserAsPriviligedUser")
	public void searchFunctionalityAsPrivilegedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.searchByName(data.get("fullName"));
		ud.searchByEmail(data.get("emailId"));
		ud.searchByContactNumber(data.get("contactNumber"));
		ud.searchByEmptyData(BestInetOperatorUsersDetailsPageProp.getsearchEmpty());
	}
	
}
