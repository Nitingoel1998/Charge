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

public class Customer_Page extends BaseTest {

	WebDriver driver;
	static ChargePageObjects ChargePage;
	// static String achPaymentAmount;
	WebDriverWait wait;
    String receiptid=ChargePage.receiptID;
    static String customer_First_Name;
    static String customer_Last_Name;
    static String customer_Email;
    static String customer_MobileNumber;
    static String receiptId;
    
    
    
	public Customer_Page(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
// Transaction History
	@FindBy(xpath = "//a[contains(text(),'Transaction History')]")
	WebElement transactionHistory_tab;
	
	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement customerSection;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement cust_lastName;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement cust_firstName;
	
	@FindBy(xpath = "//input[@id='email1']")
	WebElement cust_emailAddress;
	
	@FindBy(xpath = "//input[@id='email2']")
	WebElement cust_alternate_EmailAddress;


	@FindBy(xpath = "//input[@id='mobilePhone']")
	WebElement cust_MobileNumber;

	@FindBy(xpath = "//a[@id='addCustomerBtn']")
	WebElement cust_addButton;
	
	@FindBy(xpath = "//div[@class='btn-group']//button")
	WebElement cust_editButton;
	
	@FindBy(xpath = "//span[contains(text(),'Edit Customer')]")
	WebElement editCustPage;
	
	@FindBy(xpath = "//input[@id='workPhone']")
	WebElement cust_workPhone;
	
	@FindBy(xpath = "//a[@id='custBtn']")
	WebElement cust_edit_Savebtn;
	
	@FindBy(xpath = "//a[@class='delete__pro deleteCustomerBtn']")
	WebElement cust_deleteBtn;
	
	//Net terms
	
	@FindBy(xpath = "//*[contains(text(),'Net Term')]/../following-sibling::div//a[contains(text(),'Send')]")
	WebElement ok_Button;
	
	//Search Customer Page
	
	
	@FindBy(xpath = "//input[@placeholder='Customer Name or Phone']")
	WebElement search_CustTextfield;
	
	//Invoice Page objects
	
	@FindBy(xpath = "//a[text()='Invoices']")
	WebElement invoiceSection;
	
	@FindBy(xpath = "//input[@id='searchOrder']")
	WebElement searchorderButton;
	

	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	WebElement dropdownMenu_invoice;
	

	@FindBy(xpath = "(//div[@id='orderListTable']//a)[1]")
	WebElement firstOrderDetail;
	

	@FindBy(xpath = "(//div[@id='orderListTable']//a)[1]/span/span[@class='text-blue']")
	WebElement capture_receiptID;
	

	@FindBy(xpath = "(//div[@id='orderListTable']//a)[1]/span[2]/span")
	WebElement orderStatus;
	
	@FindBy(xpath = "//b[contains(text(),'PAY INVOICE')]	")
	WebElement payInvoice_btn;
	
	@FindBy(xpath = "//b[contains(text(),'REQUEST DEPOSIT')]")
	WebElement requestDeposit_btn;
	
	
	
	public void navigate_TransactionHistorytab() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(driver.findElement(transactionHistory_tab)));
		transactionHistory_tab.click();
	}
	
	public void customerSection() {
		customerSection.click();
	}
	
	public void invoicesSection() {
		invoiceSection.click();
	}
	
	public void addCustomer(String firstName,String lastName,String email,String mobileNum) throws InterruptedException {
		customer_First_Name= firstName;
		customer_Last_Name= lastName;
		customer_Email= email;
		customer_MobileNumber= mobileNum;
		
		cust_firstName.sendKeys(firstName);
		cust_lastName.sendKeys(lastName);
		cust_emailAddress.sendKeys(email);
		cust_MobileNumber.sendKeys(mobileNum);
		Thread.sleep(2000);
		cust_addButton.click();
	
	}
	public String mobileNumber_Format(String mobNumber) {
		String first3digit= mobNumber.substring(0, 3);
		String middle3digit= mobNumber.substring(3, 6);
		String last4digit= mobNumber.substring(6,10);
		String mobileNumber= String.format("(%s) %s-%s", first3digit,middle3digit,last4digit);
		return mobileNumber;
	}
	
	public void verify_CustomerExist(String mobileNumber) {
		String mobNumber= mobileNumber_Format(mobileNumber);
		
		if(driver.findElements(By.xpath("//td[contains(text(),'"+mobNumber+"')]")).size()!=0) {
			
			String capturefirstname=driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]/..//th/a/span")).getText();
		if(capturefirstname.equalsIgnoreCase(customer_First_Name)) {
			System.out.println("Customer is added successfully");
		}
		}else  {
			System.out.println("Customer does not exist :");
		}
		
	}
	
	public void click_on_Customer(String mobileNumber) {
		String mobNumber= mobileNumber_Format(mobileNumber);
		if(driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]")).isDisplayed()) {
			driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]/..//th/a/span")).click();
		}else {
			System.out.println("Customer not found with the given Mobile Number ");
		}
	}
	
	public void edit_Customerinfo(String mobileNumber,String lastname2) {
		
		String mobNumber= mobileNumber_Format(mobileNumber);
		if(driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]")).isDisplayed()) {
			driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]/..//th/a/span")).click();
			cust_editButton.click();
			Assert.assertTrue("Edit Customer page is displayed", editCustPage.isDisplayed());
			cust_lastName.clear();
			cust_lastName.sendKeys(lastname2);
			cust_edit_Savebtn.click();
			System.out.println("Customer is edited successfully");
			
		}else {
			System.out.println("Customer not found with the given emailID ");
		}
		
	}
	
	public void delete_Customerinfo(String mobileNumber) throws InterruptedException {
		String mobNumber= mobileNumber_Format(mobileNumber);
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]")).isDisplayed()) {
			driver.findElement(By.xpath("//td[contains(text(),'"+mobNumber+"')]/..//th/a/span")).click();
			cust_editButton.click();
			Thread.sleep(2000);
			Assert.assertTrue("Edit Customer page is displayed", editCustPage.isDisplayed());
			
			cust_deleteBtn.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
		}else {
			System.out.println("Customer not found with the given emailID ");
		}
		
	}
	
public void netTerms(String terms) throws InterruptedException {
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//select[@id='netTerm']/option[contains(text(),'"+terms+"')]")).isDisplayed())
		{
		
			driver.findElement(By.xpath("//select[@id='netTerm']/option[contains(text(),'"+terms+"')]")).click();
			ok_Button.click();
		}else {
			System.out.println(terms +" Option not found: ");
			
		}
	
	}

public void netTerms_Invoice(String terms) throws InterruptedException {
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//select[@id='netTerm']/option[contains(text(),'"+terms+"')]")).isDisplayed())
	{
	
		driver.findElement(By.xpath("//select[@id='netTerm']/option[contains(text(),'"+terms+"')]")).click();
	}else {
		System.out.println(terms +" Option not found: ");
		
	}

}
	
public void search_Customer(String mobileNumber) throws InterruptedException {
	
	search_CustTextfield.sendKeys(mobileNumber);
	String mobNumber= mobileNumber_Format(mobileNumber);
	Thread.sleep(3000);
	if(driver.findElements(By.xpath("//span[contains(text(),'"+mobNumber+"')]")).size()!=0) {
	driver.findElement(By.xpath("//span[contains(text(),'"+mobNumber+"')]")).click();
	//assertTrue("Invoice sent successfully",true);
	}
}

public void invoiceSearch(String firstName) {
	searchorderButton.sendKeys(firstName);
}
public void customerinvoiceDetails(String listInfo) throws InterruptedException {
	
	

	dropdownMenu_invoice.click();
	if(listInfo.equalsIgnoreCase("Pending")) {
	driver.findElement(By.xpath("//button[@id='dropdownMenuButton']/../div/a[contains(text(),'"+listInfo+"')]")).click();
	Thread.sleep(2000);
	receiptId=capture_receiptID.getText();
	System.out.println(receiptId);
	Thread.sleep(2000);
	firstOrderDetail.click();
	String captureOrderStatus=orderStatus.getText();
	System.out.println("Order Status is :"+captureOrderStatus);
	}
	if(listInfo.equalsIgnoreCase("Paid")) {
		String status=driver.findElement(By.xpath("//span[contains(text(),'"+receiptId+"')]/../../span[2]/span")).getText();
	    if(listInfo.contains(status)) {
	    	System.out.println("Status of the invoice is : "+status);
	    }else {
	    	System.out.println("Status of the invoice is not matched: "+status);
	    }
	}
}

public void verifyStatusOfInvoice() {
	if(driver.findElements(By.xpath("//span[contains(text(),'"+receiptId+"')]/../../span[2]/span")).size()!=0) {
	String status=driver.findElement(By.xpath("//span[contains(text(),'"+receiptId+"')]/../../span[2]/span")).getText();
		System.out.println("Status of the invoice is : "+status);
	}
	if(driver.findElements(By.xpath("//span[contains(text(),'"+receiptId+"')]/../../span[2]/span[2]")).size()!=0) {
		String status=driver.findElement(By.xpath("//span[contains(text(),'"+receiptId+"')]/../../span[2]/span[2]")).getText();
		System.out.println("Status of the invoice is : "+status);
	}
}

public void click_on_PayInvoice_btn() {
	payInvoice_btn.click();
}

public void click_on_RequestDepositInvoice_btn() {
	requestDeposit_btn.click();
}
	
}
	
	
	
	