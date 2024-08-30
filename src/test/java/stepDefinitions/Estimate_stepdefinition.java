package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;

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
import pageObjects.Estimate_Page;
import pageObjects.UsersPageObject;

public class Estimate_stepdefinition extends BaseTest {

	static Estimate_Page estimatePage;
	static String scenarioName;
	static Customer_Page customerpageObject;
	static UsersPageObject userpage;
	static ChargePageObjects chargepage;
	static String dateTime;

	
	@Before
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
	}

	@And("Navigate to Estimate Section")
	public void navigate_EstimateSection() throws InterruptedException {
		estimatePage = new Estimate_Page(driver);
Thread.sleep(2000);
		customerpageObject = new Customer_Page(driver);
		estimatePage.navigate_EstimateSection();
	}

	public void createNewEstimate() {
		estimatePage.create_NewEstimate();
	}
	
	@And("Click on Create New Estimate")
	public void clickCreateNewEstimate()
			throws FileNotFoundException, IOException, InterruptedException {
		
		estimatePage.create_NewEstimate();
		
	}

	@And("Create New Estimate and enter the details like {string} {string} {string}")
	public void enterDetails_Estimate(String itemName, String itemPrice, String quantity)
			throws FileNotFoundException, IOException, InterruptedException {
		String itemname = excelReader(scenarioName, itemName);
		String itemprice = excelReader(scenarioName, itemPrice);
		String itemQuantity = excelReader(scenarioName, quantity);
		estimatePage.create_NewEstimate();
		estimatePage.enter_estimateDetails(itemname, itemprice, itemQuantity);
	}
	
	@And("Enter the invoice details like {string} {string} {string}")
	public void enterDetails_Invoice(String itemName, String itemPrice, String quantity)
			throws FileNotFoundException, IOException, InterruptedException {
		Thread.sleep(2000);
		String itemname = excelReader(scenarioName, itemName);
		String itemprice = excelReader(scenarioName, itemPrice);
		String itemQuantity = excelReader(scenarioName, quantity);
		chargepage= new ChargePageObjects(driver);
		chargepage.enter_invoiceDetails(itemname, itemprice, itemQuantity);
	}
	
	@And("Verify the invoice details")
	public void verifyInvoiceDetail() {
		
		chargepage.verifyinvoicedetails();
	}
	
	@And("Click on Create New Invoice in Invoice section")
	public void createNewInvoice() {
		estimatePage = new Estimate_Page(driver);
		estimatePage.createNewInvoice();
	}

	@And("Apply Discount on Estimate {string}")
	public void enterDiscount(String discountAmt) throws FileNotFoundException, IOException {
		String discountAmount = excelReader(scenarioName, discountAmt);
		estimatePage = new Estimate_Page(driver);
		estimatePage.applyDiscountEstimate(discountAmount);
	}
	
	@And("Apply Discount percent on Estimate or Invoice {string}")
	public void enterDiscountPercent_Invoice_Estimate(String discountpercent) throws FileNotFoundException, IOException {
		String discountPCT = excelReader(scenarioName, discountpercent);
		estimatePage = new Estimate_Page(driver);
		estimatePage.applyDiscountPercentInvoice(discountPCT);
	}
	
	
	@And("Select the Customer from estimate page")
	public void addCustomer() {
		estimatePage.assign_Customer();
	}

	@And("Add a {string} in create new Estimate Page")
	public void addNote_estimate(String note) throws FileNotFoundException, IOException {
		String estimateNote = excelReader(scenarioName, note);
		estimatePage.addNotesToEstimate(estimateNote);
	}

	@And("Click on Save button in create new Estimate Page")
	public void clickSaveButton() throws InterruptedException {
		estimatePage.clickSaveButton();
	}
	
	@And("Click on Save and Send button in create new Estimate Page")
	public void clickSaveAndSendButton() {
		estimatePage.clickSaveAndSendButton_Estimate();
	}

	@And("Capture the receiptID")
	public void captureReceiptID() {
		estimatePage.capture_ReceiptID();
	}
	
	@And("verify the invoice status for Estimate converted to invoice")
	public void verifyStatusOfEstimateConvertedToInvoice() {
		estimatePage.verifyStatusOfEstimateConvertToInvoice();
	}
	
	
	
	@And("Verify the {string} displayed in the created estimate")
	public void captureReceiptIDAndVerify(String status) throws FileNotFoundException, IOException {
		String estimateStatus = excelReader(scenarioName, status);
		estimatePage.VerifyStatus_Estimate(estimateStatus);
	}
	
	@And("Click on Delete button and verify the estimate is deleted from the Estimate List")
	public void deleteEstimateAndVerify() throws InterruptedException {
		Thread.sleep(2000);
		estimatePage.clickDeleteEstimateButton();
	}

	@And("Set the Newly Created estimate status to {string}")
	public void setEstimateStatus(String status) throws FileNotFoundException, IOException {

		String estimateStatus = excelReader(scenarioName, status);
		estimatePage.change_Estimate_Status(estimateStatus);
	}

	@And("Click on send invoice icon")
	public void sendInvoiceIcon() throws InterruptedException {
		Thread.sleep(2000);
		estimatePage.sendToInvoice();
	}
	
	@And("Click on edit Estimate button")
	public void editEstimate_btn() throws InterruptedException {
		Thread.sleep(2000);
		estimatePage.clickOnEditEstimate_btn();
	}
	
	@And("Click on Share button and verify the estimate is shared via {string} and verify the success message")
	public void shareEstimatebtn(String sharemethod) throws FileNotFoundException, IOException, InterruptedException {
		String share_method = excelReader(scenarioName, sharemethod);
		Thread.sleep(2000);
		estimatePage.clickOnShareEstimate_btn(share_method);
	}

	@And("Navigate to a User Section")
	public void userSection() {
		userpage = new UsersPageObject(driver);
		userpage.user_Section();
	}

	@And("Enter the details of a user {string} {string} {string} {string} {string}")
	public void addNewUser(String firstName, String lastName, String email, String cellNumber, String Access)
			throws FileNotFoundException, IOException, InterruptedException {
		String first_Name = excelReader(scenarioName, firstName);
		String last_Name = excelReader(scenarioName, lastName);
		String Email = excelReader(scenarioName, email);
		String CellNumber = excelReader(scenarioName, cellNumber);
		String access = excelReader(scenarioName, Access);
		userpage.createUser(first_Name, last_Name, Email, CellNumber, access);
	}

	@And("verify user with {string} is created successfully")
	public void verifyUserExist(String email) throws FileNotFoundException, IOException {
		String Email = excelReader(scenarioName, email);
		userpage.verify_user(Email);
	}

	@And("Click on the user with {string}")
	public void clickUser(String email) throws FileNotFoundException, IOException {
		String Email = excelReader(scenarioName, email);
		userpage.clickUser(Email);
	}

	@And("Navigate to privilege tab")
	public void privilegeSection() {
		userpage.navigate_PrivilegeTab();
	}

	@And("Select the {string} for the user")
	public void addPrivilege(String privilege) throws FileNotFoundException, IOException, InterruptedException {
		String priv = excelReader(scenarioName, privilege);
		userpage.addPrivilege(priv);
	}

	@And("click on Save button")
	public void savebtn() {
		userpage.SaveButton();
	}

	@And("Click on a delete button")
	public void delete_btn() throws InterruptedException {
		userpage.clickOnDelete();
	}

	@And("Enter the details you want to edit like {string}")
	public void enter_Detail(String header) throws FileNotFoundException, IOException {
		String headerValue = excelReader(scenarioName, header);

		userpage.edit_detail(header, headerValue);

	}

	@And("Click on Update button")
	public void updateBtn() {
		userpage.updateButton();
	}

	// Subscription Section

	@And("Navigate to a Subscription Section")
	public void subscriptionSection() {
		estimatePage = new Estimate_Page(driver);
		estimatePage.subscriptionSection();
	}

	@And("click on Create New Plan button")
	public void addPlanbtn() {
		estimatePage.createNewPlan();
	}

	@And("Enter the details {string} {string} {string} {string}")
	public void enterThePlanDetails(String planName, String planAmount, String planDescription, String planFrequency)
			throws FileNotFoundException, IOException {
		String plan_name = excelReader(scenarioName, planName);
		String plan_amount = excelReader(scenarioName, planAmount);
		String plan_description = excelReader(scenarioName, planDescription);
		String plan_frequency = excelReader(scenarioName, planFrequency);
		estimatePage.enterPlanDetails(plan_name, plan_amount, plan_description, plan_frequency);
		
	}
	
	@And("Capture Plan ID")
	public void planID() {
		estimatePage.capturePlanID();
	}

	@And("Click on customer name whose {string}")
	public void clickCustomerName(String MobileNumber) throws FileNotFoundException, IOException {
		String mobileNumber = excelReader(scenarioName, MobileNumber);
		customerpageObject = new Customer_Page(driver);
		customerpageObject.click_on_Customer(mobileNumber);
	}

	@And("Click on the Subscription tab in customer details page")
	public void click_Subscription_tab() {
		estimatePage.navigate_CustomerSubscriptionTab();
	}

	@And("Click on assign plan and enter plan details {string} {string} {string} {string}")
	public void assignpPlan_and_enterDetails(String Plan_Name, String Start_Date, String Until, String End_Date)
			throws FileNotFoundException, IOException, InterruptedException {
		String planName = excelReader(scenarioName, Plan_Name);
		String startDate = excelReader(scenarioName, Start_Date);
		String until = excelReader(scenarioName, Until);
		String endDate = excelReader(scenarioName, End_Date);

		estimatePage.assignPlan(planName, startDate, until, endDate);
	}

	@And("Select the card whose {string}")
	public void select_card(String cardNumber) throws FileNotFoundException, IOException, InterruptedException {
		String card_number = excelReader(scenarioName, cardNumber);
		estimatePage.select_card(card_number);
	}

	@And("Apply Discount {string} {string} to the Plan {string}")
	public void enterDiscountDetail(String discountType, String discountAmount, String planAmount)
			throws FileNotFoundException, IOException {

		String discounttype = excelReader(scenarioName, discountType);
		String discountamount = excelReader(scenarioName, discountAmount);
		String planamount = excelReader(scenarioName, planAmount);
		estimatePage.applyDiscount(discounttype, discountamount, planamount);

	}

	@And("Click on add card and enter the card details {string} {string} {string} {string} {string} and select the card")
	public void addCardDetais(String CardNumber, String CardExpMonth, String CardExpYear, String CardCVV,
			String CardHolderName) throws FileNotFoundException, IOException, InterruptedException {
		String card_number = excelReader(scenarioName, CardNumber);
		String card_ExpMonth = excelReader(scenarioName, CardExpMonth);
		String card_ExpYear = excelReader(scenarioName, CardExpYear);
		String card_CVV = excelReader(scenarioName, CardCVV);
		String card_holderName = excelReader(scenarioName, CardHolderName);
		estimatePage.add_CardDetail(card_number, card_CVV, card_ExpMonth, card_ExpYear, card_holderName);
	}

	@And("verify the card has been added")
	public void verifySuccessMsg() {
		estimatePage.verify_success_Message();
	}

	@And("Click on Subscription save button")
	public void click_SubscriptionSavebtn() {
		estimatePage.subscription_Save();
	}

	@And("Verify the added plan is active or not active")
	public void verifyAddedPlan() {
		estimatePage.verify_PlanActive();
	}
	
	@And("Enter the deposit Amount {string} in Quick charge")
	public void enterDepositAMT(String deposit_AMT) throws InterruptedException, FileNotFoundException, IOException {
		estimatePage = new Estimate_Page(driver);
		String deposit_Amt = excelReader(scenarioName, deposit_AMT);
		estimatePage.enterDepositAmount(deposit_Amt);
		Thread.sleep(3000);
		chargepage= new ChargePageObjects(driver);
		chargepage.calculateSurCharge();
	}
	
	//Quick charge Step definition
	
	@And("Enter the Quick charge {string} amount and click on add cart icon")
	public void enterQuickCharge(String quickchargeAMT) throws FileNotFoundException, IOException, InterruptedException {
		estimatePage = new Estimate_Page(driver);
		String quickChargeAmount = excelReader(scenarioName, quickchargeAMT);
		estimatePage.enterQuickChargeAmount(quickChargeAmount);
	}
	
	@And ("Click on the increase quantity icon {string} in quick item to the cart")
	public void enter_Quantity(String quantity) throws FileNotFoundException, IOException {
		String itemQuantity = excelReader(scenarioName, quantity);
		estimatePage.editQuantity(itemQuantity);
	}

	@And("Click on Assign Customer button")
	public void assignCustomer() {
		estimatePage.clickOnAssigncustomer();
	}
	
	@And("Click on clear sale button")
	public void clearSale() throws InterruptedException {
		estimatePage.click_On_ClearSale_btn();
	}
	
	@And("Click on edit button ,enter the {string} and click on update button")
	public void editItemName(String itemName) throws FileNotFoundException, IOException, InterruptedException {
		String itemname = excelReader(scenarioName, itemName);
		estimatePage.editQuickItemName(itemname);
	}
	
	@And("Enter the Quantity {string} of the quick item")
	public void editItemTextField(String quantity) throws FileNotFoundException, IOException {
		String quan = excelReader(scenarioName, quantity);
		estimatePage = new Estimate_Page(driver);
		estimatePage.editQuantityByTextField(quan);
	}
	
	@And("Click on delete button right to the quick item in the cart")
	public void deleteQuickItem() throws InterruptedException {
		estimatePage.clickOnDeletebtn();
	}
	
	@And("Verify the Quick item {string} is displayed into the cart or not")
	public void verifyItemIntoCart(String itemName) throws FileNotFoundException, IOException {
		String itemname = excelReader(scenarioName, itemName);
		estimatePage.verifyItemAdded(itemname);
	}
	@And("Click on Manual card button")
	public void clickOnManualCardbtn() throws InterruptedException {
		 chargepage = new ChargePageObjects(driver);
		 chargepage.manualCardPaymentbtn();
	}
	@And("Enter the tip {string} in the Tip Page")
	public void add_Tip(String Tip) throws FileNotFoundException, IOException, InterruptedException {
		String tip = excelReader(scenarioName, Tip);
		chargepage.add_Tip(tip);
	}
	@And("Click on Manual card Close button")
	public void manualCardCloseBtn() throws InterruptedException {
		chargepage.manualCardClosebtn();
	    dateTime=estimatePage.dateformat();
	}
	
	@And("Click on Deposit page Close button")
	public void depositCloseBtn() throws InterruptedException {
		Thread.sleep(2000);
		chargepage.depositClosebtn();
	}
	@And("Navigate to Open Order tab in Virtual Terminal section")
	public void OpenOrdertab() {
		estimatePage = new Estimate_Page(driver);
		estimatePage.clickOpenOrderTab();
	}
	
	@And("Click on the open order for the particular date and time")
	public void clickOnOpenorder() throws InterruptedException {
		Thread.sleep(2000);
		estimatePage.clickOnopenOrder();
	}
	
	@And("Capture the Open Order receipt ID")
	public void captureReceiptIDforOpenOrder() {
		estimatePage.captureOpenOrderReceiptID();
	}
	
	@And("verify the Open Order details")
	public void verifyOpenOrderDetail() {
		chargepage.verifyOpenOrderInvoiceReceipt();
	}
}