package org.google.mail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
	
	private static final Logger logger = LogManager.getLogger(GmailLoginPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public GmailLoginPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public GmailLoginPage initElements()
	{
		return PageFactory.initElements(driver, GmailLoginPage.class);
	}
	
	@FindBy(id="Email")
	private WebElement textBoxUserName;
	
	@FindBy(id="next")
	private WebElement buttonNext;
	
	@FindBy(id="Passwd")
	private WebElement textBoxPassword;
	
	@FindBy(id="signIn")
	private WebElement buttonSignIn;
	
	
	//This method is used to login to Gmail
	public void loginToGmail(String userName, String password) throws Exception{
		browser.waitForEditable(textBoxUserName);
		logger.info("Entering gmail user name");
		browser.type(textBoxUserName, userName);
		browser.click(buttonNext);
		logger.info("Clicking on next button");
		browser.waitForEditable(textBoxPassword);
		logger.info("Entering gmail user password");
		browser.type(textBoxPassword, password);
		logger.info("Clicking on signin button");
		browser.click(buttonSignIn);
	}
	
}