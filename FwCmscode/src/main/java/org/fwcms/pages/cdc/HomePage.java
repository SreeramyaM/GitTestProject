package org.fwcms.pages.cdc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonElements{
	
	private static final Logger logger = LogManager.getLogger(HomePage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public HomePage initElements()
	{
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(id="menuitem_add_edit_delete_tc")
	private WebElement addEditDeleteUsersLink;
	
	@FindBy(id="menuitem_change_password")
	private WebElement changePasswordLink;
	
	@FindBy(id="menuitem_roles_privileges")
	private WebElement rolesAndPrivilegesLink;
	
	@FindBy(id="menuitem_metadata_configuration")
	private WebElement metaDataConfiguration;
	
	@FindBy(id="menuitem_mc_metadata_configuration")
	private WebElement medicalCenterMetaDataConfiguration;
	
	@FindBy(id="menuitem_agent_metadata_configuration")
	private WebElement agentMetaDataConfiguration;
	
	public void assertSignOutLinkVisible() throws Exception{
		logger.info("checking sign out link is visible");
		browser.assertVisible(signOutLink);
	}
	
	public void clickAddEditDeleteUsersLink() throws Exception{
		logger.info("waiting for the link to be enabled");
		browser.waitForEditable(addEditDeleteUsersLink);
		logger.info("clicking on add edit delete users link");
		browser.click(addEditDeleteUsersLink);
	}
	
	public void clickRolesAndPrivilegesLink() throws Exception{
		logger.info("waiting for the link to be enabled");
		browser.waitForEditable(rolesAndPrivilegesLink);
		logger.info("clicking on roles and privileges link");
		browser.click(rolesAndPrivilegesLink);
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
	}
	
	public void clickSignOutLink() throws Exception{
		logger.info("clicking signout link");
		logger.info("sleeping for 1 sec");
		browser.Wait(1);
		browser.waitForEditable(signOutLink);
		browser.click(signOutLink);
	}
	
	public void clickMetaDataConfigurationLink() throws Exception{
		logger.info("clicking meta data configuration link");
		browser.waitForEditable(metaDataConfiguration);
		browser.click(metaDataConfiguration);
		waitForOverlayToHide();
	}
	
	public void clickMedicalCenterMetaDataConfigurationLink() throws Exception{
		logger.info("clicking medical center meta data configuration link");
		browser.waitForEditable(medicalCenterMetaDataConfiguration);
		browser.click(medicalCenterMetaDataConfiguration);
	}
	
	public void verifyAgentMetaDataConfigurationVisible() throws Exception{
		logger.info("waiting for agent meta data configuration link to be editable");
		browser.waitForEditable(agentMetaDataConfiguration);
	}
	
	public void clickAgentMetaDataConfigurationLink() throws Exception{
		verifyAgentMetaDataConfigurationVisible();
		logger.info("clicking on agent meta data configuration link");
		browser.click(agentMetaDataConfiguration);
	}
	
	public void clickChangePassword() throws Exception{
		logger.info("waiting for the link to be enabled");
		browser.waitForEditable(changePasswordLink);
		logger.info("clicking on change password  link");
		browser.click(changePasswordLink);
		Thread.sleep(3000);
	}
	
	
}
