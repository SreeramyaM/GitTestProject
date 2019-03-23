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

/**Verify the condition that both the owners details are mandatory and should have validation for email*/

public class MedicalCenterVerifyBothOwnerDetailsandValidEmailAddressTest  extends BrowserInitiator{
	
	@DataProvider(name="getMedicalCenterVerifyBothOwnerDetailsandValidEmailAddressTest")
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MedicalCenterVerifyBothOwnerDetailsandValidEmailAddressTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getMedicalCenterVerifyBothOwnerDetailsandValidEmailAddressTest",description="MedCentre_Reg_13")
	public void MedicalCenterVerifyBothOwnerDetailsandValidEmailAddress(HashMap<String, String> data) throws Exception{
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
		medicalCenterReg.enterContactPersonRepresentativeDetails(data.get("rep_name1"), data.get("rep_email1"), data.get("rep_contact1"));
		//Invalid email address
		medicalCenterReg.enterEmailAddressforOwner2("Auto.Tester");
		medicalCenterReg.clickSave1();
		WebElement owner2EmailValidation=medicalCenterReg.getOwner2EmailValidation();
		medicalCenterReg.verifyValidationMessage(owner2EmailValidation,"* Invalid email address");
		//Entering valid email address
		medicalCenterReg.enterEmailAddressforOwner2(data.get("owner_email2"));
		medicalCenterReg.clickSave();
		
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		String application_id=medicalCenterReg.getApplicationId();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.clickNext();
		medicalCenterReg.assertApplicationIdInHeader(application_id);
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"),doctorSignature, doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.assertDoctorSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertSavedDoctorInList(data.get("doctor_fullname"));
		medicalCenterReg.clickNext();
		medicalCenterReg.attachDocuments(regCerDocument, proofOfIdentityDocument, medicalCenterStamp, proofOfIdentitySecondOwner, letterOfAuthSecond, letterOfAuthFirst);
		medicalCenterReg.acceptDeclerationAndSubmit();
		
		
		//Submitting without enter owner2 details and validating
		WebElement owner2fullNameValidation=medicalCenterReg.getOwner2fullnameValidation();
		medicalCenterReg.verifyValidationDisplayed(owner2fullNameValidation);
		WebElement owner2DesignationValidation=medicalCenterReg.getOwner2DesignationValidation();
		medicalCenterReg.verifyValidationDisplayed(owner2DesignationValidation);
		
	}
	
}
