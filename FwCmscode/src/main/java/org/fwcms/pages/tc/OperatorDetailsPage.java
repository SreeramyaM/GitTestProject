package org.fwcms.pages.tc;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.fwcms.prop.tc.OperatorDetailsPageProp;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorDetailsPage {
	
	private static final Logger logger = LogManager.getLogger(OperatorDetailsPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public OperatorDetailsPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public OperatorDetailsPage initElements() throws Exception
	{
		return PageFactory.initElements(driver, OperatorDetailsPage.class);
	}
	
	@FindBy(css="div[class='pageHeading']>span")
	private WebElement pageHeading;
	
	@FindBy(className="active_user")
	private WebElement userInfoInHeader;
	
	@FindBy(className="fullname_ico")
	private WebElement fullNameIcon;
	
	@FindBy(className="phone_ico")
	private WebElement phoneIcon;
	
	@FindBy(className="email_ico")
	private WebElement emailIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(id="custom_searchbyname")
	private WebElement searchByNameRadio;
	
	@FindBy(id="custom_searchbyemail")
	private WebElement searchByEmailRadio;
	
	@FindBy(id="custom_searchbyphone")
	private WebElement searchByContactRadio;
	
	@FindBy(id="operator_name_search")
	private WebElement searchTextBox;
	
	@FindBy(css="span[class='search_text search_operators']")
	private WebElement searchTextLink;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(1)")
	private WebElement nameHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(2)")
	private WebElement emailHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(3)")
	private WebElement contactHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(4)")
	private WebElement userNameHeader;
	
	@FindBy(css="div[class='listHeader']>div:nth-child(5)")
	private WebElement actionsHeader;
	
	@FindBy(css="a[id='add_tc_operator']>span:nth-child(2)")
	private WebElement addOperatorLink;
	
	@FindBy(className="records_count")
	private WebElement operatorsCount;
	
	@FindBy(css="span[class='refresh_operators_text']>a")
	private WebElement refreshLink;
	
	@FindBy(className="tc_add_operator_popup")
	private WebElement operatorPopUp;
	
	@FindBy(id="userFullName")
	private WebElement userFullNameTextBox;
	
	@FindBy(css="div[class^='userFullNameformError']>div[class='formErrorContent']")
	private WebElement userFullNameTextBoxError;
	
	@FindBy(id="email")
	private WebElement emailTextBox;
	
	@FindBy(css="div[class^='emailformError']>div[class='formErrorContent']")
	private WebElement emailTextBoxError;
	
	@FindBy(id="contactNo")
	private WebElement contactNumberTextBox;
	
	@FindBy(css="div[class^='contactNoformError']>div[class='formErrorContent']")
	private WebElement contactNumberTextBoxError;
	
	@FindBy(css="div[id='add_new_tc_operator']>span:nth-child(2)>span")
	private WebElement addButton;
	
	@FindBy(css="div[id='cancel_add_tc_operator']>span:nth-child(2)>span")
	private WebElement cancelButton;
	
	@FindBy(css="div[class$='cell_operator_name']")
	private List<WebElement> userFullNameList;
	
	@FindBy(className="user_fullname")
	private List<WebElement> hiddenUserFullNameList;
	
	@FindBy(className="user_email_id")
	private List<WebElement> hiddenEmailList;
	
	@FindBy(className="user_contact_no")
	private List<WebElement> hiddenContactNumberList;
	
	@FindBy(className="edit")
	private List<WebElement> editActionList;
	
	@FindBy(className="delete")
	private List<WebElement> deleteActionList;
	
	@FindBy(className="changePassword")
	private List<WebElement> changePasswordActionList;
	
	@FindBy(css="div[class='tc_list_rows']>div:nth-child(13)")
	private List<WebElement> operatorStatusList;
	
	@FindBy(className="edit")
	private WebElement editAction;
	
	@FindBy(className="delete")
	private WebElement deleteAction;
	
	@FindBy(className="changePassword")
	private WebElement changePasswordAction;
	
	@FindBy(className="tc_edit_operator_popup")
	private WebElement editOperatorModel;
	
	@FindBy(css="span[id='tc_edit_username']")
	private WebElement userNameInEditModel;
	
	@FindBy(id="tc_edit_name")
	private WebElement fullNameTextBoxInEditModel;
	
	@FindBy(css="span[id='tc_edit_email']")
	private WebElement emailInEditModel;
	
	@FindBy(id="tc_edit_contact")
	private WebElement contactNumberTextBoxInEditModel;
	
	@FindBy(id="tc_edit_reason")
	private WebElement reasonTextBoxInEditModel;
	
	@FindBy(css="div[class^='tc_edit_reasonformError']>div[class='formErrorContent']")
	private WebElement reasonTextBoxErrorInEditModel;
	
	@FindBy(css="div[id='modify_tc_operator']>span:nth-child(2)>span")
	private WebElement modifyButtonInEditModel;
	
	@FindBy(css="form[id='tc_modify']>div>div[class='btn_block']>div[id='cancel_add_tc_operator']")
	private WebElement cancelButtonInEditModel;
	
	@FindBy(className="tc_delete_operator_popup")
	private WebElement deleteOperatorModel;
	
	@FindBy(css="span[id='tc_delete_username']")
	private WebElement userNameInDeleteModel;
	
	@FindBy(id="tc_delete_name")
	private WebElement fullNameTextBoxInDeleteModel;
	
	@FindBy(id="tc_delete_email")
	private WebElement emailTextBoxInDeleteModel;
	
	@FindBy(id="tc_delete_contact")
	private WebElement contactNumberTextBoxInDeleteModel;
	
	@FindBy(id="tc_delete_reason")
	private WebElement reasonTextBoxInDeleteModel;
	
	@FindBy(css="div[class^='tc_delete_reasonformError']>div[class='formErrorContent']")
	private WebElement reasonTextBoxErrorInDeleteModel;
	
	@FindBy(css="div[id='delete_tc_operator']>span:nth-child(2)>span")
	private WebElement deleteButtonInDeleteModel;
	
	@FindBy(css="form[id='tc_delete_form']>div>div[class='btn_block']>div[id='cancel_add_tc_operator']")
	private WebElement cancelButtonInDeleteModel;
	
	@FindBy(className="confirm_alert")
	private WebElement confirmationMessage;
	
	@FindBy(css="div[id='confirm_tc_delete']>span:nth-child(2)>span")
	private WebElement confirmationOkButton;
	
	@FindBy(css="div[id='confirm_tc_cancel']>span:nth-child(2)>span")
	private WebElement confirmationCancelButton;
	
	private String createdOperator = null;
	
	public void verifyPageHeading() throws Exception{
		logger.info("waiting for pageHeading to be visible");
		browser.waitForVisible(pageHeading);
		logger.info("verifying page heading ");
		browser.verifyText(pageHeading, OperatorDetailsPageProp.getpageHeading());
	}
	
	public void verifyElementsPresentInOeratorDetailsPage() throws Exception{
		logger.info("verifying elements in operator details page");
		logger.info("verifying signout link visible");
		browser.verifyVisible(signOutLink);
		logger.info("verifying user info is visible");
		browser.verifyVisible(userInfoInHeader);
		logger.info("waiting for clickable");
		browser.waitForEditable(userInfoInHeader);
		logger.info("clicking user info");
		browser.click(userInfoInHeader);
		logger.info("verifying full name icon visible");
		browser.verifyVisible(fullNameIcon);
		logger.info("verifying phone icon is visible");
		browser.verifyVisible(phoneIcon);
		logger.info("verifying email icon is visible");
		browser.verifyVisible(emailIcon);
		logger.info("closing user info by clicking on page header");
		browser.click(pageHeading);
		logger.info("verifying search by name radio is visible");
		browser.verifyVisible(searchByNameRadio);
		logger.info("verifying search by email radio is visible");
		browser.verifyVisible(searchByEmailRadio);
		logger.info("verifying search by contact radio is visible");
		browser.verifyVisible(searchByContactRadio);
		logger.info("verifying search text box is visible");
		browser.verifyVisible(searchTextBox);
		logger.info("verifying search text link is visible");
		browser.verifyVisible(searchTextLink);
		logger.info("verifying name header is visible");
		browser.verifyVisible(nameHeader);
		logger.info("verifying email header is visible");
		browser.verifyVisible(emailHeader);
		logger.info("verifying contact number header is visible");
		browser.verifyVisible(contactHeader);
		logger.info("verifying user name header is visible");
		browser.verifyVisible(userNameHeader);
		logger.info("verifying actions header is visible");
		browser.verifyVisible(actionsHeader);
		logger.info("verifying add operator link is visible");
		browser.verifyVisible(addOperatorLink);
		logger.info("verifying operator count is visible");
		//browser.verifyVisible(operatorsCount);
		logger.info("verifying refresh text link is visible");
		browser.verifyVisible(refreshLink);
	}
	
	public void clickAddOperatorAndVerifyAddOperatorPopUpVisible() throws Exception{
		logger.info("clicking add operator link");
		browser.click(addOperatorLink);
		logger.info("waiting for the add operator popup to be visible");
		browser.waitForVisible(operatorPopUp);
	}
	
	public void verifyElementsInAddOperatorPopup() throws Exception{
		logger.info("verifying elements in add operator popup");
		logger.info("verifying username field is visible");
		browser.verifyVisible(userFullNameTextBox);
		logger.info("verifying email field is visible");
		browser.verifyVisible(emailTextBox);
		logger.info("verifying contact number field is visible");
		browser.verifyVisible(contactNumberTextBox);
		logger.info("verifying add button is visible");
		browser.verifyVisible(addButton);
		logger.info("verify cancel button is visible");
		browser.verifyVisible(cancelButton);
	}
	
	public void validateFullNameFieldOnAddButtonClick(JSONArray invalidUserFullNames) throws Exception{
		logger.info("validating username field");
		for (int i = 0; i < invalidUserFullNames.length(); i++) {
			String userName = invalidUserFullNames.getString(i);
			logger.info("moving focus to username field");
			browser.focus(userFullNameTextBox);
			logger.info("typing '"+userName+"' in username field");
			browser.clearAndType(userFullNameTextBox, userName);
			logger.info("clicking add button");
			browser.click(addButton);
			logger.info("waiting for the username field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(userFullNameTextBoxError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void validateEmailFieldOnAddButtonClick(JSONArray invaliedEmails) throws Exception{
		logger.info("validating email field");
		for (int i = 0; i < invaliedEmails.length(); i++) {
			logger.info("moving focus to email field");
			browser.focus(emailTextBox);
			String email = invaliedEmails.getString(i);
			logger.info("typing '"+email+"' in email field");
			browser.clearAndType(emailTextBox, email);
			logger.info("clicking add button");
			browser.click(addButton);
			browser.Wait(1);
			browser.verifyVisible(emailTextBoxError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void validateContactNumberFieldOnAddButtonClick(JSONArray invaliedMobileNumbers) throws Exception{
		logger.info("validating contact number field");
		for (int i = 0; i < invaliedMobileNumbers.length(); i++) {
			logger.info("moving focus to contact number field");
			browser.focus(contactNumberTextBox);
			String mobileNumber = invaliedMobileNumbers.getString(i);
			logger.info("typing '"+mobileNumber+"' in contact number field");
			browser.clearAndType(contactNumberTextBox, mobileNumber);
			logger.info("clicking add button");
			browser.click(addButton);
			browser.Wait(1);
			browser.verifyVisible(contactNumberTextBoxError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void verifyCancelButtonInAddOperator() throws Exception{
		logger.info("verify cancel button in add operator");
		logger.info("clicking cancel button in add operator");
		browser.click(cancelButton);
		logger.info("verifying add operator popup is not visible");
		browser.verifyNotVisible(operatorPopUp);
		logger.info("verifying add operator link is visible");
		browser.verifyVisible(addOperatorLink);
	}
	
	public void enterDetailsOfOperator(String userFullName, String email, String contactNumber) throws Exception{
		logger.info("entering details of operator");
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		logger.info("entering userFullName '"+userFullName+"' in user fullname field");
		browser.clearAndTypeRandomAlphabets(userFullNameTextBox, userFullName);
		createdOperator = browser.getValue(userFullNameTextBox);
		logger.info("entering email '"+email+"' in email field");
		browser.clearAndType(emailTextBox, email);
		logger.info("entering contactNumber '"+contactNumber+"' in contact number field");
		browser.clearAndType(contactNumberTextBox, contactNumber);
	}
	
	public void enterDetailsOfOperatorWithExactName(String userFullName, String email, String contactNumber) throws Exception{
		logger.info("entering details of operator");
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		logger.info("entering userFullName '"+userFullName+"' in user fullname field");
		browser.clearAndType(userFullNameTextBox, userFullName);
		createdOperator = browser.getValue(userFullNameTextBox);
		logger.info("entering email '"+email+"' in email field");
		browser.clearAndType(emailTextBox, email);
		logger.info("entering contactNumber '"+contactNumber+"' in contact number field");
		browser.clearAndType(contactNumberTextBox, contactNumber);
	}
	
	public void clickAddButtonAndVerifyMessage() throws Exception{
		logger.info("clicking add button in add operator popup");
		logger.info("waiting for editable");
		browser.waitForEditable(addButton);
		browser.click(addButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(OperatorDetailsPageProp.getaddOperatorMessage());
	}
	
	public void searchCreatedUser() throws Exception{
		logger.info("searching created user and verifying actions buttons");
		logger.info("waiting for the search by name radio to be clickable");
		browser.waitForEditable(searchByNameRadio);
		logger.info("typing '"+createdOperator+"' in search text box");
		browser.clearAndType(searchTextBox, createdOperator);
		logger.info("clicking search text link");
		browser.click(searchTextLink);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
	}
	
	public void searchCreatedUserAndVerifyActionButtons() throws Exception{
		searchCreatedUser();
		logger.info("verifying edit action is visible");
		Iterator<WebElement> userList = userFullNameList.iterator();
		int i=0;
		boolean verifiedIcons = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				verifiedIcons = true;
				browser.verifyVisible(editActionList.get(i));
				browser.verifyVisible(deleteActionList.get(i));
				browser.verifyVisible(changePasswordActionList.get(i));
				break;
			}
			i++;
		}
		browser.verifyTrue(verifiedIcons,"could not verify actions icon for any user");
	}
	
	public void clickChangePasswordAndVerifyMessage() throws Exception{
		logger.info("clicking on change password icon and verifying message");
		logger.info("clicking on change password action of first user");
		Iterator<WebElement> userList = userFullNameList.iterator();
		int i=0;
		boolean clickedChangePassword = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				clickedChangePassword = true;
				browser.click(changePasswordActionList.get(i));
				break;
			}
			i++;
		}
		browser.verifyTrue(clickedChangePassword,"Could not find any user in the list to click change password");
		//browser.click(changePasswordAction);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(OperatorDetailsPageProp.getchangePasswordMessage());
	}
	
	public void clickEditIconAndVerifyModifyOperatorPopupVisible() throws Exception{
		logger.info("clicking on edit icon of first user and verifying edit popup is visible");
		logger.info("clicking on edit icon");
		Iterator<WebElement> userList = userFullNameList.iterator();
		int i=0;
		boolean clickedEditIcon = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				clickedEditIcon = true;
				browser.click(editActionList.get(i));
				break;
			}
			i++;
		}
		browser.verifyTrue(clickedEditIcon,"Could not find any user in the list to click edit icon");
		logger.info("waiting for the popup to visible");
		browser.waitForVisible(editOperatorModel);
	}
	
	public void verifyElementsInEditOperatorPopup() throws Exception{
		logger.info("verifying elements in edit operator popup");
		logger.info("verifying username is visible and is not editable");
		browser.verifyVisible(userNameInEditModel);
		logger.info("verifying full name is visible");
		browser.verifyVisible(fullNameTextBoxInEditModel);
		logger.info("verifying full name is editable");
		browser.verifyEditable(fullNameTextBoxInEditModel);
		logger.info("verifying email is visible and is not editable");
		browser.verifyVisible(emailInEditModel);
		logger.info("verifying contact number is visible");
		browser.verifyVisible(contactNumberTextBoxInEditModel);
		logger.info("verifying contact number is editable");
		browser.verifyEditable(contactNumberTextBoxInEditModel);
		logger.info("verifying reason field is visible");
		browser.verifyVisible(reasonTextBoxInEditModel);
		logger.info("verifying reason fiels is editable");
		browser.verifyEditable(reasonTextBoxInEditModel);
		logger.info("verifying modify button is visible");
		browser.verifyVisible(modifyButtonInEditModel);
		logger.info("verify model button is editable");
		browser.verifyEditable(modifyButtonInEditModel);
		logger.info("verifying cancel button is visible");
		browser.verifyVisible(cancelButtonInEditModel);
		logger.info("verify cancel button is editable");
		browser.verifyEditable(cancelButtonInEditModel);
	}
	
	public void validateReasonInEditModel(JSONArray invalidReasons) throws Exception{
		logger.info("validating reason field in edit model");
		for (int i = 0; i < invalidReasons.length(); i++) {
			logger.info("moving focus to reason field");
			browser.focus(reasonTextBoxInEditModel);
			String reason = invalidReasons.getString(i);
			logger.info("typing '"+reason+"' in reason field");
			browser.clearAndType(reasonTextBoxInEditModel, reason);
			logger.info("clicking modify button");
			browser.click(modifyButtonInEditModel);
			browser.Wait(1);
			logger.info("verifying reason error is visible");
			browser.verifyVisible(reasonTextBoxErrorInEditModel);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void validateCancelButtonInModifyOperatorPopup() throws Exception{
		logger.info("verifying cancel button in modify operator popup");
		browser.click(cancelButtonInEditModel);
		logger.info("verifying edit model is not visible");
		browser.verifyNotVisible(editOperatorModel);
		logger.info("verifying add operator is visible");
		browser.verifyVisible(addOperatorLink);
	}
	
	public void clickEditIconAndVerifyValuesPopulatedInModifyOperatorPopup() throws Exception{
		logger.info("click edit icon of fist visible user");
		Iterator<WebElement> userList = userFullNameList.iterator();
		String userFullName = null;
		String email = null;
		String contactNumber = null;
		int i=0;
		boolean clickedEditIcon = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				clickedEditIcon = true;
				userFullName = browser.getTextFromHiddenElement(hiddenUserFullNameList.get(i));
				email = browser.getTextFromHiddenElement(hiddenEmailList.get(i));
				contactNumber = browser.getTextFromHiddenElement(hiddenContactNumberList.get(i));
				browser.click(editActionList.get(i));
				break;
			}
			i++;
		}
		browser.verifyTrue(clickedEditIcon, "could not click on edit icon for any user");
		logger.info("waiting for edit operator model to visible");
		browser.waitForVisible(editOperatorModel);
		browser.verifyValue(fullNameTextBoxInEditModel, userFullName);
		browser.verifyText(emailInEditModel, email);
		browser.verifyValue(contactNumberTextBoxInEditModel, contactNumber);
	}
	
	public void enterReasonAndClickModifyOperator(String reasonData) throws Exception{
		logger.info("typing reasonData '"+reasonData+"' in reason field");
		browser.clearAndType(reasonTextBoxInEditModel, reasonData);
		logger.info("clicking modify button");
		browser.click(modifyButtonInEditModel);
	}
	
	public void verifyMessageForModifyOperatorPopup() throws Exception{
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(OperatorDetailsPageProp.geteditOperatorMessage());
	}
	
	public void clickDeleteIconAndVerifyDeleteOperatorPopupVisible() throws Exception{
		logger.info("clicking on delete icon of first user and verifying edit popup is visible");
		logger.info("clicking on delete icon");
		Iterator<WebElement> userList = userFullNameList.iterator();
		int i=0;
		boolean clickedDeleteIcon = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				clickedDeleteIcon = true;
				browser.click(deleteActionList.get(i));
				break;
			}
			i++;
		}
		browser.verifyTrue(clickedDeleteIcon,"Could not find any user in the list to click delete icon");
		logger.info("waiting for the popup to visible");
		browser.waitForVisible(deleteOperatorModel);
	}
	
	public void validateCancelButtonInDeleteOperatorPopup() throws Exception{
		logger.info("verifying cancel button in delete operator popup");
		browser.click(cancelButtonInDeleteModel);
		logger.info("verifying delete model is not visible");
		browser.verifyNotVisible(deleteOperatorModel);
		logger.info("verifying add operator is visible");
		browser.verifyVisible(addOperatorLink);
	}
	
	public void verifyElementsInDeleteOperatorPopup() throws Exception{
		logger.info("verifying elements in delete operator popup");
		logger.info("verifying username is visible and is not editable");
		browser.verifyVisible(userNameInDeleteModel);
		logger.info("verifying full name is visible");
		browser.verifyVisible(fullNameTextBoxInDeleteModel);
		logger.info("verifying full name is not editable");
		browser.verifyNotEditable(fullNameTextBoxInDeleteModel);
		logger.info("verifying email is visible and is not editable");
		browser.verifyVisible(emailTextBoxInDeleteModel);
		logger.info("verifying contact number is visible");
		browser.verifyVisible(contactNumberTextBoxInDeleteModel);
		logger.info("verifying contact number is not editable");
		browser.verifyNotEditable(contactNumberTextBoxInDeleteModel);
		logger.info("verifying reason field is visible");
		browser.verifyVisible(reasonTextBoxInDeleteModel);
		logger.info("verifying reason fiels is editable");
		browser.verifyEditable(reasonTextBoxInDeleteModel);
		logger.info("verifying delete button is visible");
		browser.verifyVisible(deleteButtonInDeleteModel);
		logger.info("verify delete button is editable");
		browser.verifyEditable(deleteButtonInDeleteModel);
		logger.info("verifying cancel button is visible");
		browser.verifyVisible(cancelButtonInDeleteModel);
		logger.info("verify cancel button is editable");
		browser.verifyEditable(cancelButtonInDeleteModel);
	}
	
	public void clickDeleteIconAndVerifyValuesPopulatedInDeleteOperatorPopup() throws Exception{
		logger.info("click delete icon of fist visible user");
		Iterator<WebElement> userList = userFullNameList.iterator();
		String userFullName = null;
		String email = null;
		String contactNumber = null;
		int i=0;
		boolean clickedDeleteIcon = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				clickedDeleteIcon = true;
				userFullName = browser.getTextFromHiddenElement(hiddenUserFullNameList.get(i));
				email = browser.getTextFromHiddenElement(hiddenEmailList.get(i));
				contactNumber = browser.getTextFromHiddenElement(hiddenContactNumberList.get(i));
				browser.click(deleteActionList.get(i));
				break;
			}
			i++;
		}
		browser.verifyTrue(clickedDeleteIcon, "could not click on delete icon for any user");
		logger.info("waiting for delete operator model to visible");
		browser.waitForVisible(deleteOperatorModel);
		browser.verifyValue(fullNameTextBoxInDeleteModel, userFullName);
		browser.verifyValue(emailTextBoxInDeleteModel, email);
		browser.verifyValue(contactNumberTextBoxInDeleteModel, contactNumber);
	}
	
	public void validateReasonInDeleteModel(JSONArray invalidReasons) throws Exception{
		logger.info("validating reason field in delete model");
		for (int i = 0; i < invalidReasons.length(); i++) {
			logger.info("moving focus to reason field");
			browser.focus(reasonTextBoxInDeleteModel);
			String reason = invalidReasons.getString(i);
			logger.info("typing '"+reason+"' in reason field");
			browser.clearAndType(reasonTextBoxInDeleteModel, reason);
			logger.info("clicking delete button");
			browser.click(deleteButtonInDeleteModel);
			browser.Wait(1);
			logger.info("verifying reason error is visible");
			browser.verifyVisible(reasonTextBoxErrorInDeleteModel);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void enterReasonAndClickDeleteOperator(String reasonData) throws Exception{
		logger.info("typing reasonData '"+reasonData+"' in reason field");
		browser.clearAndType(reasonTextBoxInDeleteModel, reasonData);
		logger.info("clicking delete button");
		browser.click(deleteButtonInDeleteModel);
	}
	
	public void verifyDeleteConfirmationMessage() throws Exception{
		logger.info("verifying confirmation message in confirmation message");
		logger.info("waiting for conformation message to visible");
		browser.waitForVisible(confirmationMessage);
		logger.info("verifying text in confirmation message");
		browser.verifyText(confirmationMessage, OperatorDetailsPageProp.getdeleteOperatorConfirmMessage());
	}
	
	public void verifycancelButtonInConfirmationPopup() throws Exception{
		logger.info("verifying cancel button in delete confirmation popup");
		logger.info("clicking cancel button");
		browser.click(confirmationCancelButton);
		logger.info("verifying add operator link is visible");
		browser.verifyVisible(addOperatorLink);
	}
	
	public void clickOkInDeleteConfirmation() throws Exception{
		logger.info("waiting for the confirmation ok button to be clickable");
		browser.waitForEditable(confirmationOkButton);
		logger.info("clicking ok in confirmation button");
		browser.Wait(1);
		browser.click(confirmationOkButton);
	}
	
	public void verifyMessageForDeleteOperatorPopup() throws Exception{
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(OperatorDetailsPageProp.getdeleteOperatorMessage());
	}
	
	public void searchDeletedOperatorAndVerifyOperatorIsInActive() throws Exception{
		logger.info("searching delete operator and verifyng operator is inactive");
		logger.info("waiting for the search by name radio to be clickable");
		browser.waitForEditable(searchByNameRadio);
		logger.info("typing '"+createdOperator+"' in search text box");
		browser.clearAndType(searchTextBox, createdOperator);
		logger.info("clicking search text link");
		browser.click(searchTextLink);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		Iterator<WebElement> userList = userFullNameList.iterator();
		int i=0;
		boolean verifiedStatus = false;
		while(userList.hasNext()){
			WebElement eachUser = userList.next();
			if(browser.isVisible(eachUser)){
				verifiedStatus = true;
				browser.verifyAttribute(operatorStatusList.get(i), "title", "Inactive");
				break;
			}
			i++;
		}
		browser.verifyTrue(verifiedStatus,"could not verify status for user");
	}
	
}
