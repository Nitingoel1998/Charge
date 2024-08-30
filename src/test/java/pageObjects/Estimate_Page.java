package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.*;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.hc.core5.util.Asserts;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;

import com.qa.util.CSVReader;
import com.qa.util.ExcelReader;

import stepDefinitions.BaseTest;
import java.text.ParseException;

public class Estimate_Page extends BaseTest {

	WebDriver driver;
	static ChargePageObjects ChargePage;
	static String estimate_receiptID;
	WebDriverWait wait;
	static String capt_PlanID;
	public static  float depositAmount;
	static String dateTime;
	static String receiptID;
	static float quichAmt;

	public Estimate_Page(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

// Estimate Section
	@FindBy(xpath = "//a[contains(text(),'Estimates')]")
	WebElement estimate_Section;

	@FindBy(xpath = "(//*[contains(text(),'Estimate')]/../following-sibling::div/a)[2]")
	WebElement createNewEstimate;

	@FindBy(xpath = "//input[@id='search-item']")
	WebElement searchItem_Estimate;

	@FindBy(xpath = "//div[@id='show-item-list']/a")
	WebElement list_Item;

	@FindBy(xpath = "//span[@onclick='qtyPlus(this)']")
	WebElement item_increment;

	@FindBy(xpath = "//span[@onclick='qtyMinus(this)']")
	WebElement item_decrement;

	@FindBy(xpath = "(//*[@id='addedItemList']//td/input[@type='text'])[2]")
	WebElement item_Costvalue;

	@FindBy(xpath = "(//*[@id='addedItemList']//td/input[@type='text'])[3]")
	WebElement item_Totalvalue;

	@FindBy(xpath = "//a[@onclick='deleteItem(this)']")
	WebElement deleteItem_icon;

	@FindBy(xpath = "//select[@id='invoiceDiscountType']/option[@value='PCT']")
	WebElement percentDiscountSelection;

	@FindBy(xpath = "//select[@id='invoiceDiscountType']/option[@value='AMT']")
	WebElement amountDiscountSelection;

	@FindBy(xpath = "//input[@id='invoiceDiscountValue']")
	WebElement inputDiscount_TextField;

	@FindBy(xpath = "//input[@value='Apply']")
	WebElement discount_Apply_btn;

	@FindBy(xpath = "//a[@onclick='generateInvoice()']")
	WebElement save_btn;

	@FindBy(xpath = "//a[text()='Save & Send']")
	WebElement save_and_Send_btn;

	@FindBy(xpath = "//*[@id='orderNote']")
	WebElement orderNote_textField;

	@FindBy(xpath = "//button[@data-target='#assigncustomer']")
	WebElement assignCustomer_btn;

	@FindBy(xpath = "//a[@title='Edit']")
	WebElement edit_estimate_btn;

	@FindBy(xpath = "//a[@title='Convert to Invoice']")
	WebElement convertToInvoice_estimate_btn;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement delete_estimate_btn;
	
	@FindBy(xpath = "//input[@id='email']/../../following-sibling::div//a")
	WebElement emailShare_Estimate;
	
	@FindBy(xpath = "//input[@id='phone']/../../following-sibling::div//a")
	WebElement phoneShare_Estimate;

	@FindBy(xpath = "//*[@id='loadContent']/tr/td[1]")
	WebElement receipt_EstimateID;

	@FindBy(xpath = "//*[@title='Convert to Invoice']")
	WebElement convertToInvoice;

	@FindBy(xpath = "//select[@onchange='changeEstimateStatus(this)']/option[contains(text(),'Draft')]")
	WebElement select_StatusEstimate;

	// Subscription section

	@FindBy(xpath = "//a[contains(text(),'Subscriptions')]")
	WebElement subscriptionSection;

	@FindBy(xpath = "//a[text()=' Create New Plan ']")
	WebElement createNewPlan;

	@FindBy(xpath = "//input[@id='planName']")
	WebElement planName;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement amount;

	@FindBy(xpath = "//input[@name='description']")
	WebElement description;

	@FindBy(xpath = "//a[@onclick='createPaymentPlan()']")
	WebElement createPlanBtn;

	@FindBy(xpath = "(//tbody//th)[1]")
	WebElement planID;

	@FindBy(xpath = "//div[contains(text(),'Subscriptions')]")
	WebElement cust_SubscriptionTab;

	@FindBy(xpath = "//a[@onclick='assignPlan(this);']")
	WebElement assignPlanBtn;

	@FindBy(xpath = "//input[@id='startDate']")
	WebElement planStartDate;

	@FindBy(xpath = "//input[@id='endDate']")
	WebElement planEndDate;

	@FindBy(xpath = "//input[@id='discountValue']")
	WebElement planDiscountValue;

	@FindBy(xpath = "//iframe[@id='worldnet-iframe']")
	WebElement iframe;

	@FindBy(xpath = "//a[text()=' Add Card ']")
	WebElement addCard;

	@FindBy(xpath = "//input[@name='CARDHOLDERNAME']")
	WebElement cardHolderNameMC;

	@FindBy(xpath = "//input[@name='CARDNUMBER']")
	WebElement cardNumber;

	@FindBy(xpath = "//input[@name='CVV']")
	WebElement cvvNumber;

	@FindBy(xpath = "//button[@name='Submit']")
	WebElement registerBtn;

	@FindBy(xpath = "//a[@onclick='subscribePlan()']")
	WebElement subscribeSavebtn;

	@FindBy(xpath = "//span[contains(text(),'Thank you, your card/ACH has been added')]")
	WebElement cardAddedSuccessmessage;

	@FindBy(xpath = "//button[@id='worldnetSecureTokenModalBtn']")
	WebElement cardwindowClose;

	@FindBy(xpath = "(//button[@class='close_BTN'])[1]")
	WebElement assignPlanClose;

	@FindBy(xpath = "//input[@id='saveCardPermission']/..//span")
	WebElement cardPermissionCheckbox;

	@FindBy(xpath = "//body/div/div/p")
	WebElement cardToggleMessage;

	// Quick Charge Page Objects

	@FindBy(xpath = "//div[@id='quick-charge']//i[@class='mp_ic_add']")
	WebElement quickChargeAddbtn;

	@FindBy(xpath = "(//div[@class='list-table cartitem']//i[@class='mp_edit-n'])[1]")
	WebElement quickItemEditbtn;

	@FindBy(xpath = "(//div[@class='list-table cartitem']//i[@class='mp_delete-n'])[1]")
	WebElement quickItemDeletebtn;

	@FindBy(xpath = "//input[@id='changeItemName']")
	WebElement changeQuickItemName;

	@FindBy(xpath = "//a[@onclick='updateName()']")
	WebElement editQuickItemUpdateBtn;

	@FindBy(xpath = "//div[@class='list-table cartitem']//i[@class='mp_ic_add']")
	WebElement increasequickItemQuantity;

	// Assign Customer Button

	@FindBy(xpath = "//a[@id='selectCustomer']")
	WebElement assignCustomervirtualterminal;

	@FindBy(xpath = "//a[@id='clearSaleBtn']")
	WebElement clearSalevirtualterminal;

	@FindBy(xpath = "//span[contains(text(),'Quick Item')]")
	WebElement quickItem;

	@FindBy(xpath = "//a[contains(text(),'Open Orders')]")
	WebElement openOrdersTab;
	
	//development section
	
	@FindBy(xpath = "//a[text()=' Create New Invoice ']")
	WebElement createNewInvoicebtn;
	
	@FindBy(xpath = "//input[@onkeyup='changePriceFunction(this)']")
	WebElement changeItemPrice;
	
	@FindBy(xpath = "//a[contains(text(),'Add Quick Item')]")
	WebElement addQuickItem_invoice;
	
	

	// Subscription Section methods
	// (//span[text()='Quick Item']/../../following-sibling::div//span)[3]
	public void subscriptionSection() {
		subscriptionSection.click();
	}

	public void createNewPlan() {
		createNewPlan.click();
	}
	
	public void createNewInvoice() {
		createNewInvoicebtn.click();
	}
	
	

	public void enterPlanDetails(String plan_Name, String plan_Amount, String plan_Description, String plan_Frequency) {
		planName.sendKeys(plan_Name);
		amount.sendKeys(plan_Amount);
		description.sendKeys(plan_Description);
		plan_Frequency = plan_Frequency.toUpperCase();
		driver.findElement(By.xpath("//select[@id='frequency']/option[text()='" + plan_Frequency + "']")).click();
		createPlanBtn.click();
	}

	public void capturePlanID() {
		capt_PlanID = planID.getText();
	}

	public void verify_PlanActive() {
		if (driver.findElements(By.xpath("//a[contains(text(),'" + capt_PlanID + "')]/../..//input")).size() != 0) {
			System.out.println("Plan is active");
		} else {
			System.out.println("Plan is not active ");
		}
	}

	public void activate_SubscriptionPlan() {
		if (driver.findElements(By.xpath("//a[contains(text(),'" + capt_PlanID + "')]/../..//input")).size() != 0) {
			System.out.println("Subscription Plan is active");
		} else {
			System.out.println("Subscription Plan is not active ");
			driver.findElement(By.xpath("//*[contains(text(),'" + capt_PlanID + "')]/../..//input")).click();
		}
	}

	public void deactivate_SubscriptionPlan() {
		if (driver.findElements(By.xpath("//a[contains(text(),'" + capt_PlanID + "')]/../..//input")).size() != 0) {
			System.out.println("Subscription Plan is active");
			driver.findElement(By.xpath("//*[contains(text(),'" + capt_PlanID + "')]/../..//input")).click();
		} else {
			System.out.println("Subscription Plan is not active ");

		}
	}

	public void navigate_CustomerSubscriptionTab() {
		cust_SubscriptionTab.click();
	}

	public void assignPlan(String planName, String startDate, String until, String endDate)
			throws InterruptedException {
		assignPlanBtn.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='plan-list']/option[contains(text(),'" + planName + "')][1]"))
				.click();
		planStartDate.sendKeys(startDate);
		driver.findElement(By.xpath("//select[@id='until']/option[contains(text(),'" + until + "')]")).click();
		planEndDate.sendKeys(endDate);

	}

	public void applyDiscount(String discountType, String discountValue, String PlanAmount) {
		float discount_Value = convertingStringToFloat(discountValue);
		float plan_amount = convertingStringToFloat(PlanAmount);
		driver.findElement(By.xpath("//select[@id='discountType']/option[@value='" + discountType + "']")).click();
		if (discountType.equalsIgnoreCase("AMT")) {
			if (discount_Value < plan_amount) {
				planDiscountValue.sendKeys(discountValue);
			} else {
				System.out.println("Please enter the valid amount less than plan amount");
			}

		} else if (discountType.equalsIgnoreCase("PCT")) {
			if (discount_Value < 100) {
				planDiscountValue.sendKeys(discountValue);
			} else {
				System.out.println("Please enter the valid percent less than plan amount");
			}
		}

	}

	public void add_CardDetail(String card_Number, String cvv_Number, String cardexpMonth, String cardexpYear,
			String cardHolderName) throws InterruptedException {
		addCard.click();
		Thread.sleep(2000);
		driver.switchTo().frame(iframe);
		cardNumber.sendKeys(card_Number);
		cvvNumber.sendKeys(cvv_Number);
		WebElement expMonth = driver
				.findElement(By.xpath("//select[@name='CCMONTH']/option[contains(text(),'" + cardexpMonth + "')]"));
		expMonth.click();

		// driver.findElement(By.xpath("//select[@name='CCYEAR']")).click();
		WebElement expYear = driver
				.findElement(By.xpath("//select[@name='CCYEAR']/option[contains(text(),'" + cardexpYear + "')]"));
		expYear.click();
		cardHolderNameMC.sendKeys(cardHolderName);
		Thread.sleep(2000);
		registerBtn.click();

	}

	public void select_card(String cardNumber) throws InterruptedException {

		cardNumber = cardNumber.substring(12);
		driver.findElement(By.xpath("//select[@id='card-list']/option[contains(text(),'" + cardNumber + "')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", cardPermissionCheckbox);
		Thread.sleep(2000);
		cardPermissionCheckbox.click();

	}

	public void subscription_Save() {
		subscribeSavebtn.click();
	}

	public void verify_success_Message() {
		if (driver.findElements(By.xpath("//span[contains(text(),'Thank you, your card/ACH has been added')]"))
				.size() != 0) {
			String successMessage = cardToggleMessage.getText();
			System.out.println(successMessage);
		} else {
			String message = cardToggleMessage.getText();
			System.out.println(message);

		}
		driver.switchTo().defaultContent();
		cardwindowClose.click();

	}

	// Estimate Section
	public void navigate_EstimateSection() {

		estimate_Section.click();
	}

	public void create_NewEstimate() {
		createNewEstimate.click();
	}

	public void enter_estimateDetails(String itemName, String itemValue, String quantity) throws InterruptedException {
		searchItem_Estimate.sendKeys(itemName);
		Thread.sleep(4000);
		list_Item.click();
		for (int i = 1; i < Integer.parseInt(quantity); i++) {
			item_increment.click();
		}
		float costValue = convertingStringToFloat(item_Costvalue.getAttribute("value"));
		System.out.println(costValue);
		float itemvalue = convertingStringToFloat(itemValue);
		assertTrue("item value is correct", itemvalue == costValue);
		float totalValue = convertingStringToFloat(item_Totalvalue.getAttribute("value"));
		assertTrue("Total value is correct", itemvalue * Integer.parseInt(quantity) == totalValue);
	}

	public void applyDiscountEstimate(String discountAMT) {
		ChargePageObjects chargePage =new  ChargePageObjects(driver);
		chargePage.cartDiscountAmt=convertingStringToFloat(discountAMT);
		amountDiscountSelection.click();
		inputDiscount_TextField.sendKeys(discountAMT);
		discount_Apply_btn.click();
	}
	
	public void applyDiscountPercentInvoice(String discountPCT) {
		ChargePageObjects chargePage =new  ChargePageObjects(driver);
		float discountpercent=convertingStringToFloat(discountPCT);
		chargePage.cartDiscountAmt=convertingStringToFloat(String.valueOf(discountpercent*chargePage.subtotalamount/100));
		percentDiscountSelection.click();
		inputDiscount_TextField.sendKeys(discountPCT);
		discount_Apply_btn.click();
	}

	public void addNotesToEstimate(String estimate_Note) {
		orderNote_textField.sendKeys(estimate_Note);
	}

	public void assign_Customer() {
		assignCustomer_btn.click();
	}

	public void clickSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		save_btn.click();
	}
	
	
	
	public void clickDeleteEstimateButton() throws InterruptedException {
		
		if (driver
				.findElement(By.xpath(
						"//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Delete']"))
				.isEnabled()) {
			driver.findElement(
					By.xpath("//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Delete']"))
					.click();
		}
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//td[contains(text(),'"+estimate_receiptID+"')]")).size()==0) {
			System.out.println("Estimate with "+estimate_receiptID +" is delete successfully");
		}else {
			System.out.println("Estimate with "+estimate_receiptID +" is not deleted");
		}
	}
	
	public void clickSaveAndSendButton_Estimate() {
		save_and_Send_btn.click();
	}

	public void capture_ReceiptID() {
		estimate_receiptID = receipt_EstimateID.getText();
		System.out.println("Receipt ID is : " + estimate_receiptID);
	}
	
	public void verifyStatusOfEstimateConvertToInvoice() {
		String status=driver.findElement(By.xpath("//span[contains(text(),'"+estimate_receiptID+"')]/../../span[2]/span")).getText();
		if(status.equalsIgnoreCase("Paid")) {
			System.out.println("Status of the invoice is : "+status);
		}else {
			System.out.println("Status of the invoice is : "+status);
		}
	}
	
	public void VerifyStatus_Estimate(String Status) {
		
		String UIestimateStatus=driver.findElement(By.xpath("//td[contains(text(),'"+estimate_receiptID+"')]/..//option[@selected]")).getText();
		if(UIestimateStatus.equalsIgnoreCase(Status)) {
			System.out.println("Status shown is the estimate is correct: "+Status);
		}else {
			System.out.println("Status shown is the estimate is not correct , Correct Status is :"+Status);
		}
		//assertTrue("Selected status is different in estimate ",driver.findElement(By.xpath("//td[contains(text(),"+estimate_receiptID+")]/..//option[contains(text(),"+Status+")]")).isEnabled());
	}
	

	public void change_Estimate_Status(String status) {

		driver.findElement(By.xpath("//td[contains(text(),'" + estimate_receiptID
				+ "')]/..//select[@onchange='changeEstimateStatus(this)']/option[contains(text(),'" + status + "')]"))
				.click();
	}

	public void clickOnEditEstimate_btn() {
		if (driver
				.findElement(By.xpath(
						"//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Edit']"))
				.isEnabled()) {
			driver.findElement(
					By.xpath("//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Edit']"))
					.click();
			System.out.println("Clicked on Edit estimate button");
		} else {
			System.out.println("Edit button is not visible");
		}
	}
	
	public void clickOnShareEstimate_btn(String method) {
		if (driver
				.findElement(By.xpath(
						"//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Share']"))
				.isEnabled()) {
			driver.findElement(
					By.xpath("//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Share']"))
					.click();
		}
		
	  if(method.equalsIgnoreCase("Email")) {
		  emailShare_Estimate.click();
		 
	  }else if(method.equalsIgnoreCase("Phone")) {
		  phoneShare_Estimate.click();
	  }else {
		  System.out.println("No Such Method found");
	  }
	  
	  if(driver.findElement(By.xpath("//div[@class='alert bg-success prependToastMessageBody text-center text-white']")).isDisplayed()) {
		  String successMessage=driver.findElement(By.xpath("//div[@class='alert bg-success prependToastMessageBody text-center text-white']")).getText();
	 System.out.println(successMessage);
	 
	  }
	driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		
		
	}
	
	public void sendToInvoice() {
		if (driver
				.findElement(By.xpath(
						"//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Convert to Invoice']"))
				.isEnabled()) {
			driver.findElement(
					By.xpath("//td[contains(text(),'" + estimate_receiptID + "')]/..//a[@title='Convert to Invoice']"))
					.click();
			System.out.println("Clicked on Invoice sent button");
		} else {
			System.out.println("Send to invoice button is not visible");
		}
	}

	// deposit section

	public void enterDepositAmount(String depositAMT) throws InterruptedException {
		String depositamount=depositAMT.replace(".", "");
		depositAmount = convertingStringToFloat(depositamount);
		int i = depositamount.length();
		char a[] = new char[i];
		//int deposit_amount = Integer.parseInt(depositAMT);
		for (i = 0; i < depositamount.length(); i++) {

			a[i] = depositamount.charAt(i);
		}
		for (i = 0; i < a.length; i++) {
			driver.findElement(By.xpath("//div[@class='form-row']//a[text()='" + a[i] + "']")).click();
			Thread.sleep(2000);
		}
if(!depositAMT.contains(".")) {
		driver.findElement(By.xpath("//div[@class='form-row']//a[text()='00']")).click();
}
		
	}

	public float depositAmt() {

		return this.depositAmount;
	}

	public void enterQuickChargeAmount(String quichAmount) throws InterruptedException {
		quichAmt = convertingStringToFloat(quichAmount);
		int i = quichAmount.length();
		;
		char a[] = new char[i];
		int quick_amount = Integer.parseInt(quichAmount);
		for (i = 0; i < quichAmount.length(); i++) {

			a[i] = quichAmount.charAt(i);
		}
		for (i = 0; i < a.length; i++) {
			driver.findElement(By.xpath("//div[@id='quick-charge']//a[text()='" + a[i] + "']")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//div[@id='quick-charge']//a[text()='0']")).click();
		driver.findElement(By.xpath("//div[@id='quick-charge']//a[text()='0']")).click();
		quickChargeAddbtn.click();
	}

	public void editQuickItemName(String itemName) throws InterruptedException {
		if (driver.findElements(By.xpath("//span[contains(text(),'Quick Item')]")).size() != 0) {
			Actions action = new Actions(driver);

			action.moveToElement(quickItem).perform();
			quickItemEditbtn.click();
			Thread.sleep(2000);
			System.out.println("");
			changeQuickItemName.clear();
			changeQuickItemName.sendKeys(itemName);
			editQuickItemUpdateBtn.click();

		}
	}

	public void editQuantity(String quantity) {

		int itemQuantity = Integer.parseInt(quantity);
		Actions action = new Actions(driver);
		action.moveToElement(quickItem).perform();

		for (int i = 2; i <= itemQuantity; i++) {
			increasequickItemQuantity.click();
		}
	}
	
	public void editQuantityByTextField(String quantity) {
		driver.findElement(By.xpath("//div[@class='qty-input']//input")).clear();
	driver.findElement(By.xpath("//div[@class='qty-input']//input")).sendKeys(quantity);
	}

	public void clickOnAssigncustomer() {
		assignCustomervirtualterminal.click();
	}

	public void click_On_ClearSale_btn() throws InterruptedException {
		clearSalevirtualterminal.click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public void clickOnDeletebtn() throws InterruptedException {
		if (driver.findElements(By.xpath("//span[contains(text(),'Quick Item')]")).size() != 0) {
			Actions action = new Actions(driver);
			action.moveToElement(quickItem).perform();
			quickItemDeletebtn.click();
			Thread.sleep(2000);
		}
	}

	public void verifyItemAdded(String itemName) {
		if (driver.findElements(By.xpath("//span[contains(text(),'" + itemName + "')]")).size() != 0) {
			System.out.println("Item is displayed successfully in the cart ");
		} else {
			System.out.println("Item is not displayed into the cart");
		}
	}

	static public String dateformat() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));

		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm a");
		df.setTimeZone(cal.getTimeZone());
		dateTime = df.format(cal.getTime());
		dateTime = dateTime.replace("am", "AM").replace("pm", "PM");
		System.out.println(dateTime);
		return dateTime;
		
	}

	public void clickOpenOrderTab() {
		openOrdersTab.click();
	}

	public void clickOnopenOrder() {
		if (driver.findElements(By.xpath("//div[@id='orderListTable']//small[contains(text(),'" + dateTime + "')]"))
				.size() != 0) {

			driver.findElement(By.xpath("//div[@id='orderListTable']//small[contains(text(),'" + dateTime + "')]/.."))
					.click();

		}
	}

	public void captureOpenOrderReceiptID() {

		if (driver.findElements(By.xpath("//div[@id='orderListTable']//small[contains(text(),'" + dateTime + "')]"))
				.size() != 0) {

			receiptID = driver
					.findElement(By.xpath("//div[@id='orderListTable']//small[contains(text(),'" + dateTime + "')]/.."))
					.getText();

		}
	}
	
	//input[@name='image']

}
