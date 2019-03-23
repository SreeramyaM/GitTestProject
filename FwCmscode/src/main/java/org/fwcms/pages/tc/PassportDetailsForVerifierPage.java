package org.fwcms.pages.tc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportDetailsForVerifierPage {
	
private static final Logger logger = LogManager.getLogger(WorkerDataQualityPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public PassportDetailsForVerifierPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public PassportDetailsForVerifierPage initElements() {
		return PageFactory.initElements(driver, PassportDetailsForVerifierPage.class);
	}
	
	@FindBy(id="registrationNumber")
	private WebElement textRegistrationId;
	
	//@FindBy(css="div[class='registrations_list_container']>div")
	@FindBy(css="div[class='registrations_list_container']>div:nth-child(2)")
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
	
	@FindBy(css="div[id='fname1']>span[class='display_label']")
	private WebElement labelFullNamePresentInMC;
	
	@FindBy(css="div[id='gender2']>span[class='display_label']")
	private WebElement labelGenderEnteredByOperator;
	
	@FindBy(css="div[id='dob1']>span[class='display_label']")
	private WebElement labelDateOfBirthPresentInMC;
	
	@FindBy(css="div[id='passport_num2']>span[class='display_label']")
	private WebElement labelPassportNoEnteredByOperator;
	
	@FindBy(css="div[id='pp_issue_date1']>span[class='display_label']")
	private WebElement labelIssuedOnPresentInMC;
	
	@FindBy(css="div[id='pp_exp_date2']>span[class='display_label']")
	private WebElement labelExpiryDateEnteredByOperator;
	
	@FindBy(css="div[id='nationality1']>span[class='display_label']")
	private WebElement labelNationalityPresentInMC;
	
	//Method to select a worker for verification
	public void selectWorkerForVerification(String regId) throws Exception {
		logger.info("Selecting the worker for verification");
		browser.click(driver.findElement(By.xpath("//p[contains(text(),'"+regId+"')]")));
	}
	
	//Method to select the passport details of worker as Bestinet Privileged User
	public void selectWorkerPassportDetails() throws Exception {
		logger.info("Selecting full name captured at medical center");
		browser.click(labelFullNamePresentInMC);
		logger.info("Selecting gender entered by operator");
		browser.click(labelGenderEnteredByOperator);
		logger.info("Selecting dob captured at medical center");
		browser.click(labelDateOfBirthPresentInMC);
		logger.info("Selecting passport number entered by operator");
		browser.click(labelPassportNoEnteredByOperator);
		logger.info("Selecting issued date captured at medical center");
		browser.click(labelIssuedOnPresentInMC);
		logger.info("Selecting expiry date entered by operator");
		browser.click(labelExpiryDateEnteredByOperator);
		logger.info("Selecting nationality captured at medical center");
		browser.click(labelNationalityPresentInMC);
	}
	
	//Method to verify the worker passport details as Bestinet Privileged User
	public void verifyWorkerPassportDetails() throws Exception {
		logger.info("Selecting the checkbox, All details are verified and entered accordingly.");
		browser.click(checkBoxDeclaration);
		logger.info("Verifying if the submit button is visible on selecting the declaration checkbox");
		browser.verifyVisible(buttonSubmit);
		logger.info("Cicking on submit button");
		browser.click(buttonSubmit);
		browser.Wait(1);
	}
	
	//Method to verify the success message and close the status bar
	public void verifySuccessMessage(String successMessage) throws Exception {
			browser.Wait(2);
			logger.info("Verifying the success message");
			new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(successMessage);
		}
	
	
	//Method to click on Sign Out link
	public void clickSignOutLink() throws Exception{
		logger.info("Clicking on sign out");
		browser.click(linkSignOut);
	}
	

}
