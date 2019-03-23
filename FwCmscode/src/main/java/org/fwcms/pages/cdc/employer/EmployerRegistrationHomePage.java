package org.fwcms.pages.cdc.employer;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployerRegistrationHomePage {

private static final Logger logger = LogManager.getLogger(HomePage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public EmployerRegistrationHomePage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public EmployerRegistrationHomePage initElements()
	{
		return PageFactory.initElements(driver, EmployerRegistrationHomePage.class);
	}
	
	@FindBy(id="employer_number")
	private WebElement employerUniqueIDText;
	
	@FindBy(id="employer_email")
	private WebElement employerEmialAddressText;
	
	@FindBy(id="employer_mobile")
	private WebElement employerHandPhoneNumberText;
	
	@FindBy(id="submit_emp_details")
	private WebElement submitButton;
	
	@FindBy(css="input[value='Mykad Number']")
	private WebElement MykadNumberRadio ;
	
	@FindBy(css="div[class='block-fixed-title-emp']>p:nth-child(1)")
	private WebElement textDisplayLineOne;
	
	@FindBy(css="div[class='block-fixed-title-emp']>p:nth-child(2)")
	private WebElement textDisplayLineTwo;
	
	@FindBy(className="block-note-emp")
	private WebElement employeeNoteTextDisplay;
	
	@FindBy(css="div[class='pageHeading']>span")
	private WebElement pageHeadingTextDisplay;
	
	@FindBy(className="emp_details_popup")
	private WebElement employeeDetailsPopup;
	
	@FindBy(id="emp_details_emp_name")
	private WebElement employeeName; 
	
	@FindBy(id="emp_details_emp_no")
	private WebElement myKadEmpNo; 

	@FindBy(id="emp_details_org_address")
	private WebElement organisationAddress; 
	
	@FindBy(id="emp_details_emp_email")
	private WebElement employeeEmailAddress; 
	
	@FindBy(id="emp_details_emp_mobile")
	private WebElement mobileNumber; 
	
	@FindBy(id="emp_details_gen_cred")
	private WebElement generateCredentialsButton; 
	
	//developers has to change below id's ----------------
	
	@FindBy(id="pic_details_email1")
	private WebElement organizationNameText; 
	
	@FindBy(xpath="//div[@class='pic_details_block']/div[5]/span[2]")
	private WebElement employeeEmialText; 
	
	@FindBy(xpath="//div[@class='pic_details_block']/div[6]/span[2]")
	private WebElement employeeMobileNumberText; 
	
	@FindBy(id="submit_emp_pic_details")
	private WebElement employeeDetailsSubmitButton;
	//---------------
	
	@FindBy(id="otp_forms")
	private WebElement OTPpassword;
	
	@FindBy(id="OTP")
	private WebElement OTPtextBox;
	
	@FindBy(id="confirm_otp")
	private WebElement otpConfirmButton;
	
	@FindBy(id="username")
	private WebElement employerUserNameText;
	
	@FindBy(id="password")
	private WebElement passwordText;
	
	@FindBy(className="btn-submit")
	private WebElement loginButton;
	
	@FindBy(id="change_form")
	private WebElement changePasswordForm;
	
	@FindBy(id="oldPassword")
	private WebElement oldPasswordText;
	
	@FindBy(id="newPassword")
	private WebElement newPasswordText;
	
	@FindBy(id="cnfPassword")
	private WebElement confirmPasswordText;
	
	@FindBy(id="change_password_first_time")
	private WebElement changePasswordSubmitButton;
	
	@FindBy(css="div[id='dk_container_select_qus']>a>span")
	private WebElement securityQuestionSelect;
	
	@FindBy(css="div[id='dk_container_select_qus']>div>ul>li>a")
	private List<WebElement> securityQuestionOptionsList;
	
	@FindBy(id="validatetext")
	private WebElement answerText;
	
	@FindBy(css="div[id='reset_pfwd']>span:nth-child(2)>span")
	private WebElement resetSubmitButton;
	
	@FindBy(className="declaration_check")
	private WebElement declarationCheckBox;
	
	@FindBy(id="captcha")
	private WebElement textCaptcha;
	
	@FindBy(xpath="")
	private WebElement errorIncorrectCaptcha;
	
	//** ==================================================Perform Actions ============================================  */
	public void changePasswordAndClickOnSubmit(String OldPassword,String newPassword) throws Exception
	{
		logger.info("Change the employer password");
		browser.verifyElementPresent(changePasswordForm);
		//browser.type(employerUserNameText, userName);
		browser.type(oldPasswordText, OldPassword);
		browser.type(newPasswordText, newPassword);
		browser.type(confirmPasswordText, newPassword);
		browser.click(changePasswordSubmitButton);
	}
	
	public void verifyOTPpopupAndTypeOTP(String OTP) throws Exception
	{
		browser.waitForVisible(OTPpassword);
		browser.type(OTPtextBox, OTP);
		browser.click(otpConfirmButton);
	}
	public void clickEmpDetailsSubmitButton() throws Exception
	{
		browser.waitForVisible(employeeDetailsSubmitButton);
		browser.click(employeeDetailsSubmitButton);
	}
	public void verifyEmployeeEmail(String empEmail) throws Exception
	{
		browser.waitForVisible(employeeEmialText);
		browser.verifyText(employeeEmialText, empEmail);
	}
	
	public void verifyEmployeeMobile(String mobNumber) throws Exception
	{
		browser.waitForVisible(employeeMobileNumberText);
		browser.verifyText(employeeMobileNumberText, mobNumber);
	}
	
	public void verifyHeading(String HeadingDisplay) throws Exception
	{
		logger.info("Verify Employee information display line two");
		browser.waitForVisible(pageHeadingTextDisplay);
		browser.verifyText(pageHeadingTextDisplay, HeadingDisplay);
	}  
	
	public void verifyTextDisplayLineOne(String employeeDisplayInfo1) throws Exception
	{
		logger.info("Verify Employee information display line one");
		browser.verifyText(textDisplayLineOne, employeeDisplayInfo1);
	}
	
	public void verifyTextDisplayLineTwo(String employeeDisplayInfo2) throws Exception
	{
		logger.info("Verify Employee information display line two");
		browser.verifyText(textDisplayLineTwo, employeeDisplayInfo2);
	}
	
	public void verifyEmployeeNoteDisplay(String note) throws Exception
	{
		logger.info("verify Note information");
		browser.verifyText(employeeNoteTextDisplay, note);
	}
	
	public void registerEmployeeWithMyKadNumber(String mykadNumber,String email,String phoneNumber) throws Exception
	{
		logger.info("register employee with MyKad number");
		browser.verifyElementPresent(pageHeadingTextDisplay);
		browser.type(employerUniqueIDText, mykadNumber);
		//browser.click(MykadNumberRadio);
		browser.type(employerEmialAddressText, email);
		browser.type(employerHandPhoneNumberText, phoneNumber);
		browser.click(declarationCheckBox);
		do{
			browser.clearAndType(textCaptcha, "8");
			browser.click(submitButton);
			browser.Wait(2);
		}while(!employeeDetailsPopup.isDisplayed());
		
	}
	
	public void verifyEmployeeDetailsPopupDisplayedWithEmployeeDetails(String mykadNumber,String email,String phone) throws Exception
	{
		logger.info("verify employee details popup");
		browser.assertElementPresent(employeeDetailsPopup);
		browser.Wait(2);
		logger.info("verify employee details");
		browser.assertElementPresent(employeeName);
		browser.assertText(myKadEmpNo, mykadNumber);
		browser.assertElementPresent(organisationAddress);
		browser.assertText(employeeEmailAddress, email);
		browser.assertText(mobileNumber,"+60"+phone);
	}
	
	public void ClickGenerateCredentials() throws Exception
	{
		logger.info("clicking Generate credentials button");
		browser.click(generateCredentialsButton);
		new CommonElements(driver).initElements().waitForOverlayToHide();
	}
	
	public void employerLoginWithDefaultPasswordAndSubmit(String username,String password) throws Exception
	{
		logger.info("Employer login page with auto password from mail");
		browser.verifyElementPresent(employerUserNameText);
		browser.type(employerUserNameText, username);
		browser.type(passwordText, password);
		browser.click(loginButton);
	}
	
	public void verifySecurityQuestionAndAnswer() throws Exception{
		logger.info("verifying elements in security question form");
		logger.info("waiting for security question to be visible");
		browser.waitForVisible(securityQuestionSelect);
		logger.info("verifying answer text is visible");
		browser.verifyVisible(answerText);
	}
	
	public void selectSecurityQuestionAndAnswerIt(String questionName, String answer) throws Exception{
		logger.info("trying to answer security question");
		logger.info("waiting for the security question to visible");
		browser.waitForVisible(securityQuestionSelect);
		logger.info("clicking security question to expand options");
		browser.click(securityQuestionSelect);
		boolean foundQuestion = false;
		Iterator<WebElement> questions = securityQuestionOptionsList.iterator();
		while(questions.hasNext()){
			WebElement eachQuestion = questions.next();
			if(browser.getText(eachQuestion).equals(questionName)){
				logger.info("question in the list found");
				foundQuestion = true;
				logger.info("selecting question");
				browser.click(eachQuestion);
				break;
			}
		}
		browser.assertTrue(foundQuestion, "Question in the list not found");
		logger.info("typing answer '"+answer+"' in answer field");
		browser.type(answerText, answer);
	}
	
	public void clickSubmitButtonInSecurityQuestion() throws Exception{
		logger.info("clicking submit button of security question");
		browser.click(resetSubmitButton);
	}
	
}

