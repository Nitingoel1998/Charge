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

public class UsersPageObject extends BaseTest {

	WebDriver driver;
	static ChargePageObjects ChargePage;
	static Customer_Page CustomerPage;
	static String estimate_receiptID;
	WebDriverWait wait;
   
    
    
    
    
	public UsersPageObject(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		CustomerPage= new Customer_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	}
// Users Section
	
	@FindBy(xpath = "//label[contains(text(),'App Access')]")
	WebElement appAccess_Checkbox;
	
	@FindBy(xpath = "//label[contains(text(),'Web Access')]")
	WebElement webAccess_Checkbox;
	
	@FindBy(xpath = "//a[text()=' Add New User']")
	WebElement createNewUser;
	
	@FindBy(xpath = "//a[text()='Users']")
	WebElement userSection;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement user_firstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement user_lastName;
	
	@FindBy(xpath = "//input[@id='email1']")
	WebElement user_email;
	
	@FindBy(xpath = "//input[@id='cellPhone']")
	WebElement user_CellPhone;
	
	//Edit page
	@FindBy(xpath = "//input[@id='mobilePhone']")
	WebElement user_MobilePhone;
	//---------------------------
	
	@FindBy(xpath = "//a[@id='saveUserBtn']")
	WebElement user_SaveBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement user_cancelBtn;
	
	@FindBy(xpath = "//a[@id='updateUserBtn']")
	WebElement user_UpdateBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	WebElement user_DeleteBtn;
	
	@FindBy(xpath = "//a[@id='privilege-tab']")
	WebElement privilege_Tab;
	
	@FindBy(xpath = "//a[@id='savePrivilegeBtn']")
	WebElement savePrivilege;
	
	
	public void user_Section() {
		
		userSection.click();
	}
	
	public void createUser(String firstName,String lastName,String email,String MobileNo,String Access)throws InterruptedException {
	
		createNewUser.click();
		user_firstName.sendKeys(firstName);
		user_lastName.sendKeys(lastName);
		user_email.sendKeys(email);
		user_CellPhone.sendKeys(MobileNo);
		driver.findElement(By.xpath("//label[contains(text(),'"+Access+"')]")).click();
		user_SaveBtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	public void verify_user(String email) {
		
		if(driver.findElements(By.xpath("//td[contains(text(),'"+email+"')]/..//a")).size()!=0) {
			System.out.println("User exist in the user List");
			}else {
				System.out.println("User does not exist");
			}
	}
	
	public void clickUser(String email) {
		
		if(driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]/..//a")).isDisplayed()) {
		driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]/..//a")).click();
		}else {
			System.out.println("User does not exist");
		}
	}
	
	public void navigate_PrivilegeTab() {
		privilege_Tab.click();
	}
	
	
	public void SaveButton() {
		user_UpdateBtn.click();
	}
	
	public void addPrivilege(String privilege) throws InterruptedException{
		
	 String priv[]= privilege.split(",");
	 
		for (int i = 0; i < priv.length; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'" + priv[i] + "')]")).click();

		}
	
     Actions a= new Actions(driver);
     a.moveToElement(savePrivilege).build().perform();
    
	 savePrivilege.click();
	 
	}
	
	public void clickOnDelete()throws InterruptedException {
		user_DeleteBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	public void edit_detail(String header,String headerValue) {
		
		if(header.contains("First_Name2")) {
			user_firstName.clear();
			user_firstName.sendKeys(headerValue);
		}
		else if(header.contains("Last_Name2")) {
			user_lastName.clear();
			user_lastName.sendKeys(headerValue);
		}
		else if(header.contains("Mobile_Number2")) {
			user_MobilePhone.clear();
			user_MobilePhone.sendKeys(headerValue);
		}else if(header.contains("Access2")) {
			driver.findElement(By.xpath("//label[contains(text(),'"+headerValue+"')]")).click();
		}
	}
	
	public void updateButton() {
		user_UpdateBtn.click();
	}
	
}
	
	
	
	