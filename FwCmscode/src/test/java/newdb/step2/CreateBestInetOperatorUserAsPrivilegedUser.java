package newdb.step2;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetOperatorUsersDetailsPageProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when privileged user creates an operator user
 */
public class CreateBestInetOperatorUserAsPrivilegedUser extends CDCInitiator{
	
	@DataProvider(name="createOperatorUserAsPriviligedUser")
	public Object[][] addEditDeletePrivilegedUserAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(CreateBestInetOperatorUserAsPrivilegedUser.class.getResource("/newdb/createBestInetOperatorUsers.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="createOperatorUserAsPriviligedUser")
	public void createBestinetOperatorUserAsPrivilegedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserPassword());
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.clickAddUserLink();
		ud.createUserWithExactFullName(data.get("fullName") , data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetOperatorUsersDetailsPageProp.getaddSuccess());
	}
	
}
