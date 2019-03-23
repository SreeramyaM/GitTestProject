package org.fwcms.pages.tc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportDetailsPage {
	
private static final Logger logger = LogManager.getLogger(WorkerDataQualityPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public PassportDetailsPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public PassportDetailsPage initElements() {
		return PageFactory.initElements(driver, PassportDetailsPage.class);
	}
	
	@FindBy(xpath="//div[contains(@class,'registrations_list_container')]//div[@class='listRow'][1]/div[2]/p")
	private WebElement textRegistrationId;
	
	@FindBy(xpath="//div[contains(@class,'registrations_list_container')]//div[@class='listRow'][1]")
	private WebElement firstWorkerInList;
	
	@FindBy(id="wrk_full_name")	
	private WebElement textFullName;
	
	@FindBy(css="div[id='dk_container_wrk_gender']>a")
	private WebElement dropDownGender;
	
	@FindBy(css="a[data-dk-dropdown-value='M']")
	private WebElement dropDownGenderValueMale;
	
	@FindBy(id="wrk_dob_date")
	private WebElement textDateOfBirth;
	
	@FindBy(id="wrk_passport_num")
	private WebElement textPassportNumber;
	
	@FindBy(id="wrk_pp_issue_date")
	private WebElement textPassportIssuedDate;
	
	@FindBy(id="wrk_pp_exp_date")
	private WebElement textPassportExpiryDate;
	
	@FindBy(css="div[id='dk_container_wrk_nationality']>a")
	private WebElement dropDownNationality;
	
	@FindBy(css="a[data-dk-dropdown-value='INDONESIA']")
	private WebElement dropDwonNationalityValueIndonesia;
	
	@FindBy(id="declaration_check")
	private WebElement checkBoxDeclaration;
	
	@FindBy(xpath="//span[text()='Submit']")
	private WebElement buttonSubmit;
	
	@FindBy(linkText="Sign Out")
	private WebElement linkSignOut;
	
	//Method to select a worker for verification
	public String selectWorkerForVerification() throws Exception {
		logger.info("Selecting the worker for verification");
		String regId=browser.getText(textRegistrationId);
		browser.click(firstWorkerInList);
		return regId;
	}
	
	//Method to fill in the passport details
	public void enterPassportDetails(String fullName, String dateOfBirth, String passportNo, String passportIssuedDate, String passportExpiryDate) throws Exception {
		logger.info("waiting for Full Name field to be editable");
		browser.waitForEditable(textFullName);
		logger.info("Typing "+fullName+" in the full name field");
		browser.type(textFullName, fullName);
		logger.info("Selecting male in gender dropdown");
		browser.click(dropDownGender);
		browser.executeJavascript(dropDownGenderValueMale, "arguments[0].click();");
		logger.info("Typing "+dateOfBirth+" in the date of birth field");
		browser.type(textDateOfBirth, dateOfBirth);
		logger.info("Typing "+passportNo+" in the passport number field");
		browser.type(textPassportNumber, passportNo);
		logger.info("Typing "+passportIssuedDate+" in the issued on field");
		browser.type(textPassportIssuedDate, passportIssuedDate);
		logger.info("Typing "+passportExpiryDate+" in the expires on field");
		browser.type(textPassportExpiryDate, passportExpiryDate);
		logger.info("Selecting Indonesia from nationality dropdown");
		browser.click(dropDownNationality);
		browser.executeJavascript(dropDwonNationalityValueIndonesia, "arguments[0].click();");
				
	}
	
	//Method to verify the worker passport details as Bestinet Operator User
	public void verifyWorkerPassportDetails() throws Exception {
		logger.info("Selecting the checkbox, All details are verified and entered accordingly.");
		browser.click(checkBoxDeclaration);
		logger.info("Verifying if the submit button is visible on selecting the declaration checkbox");
		browser.verifyVisible(buttonSubmit);
		logger.info("Cicking on submit button");
		browser.click(buttonSubmit);
	}
	
	//Method to verify the success message and close the status bar
	public void verifySuccessMessage(String successMessage) throws Exception {
		logger.info("Verifying the success message");
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(successMessage);
	}
	
	//Method to click on Sign Out link
	public void clickSignOutLink() throws Exception{
		logger.info("Clicking on sign out");
		browser.click(linkSignOut);
	}
	
}
