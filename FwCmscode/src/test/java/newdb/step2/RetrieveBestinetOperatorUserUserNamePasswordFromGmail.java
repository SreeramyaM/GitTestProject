package newdb.step2;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.GmailInitiator;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.google.mail.GmailEmailPage;
import org.google.mail.GmailInboxPage;
import org.google.mail.GmailLoginPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *This test method retrieves the user name and password of the newly created operator user from gmail
 *Sets the retrieved user name and password in bestinetoperatorusercredentials.properties file
 */
public class RetrieveBestinetOperatorUserUserNamePasswordFromGmail extends GmailInitiator {
	
	@DataProvider(name="createOperatorUserAsPriviligedUser")
	public Object[][] addEditDeletePrivilegedUserAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(RetrieveBestinetOperatorUserUserNamePasswordFromGmail.class.getResource("/newdb/createBestInetOperatorUsers.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="createOperatorUserAsPriviligedUser")
	public void retriveOperatorUserUserNamePassword(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new GmailLoginPage(driver).initElements().loginToGmail(data.get("emailId"),data.get("gmailPassword"));
		new GmailInboxPage(driver).initElements().clickOnOperatorUserCreatedEmail();
		GmailEmailPage gep=new GmailEmailPage(driver).initElements();
		String userName=gep.retrieveNewUserUserName();
		String password=gep.retrieveNewUserPassword();
		gep.deleteEmail();
		BestinetOperatorUserCredentialsProp.setBestInetOperatorUserUserName(userName);
		BestinetOperatorUserCredentialsProp.setnewBestInetOperatorUserUserName(userName);
		BestinetOperatorUserCredentialsProp.setBestInetOperatorUserPassword(password);
		BestinetOperatorUserCredentialsProp.setnewBestInetOperatorUserPassword(password);
	}
}
