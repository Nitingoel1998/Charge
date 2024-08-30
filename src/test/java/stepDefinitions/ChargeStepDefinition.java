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

public class ChargeStepDefinition extends BaseTest {

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

	@Given("open the browser1")
	public void browser_is_open() throws FileNotFoundException, IOException, InterruptedException {
		openBrowser();
		estimatePage = new Estimate_Page(driver);
		ChargePage = new ChargePageObjects(driver);
		customerPage = new Customer_Page(driver);

	}

	@And("verify the receipt details when partial payment of {string} is done via manual card")
	public void manualCardTenderPaymentReceiptverification(String depositAmount)
			throws FileNotFoundException, IOException {
		String depositAmt = excelReader(scenarioName, depositAmount);
		ChargePage.verifyTenderPaymentManualCardReceiptDetails(depositAmt);
	}

	@And("verify the receipt details when payment of complete balance amount is done via Manual card")
	public void manualCardTenderPaymentReceiptverification() throws FileNotFoundException, IOException {

		ChargePage.verifyTenderPaymentManualCardReceiptDetails();
	}

	@And("verify the receipt details when payment of complete balance amount is done via ACH")
	public void achTenderPaymentReceiptverification() throws FileNotFoundException, IOException {

		ChargePage.verifyTenderPaymentACHReceiptDetails();
	}

	@And("verify the receipt details when partial payment of {string} is done via Cash")
	public void CashTenderPaymentReceiptverification(String depositAmount) throws FileNotFoundException, IOException {
		String depositAmt = excelReader(scenarioName, depositAmount);
		ChargePage.verifyTenderCashReceiptDetails(depositAmt);
	}

	@And("verify the receipt details when partial payment of {string} is done via ACH")
	public void ACHTenderPaymentReceiptverification(String depositAmount) throws FileNotFoundException, IOException {
		String depositAmt = excelReader(scenarioName, depositAmount);
		ChargePage.verifyTenderACHReceiptDetails(depositAmt);
	}

	@And("Continue the Payment via Manual card ,add {string},Enter the card details {string} {string} {string} {string} {string}")
	public void manualCardpartailPaymentDetails(String tip, String cardNumber, String expMonth, String expYear,
			String cardCVV, String cardHolderName) throws FileNotFoundException, IOException, InterruptedException {
		String addTip = excelReader(scenarioName, tip);
		String manualcardNumber = excelReader(scenarioName, cardNumber);
		String expiryMonth = excelReader(scenarioName, expMonth);
		String expiryYear = excelReader(scenarioName, expYear);
		String manualcardCVV = excelReader(scenarioName, cardCVV);
		String HolderName = excelReader(scenarioName, cardHolderName);
		ChargePage.manualCardTenderPaymentdetail(manualcardNumber, expiryMonth, expiryYear, manualcardCVV, HolderName);
	}

	@And("Continue the partial Payment via ACH ,add {string} and Enter the account details {string} {string} {string} {string} {string}")
	public void achpartialPaymentDetails(String tip, String accountType, String accountNumber, String accountHolder,
			String accountDescription, String routingNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String addTip = excelReader(scenarioName, tip);
		String accType = excelReader(scenarioName, accountType);
		String accNum = excelReader(scenarioName, accountNumber);
		String accHolder = excelReader(scenarioName, accountHolder);
		String accDev = excelReader(scenarioName, accountDescription);
		String routingNum = excelReader(scenarioName, routingNumber);

		ChargePage.achTenderPaymentdetail(accType, accNum, accHolder, accDev, routingNum);
	}

	@When("Navigate to URL")
	public void open_the_Url() throws FileNotFoundException, IOException {
		ChargePage.openURL1("URL");
	}

	@When("Navigate to URL2")
	public void open_the_Url2() throws FileNotFoundException, IOException {
		ChargePage.openURL1("URL2");
	}

	@And("I wait for Sometime")
	public void external_wait() throws InterruptedException {
		Thread.sleep(10000);
	}

	@And("Enter the details {string} and {string} and Click on login button")
	public void enter_the_loginCre_partner_portal(String Header1, String Header2)
			throws FileNotFoundException, IOException, InterruptedException {
		String str = excelReader(scenarioName, Header1);
		System.out.println(str);
		String str2 = excelReader(scenarioName, Header2);
		System.out.println(str2);
		ChargePage.login(str, str2);
	}

	@And("Navigate to Catalog Section and add super category {string} click on Save button")
	public void clickAddSupCat(String SupCatName) throws FileNotFoundException, IOException, InterruptedException {
		String name = excelReader(scenarioName, SupCatName);
		System.out.println(name);
		ChargePage.createSupCat(name);
	}

	@And("Enter the {string},{string},{string} and {string} and click on Save and Verify")
	public void createcategory(String catName, String SupCatName, String Tax, String itemImagePath)
			throws FileNotFoundException, IOException, InterruptedException, AWTException {
		String imagePath = excelReader(scenarioName, itemImagePath);
		String cat_name = excelReader(scenarioName, catName);
		String supcat_name = excelReader(scenarioName, SupCatName);
		String tax = excelReader(scenarioName, Tax);
		ChargePage.createCategory(cat_name, supcat_name, tax, imagePath);
	}

	@And("Add the Item and enter the {string} {string} {string} then click on save and verify")
	public void add_itemwithoutImage(String itemName, String price, String tax)
			throws FileNotFoundException, IOException, InterruptedException, AWTException {

		String item_name = excelReader(scenarioName, itemName);
		String itemPrice = excelReader(scenarioName, price);
		String item_tax = excelReader(scenarioName, tax);
		ChargePage.createItemWithoutImage(item_name, itemPrice, item_tax);
	}

	@And("Add the Item and enter the {string} {string} {string} and {string} then click on save and verify")
	public void add_item(String itemName, String price, String tax, String itemImagePath)
			throws FileNotFoundException, IOException, InterruptedException, AWTException {
		String item_path = excelReader(scenarioName, itemImagePath);
		String item_name = excelReader(scenarioName, itemName);
		String itemPrice = excelReader(scenarioName, price);
		String item_tax = excelReader(scenarioName, tax);
		ChargePage.createItem(item_name, itemPrice, item_tax, item_path);
	}

	@And("Click on item edit button and enter the {string} {string} {string} then click on save and verify")
	public void edit_Item(String catName, String name, String price)
			throws FileNotFoundException, IOException, InterruptedException {
		String item_name2 = excelReader(scenarioName, name);
		String cat_name = excelReader(scenarioName, catName);
		String itemPrice2 = excelReader(scenarioName, price);
		ChargePage.verify_and_editItem(cat_name, item_name2, itemPrice2);
	}

	@And("Click on delete {string} {string} and verify the item is deleted")
	public void delete_Item(String item_Name, String category)
			throws FileNotFoundException, IOException, InterruptedException {
		String item_name = excelReader(scenarioName, item_Name);
		String cat_name = excelReader(scenarioName, category);
		ChargePage.deleteItem(item_name, cat_name);
	}

	@Then("Click on Logout")
	public void logout() throws InterruptedException {
		ChargePage.logout();
	}

	@And("Click on category edit button and enter the {string} {string} then click on save and verify")
	public void edit_Category(String catName, String catname2)
			throws FileNotFoundException, IOException, InterruptedException {
		String cat_name2 = excelReader(scenarioName, catname2);
		String cat_name = excelReader(scenarioName, catName);

		ChargePage.verify_and_editCategory(cat_name, cat_name2);
	}

	@And("Click on category edit button and click the {string} then click on delete and verify")
	public void delete_Category(String catName) throws FileNotFoundException, IOException, InterruptedException {

		String cat_name = excelReader(scenarioName, catName);

		ChargePage.deleteCategory_and_verify(cat_name);
	}

	@And("Add the item {string} with {string} to the cart and verify the item is added successfully")
	public void addItem(String itemName, String quantity)
			throws FileNotFoundException, IOException, InterruptedException {
		String item_name = excelReader(scenarioName, itemName);
		String quant = excelReader(scenarioName, quantity);
		ChargePage.addItemToCart_and_verify(item_name, quant);

	}

	@And("Verify the Sub Total Amount is correct as per the items value added in the cart")
	public void verifySubTotalAmount() {
		ChargePage.verify_Cart_SubtotalAmount();
	}

	@And("Enter the discount percentage {string} to the cart value and verify the discount amount")
	public void discount_Percent(String discountPercentage)
			throws FileNotFoundException, IOException, InterruptedException {
		String discountPer = excelReader(scenarioName, discountPercentage);
		
		ChargePage.discount_Percentage_verify(discountPer);

	}

	@And("Enter the discount amount {string} to the cart value and verify the discount amount")
	public void discount_Amount(String discountAmount) throws FileNotFoundException, IOException, InterruptedException {
		String discountAmt = excelReader(scenarioName, discountAmount);
		float discountAmoun = convertingStringToFloat(discountAmt);
		ChargePage.discount_Amount_verify(discountAmoun);

	}

	@And("verify cart details on cart Page")
	public void payment_Process() throws FileNotFoundException, IOException, InterruptedException {

		ChargePage.verifycartdetails();

	}

	@And("Click on the category {string}")
	public void category(String catName) throws FileNotFoundException, IOException {
		String categoryNam = excelReader(scenarioName, catName);
		ChargePage.categoryLink(categoryNam);
	}

	@And("Continue the Payment via Manual card ,add {string} and Enter the card details {string} {string} {string} {string} {string}")
	public void manualCardDetails(String tip, String cardNumber, String expMonth, String expYear, String cardCVV,
			String cardHolderName) throws FileNotFoundException, IOException, InterruptedException {
		String addTip = excelReader(scenarioName, tip);
		String manualcardNumber = excelReader(scenarioName, cardNumber);
		String expiryMonth = excelReader(scenarioName, expMonth);
		String expiryYear = excelReader(scenarioName, expYear);
		String manualcardCVV = excelReader(scenarioName, cardCVV);
		String HolderName = excelReader(scenarioName, cardHolderName);

		ChargePage.manualCardPaymentdetail(addTip, manualcardNumber, expiryMonth, expiryYear, manualcardCVV,
				HolderName);
	}
@And("Continue the payment via swipe")
public void swipe() {
	ChargePage.swipeMethod();
}
	
	@And("Continue the Payment via ACH ,add {string} and Enter the account details {string} {string} {string} {string} {string}")
	public void achDetails(String tip, String accountType, String accountNumber, String accountHolder,
			String accountDescription, String routingNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String addTip = excelReader(scenarioName, tip);
		String accType = excelReader(scenarioName, accountType);
		String accNum = excelReader(scenarioName, accountNumber);
		String accHolder = excelReader(scenarioName, accountHolder);
		String accDev = excelReader(scenarioName, accountDescription);
		String routingNum = excelReader(scenarioName, routingNumber);

		ChargePage.achPaymentdetail(addTip, accType, accNum, accHolder, accDev, routingNum);
	}

	@And("Continue the Payment via Cash")
	public void cashpayment() throws InterruptedException {
		ChargePage.cashpaymentProcess();
	}

	@And("Continue the Payment via SendInvoice")
	public void sendInvoice() throws InterruptedException {
		ChargePage.send_InvoicePayment();
	}

	@And("Click on the Charge button")
	public void click_ChargeButton() throws InterruptedException {
		ChargePage.click_ChargeButton();
	}

	@And("Click on the Charge button and Continue Partial payment")
	public void click_ChargeButtonContinuePartialpayment() throws InterruptedException {
		ChargePage.click_ChargeButtonandContinuePartialpayment();
	}

	@And("Capture the date and time of the Transaction")
	public void captureDateTime() {
		dateTime = estimatePage.dateformat();
		System.out.println(dateTime);
	}

	@And("verify the receipt details of payment via {string}")
	public void paymentMethod(String paymentMethod) throws FileNotFoundException, IOException, InterruptedException {
		payMethod = excelReader(scenarioName, paymentMethod);

		if (payMethod.equalsIgnoreCase("Cash")) {

			ChargePage.verifyCashReceiptDetails();
		} else if (payMethod.equalsIgnoreCase("Manual card")) {
			ChargePage.verifyManualCardReceiptDetails();
		} else if (payMethod.equalsIgnoreCase("ACH")) {
			ChargePage.verifyManualCardReceiptDetails();
		} else {
			System.out.println(paymentMethod + " Not found :");
		}
	}

	@And("verify the receipt details of payment via Cheque {string} and {string}")
	public void chequePayment(String paymentMethod, String checqueNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String payMethod = excelReader(scenarioName, paymentMethod);
		String chequeNum = excelReader(scenarioName, checqueNumber);
		System.out.println(chequeNum);
//		ChargePage.click_ChargeButton();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).click();
			ChargePage.enter_chequeDetail(chequeNum);
			Thread.sleep(5000);
			ChargePage.verifyCashReceiptDetails();
		} else {
			System.out.println(payMethod + " option Not found.");
		}

	}

	// Code to verify report/table
	@And("Select report {string} and Select the date range from {string} to {string} to generate report")
	public void select_date_range_in_report(String reportname, String dateFrom, String dateTo)
			throws FileNotFoundException, IOException, InterruptedException {
		String reportName = excelReader(scenarioName, reportname);
		String datefrom = excelReader(scenarioName, dateFrom);
		String dateto = excelReader(scenarioName, dateTo);
		ChargePage.select_Report(reportName);
		ChargePage.enterDateRange(datefrom, dateto);

	}

	@And("Click on the report section in menu bar")
	public void reportSection() {
		ChargePage.click_section();
	}

	@And("Export the report {string} in CSV file and Verify the downloaded report")
	public void verifyrepo(String reportName) throws IOException, InterruptedException {
		String reportType = excelReader(scenarioName, reportName);
		Thread.sleep(3000);
		ChargePage.verify_Report(reportType);
	}

	@And("Navigate to Transaction history Section")
	public void navigate_Transactionhistory() throws InterruptedException {
		Customer_Page transactionPage = new Customer_Page(driver);
		Thread.sleep(4000);
		transactionPage.navigate_TransactionHistorytab();
	}

	@And("Enter the date range {string} {string} to display the transaction")
	public void enterdaterange(String dateFrom, String dateTo)
			throws FileNotFoundException, IOException, InterruptedException {
		String datefrom = excelReader(scenarioName, dateFrom);
		String dateto = excelReader(scenarioName, dateTo);
		Thread.sleep(2000);
		ChargePage.enterDateRange(datefrom, dateto);

	}

	@And("Click on the transaction and verify the transaction details")
	public void verifyTransactionDetail() throws InterruptedException {
		Thread.sleep(2000);
		ChargePage.transactionhistory_receipt();
	}

	@And("Click on refund button, select the full refund type and verify the refund status is diplayed in transaction")
	public void verifyFullRefundProcess() throws FileNotFoundException, IOException, InterruptedException {

		ChargePage.verifyFullRefund();
	}

	@And("Click on refund button, select the Tip refund of {string} type and verify the refund status is diplayed in transaction")
	public void verifyTipRefundProcess(String payMethod ) throws FileNotFoundException, IOException, InterruptedException {
		String paymethod = excelReader(scenarioName, payMethod);
		ChargePage.verifyTipRefund(paymethod);
	}

	@And("Click on refund button, select the partial refund type and enter the {string} and verify the refund status is diplayed in transaction")
	public void verifyPartialRefundProcess(String partialRefundAmt)
			throws FileNotFoundException, IOException, InterruptedException {

		String partialAmt = excelReader(scenarioName, partialRefundAmt);

		ChargePage.verifyPartialRefund(partialAmt, payMethod);
	}

	@And("Capture the transaction report with payment via {string} and verify the {string} amount with the cart Amount")
	public void verify_HeaderDetails_in_TransactionReport(String paymentMethod, String header)
			throws FileNotFoundException, IOException, InterruptedException {
		String titleHeader = excelReader(scenarioName, header);
		String PaymentType = excelReader(scenarioName, paymentMethod);
		ChargePage.verifytransactionreport(PaymentType, titleHeader);
	}

	@And("Capture the Discount report with payment via {string} and verify the {string} amount with the cart Amount")
	public void verify_HeaderDetails_in_DiscountReport(String paymentMethod, String header)
			throws FileNotFoundException, IOException, InterruptedException {
		String titleHeader = excelReader(scenarioName, header);
		String PaymentType = excelReader(scenarioName, paymentMethod);
		ChargePage.verifydiscountreport(PaymentType, titleHeader);
	}

	@And("Capture the Employee Sale Summary report of {string} with payment via {string} and verify the {string} amount with the cart Amount")
	public void verify_HeaderDetails_in_EmployeeSaleSummaryReport(String userName, String paymentMethod, String header)
			throws FileNotFoundException, IOException, InterruptedException {

		String username = excelReader(scenarioName, userName);
		String titleHeader = excelReader(scenarioName, header);
		String PaymentType = excelReader(scenarioName, paymentMethod);

		ChargePage.verifyEmployeeSaleSummaryReport(PaymentType, username, titleHeader);
	}

	@And("Select the user {string} from the dropdown in Employee Sale Summary report")
	public void selectUserFromDropdown(String userName)
			throws FileNotFoundException, IOException, InterruptedException {
		String username = excelReader(scenarioName, userName);
		ChargePage.selectUserNameFromDropdown(username);
	}

	@And("Verify the total item Amount for {string},{string},{string},{string} is displaying correctly in Item report")
	public void verifyItemReport(String superCatName, String categoryName, String itemName, String quantity)
			throws FileNotFoundException, IOException {
		String supcatname = excelReader(scenarioName, superCatName);
		String catagoryname = excelReader(scenarioName, categoryName);
		String itemname = excelReader(scenarioName, itemName);
		String itemQuantity = excelReader(scenarioName, quantity);
		ChargePage.verifyItemReport(supcatname, catagoryname, itemname, itemQuantity);
	}

	@And("verify the receipt details of rest amount payment process via Cheque {string} and {string}")
	public void chequePaymentprocess(String paymentMethod, String checqueNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String payMethod = excelReader(scenarioName, paymentMethod);
		String chequeNum = excelReader(scenarioName, checqueNumber);
		System.out.println(chequeNum);
		// ChargePage.click_ChargeButton();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[text()=' " + payMethod + "']")).click();
			ChargePage.enter_chequeDetail(chequeNum);
			Thread.sleep(4000);
			ChargePage.verifyTenderChequeReceiptDetails();
		} else {
			System.out.println(payMethod + " option Not found.");
		}

	}

	@And("verify the receipt details of partial amount {string} process via Cheque {string} and {string}")
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
			ChargePage.verifyTenderChequeReceiptDetails(tenderAmount);
		} else {
			System.out.println(payMethod + " option Not found.");
		}

	}

//deposit Section

	@And("Select on Total Amount radio button on request deposit Page")
	public void selectTotalAmtRadiobtn() {
		DepositsPageObjects depositPage = new DepositsPageObjects(driver);
		depositPage.requestDeposit_totalAmt();
	}

	@And("Generate the Url for {string} via email for {string} and {string}")
	public void generateURL(String depositMethod, String orderID, String date)
			throws FileNotFoundException, IOException {
		DepositsPageObjects depositPage = new DepositsPageObjects(driver);
		String depositVia = excelReader(scenarioName, depositMethod);
		String orderDate = excelReader(scenarioName, date);
		depositPage.fetchDataFromDatabase(orderID);
		depositPage.generateUrlString(orderDate, depositVia);
	}

	// Tender Amount Transaction history
	@And("Click on the transaction and verify the tender transaction receipt details")
	public void verifyTenderTransactionreceipt() throws InterruptedException {
		ChargePage.tenderTransactionhistory_receipt();
	}

	@And("Click on refund button, select the partial refund {string}  for {string} whose {string}")
	public void enterpartialRefundAmount(String partialrefundAmt, String payType, String tenderAMt)
			throws InterruptedException, FileNotFoundException, IOException {
		String partialRefundAmount = excelReader(scenarioName, partialrefundAmt);
		String paymentMethod = excelReader(scenarioName, payType);
		String tenderAmount = excelReader(scenarioName, tenderAMt);
		ChargePage.enterPartialRefund(partialRefundAmount, paymentMethod, tenderAmount);
	}

	@And("Click on refund button, select the full refund for {string} whose {string}")
	public void selectfullRefundTender(String payType, String tenderAMt)
			throws InterruptedException, FileNotFoundException, IOException {

		String paymentMethod = excelReader(scenarioName, payType);
		String tenderAmount = excelReader(scenarioName, tenderAMt);
		ChargePage.verifyTenderFullRefund(paymentMethod, tenderAmount);
	}

	@And("Click on refund button, select the full refund for {string}")
	public void selectfullRefundForBalanceAmount(String payType)
			throws InterruptedException, FileNotFoundException, IOException {

		String paymentMethod = excelReader(scenarioName, payType);

		ChargePage.verifyTenderFullRefundRestBalance(paymentMethod);
	}

	@And("Click on refund button, select the partial refund {string} for {string}")
	public void enterpartialRefundAmountforBalanceAmount(String partialrefundAmt, String payType)
			throws InterruptedException, FileNotFoundException, IOException {
		String partialRefundAmount = excelReader(scenarioName, partialrefundAmt);
		String paymentMethod = excelReader(scenarioName, payType);

		ChargePage.enterPartialRefundForRestbalance(partialRefundAmount, paymentMethod);
	}

	@And("Click on the transaction number")
	public void clickTransactionNumber() {
		ChargePage.clickOntransactionNumber();
	}
	
	@And("Verify the partial refund {string} for {string} in transaction history receipt")
	public void verifyPartialRefundTransactionHistory(String partialrefundAmt,String payType) throws FileNotFoundException, IOException, InterruptedException {
		
		String partialRefundAmount = excelReader(scenarioName, partialrefundAmt);
		String paymentMethod = excelReader(scenarioName, payType);
		ChargePage.partialRefundTransactionhistory_receipt(partialRefundAmount, paymentMethod);

	}
	
	@And("Verify the Tip refund Amount in transaction history")
	public void verifyTipRefund_TransactionHistory() {
		ChargePage.verifyTipRefund_TransactionHistory();
	}
	
	@And("Verify the full refund Amount with {string} and {string} is displayed in the transaction history")
	public void verifyFullRefund_TransactionHistory(String payMethod,String tenderAmount) throws FileNotFoundException, IOException, InterruptedException {
		String paymentMethod = excelReader(scenarioName, payMethod);
		String tenderAMT = excelReader(scenarioName, tenderAmount);
		ChargePage.verifyTenderFullRefund_TransactionHistory(paymentMethod,tenderAMT);
	}
	
	
	@And("Verify the full refund Amount with {string} is displayed in the transaction history")
	public void verifyFullRefund_TransactionHistory(String payMethod) throws FileNotFoundException, IOException, InterruptedException {
		String paymentMethod = excelReader(scenarioName, payMethod);
		ChargePage.verifyTenderFullRefund_TransactionHistory(paymentMethod);
	}

	@After
	public void after(Scenario scenario) throws InterruptedException {
		if (scenario.isFailed()) {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			byte[] screnshot = screenShot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screnshot, "image/png", scenarioName);
		}

		driver.close();
		Thread.sleep(2000);
		driver.quit();

	}

}