package org.fwcms.tc.privilegeduser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;



import org.fwcms.initiators.TCPrivilegedUserLoginInitiator;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**MedCentre_Verify_20 : Check for the Edit button feature*/

public class VerifyEditFunctionalityOfCreditLimitTest extends TCPrivilegedUserLoginInitiator{
	
	@DataProvider(name="getMedicalCenterRegistration",parallel=false)
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(VerifyEditFunctionalityOfCreditLimitTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}

	@Test(dataProvider="getMedicalCenterRegistration",description="MedCentre_Verify_20")
	public void verifyEditFunctionalityOfCreditLimit(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		int randomCreditLimit=new Random().nextInt(500 - 100 + 1) + 100;
		String creditLimit=Integer.toString(randomCreditLimit);
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage editCreditLimit  = new SearchMedicalCenterPage(driver).initElements();
		editCreditLimit.searchByNameAndStatus(data.get("medicalcentername"), "Active");
		editCreditLimit.selectMCinListAndClickOnMedicalCenterDetails(0);
		editCreditLimit.updateCreditLimit(creditLimit);
		editCreditLimit.clickCreditLimitSaveButton();
		editCreditLimit.verifyConfirmationPopupAndClickOK();
		editCreditLimit.verifySuccessMessage("Registration limit for medical center updated successfully");
		editCreditLimit.verifyCreditLimitIfEdited(creditLimit);
		
}
}
