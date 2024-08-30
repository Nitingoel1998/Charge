package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.hc.core5.util.Asserts;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
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
import java.time.chrono.ChronoLocalDate;

import com.qa.util.CSVReader;
import com.qa.util.CouchbaseConnection2;
import com.qa.util.EncryptionUtil;
import com.qa.util.ExcelReader;

import stepDefinitions.BaseTest;

public class ChargePageObjects extends BaseTest {

	WebDriver driver;
	public static Estimate_Page estimatePage;
	public static String SupCatName;
	public static WebElement category;
	public static WebElement cat_tax;
	public static WebElement item_name;
	static float subtotalamount;
	static float cartTax;
	static float cartDiscountAmt;
	static float totalCartAmt;
	static String receiptID;
	static String PaymentAmount;
	static float balancedueAmt;
	public static float tipAmt;

	// Receipt amount
	static float totalreceiptAmt;
	static float discountreceiptAmt;
	static float taxreceiptAmt;
	static float paidByreceiptAmt;
	static float surpluspercent;
	static float subtotalreceiptAmt;
	static float tipreceiptAmt;
	static float BalanceCartAmount;

	// Development
	static float paidByVISAreceiptAmt;
	public float surchargeSubtotal;
	public float surchargeTaxtotal;
	static float paidByCashreceiptAmt;
	public static  float surchargeTotalAmount;
	public float surchargeDiscountAmount;
	static float paidByChequereceiptAmt;
	static float paidByACHreceiptAmt;
	static float tipPercent;
	public float surchargePaidByAmount;
	static float tipAMTmanualCard;

	// Partial Payment
	static String accountholder;
	static String accNumber;
	static String routingNumber;

	// full refund verification
	float achBalanceAmtAfterPartialRefund;
	float cardBalanceAmtAfterPartialRefund;
	float cashBalanceAmtAfterPartialRefund;
	float chequeBalanceAmtAfterPartialRefund;

	// static String achPaymentAmount;
	WebDriverWait wait;

	public ChargePageObjects(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		estimatePage = new Estimate_Page(driver);
	}

	public void openURL1(String url) throws FileNotFoundException, IOException {
		String URL = BaseTest.configMethod(url);
		driver.get(URL);

	}

	@FindBy(xpath = "//a[contains(text(),'Virtual Terminal')]")
	WebElement virtualTerminalSection;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement userPassword;

	@FindBy(xpath = "//a[@id='login']")
	WebElement loginButton;

	@FindBy(xpath = "//a[@class='ic_top_bar showLogoutMenuBtn']")
	WebElement userIcon;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutButton;

	@FindBy(xpath = "//i[@class='mp_ic_menu']")
	WebElement menuIcon;

	@FindBy(xpath = "//a[@class='nav-link catalogTab']")
	WebElement catalogTab;

	// Super category section

	@FindBy(xpath = "//a[@data-target='#superCategoryListModal']")
	WebElement superCategorylink;

	@FindBy(xpath = "//a[@data-target='#addEditSupCatModal']")
	WebElement addSupCat;

	@FindBy(xpath = "//input[@id='supCatName']")
	WebElement superCatName;

	@FindBy(xpath = "(//a[@onclick='saveSupCategory()'])[1]")
	WebElement addSupcatSave_button;

	// Category Section

	@FindBy(xpath = "//a[@title='Add Category']")
	WebElement addCategory;

	@FindBy(xpath = "//input[@id='catName']")
	WebElement catName;

	@FindBy(xpath = "//a[@id='saveCategory']")
	WebElement addcatSave_button;

	// Add Item in Catalog

	@FindBy(xpath = "//div[@class='searchitemlist']//i[@class='mp_ic_add']")
	WebElement addItems_button;

	@FindBy(xpath = "//input[@id='itemName']")
	WebElement addItemName;

	@FindBy(xpath = "//input[@id='price']")
	WebElement addItemPrice;

	@FindBy(xpath = "//a[@id='saveItem']")
	WebElement saveItem_button;

	@FindBy(xpath = "//a[contains(text(),'Upload Image')]")
	WebElement itemImageUploadbtn;

	// Edit item in catalog
	@FindBy(xpath = "//a[@id='checkEditItemBtn']")
	WebElement edit_Item_Button;

	@FindBy(xpath = "//a[@class='delete__pro']")
	WebElement delete_button;

	// Discount percentage page xpath

	@FindBy(xpath = "//span[@class='discount']")
	WebElement cartDiscountAmount;

	@FindBy(id = "discountBTN")
	WebElement discount_button;

	@FindBy(id = "discountPer")
	WebElement discountPer_textField;

	@FindBy(id = "pctDiscountReason")
	WebElement discountPer_reason;

	@FindBy(xpath = "//a[@class='save_btn_set applyDiscountPerBtn']")
	WebElement discountPer_applyButton;

	@FindBy(xpath = "//a[@class='save_btn_set applyDiscountAmtBtn']")
	WebElement discountAmt_applyButton;

	@FindBy(id = "discountAmt")
	WebElement discountAmt_textField;

	@FindBy(id = "amtDiscountReason")
	WebElement discountAmt_reason;

	@FindBy(id = "delDiscount")
	WebElement deleteDiscount_button;

	@FindBy(xpath = "//li[contains(text(),'Discount')]/a[contains(text(),'Change')]")
	WebElement discountChange_button;

	@FindBy(id = "discountm-tab")
	WebElement DiscountPer_tab;

	@FindBy(id = "amountm-tab")
	WebElement DiscountAmt_tab;

	@FindBy(xpath = "//div[@class='alert bg-danger prependToastMessageBody text-center text-white']")
	WebElement invalidDiscount;

	@FindBy(xpath = "//div[@id='discount']//a[contains(text(),'Cancel')]")
	WebElement discountCancelButton;

	@FindBy(xpath = "//li[contains(text(),'Tax')]//span")
	WebElement cartTaxAmount;

	@FindBy(xpath = "//span[contains(text(),'Total')]/text")
	WebElement totalCartAmount;

	@FindBy(xpath = "//a[@id='charge_btn']")
	WebElement chargeButton;

//Apply Tip Section

	@FindBy(xpath = "//a[@onclick='tipAdd()']")
	WebElement tip_Apply_btn;

	@FindBy(xpath = "//input[@class='preDefinedCustomTip']")
	WebElement customTip;

	// div[@class='key-pad-box form-row']//a[text()='2']
	// Payment type

	@FindBy(xpath = "//a[@onclick='cashPaymentBtn()']")
	WebElement cashPaymentButton;

	@FindBy(xpath = "//a[contains(text(),'Manual Card $')]")
	WebElement manualCardPaymentButton;

	@FindBy(xpath = "//a[contains(text(),'ACH $')]")
	WebElement ACHPaymentButton;

	@FindBy(xpath = "//a[@onclick='customFieldModal()']")
	WebElement sendInvoicePaymentButton;

	@FindBy(xpath = "//a[@onclick='tipAdd()']")
	WebElement tipApplyButton;

	// Manual card objects

	@FindBy(xpath = "//span[@id='amount']")
	WebElement manualcardpaymentAmount;

	@FindBy(xpath = "//a[contains(text(),'Manual Card')]/span")
	WebElement cardpaymentAmount;

	@FindBy(xpath = "//a[contains(text(),'ACH')]/span")
	WebElement achpaymentAmount;

	@FindBy(xpath = "//input[@name='CARDNUMBER']")
	WebElement cardNumberMC;

	@FindBy(xpath = "//input[@name='CVV']")
	WebElement cvvNumberMC;

	@FindBy(xpath = "//input[@name='CARDHOLDERNAME']")
	WebElement cardHolderNameMC;

	@FindBy(xpath = "//button[contains(text(),'Pay Now')]")
	WebElement payNowButtonMC;

	@FindBy(xpath = "//button[@class='close_BTN paymentclosebtn']")
	WebElement depositPageCloseBtn;

	@FindBy(xpath = "//span[@id='refNo']")
	WebElement captureReceiptID;

	// Receipt Page Object
	@FindBy(xpath = "//div[@id='orderreceipt']//button[@class='close_BTN']")
	WebElement receiptcloseButton;

	@FindBy(xpath = "//button[@id='worldnetModelClose']")
	WebElement cardreceiptcloseButton;

	@FindBy(xpath = "//b[contains(text(),'Tax')]/../../td[@class='text-right']")
	WebElement taxreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Subtotal')]/../../td[@class='text-right']")
	WebElement subTotalreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Tip')]/../../td[@class='text-right']")
	WebElement tipreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Discount')]/../../td[@class='text-right']")
	WebElement discountreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Paid by')]/../../td[@class='text-right']")
	WebElement paidByreceiptDetail;

	// Development
	@FindBy(xpath = "//b[contains(text(),'Paid by VISA')]/../../td[@class='text-right']")
	WebElement paidByVISAreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Paid by Cash')]/../../td[@class='text-right']")
	WebElement paidByCashreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Paid by ACH')]/../../td[@class='text-right']")
	WebElement paidByACHreceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Paid by Cheque')]/../../td[@class='text-right']")
	WebElement paidByChequereceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Balance Due')]/../../td[@class='text-right']")
	WebElement balanceDuereceiptDetail;

	@FindBy(xpath = "//b[contains(text(),'Total')]/../../td[@class='text-right']")
	WebElement totalreceiptDetail;

	@FindBy(xpath = "//*[@id='showChangeAmount']")
	WebElement changeAmount;

	@FindBy(xpath = "//*[@onclick='changeAmountFunction()']")
	WebElement changeAmountOk_btn;

	// ACH Payment Method
	@FindBy(xpath = "//input[@name='ACCOUNTHOLDER_NAME']")
	WebElement accountHolderName;

	@FindBy(xpath = "//input[@name='ACCOUNT_NUMBER']")
	WebElement accountNumber;

	@FindBy(xpath = "//input[@name='ROUTING_NUMBER']")
	WebElement routing_number;

	@FindBy(xpath = "//input[@name='DESCRIPTION']")
	WebElement accountdescription;

	// cheque Payment

	@FindBy(xpath = "//div[@id='userPaymentFormModal']//input[@displaylabel='Cheque']")
	WebElement chequeNumberTextfield;

	@FindBy(xpath = "//div[@id='userPaymentFormModal']//a[text()='Pay']")
	WebElement chequePayButton;

	// Iframe object for manual card details
	@FindBy(xpath = "//iframe[@id='iframe']")
	WebElement iframe;

	@FindBy(xpath = "//li[contains(text(),'Sub Total:')]//span")
	WebElement SubtotalValue;

	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement reportsSection;

	@FindBy(xpath = "//a[@class='tableToCsvBtn']")
	WebElement tabletoCSV;

	// report date range
	@FindBy(id = "daterangepicker")
	WebElement dateRange;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement dateRangeApplyButton;

	// Transaction History Page
	@FindBy(xpath = "//a[contains(text(),'Transaction History')]")
	WebElement transactionHistory_tab;

	@FindBy(xpath = "//div[contains(text(),'Discount')]/following-sibling::div")
	WebElement transactionDiscountvalue;

	@FindBy(xpath = "//div[contains(text(),'Tax')]/following-sibling::div")
	WebElement transactionTaxvalue;

	@FindBy(xpath = "//div[contains(text(),'Paid By')]/following-sibling::div")
	WebElement transactionPaidByValue;

	@FindBy(xpath = "//div[contains(text(),'Total')]/following-sibling::div")
	WebElement transactionTotalValue;

	// refund fuctionality

	@FindBy(xpath = "//div[@id='orderItemListPage']//span[contains(text(),'Refund')]")
	WebElement refundButton;

	@FindBy(xpath = "//*[@id='fullRefundBtn']")
	WebElement Refundbutton_fullrefundpage;

	@FindBy(xpath = "//*[@id='tipRefundBtn']")
	WebElement Refundbutton_tiprefundpage;

	@FindBy(xpath = "//a[contains(text(),'Full Refund')]")
	WebElement fullRefundbutton;

	@FindBy(xpath = "//a[@onclick='tipRefundModalBtn(this)']")
	WebElement tipRefundbutton;

	@FindBy(xpath = "//a[contains(text(),'Partial Refund')]")
	WebElement partialRefundButton;

	@FindBy(xpath = "//*[@id='partialAmount']")
	WebElement partialAmountTextField;

	@FindBy(xpath = "//*[@id='partialRefundBtn']")
	WebElement partialButtonAmountPage;

	@FindBy(xpath = "//div[@id='refundModal']//button[@class='close_BTN']")
	WebElement refundModalclose_btn;

	@FindBy(xpath = "//div[@id='partialRefundModal']//a[contains(text(),'Cancel')]")
	WebElement partialRefundcancel_btn;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='list-table cartitem']//div[contains(text(),'$')]"))
	private List<WebElement> rowsInCart;

	// Invoice receipt details

	@FindBy(xpath = "(//b[text()='SUBTOTAL']/../..//b)[2]")
	WebElement invoice_cashSubtotalAmount;

	@FindBy(xpath = "(//b[text()='TOTAL']/../..//b)[2]")
	WebElement invoice_cashtotalAmount;

	@FindBy(xpath = "(//b[contains(text(),'DEFAULT TAX')]/../..//b)[2]")
	WebElement invoice_cashTaxAmount;

	@FindBy(xpath = "(//b[contains(text(),'DISCOUNT')]/../..//b)[2]")
	WebElement invoice_cashDiscountAmount;

	@FindBy(xpath = "(//b[text()='SUBTOTAL']/../..//b)[3]")
	WebElement invoice_cardSubtotalAmount;

	@FindBy(xpath = "(//b[text()='TOTAL']/../..//b)[3]")
	WebElement invoice_cardtotalAmount;

	@FindBy(xpath = "(//b[contains(text(),'DEFAULT TAX')]/../..//b)[3]")
	WebElement invoice_cardTaxAmount;

	@FindBy(xpath = "(//b[contains(text(),'DISCOUNT')]/../..//b)[3]")
	WebElement invoice_cardDiscountAmount;

	@FindBy(xpath = "//button[@id='dropdownaddnew']")
	WebElement invoiceDropdownbtn;

	@FindBy(xpath = "// a[contains(text(),'Edit Invoice')]")
	WebElement invoiceEditbtn;

	@FindBy(xpath = "//textarea[@id='orderNote']")
	WebElement invoiceOrderNote;

	@FindBy(xpath = "//span[@onclick='qtyMinus(this)']")
	WebElement invoiceItemQuantityMinus;

	@FindBy(xpath = "//span[@onclick='qtyPlus(this)']")
	WebElement invoiceItemQuantityPlus;

	@FindBy(xpath = "//form[@id='invoice-upload-form']")
	WebElement invoiceAddAttachment2;

	@FindBy(xpath = "//input[@name='invoicefile']")
	WebElement invoiceAddAttachment;

	@FindBy(xpath = "//a[@id='generateInvoice']")
	WebElement generateInvoicebtn;

	@FindBy(xpath = "//input[@id='invoiceDiscountValue']")
	WebElement invoiceDiscountTextField;

	// open order page objects

	@FindBy(xpath = "//div[contains(text(),'Total')]/following-sibling::div")
	WebElement openOrderTotalAmount;

	@FindBy(xpath = "//div[contains(text(),'Discount')]/following-sibling::div")
	WebElement openOrderDiscountAmount;

	@FindBy(xpath = "//div[contains(text(),'Default Tax')]/following-sibling::div")
	WebElement openOrderTaxAmount;

	@FindBy(xpath = "//div[contains(text(),'Paid By')]/following-sibling::div")
	WebElement openOrderPaidByAmount;

	@FindBy(xpath = "//div[contains(text(),'Balance Due')]/following-sibling::div")
	WebElement openOrderBalanceDueAmount;

	@FindBy(xpath = "//*[contains(text(),'Pay')]")
	WebElement openOrderPayBtn;

	@FindBy(xpath = "(//*[contains(text(),'Receipt')])[1]")
	WebElement openOrderReceiptBtn;

	@FindBy(xpath = "//span[@id='totalInvoiceAmount']")
	WebElement totalInvoiceAmount;

	// ACH Partial payment

	@FindBy(xpath = "//input[@id='accountHolderName']")
	WebElement accHolderName_partialpayment;

	@FindBy(xpath = "//input[@id='routingNumber']")
	WebElement routingNumber_partialpayment;

	@FindBy(xpath = "//input[@id='accountNumber']")
	WebElement accNumber_partialpayment;

	@FindBy(xpath = "//a[@id='accountDetailBtn']")
	WebElement accDetailSubmitbtn_partialpayment;

	public void manualCardPaymentbtn() throws InterruptedException {
		manualCardPaymentButton.click();
		Thread.sleep(2000);
	}

	public void manualCardClosebtn() throws InterruptedException {
		cardreceiptcloseButton.click();
		Thread.sleep(2000);
	}

	public void depositCloseBtn() {
		depositPageCloseBtn.click();
	}

	public void editInvoice() {

		invoiceDropdownbtn.click();
		invoiceEditbtn.click();

	}

	public void addAttachment(String filepath) throws AWTException {
		try {
			Thread.sleep(1000);

			invoiceAddAttachment2.click();
			Thread.sleep(1000);

			driver.switchTo().activeElement().sendKeys(filepath);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addImageToItemOrCategory(String imagePath) throws AWTException {
		try {
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.click(itemImageUploadbtn).build().perform();
			// itemImageUploadbtn.click();
			Thread.sleep(1000);

			driver.switchTo().activeElement().sendKeys(imagePath);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login(String username, String password) throws InterruptedException {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);

	}

	public void virtualTerminalSection() {
		virtualTerminalSection.click();
	}

	public void createSupCat(String supCatName) throws InterruptedException {
		catalogTab.click();
		addCategory.click();
		Thread.sleep(3000);
		superCategorylink.click();
		addSupCat.click();
		Thread.sleep(1000);
		superCatName.sendKeys(supCatName);
		Thread.sleep(2000);
		addSupcatSave_button.click();
	}

	public void createCategory(String CatName, String supCatName, String tax, String imagePath)
			throws InterruptedException, AWTException {
		catName.sendKeys(CatName);
		WebElement supcat = driver.findElement(By.xpath("//option[text()='" + supCatName + "']"));
		supcat.click();
		cat_tax = driver.findElement(By.xpath("//option[contains(text(),'" + tax + "')]"));
		cat_tax.click();
		if (imagePath.isEmpty() == false) {
			addImageToItemOrCategory(imagePath);
		}
		addcatSave_button.click();
		category = driver.findElement(By.xpath("//div[@catname='" + CatName + "']"));
		Boolean verify_cat = category.isDisplayed();
		Assert.assertTrue(verify_cat);
		Thread.sleep(2000);
		// category.click();

	}

	void navigate_Catalogtab() {
		catalogTab.click();
	}

	public void createItem(String itemName, String itemPrice, String tax, String itemPath)
			throws InterruptedException, AWTException {

		addItems_button.click();
		Thread.sleep(2000);
		addItemName.sendKeys(itemName);
		Thread.sleep(2000);
		addItemPrice.sendKeys(itemPrice);
		// cat_tax.click();
		if (itemPath.isEmpty() == false) {
			String projectPath = System.getProperty("user.dir");
			addImageToItemOrCategory(projectPath + "\\src\\test\\resources\\ItemImages\\" + itemPath);
		}
		saveItem_button.click();
		Thread.sleep(2000);
		item_name = driver.findElement(By.xpath("(//span/p[contains(text(),'" + itemName + "')])[1]"));
		Assert.assertTrue(item_name.isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='searchitemlist']//a[@itemprice='" + itemPrice + "']"))
						.isDisplayed());

	}

	public void createItemWithoutImage(String itemName, String itemPrice, String tax)
			throws InterruptedException, AWTException {

		addItems_button.click();
		Thread.sleep(2000);
		addItemName.sendKeys(itemName);
		Thread.sleep(2000);
		addItemPrice.sendKeys(itemPrice);
		// cat_tax.click();
		saveItem_button.click();
		Thread.sleep(2000);
		item_name = driver.findElement(By.xpath("(//span/p[contains(text(),'" + itemName + "')])[1]"));
		Assert.assertTrue(item_name.isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='searchitemlist']//a[@itemprice='" + itemPrice + "']"))
						.isDisplayed());

	}

	public void verify_and_editItem(String catname, String item_name2, String itemPrice2) throws InterruptedException {
		// TODO Auto-generated method stub
		edit_Item_Button.click();
		item_name.click();
		addItemName.clear();
		addItemName.sendKeys(item_name2);
		addItemPrice.clear();
		addItemPrice.sendKeys(itemPrice2);
		saveItem_button.click();
		Thread.sleep(2000);
		category = driver.findElement(By.xpath("//div[@catname='" + catname + "']"));
		category.click();
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("(//span/p[contains(text(),'" + item_name2 + "')])[1]")).isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='searchitemlist']//a[@itemprice='" + itemPrice2 + "']"))
						.isDisplayed());

	}

	public void deleteItem(String item, String cat_name) {
		try {
			edit_Item_Button.click();
			item_name.click();
			delete_button.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			catalogTab.click();
			category = driver.findElement(By.xpath("//div[@catname='" + cat_name + "']"));
			category.click();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("(//span/p[contains(text(),'" + item + "')])[1]")).isDisplayed()) {
				System.out.println("Item not deleted");
			}
		} catch (Exception e) {

			System.out.println("item is deleted");
		}
//		Assert.assertEquals(
//				0,driver.findElement(By.xpath("(//span/p[contains(text(),'" + item + "')])[1]")).getSize());

	}

	public void logout() throws InterruptedException {
		userIcon.click();
		logoutButton.click();
		Thread.sleep(1000);
		surchargeTotalAmount=0;
	}

	public void verify_and_editCategory(String cat_name, String cat_name2) {
		edit_Item_Button.click();
		category.click();
		catName.clear();
		catName.sendKeys(cat_name2);
		addcatSave_button.click();
		category = driver.findElement(By.xpath("//div[@catname='" + cat_name2 + "']"));
		Boolean verify_cat = category.isDisplayed();
		Assert.assertTrue(verify_cat);

	}

	public void deleteCategory_and_verify(String cat_name) {
		try {
			edit_Item_Button.click();
			category.click();
			delete_button.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			catalogTab.click();
			Boolean verify_cat = category.isDisplayed();
			assertEquals(verify_cat, "Category is not deleted");
		} catch (Exception e) {
			System.out.println("Category is deleted");
			;
		}
	}

	@SuppressWarnings("deprecation")
	public void addItemToCart_and_verify(String itemName, String quantity) throws InterruptedException {
		// TODO Auto-generated method stub

		int quant = Integer.parseInt(quantity);
		for (int i = 1; i <= quant; i++) {
			item_name.click();
			Thread.sleep(1000);
		}
		String itemPrice = driver.findElement(By.xpath("(//span/p[contains(text(),'" + itemName + "')])[1]/../.."))
				.getAttribute("itemPrice");
		float actualItemprice = convertingStringToFloat(itemPrice);
		float totalItemPrice = actualItemprice * quant;
		String itemcartPrice = driver
				.findElement(
						By.xpath("(//span[contains(text(),'" + itemName + "')]/../../following-sibling::div//span)[3]"))
				.getText();
		float totalcartItemprice = convertingStringToFloat(itemcartPrice);
		if (totalItemPrice == totalcartItemprice) {
			System.out.println("Item cart total Price is Correct");
		} else {
			System.out.println("Item cart total Price is not Correct");
		}
		// assertEquals(totalItemPrice,totalcartItemprice,);
		String Quantity = driver
				.findElement(
						By.xpath("//span[contains(text(),'" + itemName + "')]/../../following-sibling::div//input"))
				.getAttribute("value");
		int cartQuantity = Integer.parseInt(Quantity);
		assertEquals(cartQuantity, quant);
	}

	public void verify_Cart_SubtotalAmount() {
		float totalCartvalue = 0;

		int itemRows = rowsInCart.size();
		if (itemRows != 0) {

			for (int i = 1; i <= itemRows; i++) {
				String itemIndividualPrices = driver
						.findElement(By.xpath(
								"(//div[@class='list-table cartitem']//div[contains(text(),'$')]/span)[" + i + "]"))
						.getText();
				float eachRowItemPrices = convertingStringToFloat(itemIndividualPrices);
				totalCartvalue = totalCartvalue + eachRowItemPrices;
			}
			System.out.println("SubTotal Cart Value is : " + totalCartvalue);
			subtotalamount = convertingStringToFloat(SubtotalValue.getText());
			if (subtotalamount == totalCartvalue) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect Subtotal Correct");
			}

		} else {
			System.out.println("Cart is empty");
		}
	}

	public void discount_Percentage_verify(String discountPer) throws InterruptedException {
		// TODO Auto-generated method stub

		discount_button.click();
		DiscountPer_tab.click();
		discountPer_textField.sendKeys(discountPer);
		discountPer_reason.sendKeys("Discount Percentage");
		float discountPercent = convertingStringToFloat(discountPer);
		discountPer_applyButton.click();
		if (discountPercent <= 100) {
			Thread.sleep(2000);
			float discountPerAmt = (discountPercent * subtotalamount) / 100;
			discountPerAmt = convertingStringToFloat(String.valueOf(discountPerAmt));

			if (cartDiscountAmount.isDisplayed()) {
				float cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
				if (discountPerAmt == cartDiscountAmt) {
					System.out.println("Discount price is Correct");
				} else {
					System.out.println("Discount price is not Correct");
				}
			} else {
				System.out.println("Discount is not Applied :");
			}
		} else {

			assertTrue(invalidDiscount.isEnabled());
			System.out.println(invalidDiscount.getText());
			discountCancelButton.click();
		}

	}

	public void discount_Amount_verify(float discountAmount) throws InterruptedException {
		// TODO Auto-generated method stub

		discount_button.click();
		Thread.sleep(1000);
		DiscountAmt_tab.click();
		discountAmt_textField.sendKeys(String.valueOf(discountAmount));
		discountAmt_reason.sendKeys("Discount Amount");
		;
		discountAmt_applyButton.click();
		if (discountAmount <= subtotalamount || discountAmount <= estimatePage.quichAmt) {

			Thread.sleep(2000);

			if (cartDiscountAmount.isDisplayed()) {
				float cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
				if (discountAmount == cartDiscountAmt) {
					System.out.println("Discount price is Correct");
				} else {
					System.out.println("Discount price is not Correct");
				}
			} else {
				System.out.println("Discount is not Applied :");
			}

		} else {

			assertTrue(invalidDiscount.isEnabled());
			System.out.println(invalidDiscount.getText());
			Thread.sleep(1000);
			discountCancelButton.click();
		}

	}

	public void click_ChargeButton() throws InterruptedException {
		chargeButton.click();
		Thread.sleep(3000);
		String cardpaymentAmt = cardpaymentAmount.getText().replace(",", "");
		float manualcardpayAmount = convertingStringToFloat(cardpaymentAmt);
		surpluspercent = ((manualcardpayAmount - totalCartAmt) / totalCartAmt) * 100;
		surpluspercent = convertingStringToFloat(String.valueOf(surpluspercent));
		System.out.println(surpluspercent + " SurCharge for Manual Card Payment");
	}

	public void click_ChargeButtonandContinuePartialpayment() throws InterruptedException {
		chargeButton.click();

	}

	public void cashpaymentProcess() throws InterruptedException {

		cashPaymentButton.click();

		Thread.sleep(3000);

		receiptID = captureReceiptID.getText();
		Thread.sleep(1000);
		System.out.println("Order Receipt ID : " + receiptID);
	}

	public void verifycartdetails() {
		if (cartTaxAmount.isDisplayed()) {
			cartTax = convertingStringToFloat(cartTaxAmount.getText());
			totalCartAmt = subtotalamount + cartTax;
		}
		if (cartDiscountAmount.isDisplayed()) {
			cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
			totalCartAmt = subtotalamount - cartDiscountAmt;
		}
		if (cartTaxAmount.isDisplayed() && cartDiscountAmount.isDisplayed()) {
			totalCartAmt = subtotalamount + cartTax - cartDiscountAmt;
		}

		float uiTotalValue = convertingStringToFloat(totalCartAmount.getText());
		if (uiTotalValue == totalCartAmt) {
			System.out.println("Total Cart Value is correct :" + totalCartAmt);
		} else {
			System.out.println("Total Cart Value is incorrect");
		}
		BalanceCartAmount = totalCartAmt;
	}

	public void verifyinvoicedetails() {

		totalCartAmt = convertingStringToFloat(totalInvoiceAmount.getText().replace(",", ""));
		cartTax = convertingStringToFloat(String.valueOf((subtotalamount - cartDiscountAmt) * 10 / 100));
//		if (cartTaxAmount.isDisplayed()) {
//			cartTax = convertingStringToFloat(cartTaxAmount.getText());
//			totalCartAmt = subtotalamount + cartTax;
//		}
//		if (cartDiscountAmount.isDisplayed()) {
//			cartDiscountAmt = convertingStringToFloat(cartDiscountAmount.getText());
//			totalCartAmt = subtotalamount - cartDiscountAmt;
//		}
//		if (cartTaxAmount.isDisplayed() && cartDiscountAmount.isDisplayed()) {
//			totalCartAmt = subtotalamount + cartTax - cartDiscountAmt;
//		}
//
//		float uiTotalValue = convertingStringToFloat(totalCartAmount.getText());
//		if (uiTotalValue == totalCartAmt) {
//			System.out.println("Total Cart Value is correct :" + totalCartAmt);
//		} else {
//			System.out.println("Total Cart Value is incorrect");
//		}
		BalanceCartAmount = totalCartAmt;
	}

	// verify and capture

	public void verifyCashReceiptDetails() {
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1);
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);

		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1);
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			if (totalCartAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: " + totalreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1);
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: " + discountreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1);
			System.out.println(paidByAmt);
			paidByreceiptAmt = convertingStringToFloat(paidByAmt);
			if (totalCartAmt == paidByreceiptAmt) {
				System.out.println("Paid by Receipt Amount is Correct: " + paidByreceiptAmt);
			} else if (paidByreceiptAmt == estimatePage.depositAmt()) {
				System.out.println("Paid by Receipt Amount matches with the deposit Amt");
			} else {
				System.out.println("Paid by Amount is not Correct: " + paidByreceiptAmt);
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1);
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out.println("Tax Receipt Amount is not Correct: " + taxreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1);
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == totalCartAmt - estimatePage.depositAmt()) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		receiptcloseButton.click();

	}

	public void verifyManualCardReceiptDetails() {

		float manualcardpayAmount = convertingStringToFloat(PaymentAmount);
		surpluspercent = ((manualcardpayAmount - totalCartAmt) / totalCartAmt) * 100;
		surpluspercent = convertingStringToFloat(String.valueOf(surpluspercent));
		float calculatedtotalAmt = convertingStringToFloat(
				String.valueOf((totalCartAmt * surpluspercent) / 100 + totalCartAmt));
		float calculatedDiscountAmt = convertingStringToFloat(
				String.valueOf((cartDiscountAmt * surpluspercent) / 100 + cartDiscountAmt));
		float calculatedTaxAmt = convertingStringToFloat(String.valueOf((cartTax * surpluspercent) / 100 + cartTax));
		float calculatedSubtotalAmt = convertingStringToFloat(
				String.valueOf((subtotalamount * surpluspercent) / 100 + subtotalamount));
		float tipAmt = convertingStringToFloat(String.valueOf(tipPercent * totalCartAmt / 100));
		float tipAmount = convertingStringToFloat(String.valueOf(tipAmt + ((tipAmt * surpluspercent) / 100)));
		if (subTotalreceiptDetail.isDisplayed()) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (calculatedSubtotalAmt == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: " + subtotalreceiptAmt);
			}

		}

		if (totalreceiptDetail.isDisplayed()) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float totalAmt = convertingStringToFloat(String.valueOf(calculatedtotalAmt + tipAmount));
			if (totalAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: " + totalreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (calculatedDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: " + discountreceiptAmt);
			}
		}
		if (paidByreceiptDetail.isDisplayed()) {
			String paidByAmt = paidByreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			System.out.println(paidByAmt);
			paidByreceiptAmt = convertingStringToFloat(paidByAmt);
			float paidBytotalAmount = convertingStringToFloat(String.valueOf(calculatedtotalAmt + tipAmount));
			if (paidBytotalAmount == paidByreceiptAmt) {
				System.out.println("Paid by Receipt Amount is Correct: " + paidByreceiptAmt);
			} else {
				System.out.println("Paid by Amount is not Correct: " + paidByreceiptAmt);
			}
		}
		if (taxreceiptDetail.isDisplayed()) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (calculatedTaxAmt == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out.println("Tax Receipt Amount is not Correct: " + taxreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tip')]/../../td[@class='text-right']")).size() != 0) {
			String tipamount = tipreceiptDetail.getText();
			tipamount = tipamount.substring(1).replace(",", "");
			tipreceiptAmt = convertingStringToFloat(tipamount);
			if (tipAmount == tipreceiptAmt) {
				System.out.println("Tip Amount in the receipt is Correct: " + tipAmount);
			} else {
				System.out.println("Tip Receipt Amount is not Correct: " + tipreceiptAmt);
			}

		}
		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}// a[text()=' Check UD']

	public void manualCardPaymentdetail(String tip, String cardNumber, String cardexpMonth, String cardexpYear,
			String cvv, String cardHolderName) throws InterruptedException {
		PaymentAmount = cardpaymentAmount.getText().replace(",", "");
		manualCardPaymentButton.click();
		Thread.sleep(2000);

		add_Tip(tip);

		Thread.sleep(3000);

		driver.switchTo().frame(iframe);
		// PaymentAmount = manualcardpaymentAmount.getText();
		cardNumberMC.sendKeys(cardNumber);
		// driver.findElement(By.xpath("//select[@name='CCMONTH']")).click();
		WebElement expMonth = driver
				.findElement(By.xpath("//select[@name='CCMONTH']/option[contains(text(),'" + cardexpMonth + "')]"));
		expMonth.click();

		// driver.findElement(By.xpath("//select[@name='CCYEAR']")).click();
		WebElement expYear = driver
				.findElement(By.xpath("//select[@name='CCYEAR']/option[contains(text(),'" + cardexpYear + "')]"));
		expYear.click();
		cvvNumberMC.sendKeys(cvv);
		cardHolderNameMC.sendKeys(cardHolderName);
		payNowButtonMC.click();

		Thread.sleep(5000);

		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);

	}

	public void achPaymentdetail(String tip, String AccountType, String accountnumber, String accountHolder,
			String routingnum, String accDes) throws InterruptedException {
		PaymentAmount = achpaymentAmount.getText().replace(",", "");
		ACHPaymentButton.click();
		Thread.sleep(2000);
		add_Tip(tip);
		Thread.sleep(5000);

		driver.switchTo().frame(iframe);
		// PaymentAmount = manualcardpaymentAmount.getText();
		driver.findElement(By.xpath("//select[@id='ACCOUNT_TYPE']/option[contains(text(),'" + AccountType + "')]"))
				.click();
		accountHolderName.sendKeys(accountHolder);
		accountNumber.sendKeys(accountnumber);
		routing_number.sendKeys(routingnum);

		accountdescription.sendKeys(accDes);

		payNowButtonMC.click();
		Thread.sleep(6000);
		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);

	}

	public void categoryLink(String catName) {

		category = driver.findElement(By.xpath("//div[@catname='" + catName + "']"));
		if (category.isDisplayed()) {
			category.click();
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			category.click();
		}
	}

	// code for verify table or report

	public void click_section() {
		reportsSection.click();
	}

	public void select_Report(String reportName) {
		driver.findElement(By.xpath("//a[text()=' " + reportName + " ']")).click();
	}

	public void enterDateRange(String datefrom, String dateTo) throws InterruptedException {

		dateRange.clear();
		dateRange.sendKeys(datefrom + " - " + dateTo);
		dateRangeApplyButton.click();
		Thread.sleep(2000);

	}

	public void verify_Report(String reportName) throws IOException {

		String username = System.getProperty("user.name");

		WebElement table = driver.findElement(By.xpath("(//div[@id='salesbypaytype']//table)[1]"));

		tabletoCSV.click();
		CSVReader reader = new CSVReader();
		Date currentDate = new Date();
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd_MM_yyyy");
		String date = inputFormat.format(currentDate);

		String[][] data = reader
				.readCSV("//Users//" + username + "//downloads//export_" + reportName + "_" + date + ".csv");

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] != null) {
					data[i][j] = data[i][j].replace("\"", "");
					System.out.println(data[i][j]);
				} else {

				}
			}
		}
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<WebElement> cells;
		// Compare table data with Excel data
		for (int i = 0; i < rows.size(); i++) {
			if (i == 0) {
				cells = rows.get(i).findElements(By.tagName("th"));
			} else {
				cells = rows.get(i).findElements(By.tagName("td"));
			}
			for (int j = 0; j < cells.size(); j++) {
				String cellText = cells.get(j).getText();
				String excelText = (String) data[i][j];
				if (!cellText.equals(excelText)) {
					System.out.println("Mismatch found at row " + (i + 1) + ", column " + (j + 1));
					// You may choose to handle this mismatch according to your requirements
				}
			}
		}
		System.out.println(reportName + " verified successfully:");

	}

	// Cheque detail
	public void enter_chequeDetail(String checqueNumber) throws InterruptedException {
		Thread.sleep(4000);
		chequeNumberTextfield.sendKeys(checqueNumber);
		chequePayButton.click();
		Thread.sleep(4000);
	}
	// Transaction History Object

	public void transactionhistory_receipt() throws InterruptedException {
		receiptID = receiptID.substring(2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + receiptID + "')]")));
		if (driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).isDisplayed()) {
			driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).click();

			if (transactionTotalValue.isDisplayed()) {
				String transTotalAmount = transactionTotalValue.getText();
				transTotalAmount = transTotalAmount.replaceAll(" ", "");
				transTotalAmount = transTotalAmount.substring(1);
				float totalTransactionAmt = convertingStringToFloat(transTotalAmount);
				if (totalTransactionAmt == totalreceiptAmt) {
					System.out.println("Total transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Total transaction Amount not Matched with the receipt Amount");
				}
			}
			if (transactionDiscountvalue.isDisplayed()) {
				String transDiscountAmount = transactionDiscountvalue.getText();
				transDiscountAmount = transDiscountAmount.replaceAll("\\s", "");
				transDiscountAmount = transDiscountAmount.substring(1);
				float discountTransactionAmt = convertingStringToFloat(transDiscountAmount);
				if (discountTransactionAmt == discountreceiptAmt) {
					System.out.println("Discount transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Discount transaction Amount not Matched with the receipt Amount");
				}
			}
			if (transactionTaxvalue.isDisplayed()) {
				String transTaxAmount = transactionTaxvalue.getText();
				transTaxAmount = transTaxAmount.replaceAll("\\s", "");
				transTaxAmount = transTaxAmount.substring(1);
				float taxTransactionAmt = convertingStringToFloat(transTaxAmount);
				if (taxTransactionAmt == taxreceiptAmt) {
					System.out.println("Tax transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Tax transaction Amount not Matched with the receipt Amount");
				}
			}
			if (transactionPaidByValue.isDisplayed()) {
				String transPaidByAmount = transactionPaidByValue.getText();
				transPaidByAmount = transPaidByAmount.replaceAll("\\s", "");
				transPaidByAmount = transPaidByAmount.substring(1);
				float totalPaidByAmt = convertingStringToFloat(transPaidByAmount);
				if (totalPaidByAmt == paidByreceiptAmt) {
					System.out.println("Paid By transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Paid By transaction Amount not Matched with the receipt Amount");
				}
			}
		}

	}

	public void verifyFullRefund() throws InterruptedException {

		refundButton.click();
		Thread.sleep(2000);
		fullRefundbutton.click();
		Refundbutton_fullrefundpage.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Refund']")));
		WebElement refundStatus = driver
				.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Refund']"));

		String status = refundStatus.getText();
		Assert.assertTrue(status.equalsIgnoreCase("Refund"));
	}

	public void verifyTipRefund(String paymethod) throws InterruptedException {

		if (paymethod.equalsIgnoreCase("ACH")) {
			achBalanceAmtAfterPartialRefund = paidByACHreceiptAmt - tipAMTmanualCard;
		}
		if (paymethod.equalsIgnoreCase("Card")) {
			cashBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt - tipAMTmanualCard;
		}
		refundButton.click();
		Thread.sleep(2000);
		tipRefundbutton.click();
		Refundbutton_tiprefundpage.click();
		Thread.sleep(6000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
		WebElement refundStatus = driver.findElement(
				By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));

		String status = refundStatus.getText();
		Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));
	}

	public void verifyPartialRefund(String partialrefundAmount, String payMethod) throws InterruptedException {

		float refundAmount = convertingStringToFloat(partialrefundAmount);

		refundButton.click();
		Thread.sleep(2000);
		partialRefundButton.click();

		if (payMethod.equalsIgnoreCase("Manual Card")) {
			if (refundAmount <= (paidByreceiptAmt - (paidByreceiptAmt * surpluspercent) / 100)) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ (paidByreceiptAmt - (paidByreceiptAmt * surpluspercent) / 100));
			Thread.sleep(3000);
			partialRefundcancel_btn.click();
			Thread.sleep(2000);
				refundModalclose_btn.click();
			}
		} else {
			if (refundAmount <= paidByreceiptAmt) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ paidByreceiptAmt);
				Thread.sleep(2000);
				partialRefundcancel_btn.click();
				Thread.sleep(2000);
				refundModalclose_btn.click();
			}
		}

	}

	// Send Invoice Payment
	public void send_InvoicePayment() {
		
		sendInvoicePaymentButton.click();
	}

	public void verifyInvoiceReceiptforCashorACH() {

		if (driver.findElements(By.xpath("(//b[text()='SUBTOTAL']/../..//b)[2]")).size() != 0) {
			String SubtotalAmt = invoice_cashSubtotalAmount.getText();
			SubtotalAmt = SubtotalAmt.replace("$", "").replace(",", "");
			SubtotalAmt = SubtotalAmt.replace(" ", "");
			float subTotalAmt = convertingStringToFloat(SubtotalAmt);
			if (subTotalAmt == subtotalamount) {
				System.out.println("Cash/ACH Subtotal Amount is correct");
			} else {
				System.out.println("Cash/ACH Subtotal Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[text()='TOTAL']/../..//b)[2]")).size() != 0) {
			String totalAmt = invoice_cashtotalAmount.getText();
			totalAmt = totalAmt.replace("$", "").replace(",", "");
			totalAmt = totalAmt.replace(" ", "");
			float TotalAmt = convertingStringToFloat(totalAmt);
			if (TotalAmt == totalCartAmt) {
				System.out.println("Cash/ACH Total Amount is correct");
			} else {
				System.out.println("Cash/ACH Total Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[contains(text(),'DEFAULT TAX')]/../..//b)[2]")).size() != 0) {
			String taxAmt = invoice_cashTaxAmount.getText();
			taxAmt = taxAmt.replace("$", "").replace(",", "");
			taxAmt = taxAmt.replace(" ", "");
			float TaxAmt = convertingStringToFloat(taxAmt);
			if (TaxAmt == cartTax) {
				System.out.println("Cash/ACH Tax Amount is correct");
			} else {
				System.out.println("Cash/ACH Tax Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[contains(text(),'DISCOUNT')]/../..//b)[2]")).size() != 0) {
			String discountAmt = invoice_cashDiscountAmount.getText();
			discountAmt = discountAmt.replace("$", "").replace(",", "");
			discountAmt = discountAmt.replace(" ", "");
			float DiscountAmt = convertingStringToFloat(discountAmt);
			if (DiscountAmt == cartDiscountAmt) {
				System.out.println("Cash/ACH Discount Amount is correct");
			} else {
				System.out.println("Cash/ACH Discount Amount is not correct");
			}
		}

	}

	public void verifyInvoiceReceiptforCard() {
		surpluspercent = 3;
		if (driver.findElements(By.xpath("(//b[text()='SUBTOTAL']/../..//b)[3]")).size() != 0) {
			String SubtotalAmt = invoice_cardSubtotalAmount.getText();
			SubtotalAmt = SubtotalAmt.replace("$", "").replace(",", "");
			SubtotalAmt = SubtotalAmt.replace(" ", "");
			float subTotalAmt = convertingStringToFloat(SubtotalAmt);
			if (subTotalAmt == convertingStringToFloat(
					String.valueOf(subtotalamount + (subtotalamount * surpluspercent) / 100))) {
				System.out.println("Card Subtotal Amount is correct");
			} else {
				System.out.println("Card Subtotal Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[text()='TOTAL']/../..//b)[3]")).size() != 0) {
			String totalAmt = invoice_cardtotalAmount.getText();
			totalAmt = totalAmt.replace("$", "").replace(",", "");
			totalAmt = totalAmt.replace(" ", "");
			float TotalAmt = convertingStringToFloat(totalAmt);
			if (TotalAmt == convertingStringToFloat(
					String.valueOf(totalCartAmt + (totalCartAmt * surpluspercent) / 100))) {
				System.out.println("Card Total Amount is correct");
			} else {
				System.out.println("Card Total Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[contains(text(),'DEFAULT TAX')]/../..//b)[3]")).size() != 0) {
			String taxAmt = invoice_cardTaxAmount.getText();
			taxAmt = taxAmt.replace("$", "").replace(",", "");
			taxAmt = taxAmt.replace(" ", "");
			float TaxAmt = convertingStringToFloat(taxAmt);
			float calculateTaxAmt = convertingStringToFloat(String.valueOf(cartTax + (cartTax * surpluspercent) / 100));
			if (TaxAmt == calculateTaxAmt) {
				System.out.println("Card Tax Amount is correct");
			} else {
				System.out.println("Card Tax Amount is not correct" + (TaxAmt - calculateTaxAmt));
			}
		}
		if (driver.findElements(By.xpath("(//b[contains(text(),'DISCOUNT')]/../..//b)[3]")).size() != 0) {
			String discountAmt = invoice_cardDiscountAmount.getText();
			discountAmt = discountAmt.replace("$", "").replace(",", "");
			discountAmt = discountAmt.replace(" ", "");
			float DiscountAmt = convertingStringToFloat(discountAmt);
			if (DiscountAmt == convertingStringToFloat(
					String.valueOf(cartDiscountAmt + (cartDiscountAmt * surpluspercent) / 100))) {
				System.out.println("Card Discount Amount is correct");
			} else {
				System.out.println("Card Discount Amount is not correct");
			}
		}

	}

	public void verifytransactionreport(String PaymentMethod, String header) {
		int cellIndex = 0;
		List<WebElement> value = driver.findElements(By.xpath("(//div[@id='salesbypaytype']//table)[1]//tr/th/div"));
		for (WebElement Cell : value) {
			String rowValue = Cell.getText();
			if (rowValue.equalsIgnoreCase(header)) {
				cellIndex = value.indexOf(Cell);
				System.out.println(cellIndex + 1);
			}
		}
		String cellValue = driver
				.findElement(
						By.xpath("(//a[contains(text(),'" + receiptID + "')])[1]/../../td[" + (cellIndex + 1) + "]"))
				.getText();
		String regex = "\\$([\\d\\.]+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cellValue);
		if (matcher.find()) {
			cellValue = matcher.group(1); // Extract the matched group
		}
		System.out.println(cellValue);
		float cellvalue = convertingStringToFloat(cellValue);
		if (PaymentMethod.equals("Cash") || PaymentMethod.equals("ACH")) {
			switch (header.toLowerCase()) {

			case "subtotal":
				assertTrue("Subtotal Amount is not matched in the Transaction report",
						cellvalue == subtotalamount - cartDiscountAmt);
				break;
			case "total":
				assertTrue("Total Amount is not matched in the Transaction report", cellvalue == totalCartAmt+tipreceiptAmt);
				break;
			case "discount":
				assertTrue("Discount Amount is not matched in the Transaction report", cellvalue == cartDiscountAmt);
				break;
			case "tax":
				assertTrue("Total Amount is not matched in the Transaction report", cellvalue == taxreceiptAmt);
				break;
			case "tip":
				assertTrue("Tip Amount is not matched in the Transaction report", cellvalue == tipreceiptAmt);
				break;

			}
		}
		if (PaymentMethod.equals("Manual Card")) {
			switch (header.toLowerCase()) {

			case "subtotal":
				float subtotalTransaction = subtotalreceiptAmt - discountreceiptAmt;
				subtotalTransaction = convertingStringToFloat(String.valueOf(subtotalTransaction));
				assertTrue("Subtotal Amount is not matched in the Transaction report",
						cellvalue == subtotalTransaction);
				break;
			case "total":
				assertTrue("Total Amount is not matched in the Transaction report", cellvalue == totalreceiptAmt);
				break;
			case "discount":
				assertTrue("Discount Amount is not matched in the Transaction report", cellvalue == discountreceiptAmt);
				break;
			case "tax":
				assertTrue("Total Amount is not matched in the Transaction report", cellvalue == taxreceiptAmt);
				break;
			case "tip":
				assertTrue("Tip Amount is not matched in the Transaction report", cellvalue == tipreceiptAmt);
				break;

			}
		}
	}
//Discount report

	public void verifydiscountreport(String PaymentMethod, String header) {
		int cellIndex = 0;
		List<WebElement> value = driver.findElements(By.xpath("(//div[@id='salesbypaytype']//table)[1]//tr/th/div"));
		for (WebElement Cell : value) {
			String rowValue = Cell.getText();
			if (rowValue.equalsIgnoreCase(header)) {
				cellIndex = value.indexOf(Cell);
				System.out.println(cellIndex + 1);
			}
		}
		String cellValue = driver
				.findElement(
						By.xpath("(//a[contains(text(),'" + receiptID + "')])[1]/../../td[" + (cellIndex + 1) + "]"))
				.getText();
		String regex = "\\$([\\d\\.]+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cellValue);
		if (matcher.find()) {
			cellValue = matcher.group(1); // Extract the matched group
		}
		System.out.println(cellValue);
		float cellvalue = convertingStringToFloat(cellValue);
		if (PaymentMethod.equals("Cash") || PaymentMethod.equals("ACH")) {

			assertTrue("Discount Amount is not matched in the Transaction report", cellvalue == cartDiscountAmt);
			System.out.println("Discount report is correct and verified");

		}

		if (PaymentMethod.equals("Manual Card")) {

			assertTrue("Discount Amount is not matched in the Transaction report", cellvalue == discountreceiptAmt);
			System.out.println("Discount report is correct and verified");

		}
	}

	// tip section
	public void add_Tip(String tip_Percent) throws InterruptedException {

		if (tip_Percent.contains("No Tip")) {
			tipPercent = 0;
		} else {
			tipPercent = convertingStringToFloat(tip_Percent);
		}
		if (driver.findElements(By.xpath("//div[@id='pills-tabContent']//a[contains(text(),'" + tip_Percent + "')]"))
				.size() != 0) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='pills-tabContent']//a[contains(text(),'" + tip_Percent + "')]"))
					.click();

		} else if (customTip.isDisplayed()) {
			customTip.click();
			customTip.sendKeys(tip_Percent);

		} else {
			System.out.println("Custom Tip field does not exist ");

		}
		tip_Apply_btn.click();
	}

	public void selectUserNameFromDropdown(String userName) throws InterruptedException {
		driver.findElement(By.xpath("//select[@id='employeeFilter']/option[contains(text(),'" + userName + "')]"))
				.click();
		Thread.sleep(2000);
	}

//a[text()='Users']
	public void verifyEmployeeSaleSummaryReport(String PaymentMethod, String userName, String header) {
		int cellIndex = 0;
		List<WebElement> value = driver.findElements(By.xpath("(//div[@id='salesbypaytype']//table)[1]//tr/th/div"));
		for (WebElement Cell : value) {
			String rowValue = Cell.getText();
			if (rowValue.equalsIgnoreCase(header)) {
				cellIndex = value.indexOf(Cell);
				System.out.println(cellIndex + 1);
			}
		}
		String cellValue = driver
				.findElement(
						By.xpath("(//span[contains(text(),'" + userName + "')])[1]/../../td[" + (cellIndex + 1) + "]"))
				.getText();
		String regex = "\\$([\\d\\.]+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cellValue);
		if (matcher.find()) {
			cellValue = matcher.group(1); // Extract the matched group
		}
		System.out.println(cellValue);
		float cellvalue = convertingStringToFloat(cellValue);
		if (PaymentMethod.equals("Cash") || PaymentMethod.equals("ACH")) {
			switch (header.toLowerCase()) {

			case "total sale":
				if (cellvalue > totalCartAmt) {
					System.out.println("Total sale value is greater than the transaction total amount");
				} else if (cellvalue == totalCartAmt) {
					System.out.println("Total sale value is equal to the transaction total amount");
				} else {
					assertTrue("Total Amount is less matched in the Transaction report", cellvalue >= totalCartAmt);
				}

				break;

//		case "refund":
//			assertTrue("Total Amount is not matched in the Transaction report", cellvalue == totalCartAmt);
//			break;
			case "discount":
				if (cellvalue > cartDiscountAmt) {
					System.out.println("Discount value is greater than the transaction discount amount");
				} else if (cellvalue == cartDiscountAmt) {
					System.out.println("Discount value is equal to the transaction discount amount");
				} else {
					assertTrue("Discount Amount is less in the Transaction report", cellvalue >= cartDiscountAmt);
				}

				break;
//		case "tip":
//			assertTrue("Total Amount is not matched in the Transaction report", cellvalue == taxreceiptAmt);
//			break;

			}
		}
		if (PaymentMethod.equals("Manual Card")) {
			switch (header.toLowerCase()) {

			case "total sale":
				assertTrue("Total Amount is not matched in the Transaction report", cellvalue == totalreceiptAmt);
				break;
//		case "refund":
//			assertTrue("Total Amount is not matched in the Transaction report", cellvalue == totalCartAmt);
//			break;
			case "discount":
				assertTrue("Discount Amount is not matched in the Transaction report", cellvalue == discountreceiptAmt);
				break;
//		case "tip":
//			assertTrue("Total Amount is not matched in the Transaction report", cellvalue == taxreceiptAmt);
//			break;

			}
		}
	}

	public void verifyItemReport(String superCategory, String category, String itemName, String quantity) {

		if (driver.findElements(By.xpath("//span[contains(text(),'" + superCategory
				+ "')]/../..//span[contains(text(),'" + category + "')]/../..//span[contains(text(),'" + itemName
				+ "')]/../..//td[contains(text(),'" + quantity + "')]/..//td[5]")).size() != 0) {
			String itemAmount = driver.findElement(By.xpath("//span[contains(text(),'" + superCategory
					+ "')]/../..//span[contains(text(),'" + category + "')]/../..//span[contains(text(),'" + itemName
					+ "')]/../..//td[contains(text(),'" + quantity + "')]/..//td[5]")).getText();
			String regex = "\\$([\\d\\.]+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(itemAmount);
			if (matcher.find()) {
				itemAmount = matcher.group(1); // Extract the matched group
			}
			float itemamount = convertingStringToFloat(itemAmount);

			float receiptitemAmount = convertingStringToFloat(
					String.valueOf(subtotalreceiptAmt + taxreceiptAmt - discountreceiptAmt - tipreceiptAmt));
			if (itemamount == receiptitemAmount) {
				System.out.println("Item Amount is correct in item Report");
			} else {
				System.out.println("Item Amount is not correct in item Report");
			}
		} else {
			System.out.println("Item Report Not found ");
		}
	}

	public void verifyOpenOrderInvoiceReceipt() {

		if (openOrderTotalAmount.isDisplayed()) {
			String totalAmt = openOrderTotalAmount.getText();
			totalAmt = totalAmt.replace("$", "");
			totalAmt = totalAmt.replace(" ", "");
			float TotalAmt = convertingStringToFloat(totalAmt);
			if (TotalAmt == estimatePage.quichAmt - cartDiscountAmt + cartTax) {
				System.out.println("Total Amount is correct");
			} else {
				System.out.println("Total Amount is not correct");
			}
		}
		if (openOrderTaxAmount.isDisplayed()) {
			String taxAmt = openOrderTaxAmount.getText();
			taxAmt = taxAmt.replace("$", "");
			taxAmt = taxAmt.replace(" ", "");
			float TaxAmt = convertingStringToFloat(taxAmt);
			if (TaxAmt == cartTax) {
				System.out.println("Tax Amount is correct");
			} else {
				System.out.println("Tax Amount is not correct");
			}
		}
		if (openOrderDiscountAmount.isDisplayed()) {
			String discountAmt = openOrderDiscountAmount.getText();
			discountAmt = discountAmt.replace("$", "");
			discountAmt = discountAmt.replace(" ", "");
			float DiscountAmt = convertingStringToFloat(discountAmt);
			if (DiscountAmt == cartDiscountAmt) {
				System.out.println("Discount Amount is correct");
			} else {
				System.out.println("Discount Amount is not correct");
			}
		}
//		if (openOrderPaidByAmount.isDisplayed()) {
//			String paidByAmt = openOrderPaidByAmount.getText();
//			paidByAmt = paidByAmt.substring(1);
//			System.out.println(paidByAmt);
//			paidByreceiptAmt = convertingStringToFloat(paidByAmt);
//			if (totalCartAmt == paidByreceiptAmt) {
//				System.out.println("Paid by Receipt Amount is Correct: " + paidByreceiptAmt);
//			} 
//			else if(paidByreceiptAmt==estimatePage.depositAmt()) {
//				System.out.println("Paid by Receipt Amount matches with the deposit Amt");
//			}
//			else {
//				System.out.println("Paid by Amount is not Correct: " + paidByreceiptAmt);
//			}
//		}

		if (openOrderBalanceDueAmount.isDisplayed()) {
			String balanceDue = openOrderBalanceDueAmount.getText();
			balanceDue = balanceDue.substring(1);
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == totalCartAmt - estimatePage.depositAmt()) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

	}

	public void depositClosebtn() {
		depositPageCloseBtn.click();
	}

	// Development test cases methods

	public void manualCardTenderPaymentdetail(String cardNumber, String cardexpMonth, String cardexpYear, String cvv,
			String cardHolderName) throws InterruptedException {

		manualCardPaymentButton.click();
		Thread.sleep(4000);

		driver.switchTo().frame(iframe);
		PaymentAmount = manualcardpaymentAmount.getText();
		cardNumberMC.sendKeys(cardNumber);
		// driver.findElement(By.xpath("//select[@name='CCMONTH']")).click();
		WebElement expMonth = driver
				.findElement(By.xpath("//select[@name='CCMONTH']/option[contains(text(),'" + cardexpMonth + "')]"));
		expMonth.click();

		// driver.findElement(By.xpath("//select[@name='CCYEAR']")).click();
		WebElement expYear = driver
				.findElement(By.xpath("//select[@name='CCYEAR']/option[contains(text(),'" + cardexpYear + "')]"));
		expYear.click();
		cvvNumberMC.sendKeys(cvv);
		cardHolderNameMC.sendKeys(cardHolderName);
		payNowButtonMC.click();

		Thread.sleep(5000);

		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);

	}

	public void achTenderPaymentdetail(String AccountType, String accountnumber, String accountHolder,
			String routingnum, String accDes) throws InterruptedException {
		accountholder = accountHolder;
		accNumber = accountnumber;
		routingNumber = routingnum;
		ACHPaymentButton.click();

		Thread.sleep(5000);

		driver.switchTo().frame(iframe);
		PaymentAmount = manualcardpaymentAmount.getText().replace(",", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='ACCOUNT_TYPE']/option[contains(text(),'" + AccountType + "')]"))
				.click();
		accountHolderName.sendKeys(accountHolder);
		accountNumber.sendKeys(accountnumber);
		routing_number.sendKeys(routingnum);

		accountdescription.sendKeys(accDes);

		payNowButtonMC.click();
		Thread.sleep(5000);
		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);

	}

	public void verifyTenderPaymentManualCardReceiptDetails(String depositAmount) {

		float manualcardpayAmount = convertingStringToFloat(PaymentAmount);
		float depositAmt = convertingStringToFloat(depositAmount);
		surpluspercent = ((manualcardpayAmount - depositAmt) / depositAmt) * 100;
		surpluspercent = convertingStringToFloat(String.valueOf(surpluspercent));
		surchargeSubtotal = convertingStringToFloat(String
				.valueOf(surchargeSubtotal + ((manualcardpayAmount - depositAmt) / totalCartAmt * subtotalamount)));
		surchargeTaxtotal = convertingStringToFloat(
				String.valueOf(surchargeTaxtotal + ((manualcardpayAmount - depositAmt) / totalCartAmt * cartTax)));
		surchargeTotalAmount = convertingStringToFloat(String
				.valueOf(surchargeTotalAmount + ((manualcardpayAmount - depositAmt) / totalCartAmt * totalCartAmt)));
		surchargeDiscountAmount = convertingStringToFloat(String.valueOf(
				surchargeDiscountAmount + ((manualcardpayAmount - depositAmt) / totalCartAmt * cartDiscountAmt)));
		surchargePaidByAmount = convertingStringToFloat(String
				.valueOf(surchargePaidByAmount + ((manualcardpayAmount - depositAmt) / totalCartAmt * depositAmt)));

		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct having difference of : "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float calculatedTotatAmt = convertingStringToFloat(String.valueOf(totalCartAmt + surchargeTotalAmount));
			if (calculatedTotatAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by VISA')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByVISAreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByVISAreceiptAmt = convertingStringToFloat(paidByAmt);
			if (manualcardpayAmount == paidByVISAreceiptAmt) {
				System.out.println("Paid by VISA Receipt Amount is Correct: " + paidByVISAreceiptAmt);
			} else {
				System.out
						.println("Paid by VISA Amount is not Correct: " + (manualcardpayAmount - paidByVISAreceiptAmt));
			}
			cardBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - depositAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}
		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}

	public void verifyTenderPaymentManualCardReceiptDetails() {

		float manualcardpayAmount = convertingStringToFloat(PaymentAmount);
		// float depositAmt = convertingStringToFloat(depositAmount);
		surpluspercent = ((manualcardpayAmount - BalanceCartAmount) / BalanceCartAmount) * 100;
		surpluspercent = convertingStringToFloat(String.valueOf(surpluspercent));
		surchargeSubtotal = convertingStringToFloat(String.valueOf(
				surchargeSubtotal + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * subtotalamount)));
		surchargeTaxtotal = convertingStringToFloat(String
				.valueOf(surchargeTaxtotal + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * cartTax)));
		// surchargeTiptotal=convertingStringToFloat(String.valueOf(surchargeTiptotal+((manualcardpayAmount-
		// BalanceCartAmount) / totalCartAmt * Tip)));
		surchargeTotalAmount = convertingStringToFloat(String.valueOf(
				surchargeTotalAmount + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * totalCartAmt)));
		surchargeDiscountAmount = convertingStringToFloat(String.valueOf(surchargeDiscountAmount
				+ ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * cartDiscountAmt)));

//		surchargePaidByAmount = convertingStringToFloat(String
//				.valueOf(surchargePaidByAmount + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * BalanceCartAmount)));

		float tipAmt = convertingStringToFloat(String.valueOf(tipPercent * totalCartAmt / 100));
		tipAMTmanualCard = convertingStringToFloat(String.valueOf(tipAmt + ((tipAmt * surpluspercent) / 100)));

		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct having difference of : "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float totalrecAMT = convertingStringToFloat(
					String.valueOf(totalCartAmt + surchargeTotalAmount + tipAMTmanualCard));
			if (totalrecAMT == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by VISA')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByVISAreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByVISAreceiptAmt = convertingStringToFloat(paidByAmt);
			float paidByrecAMT = convertingStringToFloat(
					String.valueOf(BalanceCartAmount + (surpluspercent * BalanceCartAmount / 100) + tipAMTmanualCard));
			if (paidByrecAMT == paidByVISAreceiptAmt) {
				System.out.println("Paid by VISA Receipt Amount is Correct: " + paidByVISAreceiptAmt);
			} else {
				System.out
						.println("Paid by VISA Amount is not Correct: " + (manualcardpayAmount - paidByVISAreceiptAmt));
			}
			cardBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tip')]/../../td[@class='text-right']")).size() != 0) {
			String tipamount = tipreceiptDetail.getText();
			tipamount = tipamount.substring(1).replace(",", "");
			System.out.println(tipamount);
			tipreceiptAmt = convertingStringToFloat(tipamount);

			System.out.println("Tip Amount in the receipt is: " + tipreceiptAmt);

		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}

	public void verifyTenderPaymentACHReceiptDetails() {

		float manualcardpayAmount = convertingStringToFloat(PaymentAmount);
		// float depositAmt = convertingStringToFloat(depositAmount);
		surpluspercent = ((manualcardpayAmount - BalanceCartAmount) / BalanceCartAmount) * 100;
		surpluspercent = convertingStringToFloat(String.valueOf(surpluspercent));
		surchargeSubtotal = convertingStringToFloat(String.valueOf(
				surchargeSubtotal + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * subtotalamount)));
		surchargeTaxtotal = convertingStringToFloat(String
				.valueOf(surchargeTaxtotal + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * cartTax)));
		// surchargeTiptotal=convertingStringToFloat(String.valueOf(surchargeTiptotal+((manualcardpayAmount-
		// BalanceCartAmount) / totalCartAmt * Tip)));
		surchargeTotalAmount = convertingStringToFloat(String.valueOf(
				surchargeTotalAmount + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * totalCartAmt)));
		surchargeDiscountAmount = convertingStringToFloat(String.valueOf(surchargeDiscountAmount
				+ ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * cartDiscountAmt)));

//		surchargePaidByAmount = convertingStringToFloat(String
//				.valueOf(surchargePaidByAmount + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * BalanceCartAmount)));

		float tipAmt = convertingStringToFloat(String.valueOf(tipPercent * totalCartAmt / 100));
		tipAMTmanualCard = convertingStringToFloat(String.valueOf(tipAmt + ((tipAmt * surpluspercent) / 100)));

		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct having difference of : "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float totalrecAMT = convertingStringToFloat(
					String.valueOf(totalCartAmt + surchargeTotalAmount + tipAMTmanualCard));
			if (totalrecAMT == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by ACH')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByACHreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByACHreceiptAmt = convertingStringToFloat(paidByAmt);
			float paidByrecAMT = convertingStringToFloat(
					String.valueOf(BalanceCartAmount + (surpluspercent * BalanceCartAmount / 100) + tipAMTmanualCard));
			if (paidByrecAMT == paidByACHreceiptAmt) {
				System.out.println("Paid by VISA Receipt Amount is Correct: " + paidByVISAreceiptAmt);
			} else {
				System.out
						.println("Paid by VISA Amount is not Correct: " + (manualcardpayAmount - paidByVISAreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tip')]/../../td[@class='text-right']")).size() != 0) {
			String tipamount = tipreceiptDetail.getText();
			tipamount = tipamount.substring(1).replace(",", "");
			System.out.println(tipamount);
			tipreceiptAmt = convertingStringToFloat(tipamount);

			System.out.println("Tip Amount in the receipt is: " + tipreceiptAmt);

		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}

	public void verifyTenderCashReceiptDetails(String tenderAmount) {

		float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			;
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			;
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			if (totalCartAmt + surchargeTotalAmount == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by Cash')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByCashreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByCashreceiptAmt = convertingStringToFloat(paidByAmt);
			if (tenderAmt == paidByCashreceiptAmt) {
				System.out.println("Paid by Cash Receipt Amount is Correct: " + paidByCashreceiptAmt);
			} else {
				System.out.println("Paid by Cash Amount is not Correct: " + (tenderAmt - paidByCashreceiptAmt));
			}
			cashBalanceAmtAfterPartialRefund = paidByCashreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - tenderAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		receiptcloseButton.click();

	}

	public void verifyTenderACHReceiptDetails(String tenderAmount) {

		float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			;
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			;
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			if (totalCartAmt + surchargeTotalAmount == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by ACH')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByACHreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByACHreceiptAmt = convertingStringToFloat(paidByAmt);

			if (tenderAmt == paidByACHreceiptAmt) {
				System.out.println("Paid by ACH Receipt Amount is Correct: " + paidByACHreceiptAmt);
			} else {
				System.out.println("Paid by ACH Amount is not Correct: " + (tenderAmt - paidByACHreceiptAmt));
			}
			achBalanceAmtAfterPartialRefund = paidByACHreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - tenderAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}

	// Cheque
	public void verifyTenderChequeReceiptDetails() throws InterruptedException {
		Thread.sleep(2000);
		// float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");

			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			if (totalCartAmt + surchargeTotalAmount == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by Cheque')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByChequereceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			System.out.println(paidByAmt);
			paidByChequereceiptAmt = convertingStringToFloat(paidByAmt);
			if (BalanceCartAmount == paidByChequereceiptAmt) {
				System.out.println("Paid by Cheque Receipt Amount is Correct: " + paidByChequereceiptAmt);
			} else {
				System.out.println("Paid by Cheque Amount is not Correct: ");
			}
			chequeBalanceAmtAfterPartialRefund = paidByChequereceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1);
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		receiptcloseButton.click();

	}

	public void verifyTenderChequeReceiptDetails(String tenderAmount) throws InterruptedException {
		Thread.sleep(5000);
		float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			;
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount + surchargeSubtotal == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount + surchargeSubtotal - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float calculatedTotalAmt = convertingStringToFloat(String.valueOf(totalCartAmt + surchargeTotalAmount));
			if (calculatedTotalAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt + surchargeDiscountAmount == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt + surchargeDiscountAmount - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by Cheque')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByChequereceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			System.out.println(paidByAmt);
			paidByChequereceiptAmt = convertingStringToFloat(paidByAmt);
			if (tenderAmt == paidByChequereceiptAmt) {
				System.out.println("Paid by Cheque Receipt Amount is Correct: " + tenderAmt);
			} else {
				System.out.println("Paid by Cheque Amount is not Correct: ");
			}
			chequeBalanceAmtAfterPartialRefund = paidByChequereceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax + surchargeTaxtotal == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax + surchargeTaxtotal - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1);
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - tenderAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		receiptcloseButton.click();

	}

	public void calculateSurCharge() {
		String cardpaymentAmt = cardpaymentAmount.getText();
		float manualcardpayAmount = convertingStringToFloat(cardpaymentAmt);
		surpluspercent = ((manualcardpayAmount - estimatePage.depositAmount) / estimatePage.depositAmount) * 100;
		surpluspercent = convertingStringToFloat(String.valueOf(surpluspercent));
		System.out.println(surpluspercent + " SurCharge for Manual Card Payment");
	}

	public void enterDepositAmount(String depositAMT) throws InterruptedException {
		float depositAmount = convertingStringToFloat(depositAMT);
		int i = depositAMT.length();
		char a[] = new char[i];
		int deposit_amount = Integer.parseInt(depositAMT);
		for (i = 0; i < depositAMT.length(); i++) {

			a[i] = depositAMT.charAt(i);
		}
		for (i = 0; i < a.length; i++) {
			driver.findElement(By.xpath("//div[@class='form-row']//a[text()='" + a[i] + "']")).click();
			Thread.sleep(2000);
		}

		driver.findElement(By.xpath("//div[@class='form-row']//a[text()='00']")).click();

	}

	public void enter_invoiceDetails(String itemName, String itemValue, String quantity) throws InterruptedException {
		if (itemName.contains("Quick Item")) {
			estimatePage.addQuickItem_invoice.click();
		} else {
			estimatePage.searchItem_Estimate.sendKeys(itemName);
			Thread.sleep(4000);
			estimatePage.list_Item.click();
		}
		estimatePage.changeItemPrice.clear();
		estimatePage.changeItemPrice.click();
		Thread.sleep(2000);
		estimatePage.changeItemPrice.sendKeys(itemValue);
		Thread.sleep(2000);
		for (int i = 1; i < Integer.parseInt(quantity); i++) {
			estimatePage.item_increment.click();
		}
		float itemprice = convertingStringToFloat(itemValue);
		float itemQuantity = convertingStringToFloat(quantity);
		subtotalamount = convertingStringToFloat(String.valueOf(itemprice * itemQuantity));

	}

	public void clickOntransactionNumber() {
		if (driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).isDisplayed()) {
			driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).click();
		}
	}

	public void tenderTransactionhistory_receipt() throws InterruptedException {
		receiptID = receiptID.substring(2);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + receiptID + "')]")));
		if (driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).isDisplayed()) {
			driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).click();

			if (driver.findElements(By.xpath("//div[contains(text(),'Total')]/following-sibling::div")).size() != 0) {
				String transTotalAmount = transactionTotalValue.getText();
				transTotalAmount = transTotalAmount.replaceAll(" ", "").replace(",", "");
				transTotalAmount = transTotalAmount.substring(1);
				float totalTransactionAmt = convertingStringToFloat(transTotalAmount);
				if (totalTransactionAmt == totalreceiptAmt) {
					System.out.println("Total transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Total transaction Amount not Matched with the receipt Amount");
				}
			}
			if (driver.findElements(By.xpath("//div[contains(text(),'Tip')]/following-sibling::div")).size() != 0) {
				String transTipAmount = driver
						.findElement(By.xpath("//div[contains(text(),'Tip')]/following-sibling::div")).getText();
				transTipAmount = transTipAmount.replaceAll(" ", "").replace(",", "");
				transTipAmount = transTipAmount.substring(1);
				float tipTransactionAmt = convertingStringToFloat(transTipAmount);
				if (tipTransactionAmt == tipAMTmanualCard) {
					System.out.println("Tip transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Tip transaction Amount not Matched with the receipt Amount");
				}
			}
			if (driver.findElements(By.xpath("//div[contains(text(),'Discount')]/following-sibling::div"))
					.size() != 0) {
				String transDiscountAmount = transactionDiscountvalue.getText();
				transDiscountAmount = transDiscountAmount.replaceAll("\\s", "").replace(",", "");
				transDiscountAmount = transDiscountAmount.substring(1);
				float discountTransactionAmt = convertingStringToFloat(transDiscountAmount);
				if (discountTransactionAmt == discountreceiptAmt) {
					System.out.println("Discount transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Discount transaction Amount not Matched with the receipt Amount");
				}
			}
			if (driver.findElements(By.xpath("//div[contains(text(),'Tax')]/following-sibling::div")).size() != 0) {
				String transTaxAmount = transactionTaxvalue.getText();
				transTaxAmount = transTaxAmount.replaceAll("\\s", "").replace(",", "");
				transTaxAmount = transTaxAmount.substring(1);
				float taxTransactionAmt = convertingStringToFloat(transTaxAmount);
				if (taxTransactionAmt == taxreceiptAmt) {
					System.out.println("Tax transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Tax transaction Amount not Matched with the receipt Amount");
				}
			}
			if (driver.findElements(By.xpath("//div[contains(text(),'Paid By VISA')]/following-sibling::div"))
					.size() != 0) {
				String transPaidByVISA = driver
						.findElement(By.xpath("//div[contains(text(),'Paid By VISA')]/following-sibling::div"))
						.getText();
				transPaidByVISA = transPaidByVISA.replaceAll("\\s", "").replace(",", "");
				transPaidByVISA = transPaidByVISA.substring(1);
				float totalPaidByVisaAmt = convertingStringToFloat(transPaidByVISA);
				if (totalPaidByVisaAmt == paidByVISAreceiptAmt) {
					System.out.println("Paid By VISA transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Paid By VISA transaction Amount not Matched with the receipt Amount");
				}
			}

			if (driver.findElements(By.xpath("//div[contains(text(),'Paid By Cheque')]/following-sibling::div"))
					.size() != 0) {
				String transPaidByCheque = driver
						.findElement(By.xpath("//div[contains(text(),'Paid By Cheque')]/following-sibling::div"))
						.getText();
				transPaidByCheque = transPaidByCheque.replaceAll("\\s", "").replace(",", "");
				transPaidByCheque = transPaidByCheque.substring(1);
				float totalPaidByChequeAmt = convertingStringToFloat(transPaidByCheque);
				if (totalPaidByChequeAmt == paidByChequereceiptAmt) {
					System.out.println("Paid By Cheque transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Paid By Cheque transaction Amount not Matched with the receipt Amount");
				}
			}

			if (driver.findElements(By.xpath("//div[contains(text(),'Paid By ACH')]/following-sibling::div"))
					.size() != 0) {
				String transPaidByACH = driver
						.findElement(By.xpath("//div[contains(text(),'Paid By ACH')]/following-sibling::div"))
						.getText();
				transPaidByACH = transPaidByACH.replaceAll("\\s", "").replace(",", "");
				transPaidByACH = transPaidByACH.substring(1);
				float totalPaidByACHAmt = convertingStringToFloat(transPaidByACH);
				if (totalPaidByACHAmt == paidByACHreceiptAmt) {
					System.out.println("Paid By ACH transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Paid By ACH transaction Amount not Matched with the receipt Amount");
				}
			}

			if (driver.findElements(By.xpath("//div[contains(text(),'Paid By Cash')]/following-sibling::div"))
					.size() != 0) {
				String transPaidByCash = driver
						.findElement(By.xpath("//div[contains(text(),'Paid By Cash')]/following-sibling::div"))
						.getText();
				transPaidByCash = transPaidByCash.replaceAll("\\s", "").replace(",", "");
				transPaidByCash = transPaidByCash.substring(1);
				float totalPaidByCashAmt = convertingStringToFloat(transPaidByCash);
				if (totalPaidByCashAmt == paidByCashreceiptAmt) {
					System.out.println("Paid By Cash transaction Amount Matched with the receipt Amount");
				} else {
					System.out.println("Paid By Cash transaction Amount not Matched with the receipt Amount");
				}
			}
		}

	}

	public void enterPartialRefund(String partialrefundAmount, String payMethod, String depositAmt)
			throws InterruptedException {

		payMethod = payMethod.toUpperCase();
		float refundAmount = convertingStringToFloat(partialrefundAmount);
		float depositAmount = convertingStringToFloat(depositAmt);
		refundButton.click();
		Thread.sleep(2000);

		if (payMethod.equalsIgnoreCase("Card")) {
			cardBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ (depositAmount + (depositAmount * surpluspercent) / 100)
					+ "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= (depositAmount)) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ depositAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		} else if (payMethod.equalsIgnoreCase("Cheque")) {
			chequeBalanceAmtAfterPartialRefund = paidByChequereceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ depositAmt + "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= depositAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ depositAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		} else if (payMethod.equalsIgnoreCase("Cash")) {
			float cashBalanceAmtAfterPartialRefund = paidByCashreceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ depositAmt + "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= depositAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				Thread.sleep(6000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ depositAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		} else if (payMethod.equalsIgnoreCase("ACH")) {
			achBalanceAmtAfterPartialRefund = paidByACHreceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ depositAmt + "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= depositAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();

				accHolderName_partialpayment.sendKeys(accountholder);

				routingNumber_partialpayment.sendKeys(routingNumber);

				accNumber_partialpayment.sendKeys(accNumber);

				accDetailSubmitbtn_partialpayment.click();
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ depositAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		}

	}

	public void enterPartialRefundForRestbalance(String partialrefundAmount, String payMethod)
			throws InterruptedException {

		payMethod = payMethod.toUpperCase();
		float refundAmount = convertingStringToFloat(partialrefundAmount);
		Thread.sleep(3000);
		refundButton.click();
		Thread.sleep(2000);

		if (payMethod.equalsIgnoreCase("Card")) {

			cardBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ convertingStringToFloat(
							String.valueOf(BalanceCartAmount + (BalanceCartAmount * surpluspercent) / 100))
					+ "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= BalanceCartAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ (BalanceCartAmount - (BalanceCartAmount * surpluspercent) / 100));
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		} else if (payMethod.equalsIgnoreCase("Cheque")) {

			chequeBalanceAmtAfterPartialRefund = paidByChequereceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ BalanceCartAmount + "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= BalanceCartAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ BalanceCartAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		} else if (payMethod.equalsIgnoreCase("Cash")) {

			cashBalanceAmtAfterPartialRefund = paidByCashreceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ BalanceCartAmount + "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= BalanceCartAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();
				Thread.sleep(6000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ BalanceCartAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		} else if (payMethod.equalsIgnoreCase("ACH")) {
			achBalanceAmtAfterPartialRefund = paidByACHreceiptAmt - refundAmount;
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ BalanceCartAmount + "')]/..//a[contains(text(),'Partial Refund')]")).click();
			if (refundAmount <= BalanceCartAmount) {
				partialAmountTextField.sendKeys(String.valueOf(refundAmount));
				partialButtonAmountPage.click();

				accHolderName_partialpayment.sendKeys(accountholder);

				routingNumber_partialpayment.sendKeys(routingNumber);

				accNumber_partialpayment.sendKeys(accNumber);

				accDetailSubmitbtn_partialpayment.click();
				Thread.sleep(6000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
				WebElement refundStatus = driver.findElement(
						By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));
				String status = refundStatus.getText();
				Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));

			} else {
				System.out.println("Amount entered is more than refundable amount, Maximum refundable amount is :"
						+ BalanceCartAmount);
				partialRefundcancel_btn.click();
				refundModalclose_btn.click();
			}
		}

	}

	public void verifyTenderFullRefundRestBalance(String payMethod) throws InterruptedException {
		payMethod = payMethod.toUpperCase();

		refundButton.click();
		Thread.sleep(2000);
		if (payMethod.equalsIgnoreCase("Card")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ convertingStringToFloat(
							String.valueOf(BalanceCartAmount + (BalanceCartAmount * surpluspercent) / 100))
					+ "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
		} else if (payMethod.equalsIgnoreCase("Cheque")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ BalanceCartAmount + "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
		} else if (payMethod.equalsIgnoreCase("Cash")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ BalanceCartAmount + "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
		} else if (payMethod.equalsIgnoreCase("ACH")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ BalanceCartAmount + "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
			accHolderName_partialpayment.sendKeys(accountholder);

			routingNumber_partialpayment.sendKeys(routingNumber);

			accNumber_partialpayment.sendKeys(accNumber);

			accDetailSubmitbtn_partialpayment.click();

		}

		Thread.sleep(4000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Refund']")));
		WebElement refundStatus = driver
				.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Refund']"));

		String status = refundStatus.getText();
		Assert.assertTrue(status.equalsIgnoreCase("Refund"));
	}

	public void verifyTenderFullRefund(String payMethod, String tenderAmt) throws InterruptedException {
		payMethod = payMethod.toUpperCase();
		float depositAmount = convertingStringToFloat(tenderAmt);
		Thread.sleep(2000);
		refundButton.click();
		Thread.sleep(2000);
		if (payMethod.equalsIgnoreCase("Card")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ (depositAmount + (depositAmount * surpluspercent) / 100)
					+ "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
		} else if (payMethod.equalsIgnoreCase("Cheque")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ depositAmount + "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
		} else if (payMethod.equalsIgnoreCase("Cash")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ depositAmount + "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
		} else if (payMethod.equalsIgnoreCase("ACH")) {
			driver.findElement(By.xpath("//td[contains(text(),'" + payMethod + "')]/..//td[contains(text(),'"
					+ depositAmount + "')]/..//a[contains(text(),'Full Refund')]")).click();
			Refundbutton_fullrefundpage.click();
			accHolderName_partialpayment.sendKeys(accountholder);

			routingNumber_partialpayment.sendKeys(routingNumber);

			accNumber_partialpayment.sendKeys(accNumber);

			accDetailSubmitbtn_partialpayment.click();
		}

		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']")));
		WebElement refundStatus = driver.findElement(
				By.xpath("//span[contains(text(),'" + receiptID + "')]/..//span[text()='Partial Refund']"));

		String status = refundStatus.getText();
		Assert.assertTrue(status.equalsIgnoreCase("Partial Refund"));
	}

	public void verifyTipRefund_TransactionHistory() {
		if (driver.findElements(By.xpath("//div[contains(text(),'Tip Refund')]/following-sibling::div")).size() != 0) {
			String tipRefundAmount = driver
					.findElement(By.xpath("//div[contains(text(),'Tip Refund')]/following-sibling::div")).getText();
			tipRefundAmount = tipRefundAmount.replaceAll(" ", "").replace(",", "");
			tipRefundAmount = tipRefundAmount.substring(1);
			float tipRefundTransactionAmt = convertingStringToFloat(tipRefundAmount);
			if (tipRefundTransactionAmt == tipAMTmanualCard) {
				System.out.println("Tip refund Amount Matched with the receipt Amount");
			} else {
				System.out.println("Tip refund Cash Amount not Matched with the receipt Amount");
			}
		}
	}

	public void partialRefundTransactionhistory_receipt(String partialrefundAmount, String payMethod)
			throws InterruptedException {
		float partialRefundAmt = convertingStringToFloat(partialrefundAmount);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + receiptID + "')]")));
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).isDisplayed()) {
			driver.findElement(By.xpath("//span[contains(text(),'" + receiptID + "')]")).click();
			if (payMethod.equalsIgnoreCase("Cash")) {

				if (driver.findElements(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div"))
						.size() != 0) {
					String refundByCashAmount = driver
							.findElement(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div"))
							.getText();
					refundByCashAmount = refundByCashAmount.replaceAll(" ", "").replace(",", "");
					refundByCashAmount = refundByCashAmount.substring(1);
					float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
					if (partialRefundByCashTransactionAmt == partialRefundAmt) {
						System.out.println("Refund By Cash Amount Matched with the receipt Amount");
					} else {
						System.out.println("Refund By Cash Amount not Matched with the receipt Amount");
					}
				}
			}
			if (payMethod.equalsIgnoreCase("Cheque")) {

				if (driver.findElements(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div"))
						.size() != 0) {
					String refundByCashAmount = driver
							.findElement(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div"))
							.getText();
					refundByCashAmount = refundByCashAmount.replaceAll(" ", "").replace(",", "");
					refundByCashAmount = refundByCashAmount.substring(1);
					float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
					if (partialRefundByCashTransactionAmt == partialRefundAmt) {
						System.out.println("Refund By Cash Amount Matched with the receipt Amount");
					} else {
						System.out.println("Refund By Cash Amount not Matched with the receipt Amount");
					}
				}
			}
			if (payMethod.equalsIgnoreCase("ACH")) {

				if (driver.findElements(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div"))
						.size() != 0) {
					String refundByCashAmount = driver
							.findElement(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div"))
							.getText();
					refundByCashAmount = refundByCashAmount.replaceAll(" ", "").replace(",", "");
					refundByCashAmount = refundByCashAmount.substring(1);
					float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
					if (partialRefundByCashTransactionAmt == partialRefundAmt) {
						System.out.println("Refund By ACH Amount Matched with the receipt Amount");
					} else {
						System.out.println("Refund By ACH Amount not Matched with the receipt Amount");
					}
				}
			}
			if (payMethod.equalsIgnoreCase("Card")) {

				if (driver.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div"))
						.size() != 0) {
					String refundByCashAmount = driver
							.findElement(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div"))
							.getText();
					refundByCashAmount = refundByCashAmount.replaceAll(" ", "").replace(",", "");
					refundByCashAmount = refundByCashAmount.substring(1);
					float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
					if (partialRefundByCashTransactionAmt == partialRefundAmt) {
						System.out.println("Refund By Card Amount Matched with the receipt Amount");
					} else {
						System.out.println("Refund By Card Amount not Matched with the receipt Amount");
					}
				}

			}
		}

	}

	public void verifyTenderFullRefund_TransactionHistory(String payMethod) throws InterruptedException {

		if (payMethod.equalsIgnoreCase("Card")) {
			if (driver.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div"))
					.size() != 0) {
				for (int i = 1; i <= driver
						.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div"))
						.size(); i++) {
					String refundByVISAAmount = driver
							.findElement(By.xpath(
									"(//div[contains(text(),'Refund By VISA')]/following-sibling::div)[" + i + "]"))
							.getText();
					refundByVISAAmount = refundByVISAAmount.replaceAll(" ", "").replace(",", "");
					refundByVISAAmount = refundByVISAAmount.substring(1);
					float partialRefundByVISATransactionAmt = convertingStringToFloat(refundByVISAAmount);
					if (partialRefundByVISATransactionAmt == cardBalanceAmtAfterPartialRefund) {
						System.out.println("Refund By VISA Amount Matched with the receipt Amount");
					}
				}
			}
		}
		if (payMethod.equalsIgnoreCase("ACH")) {
			if (driver.findElements(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div"))
					.size() != 0) {
				String refundByACHAmount = driver
						.findElement(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div"))
						.getText();
				refundByACHAmount = refundByACHAmount.replaceAll(" ", "").replace(",", "");
				refundByACHAmount = refundByACHAmount.substring(1);
				float partialRefundByACHTransactionAmt = convertingStringToFloat(refundByACHAmount);
				if (partialRefundByACHTransactionAmt == achBalanceAmtAfterPartialRefund) {
					System.out.println("Refund By ACH Amount Matched with the receipt Amount");
				} else {
					System.out.println("Refund By ACH Amount not Matched with the receipt Amount");
				}
			}
		}
		if (payMethod.equalsIgnoreCase("Cash") || payMethod.equalsIgnoreCase("Cheque")) {
			String refundByCashAmount = driver
					.findElement(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div")).getText();
			refundByCashAmount = refundByCashAmount.replaceAll(" ", "").replace(",", "");
			refundByCashAmount = refundByCashAmount.substring(1);
			float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
			if (partialRefundByCashTransactionAmt == cashBalanceAmtAfterPartialRefund
					|| partialRefundByCashTransactionAmt == chequeBalanceAmtAfterPartialRefund) {
				System.out.println("Refund By Cash Amount Matched with the receipt Amount");
			} else {
				System.out.println("Refund By Cash Amount not Matched with the receipt Amount");
			}

		}
	}

//public void verifyTenderFullRefund_TransactionHistory(String payMethod) throws InterruptedException {
//		
//		
//		if (payMethod.equalsIgnoreCase("Card")) {
//			if (driver.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div")).size() != 0) {
//				for(int i=1;i<=driver.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div")).size();i++) {
//				String refundByVISAAmount = driver.findElement(By.xpath("(//div[contains(text(),'Refund By VISA')]/following-sibling::div)["+i+"]")).getText();
//				refundByVISAAmount = refundByVISAAmount.replaceAll(" ", "");
//				refundByVISAAmount = refundByVISAAmount.substring(1);
//				float partialRefundByVISATransactionAmt = convertingStringToFloat(refundByVISAAmount);
//				if (partialRefundByVISATransactionAmt == cardBalanceAmtAfterPartialRefund) {
//					System.out.println("Refund By VISA Amount Matched with the receipt Amount");
//				} 
//			}}}
//		 if (payMethod.equalsIgnoreCase("ACH")) {
//			if (driver.findElements(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div")).size() != 0) {
//				String refundByACHAmount = driver.findElement(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div")).getText();
//				refundByACHAmount = refundByACHAmount.replaceAll(" ", "");
//				refundByACHAmount = refundByACHAmount.substring(1);
//				float partialRefundByACHTransactionAmt = convertingStringToFloat(refundByACHAmount);
//				if (partialRefundByACHTransactionAmt == paidByACHreceiptAmt) {
//					System.out.println("Refund By ACH Amount Matched with the receipt Amount");
//				} else {
//					System.out.println("Refund By ACH Amount not Matched with the receipt Amount");
//				}
//			}
//		} if (payMethod.equalsIgnoreCase("Cash") ||payMethod.equalsIgnoreCase("Cheque")) {
//			String refundByCashAmount = driver.findElement(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div")).getText();
//			refundByCashAmount = refundByCashAmount.replaceAll(" ", "");
//			refundByCashAmount = refundByCashAmount.substring(1);
//			float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
//			if (partialRefundByCashTransactionAmt == paidByCashreceiptAmt ||  partialRefundByCashTransactionAmt == paidByChequereceiptAmt) {
//				System.out.println("Refund By Cash Amount Matched with the receipt Amount");
//			} else {
//				System.out.println("Refund By Cash Amount not Matched with the receipt Amount");
//			}
//		
//
//	}
//	}

	public void verifyTenderFullRefund_TransactionHistory(String payMethod, String depositAmount)
			throws InterruptedException {

		float depositAMT = convertingStringToFloat(depositAmount);
		if (payMethod.equalsIgnoreCase("Card")) {
			if (driver.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div"))
					.size() != 0) {
				for (int i = 1; i <= driver
						.findElements(By.xpath("//div[contains(text(),'Refund By VISA')]/following-sibling::div"))
						.size(); i++) {
					String refundByVISAAmount = driver
							.findElement(By.xpath(
									"(//div[contains(text(),'Refund By VISA')]/following-sibling::div)[" + i + "]"))
							.getText();
					refundByVISAAmount = refundByVISAAmount.replaceAll(" ", "").replace(",", "");
					refundByVISAAmount = refundByVISAAmount.substring(1);
					float partialRefundByVISATransactionAmt = convertingStringToFloat(refundByVISAAmount);
					float calculatedCardAmt = convertingStringToFloat(
							String.valueOf(depositAMT + (depositAMT * surpluspercent) / 100));
					if (partialRefundByVISATransactionAmt == calculatedCardAmt) {
						System.out.println("Refund By VISA Amount Matched with the receipt Amount");
					}
				}
			}
		}
		if (payMethod.equalsIgnoreCase("ACH")) {
			if (driver.findElements(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div"))
					.size() != 0) {
				String refundByACHAmount = driver
						.findElement(By.xpath("//div[contains(text(),'Refund By ACH')]/following-sibling::div"))
						.getText();
				refundByACHAmount = refundByACHAmount.replaceAll(" ", "").replace(",", "");
				refundByACHAmount = refundByACHAmount.substring(1);
				float partialRefundByACHTransactionAmt = convertingStringToFloat(refundByACHAmount);
				if (partialRefundByACHTransactionAmt == depositAMT) {
					System.out.println("Refund By ACH Amount Matched with the receipt Amount");
				} else {
					System.out.println("Refund By ACH Amount not Matched with the receipt Amount");
				}
			}
		}
		if (payMethod.equalsIgnoreCase("Cash") || payMethod.equalsIgnoreCase("Cheque")) {
			String refundByCashAmount = driver
					.findElement(By.xpath("//div[contains(text(),'Refund By Cash')]/following-sibling::div")).getText();
			refundByCashAmount = refundByCashAmount.replaceAll(" ", "").replace(",", "");
			refundByCashAmount = refundByCashAmount.substring(1);
			float partialRefundByCashTransactionAmt = convertingStringToFloat(refundByCashAmount);
			if (partialRefundByCashTransactionAmt == depositAMT
					|| partialRefundByCashTransactionAmt == paidByChequereceiptAmt) {
				System.out.println("Refund By Cash Amount Matched with the receipt Amount");
			} else {
				System.out.println("Refund By Cash Amount not Matched with the receipt Amount");
			}

		}
	}
	
	//Reward Pay Methods
	
	public void verifyTenderACHReceiptDetailsRewardPay(String tenderAmount) {

		float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			;
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			;
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			if (totalCartAmt + surchargeTotalAmount == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt== discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by ACH')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByACHreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByACHreceiptAmt = convertingStringToFloat(paidByAmt);

			if (tenderAmt == paidByACHreceiptAmt) {
				System.out.println("Paid by ACH Receipt Amount is Correct: " + paidByACHreceiptAmt);
			} else {
				System.out.println("Paid by ACH Amount is not Correct: " + (tenderAmt - paidByACHreceiptAmt));
			}
			achBalanceAmtAfterPartialRefund = paidByACHreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax  == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - tenderAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}
	
	public void manualCardTenderPaymentdetail_RewardPay(String cardNumber, String cardexpMonth, String cardexpYear, String cvv,
			String cardHolderName) throws InterruptedException {

		manualCardPaymentButton.click();
		Thread.sleep(4000);

		driver.switchTo().frame(iframe);
		
		cardNumberMC.sendKeys(cardNumber);
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//li[@class='surchargeRow']//div[@class='infoBox warning']")).isDisplayed()==true){
			surpluspercent=3;
			
		}
		// driver.findElement(By.xpath("//select[@name='CCMONTH']")).click();
		WebElement expMonth = driver
				.findElement(By.xpath("//select[@name='CCMONTH']/option[contains(text(),'" + cardexpMonth + "')]"));
		expMonth.click();

		// driver.findElement(By.xpath("//select[@name='CCYEAR']")).click();
		WebElement expYear = driver
				.findElement(By.xpath("//select[@name='CCYEAR']/option[contains(text(),'" + cardexpYear + "')]"));
		expYear.click();
		cvvNumberMC.sendKeys(cvv);
		cardHolderNameMC.sendKeys(cardHolderName);
		payNowButtonMC.click();

		Thread.sleep(5000);

		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);

	}
	
	public void manualCardPaymentdetail_RewardPay(String tip, String cardNumber, String cardexpMonth, String cardexpYear,
			String cvv, String cardHolderName) throws InterruptedException {
		PaymentAmount = cardpaymentAmount.getText().replace(",", "");
		manualCardPaymentButton.click();
		Thread.sleep(2000);

		add_Tip(tip);
		
		Thread.sleep(3000);

		driver.switchTo().frame(iframe);
		// PaymentAmount = manualcardpaymentAmount.getText();
		cardNumberMC.sendKeys(cardNumber);
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//li[@class='surchargeRow']//div[@class='infoBox warning']")).isDisplayed()==true){
			surpluspercent=3;
			
		}
//		 driver.findElement(By.xpath("//select[@name='CCMONTH']")).click();
		WebElement expMonth = driver
				.findElement(By.xpath("//select[@name='CCMONTH']/option[contains(text(),'" + cardexpMonth + "')]"));
		expMonth.click();

		// driver.findElement(By.xpath("//select[@name='CCYEAR']")).click();
		WebElement expYear = driver
				.findElement(By.xpath("//select[@name='CCYEAR']/option[contains(text(),'" + cardexpYear + "')]"));
		expYear.click();
		cvvNumberMC.sendKeys(cvv);
		cardHolderNameMC.sendKeys(cardHolderName);
		Thread.sleep(2000);
		payNowButtonMC.click();

		Thread.sleep(5000);

		receiptID = captureReceiptID.getText();
		System.out.println("Order Receipt ID : " + receiptID);

	}
	
	public void verifyTenderPaymentManualCardReceiptDetails_RewardPay(String depositAmount) {

	
		float depositAmt = convertingStringToFloat(depositAmount);
	float	manualcardpayAmount=convertingStringToFloat(String.valueOf((depositAmt*surpluspercent/100) +  depositAmt));
		
		surchargeTotalAmount = convertingStringToFloat(String
				.valueOf(surchargeTotalAmount + ((manualcardpayAmount - depositAmt) / totalCartAmt * totalCartAmt)));
		
		surchargePaidByAmount = convertingStringToFloat(String
				.valueOf(surchargePaidByAmount + ((manualcardpayAmount - depositAmt) / totalCartAmt * depositAmt)));

		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount== subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct having difference of : "
						+ (subtotalamount - subtotalreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float calculatedTotatAmt = convertingStringToFloat(String.valueOf(totalCartAmt + surchargeTotalAmount));
			if (calculatedTotatAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt== discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt - discountreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax  == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by VISA')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByVISAreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByVISAreceiptAmt = convertingStringToFloat(paidByAmt);
			if (manualcardpayAmount == paidByVISAreceiptAmt) {
				System.out.println("Paid by VISA Receipt Amount is Correct: " + paidByVISAreceiptAmt);
			} else {
				System.out
						.println("Paid by VISA Amount is not Correct: " + (manualcardpayAmount - paidByVISAreceiptAmt));
			}
			cardBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - depositAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).size() != 0) {
			String surchargereceiptAmt = driver.findElement(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).getText();
			surchargereceiptAmt = surchargereceiptAmt.substring(1).replace(",", "");
			System.out.println(surchargereceiptAmt);
			float surchargereceiptAmount = convertingStringToFloat(surchargereceiptAmt);
			float surcharge = convertingStringToFloat(
					String.valueOf(surchargeTotalAmount));
			if (surchargereceiptAmount == surcharge) {
				System.out.println("Surcharge Receipt Amount is Correct: " + surchargereceiptAmount);
			} else {
				System.out.println("Surcharge Receipt Amount is not Correct: "
						+ (surcharge-surchargereceiptAmount));
			}
		}
		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}
	
	public void verifyTenderChequeReceiptDetails_RewardPay() throws InterruptedException {
		Thread.sleep(2000);
		// float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");

			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount  - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			if (totalCartAmt + surchargeTotalAmount == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt  - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by Cheque')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByChequereceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			System.out.println(paidByAmt);
			paidByChequereceiptAmt = convertingStringToFloat(paidByAmt);
			if (BalanceCartAmount == paidByChequereceiptAmt) {
				System.out.println("Paid by Cheque Receipt Amount is Correct: " + paidByChequereceiptAmt);
			} else {
				System.out.println("Paid by Cheque Amount is not Correct: ");
			}
			chequeBalanceAmtAfterPartialRefund = paidByChequereceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax  - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1);
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}
		
		if (driver.findElements(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).size() != 0) {
			String surchargereceiptAmt = driver.findElement(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).getText();
			surchargereceiptAmt = surchargereceiptAmt.substring(1).replace(",", "");
			System.out.println(surchargereceiptAmt);
			float surchargereceiptAmount = convertingStringToFloat(surchargereceiptAmt);
			float surcharge = convertingStringToFloat(
					String.valueOf(surchargeTotalAmount + tipAMTmanualCard-tipAmt));
			if (surchargereceiptAmount == surcharge) {
				System.out.println("Surcharge Receipt Amount is Correct: " + surchargereceiptAmount);
			} else {
				System.out.println("Surcharge Receipt Amount is not Correct: "
						+ (surcharge-surchargereceiptAmount));
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		receiptcloseButton.click();

	}
	
	public void verifyTenderPaymentManualCardReceiptDetails_RewardPay() {

		float manualcardpayAmount = convertingStringToFloat(String.valueOf((BalanceCartAmount*surpluspercent/100)+BalanceCartAmount));
		// float depositAmt = convertingStringToFloat(depositAmount);
		
		surchargeTotalAmount = convertingStringToFloat(String.valueOf(
				surchargeTotalAmount + ((manualcardpayAmount - BalanceCartAmount) / totalCartAmt * totalCartAmt)));
		



		tipAmt = convertingStringToFloat(String.valueOf(tipPercent * totalCartAmt / 100));
		tipAMTmanualCard = convertingStringToFloat(String.valueOf(tipAmt + ((tipAmt * surpluspercent) / 100)));

		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct having difference of : "
						+ (subtotalamount  - subtotalreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float totalrecAMT = convertingStringToFloat(
					String.valueOf(totalCartAmt + surchargeTotalAmount + tipAMTmanualCard));
			if (totalrecAMT == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalrecAMT - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt - discountreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax  == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax  - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by VISA')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByVISAreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByVISAreceiptAmt = convertingStringToFloat(paidByAmt);
			float paidByrecAMT = convertingStringToFloat(
					String.valueOf(BalanceCartAmount + (surpluspercent * BalanceCartAmount / 100) + tipAMTmanualCard));
			if (paidByrecAMT == paidByVISAreceiptAmt) {
				System.out.println("Paid by VISA Receipt Amount is Correct: " + paidByVISAreceiptAmt);
			} else {
				System.out
						.println("Paid by VISA Amount is not Correct: " + (paidByrecAMT - paidByVISAreceiptAmt));
			}
			cardBalanceAmtAfterPartialRefund = paidByVISAreceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tip')]/../../td[@class='text-right']")).size() != 0) {
			String tipamount = tipreceiptDetail.getText();
			tipamount = tipamount.substring(1).replace(",", "");
			System.out.println(tipamount);
			tipreceiptAmt = convertingStringToFloat(tipamount);

			System.out.println("Tip Amount in the receipt is: " + tipreceiptAmt);

		}
		
		if (driver.findElements(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).size() != 0) {
			String surchargereceiptAmt = driver.findElement(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).getText();
			surchargereceiptAmt = surchargereceiptAmt.substring(1).replace(",", "");
			System.out.println(surchargereceiptAmt);
			float surchargereceiptAmount = convertingStringToFloat(surchargereceiptAmt);
			float surcharge = convertingStringToFloat(
					String.valueOf(surchargeTotalAmount + tipAMTmanualCard-tipAmt));
			if (surchargereceiptAmount == surcharge) {
				System.out.println("Surcharge Receipt Amount is Correct: " + surchargereceiptAmount);
			} else {
				System.out.println("Surcharge Receipt Amount is not Correct: "
						+ (surcharge-surchargereceiptAmount));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}

	public void verifyTenderChequeReceiptDetails_RewardPay(String tenderAmount) throws InterruptedException {
		Thread.sleep(5000);
		float tenderAmt = convertingStringToFloat(tenderAmount);
		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			;
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: "
						+ (subtotalamount  - subtotalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float calculatedTotalAmt = convertingStringToFloat(String.valueOf(totalCartAmt + surchargeTotalAmount));
			if (calculatedTotalAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt - discountreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by Cheque')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByChequereceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			System.out.println(paidByAmt);
			paidByChequereceiptAmt = convertingStringToFloat(paidByAmt);
			if (tenderAmt == paidByChequereceiptAmt) {
				System.out.println("Paid by Cheque Receipt Amount is Correct: " + tenderAmt);
			} else {
				System.out.println("Paid by Cheque Amount is not Correct: ");
			}
			chequeBalanceAmtAfterPartialRefund = paidByChequereceiptAmt;
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1);
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount - tenderAmt) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).size() != 0) {
			String surchargereceiptAmt = driver.findElement(By.xpath("//b[contains(text(),'Surcharge')]/../../td[@class='text-right']")).getText();
			surchargereceiptAmt = surchargereceiptAmt.substring(1).replace(",", "");
			System.out.println(surchargereceiptAmt);
			float surchargereceiptAmount = convertingStringToFloat(surchargereceiptAmt);
			float surcharge = convertingStringToFloat(
					String.valueOf(surchargeTotalAmount + tipAMTmanualCard-tipAmt));
			if (surchargereceiptAmount == surcharge) {
				System.out.println("Surcharge Receipt Amount is Correct: " + surchargereceiptAmount);
			} else {
				System.out.println("Surcharge Receipt Amount is not Correct: "
						+ (surcharge-surchargereceiptAmount));
			}
		}

		BalanceCartAmount = balancedueAmt;

		driver.switchTo().defaultContent();
		receiptcloseButton.click();

	}
	//Invoices Reward Pay
	public void verifyInvoiceReceiptforCard_RewardPay() {
		
		if (driver.findElements(By.xpath("(//b[text()='SUBTOTAL']/../..//b)[2]")).size() != 0) {
			String SubtotalAmt = driver.findElement(By.xpath("(//b[text()='SUBTOTAL']/../..//b)[2]")).getText();
			SubtotalAmt = SubtotalAmt.replace("$", "").replace(",", "");
			SubtotalAmt = SubtotalAmt.replace(" ", "");
			float subTotalAmt = convertingStringToFloat(SubtotalAmt);
			if (subTotalAmt == convertingStringToFloat(
					String.valueOf(subtotalamount))) {
				System.out.println("Card Subtotal Amount is correct");
			} else {
				System.out.println("Card Subtotal Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[text()='TOTAL']/../..//b)[2]")).size() != 0) {
			String totalAmt = driver.findElement(By.xpath("(//b[text()='TOTAL']/../..//b)[2]")).getText();
			totalAmt = totalAmt.replace("$", "").replace(",", "");
			totalAmt = totalAmt.replace(" ", "");
			float TotalAmt = convertingStringToFloat(totalAmt);
			if (TotalAmt == convertingStringToFloat(
					String.valueOf(totalCartAmt))) {
				System.out.println("Card Total Amount is correct");
			} else {
				System.out.println("Card Total Amount is not correct");
			}
		}
		if (driver.findElements(By.xpath("(//b[contains(text(),'TAX')]/../..//b)[2]")).size() != 0) {
			String taxAmt = driver.findElement(By.xpath("(//b[contains(text(),'TAX')]/../..//b)[2]")).getText();
			taxAmt = taxAmt.replace("$", "").replace(",", "");
			taxAmt = taxAmt.replace(" ", "");
			float TaxAmt = convertingStringToFloat(taxAmt);
			
			if (TaxAmt == cartTax) {
				System.out.println("Card Tax Amount is correct");
			} else {
				System.out.println("Card Tax Amount is not correct" + (TaxAmt - cartTax));
			}
		}
		if (driver.findElements(By.xpath("(//b[contains(text(),'DISCOUNT')]/../..//b)[2]")).size() != 0) {
			String discountAmt = driver.findElement(By.xpath("(//b[contains(text(),'DISCOUNT')]/../..//b)[2]")).getText();
			discountAmt = discountAmt.replace("$", "").replace(",", "");
			discountAmt = discountAmt.replace(" ", "");
			float DiscountAmt = convertingStringToFloat(discountAmt);
			if (DiscountAmt == convertingStringToFloat(
					String.valueOf(cartDiscountAmt))) {
				System.out.println("Card Discount Amount is correct");
			} else {
				System.out.println("Card Discount Amount is not correct");
			}
		}

	}
	
	public void verifyManualCardReceiptDetails_RewardPay() {

		
		float calculatedtotalAmt = convertingStringToFloat(
				String.valueOf((totalCartAmt * surpluspercent) / 100 + totalCartAmt));
		
		float tipAmt = convertingStringToFloat(String.valueOf(tipPercent * totalCartAmt / 100));
		float tipAmount = convertingStringToFloat(String.valueOf(tipAmt + ((tipAmt * surpluspercent) / 100)));
		if (subTotalreceiptDetail.isDisplayed()) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct: " + subtotalreceiptAmt);
			}

		}

		if (totalreceiptDetail.isDisplayed()) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float totalAmt = convertingStringToFloat(String.valueOf(calculatedtotalAmt + tipAmount));
			if (totalAmt == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: " + totalreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: " + discountreceiptAmt);
			}
		}
		if (paidByreceiptDetail.isDisplayed()) {
			String paidByAmt = paidByreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			System.out.println(paidByAmt);
			paidByreceiptAmt = convertingStringToFloat(paidByAmt);
			float paidBytotalAmount = convertingStringToFloat(String.valueOf(calculatedtotalAmt + tipAmount));
			if (paidBytotalAmount == paidByreceiptAmt) {
				System.out.println("Paid by Receipt Amount is Correct: " + paidByreceiptAmt);
			} else {
				System.out.println("Paid by Amount is not Correct: " + paidByreceiptAmt);
			}
		}
		if (taxreceiptDetail.isDisplayed()) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out.println("Tax Receipt Amount is not Correct: " + taxreceiptAmt);
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tip')]/../../td[@class='text-right']")).size() != 0) {
			String tipamount = tipreceiptDetail.getText();
			tipamount = tipamount.substring(1).replace(",", "");
			tipreceiptAmt = convertingStringToFloat(tipamount);
			if (tipAmt == tipreceiptAmt) {
				System.out.println("Tip Amount in the receipt is Correct: " + tipAmount);
			} else {
				System.out.println("Tip Receipt Amount is not Correct: " + tipreceiptAmt);
			}

		}
		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}
	
	public void verifyTenderPaymentACHReceiptDetails_RewardPay() {

	
		
		
		float tipAmt = convertingStringToFloat(String.valueOf(tipPercent * totalCartAmt / 100));
		tipAMTmanualCard = convertingStringToFloat(String.valueOf(tipAmt + ((tipAmt * surpluspercent) / 100)));

		if (driver.findElements(By.xpath("//b[contains(text(),'Subtotal')]/../../td[@class='text-right']"))
				.size() != 0) {
			String manualsubtotalamount = subTotalreceiptDetail.getText();
			manualsubtotalamount = manualsubtotalamount.substring(1).replace(",", "");
			System.out.println(manualsubtotalamount);
			subtotalreceiptAmt = convertingStringToFloat(manualsubtotalamount);
			if (subtotalamount == subtotalreceiptAmt) {
				System.out.println("SubTotal Receipt Amount is Correct: " + subtotalreceiptAmt);
			} else {
				System.out.println("SubTotal Receipt Amount is not Correct having difference of : "
						+ (subtotalamount - subtotalreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Total')]/../../td[@class='text-right']")).size() != 0) {
			String totalamount = totalreceiptDetail.getText();
			totalamount = totalamount.substring(1).replace(",", "");
			System.out.println(totalamount);
			totalreceiptAmt = convertingStringToFloat(totalamount);
			float totalrecAMT = convertingStringToFloat(
					String.valueOf(totalCartAmt + surchargeTotalAmount + tipAMTmanualCard));
			if (totalrecAMT == totalreceiptAmt) {
				System.out.println("Total Receipt Amount is Correct: " + totalreceiptAmt);
			} else {
				System.out.println("Total Receipt Amount is not Correct: "
						+ (totalCartAmt + surchargeTotalAmount - totalreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Discount')]/../../td[@class='text-right']"))
				.size() != 0) {
			String discountamount = discountreceiptDetail.getText();
			discountamount = discountamount.substring(1).replace(",", "");
			;
			System.out.println(discountamount);
			discountreceiptAmt = convertingStringToFloat(discountamount);
			if (cartDiscountAmt == discountreceiptAmt) {
				System.out.println("Discount Receipt Amount is Correct: " + discountreceiptAmt);
			} else {
				System.out.println("Discount Receipt Amount is not Correct: "
						+ (cartDiscountAmt - discountreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Tax')]/../../td[@class='text-right']")).size() != 0) {
			String taxamount = taxreceiptDetail.getText();
			taxamount = taxamount.substring(1).replace(",", "");
			;
			System.out.println(taxamount);
			taxreceiptAmt = convertingStringToFloat(taxamount);
			if (cartTax  == taxreceiptAmt) {
				System.out.println("Tax Receipt Amount is Correct: " + taxreceiptAmt);
			} else {
				System.out
						.println("Tax Receipt Amount is not Correct: " + (cartTax - taxreceiptAmt));
			}
		}
		if (driver.findElements(By.xpath("//b[contains(text(),'Paid by ACH')]/../../td[@class='text-right']"))
				.size() != 0) {
			String paidByAmt = paidByACHreceiptDetail.getText();
			paidByAmt = paidByAmt.substring(1).replace(",", "");
			;
			System.out.println(paidByAmt);
			paidByACHreceiptAmt = convertingStringToFloat(paidByAmt);
			float paidByrecAMT = convertingStringToFloat(
					String.valueOf(BalanceCartAmount));
			if (paidByrecAMT == paidByACHreceiptAmt) {
				System.out.println("Paid by ACH Receipt Amount is Correct: " + paidByACHreceiptAmt);
			} else {
				System.out
						.println("Paid by ACH Amount is not Correct: " + (paidByrecAMT - paidByACHreceiptAmt));
			}
		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Tip')]/../../td[@class='text-right']")).size() != 0) {
			String tipamount = tipreceiptDetail.getText();
			tipamount = tipamount.substring(1).replace(",", "");
			System.out.println(tipamount);
			tipreceiptAmt = convertingStringToFloat(tipamount);

			System.out.println("Tip Amount in the receipt is: " + tipreceiptAmt);

		}

		if (driver.findElements(By.xpath("//b[contains(text(),'Balance Due')]/../../td[@class='text-right']"))
				.size() != 0) {
			String balanceDue = balanceDuereceiptDetail.getText();
			balanceDue = balanceDue.substring(1).replace(",", "");
			;
			System.out.println(balanceDue);
			balancedueAmt = convertingStringToFloat(balanceDue);
			if (balancedueAmt == BalanceCartAmount) {
				System.out.println("Balance Due amount is correct i.e; " + balancedueAmt);
			} else {
				System.out.println("Balance Due amount is not correct: ");
			}
		}

		driver.switchTo().defaultContent();
		cardreceiptcloseButton.click();

	}
	
	public void swipeMethod() {
		driver.findElement(By.xpath("//a[text()=' Swipe/Insert Card ']")).click();
	}

}
