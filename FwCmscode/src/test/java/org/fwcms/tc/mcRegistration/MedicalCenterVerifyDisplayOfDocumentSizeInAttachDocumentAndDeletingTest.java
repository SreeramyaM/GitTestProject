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

/**Verify the contents of the Attach document tab once saved
 * Confirm the functionality of the "Delete" option. */

public class MedicalCenterVerifyDisplayOfDocumentSizeInAttachDocumentAndDeletingTest extends BrowserInitiator{
		
		@DataProvider(name="getMedicalCenterVerifyDisplayOfDocumentSizeInAttachDocumentTest")
		public Object[][] returnMedicalCenterRegistration() throws Exception{
			
			JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MedicalCenterVerifyDisplayOfDocumentSizeInAttachDocumentAndDeletingTest.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
			Object[][] result = new Object[ja.size()][1];
			for(int i=0;i<ja.size();i++){
				result[i][0] = ja.get(i);
			}
			return result;
		}
		
		@Test(dataProvider="getMedicalCenterVerifyDisplayOfDocumentSizeInAttachDocumentTest",description="MedCentre_Reg_46, MedCentre_Reg_42")
		public void medicalCenterVerifyDisplayOfDocumentSizeInAttachDocumentAndDeleting(HashMap<String, String> data) throws Exception{
			WebDriver driver = getDriver();
			//Attachment
			String projectPath = System.getProperty("user.dir");
			String regCerDocument = projectPath+data.get("reg_cer_document");
			String proofOfIdentityDocument = projectPath+data.get("proof_of_identity_document");
			String medicalCenterStamp = projectPath+data.get("medical_center_stamp");
			String proofOfIdentitySecondOwner = projectPath+data.get("proof_of_identity_second_owner");
			String letterOfAuthSecond = projectPath+data.get("letter_of_auth_second");
			String letterOfAuthFirst = projectPath+data.get("letter_of_auth_first");
			
			driver.get(configProp.getProperty("mcRegistration")+data.get("mcRegistrationCountry"));
			RegisterMedicalCenterPage medicalCenterReg = new RegisterMedicalCenterPage(driver).initElements();
			medicalCenterReg.clickAttachDocumentTab();
			medicalCenterReg.attachDocuments(regCerDocument, proofOfIdentityDocument, medicalCenterStamp, proofOfIdentitySecondOwner, letterOfAuthSecond, letterOfAuthFirst);
			//Verify display of document size for the uploaded document
			medicalCenterReg.VerifyDocumentSizeDisplayed(1);
			medicalCenterReg.VerifyDocumentSizeDisplayed(2);
			medicalCenterReg.VerifyDocumentSizeDisplayed(3);
			medicalCenterReg.VerifyDocumentSizeDisplayed(4);
			medicalCenterReg.VerifyDocumentSizeDisplayed(5);
			medicalCenterReg.VerifyDocumentSizeDisplayed(6);
			//Deleting the uploaded documents
			medicalCenterReg.deleteDocumentWRTOptionAndAssert("Registration Certificate");
			medicalCenterReg.deleteDocumentWRTOptionAndAssert("Letter of Authorization for first Representative");
		}
		
}
