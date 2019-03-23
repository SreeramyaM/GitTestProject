package org.fwcms.cdc.superuser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.initiators.CDCInitiator;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.MetaDataConfigurationPage;
import org.fwcms.util.BestinetSuperUserCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a super user adds, edits, deletes meta data
 */
public class MetaDataConfigurationTest extends CDCInitiator{
	
	@DataProvider(name="metaDataConfiguration")
	public Object[][] metaDataConfigurationData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(MetaDataConfigurationTest.class.getResource("/org/fwcms/cdc/superuser/metaDataConfiguration.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	@Test(dataProvider="metaDataConfiguration")
	public void metaDataConfiguration(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		
		new LoginPage(driver).initElements().loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		HomePage hp = new HomePage(driver).initElements();
		 
		hp.clickMetaDataConfigurationLink();
		
		MetaDataConfigurationPage mdcp = new MetaDataConfigurationPage(driver).initElements();
		mdcp.verifyElementPresentAndDefaultSelectedOnFirstVisitToThisPage();
		mdcp.verifySelectOptionsVisibleAndInvisibleOnclickOfSelectWidget();
		mdcp.addMetaDataConfiguration(data.get("metaDataType"), data.get("value"), data.get("description"));
		mdcp.clickShowAllInOptions();
		mdcp.searchByShowAllAndVerifyCreatedMetaDataInList();
		mdcp.searchByMetaDataTypeAndVerifyCreatedMetaDataInList(data.get("metaDataType"));
		mdcp.clickEditIconFirstVisibleMetaDataInList();
		mdcp.verifyEditMetaDataModelElements();
		mdcp.verifyingValuesInEditMetaDataModelAfterCreatingNewMetaData(data.get("metaDataType"), data.get("description"));
		mdcp.verifyingCancelButtonInEditPopup();
		mdcp.clickEditIconFirstVisibleMetaDataInList();
		mdcp.editDescriptionInEditPopupAndVerifyEditedDescription();
		mdcp.clickEditIconFirstVisibleMetaDataInList();
		mdcp.editValueInEditPopupAndVerifyEditedValue();
		mdcp.clickEditIconFirstVisibleMetaDataInList();
		mdcp.editValueAndDescriptionInEditPopupAndVerifyEditedValues();
		mdcp.searchByShowAllAndVerifyCreatedMetaDataInList();
		mdcp.clickDeleteIconFirstVisibleMetaDataInList();
		mdcp.verifyDeleteConfirmationPresent();
		mdcp.verifyingNoButtonInDeleteConfirmation();
		mdcp.clickDeleteIconFirstVisibleMetaDataInList();
		mdcp.verifyingYesButtonInDeleteConfirmation();
	}
	
}
