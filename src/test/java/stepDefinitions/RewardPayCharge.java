package stepDefinitions;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.util.ExcelReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ChargePageObjects;
import pageObjects.Customer_Page;
import pageObjects.DepositsPageObjects;
import pageObjects.Estimate_Page;

public class RewardPayCharge extends BaseTest {

	static ChargePageObjects ChargePage;
	static String scenarioName;
	static Customer_Page customerPage;
	static String payMethod;
	static Estimate_Page estimatePage;
	static String dateTime;
	static float totatCartAmount;
	float AmountPaid;

	@Before
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
		
	}

	
	@And("Continue the Payment via Manual card ,add {string},Enter the card details {string} {string} {string} {string} {string} in Reward Pay")
	public void manualCardpartailPaymentDetails(String tip, String cardNumber, String expMonth, String expYear,
			String cardCVV, String cardHolderName) throws FileNotFoundException, IOException, InterruptedException {
		String addTip = excelReader(scenarioName, tip);
		String manualcardNumber = excelReader(scenarioName, cardNumber);
		String expiryMonth = excelReader(scenarioName, expMonth);
		String expiryYear = excelReader(scenarioName, expYear);
		String manualcardCVV = excelReader(scenarioName, cardCVV);
		String HolderName = excelReader(scenarioName, cardHolderName);
		ChargePage = new ChargePageObjects(driver);
		ChargePage.manualCardTenderPaymentdetail_RewardPay(manualcardNumber, expiryMonth, expiryYear, manualcardCVV, HolderName);
	}
	
	@And("verify the receipt details when partial payment of {string} is done via ACH in Reward Pay")
	public void ACHTenderPaymentReceiptverification(String depositAmount) throws FileNotFoundException, IOException {
		String depositAmt = excelReader(scenarioName, depositAmount);
		ChargePage = new ChargePageObjects(driver);
		ChargePage.verifyTenderACHReceiptDetailsRewardPay(depositAmt);
	}
	
	@And("verify the receipt details when partial payment of {string} is done via manual card in Reward Pay")
	public void manualCardTenderPaymentReceiptverification(String depositAmount)
			throws FileNotFoundException, IOException {
		String depositAmt = excelReader(scenarioName, depositAmount);
		ChargePage = new ChargePageObjects(driver);
		ChargePage.verifyTenderPaymentManualCardReceiptDetails_RewardPay(depositAmt);
	}
	
	@And("verify the receipt details of rest amount payment process via Cheque {string} and {string} in Reward Pay")
	public void chequePaymentprocess(String paymentMethod, String checqueNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String payMethod = excelReader(scenarioName, paymentMethod);
		String chequeNum = excelReader(scenarioName, checqueNumber);
		System.out.println(chequeNum);
		// ChargePage.click_ChargeButton();
		Thread.sleep(2000);
		ChargePage = new ChargePageObjects(driver);
		if (driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).click();
			ChargePage.enter_chequeDetail(chequeNum);
			Thread.sleep(4000);
			ChargePage.verifyTenderChequeReceiptDetails_RewardPay();
		} else {
			System.out.println(payMethod + " option Not found.");
		}

	}
	@And("verify the receipt details when payment of complete balance amount is done via Manual card in Reward Pay")
	public void manualCardTenderPaymentReceiptverification() throws FileNotFoundException, IOException {

		ChargePage.verifyTenderPaymentManualCardReceiptDetails_RewardPay();
	}

	@And("verify the receipt details of partial amount {string} process via Cheque {string} and {string} in Reward Pay")
	public void chequePayment(String tenderAmt, String paymentMethod, String checqueNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String tenderAmount = excelReader(scenarioName, tenderAmt);
		String payMethod = excelReader(scenarioName, paymentMethod);
		String chequeNum = excelReader(scenarioName, checqueNumber);
		System.out.println(chequeNum);
		// ChargePage.click_ChargeButton();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).click();
			Thread.sleep(2000);
			ChargePage.enter_chequeDetail(chequeNum);
			Thread.sleep(4000);
			ChargePage.verifyTenderChequeReceiptDetails_RewardPay(tenderAmount);
		} else {
			System.out.println(payMethod + " option Not found.");
		}

	}

	@And("Continue the Payment via Manual card ,add {string} and Enter the card details {string} {string} {string} {string} {string} in Reward Pay")
	public void manualCardDetails(String tip, String cardNumber, String expMonth, String expYear, String cardCVV,
			String cardHolderName) throws FileNotFoundException, IOException, InterruptedException {
		String addTip = excelReader(scenarioName, tip);
		String manualcardNumber = excelReader(scenarioName, cardNumber);
		String expiryMonth = excelReader(scenarioName, expMonth);
		String expiryYear = excelReader(scenarioName, expYear);
		String manualcardCVV = excelReader(scenarioName, cardCVV);
		String HolderName = excelReader(scenarioName, cardHolderName);

		ChargePage.manualCardPaymentdetail_RewardPay(addTip, manualcardNumber, expiryMonth, expiryYear, manualcardCVV,
				HolderName);
	}
	
	//Invoices
	
	@And("verify the amount in invoice is matched with the cart amount in Reward Pay")
	public void verifyInvoiceAmountforCashorACH() {
//		ChargePage.verifyInvoiceReceiptforCashorACH();
		ChargePage = new ChargePageObjects(driver);
		ChargePage.verifyInvoiceReceiptforCard_RewardPay();
	}
	
	@And("verify the receipt details of payment via {string} in Reward Pay")
	public void paymentMethod(String paymentMethod) throws FileNotFoundException, IOException, InterruptedException {
		payMethod = excelReader(scenarioName, paymentMethod);

		if (payMethod.equalsIgnoreCase("Cash")) {

			ChargePage.verifyCashReceiptDetails();
		} else if (payMethod.equalsIgnoreCase("Manual card")) {
			ChargePage.verifyManualCardReceiptDetails_RewardPay();
		} else if (payMethod.equalsIgnoreCase("ACH")) {
			ChargePage.verifyManualCardReceiptDetails_RewardPay();
		} else {
			System.out.println(paymentMethod + " Not found :");
		}
	}
	
	@And("verify the receipt details when payment of complete balance amount is done via ACH in Reward Pay")
	public void achTenderPaymentReceiptverification() throws FileNotFoundException, IOException {

		ChargePage.verifyTenderPaymentACHReceiptDetails_RewardPay();
	}
	@And("Enter the deposit Amount {string} in Quick charge in Reward Pay")
	public void enterDepositAMT(String deposit_AMT) throws InterruptedException, FileNotFoundException, IOException {
		estimatePage = new Estimate_Page(driver);
		String deposit_Amt = excelReader(scenarioName, deposit_AMT);
		estimatePage.enterDepositAmount(deposit_Amt);
		Thread.sleep(3000);
		
	}
}