@ChargeWebApplication_Estimate
Feature: This feature is for estimate Section.

   @TC022_verifyDepositInvoiceACHPayment @ChargeTestCases @developmentScenarios
  Scenario: Verify the invoice status after the Deposit is selected with total due and payment is done via ACH with tip
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And I wait for Sometime
    And Navigate to Invoices Section
    And Click on Create New Invoice in Invoice section
    And Select the "Net_Days" in Net Term dropdown in create new Invoice Page
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Request deposit button from Invoice page
    And Select on Total Amount radio button on request deposit Page
    And Generate the Url for "Deposit_method" via email for "orderID" and "Order_Date"
    
    And I wait for Sometime
    #And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    #And verify the receipt details of payment via "Payment_Method"
    #And I wait for Sometime
    #And Navigate to Invoices Section
    #And Enter the date range "Date_From" "Date_To" to display the transaction
    #And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  