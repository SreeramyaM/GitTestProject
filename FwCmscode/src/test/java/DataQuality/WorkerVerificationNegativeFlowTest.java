package DataQuality;

import static com.olo.util.PropertyReader.configProp;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.HomePage;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.PassportDetailsForVerifierPage;
import org.fwcms.pages.tc.PassportDetailsPage;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkerVerificationNegativeFlowTest extends TCInitiator {
	
	@DataProvider(name="passportDetailsForWorkerVerification")
	public Object[][] passportDetailsForWorkerVerification() throws Exception {
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(WorkerVerificationNegativeFlowTest.class.getResource("/org/fwcms/tc/operator/passportDetailsForWorkerVerification.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	
	@Test(dataProvider="passportDetailsForWorkerVerification")
	public void verifyDataQualityNegativeFlow(HashMap<String, String> data) throws Exception {
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getNewBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getNewBestInetOperatorPassword());
		new HomePage(driver).initElements().clickWorkerVerificationApprovalMenu();
		PassportDetailsPage pdp=new PassportDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		String registrationId=pdp.selectWorkerForVerification();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		String passportNo=data.get("passportNumber")+new Random().nextInt((1000-1)+1);
		pdp.enterPassportDetails(data.get("fullName"), data.get("dateOfBirth"), passportNo, data.get("passportIssuedDate"), data.get("passportExpiryDate"));
		pdp.verifyWorkerPassportDetails();
		pdp.verifySuccessMessage("Passport details captured successfully!");
		pdp.clickSignOutLink();
		
		driver.manage().deleteAllCookies();
		driver.get(configProp.getProperty("tcUser"));
		new LoginPage(driver).initElements().loginToTC(BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getNewBestInetPrivilegedUserPassword());
		new HomePage(driver).initElements().clickWorkerVerificationApprovalMenu();
		PassportDetailsForVerifierPage pdfvp=new PassportDetailsForVerifierPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		pdfvp.selectWorkerForVerification(registrationId);
		new CommonElements(driver).initElements().waitForOverlayToHide();
		pdfvp.selectWorkerPassportDetails();
		pdfvp.verifyWorkerPassportDetails();
		pdfvp.verifySuccessMessage("Worker Details Captured Succesfully!");
		pdfvp.clickSignOutLink();
	}

}
