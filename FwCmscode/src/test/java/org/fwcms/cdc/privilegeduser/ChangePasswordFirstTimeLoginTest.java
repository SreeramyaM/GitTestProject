package org.fwcms.cdc.privilegeduser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.cdc.ChangePasswordPage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.LogoutPage;
import org.fwcms.prop.cdc.ChangePasswordPageProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a privileged user wants to change his/her password
 */
public class ChangePasswordFirstTimeLoginTest extends CDCInitiator{
	
	@DataProvider(name="changePasswordAsPrivilegedUser")
	public Object[][] changePasswordAsPrivilegedUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordFirstTimeLoginTest.class.getResource("/org/fwcms/cdc/privilegeduser/changePasswordAsPrivilegedUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="changePasswordAsPrivilegedUser",description="PrivUserOper_ChngPwd_01, PrivUserOper_ChngPwd_03, PrivUserOper_ChngPwd_07, PrivUserOper_ChngPwd_08")
	public void changePasswordAsNewPrivilegedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userName = BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserUserName();
		String oldPassword = BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserPassword();
		new LoginPage(driver).initElements().loginToCDC(userName, oldPassword);
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		cpp.verifyPageTitleContains(ChangePasswordPageProp.getpageTitleContains());
		cpp.clickSignOut();
		new LogoutPage(driver).initElements().clickBackToLogin();
		new LogoutPage(driver).initElements().navigateToLoginPage();
		new LoginPage(driver).initElements().loginToCDC(userName, oldPassword);
		
		cpp = new ChangePasswordPage(driver).initElements();
		cpp.changePassword(oldPassword, data.get("newPassword"), data.get("confirmPassword"), ChangePasswordPageProp.getchangedPasswordSuccess());
		BestinetPrivilegedUserCredentialsProp.setBestInetPrivilegedUserPassword(data.get("newPassword"));
		BestinetPrivilegedUserCredentialsProp.setnewBestInetPrivilegedUserPassword(data.get("newPassword"));
	}
	
}
