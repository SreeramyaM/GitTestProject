package org.fwcms.tc.mcRegistration;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.tc.mcRegistrationPages.RegisterMedicalCenterPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olo.initiator.BrowserInitiator;

/**MedCentre_Reg_08,MedCentre_Reg_30, MedCentre_Reg_63 	: Confirm the functionality of the "Upload" button.*/

public class MedicalCenterUploadButtonFunctionalityTest extends BrowserInitiator{
	
	@DataProvider(name="getMedicalCenterUploadButtonFunctionalityTest")
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MedicalCenterUploadButtonFunctionalityTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getMedicalCenterUploadButtonFunctionalityTest",description="MedCentre_Reg_08,MedCentre_Reg_37,MedCentre_Reg_30")
	public void MedicalCenterUploadButtonFunctionality(HashMap<String, String> data) throws Exception{
		//Attachments
		WebDriver driver = getDriver();
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
		medicalCenterReg.clickNext();
		medicalCenterReg.clickSave();
		
		medicalCenterReg.verifyConfirmPopupCaptchaAndBreakCaptche();
		medicalCenterReg.assertSavedMessage();
		String application_id=medicalCenterReg.getApplicationId();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertApplicationIdInHeader(application_id);
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"), doctorSignature, doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.assertDoctorSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.assertSavedDoctorInList(data.get("doctor_fullname"));
		medicalCenterReg.selectDocterInList(data.get("doctor_fullname"));
		//Verify doctor documents and stamp
		medicalCenterReg.VerifyDoctorSignatureAndStamp();
		medicalCenterReg.clickNext();
		//Verify the list of documents under the "Document details" column.
		medicalCenterReg.verifyDocumentListRequired("Registration Certificate",
				"Proof of Identity for first Owner/Director","Medical Center Stamp",
				"Proof of Identity for second Owner/Director","Letter of Authorization for second Representative",
				"Letter of Authorization for first Representative");
		//Attach documents
		medicalCenterReg.attachDocuments(regCerDocument, proofOfIdentityDocument,
				medicalCenterStamp, proofOfIdentitySecondOwner, letterOfAuthSecond, letterOfAuthFirst);
		//Verifying attach documents
		medicalCenterReg.verifyAttachedDocs("Registration Certificate ( RegistrationCertificate.pdf )");
		medicalCenterReg.verifyAttachedDocs("Medical Center Stamp ( logo.jpg )");
		medicalCenterReg.verifyAttachedDocs("Proof of Identity for first Owner/Director ( ProofOfIdentity.pdf )");
		medicalCenterReg.verifyAttachedDocs("Proof of Identity for second Owner/Director ( ProofOfIdentityDirector.pdf )");
		medicalCenterReg.verifyAttachedDocs("Letter of Authorization for second Representative ( LetterOfAuthFirstRep.pdf )");
		medicalCenterReg.verifyAttachedDocs("Letter of Authorization for first Representative ( LetterOfAuthFirstRep.pdf )");
	}
}
