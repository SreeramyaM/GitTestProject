package org.fwcms.pages.tc;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fwcms.bot.BrowserBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakePaymentPage {

private static final Logger logger = LogManager.getLogger(MakePaymentPage.class.getName());
	
	private BrowserBot browser;
	private WebDriver driver;
	
	public MakePaymentPage(WebDriver driver){
		this.driver = driver;
		browser = new BrowserBot(driver);
	}
	
	public MakePaymentPage initElements()
	{
		return PageFactory.initElements(driver, MakePaymentPage.class);
	}
	
	@FindBy(id="registrationPendingAmount")
	private WebElement regPendingAmount;
	
	@FindBy(className="pay_details_block_popup")
	private WebElement transactionDetailsPopup;
	
	@FindBy(className="pay_details_block_popup")
	private WebElement MCTransactionDetailsPopUp;
	
	@FindBy(id="make_payment")
	private WebElement makePaymentButton;
	
	@FindBy(id="bank_draft")
	private WebElement bankDraft;
	
	@FindBy(id="online_transfer")
	private WebElement onlineTranfer;
	
	@FindBy(id="transactionAmount")
	private WebElement amountPaidText;
	
	@FindBy(id="bd_transactionId")
	private WebElement instrumentNoText;
	
	@FindBy(className="ui-datepicker-trigger")
	private List<WebElement> datePickerList;
	
	@FindBy(id="bd_sourceBankName")
	private WebElement draweeBankText;
	
	@FindBy(id="bd_bankBranchName")
	private WebElement bankBranchNameText;
	
	@FindBy(id="bd_transactionComment")
	private WebElement commenttext;
	
	@FindBy(css="td[class*='ui-datepicker-today']>a")
	private WebElement activeDate;
	
	@FindBy(id="submit_draft_payment")
	private WebElement draftPaymentSubmitButton;
	
	@FindBy(id="confirm_operation")
	private WebElement confirmOperation;
	
	@FindBy(className="confirm_popup")
	private WebElement confirmationPopup;
	
	@FindBy(id="payment_history")
	private WebElement paymentHistoryButton;
	
	@FindBy(id="ot_transactionId")
	private WebElement onlineTransactionIDText;
	
	@FindBy(id="ot_sourceBankName")
	private WebElement otDraweeBankText;
	
	@FindBy(id="ot_bankBranchName")
	private WebElement otbranchText;
	
	@FindBy(id="ot_transactionComment")
	private WebElement otComments;
	
	@FindBy(id="submit_online_payment")
	private WebElement submitOnlinePaymentButton;
	
	@FindBy(id="gbox_mc_paymenthistory")
	private WebElement paymentHistoryPopup;
	
	//@FindBy(css="div[class^='pay_trans_details']")
	@FindBy(id="gbox_mc_paymenthistory")
	private WebElement paymentRealizedPopup;
	
	@FindBy(css="input[value='paymentRealized']")
	private WebElement paymentRealisedRadio;
	
	@FindBy(css="input[value='paymentCancelled']")
	private WebElement paymentCancelledRadio;
	
	@FindBy(id="trans_save_payment")
	private WebElement savePaymentButton;
	
	@FindBy(id="confirmation_message")
	private WebElement savePaymentConfirmationPopup;
	
	@FindBy(css="div[class$='transDetails']>span:nth-child(2)>span")
	private WebElement transactionDetailsButton;
	
	@FindBy(css="span[class='pay_close']>img")
	private WebElement closePay;
	
	public void clickTransactionDetailsButton() throws Exception
	{
		browser.waitForVisible(transactionDetailsButton);
		browser.click(transactionDetailsButton);
	}
	
	public void clickClosePay() throws Exception{
		browser.click(closePay);
	}
	
	public void verifyingTransactionIDInPaymentHistoryTable(String transactionID) throws Exception
	{
		browser.click(paymentHistoryButton);
		browser.waitForVisible(paymentHistoryPopup);
		WebElement tID=browser.findElement(By.xpath("//table[@id='mc_paymenthistory']//tr//td[text()='"+transactionID+"']"));
		browser.assertText(tID, transactionID);
	}
	
	public void payAmountThorughOnlineTransfer(String amount,String transactionID,String draweeBank,String branch,String comments) throws Exception
	{
		browser.Wait(1);
		logger.info("Make Payment By Online transfer");
		browser.waitForVisible(onlineTranfer);
		browser.click(onlineTranfer);
		browser.type(amountPaidText, amount);
		browser.type(onlineTransactionIDText, transactionID);
		browser.click(datePickerList.get(1));
		browser.click(activeDate);
		browser.type(otDraweeBankText, draweeBank);
		browser.type(otbranchText, branch);
		browser.type(otComments,comments);
		browser.click(submitOnlinePaymentButton);
		logger.info("Verify confirmation popup");
		browser.verifyVisible(confirmationPopup);
		browser.click(confirmOperation);
	}
	public void payAmountThroughBankDraft(String amount,String instrumentNo,String draweeBank,String branch,String comments) throws Exception
	{
		logger.info("Make Payment using Bank Draft");
		browser.type(amountPaidText, amount);
		browser.type(instrumentNoText, instrumentNo);
		browser.click(datePickerList.get(0));
		browser.click(activeDate);
		browser.type(draweeBankText, draweeBank);
		browser.type(bankBranchNameText, branch);
		browser.type(commenttext,comments);
		browser.click(draftPaymentSubmitButton);
		logger.info("Verify confirmation popup");
		browser.verifyVisible(confirmationPopup);
		browser.click(confirmOperation);
	}
	
	public void clickMakePaymentButton() throws Exception{
		browser.click(makePaymentButton);
	}
	
	public String getPendingAmount()
	{
		logger.info("get Pending amount");
		browser.waitForVisible(transactionDetailsPopup);
		return regPendingAmount.getText();
	}

	//Performing actions
	
	public void verifyBankDraftAndOnlineTransferTab() throws Exception
	{
		browser.verifyElementPresent(bankDraft);
		browser.verifyElementPresent(onlineTranfer);
	}
	public void verifyTransactionDetailsPopUp() throws Exception
	{
		browser.verifyElementPresent(MCTransactionDetailsPopUp);
	}
	
	public void verifyPendingAmountPostPaymentIsZero()
	{
		browser.assertText(regPendingAmount, "0");
	}
	
	public void verifyMakePaymentAndPaymentHistoryuButton() throws Exception
	{
		logger.info("Verifying  Make payment button & Payment history button");
		browser.verifyElementPresent(makePaymentButton);
		browser.verifyElementPresent(paymentHistoryButton);
	}
	
	public void changingPendingRealisedtoReaslised(String transactionID) throws Exception
	{
		logger.info("Converting online transaction from pending realised to realised");
		WebElement tID=browser.findElement(By.xpath("//table[@id='mc_paymenthistory']//tr//td[text()='"+transactionID+"']"));
		browser.waitForEditable(tID);
		tID.click();
		browser.verifyElementPresent(paymentRealizedPopup);
		logger.info("Verify Payment Realized & Payment cancelled Radio buttons");
		browser.verifyElementPresent(paymentRealisedRadio);
		browser.verifyElementPresent(paymentCancelledRadio);
		logger.info("Checking Payment realized");
		browser.verifyChecked(paymentRealisedRadio);
		browser.Wait(1);
		browser.waitForEditable(savePaymentButton);
		browser.click(savePaymentButton);
	}
	
	public void verifyConfirmationPopupMessageAnClickOK(String confirmationMessage) throws Exception
	{
		logger.info("Verifying Confirmation Message");
		browser.waitForVisible(confirmationPopup);
		browser.assertText(savePaymentConfirmationPopup, confirmationMessage);
		browser.click(confirmOperation);
	}
}
