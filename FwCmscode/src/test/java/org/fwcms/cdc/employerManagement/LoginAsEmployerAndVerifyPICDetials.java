package org.fwcms.cdc.employerManagement;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCEmployerLoginInitiator;
import org.fwcms.pages.cdc.employer.HomePage;
import org.fwcms.pages.cdc.employer.PICPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginAsEmployerAndVerifyPICDetials extends CDCEmployerLoginInitiator{

	@DataProvider(name="getVerifyEmployerRegistrationTest")
	public Object[][] returnVerifyEmployerRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(LoginAsEmployerAndVerifyPICDetials.class.getResource("/org/fwcms/cdc/employermanagement/VerifyEmployerRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getVerifyEmployerRegistrationTest")
	public void loginAsEmployerAndVerifyPICDetialsTest(HashMap<String, String> data) throws Exception
	{
		WebDriver driver = getDriver();
		HomePage cdcEmployerHomePage=new HomePage(driver).initElements();
		PICPage PICdetails=new PICPage(driver).initElements();
		cdcEmployerHomePage.VerifyHeader();
		cdcEmployerHomePage.verifyReportAndAccountManagementMenu();
		cdcEmployerHomePage.clickReportAndAccountManagementMenuAndVerifyHeader("Reports & Account Management");
		cdcEmployerHomePage.clickManagePICcredentialsMenuAndVerifyHeader("PIC Details");
		//Verify PIC details 
		PICdetails.verifyPIConeDetails();	
		if(PICdetails.isPICtwoPresent()){
		PICdetails.verifyPICtwoDetails();
		}
		PICdetails.VerifyNoteMessage();
	}
}
