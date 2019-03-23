package org.fwcms.cdc.privilegeduser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetOperatorUsersDetailsPageProp;
import org.fwcms.prop.cdc.BestInetPrivilegedUsersDetailsPageProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.fwcms.initiators.CDCInitiator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test method to verify the field level validations when creating an operator user as privileged user
 */
public class ValidationsTest extends CDCInitiator{
	
	@DataProvider(name="addUserValidationsAsPrivilegedUser")
	public Object[][] addUserValidationsAsPrivilegedUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ValidationsTest.class.getResource("/org/fwcms/cdc/privilegeduser/addOperatorUserValidations.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="addUserValidationsAsPrivilegedUser",description="Bestinet_Operator_AddUpdt_20, Bestinet_Operator_AddUpdt_21")
	public void addUserValidationsAsPrivilegedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.clickAddUserLink();
		
		String fullNameEmptyMessage = BestInetOperatorUsersDetailsPageProp.getfullnameEmpty();
		String fullNameMinCharAndLettersOnlyMessage = BestInetOperatorUsersDetailsPageProp.getfullnameMinCharAndLettersOnly();
		String fullNameMinCharMessage = BestInetOperatorUsersDetailsPageProp.getfullnameMinChar();
		String fullNameLettersOnlyMessage = BestInetOperatorUsersDetailsPageProp.getfullnameLettersOnly();
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
