package org.fwcms.pages.tc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkerDataQualityPage {

private static final Logger logger = LogManager.getLogger(WorkerDataQualityPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public WorkerDataQualityPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public WorkerDataQualityPage initElements()
	{
		return PageFactory.initElements(driver, WorkerDataQualityPage.class);
	}
	
	@FindBy(id="menuitem_passport_details")
	private WebElement workerVerificationMenu;
	
	@FindBy(css="div[class='jspPane']>div:nth-child(7)")
	private WebElement selectFirstEmployeeInList;
	//Perform Actions
	
	public void clickWorkerVerificationMenu() throws Exception
	{
		logger.info("Clicking on Worker Verification");
		browser.waitForVisible(workerVerificationMenu);
		browser.click(workerVerificationMenu);
		new CommonElements(driver).initElements().waitForOverlayToHide();
	}
	
	public void selectFirstEmployeeInList() throws Exception
	{
		browser.verifyElementPresent(selectFirstEmployeeInList);
		browser.click(selectFirstEmployeeInList);
		new CommonElements(driver).initElements().waitForOverlayToHide();
	}
	
}
