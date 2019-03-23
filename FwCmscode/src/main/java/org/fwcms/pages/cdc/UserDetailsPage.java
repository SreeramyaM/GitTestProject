package org.fwcms.pages.cdc;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserDetailsPage extends CommonElements{
	
	private static final Logger logger = LogManager.getLogger(UserDetailsPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public UserDetailsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public UserDetailsPage initElements()
	{
		return PageFactory.initElements(driver, UserDetailsPage.class);
	}
	
	@FindBy(className="pageHeading")
	private WebElement pageHeading;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(1)")
	private WebElement nameListHeader;
	 
	@FindBy(css="div[class='listHeader']>div:nth-child(2)")
	private WebElement emailListHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(3)")
	private WebElement contactNumberListHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(4)")
	private WebElement userNameListHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(5)")
	private WebElement actionsListHeader;
	
	@FindBy(id="custom_searchbyname")
	private WebElement searchByNameRadio;
	
	@FindBy(id="custom_searchbyemail")
	private WebElement searchByEmailRadio;
	
	@FindBy(id="custom_searchbyphone")
	private WebElement searchByContactRadio;
	
	@FindBy(id="operator_name_search")
	private WebElement nameSearchText;
	
	@FindBy(css="div[class^='operator_name_searchformError']>div[class='formErrorContent']")
	private WebElement nameSearchFormError;
	
	@FindBy(css="span[class='search_text search_operators']>a")
	private WebElement searchTextLink;
	
	@FindBy(css="a[id='add_tc_operator']>span")
	private WebElement addUserLink;
	
	@FindBy(id="tc_operators_count")
	private WebElement userCount;
	
	@FindBy(css="span[class='checkAll_icon refresh']")
	private WebElement refreshIcon;
	
	@FindBy(className="refresh_operators_text")
	private WebElement refreshText;
	
	@FindBy(css="div[class$='cell_operator_name']")
	private List<WebElement> nameList;
	
	@FindBy(css="div[class$='cell_operator_email']")
	private List<WebElement> emailList;
	
	@FindBy(css="div[class$='cell_operator_phone']")
	private List<WebElement> contactNumberList;
	
	@FindBy(css="div[class$='cell_operator_username']")
	private List<WebElement> userNameList;
	
	@FindBy(css="div[class='tc_actions']>a:nth-child(1)")
	private List<WebElement> actionsEditIconList;
	
	@FindBy(className="delete_op")
	private List<WebElement> actionsDeleteIconList;
	
	@FindBy(css="div[class$='cell_operator_status']")
	private List<WebElement> accountStatusList;
	
	@FindBy(css="form[id='tc_add_operator']>div>div:nth-child(1)>span")
	private WebElement addUserModelHeader;
	
	@FindBy(css="form[id='tc_modify']>div>div:nth-child(1)>span")
	private WebElement editUserModelHeader;
	
	@FindBy(css="form[id='tc_delete_form']>div>div:nth-child(1)>span")
	private WebElement deleteUserModelHeader;
	
	@FindBy(id="userFullName")
	private WebElement fullNameText;
	
	@FindBy(css="div[class^='userFullNameformError']>div[class='formErrorContent']")
	private WebElement fullNameFormError;
	
	@FindBy(id="email")
	private WebElement emailText;
	
	@FindBy(css="div[class^='emailformError']>div[class='formErrorContent']")
	private WebElement emailFormError;
	
	@FindBy(id="contactNo")
	private WebElement contactNumberText;
	
	@FindBy(css="div[class^='contactNoformError']>div[class='formErrorContent']")
	private WebElement contactNumberFormError;
	
	@FindBy(id="address")
	private WebElement addressText;
	
	@FindBy(css="div[class^='addressformError']>div[class='formErrorContent']")
	private WebElement addressFormError;
	
	@FindBy(id="tc_edit_address")
	private WebElement editAddressText;
	
	@FindBy(id="tc_edit_reason")
	private WebElement editReasonText;
	
	@FindBy(id="userRoleType")
	private WebElement userRoleCheckBox;
	
	@FindBy(id="tc_delete_name")
	private WebElement userFullNameDeleteModelText;
	
	@FindBy(id="tc_delete_email")
	private WebElement emailDeleteModelText;
	
	@FindBy(id="tc_delete_contact")
	private WebElement contactNumberDeleteModelText;
	
	@FindBy(id="tc_delete_address")
	private WebElement addressDeleteModelText;
	
	@FindBy(id="tc_delete_reason")
	private WebElement deleteReasonText;
	
	@FindBy(css="div[id='add_new_operator']>span:nth-child(2)>span")
	private WebElement addButtonInAddUserModel;
	
	@FindBy(css="form[id='tc_add_operator'] div[id='cancel_add_tc_operator']>span:nth-child(2)>span")
	private WebElement cancelButtonInAddUserModel;
	
	@FindBy(css="div[id='modify_operator']>span:nth-child(2)>span")
	private WebElement modifyButtonInEditUserModel;
	
	@FindBy(css="form[id='tc_modify'] div[id='cancel_add_tc_operator']>span:nth-child(2)>span")
	private WebElement cancelButtonInEditUserModel;
	
	@FindBy(css="div[id='delete_operator']>span:nth-child(2)>span")
	private WebElement deleteButtonInDeleteUserModel;
	
	@FindBy(css="form[id='tc_delete_form'] div[id='cancel_add_tc_operator']>span:nth-child(2)>span")
	private WebElement cancelButtonInDeleteUserModel;
	
	@FindBy(className="confirm_alert")
	private WebElement confirmMessage;
	
	@FindBy(css="div[id='confirm_tc_delete']>span:nth-child(2)>span")
	private WebElement confirmOkButton;
	
	@FindBy(css="div[id='confirm_tc_cancel']>span:nth-child(2)>span")
	private WebElement confirmCancelButton;
	
	@FindBy(className="sticky_nav_text")
	private WebElement stickyActionsText;
	
	@FindBy(id="menuitem_add_edit_delete_tc")
	private WebElement addEditDeleteUsersLink;
	
	@FindBy(id="menuitem_roles_privileges")
	private WebElement rolesAndPrivilegesLink;
	
	private String createdUser = null;
	
	public void clickStickyActions() throws Exception{
		logger.info("waiting for sticky to be editable");
		browser.waitForEditable(stickyActionsText);
		logger.info("clicking on sticky actions");
		browser.click(stickyActionsText);
	}
	
	public void clickAddEditDeleteUsersLink() throws Exception{
		logger.info("waiting for the link to be enabled");
		browser.waitForEditable(addEditDeleteUsersLink);
		logger.info("clicking on add edit delete users link");
		browser.click(addEditDeleteUsersLink);
	}
	
	public void clickRolesAndPrivilegesLink() throws Exception{
		logger.info("waiting for the link to be enabled");
		browser.waitForEditable(rolesAndPrivilegesLink);
		logger.info("clicking on roles and privileges link");
		browser.click(rolesAndPrivilegesLink);
	}
	
	public void verifyElementsPresenceInDetailsPage(String pageHeadingMessage) throws Exception{
		logger.info("asserting page heading visible");
		browser.assertVisible(pageHeading);
		logger.info("asserting page heading text");
		String pagetitle= pageHeading.getText();
		logger.info(pagetitle);
		if(pagetitle.contains(pageHeadingMessage)){
			Assert.assertTrue(true);
		}else{
			logger.info("Page header does not match");
			Assert.assertTrue(false);
		}
	 
		logger.info("asserting name header visible");
		browser.assertVisible(nameListHeader);
		logger.info("asserting email header visible");
		browser.assertVisible(emailListHeader);
		logger.info("asserting contact number header visible");
		browser.assertVisible(contactNumberListHeader);
		logger.info("asserting user name header visible");
		browser.assertVisible(userNameListHeader);
		logger.info("asserting actions header visible");
		browser.assertVisible(actionsListHeader);
		logger.info("asserting name radio option visible");
		browser.assertVisible(searchByNameRadio);
		logger.info("asserting email radio option visible");
		browser.assertVisible(searchByEmailRadio);
		logger.info("asserting contact radio option visible");
		browser.assertVisible(searchByContactRadio);
		logger.info("asserting name search text visible");
		browser.assertVisible(nameSearchText);
		logger.info("asserting user search link visible");
		browser.assertVisible(searchTextLink);
		logger.info("asserting add user link visible");
		browser.assertVisible(addUserLink);
		logger.info("asserting user count visible");
		browser.assertVisible(userCount);
		logger.info("asserting refresh icon visible");
		browser.assertVisible(refreshIcon);
		logger.info("asserting refresh text visible");
		browser.assertVisible(refreshText);
	}
	
	public void searchByCreatedUser() throws Exception{
		logger.info("waiting for name radio button to get visible");
		browser.waitForEditable(searchByNameRadio);
		logger.info("clicking on name radio option");
		browser.click(searchByNameRadio);
		logger.info("typing in search text box");
		browser.type(nameSearchText, createdUser);
		logger.info("clicking on search link");
		browser.click(searchTextLink);
		logger.info("sleeping for 2 sec for updating the current list");
		browser.Wait(2);
	}
	
	public void searchByCreatedUserAndVerifyUserInList() throws Exception{
		searchByCreatedUser();
		Iterator<WebElement> namesList = nameList.iterator();
		boolean comparedName = false;
		while(namesList.hasNext()){
			WebElement eachElement = namesList.next();
			if(browser.isVisible(eachElement)){
				comparedName = true;
				String elementText = browser.getText(eachElement);
				logger.info("comparing "+createdUser+" with "+elementText+" in the existing list");
				if(!elementText.equalsIgnoreCase(createdUser)){
					browser.verifyFail("Expected name '"+createdUser+"' not matching in the users list");
				}
			}
		}
		browser.verifyTrue(comparedName, "No data for the given name "+createdUser);
	}
	
	public void searchByName(String name) throws Exception{
		logger.info("waiting for name radio button to get visible");
		browser.waitForEditable(searchByNameRadio);
		logger.info("clicking on name radio option");
		browser.Wait(1);
		browser.click(searchByNameRadio);
		logger.info("typing in search text box");
		browser.type(nameSearchText, name);
		logger.info("clicking on search link");
		browser.click(searchTextLink);
		logger.info("sleeping for 2 sec for updating the current list");
		browser.Wait(2);
		Iterator<WebElement> namesList = nameList.iterator();
		boolean comparedName = false;
		while(namesList.hasNext()){
			WebElement eachElement = namesList.next();
			if(browser.isVisible(eachElement)){
				comparedName = true;
				String elementText = browser.getText(eachElement);
				logger.info("comparing "+name+" with "+elementText+" in the existing list");
				if(!elementText.contains(name)){
					browser.verifyFail("Expected name '"+name+"' not matching in the users list");
				}
			}
		}
		browser.verifyTrue(comparedName, "No data for the given name "+name);
	}
	
	public void searchByEmail(String email) throws Exception{
		logger.info("clicking on email radio option");
		browser.click(searchByEmailRadio);
		logger.info("typing in search text box");
		browser.type(nameSearchText, email);
		logger.info("clicking on search link");
		browser.click(searchTextLink);
		logger.info("sleeping for 2 sec for updating the current list");
		browser.Wait(2);
		Iterator<WebElement> emailsList = emailList.iterator();
		boolean comparedEmail = false;
		while(emailsList.hasNext()){
			WebElement eachElement = emailsList.next();
			if(browser.isVisible(eachElement)){
				comparedEmail = true;
				browser.verifyAttribute(eachElement, "title", email);
			}
		}
		browser.verifyTrue(comparedEmail, "No data for the given email "+email);
	}
	
	public void searchByContactNumber(String contactNumber) throws Exception{
		logger.info("clicking on contact radio option");
		browser.click(searchByContactRadio);
		logger.info("typing in search text box");
		browser.type(nameSearchText, contactNumber);
		logger.info("clicking on search link");
		browser.click(searchTextLink);
		logger.info("sleeping for 2 sec for updating the current list");
		browser.Wait(2);
		Iterator<WebElement> contactNumbersList = contactNumberList.iterator();
		boolean comparedContactNumber = false;
		while(contactNumbersList.hasNext()){
			WebElement eachElement = contactNumbersList.next();
			if(browser.isVisible(eachElement)){
				comparedContactNumber = true;
				if(!browser.getAttribute(eachElement, "title").contains(contactNumber)){
					browser.verifyFail("Expected contact Number '"+contactNumber+"' not matching in the users list");
				}
			}
		}
		browser.verifyTrue(comparedContactNumber, "No data for the given contact number "+contactNumber);
	}
	
	public void searchByEmptyData(String searchFieldEmptyError) throws Exception{
		logger.info("verifying the search result with empty data in the search box");
		logger.info("waiting for name radio button to get visible");
		browser.waitForEditable(searchByNameRadio);
		logger.info("clicking on name radio option");
		browser.click(searchByNameRadio);
		logger.info("clearing data in search text box");
		browser.clear(nameSearchText);
		logger.info("clicking on name radio option");
		browser.click(searchByNameRadio);
		logger.info("waiting for search error to visible");
		browser.waitForVisible(nameSearchFormError);
		logger.info("verifying text in name search error");
		browser.verifyText(nameSearchFormError, searchFieldEmptyError);
	}
	
	public void clickAddUserLink() throws Exception{
		logger.info("clicking on add user link");
		browser.click(addUserLink);
	}
	
	public void clickCancelButtonOfAddUser() throws Exception{
		logger.info("clicking cancel button");
		browser.click(cancelButtonInAddUserModel);
	}
	
	public void verifyCancelButtonInAddUser() throws Exception{
		clickCancelButtonOfAddUser();
		logger.info("verifying add user model header is not visible");
		browser.verifyNotVisible(addUserModelHeader);
		logger.info("verifying add user link is visible");
		browser.verifyVisible(addUserLink);
	}
	
	public void verifyAddUserModelHeader(String addModelHeaderExpectedText) throws Exception{
		logger.info("waiting for full name text to visible");
		browser.waitForVisible(fullNameText);
		logger.info("verifying add user model header text");
		browser.verifyText(addUserModelHeader, addModelHeaderExpectedText);
	}
	
	public void createUser(String fullName, String emailId, String contactNumber, String address,String addSuccessMessage) throws Exception{
		logger.info("typing user full name");
		browser.typeRandomAlphabets(fullNameText, fullName);
		createdUser = browser.getValue(fullNameText);
		logger.info("typing email");
		browser.type(emailText, emailId);
		logger.info("typing contact number");
		browser.type(contactNumberText, contactNumber);
		logger.info("typing address");
		browser.typeRandomAlphabets(addressText, address);
		logger.info("clicking add button");
		browser.click(addButtonInAddUserModel);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(addSuccessMessage);
	}
	
	public void createUserWithExactFullName(String fullName, String emailId, String contactNumber, String address,String addSuccessMessage) throws Exception{
		logger.info("typing user full name");
		browser.type(fullNameText, fullName);
		createdUser = browser.getValue(fullNameText);
		logger.info("typing email");
		browser.type(emailText, emailId);
		logger.info("typing contact number");
		browser.type(contactNumberText, contactNumber);
		logger.info("typing address");
		browser.typeRandomAlphabets(addressText, address);
		logger.info("clicking add button");
		browser.click(addButtonInAddUserModel);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(addSuccessMessage);
	}
	
	public void verifyElementsInAddUserModel() throws Exception{
		logger.info("verifying full name is visible");
		browser.verifyVisible(fullNameText);
		logger.info("verifying email is visible");
		browser.verifyVisible(emailText);
		logger.info("verifying contact number is visible");
		browser.verifyVisible(contactNumberText);
		logger.info("verifying address field is visible");
		browser.verifyVisible(addressText);
		logger.info("verifying user add button is visible");
		browser.verifyVisible(addButtonInAddUserModel);
		logger.info("verifing user cancel button is visible");
		browser.verifyVisible(cancelButtonInAddUserModel);
	}
	
	public void clickEditIconWithUserNameInList(String userName) throws Exception{
		Iterator<WebElement> userNames = userNameList.iterator();
		boolean foundUserName = false;
		int i=0;
		while(userNames.hasNext()){
			WebElement eachUserName =  userNames.next();
			if(browser.isVisible(eachUserName)){
				if(browser.getText(eachUserName).equals(userName)){
					foundUserName = true;
					browser.click(actionsEditIconList.get(i));
					break;
				}
			}
			i++;
		}
		browser.assertTrue(foundUserName, "Could not find userName '"+userName+"' in the list");
	}
	
	public void clickEditIconFirstVisibleUserInList() throws Exception{
		Iterator<WebElement> actionEditIcons = actionsEditIconList.iterator();
		boolean clickedIcon = false;
		while(actionEditIcons.hasNext()){
			WebElement eachIcon =  actionEditIcons.next();
			if(browser.isVisible(eachIcon)){
				clickedIcon = true;
				browser.click(eachIcon);
				break;
			}
		}
		browser.assertTrue(clickedIcon, "Could not click any edit icon");
	}
	
	public void clickDeleteIconFirstVisibleUserInList() throws Exception{
		Iterator<WebElement> actionDeleteIcons = actionsDeleteIconList.iterator();
		boolean clickedDeleteIcon = false;
		while(actionDeleteIcons.hasNext()){
			WebElement eachIcon =  actionDeleteIcons.next();
			if(browser.isVisible(eachIcon)){
				clickedDeleteIcon = true;
				browser.click(eachIcon);
				break;
			}
		}
		browser.assertTrue(clickedDeleteIcon, "Could not click any delete icon");
	}
	
	public void waitForEditUserModelHeaderVisible(){
		logger.info("waiting for the model box to be displayed");
		browser.waitForVisible(editUserModelHeader);
	}
	
	public void verifyEditUserModelHeader(String editModelHeaderExpectedText) throws Exception{
		waitForEditUserModelHeaderVisible();
		logger.info("verifying text in model header");
		browser.verifyText(editUserModelHeader, editModelHeaderExpectedText);
	}
	
	public void checkAdditionalRoleOption(boolean isOperator) throws Exception{
		logger.info("verifying additional role checkbox is present");
		browser.verifyVisible(userRoleCheckBox);
		if(isOperator){
			browser.verifyValue(userRoleCheckBox, "BESTINET_OPERATOR");
		}else{
			browser.verifyValue(userRoleCheckBox, "BESTINET_PRIVILEGED_USER");
		}
		
	}
	
	public String editUserDetails(String editReason, String editSuccessMessage) throws Exception{
		
		browser.type(editAddressText, " new");
		String newAddressText = browser.getValue(editAddressText);
		browser.type(editReasonText, editReason);
		browser.click(modifyButtonInEditUserModel);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(editSuccessMessage);
		return newAddressText;
	}
	
	public void assignAdditionalRole(String editReason, String editSuccessMessage) throws Exception{
		logger.info("assigning additional role");
		logger.info("typing reason");
		browser.type(editReasonText, editReason);
		logger.info("checking userrole checkbox");
		browser.check(userRoleCheckBox);
		logger.info("clicking modify button in edit model");
		browser.click(modifyButtonInEditUserModel);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(editSuccessMessage);
	}
	
	public void removeAdditionalRole(String editReason, String editSuccessMessage) throws Exception{
		logger.info("removing additional role");
		logger.info("typing reason");
		browser.type(editReasonText, editReason);
		logger.info("checking userrole checkbox");
		browser.uncheck(userRoleCheckBox);
		logger.info("clicking modify button in edit model");
		browser.click(modifyButtonInEditUserModel);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(editSuccessMessage);
	}
	
	public void verifyAdditionalRoleAssigned() throws Exception{
		logger.info("verifying additional role is assigned");
		browser.verifyChecked(userRoleCheckBox);
	}
	
	public void verifyAdditionalRoleNotAssigned() throws Exception{
		logger.info("verifying additional role is not assigned");
		browser.verifyNotChecked(userRoleCheckBox);
	}
	
	public void assertNewAddressInEditedUser(String newAddress){
		logger.info("waiting for the model box to be displayed");
		browser.waitForVisible(editUserModelHeader);
		logger.info("asserting new address in address text");
		browser.assertValue(editAddressText, newAddress);
	}
	
	public void clickCancelButonInEditUserModel() throws Exception{
		logger.info("clicking cancel button");
		browser.click(cancelButtonInEditUserModel);
	}
	
	public void verifyCancelButtonInEditUserModel() throws Exception{
		clickCancelButonInEditUserModel();
		logger.info("verifying edit user model header is not visible");
		browser.verifyNotVisible(editUserModelHeader);
		logger.info("verify add user link is visible");
		browser.verifyVisible(addUserLink);
	}
	
	public void verifyCancelButtonInDeleteUserModel() throws Exception{
		logger.info("clicking cancel button");
		browser.click(cancelButtonInDeleteUserModel);
		logger.info("verify delete user model header is not visible");
		browser.verifyNotVisible(deleteUserModelHeader);
		logger.info("verify add user link is visible");
		browser.verifyVisible(addUserLink);
	}
	
	public void verifyDeleteUserModelHeader(String deleteModelHeaderExpectedText) throws Exception{
		logger.info("waiting for the delete user model header to visible");
		browser.waitForVisible(deleteUserModelHeader);
		logger.info("verifying text in delete user model header");
		browser.verifyText(deleteUserModelHeader, deleteModelHeaderExpectedText);
	}
	
	public void enterReasonForDelete(String deleteReason) throws Exception{
		logger.info("verifying full name in delete model is not enabled");
		browser.verifyNotEditable(userFullNameDeleteModelText);
		logger.info("verifying email in delete model is not enabled");
		browser.verifyNotEditable(emailDeleteModelText);
		logger.info("verifying contact number in the delete model is not enabled");
		browser.verifyNotEditable(contactNumberDeleteModelText);
		logger.info("verifying address in delete model is not enabled");
		browser.verifyNotEditable(addressDeleteModelText);
		logger.info("typing reason in delete model");
		browser.type(deleteReasonText, deleteReason);
	}
	
	public void clickDeleteButtonInUserModel() throws Exception{
		logger.info("waiting for the delete button to visible in delete user model");
		browser.waitForVisible(deleteButtonInDeleteUserModel);
		logger.info("clicking on the delete button in delete user model");
		browser.click(deleteButtonInDeleteUserModel);
	}
	
	public void clickOkInConfirmation() throws Exception{
		logger.info("clicking ok in the confirmation popup");
		browser.click(confirmOkButton);
	}
	
	public void deleteUser(String deleteConfirmation, String deleteSuccessMessage) throws Exception{
		clickDeleteButtonInUserModel();
		logger.info("waiting for the confirmation box");
		browser.waitForVisible(confirmMessage);
		logger.info("verifying message in the confirmation box");
		browser.verifyText(confirmMessage, deleteConfirmation);
		logger.info("clicking ok in the confirmation box");
		browser.Wait(1);
		browser.click(confirmOkButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(deleteSuccessMessage);
	}
	
	public void verifyCancelButtonInDeleteConfirmation() throws Exception{
		logger.info("waiting for the confirmation cancel button to be visible");
		browser.waitForVisible(confirmCancelButton);
		logger.info("clicking the cancel button in the confirmation popup");
		browser.click(confirmCancelButton);
		logger.info("waiting for the cancel button in confirmation popup not to visible");
		browser.waitForNotVisible(confirmCancelButton);
		logger.info("verifying add user link is visible");
		browser.verifyVisible(addUserLink);
	}
	
	public void assertDeleteStatusForFirstSearchedUserInList(String accountDeleteTitle) throws Exception{
		Iterator<WebElement> statusList = accountStatusList.iterator();
		boolean lookupStatus = false;
		while(statusList.hasNext()){
			WebElement eachStatusColor =  statusList.next();
			if(browser.isVisible(eachStatusColor)){
				lookupStatus = true;
				browser.assertAttribute(eachStatusColor, "title", accountDeleteTitle);
				break;
			}
		}
		browser.assertTrue(lookupStatus, "Could not find any account");
	}
	
	public void validateFullName(String fullnameEmptyExpectedMessage, String fullnameMinCharAndLettersOnlydata, String fullnameMinCharAndLettersOnlyExpectedMessage,String fullnameMinChardata, String fullnameMinCharExpectedMessage, String fullnameLettersOnlyData, String fullnameLettersOnlyExpectedMessage) throws Exception{
		logger.info("validating full name field");
		logger.info("moving focus to full name");
		browser.focus(fullNameText);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for full name form error");
		browser.waitForVisible(fullNameFormError);
		logger.info("verifying text in full name form error");
		browser.verifyText(fullNameFormError, fullnameEmptyExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing fullnameMinCharAndLettersOnlydata '"+fullnameMinCharAndLettersOnlydata+"' in full name");
		browser.clearAndType(fullNameText, fullnameMinCharAndLettersOnlydata);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for full name form error");
		browser.waitForVisible(fullNameFormError);
		logger.info("verifying text in full name form error");
		browser.verifyText(fullNameFormError, fullnameMinCharAndLettersOnlyExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing fullnameMinChardata '"+fullnameMinChardata+"' in full name");
		browser.clearAndType(fullNameText, fullnameMinChardata);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for full name form error");
		browser.waitForVisible(fullNameFormError);
		logger.info("verifying text in full name form error");
		browser.verifyText(fullNameFormError, fullnameMinCharExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing fullnameLettersOnlyData '"+fullnameLettersOnlyData+"' in full name");
		browser.clearAndType(fullNameText, fullnameLettersOnlyData);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for full name form error");
		browser.waitForVisible(fullNameFormError);
		logger.info("verifying text in full name form error");
		browser.verifyText(fullNameFormError, fullnameLettersOnlyExpectedMessage);
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		
	}
	
	public void validateEmail(String emailEmptyExpectedMessage, String invaliedEmailAndMinCharData, String invaliedEmailAndMinCharExpectedMessage,String invaliedEmailData, String invaliedEmailExpectedMessage) throws Exception{
		logger.info("validating email field");
		logger.info("moving focus to email");
		browser.focus(emailText);
		logger.info("moving focus email to full name");
		browser.focus(fullNameText);
		logger.info("waiting for email form error");
		browser.waitForVisible(emailFormError);
		logger.info("verifying text in email form error");
		browser.verifyText(emailFormError, emailEmptyExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(2);
		
		logger.info("clearing and typing invaliedEmailData '"+invaliedEmailAndMinCharData+"' in email");
		browser.clearAndType(emailText, invaliedEmailAndMinCharData);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for email form error");
		browser.waitForVisible(emailFormError);
		logger.info("verifying text in email form error");
		browser.verifyText(emailFormError, invaliedEmailAndMinCharExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(2);
		
		logger.info("clearing and typing invaliedEmailData '"+invaliedEmailData+"' in email");
		browser.clearAndType(emailText, invaliedEmailData);
		browser.Wait(2);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		browser.Wait(2);
		logger.info("waiting for email form error three");
		browser.waitForVisible(emailFormError);
		logger.info("verifying text in email form error");
		browser.verifyText(emailFormError, invaliedEmailExpectedMessage);
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		
	}
	
	public void validateContactNumber(String contactNumberEmptyExpectedMessage, String contactNumberMinandNumbersOnlyData, String contactNumberMinandNumbersOnlyExpectedMessage, String contactNumberMinCharData, String contactNumberMinCharExpectedMessage, String contactNumberNumberOnlyData, String contactNumberNumberOnlyExpectedMessage) throws Exception{
		logger.info("validating contact number field");
		logger.info("moving focus to contact number");
		browser.focus(contactNumberText);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for contact number form error");
		browser.waitForVisible(contactNumberFormError);
		logger.info("verifying text in contact number form error");
		browser.verifyText(contactNumberFormError, contactNumberEmptyExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing contactNumberMinandNumbersOnlyData '"+contactNumberMinandNumbersOnlyData+"' in contact number");
		browser.clearAndType(contactNumberText, contactNumberMinandNumbersOnlyData);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for contact number form error");
		browser.waitForVisible(contactNumberFormError);
		logger.info("verifying text in contact number form error");
		browser.verifyText(contactNumberFormError, contactNumberMinandNumbersOnlyExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing contactNumberMinCharData '"+contactNumberMinCharData+"' in contact number");
		browser.clearAndType(contactNumberText, contactNumberMinCharData);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for contact number form error");
		browser.waitForVisible(contactNumberFormError);
		logger.info("verifying text in contact number form error");
		browser.verifyText(contactNumberFormError, contactNumberMinCharExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing contactNumberNumberOnlyData '"+contactNumberNumberOnlyData+"' in contact number");
		browser.clearAndType(contactNumberText, contactNumberNumberOnlyData);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for contact number form error");
		browser.waitForVisible(contactNumberFormError);
		logger.info("verifying text in contact number form error");
		browser.verifyText(contactNumberFormError, contactNumberNumberOnlyExpectedMessage);
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		
	}
	
	public void validateAddress(String addressEmptyExpectedMessage, String addressSpecialCharData, String addressSpecialCharExpectedMessage) throws Exception{
		logger.info("validating address field");
		logger.info("moving focus to address");
		browser.focus(addressText);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for address form error");
		browser.waitForVisible(addressFormError);
		logger.info("verifying text in address form error");
		browser.verifyText(addressFormError, addressEmptyExpectedMessage);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		
		logger.info("clearing and typing addressSpecialCharData '"+addressSpecialCharData+"' in address");
		browser.clearAndType(addressText, addressSpecialCharData);
		logger.info("clicking on add user button");
		browser.click(addButtonInAddUserModel);
		logger.info("waiting for address form error to visible");
		browser.waitForVisible(addressFormError);
		browser.verifyText(addressFormError, addressSpecialCharExpectedMessage);
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		
	}
	
}
