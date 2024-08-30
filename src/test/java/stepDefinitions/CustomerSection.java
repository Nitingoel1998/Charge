package stepDefinitions;

import java.awt.AWTException;
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

public class CustomerSection extends BaseTest {

	static ChargePageObjects ChargePage;
	static String scenarioName;
	static Customer_Page customerpageObject;

	@Before
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
		
		
	}

	@And("Click on customer section")
	public void click_CustTab() {
		ChargePage = new ChargePageObjects(driver);
		customerpageObject = new Customer_Page(driver);
		customerpageObject.customerSection();
	}
	

	@And("Navigate to Virtual terminal Section")
	public void virtualTerminalSection() {
		ChargePage = new ChargePageObjects(driver);
		ChargePage.virtualTerminalSection();
	}

	@And("Navigate to Invoices Section")
	public void invoicesSection() {
		customerpageObject.invoicesSection();
	}

	@And("Enter the details like {string} {string} {string} {string} and click on submit button")
	public void enter_CustomerDetail(String firstName, String lastName, String email, String mobileNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		String cust_FirstName = excelReader(scenarioName, firstName);
		String cust_LastName = excelReader(scenarioName, lastName);
		String cust_Email = excelReader(scenarioName, email);
		String cust_MobileNumber = excelReader(scenarioName, mobileNumber);
		customerpageObject.addCustomer(cust_FirstName, cust_LastName, cust_Email, cust_MobileNumber);

	}

	@And("Verify the customer with {string} is diplayed in the list")
	public void verify_CustomerExist(String MobileNumber) throws FileNotFoundException, IOException {
		String cust_MobileNumber = excelReader(scenarioName, MobileNumber);
		customerpageObject.verify_CustomerExist(cust_MobileNumber);
	}

	@And("Click on customer name {string} ,click on edit and enter the {string} and click on save button")
	public void edit_CustomerDetails(String mobNumber, String lastName2) throws FileNotFoundException, IOException {
		String cust_MobileNumber = excelReader(scenarioName, mobNumber);
		String cust_lastName2 = excelReader(scenarioName, lastName2);
		customerpageObject.edit_Customerinfo(cust_MobileNumber, cust_lastName2);

	}

	@And("Click on customer name whose {string}, Click on edit and click on delete button")
	public void deleteCustomer(String mobNumber) throws FileNotFoundException, IOException, InterruptedException {
		String cust_MobileNumber = excelReader(scenarioName, mobNumber);
		customerpageObject.delete_Customerinfo(cust_MobileNumber);
	}

	@And("Select the {string} in Net Term Page")
	public void netTermsDetail(String net_days) throws FileNotFoundException, IOException {
		try {
			String net_Days = excelReader(scenarioName, net_days);
			customerpageObject.netTerms(net_Days);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@And("Select the {string} in Net Term dropdown in create new Invoice Page")
	public void netTermsDetail_Invoice(String net_days) throws FileNotFoundException, IOException {
		try {
			String net_Days = excelReader(scenarioName, net_days);
			customerpageObject.netTerms_Invoice(net_Days);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("Select the customer whose {string} in Search Customer Page")
	public void selectCustomer(String MobileNumber) throws FileNotFoundException, IOException, InterruptedException {

		String mobNumber = excelReader(scenarioName, MobileNumber);
		customerpageObject.search_Customer(mobNumber);
	}

	@And("Search for {string} in invoices page")
	public void searchInvoices(String firstname) throws FileNotFoundException, IOException {
		String firstName = excelReader(scenarioName, firstname);
		customerpageObject.invoiceSearch(firstName);
	}

	@And("Select the {string} and Capture the invoice details shows in the list")
	public void selectInvoiceDropdown(String listStatus)
			throws FileNotFoundException, IOException, InterruptedException {

		String liststatus = excelReader(scenarioName, listStatus);
		customerpageObject.customerinvoiceDetails(liststatus);
	}

	@And("verify the amount in invoice is matched with the cart amount")
	public void verifyInvoiceAmountforCashorACH() {
		ChargePage.verifyInvoiceReceiptforCashorACH();
		ChargePage.verifyInvoiceReceiptforCard();
	}
	
	@And("Click on the actions dropdown and click on edit invoice button")
	public void clickEditInvoice() {
		
		ChargePage.editInvoice();
	}
	
	@And("click on add attachment and select a file from {string}")
	public void addAttachment_Invoice(String filepath) throws FileNotFoundException, IOException, AWTException {
		String filePath = excelReader(scenarioName, filepath);
		ChargePage.addAttachment(filePath);
	}


	@And("Click on Pay Now button from Invoice page")
	public void click_on_PayInvoice_btn() {
		ChargePage = new ChargePageObjects(driver);
		customerpageObject.click_on_PayInvoice_btn();
	}
	
	@And("Click on Request deposit button from Invoice page")
	public void click_on_RequestdepositInvoice_btn() {
		ChargePage = new ChargePageObjects(driver);
		customerpageObject.click_on_RequestDepositInvoice_btn();
	}
	
	@And("verify the invoice status")
	public void invoiceStatus() {
		customerpageObject.verifyStatusOfInvoice();
	}

}