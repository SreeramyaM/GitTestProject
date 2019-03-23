package org.fwcms.cdc.privilegeduser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.cdc.ChangePasswordPage;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
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
public class ChangePasswordTest extends CDCInitiator{
	
	@DataProvider(name="changePasswordAsPrivilegedUser")
	public Object[][] changePasswordAsPrivilegedUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordTest.class.getResource("/org/fwcms/cdc/privilegeduser/changePasswordAsPrivilegedUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="changePasswordAsPrivilegedUser",description="PrivUserOper_ChngPwd_01, PrivUserOper_ChngPwd_03, PrivUserOper_ChngPwd_07, PrivUserOper_ChngPwd_08")
	public void changePasswordAsPrivilegedUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userName = BestinetPrivilegedUserCredentialsProp.getChangePasswordBestInetPrivilegedUserUserName();
		String oldPassword = BestinetPrivilegedUserCredentialsProp.getChangePasswordBestInetPrivilegedUserPassword();
		new LoginPage(driver).initElements().loginToCDC(userName, oldPassword);
		new HomePage(driver).initElements().clickChangePassword();
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		String newPassword=data.get("newPassword")+new Random().nextInt((1000-1)+1);
		cpp.changePassword(oldPassword, newPassword, newPassword, ChangePasswordPageProp.getchangedPasswordSuccess());
		BestinetPrivilegedUserCredentialsProp.setChangePasswordBestinetPrivilegedUserPassword(newPassword);
	
	}
	
}
