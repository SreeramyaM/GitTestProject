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

/**Validate the duplicate check on  "Doctor Name" and the "Professional id" fields.*/

public class MedicalCenterValidateDuplicateCheckOnDocterNameAndIDTest extends BrowserInitiator {

	@DataProvider(name="getMedicalCenterValidateDuplicateCheckOnDocterNameAndIDTest")
	public Object[][] returnMedicalCenterRegistration() throws Exception{
		
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MedicalCenterValidateDuplicateCheckOnDocterNameAndIDTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="getMedicalCenterValidateDuplicateCheckOnDocterNameAndIDTest",description="MedCentre_Reg_28")
	public void medicalCenterValidateDuplicateCheckOnDocterNameAndID(HashMap<String, String> data) throws Exception{
		//Attachments
		WebDriver driver = getDriver();
		String projectPath = System.getProperty("user.dir");
		String logoPath = projectPath+data.get("filePath");
		String doctorSignature = projectPath+data.get("doctor_signature");
		String doctorStamp = projectPath+data.get("doctor_stamp");
		
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
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"),doctorSignature,doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.assertDoctorSavedMessage();
		medicalCenterReg.closeStatusMessageBar();
		medicalCenterReg.enterDoctorDetails(data.get("doctor_fullname"), data.get("doctor_professionalid"), data.get("doctor_qualification"), data.get("doctor_address"),doctorSignature,doctorStamp);
		medicalCenterReg.saveDoctorDetails();
		medicalCenterReg.AssertDuplicationErrorForDoctorProfID("Professional Id already exist. Please enter unique professional id.");
	}
}
