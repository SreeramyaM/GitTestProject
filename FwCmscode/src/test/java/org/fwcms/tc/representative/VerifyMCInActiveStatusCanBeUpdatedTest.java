package org.fwcms.tc.representative;

import static com.olo.util.PropertyReader.configProp;

import org.fwcms.initiators.TCPrivilegedUserLoginInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.RepresentativeHomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.fwcms.pages.tc.UpdateMedicalCenterPage;
import org.fwcms.util.MedicalCenterProp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Verify if medical center in active status can be updated
 */
public class VerifyMCInActiveStatusCanBeUpdatedTest extends TCPrivilegedUserLoginInitiator{

	@Test
	public void VerifyMCInActiveStatusCanBeUpdated() throws Exception
	{
		WebDriver driver = getDriver();
		String applicationID=MedicalCenterProp.getActiveMedicalCenterId();
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage searchMC  = new SearchMedicalCenterPage(driver).initElements();
		searchMC.searchByAppIDAndVerifyForStatus(applicationID, "Active");
		new CommonElements(driver).initElements().logout();
		
		driver.get(configProp.getProperty("tcUser"));
		new LoginPage(driver).initElements().loginToTC(MedicalCenterProp.getActiveMedicalCenterRepUserName(), MedicalCenterProp.getActiveMedicalCenterRepPassword());
		RepresentativeHomePage repsHomePage=new RepresentativeHomePage(driver).initElements();
		repsHomePage.clickUpdateMedicalCenterLink();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		UpdateMedicalCenterPage updateMC=new UpdateMedicalCenterPage(driver).initElements();
		updateMC.verifyIfMCInActiveStateCanBeUpdated();
		
	}
	
}

