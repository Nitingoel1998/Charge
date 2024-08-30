@ChargeWebApplication_Employee
Feature: This feature is for user Section.

  @TC033_addUser @ChargeTestCases
  Scenario: Creation of new User
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to a User Section
    And Enter the details of a user "First_Name" "Last_Name" "Email" "Mobile_Number" "Access"
    And verify user with "Email" is created successfully
    Then Click on Logout

  @TC034_assignUserPrivilege @ChargeTestCases
  Scenario: Creation of new User and assign privilege to the user
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to a User Section
    And Enter the details of a user "First_Name" "Last_Name" "Email" "Mobile_Number" "Access"
    And verify user with "Email" is created successfully
    And I wait for Sometime
    And Click on the user with "Email"
    And Navigate to privilege tab
    And Select the "Privileges" for the user
    And I wait for Sometime
    Then Click on Logout

  @TC035_deleteUser @ChargeTestCases
  Scenario: Delete a User and verify the user is deleted
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to a User Section
    And Enter the details of a user "First_Name" "Last_Name" "Email" "Mobile_Number" "Access"
    And verify user with "Email" is created successfully
    And I wait for Sometime
    And Click on the user with "Email"
    And Click on a delete button
    And I wait for Sometime
    And verify user with "Email" is created successfully
    And I wait for Sometime
    Then Click on Logout

  @TC036_editUser @ChargeTestCases
  Scenario: Edit a User and verify the user is edited
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to a User Section
    And Enter the details of a user "First_Name" "Last_Name" "Email" "Mobile_Number" "Access"
    And verify user with "Email" is created successfully
    And I wait for Sometime
    And Click on the user with "Email"
    And Enter the details you want to edit like "First_Name2"
    And Enter the details you want to edit like "Last_Name2"
    And Enter the details you want to edit like "Mobile_Number2"
    And Click on Update button
    And I wait for Sometime
    Then Click on Logout

  @TC37_createSubscriptionPlan @ChargeTestCases
  Scenario: User is able to create the Subscription Plan
    Given open the browser1
    When Navigate to URL2
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And I wait for Sometime
    And Navigate to a Subscription Section
    And click on Create New Plan button
    And Enter the details "Plan_Name" "Plan_Amount" "Plan_Description" "Plan_Frequency"
    And I wait for Sometime
    And Capture Plan ID
    And Verify the added plan is active or not active
    And I wait for Sometime
    Then Click on Logout

  @TC38_assignSubscriptionPlanToCustomer @ChargeTestCases
  Scenario: User is able to Assign the Subscription Plan to a customer
    Given open the browser1
    When Navigate to URL2
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And I wait for Sometime
    And Navigate to a Subscription Section
    And click on Create New Plan button
    And Enter the details "Plan_Name" "Plan_Amount" "Plan_Description" "Plan_Frequency"
    And Capture Plan ID
    And Verify the added plan is active or not active
    And Click on customer section
    And Click on customer name whose "Mobile_Number"
    And I wait for Sometime
    And Click on the Subscription tab in customer details page
    And I wait for Sometime
    And Click on assign plan and enter plan details "Plan_Name" "Start_Date" "Until" "End_Date"
    And Apply Discount "Discount_type" "Discount_Amount" to the Plan "Plan_Amount"
    And Click on add card and enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName" and select the card
    And I wait for Sometime
    And verify the card has been added
    And I wait for Sometime
    And Select the card whose "CardNumber"
    And Click on Subscription save button
    And I wait for Sometime
    And Capture Plan ID
    And Verify the added plan is active or not active
    Then Click on Logout

  @TC_39VerifyEmployeeSaleSummaryReport @ChargeTestCases
  Scenario: Verify Sale Summary report with the complete process
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username2" and "Password2" and Click on login button
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
    Then Click on Logout
    And I wait for Sometime
    And Enter the details "Username" and "Password" and Click on login button
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Select the user "User_Name" from the dropdown in Employee Sale Summary report
    And Capture the Employee Sale Summary report of "User_Name" with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And Capture the Employee Sale Summary report of "User_Name" with payment via "Payment_Method" and verify the "Header2" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout

  @TC_40verifyTipRefundStatus @ChargeTestCases @verifycartAndReceiptAmount
  Scenario: Perform the Tip refund process and verify the status is displyed under transaction history
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
    And Click on refund button, select the Tip refund type and verify the refund status is diplayed in transaction
    Then Click on Logout

  @TC_41VerifyItemReport @ChargeTestCases
  Scenario: Verify Sales By Item report with the complete process
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
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
    And I wait for Sometime
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Verify the total item Amount for "SuperCatName","CategoryName","ItemName","Quantity" is displaying correctly in Item report
    And I wait for Sometime
    Then Click on Logout

  @TC42_editInvoice @InvoicesManagement @ChargeTestCases
  Scenario: Verify the invoice is edited successfully
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
    And Click on the actions dropdown and click on edit invoice button
    And I wait for Sometime
    And Apply Discount on Estimate "Discount_Amount2"
    And click on add attachment and select a file from "File_Path"
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    Then Click on Logout

  @TC43_partialPaymentfunctionality
  Scenario: Verify user is able to do partial payment successfully
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
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
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And Continue the Payment via Cash
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    Then Click on Logout

  @TC44_addQuickitem
  Scenario: Verify user is able to add the Quick Charge item into a cart
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And I wait for Sometime
    Then Click on Logout

  @TC45_editQuickitemName
  Scenario: Verify user is able to edit the quick item name
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Click on edit button ,enter the "Item_Name2" and click on update button
    And Verify the Quick item "Item_Name2" is displayed into the cart or not
    And I wait for Sometime
    Then Click on Logout

  @TC46_deleteQuickItem
  Scenario: Verify user is able to delete the quick item from the cart
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Click on delete button right to the quick item in the cart
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And I wait for Sometime

  @TC47_clearSaleQuickItem
  Scenario: Verify user is able to clear sale items to the cart
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Click on clear sale button
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And I wait for Sometime
    Then Click on Logout

  @TC48_assignCustomerToQuickCharge
  Scenario: Verify user is able to assign the customer for the Quick charge
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Click on Assign Customer button
    And Select the customer whose "Mobile_Number" in Search Customer Page
    And I wait for Sometime
    Then Click on Logout

  @TC49_editQuantityQuickItem
  Scenario: Verify user is able to edit the quantity for the quick item
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Click on the increase quantity icon "Quantity" in quick item to the cart
    And I wait for Sometime
    Then Click on Logout

  @TC50_VerifyOpenOrder
  Scenario: Verify order is came into open order and verify its details
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And I wait for Sometime
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button
    And Click on Manual card button
    And Enter the tip "Tip" in the Tip Page
    And Click on Manual card Close button
    And Click on Deposit page Close button
    And Navigate to Open Order tab in Virtual Terminal section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the open order for the particular date and time
    And Capture the Open Order receipt ID
    And verify the Open Order details
    And I wait for Sometime
    Then Click on Logout

  @TC_51ValidateDiscountReportViaCash @estimateSection @ChargeTestCases
  Scenario: Perform the transaction Via Cash and validate it in Discount report
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
    And Capture the date and time of the Transaction
    And verify the receipt details of payment via "Payment_Method"
    And Click on the report section in menu bar
    And Select report "Report_Name" and Select the date range from "Date_From" to "Date_To" to generate report
    And Capture the Discount report with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout

  @TC_52ValidateDiscountReportViaManualCard @estimateSection @ChargeTestCases
  Scenario: Perform the transaction Via Manual Card and validate it in Discount report
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
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
    And Capture the Discount report with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout

  @TC_53ValidateDiscountReportViaACH @estimateSection @ChargeTestCases
  Scenario: Perform the transaction Via ACH and validate it in Discount report
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Navigate to Catalog Section and add super category "SuperCatName" click on Save button
    And I wait for Sometime
    And Enter the "CategoryName","SuperCatName","Tax" and "ImagePath" and click on Save and Verify
    And Click on the category "CategoryName"
    And Add the Item and enter the "ItemName" "ItemPrice" "Tax" and "Item_Image" then click on save and verify
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
    And Capture the Discount report with payment via "Payment_Method" and verify the "Header1" amount with the cart Amount
    And I wait for Sometime
    Then Click on Logout
 
    
