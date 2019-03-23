package org.fwcms.pages.cdc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.fwcms.prop.cdc.ForgotPasswordPageProp;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	private static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public ForgotPasswordPage initElements()
	{
		return PageFactory.initElements(driver, ForgotPasswordPage.class);
	}
	
	@FindBy(className="pageHeading")
	private WebElement pageHeading;
	
	@FindBy(id="userName")
	private WebElement userNameText;
	
	@FindBy(css="div[class^='userNameformError']>div[class='formErrorContent']")
	private WebElement userNameFormError;
	
	@FindBy(id="email")
	private WebElement registeredEmailText;
	
	@FindBy(css="div[class^='emailformError']>div[class='formErrorContent']")
	private WebElement registeredEmailFormError;
	
	@FindBy(id="contactNumber")
	private WebElement registeredMobileNumberText;
	
	@FindBy(css="div[class^='contactNumberformError']>div[class='formErrorContent']")
	private WebElement registeredMobileNumberFormError;
	
	@FindBy(css="div[id='cancel_f_password']>span:nth-child(2)>span")
	private WebElement cancelButton;
	
	@FindBy(css="div[id='forgot_password']>span:nth-child(2)>span")
	private WebElement submitButton;
	
	public void verifyPageHeader() throws Exception{
		logger.info("verifying page header");
		browser.verifyText(pageHeading, ForgotPasswordPageProp.getpageHeader());
	}
	
	public void verifyElementsPresentInForgotPasswordForm() throws Exception{
		logger.info("verifying elements in forgot password form");
		logger.info("verifying username field visible");
		browser.verifyVisible(userNameText);
		logger.info("verifying registered email field visible");
		browser.verifyVisible(registeredEmailText);
		logger.info("verifying registered mobile field visible");
		browser.verifyVisible(registeredMobileNumberText);
		logger.info("verifying submit button visible");
		browser.verifyVisible(submitButton);
		logger.info("verifying cancen button visible");
		browser.verifyVisible(cancelButton);
	}
	
	public void validateUserNameFieldOnSubmitClick(JSONArray invaliedUserNames) throws Exception{
		logger.info("validating username field");
		for (int i = 0; i < invaliedUserNames.length(); i++) {
			String userName = invaliedUserNames.getString(i);
			logger.info("moving focus to username field");
			browser.focus(userNameText);
			logger.info("typing '"+userName+"' in username field");
			browser.clearAndType(userNameText, userName);
			logger.info("clicking submit button");
			browser.click(submitButton);
			logger.info("waiting for the username field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(userNameFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(2);
		}
	}
	
	public void validateRegisteredEmailFieldOnSubmitClick(JSONArray invaliedEmails) throws Exception{
		logger.info("validating registered email field");
		for (int i = 0; i < invaliedEmails.length(); i++) {
			logger.info("moving focus to registered email field");
			browser.focus(registeredEmailText);
			String email = invaliedEmails.getString(i);
			logger.info("typing '"+email+"' in registered email field");
			browser.clearAndType(registeredEmailText, email);
			logger.info("clicking submit button");
			browser.click(submitButton);
			browser.Wait(1);
			browser.verifyVisible(registeredEmailFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void validateRegisteredMobileFieldOnSubmitClick(JSONArray invaliedMobileNumbers) throws Exception{
		logger.info("validating registered mobile field");
		for (int i = 0; i < invaliedMobileNumbers.length(); i++) {
			logger.info("moving focus to registered mobile field");
			browser.focus(registeredMobileNumberText);
			String mobileNumber = invaliedMobileNumbers.getString(i);
			logger.info("typing '"+mobileNumber+"' in registered mobile field");
			browser.clearAndType(registeredMobileNumberText, mobileNumber);
			logger.info("clicking submit button");
			browser.click(submitButton);
			browser.Wait(1);
			browser.verifyVisible(registeredMobileNumberFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void forgotPasswordFunctionality(String userNameData, String emailData, String mobileNumberData, String successExpectedData) throws Exception{
		logger.info("checking forgot password functionality");
		logger.info("typing username '"+userNameData+"'");
		browser.type(userNameText, userNameData);
		logger.info("typing email '"+emailData+"'");
		browser.type(registeredEmailText, emailData);
		logger.info("typing mobile number '"+mobileNumberData+"'");
		browser.type(registeredMobileNumberText, mobileNumberData);
		logger.info("clicking submit");
		//registeredMobileNumberText.sendKeys(Keys.ENTER);
		browser.click(submitButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar(successExpectedData);
	}
	
}
