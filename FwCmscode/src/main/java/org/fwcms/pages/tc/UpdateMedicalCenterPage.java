package org.fwcms.pages.tc;

import java.util.List;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.fwcms.pages.CommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateMedicalCenterPage {

private static final Logger logger = LogManager.getLogger(UpdateMedicalCenterPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public UpdateMedicalCenterPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public UpdateMedicalCenterPage initElements()
	{
		return PageFactory.initElements(driver, UpdateMedicalCenterPage.class);
	}
	
	@FindBy(id="mc_update_name")
	private WebElement mcUpdateDetailsLink;
	
	@FindBy(id="change_doctor_btn")
	private WebElement changeDoctorDetailsButton;
	
	@FindBy(id="subdislayFirstOwnerdetails")
	private WebElement ownerOneEditButton;
	
	@FindBy(id="subdislaySecondOwnerdetails")
	private WebElement ownerTwoEditDetails;
	
	@FindBy(id="subdislayFirstrepDetails")
	private WebElement repOneEditButton;
	
	@FindBy(id="subdislaySecondrepDetails")
	private WebElement repTwoEditButton;
	
	@FindBy(id="update_mc_doc_form")
	private WebElement updateMCForm;
	
	@FindBy(id="txtMedicalCenterName")
	private WebElement EditMCNameText;
	
	@FindBy(id="txtMedicalCenterReg")
	private WebElement EditMCRegistrationNo;
	
	@FindBy(id="txtMedicalCenterAddressline1")
	private WebElement editMCAddressLine1;
	
	@FindBy(id="confirm_mcreg_update")
	private WebElement EditMCsaveButton;
	
	@FindBy(id="cancel_mcreg_update")
	private WebElement EditMCCancelButton;
	
	@FindBy(id="flRegistrationCertificate")
	private WebElement flRegistrationCertificate;
	
	@FindBy(className="formErrorContent")
	private WebElement errorMsg;
	
	@FindBy(id="doc_tab_fullname")
	private WebElement docterFullNameText;
	
	@FindBy(id="doctor_professional_id")
	private WebElement doctorProfessionalIDText;
	
	@FindBy(id="doctor_qualification")
	private WebElement doctorQualificationText;
	 
	@FindBy(id="doctor_address_line1")
	private WebElement doctorAddressText;
	
	@FindBy(xpath="//*[@id='doctor-details-tab']/div/div[1]/div[2]/div[1]/a")
	private WebElement doctorSaveButton;
	
	@FindBy(id="change_doctor_btn")
	private WebElement changeDoctorButton;
	
	@FindBy(id="update_mc_doctor_form")
	private WebElement updateDoctorDetails;
	
	@FindBy(css="div[class$='first_owner_popup']")
	private WebElement updateFirstOwnerPopup;
	
	@FindBy(id="txtFirstOwnerFullName")
	private WebElement firstOwnerFullNameText;
	
	@FindBy(id="txtFirstOwnerDesignation")
	private WebElement firstOwnerDesignationText;
	
	@FindBy(id="txtFirstOwnerEmail")
	private WebElement txtFirstOwnerEmailText;
	
	@FindBy(id="txtFirstOwnerContact")
	private WebElement txtFirstOwnerContactText;
	
	@FindBy(id="confirm_mcreg_firstowner")
	private WebElement firstOwnerSaveButton;
	
	@FindBy(id="cancel_mcreg_doctor")
	private WebElement EditDoctorCancelButton;
	
	@FindBy(id="cancel_mcreg_firstowner")
	private WebElement editFirstOwnerCancelButton;
	
	@FindBy(id="subdislaySecondOwnerdetails")
	private WebElement secondOwnerEditButton;
	
	@FindBy(id="txtSecondOwnerFullName")
	private WebElement secondOwnerFullNameText;
	
	@FindBy(id="txtSecondOwnerDesignation")
	private WebElement secondOwnerDesignationText;
	
	@FindBy(id="txtSecondOwnerEmail")
	private WebElement secondOwnerEmailText;
	
	@FindBy(id="txtSecondOwnerContact")
	private WebElement secondOwnerContactText;
	
	@FindBy(id="confirm_mcreg_secondowner")
	private WebElement editSecondOwnerSaveButton;
	
	@FindBy(id="cancel_mcreg_secondowner")
	private WebElement editSecondOwnerCancelButton;
	
	@FindBy(css="div[class$='second_owner_popup']")
	private WebElement secondOwnerPopup;			
	
	@FindBy(css="div[class$='first_rep_popup']")
	private WebElement firstRepPopup;
	
	@FindBy(css="div[class$='second_rep_popup']")
	private WebElement secRepPopup;
	
	@FindBy(id="txtFirstRepFullName")
	private WebElement firstRepFullNameText;
		
	@FindBy(id="txtFirstRepEmail")
	private WebElement firstRepFullEmailText;
	
	@FindBy(id="txtFirstRepContact")
	private WebElement firstRepMobileText;
		
	@FindBy(id="confirm_mcreg_firstrep")
	private WebElement firstRepSaveButton;
	
	@FindBy(id="txtSecRepFullName")
	private WebElement secRepFullNameText;
	
	@FindBy(id="txtSecRepEmail")
	private WebElement secRepFullEmailText;
	

	@FindBy(id="txtSecRepContact")
	private WebElement secRepMobileText;
	
	@FindBy(id="confirm_mcreg_secondrep")
	private WebElement secRepSaveButton;
	
	@FindBy(id="cancel_mcreg_firstrep")
	private WebElement reponeCancelButton;
	
	@FindBy(id="cancel_mcreg_secondrep")
	private WebElement reptwoCancelButton;
	
	@FindBy(id="flFirstOwnerIdProof")
	private WebElement firstOwnerIDProof;
	
	@FindBy(id="flSecondOwnerIdProof")
	private WebElement secondOwnerIDProof;

	@FindBy(id="flFirstRepAuthLetter")
	private WebElement firstRepBrowseButton;
	
	@FindBy(id="flSecondRepAuthLetter")
	private WebElement secondRepBrowseButton;
	
	@FindBy(id="applicationId")
	private WebElement applicationId;
	
	@FindBy(id="update_info_declatation")
	private WebElement declerationCheckBox;
	
	@FindBy(id="update_save_btn")
	private WebElement submitButton;
	
	@FindBy(id="attachsignature")
	private WebElement attachSignatureButton;
	
	@FindBy(id="attachstamp")
	private WebElement attachStampButton;
	
	@FindBy(css="div[id='list_doctor']>div>span[class='doc_name']")
	private List<WebElement> doctorList;
	
	@FindBy(css="a[class^=addmore]")
	private WebElement addMoreDoctors;
			
	@FindBy(className="delete")
	private WebElement doctorDeleteButton;
	
	@FindBy(id="cancel_mcreg_doctor")
	private WebElement mcRegCancelButton;
	
	@FindBy(id="firstOwnerName")
	private WebElement verifyFirstOwnerName;
	
	@FindBy(id="firstOwnerContactNo")
	private WebElement verifyFirstOwnerContactNo;
	
	@FindBy(id="secondOwnerName")
	private WebElement verifySecondOwnerName;
	
	@FindBy(id="secondOwnerContactNo")
	private WebElement verifySecondOwnerContactNo;
	
	@FindBy(css="div[id='subdislayFirstrepDetails_remove']>span")
	private WebElement rep1RemoveButton;
	
	@FindBy(css="div[id='subdislaySecondrepDetails_remove']>span")
	private WebElement rep2RemoveButton;
	
	@FindBy(css="div[id='subdislayFirstrepDetails_add']>span")
	private WebElement rep1AddButton;
	
	@FindBy(css="div[id='subdislaySecondrepDetails_add']>span")
	private WebElement rep2AddButton;
	
	@FindBy(id="confirm_remove_firstRep")
	private WebElement rep1ConfirmPopup;
	
	@FindBy(id="confirm_remove_secondRep")
	private WebElement rep2ConfirmPopup;
	
	@FindBy(id="firstRepName")
	private WebElement verifyFirstRepName;
	
	@FindBy(id="secondRepName")
	private WebElement verifySecondRepName;
	
	@FindBy(css="div[class^='statusBar']")
	private WebElement statusBar;
	
	//Perform actions
	public void deleteRep1AndVerify(String repAuthLetter) throws Exception
	{
		logger.info("Remove rep1 and verify");
		browser.waitForVisible(rep2RemoveButton);
		browser.click(rep2RemoveButton);
		browser.waitForVisible(rep2ConfirmPopup);
		browser.click(rep2ConfirmPopup);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.assertVisible(rep2AddButton);
		browser.assertNotVisible(verifySecondRepName);
		browser.assertNotVisible(rep1RemoveButton);
		browser.click(rep2AddButton);
		logger.info("Create deleted representative");
		browser.waitForVisible(secRepPopup);
		browser.verifyVisible(secRepPopup);
		browser.clearAndType(secRepFullNameText, "Rep Two");
		browser.clearAndType(secRepFullEmailText, "fwcmsautomation7@gmail.com");
		browser.clearAndType(secRepMobileText, "2323232323");
		browser.type(secondRepBrowseButton, repAuthLetter);
		browser.click(secRepSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
	}
	private String editedMcName = null;
	
	public String getEditedMcName(){
		return editedMcName;
	}
	
	public void clickMCUpdateDetailsLink() throws Exception
	{   
		browser.Wait(2);
		browser.waitForVisible(mcUpdateDetailsLink);
		logger.info("Click MC update link");
		browser.click(mcUpdateDetailsLink);
	}
	
	public String updateMCWithoutAndWithSupportingDocs(String MCName,String regNo,String MCAddress,String MCsupportDoc,String errorMessage) throws Exception
	{
		logger.info("Verify update MC form");
		int registrationNumber=Integer.parseInt(regNo);
		registrationNumber=registrationNumber+new Random().nextInt((100 - 1) + 1) + 1;
		regNo=Integer.toString(registrationNumber);
		browser.waitForVisible(updateMCForm);
		browser.verifyElementPresent(updateMCForm);
		logger.info("Edit MC name");
		browser.clear(EditMCNameText);
		browser.type(EditMCNameText, MCName);
		editedMcName=browser.getValue(EditMCNameText);
		logger.info("Edit registration no");
		browser.clearAndType(EditMCRegistrationNo, regNo);
		logger.info("Edit Medical center address");
		browser.clearAndType(editMCAddressLine1, MCAddress);
		browser.click(EditMCsaveButton);
		browser.waitForVisible(errorMsg);
		logger.info("Assert error message");
		browser.assertText(errorMsg, errorMessage);
		browser.type(flRegistrationCertificate, MCsupportDoc);
		browser.Wait(4);
		browser.click(EditMCsaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.Wait(1);
		return regNo;
	}
	
	public void updateDoctorDetailsWithoutAndWithSupportingDocs(String doctor,String professionalID,String qualification,String docAddress,String doctorSignatureandStamp,String errorMessage) throws Exception
	{
		logger.info("Updating doctor details without Stamp & Signature");
		browser.click(changeDoctorButton);
		browser.waitForVisible(updateDoctorDetails);
		browser.clearAndType(docterFullNameText, doctor);
		browser.clearAndType(doctorProfessionalIDText, professionalID);
		browser.clearAndType(doctorQualificationText, qualification);
		browser.clearAndType(doctorAddressText, docAddress);
		browser.click(doctorSaveButton);
		browser.assertText(errorMsg, errorMessage);
		browser.type(attachSignatureButton, doctorSignatureandStamp);
		browser.type(attachStampButton, doctorSignatureandStamp);
		browser.Wait(2);
		browser.click(doctorSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Doctor details have been successfully added.");
		browser.click(EditDoctorCancelButton);
		browser.Wait(1);
	}
	
	public void updateMoreThanTenDoctorAndVerifyErrorMessage(String doctorSignatureandStamp,String errorMessage) throws Exception
	{
	
		logger.info("Trying to update more than 10 doctors");
		browser.click(changeDoctorButton);
		browser.waitForVisible(updateDoctorDetails);
		
		int NumberOfDoctors=doctorList.size();
		
		logger.info("Updating with 10 doctors");
		while(NumberOfDoctors<10)
		{
		browser.click(addMoreDoctors);
		browser.typeRandomAlphabets(docterFullNameText, "Doc");
		browser.typeRandomNumbers(doctorProfessionalIDText);
		browser.clearAndType(doctorQualificationText, "MD");
		browser.clearAndType(doctorAddressText, "doc address");
		browser.type(attachSignatureButton, doctorSignatureandStamp);
		browser.type(attachStampButton, doctorSignatureandStamp);
		browser.click(doctorSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Doctor details have been successfully added.");
		if(doctorList.size()==10){
			break;
		}
		}
		browser.click(addMoreDoctors);
		browser.typeRandomAlphabets(docterFullNameText, "Doc");
		browser.typeRandomNumbers(doctorProfessionalIDText);
		browser.clearAndType(doctorQualificationText, "MD");
		browser.clearAndType(doctorAddressText, "doc address");
		browser.type(attachSignatureButton, doctorSignatureandStamp);
		browser.type(attachStampButton, doctorSignatureandStamp);
		browser.click(doctorSaveButton);
		browser.assertText(errorMsg, errorMessage);
		browser.click(mcRegCancelButton);
	}
	
	public void updateOwner1DetailsWithOutAndWithSupportingDocs(String name,String designation,String email,String mobile,String owner1Proof,String errorMessage) throws Exception{
		logger.info("Update first owner details without supporting docs");
		browser.click(ownerOneEditButton);
		browser.waitForVisible(updateFirstOwnerPopup);
		browser.verifyVisible(updateFirstOwnerPopup);
		browser.clearAndType(firstOwnerFullNameText, name);
		browser.clearAndType(firstOwnerDesignationText, designation);
		browser.clearAndType(txtFirstOwnerEmailText, email);
		browser.clearAndType(txtFirstOwnerContactText, mobile);
		browser.click(firstOwnerSaveButton);
		browser.assertText(errorMsg, errorMessage);
		browser.type(firstOwnerIDProof, owner1Proof);
		browser.Wait(2);
		browser.click(firstOwnerSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.Wait(1);
		
	}
	
	public void replaceOwnerOneDetailsAndVerify(String owner1name,String email,String mobile,String owner1Proof) throws Exception{
		logger.info("Editing owner1 details");
		browser.Wait(1);
		browser.click(ownerOneEditButton);
		browser.verifyElementPresent(secondOwnerPopup);
		browser.clearAndType(firstOwnerFullNameText, owner1name);
		browser.clearAndType(txtFirstOwnerEmailText, email);
		browser.clearAndType(txtFirstOwnerContactText, mobile);
		browser.type(firstOwnerIDProof, owner1Proof);
		browser.click(firstOwnerSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.assertText(verifyFirstOwnerName, owner1name);
		browser.assertText(verifyFirstOwnerContactNo, mobile);
	}
	
	public void replaceOwnerTwoDetailsAndVerify(String owner2name,String email,String mobile2,String owner1Proof) throws Exception{
		logger.info("Editing owner2 details");
		browser.Wait(1);
		browser.click(ownerTwoEditDetails);
		browser.verifyElementPresent(secondOwnerPopup);
		browser.clearAndType(secondOwnerFullNameText, owner2name);
		browser.clearAndType(secondOwnerEmailText, email);
		browser.clearAndType(secondOwnerContactText, mobile2);
		browser.type(secondOwnerIDProof, owner1Proof);
		browser.click(editSecondOwnerSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.assertText(verifySecondOwnerName, owner2name);
		browser.assertText(verifySecondOwnerContactNo, mobile2);
	}
	
	public void updateOwner2DetailsWithOutAndWithSupportingDocs(String name,String designation,String email,String mobile,String owner2Proof,String errorMessage) throws Exception
	{
		logger.info("Update second owner details without supporting docs");
		browser.click(secondOwnerEditButton);
		browser.waitForVisible(secondOwnerPopup);
		browser.verifyVisible(secondOwnerDesignationText);
		browser.clearAndType(secondOwnerFullNameText, name);
		browser.clearAndType(secondOwnerDesignationText, designation);
		browser.clearAndType(secondOwnerEmailText, email);
		browser.clearAndType(secondOwnerContactText, mobile);
		browser.click(editSecondOwnerSaveButton);
		browser.Wait(1);
		browser.assertText(errorMsg, errorMessage);
		browser.type(secondOwnerIDProof, owner2Proof);
		browser.Wait(4);
		browser.click(editSecondOwnerSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.Wait(1);
	}
	
	public void updateRep1DetailsWithOutAndWithSupportingDocs(String name,String email,String mobile,String rep1AuthLetter,String errorMessage) throws Exception
	{
		logger.info("Update representative one details without supporting docs");
		browser.click(repOneEditButton);
		browser.waitForVisible(firstRepPopup);
		browser.verifyVisible(firstRepPopup);
		//browser.clearAndType(firstRepFullNameText, name);
		browser.clearAndType(firstRepFullEmailText, email);
		browser.clearAndType(firstRepMobileText, mobile);
		browser.click(firstRepSaveButton);
		browser.assertText(errorMsg, errorMessage);
		browser.type(firstRepBrowseButton, rep1AuthLetter);
		browser.Wait(2);
		browser.click(firstRepSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.Wait(1);
	}
	
	
	public void updateRep2DetailsWithOutAndWithSupportingDocs(String name,String email,String mobile,String rep2AuthLetter,String errorMessage) throws Exception
	{
		logger.info("Update representative two details without supporting docs");
		browser.click(repTwoEditButton);
		browser.waitForVisible(secRepPopup);
		browser.verifyVisible(secRepPopup);
		//browser.clearAndType(secRepFullNameText, name);
		browser.clearAndType(secRepFullEmailText, email);
		browser.clearAndType(secRepMobileText, mobile);
		browser.click(secRepSaveButton);
		browser.assertText(errorMsg, errorMessage);
		browser.type(secondRepBrowseButton, rep2AuthLetter);
		browser.Wait(4);
		browser.click(secRepSaveButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Medical Center updated successfully");
		browser.Wait(1);
	}
	
	public void verifyAttachedDocsUnderDocumentSubmitted(String documentName)
	{
		logger.info("verify if attached "+documentName+" is displayed in document submitted");
		WebElement SupportingDocument=browser.findElement(By.xpath("//tbody[@id='mc_submitted_documents_tbody']//td[text()='"+documentName+"']"));
		browser.assertElementPresent(SupportingDocument);
	}
	
	public void selectDeclarationCheckBoxAndVerifySubmitButton() throws Exception
	{
		logger.info("Verify Submit button displayed on declaration");
		browser.click(declerationCheckBox);
		browser.assertVisible(submitButton);
	}
	
	public void ClickOnSubmitButtonAndVerifySuccessMessage(String successMessage) throws Exception
	{
		logger.info("Click on submit button");
		browser.click(submitButton);
		new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde(successMessage);
	}
	
	public void VerifyIfEditButtonsAreNotPresent() throws Exception
	{
		logger.info("Verify if edit buttons are not present and cannot be edited");
		browser.verifyNotVisible(repOneEditButton);
		browser.verifyNotVisible(repTwoEditButton);
		browser.verifyNotVisible(ownerOneEditButton);
		browser.verifyNotVisible(secondOwnerEditButton);
	}
	
	public void VerifyErrorMessageByDeletingAllRecords(String errormessage) throws Exception
	{
		logger.info("Verify error message on deleting all the record");
		browser.click(changeDoctorButton);
		browser.waitForVisible(updateDoctorDetails);
		int NumberOfDoctors=doctorList.size();
		logger.info("Trying to delet all the records");
		while(NumberOfDoctors>1)
		{
			doctorList.get(0).click();
			new CommonElements(driver).initElements().waitForOverlayToHide();
			browser.click(doctorDeleteButton);
			new CommonElements(driver).initElements().waitForStatusBarToBeVisibleAndVerifyTextAndCloseStatusBarAndWaitForOverlayToHIde("Doctor details deleted successfully!");
			if(doctorList.size()==1){
				break;
			}
		}
		doctorList.get(0).click();
		new CommonElements(driver).initElements().waitForOverlayToHide();
		browser.click(doctorDeleteButton);
		browser.assertText(errorMsg,errormessage);
		
	}
	
	public void verifyIfMCInActiveStateCanBeUpdated() throws Exception {
		logger.info("Verify if MC in active state can be updated");
		browser.assertNotVisible(statusBar);
		browser.assertEditable(declerationCheckBox);
	}
}

