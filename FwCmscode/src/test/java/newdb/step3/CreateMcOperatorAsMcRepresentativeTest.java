package newdb.step3;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.OperatorDetailsPage;
import org.fwcms.pages.tc.RepresentativeHomePage;
import org.fwcms.util.MCRepresentativeCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *Confirm the system behavior when a MC Representative creates a MC Operator
 */
public class CreateMcOperatorAsMcRepresentativeTest extends TCInitiator{
	
	@DataProvider(name="addMCOperatorAsMCRepresentative")
	public Object[][] addEditDeleteOperatorAsRepresentativeData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(CreateMcOperatorAsMcRepresentativeTest.class.getResource("/newdb/createMcOperator.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="addMCOperatorAsMCRepresentative")
	public void addOperatorAsRepresentative(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToTC(MCRepresentativeCredentialsProp.getNewMcRepresentativeUserName(), MCRepresentativeCredentialsProp.getNewMcRepresentativePassword());
		RepresentativeHomePage rhp = new RepresentativeHomePage(driver).initElements();
		rhp.assertSignOutVisible();
		rhp.clickAddEditDeleteOperatorLink();
		
		OperatorDetailsPage odp = new OperatorDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		
		odp.verifyElementsPresentInOeratorDetailsPage();
		odp.clickAddOperatorAndVerifyAddOperatorPopUpVisible();
		odp.enterDetailsOfOperatorWithExactName(data.get("fullNameData"), data.get("emailData"), data.get("contactNumberData"));
		odp.clickAddButtonAndVerifyMessage();
	}
	
}
