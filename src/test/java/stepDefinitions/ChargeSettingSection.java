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
import pageObjects.*;


public class ChargeSettingSection extends BaseTest {

	static ChargePageObjects ChargePage;
	static String scenarioName;
	static ChargeSettingPageObjects settingPage;

	@Before
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
		
		
	}

	@And("Navigate to Setting Section")
	public void navigateSettingSection() {
		settingPage= new ChargeSettingPageObjects(driver);
		settingPage.navigateSettingsSection();
	}

	@And("Navigate to Store Info tab")
	public void navigateStoreInfo() {
		settingPage.navigateStoreInfo();
	}
	
	@And("Navigate to Custom Field for Invoice tab under Setup")
	public void navigateCustomFieldForInvoice() {
		settingPage.navigatecustomFieldForInvoice_tab();
	}
	
	@And("Navigate to Discount tab under Setup")
	public void navigateDiscounttab() {
		settingPage.navigateDiscount_tab();
	}
	
	@And("Navigate to User defined Payment Method Section")
	public void navigateUserDefinedPaymentMethodtab() {
		settingPage.navigateUserdefinedPaymentMethod_tab();
	}
	
	@And("Navigate to Extra Fields Section under Setting")
	public void navigateExtraFieldtab() {
		settingPage.navigateExtrafield_tab();
	}
	
	@And("Navigate to Tax Section")
	public void navigateTax_tab() {
		settingPage.navigateTax_tab();
	}
	
	@And("Navigate to Pre defined Tips tab under Setup")
	public void navigatePredefinedTip_tab() {
		settingPage.navigatePredefinedTip_tab();
	}
	
	@And("Navigate to PreDefined Net Terms tab under Setup")
	public void navigatePredefinedNetTerm_tab() {
		settingPage.navigateNetTerms_tab();
	}
	
	@And("Create Custom field for invoice and enter {string},{string}")
	public void create_customFieldForInvoice(String displayLabel,String maxdigit) throws FileNotFoundException, IOException, InterruptedException {
		String displaylabel=excelReader(scenarioName,displayLabel);
		String maxDigit=excelReader(scenarioName,maxdigit);
		settingPage.clickOnEdit_btn();
		settingPage.enterCustomFieldforInvoice(displaylabel,maxDigit);
		
	}
	
	@And("Create Pre defined tips and enter {string},{string}")
	public void create_predefinedTip(String Tip_Label,String Tip_Value) throws FileNotFoundException, IOException, InterruptedException {
		String tiplabel=excelReader(scenarioName,Tip_Label);
		String tipValue=excelReader(scenarioName,Tip_Value);
		settingPage.clickOnEdit_btn();
		settingPage.create_PredefinedTip(tiplabel, tipValue);
		
	}
	
	@And("Edit Pre defined tips and enter {string},{string}")
	public void edit_predefinedTip(String Tip_Label,String Tip_Value) throws FileNotFoundException, IOException, InterruptedException {
		String tiplabel=excelReader(scenarioName,Tip_Label);
		String tipValue=excelReader(scenarioName,Tip_Value);
		settingPage.clickOnEdit_btn();
		settingPage.editPredefinedTip(tiplabel, tipValue);
		
	}
	
	@And("Create tax Field and enter the details like {string} and {string}")
	public void create_TaxField(String TaxClass_Name,String Tax_Rate) throws FileNotFoundException, IOException, InterruptedException {
		String taxClassName=excelReader(scenarioName,TaxClass_Name);
		String taxRate=excelReader(scenarioName,Tax_Rate);
		settingPage.clickOnEdit_btn();
		settingPage.createTaxField(taxClassName, taxRate);
		
	}
	
	@And("Create pre defined discount and enter {string},{string},{string} and {string}")
	public void create_PredefinedDiscount(String discountType, String discountCode, String discountValue,String discountlabel) throws FileNotFoundException, IOException, InterruptedException {
		String discounttype=excelReader(scenarioName,discountType);
		String discountcode=excelReader(scenarioName,discountCode);
		String discountvalue=excelReader(scenarioName,discountValue);
		String discountLabel=excelReader(scenarioName,discountlabel);
		settingPage.clickOnEdit_btn();
		settingPage.createDiscountField(discounttype, discountcode, discountvalue, discountLabel);
		
	}
	
	@And("Create pre defined Net Terms and enter {string}")
	public void create_PredefinedNetTerms(String netTermInDays) throws FileNotFoundException, IOException, InterruptedException {
		String netTerm=excelReader(scenarioName,netTermInDays);
		settingPage.clickOnEdit_btn();
		settingPage.createPredefinedNetTermField(netTerm);
	}
	
	@And("Create User defined payment Method and enter the details like {string}")
	public void create_UserdefinedPaymentMethod(String Payment_Method_Name) throws FileNotFoundException, IOException, InterruptedException {
		String paymentMethod=excelReader(scenarioName,Payment_Method_Name);
		settingPage.clickOnEdit_btn();
		settingPage.createUserDefPaymentMethodField(paymentMethod);
	}
	
	@And("Create Extra field ,Select {string} dropdown and enter the row details like {string} {string} {string}")
	public void create_ExtraFields(String Payment_Method_Name,String Display_Label,String Field_Name,String Max_Digit) throws FileNotFoundException, IOException, InterruptedException {
		String paymentMethod=excelReader(scenarioName,Payment_Method_Name);
		String displayLabel=excelReader(scenarioName,Display_Label);
		String fieldName=excelReader(scenarioName,Field_Name);
		String maxDigit=excelReader(scenarioName,Max_Digit);
		settingPage.clickOnEdit_btn();
		Thread.sleep(3000);
		settingPage.createExtraField(paymentMethod, displayLabel, fieldName, maxDigit);
	}
	
	@And("Delete Predefined Discount whose {string}")
	public void delete_predefinedDiscount(String discountCode) throws FileNotFoundException, IOException {
		String discountcode=excelReader(scenarioName,discountCode);
		
		settingPage.clickOnEdit_btn();
		settingPage.deleteDiscountField(discountcode);
		
	}
	
	@And("Delete Pre defined tips whose {string}")
	public void delete_predefinedTip(String tipLabel) throws FileNotFoundException, IOException {
		String tiplabel=excelReader(scenarioName,tipLabel);
		
		settingPage.clickOnEdit_btn();
		settingPage.deletePredefinedTip(tiplabel);
		
	}
	
	@And("Select Custom Tip for Pre defined tips whose {string}")
	public void selectCustomTip_predefinedTip(String tipLabel) throws FileNotFoundException, IOException {
		String tiplabel=excelReader(scenarioName,tipLabel);
		
		settingPage.clickOnEdit_btn();
		settingPage.selectCustomTip(tiplabel);
		
	}
	
	@And("Delete the Pre defined Net Terms days whose {string}")
	public void delete_predefinedNetTerm(String netTermDays) throws FileNotFoundException, IOException {
		String netDays=excelReader(scenarioName,netTermDays);
		
		settingPage.clickOnEdit_btn();
		settingPage.deletePredefinedNetTermField(netDays);
		
	}
	
	@And("Delete the User Defined Payment method field whose {string}")
	public void delete_userdefinedPaymentMethod(String Payment_Method_Name) throws FileNotFoundException, IOException {
		String paymentMethod=excelReader(scenarioName,Payment_Method_Name);
		
		settingPage.clickOnEdit_btn();
		settingPage.deleteUserDefinedPaymentmethod(paymentMethod);
		
	}
	
	@And("Delete the Extra field whose {string} and {string}")
	public void delete_ExtraField(String Payment_Method_Name,String Display_Label) throws FileNotFoundException, IOException, InterruptedException {
		String paymentMethod=excelReader(scenarioName,Payment_Method_Name);
		String displayLabel=excelReader(scenarioName,Display_Label);
		settingPage.clickOnEdit_btn();
		settingPage.deleteExtraField(paymentMethod,displayLabel);
		
	}
	
	@And("Delete the Tax field whose {string}")
	public void delete_TaxField(String TaxClass_Name) throws FileNotFoundException, IOException {
		String taxClassName=excelReader(scenarioName,TaxClass_Name);
		
		settingPage.clickOnEdit_btn();
		settingPage.deleteTaxField(taxClassName);
	}
	
	@And("Delete Custom field for invoice whose {string}")
	public void delete_customFieldForInvoice(String displayLabel) throws FileNotFoundException, IOException {
		String displaylabel=excelReader(scenarioName,displayLabel);
		
		settingPage.clickOnEdit_btn();
		settingPage.deleteCustomField(displaylabel);
		
	}
	
	@And("Edit Custom field for invoice and enter {string},{string}")
	public void edit_customFieldForInvoice(String displayLabel,String maxdigit2) throws FileNotFoundException, IOException {
		String displaylabel=excelReader(scenarioName,displayLabel);
		String maxDigit2=excelReader(scenarioName,maxdigit2);
		settingPage.clickOnEdit_btn();
		settingPage.editCustomFieldforInvoice(displaylabel,maxDigit2);
		
	}
	
	@And("Edit the Tax Field whose {string} and enter detail {string}")
	public void edit_TaxField(String TaxClass_Name,String Tax_Rate2) throws FileNotFoundException, IOException {
		String taxClass=excelReader(scenarioName,TaxClass_Name);
		String taxrate2=excelReader(scenarioName,Tax_Rate2);
		settingPage.clickOnEdit_btn();
		settingPage.editTaxField(taxClass, taxrate2);
		
	}
	
	@And("Assign the {string} as Default tax")
	public void assignDefaultTax(String TaxClass_Name) throws FileNotFoundException, IOException {
		String taxClass=excelReader(scenarioName,TaxClass_Name);
		settingPage.clickOnEdit_btn();
		settingPage.selectTaxToDefault(taxClass);
		
	}
	
	@And("Select user defined payment Method whose {string} as favourite")
	public void selectPaymentMethodAsFavourite(String Payment_Method_Name) throws FileNotFoundException, IOException {
		String payMethod=excelReader(scenarioName,Payment_Method_Name);
		settingPage.clickOnEdit_btn();
		settingPage.selectUserDefPaymentmethodAsfavorite(payMethod);
		
	}
	
	@And("DeSelect user defined payment Method whose {string} as favourite")
	public void deselectPaymentMethodAsFavourite(String Payment_Method_Name) throws FileNotFoundException, IOException {
		String payMethod=excelReader(scenarioName,Payment_Method_Name);
		settingPage.clickOnEdit_btn();
		settingPage.deselectUserDefPaymentmethodAsfavorite(payMethod);
		
	}
	
	@And("Edit predefined Discounts {string},{string},{string} and {string}")
	public void edit_PredefinedDiscount(String discountType, String discountCode, String discountValue,String discountlabel) throws FileNotFoundException, IOException {
		String discounttype=excelReader(scenarioName,discountType);
		String discountcode=excelReader(scenarioName,discountCode);
		String discountvalue=excelReader(scenarioName,discountValue);
		String discountLabel=excelReader(scenarioName,discountlabel);
		settingPage.clickOnEdit_btn();
		settingPage.editDiscountField(discounttype, discountcode, discountvalue, discountLabel);
		
	}
	
	@And("Edit the Pre defined Net Terms days from {string} to {string}")
	public void edit_PredefinedNetterms(String NetTermDays,String NetTermDays2) throws FileNotFoundException, IOException {
		String netTermDays=excelReader(scenarioName,NetTermDays);
		String netTermDays2=excelReader(scenarioName,NetTermDays2);
		settingPage.clickOnEdit_btn();
		settingPage.editPredefinedNetDays(netTermDays,netTermDays2);
	}
	
	@And("Edit the User defined payment Method from {string} to {string}")
	public void edit_UserdefinedPaymentMethod(String Payment_Method_Name,String Payment_Method_Name2) throws FileNotFoundException, IOException {
		String paymentMethod=excelReader(scenarioName,Payment_Method_Name);
		String paymentMethod2=excelReader(scenarioName,Payment_Method_Name2);
		settingPage.clickOnEdit_btn();
		settingPage.editUserDefinedPaymentmethod(paymentMethod, paymentMethod2);
	}
	
	@And("Edit the Extra field whose {string} and {string} like {string}")
	public void edit_ExtraField(String Payment_Method_Name,String Display_Label,String Field_Name2) throws FileNotFoundException, IOException, InterruptedException {
		String paymentMethod=excelReader(scenarioName,Payment_Method_Name);
		String displayLabel=excelReader(scenarioName,Display_Label);
		String fieldName=excelReader(scenarioName,Field_Name2);
		settingPage.clickOnEdit_btn();
		settingPage.editExtraFields(paymentMethod, displayLabel,fieldName);
	}
	
	
	@And("Edit and Verify the store info details like {string} and {string}")
	public void editAndVerifyStoreInfoDetails(String emailID,String address2) throws FileNotFoundException, IOException {
		String newEmail=excelReader(scenarioName, emailID);
		String address=excelReader(scenarioName, address2);
		settingPage.clickOnEdit_btn();
		settingPage.editEmail_StoreInfo(newEmail);
		settingPage.editAddress2_StoreInfo(address);
		settingPage.clickOnSaveStoreInfo_btn();
		settingPage.verifyStoreInfoEdited(newEmail, address);
	}
}