package org.fwcms.pages.cdc.employer;

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
	
	public HomePage initElements()
	{
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(className="active_user")
	private WebElement userNameInHeader;
	
	@FindBy(css="div[class='fwcms_logo']>div:nth-child(1)")
	private WebElement organizationInHeader;
	
	@FindBy(css="div[class='footer-container']>a:nth-child(1)>span:nth-child(2)")
	private WebElement trainingLink;
	
	@FindBy(css="div[class='footer-container']>a:nth-child(2)>span:nth-child(2)")
	private WebElement updatesLink;
	
	@FindBy(css="div[class='footer-container']>a:nth-child(3)>span:nth-child(2)")
	private WebElement announcementsLink;
	
	@FindBy(css="div[class='footer-container']>a:nth-child(4)>span:nth-child(2)")
	private WebElement contactsLink;
	
	@FindBy(css="div[class='footer-container']>a:nth-child(5)>span:nth-child(2)")
	private WebElement helpLink;
	
	@FindBy(css="div[class^='active_user_info']")
	private WebElement userInfo;
	
	@FindBy(css="div[class='active_user_block']>p:nth-child(2)")
	private WebElement contactNumberInUserInfo;
	
	@FindBy(css="div[class='active_user_block']>p:nth-child(3)")
	private WebElement emailInUserInfo;
	
	@FindBy(className="sticky_nav_text")
	private WebElement stickyActions;
	
	@FindBy(className="sticky_navigation_menu")
	private WebElement stickyNavigationMenu;
	
	@FindBy(className="sticky_nav_backmenu")
	private WebElement stickyNavigationBackMenu;
	
	@FindBy(id="menuitem_employer_registration")
	private WebElement managePicCredentialsLink;
	
	@FindBy(id="menuitem_VDR_process")
	private WebElement vdrProcessLink;
	
	@FindBy(css="div[id='nav-container-wrapper'] div[class='navcontainer']>ul>li:nth-child(2)>a")
	private WebElement navigationVdrProcessLink;
	
	@FindBy(id="menuitem_change_password")
	private WebElement changePasswordLink;
	
	@FindBy(id="menuitem_quota_counter")
	private WebElement quotaCounterLink;
	
	@FindBy(id="menuitem_plks")
	private WebElement plksLink;
	
	@FindBy(id="menuitem_checkout_com")
	private WebElement checkOutMemoLink;
	
	/*@FindBy(css="div[class$='new_VDR']")
	private WebElement createNewVdrLinkInActions;*/
	
	@FindBy(xpath="//a[@id='newVDRLink']//div[@class='nav-list-img new_VDR']")
	private WebElement createNewVdrLinkInActions;
	
	@FindBy(css="div[id='nav-container-wrapper'] div[class='subnavcontainer']>ul>li:nth-child(1)>a")
	private WebElement navigationCreateNewVdrLinkInActions;
	
	@FindBy(css="div[class$='cancel_VDR']")
	private WebElement cancelVdrLinkInActions;
	
	@FindBy(css="div[class$='replace_VDR']")
	private WebElement replaceVdrLinkInActions;
	
	@FindBy(css="div[class$='search_VDR']")
	private WebElement searchVdrLinkInActions;
	
	@FindBy(css="div[class='pageHeading']>span")
	private WebElement pageHeadingAction;
	
	@FindBy(css="div[id='nav-container-wrapper'] div[class='navcontainer']>ul>li:nth-child(6)>a>div:nth-child(2)")
	private WebElement reportsAndAccountManagementMenu;
	
	@FindBy(css="div[class='nav-list-img change_password']")
	private WebElement changePasswordMenu;
	
	//@FindBy(css="div[id='nav-container-wrapper'] div[class='subnavcontainer']>ul>li:nth-child(3)>a>div:nth-child(2)")
	@FindBy(xpath="//div[@id='nav-container-wrapper']//div[contains(text(),' Manage PIC Credentials')]")
	private WebElement managePICcredentialsMenu;
	
	public void clickManagePICcredentialsMenuAndVerifyHeader(String headerText) throws Exception
	{
		browser.waitForEditable(managePICcredentialsMenu);	
		browser.click(managePICcredentialsMenu);
		browser.verifyText(pageHeadingAction, headerText);
	}
	
	public void clickReportAndAccountManagementMenuAndVerifyHeader(String headerText) throws Exception
	{
		browser.waitForEditable(reportsAndAccountManagementMenu);	
		browser.click(reportsAndAccountManagementMenu);
		browser.Wait(1);
		browser.verifyText(pageHeadingAction, headerText);
		//browser.click(changePasswordMenu);
	}
	
	public void verifyReportAndAccountManagementMenu() throws Exception
	{
		browser.verifyElementPresent(reportsAndAccountManagementMenu);	
	}
	
	public void VerifyHeader() throws Exception
	{	
		browser.verifyElementPresent(pageHeadingAction);
		browser.verifyText(pageHeadingAction, "Select An Action");
	}
	
	public void clickStickyActions() throws Exception{
		logger.info("clicking sticky actions");
		browser.waitForEditable(stickyActions);
		browser.click(stickyActions);
	}
	
	public void clickNewVdrLinkInActions() throws Exception{
		logger.info("clicking new vdr link in sticky actions");
		browser.Wait(1);
		if(browser.isVisible(stickyActions)){
			clickStickyActions();
			browser.waitForEditable(vdrProcessLink);
			browser.click(vdrProcessLink);
			browser.waitForEditable(createNewVdrLinkInActions);
			createNewVdrLinkInActions.click();
			
			browser.Wait(3);
			//browser.click(createNewVdrLinkInActions);
		}else{
			browser.waitForEditable(navigationVdrProcessLink);
			browser.click(navigationVdrProcessLink);
			browser.waitForEditable(navigationCreateNewVdrLinkInActions);
			browser.click(navigationCreateNewVdrLinkInActions);
		}
		
		
	}
	
	public void assertSignOutLinkVisible() throws Exception{
		logger.info("checking sign out link is visible");
		browser.assertVisible(signOutLink);
	}
	
	public void clickSignOutLink() throws Exception{
		logger.info("clicking signout link");
		logger.info("sleeping for 2 sec");
		browser.Wait(2);
		browser.click(signOutLink);
	}
	
	public void verifyElementsPresentAndActionsOnElements() throws Exception{
		logger.info("verifying elements in employer home page");
		logger.info("verifying username is visible");
		browser.verifyVisible(userNameInHeader);
		logger.info("verifying organization is visible");
		browser.verifyVisible(organizationInHeader);
		logger.info("verifying training link is visible");
		browser.verifyVisible(trainingLink);
		logger.info("verifying updates link is visible");
		browser.verifyVisible(updatesLink);
		logger.info("verifying announcements link is visible");
		browser.verifyVisible(announcementsLink);
		logger.info("verifying contacts link is visible");
		browser.verifyVisible(contactsLink);
		logger.info("verifying help link is visible");
		browser.verifyVisible(helpLink);
		logger.info("clicking username in header");
		browser.click(userNameInHeader);
		logger.info("waiting for the user info to be visible");
		browser.waitForVisible(userInfo);
		logger.info("verifying contact number in user info is visible");
		browser.verifyVisible(contactNumberInUserInfo);
		logger.info("verifying email in user info is visible");
		browser.verifyVisible(emailInUserInfo);
		logger.info("verifying sticky actions is visible");
		browser.verifyVisible(stickyActions);
		verifyActionsTabCollapsedAndVisible();
		verifyElementsOfActionsTab();
		verifyVdrOptionsInActionsTab();
	}
	
	public void verifyActionsTabCollapsedAndVisible() throws Exception{
		logger.info("verifying actions tab collapsed and visible");
		browser.click(stickyActions);
		browser.Wait(1);
		browser.verifyVisible(stickyNavigationMenu);
		browser.click(stickyActions);
		browser.Wait(1);
		browser.verifyNotVisible(stickyNavigationMenu);
	}
	
	public void verifyElementsOfActionsTab() throws Exception{
		logger.info("verifying elements in actions tab");
		browser.click(stickyActions);
		logger.info("waiting for the sticky navigation menu to be visible");
		browser.waitForVisible(stickyNavigationMenu);
		browser.verifyVisible(managePicCredentialsLink);
		browser.verifyVisible(vdrProcessLink);
		browser.verifyVisible(changePasswordLink);
		browser.verifyVisible(quotaCounterLink);
		browser.verifyVisible(plksLink);
		browser.verifyVisible(checkOutMemoLink);
		browser.click(stickyActions);
		browser.Wait(1);
	}
	
	public void verifyVdrOptionsInActionsTab() throws Exception{
		logger.info("verifying vdr options in actions tab");
		browser.click(stickyActions);
		logger.info("waiting for the sticky navigation menu to be visible");
		browser.waitForVisible(stickyNavigationMenu);
		browser.waitForVisible(vdrProcessLink);
		browser.click(vdrProcessLink);
		browser.Wait(1);
		browser.verifyVisible(stickyNavigationBackMenu);
		browser.click(stickyNavigationBackMenu);
		browser.Wait(1);
		browser.verifyNotVisible(stickyNavigationBackMenu);
		browser.click(vdrProcessLink);
		browser.waitForVisible(stickyNavigationBackMenu);
		browser.verifyVisible(createNewVdrLinkInActions);
		browser.verifyVisible(cancelVdrLinkInActions);
		browser.verifyVisible(replaceVdrLinkInActions);
		browser.verifyVisible(searchVdrLinkInActions);
		browser.click(stickyActions);
		browser.waitForNotVisible(stickyNavigationBackMenu);
	}
	
}
