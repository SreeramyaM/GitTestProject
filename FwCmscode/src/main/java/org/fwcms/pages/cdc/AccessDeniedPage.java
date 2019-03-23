package org.fwcms.pages.cdc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessDeniedPage {
	
	private static final Logger logger = LogManager.getLogger(AccessDeniedPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public AccessDeniedPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public AccessDeniedPage initElements()
	{
		return PageFactory.initElements(driver, AccessDeniedPage.class);
	}
	
	@FindBy(className="error-msg")
	private WebElement errorMessage;
	
	@FindBy(linkText="Back to login")
	private WebElement backToLoginLink;
	
	public void verifyErrorMessageVisible() throws Exception{
		logger.info("verifying access denied is visible");
		browser.Wait(1);
		browser.verifyVisible(errorMessage);
	}
	
	public void verifyErrorMessageText() throws Exception{
		logger.info("verifying error message text");
		browser.Wait(1);
		browser.verifyText(errorMessage, "Access denied - you are not authorized to access this page");
	}
	
	public void clickBackToLogin() throws Exception{
		logger.info("waiting for back to login link to be visible");
		browser.waitForVisible(backToLoginLink);
		logger.info("clicking back to login link");
		browser.click(backToLoginLink);
	}
	
}
