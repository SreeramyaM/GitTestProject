package org.fwcms.tc.mcRegistration;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.tc.mcRegistrationPages.RegisterMedicalCenterPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olo.initiator.BrowserInitiator;

/**Confirm the system behavior when partial details of second representative details is filled along with first\
 * Confirm the system behavior in case of only one representative details being filled.
 */

public class MedicalCenterPartialEntryof2ndRepresentativeDetailsTest extends BrowserInitiator{
	
	@DataProvider(name="getMedicalCenterPartialEntryof2ndRepresentativeDetailsTest")
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MedicalCenterPartialEntryof2ndRepresentativeDetailsTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}

	@Test(dataProvider="getMedicalCenterPartialEntryof2ndRepresentativeDetailsTest",description="MedCentre_Reg_19")
	public void MedicalCenterPartialEntryof2ndRepresentativeDetails(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
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
		
		driver.get(configProp.getProperty("mcRegistration")+data.get("mcRegistrationCountry"));
		RegisterMedicalCenterPage medicalCenterReg = new RegisterMedicalCenterPage(driver).initElements();
		medicalCenterReg.enterMedicalCenterDetails(data.get("medicalcentername"),data.get("registrationnumber"),data.get("medicalcenteraddressline1"),data.get("email"),data.get("fax"),data.get("weekdayfrom"),data.get("weekdayto"));
		medicalCenterReg.attachLogo(logoPath);
		medicalCenterReg.clickNext();
		medicalCenterReg.enterContactPersonOwnerDetails(data.get("owner_name1"), data.get("owner_designation1"), data.get("owner_email1"), data.get("owner_contact1"));
		medicalCenterReg.enterContactPersonOwner2Details(data.get("owner_name2"), data.get("owner_designation2"), data.get("owner_email2"), data.get("owner_contact2"));
		medicalCenterReg.enterContactPersonRepresentativeDetails(data.get("rep_name1"), data.get("rep_email1"), data.get("rep_contact1"));
		medicalCenterReg.enterContactPersonRepresentative2Name(data.get("rep_name2"));
		medicalCenterReg.clickNext();
		medicalCenterReg.clickSave();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertSavedMessage();
		String applicationId=medicalCenterReg.getApplicationId();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertApplicationIdInHeader(applicationId);
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"),doctorSignature, doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.assertDoctorSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertSavedDoctorInList(data.get("doctor_fullname"));
		medicalCenterReg.clickNext();
		medicalCenterReg.attachDocuments(regCerDocument, proofOfIdentityDocument, medicalCenterStamp, proofOfIdentitySecondOwner, letterOfAuthSecond, letterOfAuthFirst);
		medicalCenterReg.acceptDeclerationAndSubmit();
		WebElement representative2EmailDetails=medicalCenterReg.getRepresentative2EmailDetails();
		medicalCenterReg.verifyValidationDisplayed(representative2EmailDetails);
		WebElement representative2MobileNumber=medicalCenterReg.getRepresentative2MobileNumber();
		medicalCenterReg.verifyValidationDisplayed(representative2MobileNumber);
		//Confirm the system behavior in case of only one representative details being filled.
		medicalCenterReg.clearRepresentative2Name();
		medicalCenterReg.clickSave();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.clickNext();
		medicalCenterReg.clickNext();
		medicalCenterReg.acceptDeclerationAndSubmit();
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertMedicalStatusIndicator(applicationId);
	
	}
}
