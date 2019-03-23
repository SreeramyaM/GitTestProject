package org.fwcms.tc.operator;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.fwcms.tc.mcRegistrationPages.RegisterMedicalCenterPage;
import org.fwcms.tc.mcRegistrationPages.Representative2;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olo.initiator.BrowserInitiator;

/** MedCentre_Verify_35 : Confirm the functionality of the "Save" button.
 *  MedCentre_Verify_36 : Confirm the operator access to the previously saved application and complete the verification process.
 *  MedCentre_Verify_28*/



public class VerifyingRegisteredMCForPreviouslySavedApplicationTest extends BrowserInitiator {
private static final Logger logger = LogManager.getLogger(VerifyingRegisteredMCForPreviouslySavedApplicationTest.class.getName());
	
	@DataProvider(name="getMedicalCenterRegistration",parallel=false)
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(VerifyingRegisteredMCForPreviouslySavedApplicationTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getMedicalCenterRegistration",description="MedCentre_Reg_11, MedCentre_Reg_52")
	public void verifyingRegisteredMCForPreviouslySavedApplication(HashMap<String, String> data) throws Exception{
		String url = configProp.getProperty("mcRegistration")+data.get("mcRegistrationCountry");
		WebDriver driver = getDriver();
		openUrl(driver, url);
		logger.info("mc registration running for the url "+driver.getCurrentUrl());
		//Attachments
		String projectPath = System.getProperty("user.dir");
		String logoPath = projectPath+data.get("filePath");
		String doctorSignature = projectPath+data.get("doctor_signature");
		String doctorStamp = projectPath+data.get("doctor_stamp");
		String regCerDocument = projectPath+data.get("reg_cer_document");
		String proofOfIdentityDocument = projectPath+data.get("proof_of_identity_document");
		String medicalCenterStamp = projectPath+data.get("medical_center_stamp");
		String proofOfIdentitySecondOwner = projectPath+data.get("proof_of_identity_second_owner");
		String letterOfAuthSecond = projectPath+data.get("letter_of_auth_second");
		String letterOfAuthFirst = projectPath+data.get("letter_of_auth_first");
		
		RegisterMedicalCenterPage medicalCenterReg = new RegisterMedicalCenterPage(driver).initElements();
		medicalCenterReg.enterMedicalCenterDetails(data.get("medicalcentername"),data.get("registrationnumber"),data.get("medicalcenteraddressline1"),data.get("email"),data.get("fax"),data.get("weekdayfrom"),data.get("weekdayto"));
		medicalCenterReg.attachLogo(logoPath);
		
		medicalCenterReg.clickNext();
		medicalCenterReg.enterContactPersonOwnerDetails(data.get("owner_name1"), data.get("owner_designation1"), data.get("owner_email1"), data.get("owner_contact1"));
		medicalCenterReg.enterContactPersonOwner2Details(data.get("owner_name2"), data.get("owner_designation2"), data.get("owner_email2"), data.get("owner_contact2"));
		medicalCenterReg.enterContactPersonRepresentativeDetails(data.get("rep_name1"), data.get("rep_email1"), data.get("rep_contact1"));
		if(data.get("rep_name2")!=null){
			medicalCenterReg.enterContactPersonRepresentative2Details(data.get("rep_name2"), data.get("rep_email2"), data.get("rep_contact2"));
		}
		medicalCenterReg.clickNext();
		medicalCenterReg.clickSave();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertSavedMessage();
		String applicationId=medicalCenterReg.getApplicationId();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertApplicationIdInHeader(applicationId);
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"), doctorSignature, doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.assertDoctorSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertSavedDoctorInList(data.get("doctor_fullname"));
		medicalCenterReg.clickNext();
		medicalCenterReg.attachDocuments(regCerDocument, proofOfIdentityDocument, medicalCenterStamp, proofOfIdentitySecondOwner, letterOfAuthSecond, letterOfAuthFirst);
		medicalCenterReg.acceptDeclerationAndSubmit();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
	 
		medicalCenterReg.assertMedicalStatusIndicator(applicationId);
		medicalCenterReg.assertDetailsPostSubmit(applicationId, data.get("medicalcenteraddressline1"), data.get("email"));
		
		driver.get(configProp.getProperty("tcUser"));
		new LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getNewBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getNewBestInetOperatorPassword());
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage verifyMC  = new SearchMedicalCenterPage(driver).initElements();
		verifyMC.searchByNameAndStatus(data.get("medicalcentername"), "Pending Verification");
		new CommonElements(driver).initElements().waitForOverlayToHide();
		verifyMC.clickApplicationId();
		String applicationID=verifyMC.getApplicationIDDisplayText();
		verifyMC.verifyMedicalCenterDetails();
		verifyMC.clickOwnerDetailsTab();
		verifyMC.verifyOwnerDirectorDetails();
		verifyMC.clickRepresentativeDetailsTab();
		verifyMC.verifyRepresentativeDetails(Representative2.CHECKANDVERIFY);
		verifyMC.clickDoctorDetailsTab();
		verifyMC.verifyDoctorDetails();
		verifyMC.clickDocumentsAttached();
		verifyMC.clickReferToAdminTab();
		verifyMC.sendMailForVerification(data.get("admin_email"));
		verifyMC.saveVerificationDetails();
		verifyMC.verifySuccessMessage("Medical Center verification details saved successfully!");
		verifyMC.clickCloseButton();
		verifyMC.waitForOverlayToHide();
		
		verifyMC.searchByAppIDAndVerify(applicationID);
		verifyMC.clickApplicationId();
		
		verifyMC.verifyMedicalCenterSavedDetails();
		verifyMC.verifyOwenerDirectorSavedDetails();
		verifyMC.representativeSavedDetails();
		verifyMC.verifyDoctorSavedDetails();
		verifyMC.clickVerifyButton("An email is sent to the Medical Center users with Pending Payment status.");
		verifyMC.clickCloseButton();
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar("No results found!");
		verifyMC.uncheckAllStatusOperator();
		verifyMC.ClickHeader();
		
		verifyMC.searchByAppIDAndVerifyForStatus(applicationID, "Pending Payment");
	}
}