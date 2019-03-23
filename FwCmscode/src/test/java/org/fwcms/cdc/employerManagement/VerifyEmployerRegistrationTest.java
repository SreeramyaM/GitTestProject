package org.fwcms.cdc.employerManagement;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;

import org.fwcms.initiators.CDCEmployerRegistrationInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.employer.EmployerRegistrationHomePage;
import org.fwcms.prop.cdc.EmployerManagementProp;
import org.fwcms.util.EmployerCredentialsProp;
import org.fwcms.util.MySqlAccess;
import org.google.mail.GmailEmailPage;
import org.google.mail.GmailInboxPage;
import org.google.mail.GmailLoginPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyEmployerRegistrationTest extends CDCEmployerRegistrationInitiator{

	@DataProvider(name="getVerifyEmployerRegistrationTest")
	public Object[][] returnVerifyEmployerRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(VerifyEmployerRegistrationTest.class.getResource("/org/fwcms/cdc/employermanagement/VerifyEmployerRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getVerifyEmployerRegistrationTest",description="emp_management002, emp_management008, emp_management009, emp_management010, emp_management013, emp_management014")
	public void verifyEmployerRegistration(HashMap<String, String> data) throws Exception
	{
		/** Creating unique MYKAD number */
		Random randomGenerator = new Random();
		int randomNumber=randomGenerator.nextInt(10000000);
		String MYKADNUMBER="MYKAD"+randomNumber;
		System.out.println(MYKADNUMBER);
		
		String org_reg_number= new MySqlAccess().createMykadNumber(MYKADNUMBER,data.get("Employer Email Address"), data.get("Employer Hand Phone Number"));
		System.out.println("org_reg_number: "+org_reg_number);
		WebDriver driver = getDriver();
		EmployerRegistrationHomePage employerRegistration=new EmployerRegistrationHomePage(driver).initElements();
		employerRegistration.verifyHeading("Get Access to FWCMS");
		employerRegistration.verifyTextDisplayLineOne(EmployerManagementProp.getTextDisplay1());
		employerRegistration.verifyTextDisplayLineTwo(EmployerManagementProp.getTextDisplay2());
		employerRegistration.verifyEmployeeNoteDisplay(EmployerManagementProp.getNote());
		employerRegistration.registerEmployeeWithMyKadNumber(org_reg_number.trim(), data.get("Employer Email Address"), data.get("Employer Hand Phone Number"));
		employerRegistration.verifyEmployeeDetailsPopupDisplayedWithEmployeeDetails(org_reg_number, data.get("Employer Email Address"), data.get("Employer Hand Phone Number"));
		employerRegistration.ClickGenerateCredentials();
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(EmployerManagementProp.getPostemployerRegistrationStatusMessage());
		String orgName=new MySqlAccess().getOrganisationName(org_reg_number);
		System.out.println("org name = "+orgName);
		String accessToken=new MySqlAccess().getAccessToken(MYKADNUMBER);
		System.out.println("accessToken="+accessToken);
		
		/** verify new employer details and click on submit and generate otp */
		driver.get("https://fw5.fwcms.com.my/cdc/generateEmployerCredentials.do?accessToken="+accessToken);
		employerRegistration.verifyHeading("New Employer Details");
		employerRegistration.verifyEmployeeEmail(data.get("Employer Email Address"));
		employerRegistration.verifyEmployeeMobile("+60"+data.get("Employer Hand Phone Number"));
		employerRegistration.clickEmpDetailsSubmitButton();
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyContainsTextCloseStatusBarAndWaitForOverlayToHide("OTP is sent as SMS on the registered mobile number.");
		
		/** Type OTP and generate credentials */
		String OTPnumber=new MySqlAccess().getOTPOfEmp(MYKADNUMBER);
		employerRegistration.verifyOTPpopupAndTypeOTP(OTPnumber);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar(data.get("Employer credentials created success message"));
		
		/** Retrieving the employer credentials from gmail */
		driver.get(configProp.getProperty("gmail"));
		new GmailLoginPage(driver).initElements().loginToGmail(data.get("Employer Email Address"),data.get("gmailPassword"));
		new GmailInboxPage(driver).initElements().clickOnOEmployerRegisteredEmail(orgName);
		String userName=new GmailEmailPage(driver).initElements().retrieveNewUserUserName();
		String password=new GmailEmailPage(driver).initElements().retrieveNewUserPassword();
		EmployerCredentialsProp.setNewEmployerUserName(userName);
		EmployerCredentialsProp.setNewEmployerPassword(password);
	
		
	}
}
