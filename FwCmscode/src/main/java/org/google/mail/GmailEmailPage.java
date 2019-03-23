package org.google.mail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailEmailPage {
	
	private static final Logger logger = LogManager.getLogger(GmailEmailPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public GmailEmailPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public GmailEmailPage initElements()
	{
		return PageFactory.initElements(driver, GmailEmailPage.class);
	}
	
	@FindBy(xpath="//div[@data-tooltip='Back to Inbox']")
	private WebElement linkBackToInbox;
	
	@FindBy(xpath="//td[contains(text(),'User Name')]/following-sibling::td")
	private WebElement textUserName;
	
	@FindBy(xpath="//td[contains(text(),'Password')]/following-sibling::td")
	private WebElement textPassword;
	
	@FindBy(css="img[role='menu']")
	private WebElement menuMore;
	
	@FindBy(xpath="//div[contains(text(),'Delete this message')]")
	private WebElement buttonDelete;
	
	String userName, password;
	
	//This method is used to retrieve user name from email
	public String retrieveNewUserUserName() throws Exception {
		logger.info("Waiting for the email to load");
		browser.Wait(1);
		logger.info("Retrieving new user's user username");
		userName=browser.getText(textUserName);
		return userName;
	}
	
	//This method is used to retrieve user password from email
	public String retrieveNewUserPassword() throws Exception {
		logger.info("Retrieving new user password");
		browser.Wait(1);
		password=browser.getText(textPassword);
		return password;
	}
	
	//This method is used to delete email
	public void deleteEmail() throws Exception {
		logger.info("Deleting the email...");
		browser.click(menuMore);
		browser.waitForVisible(buttonDelete);
		browser.actions().moveToElement(buttonDelete).sendKeys(Keys.ENTER).build().perform();
		
	}
}