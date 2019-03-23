package org.fwcms.tc.representative;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.TCPrivilegedUserLoginInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.RepresentativeHomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.fwcms.pages.tc.UpdateMedicalCenterPage;
import org.fwcms.util.MedicalCenterProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Verify maximum and minimum count of doctor, owner and representative in update medical center page
 */

public class VerifyCountofEachMemberInUpdateMCTest extends TCPrivilegedUserLoginInitiator{
	WebDriver driver;
	
	@DataProvider(name="getVerifyMaxcountAndMinCount",parallel=false)
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(VerifyCountofEachMemberInUpdateMCTest.class.getResource("/org/fwcms/tc/representative/updateMedicalCenter.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@BeforeMethod
	public void verifyIfMedicalCenterIsInActiveState() throws Exception {
		driver = getDriver();
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
		
	}
	
	@Test(dataProvider="getVerifyMaxcountAndMinCount")
	public void VerifyMaxcountAndMinCountofDoctors(HashMap<String, String> data) throws Exception
	{
		
		//Attachments
		String projectPath = System.getProperty("user.dir");
		String docStampSign = projectPath+data.get("DoctorStampandSign");

		UpdateMedicalCenterPage updateMC=new UpdateMedicalCenterPage(driver).initElements();
		updateMC.updateMoreThanTenDoctorAndVerifyErrorMessage(docStampSign, "You can not add more than 10 doctors");
		updateMC.VerifyErrorMessageByDeletingAllRecords("Medical center must have at least 1 Doctor");
	}
	
	@Test(dataProvider="getVerifyMaxcountAndMinCount")
	public void VerifyReplacementofOwner(HashMap<String, String> data) throws Exception
	{
		String projectPath = System.getProperty("user.dir");
		String ownerProofDoc = projectPath+data.get("supportingDocs");
		
		UpdateMedicalCenterPage updateMC=new UpdateMedicalCenterPage(driver).initElements();
		updateMC.replaceOwnerOneDetailsAndVerify(data.get("ReplaceOwner1Name"), data.get("ReplaceOwner1Email"), data.get("ReplaceOwner1mobilno"), ownerProofDoc);
		updateMC.replaceOwnerTwoDetailsAndVerify(data.get("ReplaceOwner2Name"), data.get("ReplaceOwner2Email"), data.get("ReplaceOwner2mobilno"), ownerProofDoc);
	}
	
	@Test(dataProvider="getVerifyMaxcountAndMinCount")
	public void verifyDeletingASingleRepAndDeletingBothReps(HashMap<String, String> data) throws Exception
	{
		String projectPath = System.getProperty("user.dir");
		String repAuthLetter = projectPath+data.get("supportingDocs");
		
		UpdateMedicalCenterPage updateMC=new UpdateMedicalCenterPage(driver).initElements();
		updateMC.deleteRep1AndVerify(repAuthLetter);
	}
}
