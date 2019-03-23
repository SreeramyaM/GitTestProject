package org.fwcms.tc.representative;

import java.io.FileReader;

import org.fwcms.initiators.TCInitiator;
import org.fwcms.pages.CommonElements;
import org.fwcms.pages.tc.LoginPage;
import org.fwcms.pages.tc.OperatorDetailsPage;
import org.fwcms.pages.tc.RepresentativeHomePage;
import org.fwcms.testdata.tc.AddEditDeleteOperatorAsRepresentative;
import org.fwcms.util.MCRepresentativeCredentialsProp;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when MC Representative adds, edits, deletes a MC Operator
 */
public class CrudOperationsOnOperatorTest extends TCInitiator{
	
	@DataProvider(name="addEditDeleteOperatorAsRepresentative")
	public Object[][] addEditDeleteOperatorAsRepresentativeData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(CrudOperationsOnOperatorTest.class.getResource("/org/fwcms/tc/representative/addEditDeleteOperatorAsRepresentative.json").getFile()));
		org.json.JSONArray jaa = new org.json.JSONArray(ja.toJSONString());
		Object[][] result = new Object[jaa.length()][1];
		for(int i=0;i<jaa.length();i++){
			result[i][0] = new AddEditDeleteOperatorAsRepresentative(jaa.getJSONObject(i));
		}
		return result;
	}
	
	@Test(dataProvider="addEditDeleteOperatorAsRepresentative",description="Add_MCOperator_01, Remove_MCOperator_01 , Add_MCOperator_02, Remove_MCOperator_03, Add_MCOperator_03, Remove_MCOperator_04, Add_MCOperator_05, Remove_MCOperator_05, Add_MCOperator_06, Add_MCOperator_07, Add_MCOperator_08, Add_MCOperator_09, Add_MCOperator_10, Add_MCOperator_11, Add_MCOperator_12, Add_MCOperator_04, Operator_ChngPwd_03, Remove_MCOperator_13, Remove_MCOperator_06, Remove_MCOperator_07, Remove_MCOperator_08, Remove_MCOperator_09")
	public void addEditDeleteOperatorAsRepresentative(AddEditDeleteOperatorAsRepresentative data) throws Exception{
		WebDriver driver = getDriver();
		/**
		 * Add_MCOperator_01,Remove_MCOperator_01
		 */
		LoginPage lp = new LoginPage(driver).initElements();
		lp.loginToTC(MCRepresentativeCredentialsProp.getChangePasswordMcRepresentativeUserName(), MCRepresentativeCredentialsProp.getChangePasswordMcRepresentativePassword());
		RepresentativeHomePage rhp = new RepresentativeHomePage(driver).initElements();
		rhp.assertSignOutVisible();
		/**
		 * Add_MCOperator_02,Remove_MCOperator_03
		 */
		rhp.clickAddEditDeleteOperatorLink();
		OperatorDetailsPage odp = new OperatorDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		odp.verifyPageHeading();
		/**
		 * Add_MCOperator_03,Remove_MCOperator_04
		 */
		odp.verifyElementsPresentInOeratorDetailsPage();
		/**
		 * Add_MCOperator_05,Remove_MCOperator_05
		 */
		odp.clickAddOperatorAndVerifyAddOperatorPopUpVisible();
		/**
		 * Add_MCOperator_06
		 */
		odp.verifyElementsInAddOperatorPopup();
		/**
		 * verifying cancel button functionality
		 */
		odp.verifyCancelButtonInAddOperator();
		/**
		 * Add_MCOperator_07
		 * Add_MCOperator_08
		 * Add_MCOperator_09
		 * Add_MCOperator_10
		 */
		odp.clickAddOperatorAndVerifyAddOperatorPopUpVisible();
		
		/**
		 * Add_MCOperator_11
		 * Add_MCOperator_12
		 * Add_MCOperator_04
		 */
		odp.enterDetailsOfOperator(data.getFullName(), data.getEmail(), data.getMobileNumber());
		odp.clickAddButtonAndVerifyMessage();
		odp.searchCreatedUserAndVerifyActionButtons();
		/**
		 * Operator_ChngPwd_03
		 */
		odp.clickChangePasswordAndVerifyMessage();
		/**
		 * Modifying operator
		 * Remove_MCOperator_13
		 */
		odp.searchCreatedUser();
		odp.clickEditIconAndVerifyModifyOperatorPopupVisible();
		odp.validateCancelButtonInModifyOperatorPopup();
		odp.clickEditIconAndVerifyModifyOperatorPopupVisible();
		odp.verifyElementsInEditOperatorPopup();
		odp.validateCancelButtonInModifyOperatorPopup();
		odp.clickEditIconAndVerifyValuesPopulatedInModifyOperatorPopup();
		//odp.validateReasonInEditModel(data.getInvalidReasons());
		odp.enterReasonAndClickModifyOperator(data.getReason());
		odp.verifyMessageForModifyOperatorPopup();
		/**
		 * Deleting Operator
		 * Remove_MCOperator_06
		 * Remove_MCOperator_07
		 * Remove_MCOperator_08
		 * Remove_MCOperator_09
		 * 
		 */
		odp.searchCreatedUser();
		odp.clickDeleteIconAndVerifyDeleteOperatorPopupVisible();
		odp.validateCancelButtonInDeleteOperatorPopup();
		odp.clickDeleteIconAndVerifyDeleteOperatorPopupVisible();
		odp.verifyElementsInDeleteOperatorPopup();
		odp.validateCancelButtonInDeleteOperatorPopup();
		odp.clickDeleteIconAndVerifyValuesPopulatedInDeleteOperatorPopup();
		//odp.validateReasonInDeleteModel(data.getInvalidReasons());
		odp.enterReasonAndClickDeleteOperator(data.getReason());
		odp.verifyDeleteConfirmationMessage();
		odp.verifycancelButtonInConfirmationPopup();
		odp.clickDeleteIconAndVerifyDeleteOperatorPopupVisible();
		odp.enterReasonAndClickDeleteOperator(data.getReason());
		odp.clickOkInDeleteConfirmation();
		odp.verifyMessageForDeleteOperatorPopup();
		odp.searchDeletedOperatorAndVerifyOperatorIsInActive();
	}
	
}
