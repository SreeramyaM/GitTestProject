package newdb.step1;

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
 * Confirm the system behavior when super user creates a privileged user
 */
public class CreatePriviligeUserAsSuperUser extends CDCInitiator{
	
	@DataProvider(name="createdPrivilegedUserAsSuperUser")
	public Object[][] addEditDeletePrivilegedUserAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(CreatePriviligeUserAsSuperUser.class.getResource("/newdb/createPrivilegedUsers.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="createdPrivilegedUserAsSuperUser")
	public void createPriviligedUserAsSuperUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.clickAddUserLink();
		ud.createUserWithExactFullName(data.get("fullName") , data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetPrivilegedUsersDetailsPageProp.getaddSuccess());
		
	}
}
