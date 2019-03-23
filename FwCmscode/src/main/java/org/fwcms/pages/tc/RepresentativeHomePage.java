package org.fwcms.pages.tc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepresentativeHomePage {
	
	private static final Logger logger = LogManager.getLogger(RepresentativeHomePage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public RepresentativeHomePage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public RepresentativeHomePage initElements() throws Exception
	{
		return PageFactory.initElements(driver, RepresentativeHomePage.class);
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(id="menuitem_change_password")
	private WebElement changePasswordLink;
	
	@FindBy(id="menuitem_add_edit_delete_tc")
	private WebElement addEditDeleteOperatorLink;
	
	@FindBy(id="menuitem_update_mc")
	private WebElement updateMedicalCenterLink;
	
	public void assertSignOutVisible() throws Exception{
		logger.info("asserting sign out visible");
		browser.assertVisible(signOutLink);
	}
	
	public void clickSignOutLink() throws Exception{
		logger.info("click signout link");
		browser.click(signOutLink);
	}
	
	public void clickAddEditDeleteOperatorLink() throws Exception{
		logger.info("waiting for addEditDeleteOperatorLink to be clickable");
		browser.waitForEditable(addEditDeleteOperatorLink);
		logger.info("clicking addEditDeleteOperatorLink");
		browser.click(addEditDeleteOperatorLink);
	}
	
	public void clickUpdateMedicalCenterLink() throws Exception{
		logger.info("waiting for update MC link to be clickable");
		browser.waitForEditable(updateMedicalCenterLink);
		logger.info("clicking update MC link");
		browser.click(updateMedicalCenterLink);
	}
	
	public void waitAndClickPasswordLink() throws Exception{
		logger.info("waiting for change password link to be clickable");
		browser.waitForEditable(changePasswordLink);
		logger.info("clicking change password link");
		browser.click(changePasswordLink);
	}
	
}
