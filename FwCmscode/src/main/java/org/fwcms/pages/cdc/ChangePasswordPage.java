package org.fwcms.pages.cdc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.json.JSONArray;
import org.openqa.selenium.Keys;
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
	
	public ChangePasswordPage initElements()
	{
		return PageFactory.initElements(driver, ChangePasswordPage.class);
	}
	
	@FindBy(className="pageHeading")
	private WebElement pageHeading;
	
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
	
	@FindBy(css="div[id='change_password_first_time']>span:nth-child(2)>span")
	private WebElement submitButton;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	public void verifyPageTitleContains(String verifyPageTitleContains) throws Exception{
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		logger.info("verifying page title");
		String title = browser.getTitle();
		if(!title.contains(verifyPageTitleContains)){
			browser.verifyFail("Page title is not matching Expected : "+verifyPageTitleContains+", Actual : "+title);
		}
	}
	
	public void clickSignOut() throws Exception{
		logger.info("clicking sign out");
		browser.click(signOut);
	}
	
	public void changePassword(String oldPassword,String newPassword,String confirmPassword, String changedPasswordExpectedMessage) throws Exception{
		logger.info("changing password of new user");
		logger.info("typing old password");
		browser.type(oldPasswordText, oldPassword);
		logger.info("typing new password");
		browser.type(newPasswordText, newPassword);
		logger.info("typing confirm password");
		browser.type(confirmPasswordText, confirmPassword);
		logger.info("clicking submit button");
		confirmPasswordText.sendKeys(Keys.ENTER);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBar(changedPasswordExpectedMessage);
	}
	
	public void validateOldPasswordFieldOnSubmitClick(JSONArray invaliedPasswords) throws Exception{
		logger.info("validating old password field");
		for (int i = 0; i < invaliedPasswords.length(); i++) {
			String password = invaliedPasswords.getString(i);
			logger.info("moving focus to old password field");
			browser.focus(oldPasswordText);
			logger.info("typing '"+password+"' in old password field");
			browser.clearAndType(oldPasswordText, password);
			logger.info("clicking submit button");
			//browser.click(submitButton);
			oldPasswordText.sendKeys(Keys.ENTER);
			logger.info("waiting for the old password field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(oldPasswordFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
		oldPasswordText.sendKeys(Keys.TAB);
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
			newPasswordText.sendKeys(Keys.ENTER);
			logger.info("waiting for the new password field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(newPasswordFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
		newPasswordText.sendKeys(Keys.TAB);
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
			confirmPasswordText.sendKeys(Keys.ENTER);
			logger.info("waiting for the confirm password field error to be visible");
			browser.Wait(1);
			browser.verifyVisible(confirmPasswordFormError);
			logger.info("sleeping for 1 sec");
			browser.Wait(1);
		}
	}
	
}
