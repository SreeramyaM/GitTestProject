package org.fwcms.pages.tc;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.fwcms.tc.mcRegistrationPages.Representative2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchMedicalCenterPage {

private static final Logger logger = LogManager.getLogger(SearchMedicalCenterPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public SearchMedicalCenterPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public SearchMedicalCenterPage initElements()
	{
		return PageFactory.initElements(driver, SearchMedicalCenterPage.class);
	}
	
	@FindBy(id="search_mc_status_country")
	private WebElement searchMedicalCenterText;
	
	@FindBy(className="mid_btn")
	private WebElement searchButton;
	
	@FindBy(css="input[value='byName']")
	private WebElement byNameRadio;
	
	@FindBy(css="input[value='byTransactionID']")
	private WebElement byTransactionIDRadio;
	
	@FindBy(css="input[value='byAppID']")
	private WebElement byAppIdRadio;
	
	@FindBy(css="input[value='byRegNo']")
	private WebElement byRegNoRadio;
	
	@FindBy(css="input[value='byMC']")
	private WebElement byMcIDRadio;
	
	@FindBy(css="div[class^='res_mc_name']")
	private List<WebElement> MCnamesDisplay;
	
	@FindBy(css="span[class$='mc_applicationId']")
	private WebElement appID;
	
	@FindBy(css="span[class$='mc_applicationId']")
	private List<WebElement> appIDList;
	
	@FindBy(css="div[class='result'] div[class^='form_row']>span:nth-child(5)")
	private WebElement registrationNo;
	
	@FindBy(id="mcId")
	private WebElement medicalCenterID;
	
	@FindBy(css="span[class$='mc_status']")
	private List<WebElement>  MCstatus;
	
	@FindBy(id="tab_mc_details")
	private WebElement MCdetailsTab;
	
	@FindBy(id="tab_owner_details")
	private WebElement OwnerDetailsTab;
	
	@FindBy(id="tab_rep_details")
	private WebElement RepresentativeDetailsTab;
	
	@FindBy(id="tab_doctor_details")
	private WebElement doctorDetailsTab;
	
	@FindBy(id="tab_docs")
	private WebElement DocumentsAttachedTab;
	
	@FindBy(id="tab_additional_verification")
	private WebElement referToAdminTab;
	
	@FindBy(id="vf_mc_verification_status")
	private WebElement MCVerificationCheck;
	
	@FindBy(id="vf_mc_inf_status")
	private WebElement MCInformationCheck;
	
	@FindBy(id="vf_verification_status_ow1")
	private WebElement owner1VerificationCheck;
	
	@FindBy(id="vf_inf_status_ow1")
	private WebElement owner1InformationCheck;
	
	@FindBy(id="vf_verification_status_ow2")
	private WebElement owner2VerificationCheck;
	
	@FindBy(id="vf_infm_status_ow2")
	private WebElement owner2InformationCheck;
	
	@FindBy(id="vf_verification_status_rep1")
	private WebElement representative1VerificationCheck;
	
	@FindBy(id="vf_inf_status_rep1")
	private WebElement representative1InformtionCheck;
	
	@FindBy(id="vf_verification_status_rep2")
	private WebElement representative2VerificationCheck;
	
	@FindBy(id="vf_inf_status_rep2")
	private WebElement representative2InformtionCheck;

	@FindBy(id="vf_doctor_ckbxid0")
	private WebElement SelectDoctorCheck;
	
	@FindBy(id="vf_emailid")
	private WebElement emailValidation;
	
	@FindBy(id="sendemail")
	private WebElement sendEmailButton;
	
	@FindBy(id="save_mc_details")
	private WebElement saveButton;
	
	@FindBy(id="reject_mc_details")
	private WebElement rejectButton;
	
	@FindBy(id="verify_mc_details")
	private WebElement verifyButton;
	
	@FindBy(css="div[class^='statusBar']")
	private WebElement statusBar;
	
	@FindBy(id="confirm_operation")
	private WebElement confirmOk;
	
	@FindBy(className="confirm_popup")
	private WebElement confirmPopup;
	
	@FindBy(className="details_popup_close")
	private WebElement closeButton;
	
	@FindBy(id="confirmation_message")
	private WebElement confirmationMessage;
	
	@FindBy(id="overlay")
	private WebElement overlay;
	
	@FindBy(id="vf_mc_appId")
	private WebElement appIDDisplay;
	
	@FindBy(css="span[class$='mc_status']")
	private WebElement MCStatus;
	
	@FindBy(id="checkAll_countries")
	private WebElement checkAllCountries;
	
	@FindBy(id="checkAll_status")
	private WebElement checkAllStatus;
	
	@FindBy(xpath="//*[@id='mcCreditLimit']")
	private WebElement mcCreditLimitText;
	
	@FindBy(xpath="//div[@id='setCreditLimitDiv']//div[@id='edit-btn']//span[2]")
	private WebElement setCreditLimit;
	
	@FindBy(css="div[id='updateCreditLimitDiv']>div:nth-child(2)>span:nth-child(2)")
	private WebElement updateEditButton;
	
	@FindBy(id="approve_btn")
	private WebElement creditApproveButton;
	
	@FindBy(css="div[class$='transDetails']>span:nth-child(2)>span")
	private WebElement firsttransactionDetails;
	
	@FindBy(id="registrationPendingAmount")
	private WebElement registrationPendingAmount;
	
	@FindBy(css="input[value='PENDING_VERIFICATION']")
	private WebElement pendingVerificationCheck;
	
	@FindBy(css="input[value='MC_UPDATE_PENDING_VERIFICATION']")
	private WebElement pendingUpdateVerificationCheck;
	
	@FindBy(css="input[value='PENDING_PAYMENT']")
	private WebElement pendingPaymentCheck;
	
	@FindBy(css="input[value='PENDING_APPROVAL']")
	private WebElement pendingApprovalCheck;
	
	@FindBy(css="input[value='ACTIVE']")
	private WebElement activeCheck;
	
	@FindBy(css="input[value='BLOCKED']")
	private WebElement blockedCheck;
	
	@FindBy(css="div[class^=searchFilter]")
	private WebElement searchFilter;
	
	@FindBy(css="div[id='countryList']>div>span:nth-child(1)>input")
	private List<WebElement> countriesList;
	
	@FindBy(css="div[id='statusList']>div>span:nth-child(1)>input")
	private List<WebElement> statusList;
	
	@FindBy(css="div[class$='mcDetails']>span:nth-child(2)>span")
	private List<WebElement> medicalCenterDetailsButtonList;
	
	@FindBy(css="div[class$='mcDetails']>span:nth-child(2)>span")
	private WebElement medicalCenterDetailsButton;
	
	@FindBy(css="div[class$='transDetails']>span:nth-child(2)>span")
	private WebElement transactionDetailsButton;
	
	@FindBy(css="div[class$='transDetails']>span:nth-child(2)>span")
	private List<WebElement> transactionDetailsButtonList;
	
	
	@FindBy(className="result")
	private List<WebElement> medicalCenterList;
	
	@FindBy(className="result")
	private WebElement medicalCenter;
	
	@FindBy(css="div[class^='vf_verification_status_rep1formError']")
	private WebElement rep1VerificationCheckBoxError;
	
	@FindBy(css="div[class^='vf_inf_status_rep1formError']")
	private WebElement repInformationCheckBoxError;
	
	@FindBy(id="update_btn")
	private WebElement creditLimitSaveButton;
	
	@FindBy(id="reject_btn")
	private WebElement rejectMCButton;
	
	@FindBy(className="mc_tabs")
	private WebElement MCTabs;
	
	@FindBy(id="vf_mc_name")
	private WebElement verifyMCname;
	
	@FindBy(id="vf_mc_reg_id")
	private WebElement verifyMCRegNo;
	
	@FindBy(id="vf_mc_address")
	private WebElement verifyMCAddress;
	
	@FindBy(id="vf_mc_ow1_nm")
	private WebElement verifyOwner1Name;
	
	@FindBy(id="vf_mc_ow1_deg")
	private WebElement verifyOwner1Designation;
	
	@FindBy(id="vf_mc_ow1_email")
	private WebElement verifyOwner1Email;
	
	@FindBy(id="vf_mc_ow1_cnct")
	private WebElement verifyOwner1Contact;
	
	@FindBy(id="vf_mc_ow2_nm")
	private WebElement verifyOwner2Name;
	
	@FindBy(id="vf_mc_ow2_deg")
	private WebElement verifyOwner2Designation;
	
	@FindBy(id="vf_mc_ow2_email")
	private WebElement verifyOwner2Email;
	
	@FindBy(id="vf_mc_ow2_cnct")
	private WebElement verifyOwner2Contact;
	
	@FindBy(id="vf_mc_rep1_nm")
	private WebElement verifyrep1Name;
	
	@FindBy(id="vf_mc_rep1_email")
	private WebElement verifyrep1Email;
	
	@FindBy(id="vf_mc_rep1_cnct")
	private WebElement verifyrep1Contact;
	
	@FindBy(id="vf_mc_rep2_nm")
	private WebElement verifyrep2Name;
	
	@FindBy(id="vf_mc_rep2_email")
	private WebElement verifyrep2Email;
	
	@FindBy(id="vf_mc_rep2_cnct")
	private WebElement verifyrep2Contact;
	
	@FindBy(css="div[class^='jspDrag']")
	private WebElement jspDrag;
	
	@FindBy(className="pageHeading")
	private WebElement pageHeader;
	
	@FindBy(className="rejectconfirm_popup")
	private WebElement rejectConfirmationPopup;
	
	@FindBy(id="vf_mc_reject_comments")
	private WebElement rejectCommentText;
	
	@FindBy(id="confirm_reject_operation")
	private WebElement rejectMCOKbutton;
	
	@FindBy(xpath="//img[@id='vf_mc_logo_id' and contains(@src,'image')]")
	private WebElement imageMedicalCenterLogo;
	
	
	
	
	boolean flag;
	
	
	//Performing actions
	public void uncheckAllStatusOperator() throws Exception{
		logger.info("Clicking on Search MC text box");
		browser.waitForVisible(searchMedicalCenterText);
		browser.click(searchMedicalCenterText);
		browser.waitForVisible(checkAllStatus);
		browser.uncheck(pendingVerificationCheck);
		browser.uncheck(pendingUpdateVerificationCheck);
		browser.uncheck(pendingPaymentCheck);
		browser.uncheck(activeCheck);
		browser.uncheck(blockedCheck);
	}
	
	public void ClickHeader() throws Exception
	{
		browser.click(pageHeader);
	}
	
	public void uncheckAllStatusPrivileged() throws Exception{
		logger.info("Clicking on Search MC text box");
		browser.waitForEditable(searchMedicalCenterText);
		browser.click(searchMedicalCenterText);
		browser.waitForVisible(checkAllStatus);
		browser.uncheck(pendingVerificationCheck);
		browser.uncheck(pendingUpdateVerificationCheck);
		browser.uncheck(pendingPaymentCheck);
		browser.uncheck(activeCheck);
		browser.uncheck(blockedCheck);
		browser.uncheck(pendingApprovalCheck);
	}
	
	
	public void clickTransactionDetailsButton() throws Exception
	{
		browser.waitForVisible(transactionDetailsButton);
		browser.click(transactionDetailsButton);
	}
	public void clickApplicationId() throws Exception
	{
		browser.waitForEditable(appID);
		browser.click(appID);
	}
	public String getCreditLimitFromActiveMC()
	{
		browser.waitForVisible(mcCreditLimitText);
		return browser.getText(mcCreditLimitText);
	}
	public void representativeVerificationErrorMessages(String errorMessage)
	{
		browser.assertText(rep1VerificationCheckBoxError, errorMessage);
		browser.assertText(repInformationCheckBoxError, errorMessage);
	}
	public void clickSearchAndCheckAllCountries() throws Exception
	{
		browser.click(searchMedicalCenterText);
		browser.click(checkAllCountries);
	}
	/*
	public WebElement pendingPaymentCheck()
	{
		return pendingPaymentCheck;
	}
	*/
	public String getPendingAmount()
	{
		return registrationPendingAmount.getText();	
	}
	/*
	public WebElement getTransactionDetailsButton()
	{
		return firsttransactionDetails;
	}
	*/
	public void clickApproveButton() throws Exception
	{
		 browser.click(creditApproveButton);
		 browser.click(confirmOk);
	}
	
	public void verifySuccessMessage(String message) throws Exception
	{
		browser.waitForVisible(statusBar);
		browser.assertText(statusBar, message);
		browser.click(statusBar);
	}
	public void setCreditLimit(String creditLimit) throws Exception
	{
		browser.waitForVisible(mcCreditLimitText);
		browser.click(setCreditLimit);
		//browser.click(mcCreditLimitText);
		browser.clearAndType(mcCreditLimitText, creditLimit);
	}
	
	public void updateCreditLimit(String creditLimit) throws Exception
	{
		browser.waitForVisible(mcCreditLimitText);
		browser.click(updateEditButton);
		//browser.click(mcCreditLimitText);
		browser.clearAndType(mcCreditLimitText, creditLimit);
	}
	
	public String getApplicationIDDisplayText()
	{
		browser.waitForVisible(appIDDisplay);
		return browser.getText(appIDDisplay);
	}
	
	public void waitForOverlayToHide() throws Exception{
		logger.info("waiting for loading message to disappear");
		browser.waitForNotVisible(overlay);
	}
	
	public void clickCloseButton() throws Exception 
	{
		browser.waitForVisible(closeButton);
		browser.click(closeButton);
	}
	
	public void sendMailForVerification(String emailID) throws Exception
	{
		browser.waitForVisible(emailValidation);
		browser.type(emailValidation, emailID);
		browser.click(sendEmailButton);
		browser.waitForVisible(statusBar);
		browser.assertText(statusBar, "An email is sent to the admin with Medical Center Details for Investigation.");
		browser.click(statusBar);
	}
	
	public void clickVerifyButton(String expectedMessage) throws Exception
	{
		browser.waitForVisible(verifyButton);
		browser.click(verifyButton);
		browser.waitForEditable(confirmOk);
		browser.click(confirmOk);
		browser.waitForVisible(statusBar);
		browser.verifyText(statusBar, expectedMessage);
		browser.click(statusBar);
	}
	
	public void clickVerifyMCButton() throws Exception
	{
		browser.waitForVisible(verifyButton);
		browser.click(verifyButton);
	}
	/*
	public WebElement getReferToAdminTab()
	{
		return referToAdminTab;
	}
	*/
	public void clickReferToAdminTab() throws Exception{
		browser.click(referToAdminTab);
	}
	/*
	public WebElement getDocumentsAttached()
	{
		return DocumentsAttachedTab;
	}
	*/
	public void clickDocumentsAttached() throws Exception
	{
		browser.Wait(1);
		browser.click(DocumentsAttachedTab);
	}
	
	public void clickDoctorDetailsTab() throws Exception
	{
		browser.click(doctorDetailsTab);
	}
	
	public void verifyDoctorDetails() throws Exception
	{
		logger.info("Verify Doctor details");
		browser.waitForVisible(SelectDoctorCheck);
		browser.check(SelectDoctorCheck);
	}
	public void verifyRepresentativeDetails(int checkRep2) throws Exception
	{
		logger.info("Verify representative details");
		browser.waitForVisible(representative1VerificationCheck);
		browser.check(representative1VerificationCheck);
		browser.check(representative1InformtionCheck);
		if(Representative2.YES==checkRep2){
			browser.check(representative2VerificationCheck);
			browser.check(representative2InformtionCheck);
		}else if(Representative2.CHECKANDVERIFY==checkRep2){
			if(representative2VerificationCheck.isDisplayed()){
				browser.check(representative2VerificationCheck);
				browser.check(representative2InformtionCheck);
			}
		}
	}
	
	public void clickRepresentativeDetailsTab() throws Exception
	{
		browser.click(RepresentativeDetailsTab);
	}
	
	public void clickOwnerDetailsTab() throws Exception
	{
		browser.click(OwnerDetailsTab);
		//return OwnerDetailsTab;
	}
	public void verifyMedicalCenterDetails() throws Exception
	{
		logger.info("Verify MC details");
		browser.waitForVisible(MCVerificationCheck);
		browser.check(MCVerificationCheck);
		browser.check(MCInformationCheck);
	}
	
	public void verifyOwnerDirectorDetails() throws Exception
	{
		logger.info("Verify Owner/Director details");
		browser.waitForVisible(owner1VerificationCheck);
		browser.check(owner1VerificationCheck);
		browser.check(owner1InformationCheck);
		browser.check(owner2VerificationCheck);
		browser.check(owner2InformationCheck);
		browser.Wait(3);
	}
	
	public void VerifyMCListWithStatus(String Status) throws Exception
	{
		logger.debug("Verify MC list status :"+Status );
		Iterator<WebElement> MCStatusDisplay = MCstatus.iterator();
		boolean MCstatusFount=false;
		while(MCStatusDisplay.hasNext()){
			WebElement eachStatus=MCStatusDisplay.next();
			scrollToVisible(eachStatus);
			/*
			if(!browser.isVisible(eachStatus)){
				browser.actions().clickAndHold(jspDrag).moveByOffset(0, 25).release().build().perform();
				//browser.mouseOver(eachStatus);
				//browser.executeJavascript("scroll(0, 20)");
			}
			*/
				browser.assertText(eachStatus, Status);
				MCstatusFount=true;
		}
		browser.assertTrue(MCstatusFount, "MC status not found");
	}
	
	private void scrollToVisible(WebElement element){
		if(!browser.isVisible(element)){
			browser.actions().clickAndHold(jspDrag).moveByOffset(0, 25).release().build().perform();
			scrollToVisible(element);
		}
	}
	
	public void selectMCWithStatus(String Status) throws Exception
	{
		
		logger.info("Selecting the 1st "+Status+" record in the List");
		Iterator<WebElement> MCStatusDisplay = MCstatus.iterator();
		boolean MCStatusFound=false;
		while(MCStatusDisplay.hasNext()){
			WebElement eachMCstatus = MCStatusDisplay.next();
			logger.info(eachMCstatus.getText());
			scrollToVisible(eachMCstatus);
			/*
			if(!browser.isVisible(eachMCstatus)){
				new Actions(driver).clickAndHold(jspDrag).moveByOffset(0, 15).build().perform();
				//browser.mouseOver(eachMCstatus);
				//browser.executeJavascript("scroll(0, 20)");
			}
			*/
			if(browser.getText(eachMCstatus).equals(Status)){
				MCStatusFound=true;
				logger.info("MC with status "+Status+" found");
				eachMCstatus.click();
				break;
			}
		
		}
		browser.assertTrue(MCStatusFound, "MC status not found");
	
	}
	public void searchByNameAndVerify(String MCName) throws Exception
	{
		logger.info("Searching MC by name");
		browser.click(byNameRadio);
		browser.type(searchMedicalCenterText, MCName);
		browser.click(checkAllCountries);
		browser.click(checkAllStatus);
		searchButton.sendKeys(Keys.ENTER);
		logger.info("Verifying MC by name "+MCName);
		new CommonElements(driver).initElements().waitForOverlayToHide();
		Iterator<WebElement> medicalCenters=MCnamesDisplay.iterator();
		boolean MCNameFound = false;
		while(medicalCenters.hasNext()){
			WebElement eachMCname = medicalCenters.next();
			if(browser.getText(eachMCname).contains(MCName)){
			
				MCNameFound=true;
				logger.info("found");
				browser.assertTrue(MCNameFound, "MC name found");
				
			}
		}
		browser.assertTrue(MCNameFound, "MC name not found");
	}
	
	public void searchByNameAndStatus(String MCName, String status) throws Exception
	{
		logger.info("Searching MC by name");
		browser.click(byNameRadio);
		browser.clearAndType(searchMedicalCenterText, MCName);
		
		if(status.equals("Pending Verification")){
			browser.waitForVisible(pendingVerificationCheck);
			browser.check(pendingVerificationCheck);
		}else if(status.equals("Pending Update Verification")){
			browser.waitForVisible(pendingUpdateVerificationCheck);
			browser.check(pendingUpdateVerificationCheck);
		}else if(status.equals("Pending Payment")){
			browser.waitForVisible(pendingPaymentCheck);
			browser.check(pendingPaymentCheck);
		}else if(status.equals("Pending Approval")){
			browser.waitForVisible(pendingApprovalCheck);
			browser.check(pendingApprovalCheck);
		}else if(status.equals("Active")){
			browser.waitForVisible(activeCheck);
			 browser.check(activeCheck);
		}else if(status.equals("Blocked")){
			browser.waitForVisible(blockedCheck);
			browser.check(blockedCheck);
		}else{
			browser.assertFail("No Status found");
		}
		
		//browser.click(searchButton);
		searchButton.sendKeys(Keys.ENTER);
		
		logger.info("Verifying MC by name "+MCName);
		new CommonElements(driver).initElements().waitForOverlayToHide();
		Iterator<WebElement> medicalCenters=MCnamesDisplay.iterator();
		boolean MCNameFound = false;
		while(medicalCenters.hasNext()){
			WebElement eachMCname = medicalCenters.next();
			System.out.println("MC Name From Appl="+eachMCname.getText());
			if(browser.getText(eachMCname).contains(MCName)){
				MCNameFound=true;
				logger.info("found");
				browser.assertTrue(MCNameFound, "MC name found");
				
			}
		}
		browser.assertTrue(MCNameFound, "MC name not found");
	}
	
	public String getApplicationID()
	{
		return browser.getText(appID);
	}
	
	public String getRegistrationNumber()
	{
		return browser.getText(registrationNo);
	}
	
	public String getMedicalCenterId() {
		return browser.getText(medicalCenterID);
	}
	
	public void searchByAppIDAndVerify(String ApplicationID) throws Exception
	{
		logger.info("Searching MC by Application ID");
		browser.click(byAppIdRadio);
		browser.clearAndType(searchMedicalCenterText, ApplicationID);
		//browser.click(searchButton);
		searchButton.sendKeys(Keys.ENTER);
		new CommonElements(driver).initElements().waitForOverlayToHide();
		logger.info("Verifying MC by Application ID "+ApplicationID);
		browser.waitForVisible(appID);
		browser.assertText(appID, ApplicationID);
	}

	public void searchByAppIDAndVerifyForStatus(String ApplicationID,String Status) throws Exception
	{
		logger.info("Searching MC by Application ID");
		browser.waitForEditable(byAppIdRadio);
		browser.click(byAppIdRadio);
		browser.clearAndType(searchMedicalCenterText, ApplicationID);
		searchButton.sendKeys(Keys.ENTER);
		new CommonElements(driver).initElements().waitForOverlayToHide();
		logger.info("Verifying MC status to be"+Status);
		browser.assertText(MCStatus, Status);
	}
	
	public void searchByRegistrationNoAndVerify(String registrationNum) throws Exception
	{
		logger.info("Searching MC by Registration number");
		browser.click(byRegNoRadio);
		browser.clearAndType(searchMedicalCenterText, registrationNum);
		searchButton.sendKeys(Keys.ENTER);
		logger.info("Verifying MC by registration no "+registrationNum);
		browser.assertText(registrationNo, registrationNum);
	}

	public void searchByMedicalCenterIDandVerify(String medicalCenterIDNo) throws Exception
	{
		logger.info("Searching Medical center ID");
		browser.click(byMcIDRadio);
		browser.clearAndType(searchMedicalCenterText, medicalCenterIDNo);
		searchButton.sendKeys(Keys.ENTER);
		logger.info("Verifying MC by registration no "+medicalCenterID);
		browser.assertText(medicalCenterID, medicalCenterIDNo);
	}
	/*
	public WebElement getAllCountriesCheck()
	{
		return checkAllCountries;
	}
	*/
	
	
	public void searchByCountry(String countryName) throws Exception{
		
		logger.debug("Click on Search text and check "+countryName+" check box");
		browser.click(searchButton);
		browser.waitForVisible(searchFilter);
		Iterator<WebElement> countries = countriesList.iterator();
		boolean foundCountry=false;
		while(countries.hasNext()){
			WebElement eachCountry=countries.next();
			if(browser.getValue(eachCountry).equals(countryName)){
				browser.click(eachCountry);
				foundCountry=true;
				break;
			}
		}
		browser.assertTrue(foundCountry,"Country not found in the list");
	}
	
	public void searchByStatusAndClickSearch(String Status) throws Exception{
		Iterator<WebElement> status = statusList.iterator();
		boolean foundStatus=false;
		while(status.hasNext()){
			WebElement eachStatus=status.next();
			if(browser.getValue(eachStatus).equals(Status)){
				browser.click(eachStatus);
				foundStatus=true;
				break;
			}
		}
		browser.assertTrue(foundStatus,"Status not found in the list");
		searchButton.sendKeys(Keys.ENTER);
	}
	


	public void selectMCinListAndClickOnTransactionDetails() throws Exception
	{
		browser.waitForEditable(appID);
		//browser.Wait(1);
		browser.click(appID);
		browser.waitForEditable(medicalCenterDetailsButton);
		logger.debug("verifying MC Details button & Transaction Details Button");
		browser.verifyVisible(medicalCenterDetailsButton);
		browser.verifyVisible(transactionDetailsButton);
		browser.Wait(1);
		browser.click(transactionDetailsButton);
	}
	
	public void selectMCinListAndClickOnMedicalCenterDetails(int listNo) throws Exception
	{
        browser.click(medicalCenterList.get(listNo));
		logger.debug("verifying MC Details button & Transaction Details Button");
		browser.verifyVisible(medicalCenterDetailsButtonList.get(listNo));
		browser.verifyVisible(transactionDetailsButtonList.get(listNo));
		browser.click(medicalCenterDetailsButtonList.get(listNo));
	}
	
	public void rejectMedicalCenter() throws Exception
	{
		browser.waitForVisible(rejectButton);
		browser.click(rejectButton);
	}
	
	public void rejectConfirmationPopupWithReason(String reason) throws Exception
	{
		browser.verifyVisible(rejectConfirmationPopup);
		browser.type(rejectCommentText, reason);
		browser.click(rejectMCOKbutton);
	}
	
	public void saveVerificationDetails() throws Exception
	{
		browser.click(saveButton);
	}

	public void verifyMedicalCenterSavedDetails() throws Exception
	{
		logger.info("Verifying medical center Saved details");
		browser.waitForVisible(MCVerificationCheck);
		browser.verifyChecked(MCVerificationCheck);
		browser.verifyChecked(MCInformationCheck);
	}
	
	public void verifyOwenerDirectorSavedDetails() throws Exception
	{
		logger.info("Verifying Owner director Saved details");
		browser.click(OwnerDetailsTab);
		browser.waitForVisible(owner1VerificationCheck);
		browser.verifyChecked(owner1VerificationCheck);
		browser.verifyChecked(owner1InformationCheck);
		browser.verifyChecked(owner2VerificationCheck);
		browser.verifyChecked(owner2InformationCheck);
	}
	
	public void representativeSavedDetails() throws Exception
	{
		logger.info("Verifying representative Saved details");
		browser.click(RepresentativeDetailsTab);
		browser.waitForVisible(representative1VerificationCheck);
		browser.verifyChecked(representative1VerificationCheck);
		browser.verifyChecked(representative1VerificationCheck);
		if(representative2VerificationCheck.isDisplayed()){
		browser.verifyChecked(representative2VerificationCheck);
		browser.verifyChecked(representative2VerificationCheck);
		}
	}
	
	public void verifyDoctorSavedDetails() throws Exception
	{
		logger.info("Verifying representative Saved details");
		browser.click(doctorDetailsTab);
		browser.waitForVisible(SelectDoctorCheck);
		browser.verifyChecked(SelectDoctorCheck);
}
	public void searchMCByName(String MCName) throws Exception
	{
		logger.info("Searching MC by name");
		browser.click(byNameRadio);
		browser.clearAndType(searchMedicalCenterText, MCName);
		browser.click(checkAllCountries);
		browser.click(checkAllStatus);
		//browser.click(searchButton);
		searchButton.sendKeys(Keys.ENTER);
	}
	
	public void searchByApplicationID(String AppID) throws Exception
	{
		logger.info("Searching MC by application ID");
		browser.click(byAppIdRadio);
		browser.clearAndType(searchMedicalCenterText, AppID);
		browser.click(checkAllCountries);
		browser.click(checkAllStatus);
		searchButton.sendKeys(Keys.ENTER);
	}
	
	public void searchByRegistrationNo(String regNo) throws Exception
	{
		logger.info("Searching MC by registration no");
		browser.click(byRegNoRadio);
		browser.clearAndType(searchMedicalCenterText, regNo);
		browser.click(checkAllCountries);
		browser.click(checkAllStatus);
		searchButton.sendKeys(Keys.ENTER);
	}
	
	public void searchByMedicalCenterID(String MID) throws Exception
	{
		logger.info("Searching MC by Medical center ID");
		browser.click(byMcIDRadio);
		browser.clearAndType(searchMedicalCenterText, MID);
		browser.click(checkAllCountries);
		browser.click(checkAllStatus);
		searchButton.sendKeys(Keys.ENTER);
	}
	
	public void clickCreditLimitSaveButton() throws Exception
	{
		browser.click(creditLimitSaveButton);
	}
	
	public void verifyConfirmationPopupAndClickOK() throws Exception
	{
		logger.info("Verfying confirmation popup");
		browser.verifyVisible(confirmPopup);
		browser.click(confirmOk);
	}
	
	public void verifyCreditLimitIfEdited(String creditLimit)
	{
		logger.info("Verfying edited credit limit value");
		//browser.assertText(mcCreditLimitText, creditLimit);
		browser.assertValue(mcCreditLimitText, creditLimit);
	}
	
	public void rejectMCButton() throws Exception
	{
		browser.waitForVisible(rejectMCButton);
		logger.info("Click on reject MC button");
		browser.click(rejectMCButton);
	}
	
	public void VerifyFreeNavigationOfMCTabs() throws Exception
	{
		logger.info("Verify free navigation with in tabs");
		browser.waitForVisible(MCTabs);
		browser.click(referToAdminTab);
		browser.verifyAttribute(referToAdminTab, "class", "mc_tab mc_tab-mleft selected");
		browser.click(OwnerDetailsTab);
		browser.verifyAttribute(OwnerDetailsTab, "class", "mc_tab mc_tab-mleft selected");
		browser.click(DocumentsAttachedTab);
		browser.verifyAttribute(DocumentsAttachedTab, "class", "mc_tab mc_tab-mleft selected");
		browser.click(RepresentativeDetailsTab);
		browser.verifyAttribute(RepresentativeDetailsTab, "class", "mc_tab mc_tab-mleft selected");
		browser.click(doctorDetailsTab);
		browser.verifyAttribute(doctorDetailsTab, "class", "mc_tab mc_tab-mleft selected");
		browser.click(MCdetailsTab);
		browser.verifyAttribute(MCdetailsTab, "class", "mc_tab selected");
	}
	
	public void verifyMedicalCenterUpdatedDetails(String MCName,String MCRegNo,String MCaddress) throws Exception
	{
		logger.info("Verify MC details");
		browser.waitForVisible(verifyMCname);
		browser.assertText(verifyMCname, MCName);
		browser.assertText(verifyMCRegNo, MCRegNo);
		browser.assertText(verifyMCAddress, MCaddress);
		browser.waitForVisible(MCVerificationCheck);
		browser.check(MCVerificationCheck);
		browser.check(MCInformationCheck);
	}
	
	public void verifyOwner1UpdatedDetails(String Owner1Name,String designation,String email,String contact) throws Exception
	{
		logger.info("Verify Owner1/Director1 details");
		browser.waitForVisible(owner1VerificationCheck);
		
		browser.assertText(verifyOwner1Name,Owner1Name);
		browser.assertText(verifyOwner1Designation, designation);
		browser.assertText(verifyOwner1Email, email);
		browser.assertText(verifyOwner1Contact, contact);
		browser.check(owner1VerificationCheck);
		browser.check(owner1InformationCheck);
		
	}
	
	public void verifyOwner2UpdatedDetails(String Owner2Name,String designation,String email,String contact) throws Exception
	{
		logger.info("Verify Owner1/Director1 details");
		browser.waitForVisible(owner1VerificationCheck);
		
		browser.assertText(verifyOwner2Name,Owner2Name);
		browser.assertText(verifyOwner2Designation, designation);
		browser.assertText(verifyOwner2Email, email);
		browser.assertText(verifyOwner2Contact, contact);
		browser.check(owner2VerificationCheck);
		browser.check(owner2InformationCheck);
		browser.Wait(3);
	}
	
	public void verifyRepresentative1UpdatedDetails(String rep1Name,String rep1Email,String rep1Contact) throws Exception
	{
		logger.info("Verify representative1 updated details");
		browser.waitForVisible(representative1VerificationCheck);
		//browser.assertText(verifyrep1Name, rep1Name);
		browser.assertText(verifyrep1Email, rep1Email);
		browser.assertText(verifyrep1Contact, rep1Contact);
		browser.check(representative1VerificationCheck);
		browser.check(representative1InformtionCheck);
	}
	
	public void verifyRepresentative2UpdatedDetails(String rep2Name,String rep2Email,String rep2Contact) throws Exception
	{
		logger.info("Verify representative2 updated details");
		browser.waitForVisible(representative1VerificationCheck);
	//	browser.assertText(verifyrep2Name, rep2Name);
		browser.assertText(verifyrep2Email, rep2Email);
		browser.assertText(verifyrep2Contact, rep2Contact);
		browser.check(representative2VerificationCheck);
		browser.check(representative2InformtionCheck);
	}
	
	public void verifyUpdatedDoctor(String doctorName) throws Exception
	{
		WebElement LastElementCheck=browser.findElement(By.xpath("//*[@id='vf_doctor_ckbxid1']"));
		logger.info("Verify updated doctor name");
		WebElement DoctorName=browser.findElement(By.xpath("//div[@id='list_doctor']//div/span[text()='"+doctorName+"']"));
		browser.assertElementPresent(DoctorName);
		browser.Wait(2);
		if(!LastElementCheck.isSelected()){
			browser.click(LastElementCheck);
		}
		
	}
	
	public void verifyMedicalCenterLogo() throws Exception
	{
		browser.Wait(1);
		logger.info("Verify if medical center logo is present");
		browser.assertElementPresent(imageMedicalCenterLogo);
	}
	
	public void verifySupportingDocumentsAttached(String documentName)
	{
		logger.info("Verify if "+documentName+" is attached");
		WebElement AttachedDocument=browser.findElement(By.xpath("//tbody[@id='vf_mcDocs_tbody']//tr/td[text()='"+documentName+"']"));
		browser.assertElementPresent(AttachedDocument);
	}
	
	public void closeStatusMessageBar() throws Exception{
		browser.click(statusBar);
		browser.Wait(1);
	}
	
}
