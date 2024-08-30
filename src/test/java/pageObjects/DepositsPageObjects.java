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

public class DepositsPageObjects extends BaseTest {

	WebDriver driver;
	public static Estimate_Page estimatePage;
	public static ChargePageObjects chargePage;
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
	static String headervalue;

	
	
	@FindBy(xpath = "//label[contains(text(),'Total due')]")
	WebElement totalDue_requestDeposit;
	
	@FindBy(xpath = "//label[contains(text(),'Percentage')]")
	WebElement Percentage_requestDeposit;
	
	@FindBy(xpath = "//input[@id='requestDepositAmount']")
	WebElement flatAmount_textField;
	
	@FindBy(xpath = "//input[@id='requestDepositPercent']")
	WebElement percentage_textField;
	
	@FindBy(xpath = "//label[contains(text(),'Flat Amount')]")
	WebElement flatAmount_requestDeposit;
	
	@FindBy(xpath = "//a[@onclick='requestDeposit(this)']")
	WebElement requestDeposit_btn;
	
	@FindBy(xpath = "//a[text()='Cancel ']]")
	WebElement requestDeposit_cancelbtn;
	
	
	
	
	// static String achPaymentAmount;
	WebDriverWait wait;

	public DepositsPageObjects(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		estimatePage = new Estimate_Page(driver);
		chargePage= new ChargePageObjects(driver);
	}
	
	public void requestDeposit_totalAmt() {
		
		totalDue_requestDeposit.click();
		requestDeposit_btn.click();
	}
	
public void requestDeposit_FlatAmt(float flatAmt) {
		
	flatAmount_requestDeposit.click();
	if(flatAmt<=chargePage.totalCartAmt) {
	flatAmount_textField.sendKeys(String.valueOf(flatAmt));
	requestDeposit_btn.click();
	}else {
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		requestDeposit_cancelbtn.click();
	}
	
	}

public void requestDeposit_Percentage(int percent) {
	Percentage_requestDeposit.click();
	if(percent<100) {
		percentage_textField.sendKeys(String.valueOf(percent));
		requestDeposit_btn.click();
	}else {
		System.out.println("Please enter deposit percent less than 100");
		requestDeposit_cancelbtn.click();
	}
	
}

		
	//Deposit Section
	
	public void fetchDataFromDatabase(String header) {
		Customer_Page customerPage= new Customer_Page(driver);
		receiptID=customerPage.receiptId;
		CouchbaseConnection2 cc= new CouchbaseConnection2();
	   headervalue=cc.fetchValueFromdatabase(receiptID, header);
		
		
	}
	
	public void generateUrlString(String date,String PaymentOption) {
		EncryptionUtil encrypt= new EncryptionUtil();
		String datas=encrypt.dataForEncrypt(date,headervalue,PaymentOption);
		System.out.println(datas);
		
		   String encryptedlink=encrypt.encriptData(datas);
		
		String url="https://dev-portal.metispro.com/worldnetpayment/"+encryptedlink;
		System.out.println(url);
	}
}
