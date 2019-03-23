package newdb.step2;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.GmailInitiator;
import org.fwcms.util.MCRepresentativeCredentialsProp;
import org.google.mail.GmailEmailPage;
import org.google.mail.GmailInboxPage;
import org.google.mail.GmailLoginPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *This test method retrieves the user name and password of the newly created medical center representative from gmail
 *Sets the retrieved user name and password in mcrepresentativecredentials.properties file
 */
public class RetrieveMedicalCenterRepresentativeUserNamePasswordFromGmail extends GmailInitiator {
	
	@DataProvider(name="medicalCenterRepUserCredentials")
	public Object[][] getMedicalCenterRepUserCredentials() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(RetrieveMedicalCenterRepresentativeUserNamePasswordFromGmail.class.getResource("/org/fwcms/tc/mcRegistration/MedicalCenterRegistration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="medicalCenterRepUserCredentials")
	public void retriveMCRepUserNamePassword(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new GmailLoginPage(driver).initElements().loginToGmail(data.get("rep_email1"),data.get("rep_email1_password"));
		new GmailInboxPage(driver).initElements().clickOnOMedicalCenterRepCredentialsEmail();
		GmailEmailPage gep=new GmailEmailPage(driver).initElements();
		String userName=gep.retrieveNewUserUserName();
		String password=gep.retrieveNewUserPassword();
		gep.deleteEmail();
		MCRepresentativeCredentialsProp.setnewMCRepUserName(userName);
		MCRepresentativeCredentialsProp.setnewMCRepPassword(password);
	}
}
