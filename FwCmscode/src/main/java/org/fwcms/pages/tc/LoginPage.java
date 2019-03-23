package org.fwcms.pages.tc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.prop.LoginPageProp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.olo.util.PropertyReader.configProp;

public class LoginPage {
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public LoginPage initElements()
	{
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	@FindBy(id="userName")
	private WebElement localEnvUserNameText;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement localEnvLoginButton;
	
	@FindBy(id="username")
	private WebElement userNameText;
	
	@FindBy(id="password")
	private WebElement passwordText;
	
	@FindBy(css="input[value='LOGIN']")
	private WebElement logginButton;
	
	@FindBy(className="hyperlink")
	private WebElement forgotPasswordLink;
	
	@FindBy(id="error")
	private WebElement errorMessage;
	
	public void loginToTC(String username,String password) throws Exception{
		if(configProp.getProperty("environment").contains("local")){
			logger.info("typing username '"+username+"'");
			browser.waitForEditable(localEnvUserNameText);
			browser.waitForEditable(passwordText);
			browser.type(localEnvUserNameText, username);
			logger.info("typing password '"+password+"'");
			browser.Wait(1);
			browser.type(passwordText, password);
			logger.info("clicking login button");
			browser.click(localEnvLoginButton); 
		} else {
			logger.info("typing username '"+username+"' ");
			browser.waitForEditable(userNameText);
			browser.waitForEditable(passwordText);
			browser.type(userNameText, username);
			logger.info("typing password '"+password+"'");
			browser.Wait(1);
			browser.type(passwordText, password);
			logger.info("clicking login button");
			browser.click(logginButton);
		}
	}
	
	public void verifyElementsPresentInLoginPage() throws Exception{
		logger.info("verifying elements in login page");
		logger.info("verifying username field visible");
		browser.verifyVisible(userNameText);
		logger.info("verifying password field visible");
		browser.verifyVisible(passwordText);
		logger.info("verifying login button visible");
		browser.verifyEditable(logginButton);
		logger.info("verifying forgot password link visible");
		browser.verifyVisible(forgotPasswordLink);
	}
	
	public void clickForgotPasswordLink() throws Exception{
		logger.info("clicking forgot password link");
		browser.click(forgotPasswordLink);
	}
	
	public void verifyInvaliedLoginAccess() throws Exception{
		logger.info("verifying invalied login");
		logger.info("waiting for error message to visible");
		browser.waitForVisible(errorMessage);
		logger.info("verifying text in error message");
		browser.verifyText(errorMessage, LoginPageProp.getaccessDenied());
	}
	
}
