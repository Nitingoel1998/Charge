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

public class ChargeSettingPageObjects extends BaseTest {

	WebDriver driver;
	static ChargePageObjects ChargePage;
	static Customer_Page CustomerPage;

	public ChargeSettingPageObjects(WebDriver Stepsdriver) {
		this.driver = Stepsdriver;
		PageFactory.initElements(driver, this);
		CustomerPage = new Customer_Page(driver);

	}

	@FindBy(xpath = "//a[contains(text(),'Settings')]")
	WebElement settingsSection;

	@FindBy(xpath = "//a[contains(text(),'Store Info')]")
	WebElement storeInfo_tab;

	@FindBy(xpath = "//a[contains(text(),'Custom Field for Invoice')]")
	WebElement customField_tab;

	@FindBy(xpath = "//a[contains(text(),'Discounts')]")
	WebElement discounts_tab;

	@FindBy(xpath = "//a[contains(text(),'Predefined Net Terms')]")
	WebElement netTerms_tab;

	@FindBy(xpath = "//a[contains(text(),'Predefined Tips')]")
	WebElement predefinedTips_tab;

	@FindBy(xpath = "//a[contains(text(),'Tax')]")
	WebElement tax_tab;

	@FindBy(xpath = "//a[contains(text(),'User Defined Payment Method')]")
	WebElement userDefinedPaymentmethod_tab;

	@FindBy(xpath = "//a[contains(text(),'Extra Fields')]")
	WebElement extraFields_tab;

	// Store Info Page

	@FindBy(xpath = "//a[@class='edit_btn']")
	WebElement edit_btn;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTextfield;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2textField;

	@FindBy(xpath = "//button[@id='saveItemBtn']")
	WebElement save_btn;

	// Custom field for invoice section

	@FindBy(xpath = "//input[@key='displayLabel']")
	WebElement displayLabel_textfield;

	@FindBy(xpath = "//input[@key='maxDigits']")
	WebElement maxDigits_textfield;

	@FindBy(xpath = "//input[@id='status_1']/following-sibling::span[@class='checkmark']")
	WebElement status_checkBox;

	@FindBy(xpath = "//input[@id='isRequired_1']/following-sibling::span[@class='checkmark']")
	WebElement required_checkBox;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	WebElement saveCustomfield_btn;
	
	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	WebElement saveExtrafield_btn;
	
	
	@FindBy(xpath = "//a[contains(text(),'Close')]")
	WebElement closeCustomfield_btn;
	
	@FindBy(xpath = "//a[@id='delete_1']")
	WebElement deleteCustomfield_btn;

	@FindBy(xpath = "//button[@id='addRowBtn']")
	WebElement addRow_btn;
	
	@FindBy(xpath = "//a[@onclick='addExtraField()']")
	WebElement addExtraField_btn;
	
	// Discount section

	@FindBy(xpath = "//input[@id='code_1']")
	WebElement discountCode_textfield;

	@FindBy(xpath = "//input[@id='value_1']")
	WebElement discountValue_textfield;

	@FindBy(xpath = "//input[@id='discountLabel_1']")
	WebElement discountlabel_textfield;

	public void editEmail_StoreInfo(String emailId) {
		emailTextfield.clear();
		emailTextfield.sendKeys(emailId);

	}

	public void editAddress2_StoreInfo(String address2) {
		address2textField.clear();
		address2textField.sendKeys(address2);

	}

	public void verifyStoreInfoEdited(String email,String address2) {
		String editedEmail=emailTextfield.getAttribute("value");
		Assert.assertTrue("Updated Email not matched", editedEmail.equalsIgnoreCase(email));
		String editedAddress2=address2textField.getAttribute("value");
		Assert.assertTrue("Updated Address not matched", editedAddress2.equalsIgnoreCase(address2));
		
	}
	
	public void clickOnSaveStoreInfo_btn() {
		save_btn.click();
	}

	public void clickOnEdit_btn() {
		edit_btn.click();
	}
//-------------------------------------	Custom field for invoice section---------------------------

	public void enterCustomFieldforInvoice(String displayLabel, String maxDigit) throws InterruptedException {
		addRow_btn.click();
		Thread.sleep(3000);
		int rowno=driver.findElements(By.xpath("//tbody[@id='tbodyData']/tr")).size();
		if(rowno>=1) {
		driver.findElement(By.xpath("//input[@id='displayLabel_"+(rowno-1)+"']")).sendKeys(displayLabel);
		driver.findElement(By.xpath("//input[@id='maxDigits_"+(rowno-1)+"']")).sendKeys(maxDigit);
		if (driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
			System.out.println("Status Checkbox is selected");
		} else {
			driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
		}
		if (driver.findElement(By.xpath("//input[@id='isRequired_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
			System.out.println("Required Checkbox is selected");
		} else {
			driver.findElement(By.xpath("//input[@id='isRequired_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
		}
		}else {
			driver.findElement(By.xpath("//input[@id='displayLabel_1']")).sendKeys(displayLabel);
			driver.findElement(By.xpath("//input[@id='maxDigits_1']")).sendKeys(maxDigit);
			if (driver.findElement(By.xpath("//input[@id='status_1']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Status Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='status_1']/following-sibling::span[@class='checkmark']")).click();
			}
			if (driver.findElement(By.xpath("//input[@id='isRequired_1']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Required Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='isRequired_1']/following-sibling::span[@class='checkmark']")).click();
			}
		}
		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
		
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
	
	public void create_PredefinedTip(String tipLabel, String tipValue) throws InterruptedException {
		addRow_btn.click();
		Thread.sleep(3000);
		int rowno=driver.findElements(By.xpath("//tbody[@id='tbodyData']/tr")).size();
		if(rowno>=1) {
		driver.findElement(By.xpath("//input[@id='tipLabel_"+(rowno-1)+"']")).sendKeys(tipLabel);
		driver.findElement(By.xpath("//input[@id='value_"+(rowno-1)+"']")).sendKeys(tipValue);
		if (driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
			System.out.println("Status Checkbox is selected");
		} else {
			driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
		}
		
		}else {
			driver.findElement(By.xpath("//input[@id='tipLabel_1']")).sendKeys(tipLabel);
			driver.findElement(By.xpath("//input[@id='value_1']")).sendKeys(tipValue);
			if (driver.findElement(By.xpath("//input[@id='status_1']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Status Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='status_1']/following-sibling::span[@class='checkmark']")).click();
			}
			
		}
		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
		
		Thread.sleep(5000);
		driver.navigate().refresh();
	}

	public void editCustomFieldforInvoice(String displayLabel, String maxDigit) {
		
		driver.findElement(By.xpath("//input[@value='"+displayLabel+"']/../..//input[@Key='maxDigits']")).clear();
		driver.findElement(By.xpath("//input[@value='"+displayLabel+"']/../..//input[@Key='maxDigits']")).sendKeys(maxDigit);
		if (status_checkBox.isSelected()==false) {
			System.out.println("Status Checkbox is selected");
		} else {
			status_checkBox.click();
		}
		if (required_checkBox.isSelected()==false) {
			System.out.println("Required Checkbox is selected");
		} else {
			required_checkBox.click();
		}
//		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
	}
	
public void editPredefinedTip(String tipLabel, String tipValue) {
		
		driver.findElement(By.xpath("//input[@value='"+tipLabel+"']/../..//input[@Key='value']")).clear();
		driver.findElement(By.xpath("//input[@value='"+tipLabel+"']/../..//input[@Key='value']")).sendKeys(tipValue);
		
//		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
	}


	public void createDiscountField(String discountType, String discountCode, String discountValue,
			String discountlabel) throws InterruptedException {
		addRow_btn.click();
		Thread.sleep(3000);
		int rowno=driver.findElements(By.xpath("//tbody[@id='tbodyData']/tr")).size();
		if(rowno>=1) {
			driver.findElement(By.xpath("//select[@id='discountType_"+(rowno-1)+"']//option[contains(text(),'" + discountType + "')]")).click();
			driver.findElement(By.xpath("//input[@id='code_"+(rowno-1)+"']")).sendKeys(discountCode);

			driver.findElement(By.xpath("//input[@id='value_"+(rowno-1)+"']")).sendKeys(discountValue);

			driver.findElement(By.xpath("//input[@id='discountLabel_"+(rowno-1)+"']")).sendKeys(discountlabel);
			if (driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Status Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
			}
			
		}else {
			driver.findElement(By.xpath("//select[@id='discountType_1']//option[contains(text(),'" + discountType + "')]")).click();
			discountCode_textfield.sendKeys(discountCode);

			discountValue_textfield.sendKeys(discountValue);

			discountlabel_textfield.sendKeys(discountlabel);
			if (status_checkBox.isSelected()) {
				System.out.println("Status Checkbox is selected");
			} else {
				status_checkBox.click();
			}
		}
		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	
	
	public void editDiscountField(String discountType, String discountCode, String discountValue,
			String discountlabel) {
		
		driver.findElement(By.xpath("//input[@value='"+discountCode+"']/../..//option[contains(text(),'"+discountType+"')]")).click();
		
		driver.findElement(By.xpath("//input[@value='"+discountCode+"']/../..//input[@key='value']")).clear();
		driver.findElement(By.xpath("//input[@value='"+discountCode+"']/../..//input[@key='value']")).sendKeys(discountValue);
		
		driver.findElement(By.xpath("//input[@value='"+discountCode+"']/../..//input[@key='discountLabel']")).clear();
		driver.findElement(By.xpath("//input[@value='"+discountCode+"']/../..//input[@key='discountLabel']")).sendKeys(discountlabel);
		//input[@value='avc']/../..//input[@key='discountLabel']
		discountlabel_textfield.sendKeys(discountlabel);
		if (status_checkBox.isSelected()) {
			System.out.println("Status Checkbox is selected");
		} else {
			status_checkBox.click();
		}
//		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
	}

	public void deleteDiscountField(String discountCode) {
		driver.findElement(By.xpath("//input[@value='" + discountCode + "']/../..//a")).click();
		driver.switchTo().alert().accept();
		System.out.println("Discount Field deleted Successfully");
	}
	public void deleteCustomField(String displayLabel) {
		driver.findElement(By.xpath("//input[@value='" + displayLabel + "']/../..//a")).click();
		driver.switchTo().alert().accept();
		System.out.println("Custom Field deleted Successfully");
	}
	
	public void deletePredefinedTip(String tipLabel) {
		driver.findElement(By.xpath("//input[@value='" + tipLabel + "']/../..//a")).click();
		driver.switchTo().alert().accept();
		System.out.println(tipLabel+" -Pre defined Tip deleted Successfully");
	}

	public void deletePredefinedNetTermField(String netTermDays) {
		driver.findElement(By.xpath("//input[@value='" + netTermDays + "']/../..//a")).click();
		driver.switchTo().alert().accept();
		System.out.println("PreDefined Net Term Days Field deleted Successfully");
	}
	
	public void navigateSettingsSection() {
		settingsSection.click();
		;
	}

	public void navigateStoreInfo() {
		storeInfo_tab.click();
	}

	public void navigatecustomFieldForInvoice_tab() {
		customField_tab.click();
	}

	public void navigateDiscount_tab() {
		discounts_tab.click();
	}

	public void navigateNetTerms_tab() {
		netTerms_tab.click();
	}

	public void navigatePredefinedTip_tab() {
		predefinedTips_tab.click();
	}

	public void navigateTax_tab() {
		tax_tab.click();
	}

	public void navigateUserdefinedPaymentMethod_tab() {
		userDefinedPaymentmethod_tab.click();
	}

	public void navigateExtrafield_tab() {
		extraFields_tab.click();
	}
	
	public void createPredefinedNetTermField(String netTerm) throws InterruptedException {
		addRow_btn.click();
		Thread.sleep(3000);
		int rowno=driver.findElements(By.xpath("//tbody[@id='tbodyData']/tr")).size();
		if(rowno>=1) {
			driver.findElement(By.xpath("//input[@id='termDays_"+(rowno-1)+"']")).sendKeys(netTerm);

			
			if (driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Status Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
			}
			
		}else {
			
			driver.findElement(By.xpath("//input[@id='termDays_1']")).sendKeys(netTerm);

		
			if (status_checkBox.isSelected()) {
				System.out.println("Status Checkbox is selected");
			} else {
				status_checkBox.click();
			}
		}
		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	public void createUserDefPaymentMethodField(String paymentMethodName) throws InterruptedException {
		addRow_btn.click();
		Thread.sleep(3000);
		int rowno=driver.findElements(By.xpath("//tbody[@id='tbodyData']/tr")).size();
		if(rowno>=1) {
			driver.findElement(By.xpath("//input[@id='name_"+(rowno-1)+"']")).sendKeys(paymentMethodName);

			
			if (driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Status Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
			}
			
		}else {
			
			driver.findElement(By.xpath("//input[@id='name_1']")).sendKeys(paymentMethodName);

		
			if (status_checkBox.isSelected()) {
				System.out.println("Status Checkbox is selected");
			} else {
				status_checkBox.click();
			}
		}
		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	public void editUserDefinedPaymentmethod(String paymentmethod,String paymentMethod2) {
		
		driver.findElement(By.xpath("//input[@value='"+paymentmethod+"']")).clear();
		driver.findElement(By.xpath("//input[@value='"+paymentmethod+"']")).sendKeys(paymentMethod2);
		closeCustomfield_btn.click();
	}
	
	public void deleteUserDefinedPaymentmethod(String paymentmethod) {
		driver.findElement(By.xpath("//input[@value='" + paymentmethod + "']/../..//a")).click();
		driver.switchTo().alert().accept();
		System.out.println(paymentmethod+" -user defined payment method Field deleted Successfully");
	}
	
	
	
	public void editPredefinedNetDays(String netdays,String netDays2) {
		driver.findElement(By.xpath("//input[@value='"+netdays+"']")).clear();
		driver.findElement(By.xpath("//input[@value='"+netdays+"']")).sendKeys(netDays2);
		closeCustomfield_btn.click();
	}
	
	public void createTaxField(String taxClassName, String taxRate) throws InterruptedException {
		addRow_btn.click();
		Thread.sleep(3000);
		int rowno=driver.findElements(By.xpath("//tbody[@id='tbodyData']/tr")).size();
		if(rowno>=1) {
			
			driver.findElement(By.xpath("//input[@id='taxClassName_"+(rowno-1)+"']")).sendKeys(taxClassName);

			driver.findElement(By.xpath("//input[@id='taxValue_"+(rowno-1)+"']")).sendKeys(taxRate);

			
			if (driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).isSelected()==false) {
				System.out.println("Status Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@id='status_"+(rowno-1)+"']/following-sibling::span[@class='checkmark']")).click();
			}
			
		}else {
			driver.findElement(By.xpath("//input[@id='taxClassName_1']")).sendKeys(taxClassName);

			driver.findElement(By.xpath("//input[@id='taxValue_1']")).sendKeys(taxRate);

			if (status_checkBox.isSelected()) {
				System.out.println("Status Checkbox is selected");
			} else {
				status_checkBox.click();
			}
		}
		saveCustomfield_btn.click();
		closeCustomfield_btn.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	public void editTaxField(String taxClassName, String newtaxRate) {
		driver.findElement(By.xpath("//input[@value='"+taxClassName+"']/../..//input[@key='taxValue']")).clear();
		driver.findElement(By.xpath("//input[@value='"+taxClassName+"']/../..//input[@key='taxValue']")).sendKeys(newtaxRate);
		closeCustomfield_btn.click();
	}
	
	public void selectTaxToDefault(String taxClassName) {
		driver.findElement(By.xpath("//input[@value='"+taxClassName+"']/../..//input[@key='isDefault']")).click();	
		closeCustomfield_btn.click();
		System.out.println(taxClassName+" is assigned to Default");
	}
	
	public void selectUserDefPaymentmethodAsfavorite(String paymentmethod) {
		if(driver.findElement(By.xpath("//input[@value='"+paymentmethod+"']/../..//input[@key='isFavourite']/following-sibling::span")).isSelected()==false) {
		driver.findElement(By.xpath("//input[@value='"+paymentmethod+"']/../..//input[@key='isFavourite']/following-sibling::span")).click();	
		}else {
			System.out.println("favourite CheckBox is Already Selected for - "+paymentmethod);
		}
		closeCustomfield_btn.click();
		System.out.println(paymentmethod+" -User Defined payment method is set as favourite ");
	}
	
	public void selectCustomTip(String tipLabel) {
		if(driver.findElement(By.xpath("//input[@value='"+tipLabel+"']/../..//input[@key='isCustom']/following-sibling::span")).isSelected()==false) {
		driver.findElement(By.xpath("//input[@value='"+tipLabel+"']/../..//input[@key='isCustom']/following-sibling::span")).click();	
		}else {
			System.out.println("Custom Tip CheckBox is Already Selected for- "+tipLabel);
		}
		closeCustomfield_btn.click();
		
	}
	
	public void deselectUserDefPaymentmethodAsfavorite(String paymentmethod) {
		if(driver.findElement(By.xpath("//input[@value='"+paymentmethod+"']/../..//input[@key='isFavourite']/following-sibling::span")).isSelected()==false) {
		driver.findElement(By.xpath("//input[@value='"+paymentmethod+"']/../..//input[@key='isFavourite']/following-sibling::span")).click();	
		}else {
			System.out.println("favourite CheckBox is Already DeSelected for -"+paymentmethod);
		}
		closeCustomfield_btn.click();
		System.out.println(paymentmethod+" -User Defined payment method is set as favourite ");
	}
	
	public void deleteTaxField(String taxClassName) {
		driver.findElement(By.xpath("//input[@value='" + taxClassName + "']/../..//a")).click();
		driver.switchTo().alert().accept();
		System.out.println("Tax Field deleted Successfully");
	}
	
	public void createExtraField(String paymentMethod, String displayLabel, String fieldName, String maxDigit)
			throws InterruptedException {
		driver.findElement(By.xpath("//select[@id='paymentMethod']/option[contains(text(),'" + paymentMethod + "')]"))
				.click();
		addExtraField_btn.click();

		Thread.sleep(3000);

		int rowno = driver.findElements(By.xpath("//tbody[@id='extrafieldsclassbody']/tr")).size();
		if (rowno >= 1) {
			driver.findElement(By.xpath("//input[@id='displayLabel" + (rowno - 1) + "']")).sendKeys(displayLabel);

			driver.findElement(By.xpath("//input[@id='fieldName" + (rowno - 1) + "']")).sendKeys(fieldName);
			driver.findElement(By.xpath("//input[@id='maxDigits" + (rowno - 1) + "']")).sendKeys(maxDigit);

			if (driver.findElement(By.xpath(
					"//input[@name='isRequired" + (rowno - 1) + "']/following-sibling::span[@class='checkmark']"))
					.isSelected() == true) {
				System.out.println("Required Checkbox is selected");
			} else {
				driver.findElement(By.xpath(
						"//input[@name='isRequired" + (rowno - 1) + "']/following-sibling::span[@class='checkmark']"))
						.click();
			}

		} else {

			driver.findElement(By.xpath("//input[@id='displayLabel0']")).sendKeys(displayLabel);

			driver.findElement(By.xpath("//input[@id='fieldName0']")).sendKeys(fieldName);
			driver.findElement(By.xpath("//input[@id='maxDigits0']")).sendKeys(maxDigit);

			if (driver.findElement(By.xpath("//input[@name='isRequired0']/following-sibling::span[@class='checkmark']"))
					.isSelected() == true) {
				System.out.println("Required Checkbox is selected");
			} else {
				driver.findElement(By.xpath("//input[@name='isRequired0']/following-sibling::span[@class='checkmark']"))
						.click();
			}
		}
		saveExtrafield_btn.click();

		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	public void deleteExtraField(String paymentmethod,String displayLabel) throws InterruptedException {
		driver.findElement(By.xpath("//select[@id='paymentMethod']/option[contains(text(),'" + paymentmethod + "')]"))
		.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='" + displayLabel + "']/../..//a")).click();
    	driver.switchTo().alert().accept();
		System.out.println(displayLabel+" -Extra Field deleted Successfully");
	}
	
	public void editExtraFields(String paymentmethod,String displayLabel,String fieldName) throws InterruptedException {
		driver.findElement(By.xpath("//select[@id='paymentMethod']/option[contains(text(),'" + paymentmethod + "')]"))
		.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='"+displayLabel+"']/../..//input)[2]")).clear();
		driver.findElement(By.xpath("(//input[@value='"+displayLabel+"']/../..//input)[2]")).sendKeys(fieldName);
		saveExtrafield_btn.click();

		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
}
