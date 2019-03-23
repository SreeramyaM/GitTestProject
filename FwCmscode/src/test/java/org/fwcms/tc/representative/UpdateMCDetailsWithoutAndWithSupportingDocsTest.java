package org.fwcms.tc.representative;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.fwcms.initiators.TCOperatorLoginInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.RepresentativeHomePage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.fwcms.pages.tc.UpdateMedicalCenterPage;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.fwcms.util.MedicalCenterProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Search for a medical center and verify if it is active as bestinet operator user
 * Update the medical center as representative
 * Verify if the status of medical center is Pending Update Verification as bestinet operator user
 * Verify all the updated details and verify the medical center as bestinet operator user
 */

public class UpdateMCDetailsWithoutAndWithSupportingDocsTest extends TCOperatorLoginInitiator{

	@DataProvider(name="getUpdateMCDetailsWithoutAndWithSupportingDocs",parallel=false)
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(UpdateMCDetailsWithoutAndWithSupportingDocsTest.class.getResource("/org/fwcms/tc/representative/updateMedicalCenter.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getUpdateMCDetailsWithoutAndWithSupportingDocs",description="Update_MC001, Update_MC002, Update_MC003, Update_MC005, Update_MC006")
	public void updateMCDetailsWithoutAndWithSupportingDocs(HashMap<String, String> data) throws Exception
	{
		WebDriver driver = getDriver();
		//Attachments
		//String applicationID=PrerequisiteDataProp.getmcRepresentativeMedicalCenterId1();
		String applicationID=MedicalCenterProp.getActiveMedicalCenterId();
		String projectPath = System.getProperty("user.dir");
		String docStampSign = projectPath+data.get("DoctorStampandSign");
		String reg_Certificate = projectPath+data.get("supportingDocs");
		String owner1ProofDoc = projectPath+data.get("supportingDocs");
		String owner2ProofDoc = projectPath+data.get("supportingDocs");
		String rep1AuthorizationLetter=projectPath+data.get("supportingDocs");
		String rep2AuthorizationLetter=projectPath+data.get("supportingDocs");
		
		//Rendomutils
		String professionalId = RandomStringUtils.randomNumeric(8);
		// Login as Bestinet operator search for application ID and verify status as active
		
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage approveMC  = new SearchMedicalCenterPage(driver).initElements();
		approveMC.searchByAppIDAndVerifyForStatus(applicationID, "Active");
		new CommonElements(driver).initElements().logout();
		
		//Login as representative update the existing records
		driver.get(configProp.getProperty("tcUser"));
		//new LoginPage(driver).initElements().loginToTC(MCRepresentativeCredentialsProp.getmcRepresentativeUserName1(), MCRepresentativeCredentialsProp.getmcRepresentativePassword1());
		new LoginPage(driver).initElements().loginToTC(MedicalCenterProp.getActiveMedicalCenterRepUserName(), MedicalCenterProp.getActiveMedicalCenterRepPassword());
		RepresentativeHomePage repsHomePage=new RepresentativeHomePage(driver).initElements();
		repsHomePage.clickUpdateMedicalCenterLink();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		UpdateMedicalCenterPage updateMC=new UpdateMedicalCenterPage(driver).initElements();
		updateMC.clickMCUpdateDetailsLink();
		String regNo=updateMC.updateMCWithoutAndWithSupportingDocs(data.get("medicalcentername"),data.get("medicalregno"), data.get("medicalcenteraddress"),reg_Certificate,"* This field is required");
		updateMC.verifyAttachedDocsUnderDocumentSubmitted("Registration Certificate");
		updateMC.updateDoctorDetailsWithoutAndWithSupportingDocs(data.get("fullname"),professionalId,data.get("qualification"),data.get("address"),docStampSign, "*This field is required");
		updateMC.updateOwner1DetailsWithOutAndWithSupportingDocs(data.get("Owner1FullName"),data.get("Owner1Designation"),data.get("Owner1Email"),data.get("Owner1mobilno"),owner1ProofDoc, "* This field is required");
		updateMC.verifyAttachedDocsUnderDocumentSubmitted("Proof of Identity for first Owner/Director");
		updateMC.updateOwner2DetailsWithOutAndWithSupportingDocs(data.get("Owner2FullName"),data.get("Owner2Designation"),data.get("Owner2Email"),data.get("Owner2mobilno"),owner2ProofDoc, "* This field is required");
		updateMC.verifyAttachedDocsUnderDocumentSubmitted("Proof of Identity for second Owner/Director");
		updateMC.updateRep1DetailsWithOutAndWithSupportingDocs(data.get("reponefullname"), data.get("reponeemail"),data.get("reponemobileno"),rep1AuthorizationLetter,"* This field is required");
		updateMC.verifyAttachedDocsUnderDocumentSubmitted("Letter of Authorization for first Representative");
		updateMC.updateRep2DetailsWithOutAndWithSupportingDocs(data.get("reptwofullname"), data.get("reptwoemail"),data.get("reptwomobileno"),rep2AuthorizationLetter,"* This field is required");
		updateMC.verifyAttachedDocsUnderDocumentSubmitted("Letter of Authorization for second Representative");
		updateMC.selectDeclarationCheckBoxAndVerifySubmitButton();
		updateMC.ClickOnSubmitButtonAndVerifySuccessMessage("Medical center update is pending verification.\nFurther updates cannot be done until verification is complete");
		//To verify if editable
		updateMC.VerifyIfEditButtonsAreNotPresent();
		new CommonElements(driver).initElements().logout();
		
		/**Login as Bestinet operator and verify for status "Pending Update Verification" and verify all updated
		 * records in MC and Click on verify button
		 * 
		 */
		driver.get(configProp.getProperty("tcUser"));
		new LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getBestInetOperatorPassword());
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		approveMC.searchByAppIDAndVerifyForStatus(applicationID, "Pending Update Verification");
		approveMC.selectMCWithStatus("Pending Update Verification");
		approveMC.verifyMedicalCenterUpdatedDetails(data.get("medicalcentername"),regNo, data.get("medicalcenteraddress"));
		approveMC.clickOwnerDetailsTab();
		approveMC.verifyOwner1UpdatedDetails(data.get("Owner1FullName"),data.get("Owner1Designation"),data.get("Owner1Email"),data.get("Owner1mobilno"));
		approveMC.verifyOwner2UpdatedDetails(data.get("Owner2FullName"),data.get("Owner2Designation"),data.get("Owner2Email"),data.get("Owner2mobilno"));
		approveMC.clickRepresentativeDetailsTab();
		approveMC.verifyRepresentative1UpdatedDetails(data.get("reponefullname"), data.get("reponeemail"),data.get("reponemobileno"));
		approveMC.verifyRepresentative2UpdatedDetails(data.get("reptwofullname"), data.get("reptwoemail"),data.get("reptwomobileno"));
		approveMC.clickDoctorDetailsTab();
		approveMC.verifyUpdatedDoctor(data.get("fullname"));
		approveMC.clickDocumentsAttached();
		
		//verify all attached supporting documents
		approveMC.verifyMedicalCenterLogo();
		approveMC.verifySupportingDocumentsAttached("Registration Certificate");
		approveMC.verifySupportingDocumentsAttached("Proof of Identity for first Owner/Director");
		approveMC.verifySupportingDocumentsAttached("Proof of Identity for second Owner/Director");
		approveMC.verifySupportingDocumentsAttached("Letter of Authorization for first Representative");
		approveMC.verifySupportingDocumentsAttached("Letter of Authorization for second Representative");
		approveMC.clickReferToAdminTab();
		approveMC.sendMailForVerification(data.get("admin_email"));
		approveMC.clickVerifyButton("An email is sent to the Medical Center users with Update of Medical center details verified status.");
		approveMC.clickCloseButton();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		approveMC.searchByAppIDAndVerifyForStatus(applicationID, "Active");
		
	}
}
