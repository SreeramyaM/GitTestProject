package org.fwcms.tc.mcRegistrationPages;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterMedicalCenterPage extends CommonElements{
	
	private static final Logger logger = LogManager.getLogger(RegisterMedicalCenterPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	
	public RegisterMedicalCenterPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public RegisterMedicalCenterPage initElements()
	{
		return PageFactory.initElements(driver, RegisterMedicalCenterPage.class);
	}
	@FindBy(id="dk_container_doc_attach")
	private WebElement attachementdropDown;
	@FindBy(id="medicalcenter")
	private WebElement medicalCenterName;
	
	@FindBy(id="registration")
	private WebElement registrationNumber;
	
	@FindBy(id="center_address_line1")
	private WebElement medicalCenterAddressLine1;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="fax")
	private WebElement fax;
	
	@FindBy(css="div[id='dk_container_week_from']>a>span")
	private WebElement weekDayFromSelect;
	
	@FindBy(css="div[id='dk_container_week_from']>div>ul>li>a")
	private List<WebElement> weekDayFrom;
	
	@FindBy(css="div[id='dk_container_week_to']>a>span")
	private WebElement weekDayToSelect;
	
	@FindBy(css="div[id='dk_container_week_to']>div>ul>li>a")
	private List<WebElement> weekDayTo;
	
	@FindBy(css="div[id='next-tab']>span:nth-child(2)>span")
	private WebElement nextButton;
	
	@FindBy(id="attachlogo")
	private WebElement attachLogo;
	
	@FindBy(id="ownername1")
	private WebElement ownerName1;
	
	@FindBy(id="ownerdesignation1")
	private WebElement ownerDesignation1;
	
	@FindBy(id="owneremail1")
	private WebElement ownerEmail1;
	
	@FindBy(id="ownercontact1")
	private WebElement ownerContact1;
	
	@FindBy(id="ownername2")
	private WebElement ownerName2;
	
	@FindBy(id="ownerdesignation2")
	private WebElement ownerDesignation2;
	
	@FindBy(id="owneremail2")
	private WebElement ownerEmail2;
	
	@FindBy(id="ownercontact2")
	private WebElement ownerContact2;
	
	@FindBy(id="repname1")
	private WebElement repName1;
	
	@FindBy(id="repemail1")
	private WebElement repEmail1;
	
	@FindBy(id="repcontact1")
	private WebElement repContact1;
	
	@FindBy(id="repname2")
	private WebElement repname2Text;
	
	@FindBy(id="repemail2")
	private WebElement repemail2Text;
	
	@FindBy(id="repcontact2")
	private WebElement repcontact2Text;
	
	@FindBy(css="div[id='save-tab']>span:nth-child(2)>span")
	private WebElement saveButton;
	
	@FindBy(css="div[class^='statusBar']")
	private WebElement statusBar;
	
	@FindBy(id="app_id")
	private WebElement applicationId;
	
	@FindBy(id="doc_tab_fullname")
	private WebElement doctorFullName;
	
	@FindBy(id="doctor_professional_id")
	private WebElement doctorProfessionalId;
	
	@FindBy(id="doctor_qualification")
	private WebElement doctorQualification;
	
	@FindBy(id="doctor_address_line1")
	private WebElement doctorAddress1;
	
	@FindBy(id="attachsignature")
	private WebElement doctorSignature;
	
	@FindBy(id="attachstamp")
	private WebElement doctorStamp;
	
	@FindBy(className="update")
	private WebElement doctorUpdateButton;
	
	@FindBy(className="delete")
	private WebElement doctorDeleteButton;
	
	@FindBy(className="cancel")
	private WebElement doctorCancelButton;
	
	@FindBy(css="form[id='doctor-tab']>div[class='doc_leftPane']>div[class='action_btns']>div[class='action_item']>a")
	private WebElement doctorSave;
	
	@FindBy(css="div[class='doctors_list']>div[class='doctor']>span[class='doc_name']")
	private List<WebElement> doctorsList;
	
	@FindBy(css="div[id='dk_container_doc_attach']>a>span")
	private WebElement selectDocumentTypeOption;
	
	@FindBy(css="div[id='dk_container_doc_attach'] a[data-dk-dropdown-value='REGISTRATION_CERTIFICATE']")
	private WebElement registrationCertificateOption;
	
	@FindBy(css="div[id='dk_container_doc_attach'] a[data-dk-dropdown-value='PROOF_OF_IDENTITY_FIRST_OWNER']")
	private WebElement proofOfIdentityFirstOwnerOption;
	
	@FindBy(css="div[id='dk_container_doc_attach'] a[data-dk-dropdown-value='MEDICAL_CENTER_STAMP']")
	private WebElement medicalCenterStampOption;
	
	@FindBy(css="div[id='dk_container_doc_attach'] a[data-dk-dropdown-value='PROOF_OF_IDENTITY_SECOND_OWNER']")
	private WebElement proofOfIdentitySecondOwnerOption;
	
	@FindBy(css="div[id='dk_container_doc_attach'] a[data-dk-dropdown-value='LETTER_OF_AUTH_SECOND_REP']")
	private WebElement letterOfAuthorizationForSecondRepOption;
	
	@FindBy(css="div[id='dk_container_doc_attach'] a[data-dk-dropdown-value='LETTER_OF_AUTH_FIRST_REP']")
	private WebElement letterOfAuthorizationForFirstRepOption;
	
	@FindBy(id="attachfile")
	private WebElement documentAttach;
	
	@FindBy(css="a[id='upload_doc']>span:nth-child(2)")
	private WebElement uploadDocument;
	
	@FindBy(css="div[id='grid-doc-attach']>div[class^='scroll-pane']>div>div[class='grid-doc-row']")
	List<WebElement> uploadedDocumentsInGrid;
	
	@FindBy(css="div[id='submit_btn_reg_details']>span:nth-child(2)>span")
	private WebElement submitRegistrationDetails;
	
	@FindBy(id="creditLimitBasedModel")
	private WebElement creditLimitBasedModel;
	
	@FindBy(className="selected_paymode")
	private WebElement selectedPayMode;
	
	@FindBy(className="confirm_popup")
	private WebElement confirmationPopup;
	
	@FindBy(id="confirmation_message")
	private WebElement confirmationMessage;
	
	@FindBy(id="confirm_operation")
	private WebElement confirmOk;
	
	@FindBy(id="mc_status_indicator")
	private WebElement medicalStatusIndicator;
	
	@FindBy(id="search")
	private WebElement AppIDSearchButton;
	
	@FindBy(id="search_mc_status")
	private WebElement searchButton;

	@FindBy(className="attach-documents-tab")
	private WebElement attachDocumentTab;
	
	@FindBy(css="div[class='ownername2formError parentFormcontact-tab formError']>div[class='formErrorContent']")
	private WebElement owner2fullnameValidation;
	
	@FindBy(css="div[class='ownerdesignation2formError parentFormcontact-tab formError']>div[class='formErrorContent']")
	private WebElement owner2DesignationValidation;
	
	@FindBy(css="div[class='owneremail2formError parentFormcontact-tab formError']>div[class='formErrorContent']")
	private WebElement owner2EmailValidation;
	
	@FindBy(css="div[class='repemail2formError parentFormcontact-tab formError']>div[class='formErrorContent']")
	private WebElement representative2EmailDetails;
	
	@FindBy(css="div[class='repcontact2formError parentFormcontact-tab formError']>div[class='formErrorContent']")
	private WebElement representative2MobileNumber;
		
	@FindBy(xpath="//div[@class='input-panel-right']/div[contains(@class,'doctor_professional_idformError parentFormdoctor-tab formError')]/div[@class='formErrorContent']")
	private WebElement professionalIDErrorMsg;
	
	@FindBy(xpath="//div[@class='mc_com_details']/h1")
	private WebElement medicalCenterNameDisplay;
	
	@FindBy(xpath="//div[@class='mc_com_details']/p[1]")
	private WebElement medicalCenterAddressDisplay;
	
	@FindBy(xpath="//div[@class='mc_com_details']/p[2]")
	private WebElement medicalCenterContactDisplay;
		
	@FindBy(id="next-tab")
	private WebElement nxtButton;
	
	@FindBy(id="delete-tab")
	private WebElement prevButton;
	
	@FindBy(xpath="//li[contains(@class,'ui-state-active')]/a")
	private WebElement activeTab;
	
	@FindBy(className="grid-row-cl-two")
	private List<WebElement> documentsList;
	
	@FindBy(css="span[class='grid-row-cl-four']>input")
	private List<WebElement> checkBoxList;
	
	@FindBy(className="del-btn-name")
	private WebElement deleteButton;
	
	@FindBy(id="upload_logo")
	private WebElement uploadLogo;
	
	@FindBy(className="review-tab")
	private WebElement paymentOptionTab;
	
	@FindBy(className="contact-person-tab")
	private WebElement contactPersonTab;
	
	@FindBy(className="doctor-details-tab")
	private WebElement doctorDetailsTab;
	
	@FindBy(className="jspTrack")
	private WebElement scroller;
	
	@FindBy(css="div[class^='jspDrag']")
	private WebElement jspDrag;
	
	@FindBy(className="declaration_check")
	private WebElement declerationCheck;

	
	@FindBy(className="confirm_popup_captche")
	private WebElement confirmPopupCaptche;
	
	@FindBy(id="captcha")
	private WebElement captchaText;
	
	@FindBy(id="confirm_save_mc")
	private WebElement confirmOKButton;
	
	/***************************************Getting WebElements to Test cases ************************************* 
	 * @throws Exception */
	
	public void acceptDeclerationAndSubmit() throws Exception
	{
		browser.check(declerationCheck);
		browser.waitForEditable(submitRegistrationDetails);
		browser.click(submitRegistrationDetails);
	}
	
	public WebElement getRepresentative2MobileNumber()
	{
		return representative2MobileNumber;
	}
	
	public WebElement getRepresentative2EmailDetails()
	{
		browser.waitForVisible(representative2EmailDetails);
		return representative2EmailDetails;
	}
	/*
	public WebElement getRepname2Text()
	{
		return repname2Text;
	}
	*/
	public WebElement getOwner2EmailValidation()
	{
		return owner2EmailValidation;
	}
	
	public WebElement getOwner2fullnameValidation()
	{
		return owner2fullnameValidation;
	}
	
	public WebElement getOwner2DesignationValidation()
	{
		return owner2DesignationValidation;
	}
	
	/** ***********************************Performing actions and verification ******************************************** 
	 * @throws Exception 
	 * @throws InterruptedException */
	
	public void clickPreviousButton() throws Exception
	{
		browser.click(prevButton);
	}
	
	public void clickNextButton() throws Exception
	{
		browser.click(nxtButton);
	}
	
	public void clickDoctorDetailsTab() throws Exception
	{
		browser.Wait(1);
		browser.click(doctorDetailsTab);
	}
	
	public void clickContactPersonTab() throws Exception
	{
		browser.Wait(1);
		browser.click(contactPersonTab);
	}
	
	public void clickPaymentOptionTab() throws Exception
	{
		browser.Wait(1);
		browser.click(paymentOptionTab);
	}
	
	public void clickAttachDocumentTab() throws Exception
	{
		browser.Wait(1);
		browser.click(attachDocumentTab);
	}
	
	public void assertActiveTab(String ActiveTab)
	{
		browser.waitForVisible(activeTab);
		browser.assertText(activeTab, ActiveTab);
	}
	
	
	public void assertElementInPage() throws Exception
	{
		browser.assertVisible(ownerContact1);
	}
	public void enterMedicalCenterDetails(String medicalcentername,String registrationnumber,String medicalcenteraddressline1,String email,String fax,String weekdayfrom,String weekdayto) throws Exception{
		logger.info("Typing medical center name");
		browser.type(medicalCenterName, medicalcentername);
		logger.info("typing registration number");
		browser.typeRandomNumbers(registrationNumber, registrationnumber);
		logger.info("typing medical center address in line1");
		browser.type(medicalCenterAddressLine1, medicalcenteraddressline1);
		logger.info("typing email");
		browser.type(this.email, email);
		logger.info("typing fax number");
		browser.type(this.fax, fax);
		logger.info("clicking weekday from select button");
		browser.click(weekDayFromSelect);
		logger.info("selecting option from weekday from select");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("document.getElementById('dk_container_week_from').focus"); 
	 	driver.findElement(By.id("dk_container_week_from")).sendKeys(Keys.ARROW_UP);
	 	js.executeScript("document.getElementById('dk_container_week_from').focus");
		driver.findElement(By.id("dk_container_week_from")).sendKeys(Keys.ARROW_UP);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		driver.findElement(By.id("dk_container_week_from")).sendKeys(Keys.ENTER);

		logger.info("clicking weekday to select buton");
		browser.click(weekDayToSelect);
		logger.info("selecting option from weekday to select");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	 	js1.executeScript("document.getElementById('dk_container_week_to').focus"); 
	 	driver.findElement(By.id("dk_container_week_to")).sendKeys(Keys.ARROW_UP); 
		js1.executeScript("document.getElementById('dk_container_week_to').focus"); 
		driver.findElement(By.id("dk_container_week_to")).sendKeys(Keys.ENTER);

		
	}
	
	public void clickNext() throws Exception{
		logger.info("clicking next button");
		browser.click(nextButton);
	}
	
	public void clickSave() throws Exception{
		logger.info("clicking save button");
		browser.Wait(2);
		browser.click(saveButton);
	}
	
	public void verifyConfirmPopupCaptchaAndBreakCaptche() throws Exception
	{
		logger.info("Verifying confirm popup");
		browser.waitForVisible(confirmPopupCaptche);
		browser.waitForEditable(captchaText);
		do{
			browser.focus(captchaText);
			browser.clearAndType(captchaText, "9");
			browser.click(confirmOKButton);
			browser.Wait(1);
		}while(confirmPopupCaptche.isDisplayed());
		
	}
	
	public void clickSave1() throws Exception{
		logger.info("clicking save button");
		browser.click(saveButton);
	}
	
	public void assertSavedMessage() throws Exception{
		waitForStatusBarToBeVisibleAndVerifyContainsText("Your data has been saved.");
		//browser.assertTrue(browser.getText(statusBar).contains("Your data has been saved."));
	}
	
	public String getApplicationId() throws Exception{
		browser.Wait(1);
		String statusMessage = browser.getText(statusBar);
		statusMessage=statusMessage.replace("Your data has been saved. Your application id is ", "");
		String applicationId = statusMessage.substring(0,statusMessage.lastIndexOf("."));
		logger.info("new appilication id is "+applicationId);
		return applicationId.trim();
	}
	
	public void assertApplicationIdInHeader(String applicationid) throws Exception{
		browser.isElementPresent(applicationId);
		browser.Wait(2);
		browser.assertText(applicationId, applicationid);
	}
	
	public void attachLogo(String filePath) throws Exception{
		logger.info("ataching file "+filePath);
		browser.type(attachLogo, filePath);
		browser.click(uploadLogo);
	}
	
	public void enterContactPersonOwnerDetails(String owner_name1,String owner_designation1,String owner_email1,String owner_contact1) throws Exception{
		logger.info("typing owner full name");
		browser.type(ownerName1, owner_name1);
		logger.info("typing owner designation");
		browser.type(ownerDesignation1, owner_designation1);
		logger.info("typing owner email");
		browser.type(ownerEmail1, owner_email1);
		logger.info("typing owner contact");
		browser.type(ownerContact1, owner_contact1);
	}
	
	public void enterContactPersonOwner2Details(String owner_name2,String owner_designation2,String owner_email2,String owner_contact2){
		logger.info("typing owner2 full name");
		browser.type(ownerName2, owner_name2);
		logger.info("typing owner2 designation");
		browser.type(ownerDesignation2, owner_designation2);
		logger.info("tying owner2 email");
		browser.clearAndType(ownerEmail2, owner_email2);
		logger.info("tying owner2 contact");
		browser.type(ownerContact2, owner_contact2);
	}
	
	public void enterContactPersonRepresentativeDetails(String rep_name1,String rep_email1,String rep_contact1){
		logger.info("typing representative1 full name");
		browser.type(repName1, rep_name1);
		logger.info("typing representative email");
		browser.type(repEmail1, rep_email1);
		logger.info("typing representative contact");
		browser.type(repContact1, rep_contact1);
	}
	
	public void enterContactPersonRepresentative2Details(String rep_name2,String rep_email2,String rep_contact1)
	{
		logger.info("typing representative2 full name");
		browser.type(repname2Text, rep_name2);
		logger.info("typing representative email");
		browser.type(repemail2Text, rep_email2);
		logger.info("typing representative contact");
		browser.type(repcontact2Text, rep_contact1);
	}
	
	
	public void enterContactPersonRepresentative2Name(String rep_name2)
	{
		logger.info("typing representative2 full name");
		browser.clearAndType(repname2Text, rep_name2);
	}
	
	public void clearRepresentative2Name() throws Exception
	{
		logger.info("Clearing representative2 name");
		browser.clear(repname2Text);
		browser.Wait(1);
	}
	
	public void enterDoctorDetails(String doctor_fullname,String doctor_professionalid,String doctor_qualification,String doctor_address,String doctor_signature,String doctor_stamp) throws Exception{
		logger.info("typing doctor name");
		browser.clearAndType(doctorFullName, doctor_fullname);
		logger.info("typing doctor professional id");
		browser.type(doctorProfessionalId, doctor_professionalid);
		logger.info("typing doctor qualification");
		browser.type(doctorQualification, doctor_qualification);
 		logger.info("typing doctor address");
		browser.type(doctorAddress1, doctor_address);
		logger.info("attaching doctor signature");
		browser.type(doctorSignature, doctor_signature);
		logger.info("attaching doctor stamp");
		browser.type(doctorStamp, doctor_stamp);
		browser.Wait(1);
	}
	
	public void editDoctorDetails(String doctor_fullname,String doctor_qualification,String doctor_address){
		logger.info("editing doctor name");
		browser.clearAndType(doctorFullName, doctor_fullname);
		
		logger.info("editing doctor qualification");
		browser.clearAndType(doctorQualification, doctor_qualification);
 		logger.info("editing doctor address");
		browser.clearAndType(doctorAddress1, doctor_address);
	}

	public void saveDoctorDetails() throws Exception{
		logger.info("clicking on save in doctors tab");
		browser.click(doctorSave);
		browser.Wait(2);
	}
	
	public void updateDoctorDetails() throws Exception{
		logger.info("clicking on save in doctors tab");
		browser.click(doctorUpdateButton);
	}
	
	public void deleteDocterDetails() throws Exception
	{
		logger.info("Deleting doctor ");
		browser.click(doctorDeleteButton);
	}
	public void assertDoctorSavedMessage() throws Exception{
		logger.info("checking message in status bar after doctor saved");
		browser.waitForVisible(statusBar);
		browser.verifyText(statusBar, "Doctor details have been successfully added.");
	}
	
	public void assertDoctorUpdateMessage(){
		logger.info("checking message in status bar after doctor update");
		browser.waitForVisible(statusBar);
		browser.assertText(statusBar, "Doctor details has been updated successfully.");
	}
	
	public void assertDoctorDeleteMessage(){
		logger.info("checking message in status bar after doctor delete");
		browser.waitForVisible(statusBar);
		browser.assertText(statusBar, "Doctor details deleted successfully!");
	}
	
	public void closeStatusMessageBar() throws Exception{
		browser.click(statusBar);
		browser.Wait(1);
	}
	
	public void SelectDocterinTable(String DoctorName)
	{
		logger.info("Selecting docter "+DoctorName+"from Doctor table ");
		boolean foundDoctor = false;
		Iterator<WebElement> doctors = doctorsList.iterator();
		while(doctors.hasNext()){
			WebElement eachDoctor = doctors.next();
			if(browser.getText(eachDoctor).equals(DoctorName)){
				logger.info("doctor in the list found");
				eachDoctor.click();
				foundDoctor = true;
				break;
			}
		}
		browser.assertTrue(foundDoctor, " Doctor "+DoctorName+" in the list not found");
	}
	public void waitForSomeTime(int sec) throws Exception
	{
		browser.Wait(sec);
	}
	public void assertSavedDoctorInList(String doctor_fullname) {
		logger.info("checking for doctor in the doctors list");
		boolean foundDoctor = false;
		Iterator<WebElement> doctors = doctorsList.iterator();
		while(doctors.hasNext()){
			WebElement eachDoctor = doctors.next();
			if(browser.getText(eachDoctor).equals(doctor_fullname)){
				logger.info("doctor in the list found");
				foundDoctor = true;
			}
		}
		browser.assertTrue(foundDoctor, " Doctor in the list not found");
	}
	
	public void verifyDocumentListRequired(String doc1,String doc2,String doc3,String doc4,String doc5,String doc6) throws Exception
	{
		logger.info("Verify the required document in Attach Document page");
		browser.click(selectDocumentTypeOption);
		String actualRegCetificate=registrationCertificateOption.getText();
		System.out.println(actualRegCetificate);
		browser.assertText(registrationCertificateOption, doc1);
		browser.assertText(proofOfIdentityFirstOwnerOption, doc2);
		browser.assertText(medicalCenterStampOption, doc3);
		browser.assertText(proofOfIdentitySecondOwnerOption, doc4);
		browser.assertText(letterOfAuthorizationForSecondRepOption, doc5);
		browser.assertText(letterOfAuthorizationForFirstRepOption, doc6);
		//browser.click(selectDocumentTypeOption);
	}
	
	public void attachDocuments(String reg_cer_document,String proof_of_identity_document,String medical_center_stamp,String proof_of_identity_second_owner,String letter_of_auth_second,String letter_of_auth_first) throws Exception{
		browser.Wait(3);
		logger.info("uploading registration certification document");
		selectDocumentTypeOption.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_UP);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		attachementdropDown.sendKeys(Keys.ENTER);
		 browser.Wait(3);
		browser.type(documentAttach, reg_cer_document); 
		browser.Wait(1);
		browser.click(uploadDocument);
		browser.waitForElementSize(uploadedDocumentsInGrid, 1);
		browser.Wait(1);
    	logger.info("uploading proof of identity document");
		browser.click(selectDocumentTypeOption);
		browser.Wait(3);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_DOWN);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_DOWN);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		attachementdropDown.sendKeys(Keys.ENTER);
 
		//browser.click(proofOfIdentityFirstOwnerOption);
		browser.type(documentAttach, proof_of_identity_document);
		browser.Wait(1); 
		browser.click(uploadDocument);
		browser.waitForElementSize(uploadedDocumentsInGrid, 2);
		browser.Wait(1);
    	logger.info("uploading medical center stamp document");
		browser.click(selectDocumentTypeOption);
		browser.Wait(3);
		//browser.click(medicalCenterStampOption);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_DOWN); 
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		attachementdropDown.sendKeys(Keys.ENTER);
		browser.type(documentAttach, medical_center_stamp);
		browser.Wait(1);
		browser.click(uploadDocument);
		browser.waitForElementSize(uploadedDocumentsInGrid, 3);
		browser.Wait(1);
		logger.info("uploading proof of identity owner2 document");
    	browser.click(selectDocumentTypeOption);
    	browser.Wait(3);
    	//browser.click(proofOfIdentitySecondOwnerOption);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_DOWN); 
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		attachementdropDown.sendKeys(Keys.ENTER);
    	browser.type(documentAttach, proof_of_identity_second_owner);
    	browser.Wait(1);
    	browser.click(uploadDocument);
    	browser.waitForElementSize(uploadedDocumentsInGrid, 4);
    	browser.Wait(1);
    	logger.info("uploading letter of authorization for second representative");
    	browser.click(selectDocumentTypeOption);
    	browser.Wait(3);
    	//browser.click(letterOfAuthorizationForSecondRepOption);
		js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_DOWN); 
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		attachementdropDown.sendKeys(Keys.ENTER);
		browser.Wait(3);
    	browser.type(documentAttach, letter_of_auth_second);
    	browser.Wait(1);
    	browser.click(uploadDocument);
    	browser.waitForElementSize(uploadedDocumentsInGrid, 5);
    	browser.Wait(1);
    	logger.info("uploading letter of authorization for first representative");
    	browser.click(selectDocumentTypeOption);
    	browser.Wait(3);
    	//browser.click(letterOfAuthorizationForFirstRepOption);
    	js.executeScript("document.getElementById('dk_container_doc_attach').focus");  
		attachementdropDown.sendKeys(Keys.ARROW_DOWN); 
		js.executeScript("document.getElementById('dk_container_doc_attach').focus"); 
		attachementdropDown.sendKeys(Keys.ENTER);
		browser.Wait(3);
    	browser.type(documentAttach, letter_of_auth_first);
    	browser.Wait(1);
    	browser.click(uploadDocument);
    	browser.waitForElementSize(uploadedDocumentsInGrid, 6);
    	browser.Wait(1);
    	logger.info("attaching documents completed"); 
	}
	
	public void doPayment() throws Exception{
		logger.info("clicking credit limit model");
		browser.waitForEditable(creditLimitBasedModel);
		browser.click(creditLimitBasedModel);
		logger.info("asserting pay mode is visible");
		browser.assertVisible(selectedPayMode);
		logger.info("clicking submit resigration");
		browser.click(submitRegistrationDetails);
		logger.info("waiting for the confirmation popup");
		browser.waitForVisible(confirmationPopup);
		logger.info("checking confirmation popup message");
		browser.assertText(confirmationMessage, "You are going to submit registration details. Are you sure?");
		logger.info("clicking Ok in confirmation");
		browser.click(confirmOk);
	}
	
	public void doPaymentWhilePartialRegistration() throws Exception{
		logger.info("clicking credit limit model");
		browser.click(creditLimitBasedModel);
		logger.info("asserting pay mode is visible");
		browser.assertVisible(selectedPayMode);
		logger.info("clicking submit resigration");
		browser.click(submitRegistrationDetails);
	}
	
	public void assertMedicalStatusIndicator(String application_id) throws Exception{
		logger.info("waiting for the medical status indicator");
		browser.waitForEditable(medicalStatusIndicator);
		logger.info("checking the message in medical status indicator");
		browser.verifyText(medicalStatusIndicator, "Thanks for registering with us. Your application ID is "+application_id+". This will be processed within next 72 hours. Details of your application are as given below.");
	}
	
	public void assertDetailsPostSubmit(String application_id,String medicalCenterAddress,String contactPerson) throws Exception
	{
		logger.info("waiting for the medical status indicator");
		browser.waitForEditable(medicalStatusIndicator);
		logger.info("checking the message in medical status indicator");
		logger.info("Thanks for registering with us. Your application ID is "+application_id+". This will be processed within next 72 hours. Details of your application are as given below.");
		browser.verifyText(medicalStatusIndicator, "Thanks for registering with us. Your application ID is "+application_id+". This will be processed within next 72 hours. Details of your application are as given below.");
		browser.assertVisible(medicalCenterNameDisplay);
		browser.assertText(medicalCenterAddressDisplay, medicalCenterAddress);
		browser.assertText(medicalCenterContactDisplay, contactPerson);
	}
	
	public void verifyElementsPresentInMedicalCenterPage() throws Exception{
		browser.verifyVisible(medicalCenterName);
		browser.verifyVisible(registrationNumber);
	}

	public void VerifyDoctorSignatureAndStamp() throws Exception{
		logger.info("checking for doctor signature and stamp Attachment");
		browser.verifyElementPresent(doctorSignature);
		browser.verifyElementPresent(doctorStamp);
	
	}
	
	public void selectDocterInList(String DocterName)
	{
		logger.info("Select doctor from table");
		browser.findElement(By.xpath("//div[@id='list_doctor']/div/span[text()='"+DocterName+"']")).click();
	}
	
	public void verifyAttachedDocs(String DocumentToBeVerified) throws Exception
	{
		logger.info("Verify attached documents in Attache Document Tab");
		WebElement attachedDoc=browser.findElement(By.xpath("//div[@class='grid-doc-row']/div/span[text()='"+DocumentToBeVerified+"']"));
		if(!browser.isVisible(attachedDoc)){
			browser.mouseOver(attachedDoc);
			browser.executeJavascript("scroll(0, 20)");
		}
		browser.verifyElementPresent(attachedDoc);
	}
	
	public void enterEmailAddressforOwner2(String invalidEmail){
		logger.info("typing invalid email for owner2");
		browser.clearAndType(ownerEmail2, invalidEmail);
	}
	
	public void verifyValidationMessage(WebElement element,String validationMessage) throws Exception
	{
		logger.info("Verifying validation message");
		browser.verifyText(element, validationMessage);
	}
	
	public void verifyValidationDisplayed(WebElement element) throws Exception
	{
		logger.info("Verifying validation message");
		browser.assertElementPresent(element);
	}
	
	public void searchForAppID(String AppID){
		logger.info("Typing AppID in Search test");
		browser.type(AppIDSearchButton, AppID);
		searchButton.click();
	}
	
	public void AssertDuplicationErrorForDoctorProfID(String ErrorMsg){
		logger.info("Asserting Error message for Duplicating doctor record");
		browser.assertText(professionalIDErrorMsg, ErrorMsg);
	}
	
	public void VerifyAppearenceOfDeleteUpdateCancelButtons() throws Exception
	{
		browser.verifyVisible(doctorCancelButton);
		browser.verifyVisible(doctorUpdateButton);
		browser.verifyVisible(doctorDeleteButton);
	}
	
	public void VerifyDocumentSizeDisplayed(int rowNum) throws Exception
	{
		logger.info("Verifying Document size display in row"+ rowNum);
		WebElement documentSize=browser.findElement(By.xpath("//div[@class='row-spacer-hr']/div["+rowNum+"]//span[3]"));
		browser.verifyElementPresent(documentSize);
	}
	
	public void deleteDocumentWRTOptionAndAssert(String optionName) throws Exception{
		Iterator<WebElement> documents = documentsList.iterator();
		int i=0;
		boolean isDocumentOptionPresent = false;
		scrollUpToVisible(documentsList.get(0));
		while(documents.hasNext()){
			WebElement eachDocument = documents.next();
			if(!browser.isVisible(eachDocument)){
				
				scrollDownToVisible(eachDocument);
			}
			if(browser.getText(eachDocument).contains(optionName)){
				isDocumentOptionPresent = true;
				browser.check(checkBoxList.get(i));
				browser.click(deleteButton);
				break;
			}
			i++;
		}
		browser.assertTrue(isDocumentOptionPresent, "Could not find the option "+optionName+" in attach document list option");
		scrollUpToVisible(documentsList.get(0));
		while(documents.hasNext()){
			WebElement eachDocument = documents.next();
			if(!browser.isVisible(eachDocument)){
				scrollDownToVisible(eachDocument);
			}
			if(browser.getText(eachDocument).contains(optionName)){
				browser.assertFail("Unable to delete against option "+optionName);
			}
		}
	}
	
	private void scrollDownToVisible(WebElement element){
		if(!browser.isVisible(element)){jspDrag.getSize();
			browser.actions().clickAndHold(jspDrag).moveByOffset(0, 50).release().build().perform();
			scrollDownToVisible(element);
		}
	}
	
	private void scrollUpToVisible(WebElement element){
		if(!browser.isVisible(element)){
			browser.actions().clickAndHold(jspDrag).moveByOffset(0, -50).release().build().perform();
			scrollDownToVisible(element);
		}
	}
	
}
