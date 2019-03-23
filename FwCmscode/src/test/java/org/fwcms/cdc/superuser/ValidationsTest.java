package org.fwcms.cdc.superuser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetPrivilegedUsersDetailsPageProp;
import org.fwcms.util.BestinetSuperUserCredentialsProp;
import org.fwcms.initiators.CDCInitiator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test method to verify the field level validations when creating a privileged user as super user
 */
public class ValidationsTest extends CDCInitiator{
	
	@DataProvider(name="addPrivilegeUserValidationsAsSuperUser")
	public Object[][] addPrivilegeUserValidationsAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ValidationsTest.class.getResource("/org/fwcms/cdc/superuser/addPrivilegeUserValidations.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="addPrivilegeUserValidationsAsSuperUser",description="PrivUser_AddUpdt_15, PrivUser_AddUpdt_16")
	public void addPrivilegeUserValidationsAsSuperUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.clickAddUserLink();
		
		String fullNameEmptyMessage = BestInetPrivilegedUsersDetailsPageProp.getfullnameEmpty();
		String fullNameMinCharAndLettersOnlyMessage = BestInetPrivilegedUsersDetailsPageProp.getfullnameMinCharAndLettersOnly();
		String fullNameMinCharMessage = BestInetPrivilegedUsersDetailsPageProp.getfullnameMinChar();
		String fullNameLettersOnlyMessage = BestInetPrivilegedUsersDetailsPageProp.getfullnameLettersOnly();
		ud.validateFullName(fullNameEmptyMessage, data.get("fullnameMinCharAndLettersOnlydata"), fullNameMinCharAndLettersOnlyMessage, data.get("fullnameMinChardata"), fullNameMinCharMessage, data.get("fullnameLettersOnlyData"), fullNameLettersOnlyMessage);
		
		String emailEmptyMessage = BestInetPrivilegedUsersDetailsPageProp.getemailEmpty();
		String emailInvaliedAndMinCharMessage = BestInetPrivilegedUsersDetailsPageProp.getemailInvaliedAndMinChar();
		String emailInvaliedMessage = BestInetPrivilegedUsersDetailsPageProp.getemailInvalied();
		ud.validateEmail(emailEmptyMessage, data.get("invaliedEmailAndMinCharData"), emailInvaliedAndMinCharMessage, data.get("invaliedEmailData"), emailInvaliedMessage);
		
		String contactNumberEmptyMessage = BestInetPrivilegedUsersDetailsPageProp.getcontactNumberEmpty();
		String contactNumberMinAndNumbersOnlyMessage = BestInetPrivilegedUsersDetailsPageProp.getcontactNumberMinandNumbersOnly();
		String contactNumberMinCharMessage = BestInetPrivilegedUsersDetailsPageProp.getcontactNumberMinChar();
		String contactNumberNumbersOnlyMessage = BestInetPrivilegedUsersDetailsPageProp.getcontactNumberNumberOnly();
		ud.validateContactNumber(contactNumberEmptyMessage, data.get("contactNumberMinandNumbersOnlyData"), contactNumberMinAndNumbersOnlyMessage, data.get("contactNumberMinCharData"), contactNumberMinCharMessage, data.get("contactNumberNumberOnlyData"), contactNumberNumbersOnlyMessage);
		
		String addressEmptyMessage = BestInetPrivilegedUsersDetailsPageProp.getaddressEmpty();
		String addressSpeciarCharMessage = BestInetPrivilegedUsersDetailsPageProp.getaddressSpecialChar();
		ud.validateAddress(addressEmptyMessage, data.get("addressSpecialCharData"), addressSpeciarCharMessage);
	}
	
}
