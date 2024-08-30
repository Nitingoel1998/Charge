@ChargeWebApplication @FirstSprint
Feature: This feature is for Charge Portal.

  @TC01_login @ChargeTestCases
  Scenario: User should be able to login
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And I wait for Sometime
    Then Click on Logout

  @TC02_addingSuperCatogory @ChargeTestCases
  Scenario: Adding Super Category and Category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And I wait for Sometime
    Then Click on Logout

  @TC03_addingItem @ChargeTestCases
  Scenario: Adding Item into category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    Then Click on Logout

  @TC04_editItem @ChargeTestCases
  Scenario: Edit Item from category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Click on item edit button and enter the "CategoryName" "ItemName2" "ItemPrice2" then click on save and verify
    Then Click on Logout

  @TC05_deleteItem @ChargeTestCases
  Scenario: Delete Item from category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Click on delete "ItemName" "CategoryName" and verify the item is deleted
    Then Click on Logout

  @TC06_editCatogory @ChargeTestCases
  Scenario: validate that user is able to edit created category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And I wait for Sometime
    And Click on category edit button and enter the "CategoryName" "CategoryName2" then click on save and verify
    Then Click on Logout

  @TC07_deleteCatogory @ChargeTestCases
  Scenario: validate that user is able to delete created category
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And I wait for Sometime
    And Click on category edit button and click the "CategoryName" then click on delete and verify
    Then Click on Logout

  @TC08_addingItemintoCart @ChargeTestCases
  Scenario: Items added to the cart and verify Items amount as per their quantities added
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    Then Click on Logout

  @TC09_verifySubTotalValue @ChargeTestCases
  Scenario: verify Sub total value in cart as per added Items and their quantity
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And Add the Item and enter the "ItemName2" "ItemPrice2" "Tax" then click on save and verify
    And Add the item "itemName2" with "Quantity2" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    Then Click on Logout

  @TC10_applyDiscountPercentandVerify @ChargeTestCases
  Scenario: Apply discount percentage to the cart price and verify the discount value is properly calculated
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And Add the Item and enter the "ItemName2" "ItemPrice2" "Tax" then click on save and verify
    And Add the item "itemName2" with "Quantity2" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount percentage "Discount_Percentage" to the cart value and verify the discount amount
    Then Click on Logout

  @TC11_applyDiscountAmountandVerify @ChargeTestCases
  Scenario: Apply discount amount to the cart price and verify the discount value is properly calculated
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And Add the Item and enter the "ItemName2" "ItemPrice2" "Tax" then click on save and verify
    And Add the item "itemName2" with "Quantity2" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    Then Click on Logout

  @TC12_verifyPaymentProcessViaCash @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Verify Payment process via cash and verify the Receipt Amount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Cash
    And verify the receipt details of payment via "Payment_Method"
    Then Click on Logout

  @TC13_verifyPaymentProcessViaManualCard @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Verify Payment process via Manual Card and verify the Receipt Amount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    #And Enter the Quantity "Quantity2" of the quick item
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    #And Continue the payment via swipe
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    Then Click on Logout

  @TC14_verifyPaymentProcessViaACH @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Verify Payment process via ACH and verify the Receipt Amount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And verify the receipt details of payment via "Payment_Method"
    Then Click on Logout

  @TC15_verifyPaymentProcessViaCheque @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Verify Payment process via cheque and verify the Receipt Amount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
     And Click on the Charge button
    And verify the receipt details of payment via Cheque "Payment_Method" and "Cheque_Number"
    Then Click on Logout

  @TC16Reportverification @ChargeTestCases
  Scenario: Verify summary report in Reports Section
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Export the report "Report_Name" in CSV file and Verify the downloaded report
    Then Click on Logout

  @TC17_verifyTransactioninhistory @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Verify the transaction receipt is coming under transaction history
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the transaction details
    Then Click on Logout

  @TC18_verifyfullRefundStatus @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Perform the Full refund process and verify the status is displyed under transaction history
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the transaction details
    And Click on refund button, select the full refund type and verify the refund status is diplayed in transaction
    Then Click on Logout

  @TC19_verifyPartialRefundStatus @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Perform the Partial refund process and verify the status is displyed under transaction history
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the transaction details
    And Click on refund button, select the partial refund type and enter the "Partial_Refund_Amt" and verify the refund status is diplayed in transaction
    Then Click on Logout
    
  @TC20_verifyPartialRefundStatusviaCash @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Perform the cash Partial refund process  and verify the status is displyed under transaction history
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Cash
    And verify the receipt details of payment via "Payment_Method"
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the transaction details
    And Click on refund button, select the partial refund type and enter the "Partial_Refund_Amt" and verify the refund status is diplayed in transaction
    Then Click on Logout

  @TC21_verifyFullRefundStatusviaCash @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Perform the cash Full refund process  and verify the status is displyed under transaction history
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Cash
    And verify the receipt details of payment via "Payment_Method"
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And I wait for Sometime
    And Click on the transaction and verify the transaction details
    And Click on refund button, select the full refund type and verify the refund status is diplayed in transaction
    Then Click on Logout
    
    

  @TC22_createAndVerifyCustomerAdded @CustomerManagement @ChargeTestCases
  Scenario: create and verify customer in charge
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    Then Click on Logout

  @TC23_editAndVerifyCustomerdetail @CustomerManagement @ChargeTestCases
  Scenario: edit and verify customer in charge
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Click on customer name "Mobile_Number" ,click on edit and enter the "Last_Name2" and click on save button
    And I wait for Sometime
    Then Click on Logout

  @TC24_deleteCustomerdetail @CustomerManagement @ChargeTestCases
  Scenario: Delete customer in charge
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Click on customer name whose "Mobile_Number", Click on edit and click on delete button
    And Click on customer section
    And Verify the customer with "Mobile_Number" is diplayed in the list
    Then Click on Logout

  @TC25_sendInvoiceToCustomer @CustomerManagement @ChargeTestCases
  Scenario: Verify user is able to send the invoice to the customer
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
     And I wait for Sometime
    And Continue the Payment via SendInvoice
    And Select the "Net_Days" in Net Term Page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    Then Click on Logout

  @TC26_sendInvoiceAndVerifyAmountInInvoices @InvoicesManagement @ChargeTestCases
  Scenario: Verify the invoice amount details in Invoice section
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via SendInvoice
    And Select the "Net_Days" in Net Term Page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    And I wait for Sometime
    And Navigate to Invoices Section
    And Search for "First_Name" in invoices page
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    Then Click on Logout

  @TC27_sendInvoiceAndPayFromInvoice @InvoicesManagement @ChargeTestCases
  Scenario: Pay invoice amount from invoice page and verify the receipt details
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via SendInvoice
    And Select the "Net_Days" in Net Term Page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    And I wait for Sometime
    And Navigate to Invoices Section
    And Search for "First_Name" in invoices page
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via Cash
    And verify the receipt details of payment via "Pay_Invoice_Method"
    Then Click on Logout

  @TC_28createEstimate @estimateSection @ChargeTestCases
  Scenario: Create New Estimate and capture the receipt ID
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Navigate to Estimate Section
    And Create New Estimate and enter the details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount on Estimate "Discount_Amount"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And Capture the receiptID
    And I wait for Sometime
    Then Click on Logout

  @TC_29Send_EstimateToInvoice @estimateSection @ChargeTestCases
  Scenario: Create Estimate set status to approved and send the invoice
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Navigate to Estimate Section
    And Create New Estimate and enter the details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount on Estimate "Discount_Amount"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And I wait for Sometime
    And Set the Newly Created estimate status to "Estimate_Status"
    And Click on send invoice icon
    And Select the "Net_Days" in Net Term Page
    And I wait for Sometime
    Then Click on Logout

  @TC_30ValidateTransactionReportViaCash @estimateSection @ChargeTestCases
  Scenario: Perform the transaction Via Cash and validate it in Transaction report
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Cash
    And verify the receipt details of payment via "Payment_Method"
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header2" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header3" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header4" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout

  @TC_31ValidateTransactionReportViaACH @estimateSection @ChargeTestCases
  Scenario: Perform the transaction Via ACH and validate it in Transaction report
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And verify the receipt details of payment via "Payment_Method"
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header2" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header3" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header4" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout

  @TC_32ValidateTransactionReportViaManualCard @estimateSection @ChargeTestCases
  Scenario: Perform the transaction Via Manual Card and validate it in Transaction report
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" then click on save and verify
    And Add the item "itemName" with "Quantity" to the cart and verify the item is added successfully
    And I wait for Sometime
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header2" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header3" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header4" amount with the cart Amount
    And Capture the transaction report with payment via "Payment_Method" and verify the "Header5" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout
