package org.fwcms.tc.mcRegistration;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.tc.mcRegistrationPages.RegisterMedicalCenterPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olo.initiator.BrowserInitiator;

/**Confirm the functionality of the "Previous" & "Next" button.
 * MedCentre_Reg_50 : Verify free navigation of the representative among the different tabs. */

public class MedicalCenterNextAndPreviousButtonFunctionalityTest extends BrowserInitiator{
	
	@DataProvider(name="getMedicalCenterNextAndPreviousButtonFunctionalityTest")
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MedicalCenterNextAndPreviousButtonFunctionalityTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}

	@Test(dataProvider="getMedicalCenterNextAndPreviousButtonFunctionalityTest",description="MedCentre_Reg_43, MedCentre_Reg_44, MedCentre_Reg_10, MedCentre_Reg_20, MedCentre_Reg_21")
	public void medicalCenterNextAndPreviousButtonFunctionality(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		driver.get(configProp.getProperty("mcRegistration")+data.get("mcRegistrationCountry"));
		RegisterMedicalCenterPage medicalCenterReg = new RegisterMedicalCenterPage(driver).initElements();
		
		//Verify the active tabs while navigating through next & previous button
		medicalCenterReg.assertActiveTab("Medical Center Details");
		medicalCenterReg.clickNextButton();
		medicalCenterReg.assertActiveTab("Contact Person Details");
		medicalCenterReg.clickNextButton();
		medicalCenterReg.assertActiveTab("Doctor Details");
		medicalCenterReg.clickNextButton();
		medicalCenterReg.assertActiveTab("Attach Documents");
		medicalCenterReg.clickPreviousButton();
		medicalCenterReg.assertActiveTab("Doctor Details");
		medicalCenterReg.clickPreviousButton();
		medicalCenterReg.assertActiveTab("Contact Person Details");
		medicalCenterReg.clickPreviousButton();
		medicalCenterReg.assertActiveTab("Medical Center Details");
	}
	
	@Test(dataProvider="getMedicalCenterNextAndPreviousButtonFunctionalityTest",description="MedCentre_Reg_50")
	public void medicalCenterVerifyNavigationAmongDifferentTabs(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		driver.get(configProp.getProperty("mcRegistration")+data.get("mcRegistrationCountry"));
		RegisterMedicalCenterPage medicalCenterReg = new RegisterMedicalCenterPage(driver).initElements();
		
		//Verify the active tabs while navigating through next & previous button
		medicalCenterReg.assertActiveTab("Medical Center Details");
		medicalCenterReg.clickContactPersonTab();
		medicalCenterReg.assertActiveTab("Contact Person Details");
		medicalCenterReg.clickAttachDocumentTab();
		medicalCenterReg.assertActiveTab("Attach Documents");
		medicalCenterReg.clickDoctorDetailsTab();
		medicalCenterReg.assertActiveTab("Doctor Details");
	}
}
