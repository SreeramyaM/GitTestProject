package org.fwcms.pages.tc;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.prop.tc.ForgotPasswordPageProp;
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
	
	@FindBy(css="div[id='confirm_pass']>span:nth-child(2)>span")
	private WebElement submitButton;
	
	@FindBy(css="div[id='cancel_ch_password']>span:nth-child(2)>span")
	private WebElement cancelButton;
	
	@FindBy(css="div[id='dk_container_select_qus']>a>span")
	private WebElement securityQuestionSelect;
	
	@FindBy(css="div[id='dk_container_select_qus']>div>ul>li>a")
	private List<WebElement> securityQuestionOptionsList;
	
	@FindBy(id="validatetext")
	private WebElement answerText;
	
	@FindBy(css="div[id='reset_pfwd']>span:nth-child(2)>span")
	private WebElement resetSubmitButton;
	
	@FindBy(css="div[id='cancel_sq_password']>span:nth-child(2)>span")
	private WebElement resetCancelButton;
	
	@FindBy(id="error")
	private WebElement errorMessage;
	
	public void verifyPageHeader(String pageHeaderExpectedData) throws Exception{
		logger.info("verifying page header");
		browser.verifyText(pageHeading, pageHeaderExpectedData);
	}
	
	public void verifyElementsPresentInForgotPasswordPage() throws Exception{
		logger.info("verifying elements in forgot password page");
		logger.info("verify username field visible");
		browser.verifyVisible(userNameText);
		logger.info("verify registered email field visible");
		browser.verifyVisible(registeredEmailText);
		logger.info("verify registered mobile field visible");
		browser.verifyVisible(registeredMobileNumberText);
		logger.info("verify submit button visible");
		browser.verifyVisible(submitButton);
		logger.info("verify cancel button visible");
		browser.verifyVisible(cancelButton);
	}
	
	public void clickCancelButton() throws Exception{
		logger.info("clicking on the cancel button");
		browser.click(cancelButton);
	}
	
	public void waitForUserNameToVisible(){
		logger.info("waiting for user name to be visible");
		browser.waitForVisible(userNameText);
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
			browser.Wait(1);
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
			browser.Wait(1);
			logger.info("clicking submit button");
			browser.click(submitButton);
			browser.Wait(1);
			browser.verifyVisible(registeredMobileNumberFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void enterDetailsInForgotPasswordFormAndClickSubmit(String userName,String registeredEmail,String registeredMobile) throws Exception{
		logger.info("entering data in forgot password form");
		logger.info("typing userName '"+userName+"' in user name field");
		browser.clearAndType(userNameText, userName);
		logger.info("typing registeredEmail '"+registeredEmail+"' in registered email field");
		browser.clearAndType(registeredEmailText, registeredEmail);
		logger.info("typing registeredMobile '"+registeredMobile+"' in registered mobile field");
		browser.clearAndType(registeredMobileNumberText, registeredMobile);
		logger.info("clicking submit button");
		browser.click(submitButton);
	}
	
	public void verifyInvaliedOldPassword() throws Exception{
		logger.info("waiting for server side error message to be visible");
		browser.waitForVisible(errorMessage);
		String message = ForgotPasswordPageProp.getinvaliedDetailsError();
		logger.info("verifying text '"+message+"', should be in error message");
		browser.verifyText(errorMessage, message);
	}
	
	public void verifySecurityQuestionAndAnswer() throws Exception{
		logger.info("verifying elements in security question form");
		logger.info("waiting for security question to be visible");
		browser.waitForVisible(securityQuestionSelect);
		logger.info("verifying answer text is visible");
		browser.verifyVisible(answerText);
	}
	
	public void selectSecurityQuestionAndAnswerIt(String questionName, String answer) throws Exception{
		logger.info("trying to answer security question");
		logger.info("waiting for the security question to visible");
		browser.waitForVisible(securityQuestionSelect);
		logger.info("clicking security question to expand options");
		browser.click(securityQuestionSelect);
		boolean foundQuestion = false;
		Iterator<WebElement> questions = securityQuestionOptionsList.iterator();
		while(questions.hasNext()){
			WebElement eachQuestion = questions.next();
			if(browser.getText(eachQuestion).equals(questionName)){
				logger.info("question in the list found");
				foundQuestion = true;
				logger.info("selecting question");
				browser.executeJavascript(eachQuestion, "arguments[0].click();");
				break;
			}
		}
		browser.assertTrue(foundQuestion, "Question in the list not found");
		logger.info("typing answer '"+answer+"' in answer field");
		browser.Wait(1);
		browser.type(answerText, answer);
	}
	
	public void clickCancelButtonInSecurityQuestion() throws Exception{
		logger.info("clicking cancel button of security question");
		browser.click(resetCancelButton);
	}
	
	public void clickSubmitButtonInSecurityQuestion() throws Exception{
		logger.info("clicking submit button of security question");
		browser.click(resetSubmitButton);
	}
	
}
