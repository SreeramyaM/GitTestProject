package org.fwcms.tc.operator;


import org.fwcms.initiators.TCOperatorLoginInitiator;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.fwcms.util.MedicalCenterProp;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

/**MedCentre_Verify_03 : Search for the Medical center using the name
 * MedCentre_Verify_04 : Search for the Medical center using the Application ID.
 * MedCentre_Verify_05 : Search for the Medical center using the Registration no.
 * MedCentre_Verify_06 : Search for the Medical center using the Medical Center ID.*/

public class SearchForMedicalCenterTest extends TCOperatorLoginInitiator{
	
	@Test(description="MedCentre_Verify_03, MedCentre_Verify_04, MedCentre_Verify_05, MedCentre_Verify_06")
	public void searchForMedicalCenterAsOperatorUser() throws Exception{
		WebDriver driver = getDriver();
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage searchMC  = new SearchMedicalCenterPage(driver).initElements();
		searchMC.searchByNameAndVerify(MedicalCenterProp.getSearchMCByName());
		String appID=searchMC.getApplicationID();
		String registrationNo=searchMC.getRegistrationNumber();
		String medicalCenterId=searchMC.getMedicalCenterId();
		searchMC.searchByAppIDAndVerify(appID);
		searchMC.searchByRegistrationNoAndVerify(registrationNo);
		searchMC.searchByMedicalCenterIDandVerify(medicalCenterId);
	}
	
}
