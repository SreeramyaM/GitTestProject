package newdb.step3;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.GmailInitiator;
import org.fwcms.util.MCOperatorCredentialsProp;
import org.google.mail.GmailEmailPage;
import org.google.mail.GmailInboxPage;
import org.google.mail.GmailLoginPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *This test method retrieves the user name and password of the newly created medical center operator from gmail
 *Sets the retrieved user name and password in mcoperatorcredentials.properties file
 */
public class RetrieveMedicalCenterOperatorUserNamePasswordFromGmail extends GmailInitiator {
	
	@DataProvider(name="medicalCenterOprUserCredentials")
	public Object[][] getMedicalCenterOprUserCredentials() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(RetrieveMedicalCenterOperatorUserNamePasswordFromGmail.class.getResource("/newdb/createMcOperator.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="medicalCenterOprUserCredentials")
	public void retriveMCOperatorUserNamePassword(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new GmailLoginPage(driver).initElements().loginToGmail(data.get("emailData"),data.get("gmailPassword"));
		new GmailInboxPage(driver).initElements().clickOnOMedicalCenterOprCreatedEmail();
		GmailEmailPage gep=new GmailEmailPage(driver).initElements();
		String userName=gep.retrieveNewUserUserName();
		String password=gep.retrieveNewUserPassword();
		gep.deleteEmail();
		MCOperatorCredentialsProp.setMCOperatorUserName(userName);
		MCOperatorCredentialsProp.setMCOperatorPassword(password);
	}
}
