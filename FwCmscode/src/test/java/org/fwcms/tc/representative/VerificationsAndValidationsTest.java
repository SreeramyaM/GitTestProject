package org.fwcms.tc.representative;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.tc.ForgotPasswordPage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.testdata.tc.ForgotPasswordValidationsData;
import org.fwcms.util.MCRepresentativeCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Verify the field level validations of Forgot Password form as MC Representative user
 **/

public class VerificationsAndValidationsTest extends TCInitiator{
	
	@Test(description="Representative_ChngPwd_01")
	public void verifyElementsInLoginPage() throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().verifyElementsPresentInLoginPage();
	}
	
	@DataProvider(name="verifyAndValidateForgotPasswordPage")
	public Object[][] verifyAndValidateForgotPasswordPageData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(VerificationsAndValidationsTest.class.getResource("/org/fwcms/tc/representative/verifyAndValidateForgotPasswordPage.json").getFile()));
		org.json.JSONArray jaa = new org.json.JSONArray(ja.toJSONString());
		Object[][] result = new Object[jaa.length()][1];
		for(int i=0;i<jaa.length();i++){
			result[i][0] = new ForgotPasswordValidationsData(jaa.getJSONObject(i));
		}
		return result;
	}
	
	/**
	 * Iteration 1 - UC 5.1 
	 */
	@Test(dataProvider="verifyAndValidateForgotPasswordPage",description="Representative_ChngPwd_17, Representative_ChngPwd_18, Representative_ChngPwd_19, Representative_ChngPwd_20, Representative_ChngPwd_21, Representative_ChngPwd_22, Representative_ChngPwd_23")
	public void verifyAndValidateForgotPasswordPage(ForgotPasswordValidationsData data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().clickForgotPasswordLink();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver).initElements();
		fpp.verifyPageHeader("Forgot Password");
		fpp.verifyElementsPresentInForgotPasswordPage();
		fpp.clickCancelButton();
		
		driver.get(configProp.getProperty("tcUser"));
		new LoginPage(driver).initElements().clickForgotPasswordLink();
		fpp.waitForUserNameToVisible();
		fpp.validateUserNameFieldOnSubmitClick(data.getInvalidUserNames());
		fpp.validateRegisteredEmailFieldOnSubmitClick(data.getInvalidEmails());
		fpp.validateRegisteredMobileFieldOnSubmitClick(data.getInvalidMobileNumbers());
		fpp.enterDetailsInForgotPasswordFormAndClickSubmit(MCRepresentativeCredentialsProp.getForgotPasswordMcRepresentativeUserName(), MCRepresentativeCredentialsProp.getForgotPasswordMcRepresentativeEmail(), "87967356200");
		fpp.verifyInvaliedOldPassword();
		fpp.waitForUserNameToVisible();
		fpp.enterDetailsInForgotPasswordFormAndClickSubmit(MCRepresentativeCredentialsProp.getForgotPasswordMcRepresentativeUserName(), MCRepresentativeCredentialsProp.getForgotPasswordMcRepresentativeEmail(), MCRepresentativeCredentialsProp.getForgotPasswordMcRepresentativeContactNumber());
		fpp.verifySecurityQuestionAndAnswer();
		
	}
	
}
