package org.fwcms.pages.tc;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.fwcms.prop.tc.ChangePasswordPageProp;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	
	private static final Logger logger = LogManager.getLogger(ChangePasswordPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public ChangePasswordPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public ChangePasswordPage initElements() throws Exception
	{
		return PageFactory.initElements(driver, ChangePasswordPage.class);
	}
	
	@FindBy(id="username")
	private WebElement userNameText;
	
	@FindBy(id="oldPassword")
	private WebElement oldPasswordText;
	
	@FindBy(css="div[class^='oldPasswordformError']>div[class='formErrorContent']")
	private WebElement oldPasswordFormError;
	
	@FindBy(id="newPassword")
	private WebElement newPasswordText;
	
	@FindBy(css="div[class^='newPasswordformError']>div[class='formErrorContent']")
	private WebElement newPasswordFormError;
	
	@FindBy(id="cnfPassword")
	private WebElement confirmPasswordText;
	
	@FindBy(css="div[class^='cnfPasswordformError']>div[class='formErrorContent']")
	private WebElement confirmPasswordFormError;
	
	@FindBy(css="div[class='button-container']>span>div>div>span:nth-child(2)>span")
	private WebElement submitButton;
	
	@FindBy(id="error")
	private WebElement errorMessage;
	
	@FindBy(css="form[id='frg_form_popup'] div[class*='ui-widget-header']")
	private WebElement popupHeader;
	
	@FindBy(css="div[id='dk_container_select_qus']>a>span")
	private WebElement securityQuestionSelect;
	
	@FindBy(css="div[class^='dk_container_select_qusformError']>div[class='formErrorContent']")
	private WebElement securityQuestionSelectFormError;
	
	@FindBy(css="div[id='dk_container_select_qus']>div>ul>li>a")
	private List<WebElement> securityQuestionOptionsList;
	
	@FindBy(id="validatetext")
	private WebElement answerText;
	
	@FindBy(css="div[class^='validatetextformError']>div[class='formErrorContent']")
	private WebElement answerTextFormError;
	
	@FindBy(css="div[id='reset_pfwd']>span:nth-child(2)>span")
	private WebElement resetSubmitButton;
	
	public void verifyElementsPresentInChangePasswordPage() throws Exception{
		logger.info("verifying elements in change password page");
		logger.info("verifying username field visible");
		browser.verifyVisible(userNameText);
		logger.info("verifying username field is not editable");
		browser.verifyNotEditable(userNameText);
		logger.info("verifying old password field visible");
		browser.verifyVisible(oldPasswordText);
		logger.info("verifying new password field visible");
		browser.verifyVisible(newPasswordText);
		logger.info("verifying confirm password field visible");
		browser.verifyVisible(confirmPasswordText);
		logger.info("verifying submit button visible");
		browser.verifyVisible(submitButton);
	}
	
	public void validateOldPasswordFieldOnSubmitClick(JSONArray invaliedPasswords) throws Exception{
		logger.info("validating old password field on submit click");
		for (int i = 0; i < invaliedPasswords.length(); i++) {
			String password = invaliedPasswords.getString(i);
			logger.info("moving focus to old password field");
			browser.focus(oldPasswordText);
			logger.info("typing '"+password+"' in old password field");
			browser.clearAndType(oldPasswordText, password);
			logger.info("clicking submit button");
			browser.click(submitButton);
			logger.info("waiting for the old password field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(oldPasswordFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void validateNewPasswordFieldOnSubmitclick(JSONArray invaliedPasswords) throws Exception{
		logger.info("validating new password field");
		for (int i = 0; i < invaliedPasswords.length(); i++) {
			String password = invaliedPasswords.getString(i);
			logger.info("moving focus to new password field");
			browser.focus(newPasswordText);
			logger.info("typing '"+password+"' in new password field");
			browser.clearAndType(newPasswordText, password);
			logger.info("clicking submit button");
			browser.click(submitButton);
			logger.info("waiting for the new password field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(newPasswordFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void validateConfirmPasswordFieldOnSubmitClick(JSONArray invaliedPasswords) throws Exception{
		logger.info("validating confirm password field");
		for (int i = 0; i < invaliedPasswords.length(); i++) {
			String password = invaliedPasswords.getString(i);
			logger.info("moving focus to confirm password field");
			browser.focus(confirmPasswordText);
			logger.info("typing '"+password+"' in confirm password field");
			browser.clearAndType(confirmPasswordText, password);
			logger.info("clicking submit button");
			browser.click(submitButton);
			logger.info("waiting for the confirm password field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(confirmPasswordFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	
	public void verifyInvaliedOldPassword(String message) throws Exception{
		/*
		logger.info("typing oldPasswordData '"+oldPasswordData+"' in old password field");
		browser.clearAndType(oldPasswordText, oldPasswordData);
		
		logger.info("clicking submit button");
		browser.click(submitButton);
		*/
		logger.info("waiting for server side error message to be visible");
		browser.waitForVisible(errorMessage);
		//String message = ChangePasswordPageProp.getinvaliedOldPassword();
		browser.verifyText(errorMessage, message);
	}
	
	public void changePasswordFillDetailsAndClickSubmit(String oldPassword,String newPassword,String confirmPassword) throws Exception{
		logger.info("changing password of new user");
		logger.info("sleeping for 3 sec");
		browser.Wait(3);
		logger.info("typing old password");
		browser.clearAndType(oldPasswordText, oldPassword);
		logger.info("typing new password");
		browser.clearAndType(newPasswordText, newPassword);
		logger.info("typing confirm password");
		browser.clearAndType(confirmPasswordText, confirmPassword);
		logger.info("clicking submit button");
		browser.click(submitButton);

	}
	
	public void validateFirstLoginSecurityQuestion() throws Exception{
		logger.info("validating first login security question");
		logger.info("clicking reset submit button");
		browser.click(resetSubmitButton);
		logger.info("waiting for security question error to be visible");
		browser.waitForVisible(securityQuestionSelectFormError);
		String message = ChangePasswordPageProp.getsecurityQuestionEmpty();
		logger.info("verifying text '"+message+"' should present in securityQuestionSelectFormError");
		browser.verifyText(securityQuestionSelectFormError, message);
	}
	
	public void validateAnswerInSecurityQuestionForm(JSONArray invaliedSecurityAnswers) throws Exception{
		logger.info("validating answer field");
		for (int i = 0; i < invaliedSecurityAnswers.length(); i++) {
			String securityAnswer = invaliedSecurityAnswers.getString(i);
			logger.info("moving focus to answer field");
			browser.waitForEditable(answerText);
			browser.focus(answerText);
			logger.info("typing '"+securityAnswer+"' in answer field");
			browser.clearAndType(answerText, securityAnswer);
			browser.waitForEditable(resetSubmitButton);
			logger.info("clicking submit button");
			browser.click(resetSubmitButton);
			logger.info("waiting for the answer field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(answerTextFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
	public void verifySecurityQuestionAndAnswer() throws Exception{
		logger.info("verifying elements in security question form");
		logger.info("waiting for security question to be visible");
		browser.waitForVisible(securityQuestionSelect);
		logger.info("verifying answer text is visible");
		browser.verifyVisible(answerText);
	}
	
	public void answerFirstTimeQuestion(String questionName,String answer) throws Exception{
		logger.info("answering first time question");
		logger.info("waiting for first time question to visible");
		browser.waitForEditable(securityQuestionSelect);
		//browser.waitForElementNotPresent(securityQuestionSelectFormError);
		logger.info("clicking security question");
		browser.click(securityQuestionSelect);
		logger.info("navigating options list");
		securityQuestionOptionsList.iterator();
		boolean foundQuestion = false;
		Iterator<WebElement> questions = securityQuestionOptionsList.iterator();
		while(questions.hasNext()){
			WebElement eachQuestion = questions.next();
			if(browser.getText(eachQuestion).equals(questionName)){
				logger.info("question in the list found");
				foundQuestion = true;
				logger.info("selecting question");
				logger.info("sleeping for 1 sec");
				browser.Wait(1);
				browser.waitForEditable(eachQuestion);
				browser.executeJavascript(eachQuestion, "arguments[0].click();");
				break;
			}
		}
		browser.assertTrue(foundQuestion, "Question in the list not found");
		logger.info("typing answer '"+answer+"' in answer field");
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		browser.clearAndType(answerText, answer);
		browser.Wait(1);
		logger.info("clicking reset submit button");
		browser.click(resetSubmitButton);
	}
	
	public void verifyMessageAfterChangePassword() throws Exception{
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar(ChangePasswordPageProp.getchangedPasswordSuccess());
	}
	
}
