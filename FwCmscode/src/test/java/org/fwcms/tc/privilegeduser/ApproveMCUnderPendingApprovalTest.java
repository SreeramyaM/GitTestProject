package org.fwcms.tc.privilegeduser;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.LogoutPage;
import org.fwcms.pages.tc.MakePaymentPage;
import org.fwcms.pages.tc.SearchMedicalCenterPage;
import org.fwcms.tc.mcRegistrationPages.RegisterMedicalCenterPage;
import org.fwcms.tc.mcRegistrationPages.Representative2;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olo.initiator.BrowserInitiator;

/**MedCentre_Verify_22 : Check for the Approve button feature
 * MedCentre_Verify_15 : Confirm the flow of navigating to the setting credit limit process.
 * MedCentre_Verify_23 : Verify the success message for Approval*/

public class ApproveMCUnderPendingApprovalTest extends BrowserInitiator {
	
	private static final Logger logger = LogManager.getLogger(ApproveMCUnderPendingApprovalTest.class.getName());
	
	@DataProvider(name="getMedicalCenterRegistration",parallel=false)
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(ApproveMCUnderPendingApprovalTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getMedicalCenterRegistration",description="Demo")
	public void approveMCUnderPendingApprovalByPrivilegedUser(HashMap<String, String> data) throws Exception{
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
		
		//Medical Center Details Tab
		RegisterMedicalCenterPage medicalCenterReg = new RegisterMedicalCenterPage(driver).initElements();
		medicalCenterReg.enterMedicalCenterDetails(data.get("medicalcentername"),data.get("registrationnumber"),data.get("medicalcenteraddressline1"),data.get("email"),data.get("fax"),data.get("weekdayfrom"),data.get("weekdayto"));
		medicalCenterReg.attachLogo(logoPath);
		medicalCenterReg.clickNext();
		
		//Contact Person Details Tab
		medicalCenterReg.enterContactPersonOwnerDetails(data.get("owner_name1"), data.get("owner_designation1"), data.get("owner_email1"), data.get("owner_contact1"));
		medicalCenterReg.enterContactPersonOwner2Details(data.get("owner_name2"), data.get("owner_designation2"), data.get("owner_email2"), data.get("owner_contact2"));
		medicalCenterReg.enterContactPersonRepresentativeDetails(data.get("rep_name1"), data.get("rep_email1"), data.get("rep_contact1"));
		boolean hasRep2 = false;
		if(data.get("rep_name2")!=null){
			hasRep2=true;
			medicalCenterReg.enterContactPersonRepresentative2Details(data.get("rep_name2"), data.get("rep_email2"), data.get("rep_contact2"));
		}
		medicalCenterReg.clickNext();
		medicalCenterReg.clickSave();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertSavedMessage();
		String applicationId=medicalCenterReg.getApplicationId();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertApplicationIdInHeader(applicationId);
		
		//Doctor Details Tab
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"), doctorSignature, doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.assertDoctorSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertSavedDoctorInList(data.get("doctor_fullname"));
		medicalCenterReg.clickNext();
		
		//Attach Documents Tab
		medicalCenterReg.attachDocuments(regCerDocument, proofOfIdentityDocument, medicalCenterStamp, proofOfIdentitySecondOwner, letterOfAuthSecond, letterOfAuthFirst);
		medicalCenterReg.acceptDeclerationAndSubmit();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertMedicalStatusIndicator(applicationId);
		medicalCenterReg.assertDetailsPostSubmit(applicationId, data.get("medicalcenteraddressline1"), data.get("email"));
		
		//Verify the medical center as Bestinet Operator User 
		driver.get(configProp.getProperty("tcUser"));
		new LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getNewBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getNewBestInetOperatorPassword());
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		SearchMedicalCenterPage smcp  = new SearchMedicalCenterPage(driver).initElements();
		smcp.searchByAppIDAndVerify(applicationId);
		smcp.clickApplicationId();
		smcp.verifyMedicalCenterDetails();
		smcp.clickOwnerDetailsTab();
		smcp.verifyOwnerDirectorDetails();
		smcp.clickRepresentativeDetailsTab();
		if(hasRep2){
			smcp.verifyRepresentativeDetails(Representative2.YES);
		}else{
			smcp.verifyRepresentativeDetails(Representative2.NO);
		}
		
		smcp.clickDoctorDetailsTab();
		smcp.verifyDoctorDetails();
		smcp.clickDocumentsAttached();
		smcp.clickReferToAdminTab();
		smcp.sendMailForVerification(data.get("admin_email"));
		smcp.clickVerifyButton("An email is sent to the Medical Center users with Pending Payment status.");
		smcp.clickCloseButton();
		smcp.waitForOverlayToHide();
		smcp.searchByAppIDAndVerifyForStatus(applicationId, "Pending Payment");
		
		smcp.clickApplicationId();
		MakePaymentPage MakePayment = new MakePaymentPage(driver).initElements();
		MakePayment.clickTransactionDetailsButton();
		MakePayment.verifyTransactionDetailsPopUp();
		String pendingAmount=MakePayment.getPendingAmount();
		MakePayment.verifyMakePaymentAndPaymentHistoryuButton();
		MakePayment.clickMakePaymentButton();
		MakePayment.verifyBankDraftAndOnlineTransferTab();
		MakePayment.payAmountThroughBankDraft(pendingAmount,"aaas","abc Bank","xyz","Testing");
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Transaction captured successfully");
		MakePayment.verifyPendingAmountPostPaymentIsZero();
		MakePayment.clickClosePay();
		smcp.closeStatusMessageBar();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		new HomePage(driver).initElements().clickSignOutLink();
		new LogoutPage(driver).initElements().clickBackToLogin();
		new LogoutPage(driver).initElements().navigateToLoginPage();
		
		//Approve the medical center as Bestinet Privileged User
		new LoginPage(driver).initElements().loginToTC(BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserPassword());
		new HomePage(driver).initElements().clickSearchMedicalCenterOption();
		smcp.searchByAppIDAndVerifyForStatus(applicationId, "Pending Approval");
		smcp.clickApplicationId();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		smcp.setCreditLimit("100");
		smcp.clickApproveButton();
		smcp.verifySuccessMessage("Medical center is approved & registration limit is set successfully");
	}
}