package org.fwcms.cdc.privilegeduser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetOperatorUsersDetailsPageProp;
import org.fwcms.util.BestinetPrivilegedUserCredentialsProp;
import org.fwcms.initiators.CDCInitiator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a privileged user adds, edits, deletes an operator user
 */
public class CrudOperationsTest extends CDCInitiator{
	
	@DataProvider(name="addEditDeleteOperatorUserAsPrivilegedUser")
	public Object[][] addEditDeleteOperatorUserAsPrivilegedUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(CrudOperationsTest.class.getResource("/org/fwcms/cdc/privilegeduser/addEditDeleteOperatorUserAsPrivilegedUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	//Test method to add update delete operator as privileged user
	@Test(dataProvider="addEditDeleteOperatorUserAsPrivilegedUser",description="Bestinet_Operator_AddUpdt_22, Bestinet_Operator_AddUpdt_23, Bestinet_Operator_AddUpdt_08, Bestinet_Operator_AddUpdt_09, Bestinet_Operator_AddUpdt_10, Bestinet_Operator_AddUpdt_11, Bestinet_Operator_AddUpdt_12, Bestinet_Operator_AddUpdt_13, Bestinet_Operator_AddUpdt_14, Bestinet_Operator_AddUpdt_16, BES_operator_Delete_08")
	public void addEditDeleteOperatorUserAsPrivilegedUser(HashMap<String, String> data) throws Exception{
		//Adding an operator user
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserUserName(), BestinetPrivilegedUserCredentialsProp.getBestInetPrivilegedUserPassword());
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.clickAddUserLink();
		ud.verifyCancelButtonInAddUser();
		ud.clickAddUserLink();
		ud.verifyAddUserModelHeader(BestInetOperatorUsersDetailsPageProp.getaddModelHeader());
		ud.createUser(data.get("fullName"), data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetOperatorUsersDetailsPageProp.getaddSuccess());
		
		//Editing an operator user
		ud.searchByCreatedUserAndVerifyUserInList();
		ud.clickEditIconFirstVisibleUserInList();
		ud.verifyEditUserModelHeader(BestInetOperatorUsersDetailsPageProp.geteditModelHeader());
		ud.checkAdditionalRoleOption(false);
		String newAddress = ud.editUserDetails(data.get("editReason"), BestInetOperatorUsersDetailsPageProp.geteditSuccess());
		ud.searchByCreatedUser();
		ud.clickEditIconFirstVisibleUserInList();
		ud.assertNewAddressInEditedUser(newAddress);
		ud.verifyCancelButtonInEditUserModel();
		
		//Deleting an operator user
		ud.clickDeleteIconFirstVisibleUserInList();
		ud.verifyCancelButtonInDeleteUserModel();
		ud.clickDeleteIconFirstVisibleUserInList();
		ud.verifyDeleteUserModelHeader(BestInetOperatorUsersDetailsPageProp.getdeleteModelHeader());
		ud.enterReasonForDelete(data.get("deleteReason"));
		ud.clickDeleteButtonInUserModel();
		ud.verifyCancelButtonInDeleteConfirmation();
		ud.clickDeleteIconFirstVisibleUserInList();
		ud.deleteUser(BestInetOperatorUsersDetailsPageProp.getdeleteConfirmation(), BestInetOperatorUsersDetailsPageProp.getdeleteSuccess());
		ud.searchByCreatedUser();
		ud.assertDeleteStatusForFirstSearchedUserInList(data.get("accountDeleteTitle"));
	}
	
}
