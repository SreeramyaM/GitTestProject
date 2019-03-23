package org.fwcms.tc.operator;

import org.fwcms.initiators.TCOperatorLoginInitiator;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**MC_Payment_toBestinet_06:Confirm the selection of appropriate country from "By country of origin" list.
 * MC_Payment_toBestinet_07:Confirm the selection of appropriate country from "By Registration status" list.*/

public class SearchMCByCountryAndByStatusTest extends TCOperatorLoginInitiator{

	@Test(description="MC_Payment_toBestinet_06,MC_Payment_toBestinet_07")
	public void SearchMCByCountryAndByStatus() throws Exception{
		WebDriver driver = getDriver();
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage searchMC  = new SearchMedicalCenterPage(driver).initElements();
		searchMC.searchByCountry("KAZAKHSTAN");
		searchMC.searchByStatusAndClickSearch("PENDING_VERIFICATION");
		searchMC.VerifyMCListWithStatus("Pending Verification");
		
	}
}
