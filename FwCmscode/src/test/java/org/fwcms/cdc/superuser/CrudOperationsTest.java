package org.fwcms.cdc.superuser;

import java.io.FileReader;
import java.util.HashMap;

import org.fwcms.pages.CommonElements;
import org.fwcms.pages.cdc.HomePage;
import org.fwcms.pages.cdc.LoginPage;
import org.fwcms.pages.cdc.UserDetailsPage;
import org.fwcms.prop.cdc.BestInetPrivilegedUsersDetailsPageProp;
import org.fwcms.util.BestinetSuperUserCredentialsProp;
import org.fwcms.initiators.CDCInitiator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Confirm the system behavior when a super user adds, edits, deletes a privileged user
 *
 */
public class CrudOperationsTest extends CDCInitiator{
	
	@DataProvider(name="addEditDeletePrivilegedUserAsSuperUser")
	public Object[][] addEditDeletePrivilegedUserAsSuperUserData() throws Exception{
		JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader(CrudOperationsTest.class.getResource("/org/fwcms/cdc/superuser/addEditDeletePrivilegedUserAsSuperUser.json").getFile()));
		Object[][] result = new Object[ja.size()][1];
		for(int i=0;i<ja.size();i++){
			result[i][0] = ja.get(i);
		}
		return result;
	}
	
	//Test method to add update delete privileged user as super user
	@Test(dataProvider="addEditDeletePrivilegedUserAsSuperUser",description="PrivUser_AddUpdt_17, PrivUser_AddUpdt_18, PrivUser_AddUpdt_07, PrivUser_AddUpdt_08, PrivUser_AddUpdt_09, PrivUser_AddUpdt_10, PrivUser_AddUpdt_11, PrivUser_AddUpdt_12, BES_Privilage_User_Delete_07")
	public void addEditDeletePrivilegedUserAsSuperUser(HashMap<String, String> data) throws Exception{
		WebDriver driver = getDriver();
		new LoginPage(driver).initElements().loginToCDC(BestinetSuperUserCredentialsProp.getBestInetSuperUserUserName(), BestinetSuperUserCredentialsProp.getBestInetSuperUserPassword());
		
		//Adding a privileged user
		new HomePage(driver).initElements().clickAddEditDeleteUsersLink();
		UserDetailsPage ud = new UserDetailsPage(driver).initElements();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		ud.clickAddUserLink();
		ud.verifyCancelButtonInAddUser();
		ud.clickAddUserLink();
		ud.verifyAddUserModelHeader(BestInetPrivilegedUsersDetailsPageProp.getaddModelHeader());
		ud.createUser(data.get("fullName") , data.get("emailId"), data.get("contactNumber"), data.get("address"), BestInetPrivilegedUsersDetailsPageProp.getaddSuccess());
		
		//Editing a privileged user
		ud.searchByCreatedUserAndVerifyUserInList();
		ud.clickEditIconFirstVisibleUserInList();
		ud.verifyEditUserModelHeader(BestInetPrivilegedUsersDetailsPageProp.geteditModelHeader());
		ud.checkAdditionalRoleOption(true);
		String newAddress = ud.editUserDetails(data.get("editReason"), BestInetPrivilegedUsersDetailsPageProp.geteditSuccess());
		ud.searchByCreatedUser();
		ud.clickEditIconFirstVisibleUserInList();
		ud.assertNewAddressInEditedUser(newAddress);
		ud.verifyCancelButtonInEditUserModel();
		
		//Deleting a privileged user
		ud.clickDeleteIconFirstVisibleUserInList();
		ud.verifyCancelButtonInDeleteUserModel();
		ud.clickDeleteIconFirstVisibleUserInList();
		ud.verifyDeleteUserModelHeader(BestInetPrivilegedUsersDetailsPageProp.getdeleteModelHeader());
		ud.enterReasonForDelete(data.get("deleteReason"));
		ud.clickDeleteButtonInUserModel();
		ud.verifyCancelButtonInDeleteConfirmation();
		ud.clickDeleteIconFirstVisibleUserInList();
		ud.deleteUser(BestInetPrivilegedUsersDetailsPageProp.getdeleteConfirmation(), BestInetPrivilegedUsersDetailsPageProp.getdeleteSuccess());
		ud.searchByCreatedUser();
		ud.assertDeleteStatusForFirstSearchedUserInList(data.get("accountDeleteTitle"));
	}
	
}
