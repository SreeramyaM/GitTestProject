package org.fwcms.pages.cdc;

import static com.olo.util.PropertyReader.configProp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	private static final Logger logger = LogManager.getLogger(LogoutPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public LogoutPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public LogoutPage initElements()
	{
		return PageFactory.initElements(driver, LogoutPage.class);
	}
	
	@FindBy(linkText="Back to login")
	private WebElement backToLoginLink;
	
	public void verifyBackToLoginLinkVisible() throws Exception{
		logger.info("verifying back to login link is visible");
		browser.verifyVisible(backToLoginLink);
	}
	
	public void clickBackToLogin() throws Exception{
		logger.info("waiting for back to login link to be visible");
		browser.waitForVisible(backToLoginLink);
		logger.info("clicking back to login link");
		browser.click(backToLoginLink);
	}
	
	public void navigateToLoginPage() throws Exception {
		logger.info("navigating back to login page");
		browser.get(configProp.getProperty("cdcUser"));
	}
	
}
