package org.fwcms.pages.cdc.employer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PICPage {

	private static final Logger logger = LogManager.getLogger(PICPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public PICPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public PICPage initElements()
	{
		return PageFactory.initElements(driver, PICPage.class);
	}
	
	@FindBy(xpath="//div[@class='tcoperatorContainer_employer']/div[contains(@class,'pic_details')][1]")
	private WebElement PICone;
	
	@FindBy(xpath="//div[@class='tcoperatorContainer_employer']/div[contains(@class,'pic_details')][2]")
	private WebElement PICtwo;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][1]//span[@id='pic_details_fullname1']")
	private WebElement PIConeFullName;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][2]//span[@id='pic_details_fullname1']")
	private WebElement PICtwoFullName;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][1]//span[@id='pic_details_designation1']")
	private WebElement PIConeDesignation;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][2]//span[@id='pic_details_designation1']")
	private WebElement PICtwoDesignation;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][1]//span[@id='pic_details_email1']")
	private WebElement PIConeEmail;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][2]//span[@id='pic_details_email1']")
	private WebElement PICtwoEmail;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][1]//span[@id='pic_details_mobileno1']")
	private WebElement PIConeMobile;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][2]//span[@id='pic_details_mobileno1']")
	private WebElement PICtwoMobile;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][1]//span[@id='pic_details_status1']")
	private WebElement PIConeStatus;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][2]//span[@id='pic_details_status1']")
	private WebElement PICtwoStatus;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][1]//span[@class='btnText_reg']")
	private WebElement PIConeCredentialsButton;
	
	@FindBy(xpath="//div[contains(@class,'pic_details_container')][2]//span[@class='btnText_reg']")
	private WebElement PICtwoCredentialsButton;
	
	@FindBy(id="employerPICNote")
	private WebElement employerPICNoteText;
	
	/** =========== Perform actions ================== 
	 * @throws Exception */
	
	public void verifyPIConeDetails() throws Exception
	{
		logger.info("Verify PIC one details displayed");
		browser.verifyElementPresent(PICone);
		browser.verifyElementPresent(PIConeFullName);
		browser.verifyElementPresent(PIConeEmail);
		browser.verifyElementPresent(PIConeMobile);
		browser.verifyElementPresent(PIConeStatus);
		browser.verifyEditable(PIConeCredentialsButton);
	}
	
	public void verifyPICtwoDetails() throws Exception
	{
		logger.info("Verify PIC two details displayed");
		browser.verifyElementPresent(PICtwo);
		browser.verifyElementPresent(PICtwoFullName);
		browser.verifyElementPresent(PICtwoEmail);
		browser.verifyElementPresent(PICtwoMobile);
		browser.verifyElementPresent(PICtwoStatus);
		browser.verifyEditable(PICtwoCredentialsButton);
	}
	
	public boolean isPICtwoPresent()
	{
		logger.info("Check if rep two is present");
		return browser.isElementPresent(PICtwo);
	}
	public void VerifyNoteMessage() throws Exception
	{
		logger.info("Verify note message displayed");
		browser.verifyText(employerPICNoteText, "Note: To Add/ Modify/ Delete PIC details, kindly get updated by contacting Jabatan Imigresen Malaysia.");
	}
}
