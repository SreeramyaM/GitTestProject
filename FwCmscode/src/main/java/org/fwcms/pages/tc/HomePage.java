package org.fwcms.pages.tc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private static final Logger logger = LogManager.getLogger(HomePage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public HomePage initElements() throws Exception
	{
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(id="menuitem_search_mc")
	private WebElement searchMedicalCenterOption;
	
	@FindBy(id="menuitem_passport_details")
	private WebElement workerVerificationApprovalMenu;
	
	@FindBy(id="menuitem_change_password")
	private WebElement changePasswordOption;
	
		
	public void clickWorkerVerificationApprovalMenu() throws Exception{
		logger.info("clicking worker verification menu");
		browser.waitForEditable(workerVerificationApprovalMenu);
		browser.click(workerVerificationApprovalMenu);
	}
		
	public void clickSearchMedicalCenterOption() throws Exception{
		logger.info("clicking medical center search option");
		browser.waitForEditable(searchMedicalCenterOption);
		browser.click(searchMedicalCenterOption);
	}
	
	public void clickChangePasswordOption() throws Exception{
		logger.info("clicking change password option");
		browser.waitForEditable(changePasswordOption);
		browser.click(changePasswordOption);
	}
	
	public void assertSignOutVisible() throws Exception{
		logger.info("asserting sign out visible");
		browser.assertVisible(signOutLink);
	}
	
	public void clickSignOutLink() throws Exception{
		logger.info("clicking signout link");
		browser.waitForEditable(signOutLink);
		browser.click(signOutLink);
	}
	
}
