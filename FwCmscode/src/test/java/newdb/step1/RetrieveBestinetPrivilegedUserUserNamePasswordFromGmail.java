package newdb.step1;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.GmailInitiator;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.google.mail.GmailEmailPage;
import org.google.mail.GmailInboxPage;
import org.google.mail.GmailLoginPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test method retrieves the user name and password of the newly created privileged user from gmail
 * Sets the retrieved user name and password in bestinetprivilegedusercredentials.properties file
 */
public class RetrieveBestinetPrivilegedUserUserNamePasswordFromGmail extends GmailInitiator {
	
	@DataProvider(name="createdPrivilegedUserAsSuperUser")
	public Object[][] addEditDeletePrivilegedUserAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(RetrieveBestinetPrivilegedUserUserNamePasswordFromGmail.class.getResource("/newdb/createPrivilegedUsers.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}

	@Test(dataProvider="createdPrivilegedUserAsSuperUser")
	public void retrivePrivilegedUserUserNamePassword(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new GmailLoginPage(driver).initElements().loginToGmail(data.get("emailId"),data.get("gmailPassword"));
		new GmailInboxPage(driver).initElements().clickOnPrivilegedUserCreatedEmail();
		GmailEmailPage gep=new GmailEmailPage(driver).initElements();
		String userName=gep.retrieveNewUserUserName();
		String password=gep.retrieveNewUserPassword();
		gep.deleteEmail();
		BestinetPrivilegedUserCredentialsProp.setBestInetPrivilegedUserUserName(userName);
		BestinetPrivilegedUserCredentialsProp.setnewBestInetPrivilegedUserUserName(userName);
		BestinetPrivilegedUserCredentialsProp.setBestInetPrivilegedUserPassword(password);
		BestinetPrivilegedUserCredentialsProp.setnewBestInetPrivilegedUserPassword(password);
	}
}
