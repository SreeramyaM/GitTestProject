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

public class MetaDataConfigurationPage extends CommonElements{
	
	private static final Logger logger = LogManager.getLogger(MetaDataConfigurationPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public MetaDataConfigurationPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		browser = new BrowserBot(driver);
		
	}
	
	public MetaDataConfigurationPage initElements()
	{
		return PageFactory.initElements(driver, MetaDataConfigurationPage.class);
	}
	
	@FindBy(id="list_metadata_btn")
	private WebElement metaDataSearchButton;
	
	@FindBy(id="add_metadata_btn")
	private WebElement addMetaDataButton;
	
	//@FindBy(css="div[id='dk_container_metadata']>a>span")
	@FindBy(id="dk_container_metadata")
	private WebElement selectWidget;
	
	@FindBy(className="dk_options_inner")
	private WebElement selectOptions;
	
	@FindBy(css="ul[class='dk_options_inner']>li>a")
	private WebElement showAllOption;
	
	@FindBy(css="ul[class='dk_options_inner']>li>a")
	private List<WebElement> metaDataOptionsList;
	
	@FindBy(id="list_metadata")
	private WebElement listMetaDataRadio;
	
	@FindBy(css="input[id='add_metadata']")
	private WebElement addMetaDataRadio;
	
	@FindBy(id="metadata_value")
	private WebElement valueTextBox;
	
	@FindBy(id="metadata_desc")
	private WebElement descriptionTextBox;
	
	@FindBy(css="span[class='refresh_text']>a")
	private WebElement refreshListLink;
	
	@FindBy(id="metadata_val")
	private WebElement metaDataSearchTextBox;
	
	@FindBy(css="span[id='search_value']>a")
	private WebElement searchLink;
	
	@FindBy(id="workers_count")
	private WebElement totalEntriesCount;
	
	@FindBy(css="div[class='passport_td_field data']")
	private List<WebElement> metaDataValuesList;
	
	@FindBy(className="grid_edit_icon")
	private List<WebElement> editIconsList;
	
	@FindBy(className="grid_delete_icon")
	private List<WebElement> deleteIconsList;
	
	@FindBy(className="noresults")
	private WebElement noResults;
	
	@FindBy(id="metadata_modify")
	private WebElement editPopup;
	
	@FindBy(id="metadata_edit_type")
	private WebElement typeTextBoxInEditPopup;
	
	@FindBy(id="metadata_edit_value")
	private WebElement valueTextBoxInEditPopup;
	
	@FindBy(id="metadata_edit_desc")
	private WebElement descriptionTextBoxInEditPopup;
	
	@FindBy(css="div[id='edit_metadata']>span:nth-child(2)>span")
	private WebElement saveButtonInEditPopup;
	
	@FindBy(css="div[id='cancel_edit_metadata']>span:nth-child(2)>span")
	private WebElement cancelButtonInEditPopup;
	
	@FindBy(css="div[class^='modalPopup']")
	private WebElement deleteConfirmation;
	
	@FindBy(className="confirm_alert")
	private WebElement deleteConfirmationText;
	
	@FindBy(css="div[id='delete_metadata']>span:nth-child(2)>span")
	private WebElement yesButtonInDeletePopup;
	
	@FindBy(css="div[id='dont_delete_metadata']>span:nth-child(2)>span")
	private WebElement noButtonInDeletePopup;
	
	private String createdMetaData = null;
	
	public void verifyElementPresentAndDefaultSelectedOnFirstVisitToThisPage() throws Exception{
		logger.info("verifying elements present and default selected on first visit to this page");
		browser.verifyVisible(selectWidget);
		browser.verifyVisible(metaDataSearchButton);
		browser.verifyVisible(listMetaDataRadio);
		browser.verifyVisible(addMetaDataRadio);
		browser.verifyChecked(listMetaDataRadio);
	}
	
	public void verifySelectOptionsVisibleAndInvisibleOnclickOfSelectWidget() throws Exception{
		logger.info("verifying select options visible on click of select widget");
		browser.waitForEditable(selectWidget);
		browser.Wait(3);
		browser.click(selectWidget);
		browser.verifyVisible(selectOptions);	
		browser.click(selectWidget);
		browser.Wait(3);
		browser.verifyNotVisible(selectOptions);
	}
	
	public void addMetaDataConfiguration(String  metaDataType, String value, String description) throws Exception{
		logger.info("adding meta data configuration");
		browser.click(selectWidget);
		browser.waitForVisible(selectOptions);
		Iterator<WebElement> metaDataOptions = metaDataOptionsList.iterator();
		 
		boolean selectedMetaDataOption = false;
		while(metaDataOptions.hasNext()){
			WebElement eachElement = metaDataOptions.next();
			String elementText = browser.getText(eachElement);
			if(elementText.equals(metaDataType)){
				selectedMetaDataOption = true;
				browser.click(eachElement);
				break;
			}
		}
		browser.verifyTrue(selectedMetaDataOption, "No meta data type option for the given name "+metaDataType);
		
		browser.check(addMetaDataRadio);
		browser.verifyChecked(addMetaDataRadio);
		browser.waitForEditable(valueTextBox);
		browser.waitForEditable(descriptionTextBox);
		browser.waitForEditable(addMetaDataButton);
		
		browser.typeRandomAlphabets(valueTextBox, value, 6);
		createdMetaData = browser.getValue(valueTextBox);
		browser.type(descriptionTextBox, description);
		browser.click(addMetaDataButton);
		waitForOverlayToHide();
		waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar("Successfully saved the meta data.");
	}
	
	public void clickShowAllInOptions() throws Exception{
		logger.info("clicking show all in select options");
		browser.waitForEditable(selectWidget);
		browser.click(selectWidget);
		browser.click(showAllOption);
		browser.verifyVisible(metaDataSearchButton);
		browser.verifyNotVisible(addMetaDataButton);
		browser.verifyChecked(listMetaDataRadio);
		browser.verifyNotChecked(addMetaDataRadio);
	}
	
	public void searchByShowAllAndVerifyCreatedMetaDataInList() throws Exception{
		logger.info("searching by show all and verify created meta data");
		browser.waitForEditable(metaDataSearchButton);
		browser.click(metaDataSearchButton);
		waitForOverlayToHide();
		searchByMetaData(createdMetaData);
	}
	
	public void searchByMetaDataTypeAndVerifyCreatedMetaDataInList(String metaDataType) throws Exception{
		logger.info("searching by meta data type and verifying created meta data in list");
		browser.waitForEditable(metaDataSearchButton);
		browser.waitForEditable(selectWidget);
		browser.click(selectWidget);
		browser.waitForVisible(selectOptions);
		
		Iterator<WebElement> metaDataOptions = metaDataOptionsList.iterator();
		boolean selectedMetaDataOption = false;
		while(metaDataOptions.hasNext()){
			WebElement eachElement = metaDataOptions.next();
			String elementText = browser.getText(eachElement);
			if(elementText.equals(metaDataType)){
				selectedMetaDataOption = true;
				browser.click(eachElement);
				break;
			}
		}
		browser.verifyTrue(selectedMetaDataOption, "No meta data type option for the given name "+metaDataType);
		
		browser.click(metaDataSearchButton);
		waitForOverlayToHide();
		searchByMetaData(createdMetaData);
	}
	
	public void searchByMetaData(String metadata) throws Exception{
		logger.info("searching by meta data and will click first visible");
		browser.waitForEditable(metaDataSearchTextBox);
		browser.clearAndType(metaDataSearchTextBox, metadata);
		browser.click(searchLink);
		browser.Wait(2);
		
		Iterator<WebElement> metaDataValues = metaDataValuesList.iterator();
		boolean comparedMetaData = false;
		while(metaDataValues.hasNext()){
			WebElement eachElement = metaDataValues.next();
			if(browser.isVisible(eachElement)){
				comparedMetaData = true;
				String elementText = browser.getText(eachElement);
				logger.info("comparing "+metadata+" with "+elementText+" in the existing list");
				if(!elementText.equalsIgnoreCase(metadata)){
					browser.verifyFail("Expected name '"+metadata+"' not matching in the users list");
				}
				break;
			}
		}
		browser.verifyTrue(comparedMetaData, "No data for the given name "+metadata);
	}
	
	public void clickEditIconFirstVisibleMetaDataInList() throws Exception{
		logger.info("clicking on the edit icon for first visible meta data in list");
		Iterator<WebElement> actionEditIcons = editIconsList.iterator();
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
	
	public void clickDeleteIconFirstVisibleMetaDataInList() throws Exception{
		logger.info("clicking on the delete icon for first visible meta data in list");
		Iterator<WebElement> actionDeleteIcons = deleteIconsList.iterator();
		boolean clickedIcon = false;
		while(actionDeleteIcons.hasNext()){
			WebElement eachIcon =  actionDeleteIcons.next();
			if(browser.isVisible(eachIcon)){
				clickedIcon = true;
				browser.click(eachIcon);
				break;
			}
		}
		browser.assertTrue(clickedIcon, "Could not click any delete icon");
	}
	
	public void verifyEditMetaDataModelElements() throws Exception{
		logger.info("verifying elements present and default data in edit meta data model");
		browser.waitForVisible(editPopup);
		browser.verifyVisible(typeTextBoxInEditPopup);
		browser.verifyNotEditable(typeTextBoxInEditPopup);
		browser.verifyEditable(valueTextBoxInEditPopup);
		browser.verifyEditable(descriptionTextBoxInEditPopup);
		browser.verifyEditable(saveButtonInEditPopup);
		browser.verifyEditable(cancelButtonInEditPopup);
	}
	
	public void verifyingValuesInEditMetaDataModelAfterCreatingNewMetaData(String metaDataType, String description) throws Exception{
		logger.info("verifying Values In Edit Meta Data Model After Creating New Meta Data");
		browser.waitForVisible(editPopup);
		browser.verifyValue(typeTextBoxInEditPopup, metaDataType);
		browser.verifyValue(valueTextBoxInEditPopup, createdMetaData);
		browser.verifyValue(descriptionTextBoxInEditPopup, description);
	}
	
	public void verifyingCancelButtonInEditPopup() throws Exception{
		logger.info("verifying cancel button in edit popup");
		browser.waitForEditable(cancelButtonInEditPopup);
		browser.click(cancelButtonInEditPopup);
		browser.waitForNotVisible(editPopup);
		browser.verifyVisible(listMetaDataRadio);
		browser.verifyVisible(refreshListLink);
		browser.verifyNotVisible(editPopup);
	}
	
	public void editDescriptionInEditPopupAndVerifyEditedDescription() throws Exception{
		logger.info("edit description in edit popup and verify edited description");
		browser.waitForVisible(editPopup);
		browser.typeRandomAlphabets(descriptionTextBoxInEditPopup);
		String editedDescription = browser.getValue(descriptionTextBoxInEditPopup);
		browser.click(saveButtonInEditPopup);
		waitForOverlayToHide();
		waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Successfully updated the meta data.");
		searchByShowAllAndVerifyCreatedMetaDataInList();
		clickEditIconFirstVisibleMetaDataInList();
		browser.waitForVisible(editPopup);
		browser.verifyValue(descriptionTextBoxInEditPopup, editedDescription);
		browser.click(cancelButtonInEditPopup);
	}
	
	public void editValueInEditPopupAndVerifyEditedValue() throws Exception{
		logger.info("edit value in edit popup and verify edited value");
		browser.waitForVisible(editPopup);
		browser.typeRandomAlphabets(valueTextBoxInEditPopup,5);
		createdMetaData = browser.getValue(valueTextBoxInEditPopup);
		browser.click(saveButtonInEditPopup);
		waitForOverlayToHide();
		waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Successfully updated the meta data.");
		searchByShowAllAndVerifyCreatedMetaDataInList();
		clickEditIconFirstVisibleMetaDataInList();
		browser.waitForVisible(editPopup);
		browser.verifyValue(valueTextBoxInEditPopup, createdMetaData);
		browser.click(cancelButtonInEditPopup);
	}
	
	public void editValueAndDescriptionInEditPopupAndVerifyEditedValues() throws Exception{
		logger.info("edit value and description in edit popup and verify edited values");
		browser.waitForVisible(editPopup);
		browser.typeRandomAlphabets(valueTextBoxInEditPopup,5);
		createdMetaData = browser.getValue(valueTextBoxInEditPopup);
		browser.typeRandomAlphabets(descriptionTextBoxInEditPopup);
		String editedDescription = browser.getValue(descriptionTextBoxInEditPopup);
		browser.click(saveButtonInEditPopup);
		waitForOverlayToHide();
		waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Successfully updated the meta data.");
		searchByShowAllAndVerifyCreatedMetaDataInList();
		clickEditIconFirstVisibleMetaDataInList();
		browser.waitForVisible(editPopup);
		browser.verifyValue(valueTextBoxInEditPopup, createdMetaData);
		browser.verifyValue(descriptionTextBoxInEditPopup, editedDescription);
		browser.click(cancelButtonInEditPopup);
	}
	
	public void verifyDeleteConfirmationPresent() throws Exception{
		logger.info("verifying delete confirmation present");
		browser.waitForVisible(deleteConfirmation);
		browser.verifyText(deleteConfirmationText, "Are you sure that you want to delete the selected metadata?");
		browser.verifyEditable(yesButtonInDeletePopup);
		browser.verifyEditable(noButtonInDeletePopup);
	}
	
	public void verifyingNoButtonInDeleteConfirmation() throws Exception{
		logger.info("verifying no button in delete confirmation");
		browser.waitForEditable(noButtonInDeletePopup);
		browser.click(noButtonInDeletePopup);
		browser.waitForNotVisible(deleteConfirmation);
		browser.verifyNotVisible(noButtonInDeletePopup);
		browser.verifyVisible(listMetaDataRadio);
		browser.verifyVisible(refreshListLink);
	}
	
	public void verifyingYesButtonInDeleteConfirmation() throws Exception{
		logger.info("verifying yes button in delete confirmation");
		browser.waitForEditable(yesButtonInDeletePopup);
		browser.click(yesButtonInDeletePopup);
		waitForOverlayToHide();
		waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Successfully deleted the meta data.");
		browser.waitForEditable(metaDataSearchButton);
		browser.click(metaDataSearchButton);
		waitForOverlayToHide();
		browser.waitForEditable(metaDataSearchTextBox);
		browser.clearAndType(metaDataSearchTextBox, createdMetaData);
		browser.click(searchLink);
		browser.Wait(2);
		browser.verifyVisible(noResults);
	}
	
}
