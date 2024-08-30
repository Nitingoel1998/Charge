@dev_ChargeTestCases @chargeSettingModule
Feature: Development Charge Setting Module Test Cases

  @TC054_verifyeditStoreInfosetting @ChargeTestCases @developmentScenarios
  Scenario: verify user is able to edit store info settings
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Store Info tab
    And Edit and Verify the store info details like "emailID" and "Address2"
    And I wait for Sometime
    Then Click on Logout

  @TC055_createCustomFieldForInvoice @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create Custom Field for Invoice
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Custom Field for Invoice tab under Setup
    And Create Custom field for invoice and enter "Display_Label","Max_Digit"
    And I wait for Sometime
    Then Click on Logout

  @TC056_editCustomFieldForInvoice @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit Custom Field for Invoice
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Custom Field for Invoice tab under Setup
    And Create Custom field for invoice and enter "Display_label","Max_Digit"
    And I wait for Sometime
    And Edit Custom field for invoice and enter "Display_label","Max_Digit2"
    And I wait for Sometime
    Then Click on Logout

  @TC057_deleteCustomFieldForInvoice @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to Delete Custom Field for Invoice
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Custom Field for Invoice tab under Setup
    And Create Custom field for invoice and enter "Display_label","Max_Digit"
    And Delete Custom field for invoice whose "Display_label"
    And I wait for Sometime
    Then Click on Logout

  @TC058_createPreDefinedDiscount @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create pre define discount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Discount tab under Setup
    And Create pre defined discount and enter "Discount_Type","Discount_Code","Discount_Value" and "Discount_Label"
    And I wait for Sometime
    Then Click on Logout

  @TC059_editPreDefinedDiscount @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit pre defined discount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Discount tab under Setup
    And Create pre defined discount and enter "Discount_Type","Discount_Code","Discount_Value" and "Discount_Label"
    And Edit predefined Discounts "Discount_Type2","Discount_Code","Discount_Value2" and "Discount_Label2"
    And I wait for Sometime
    Then Click on Logout

  @TC060_deletePreDefinedDiscount @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to delete pre defined discount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Discount tab under Setup
    And Create pre defined discount and enter "Discount_Type","Discount_Code","Discount_Value" and "Discount_Label"
    And Delete Predefined Discount whose "Discount_Code"
    And I wait for Sometime
    Then Click on Logout

  @TC061_createPreDefinedNetTerms @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create pre defined Net Terms
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to PreDefined Net Terms tab under Setup
    And Create pre defined Net Terms and enter "NetTerm_Days"
    And I wait for Sometime
    Then Click on Logout

  @TC062_editPreDefinedNetTerms @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit pre defined Net Terms
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to PreDefined Net Terms tab under Setup
    And Create pre defined Net Terms and enter "NetTerm_Days"
    And Edit the Pre defined Net Terms days from "NetTerm_Days" to "NetTerm_Days2"
    And I wait for Sometime
    Then Click on Logout

  @TC063_deletePreDefinedNetTerms @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to delete pre defined Net Terms
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to PreDefined Net Terms tab under Setup
    And Create pre defined Net Terms and enter "NetTerm_Days"
    And Delete the Pre defined Net Terms days whose "NetTerm_Days"
    And I wait for Sometime
    Then Click on Logout

  @TC064_createPredefinedTips @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create pre defined tip
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Pre defined Tips tab under Setup
    And Create Pre defined tips and enter "Tip_Label","Tip_Value"
    And I wait for Sometime
    Then Click on Logout

  @TC065_editPredefinedTips @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit pre defined tip
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Pre defined Tips tab under Setup
    And Create Pre defined tips and enter "Tip_Label","Tip_Value"
    And I wait for Sometime
    And Edit Pre defined tips and enter "Tip_Label","Tip_Value2"
    And I wait for Sometime
    Then Click on Logout

  @TC066_deletePredefinedTips @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to delete pre defined tip
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Pre defined Tips tab under Setup
    And Create Pre defined tips and enter "Tip_Label","Tip_Value"
    And Delete Pre defined tips whose "Tip_Label"
    And I wait for Sometime
    Then Click on Logout

  @TC067_selectCustomTip_PredefinedTips @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create pre defined custom tip
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Pre defined Tips tab under Setup
    And Create Pre defined tips and enter "Tip_Label","Tip_Value"
    And Select Custom Tip for Pre defined tips whose "Tip_Label"
    And I wait for Sometime
    Then Click on Logout

  @TC068_createTaxField @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create pre defined tax
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Tax Section
    And Create tax Field and enter the details like "TaxClass_Name" and "Tax_Rate"
    And I wait for Sometime
    Then Click on Logout

  @TC069_editTaxField @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit pre defined tax
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Tax Section
    And Create tax Field and enter the details like "TaxClass_Name" and "Tax_Rate"
    And Edit the Tax Field whose "TaxClass_Name" and enter detail "Tax_Rate2"
    And I wait for Sometime
    Then Click on Logout

  @TC070_deleteTaxField @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to delete pre defined tax
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Tax Section
    And Create tax Field and enter the details like "TaxClass_Name" and "Tax_Rate"
    And Delete the Tax field whose "TaxClass_Name"
    And I wait for Sometime
    Then Click on Logout

  @TC071_assignDefaultTax @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to assign default to a tax
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to Tax Section
    And Create tax Field and enter the details like "TaxClass_Name" and "Tax_Rate"
    And Assign the "TaxClass_Name" as Default tax
    And I wait for Sometime
    Then Click on Logout

  @TC072_createUserdefinedPaymentMethod @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create User Defined Payment Method
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And I wait for Sometime
    Then Click on Logout

  @TC073_editUserdefinedPaymentMethod @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit User Defined Payment Method
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And Edit the User defined payment Method from "Payment_Method_Name" to "Payment_Method_Name2"
    And I wait for Sometime
    Then Click on Logout

  @TC074_deleteUserdefinedPaymentMethod @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to delete User Defined Payment Method
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And Delete the User Defined Payment method field whose "Payment_Method_Name"
    And I wait for Sometime
    Then Click on Logout

  @TC075_selectUserDefPaymentMethodAsFavourite @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to mark/remove a User Defined Payment Method Favorite
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And Select user defined payment Method whose "Payment_Method_Name" as favourite
    And I wait for Sometime
    Then Click on Logout

  @TC076_createExtraFields @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to create Extra Fields
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And Navigate to Extra Fields Section under Setting
    And Create Extra field ,Select "Payment_Method_Name" dropdown and enter the row details like "Display_Label" "Field_Name" "Max_Digit"
    And I wait for Sometime
    Then Click on Logout
    
    @TC077_editExtraField @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to edit Extra Fields
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
    And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And Navigate to Extra Fields Section under Setting
    And Create Extra field ,Select "Payment_Method_Name" dropdown and enter the row details like "Display_Label" "Field_Name" "Max_Digit"    
    And Edit the Extra field whose "Payment_Method_Name" and "Display_Label" like "Field_Name2"
    And I wait for Sometime
    Then Click on Logout

  @TC078_deleteExtraField @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to delete Extra Fields
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Setting Section
   And Navigate to User defined Payment Method Section
    And Create User defined payment Method and enter the details like "Payment_Method_Name"
    And Navigate to Extra Fields Section under Setting
    And Create Extra field ,Select "Payment_Method_Name" dropdown and enter the row details like "Display_Label" "Field_Name" "Max_Digit"
    And Delete the Extra field whose "Payment_Method_Name" and "Display_Label"
    And I wait for Sometime
    Then Click on Logout
