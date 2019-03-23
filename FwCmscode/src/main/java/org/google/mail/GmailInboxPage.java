package org.google.mail;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class GmailInboxPage {
	
	private static final Logger logger = LogManager.getLogger(GmailInboxPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public GmailInboxPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public GmailInboxPage initElements()
	{
		return PageFactory.initElements(driver, GmailInboxPage.class);
	}
		
	@FindBy(xpath="//span[contains(text(),'Bestinet Privileged User Created Successfully')]")
	private WebElement linkPriviligedUserCreated;
	
	@FindBy(xpath="//span[contains(text(),'Bestinet Operator Created Successfully')]")
	private WebElement linkOperatorUserCreated;
	
	@FindBy(xpath="//span[contains(text(),'MC Representative Created Successfully')]")
	private WebElement linkMedicalCenterRepresentativeCredentials;
	
	@FindBy(xpath="//span[contains(text(),'MC Operator Created Successfully')]")
	private WebElement linkMedicalCenterOperatorCreated;
	
	@FindBy(xpath="//a[contains(text(),'Inbox')]")
	private WebElement linkInbox;
	
	//This method is used to click on the 'Privileged User Created' email received
	public void clickOnPrivilegedUserCreatedEmail() throws Exception {
		logger.info("Waiting for the inbox page to load");
		browser.Wait(10);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(3, TimeUnit.MINUTES)
		        .pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		linkPriviligedUserCreated =  wait.until(
			        new Function<WebDriver, WebElement>() {
			            public WebElement apply(WebDriver driver) {
			            	try {
								browser.click(linkInbox);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                return linkPriviligedUserCreated ;
			            }
			        }
		);
		try {
			browser.click(linkPriviligedUserCreated);
		} catch(NoSuchElementException e) {
			browser.click(linkInbox);
			browser.Wait(20);
			browser.waitForVisible(linkPriviligedUserCreated);
			browser.click(linkPriviligedUserCreated);
		}
	}
	
	//This method is used to click on the 'Operator User Created' email received
	public void clickOnOperatorUserCreatedEmail() throws Exception {
		logger.info("Waiting for the inbox page to load");
		browser.Wait(10);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(3, TimeUnit.MINUTES)
		        .pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		linkOperatorUserCreated =  wait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		            	try {
							browser.click(linkInbox);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                return linkOperatorUserCreated ;
		            }
		        }
	);
		try {
			browser.click(linkOperatorUserCreated);
		} catch(NoSuchElementException e) {
			browser.click(linkInbox);
			browser.Wait(20);
			browser.waitForVisible(linkOperatorUserCreated);
			browser.click(linkOperatorUserCreated);
		}
	}
	
	//This method is used to click on the 'Medical Center Representative Credentials' email received
	public void clickOnOMedicalCenterRepCredentialsEmail() throws Exception {
		logger.info("Waiting for the inbox page to load");
		Thread.sleep(100000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(4, TimeUnit.MINUTES)
		        .pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		linkMedicalCenterRepresentativeCredentials =  wait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		            	try {
							browser.click(linkInbox);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                return linkMedicalCenterRepresentativeCredentials ;
		            }
		        }
	);
		try {
			browser.click(linkMedicalCenterRepresentativeCredentials);
		} catch(NoSuchElementException e) {
			browser.click(linkInbox);
			browser.Wait(20);
			browser.waitForVisible(linkMedicalCenterRepresentativeCredentials);
			browser.click(linkMedicalCenterRepresentativeCredentials);
		}
	}
	
	//This method is used to click on the 'Medical Center Operator Created Successfully' email received
	public void clickOnOMedicalCenterOprCreatedEmail() throws Exception {
		logger.info("Waiting for the inbox page to load");
		browser.Wait(10);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(3, TimeUnit.MINUTES)
		        .pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		linkMedicalCenterOperatorCreated =  wait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		            	try {
							browser.click(linkInbox);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                return linkMedicalCenterOperatorCreated ;
		            }
		        }
	);
		try {
			browser.click(linkMedicalCenterOperatorCreated);
		} catch(NoSuchElementException e) {
			browser.click(linkInbox);
			browser.Wait(20);
			browser.waitForVisible(linkMedicalCenterOperatorCreated);
			browser.click(linkMedicalCenterOperatorCreated);
		}
	}
	
	//This method is used to click on the 'Employer Profile Registered Successfully' email received
	public void clickOnOEmployerRegisteredEmail(final String orgName) throws Exception {
		logger.info("Waiting for the inbox page to load");
		browser.Wait(10);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(3, TimeUnit.MINUTES)
		        .pollingEvery(5, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		WebElement linkEmployerProfileRegistered =  wait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		            	try {
							browser.click(linkInbox);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                return driver.findElement(By.xpath("//span/b[contains(text(),'Employer Profile Registered Successfully for "+orgName+"')]")) ;
		            }
		        }
	);
		try {
			browser.click(linkEmployerProfileRegistered);
		} catch(NoSuchElementException e) {
			browser.click(linkInbox);
			browser.Wait(20);
			browser.waitForVisible(linkEmployerProfileRegistered);
			browser.click(linkEmployerProfileRegistered);
		}
	}
}