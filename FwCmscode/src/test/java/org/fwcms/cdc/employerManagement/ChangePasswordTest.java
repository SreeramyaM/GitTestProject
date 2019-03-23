package org.fwcms.cdc.employerManagement;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.ChangePasswordPage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.LogoutPage;
import org.fwcms.pages.cdc.employer.EmployerRegistrationHomePage;
import org.fwcms.prop.cdc.ChangePasswordPageProp;
import org.fwcms.util.EmployerCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when an employer wants to change his/her password
 */
public class ChangePasswordTest extends CDCInitiator{
	
	@DataProvider(name="changePasswordAsEmployer")
	public Object[][] changePasswordAsEmployer() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ChangePasswordTest.class.getResource("/org/fwcms/cdc/employermanagement/VerifyEmployerRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="changePasswordAsEmployer")
	public void changePasswordAsEmployer(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		String userName = EmployerCredentialsProp.getNewEmployerUserName();
		String oldPassword = EmployerCredentialsProp.getNewEmployerPassword();
		new LoginPage(driver).initElements().loginToCDC(userName, oldPassword);
		ChangePasswordPage cpp = new ChangePasswordPage(driver).initElements();
		cpp.verifyPageTitleContains(ChangePasswordPageProp.getpageTitleContains());
		cpp.clickSignOut();
		new LogoutPage(driver).initElements().clickBackToLogin();
		new LogoutPage(driver).initElements().navigateToLoginPage();
		new LoginPage(driver).initElements().loginToCDC(userName, oldPassword);
		
		EmployerRegistrationHomePage employerRegistration=new EmployerRegistrationHomePage(driver).initElements();
		employerRegistration.changePasswordAndClickOnSubmit(oldPassword, data.get("newPassword"));
		employerRegistration.verifySecurityQuestionAndAnswer();
		employerRegistration.selectSecurityQuestionAndAnswerIt("Who was your childhood hero?", "Rajinikanth");
		employerRegistration.clickSubmitButtonInSecurityQuestion();
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyText(data.get("Change in password success message"));
		EmployerCredentialsProp.setNewEmployerPassword(data.get("newPassword"));
	}
	
}
