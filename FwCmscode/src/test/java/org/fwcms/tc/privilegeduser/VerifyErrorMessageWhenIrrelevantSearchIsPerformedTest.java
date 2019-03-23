package org.fwcms.tc.privilegeduser;

import org.fwcms.initiators.TCPrivilegedUserLoginInitiator;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**MedCentre_Verify_09 : Verify the error message when the privilege user enters the data mismatching with the radio button chosen.
 * MedCentre_Verify_10 : Verify the error message when the privilege user enters the data mismatching with the radio button chosen.
 * MedCentre_Verify_11 : Verify the error message when the privilege user enters the data mismatching with the radio button chosen.
 * MedCentre_Verify_12: Verify the error message when the privilege user enters an irrelevant data.
 **/

public class VerifyErrorMessageWhenIrrelevantSearchIsPerformedTest extends TCPrivilegedUserLoginInitiator{

	@Test(description="MedCentre_Verify_09")
	public void verifyErrorMessageWhenIrrelevantSearchIsPerformed() throws Exception{
		WebDriver driver = getDriver();
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage searchMC  = new SearchMedicalCenterPage(driver).initElements();
		searchMC.searchMCByName("99999");
		searchMC.verifySuccessMessage("No results found!");
		searchMC.searchByRegistrationNo("4444");
		searchMC.verifySuccessMessage("No results found!");
		searchMC.searchByMedicalCenterID("44444");
		searchMC.verifySuccessMessage("No results found!");
		searchMC.searchByApplicationID("343434");
		searchMC.verifySuccessMessage("No results found!");
		searchMC.searchByRegistrationNo("3434353");
		searchMC.verifySuccessMessage("No results found!");
	}
}
