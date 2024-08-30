@dev_ChargeTestCases @AugustSprint
Feature: Development Charge Test Cases

  @TC001_verifyReceiptGeneratedByACH_Card_Cheque @ChargeTestCases @developmentScenarios
  Scenario: verify the receipt by deposit amount via ACH,Card,Cheque
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    #And Enter the Quantity "Quanity" of the quick item
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount" is done via ACH
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Deposit_Amount2" is done via manual card
    And verify the receipt details of rest amount payment process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    Then Click on Logout

  @TC002_verifyReceiptGeneratedBycard_Card @ChargeTestCases @developmentScenarios
  Scenario: verify the receipt by tender amount via manual Card and balance amount is also paid by manual card
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Deposit_Amount" is done via manual card
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And I wait for Sometime
    Then Click on Logout

  @TC003_verifyReceiptGeneratedByCard_ACH_Cheque @ChargeTestCases @developmentScenarios
  Scenario: verify the receipt by deposit amount via Card,ACH,Cheque
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Deposit_Amount" is done via manual card
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount2" is done via ACH
    And I wait for Sometime
    And verify the receipt details of rest amount payment process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    Then Click on Logout

  @TC004_verifyReceiptGeneratedByACH_Cheque_Card @ChargeTestCases @developmentScenarios
  Scenario: verify the receipt by deposit amount via ACH,Cheque,Card
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount" is done via ACH
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Deposit_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And I wait for Sometime
    Then Click on Logout

  @TC005_verifyReceiptGeneratedwithDiscountByACH_Cheque_Card @ChargeTestCases @developmentScenarios
  Scenario: verify the receipt by deposit amount with discount via ACH,Cheque,Card
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount" is done via ACH
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Deposit_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And I wait for Sometime
    Then Click on Logout

  @TC006_verifyReceiptGeneratedwithDiscountPercentageByACH_Cheque_Card @ChargeTestCases @developmentScenarios
  Scenario: verify the receipt by deposit amount with discount percentage via ACH,Cheque,Card
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount percentage "Discount_Percentage" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount" is done via ACH
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Deposit_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And I wait for Sometime
    Then Click on Logout

  @TC007_verifyInvoiceACHPayment @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via ACH
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
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC008_verifyInvoiceCardPayment @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via Manual card
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
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC009_verifyInvoiceChequePayment @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via Cheque
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
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And verify the receipt details of payment via Cheque "Payment_Method" and "Cheque_Number"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC010_verifyInvoiceACHPaymentwithTip @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via ACH with Tip
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
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC011_verifyInvoiceCardPaymentwithTip @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via Manual card with Tip
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
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC012_verifyInvoiceACHPaymentwithDiscountPercent @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via ACH with Discount percent
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
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC013_verifyInvoiceACHPaymentwithDiscountAmount @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via ACH with Discount amount
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
    And Apply Discount on Estimate "Discount_Amount"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC014_verifyInvoicecardPaymentwithDiscountPercent @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via Manual card with Discount percent
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
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC015_verifyInvoiceCardPaymentwithDiscountAmount @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via Manual card with Discount amount
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
    And Apply Discount on Estimate "Discount_Amount"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC016_verifyInvoiceTenderPayment_ACH_Card_Cheque @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after tender payment is done via ACH, Card and Cheque
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
    #And Apply Discount on Estimate "Discount_Amount"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount" is done via ACH
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Deposit_Amount2" is done via manual card
    And verify the receipt details of rest amount payment process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC017_verifyInvoiceTenderPayment_Card_Cheque_ACH @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after tender payment is done via Card,Cheque and ACH
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
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Deposit_Amount" is done via manual card
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Deposit_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when payment of complete balance amount is done via ACH
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC018_verifyInvoiceTenderPayment_Cheque_ACH_Card @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after tender payment is done via Cheque, ACH and card
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
    #And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And verify the receipt details of partial amount "Deposit_Amount" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount2" is done via ACH
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC019_verifyInvoicecardPaymentwithDiscountPercentandTip @ChargeTestCases @developmentScenarios
  Scenario: verify the invoice status after payment is done via Manual card with Discount percent and Tip
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
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Verify the invoice details
    And Click on Save button in create new Estimate Page
    And Search for "First_Name" in invoices page
    And I wait for Sometime
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Select the "List_Status" and Capture the invoice details shows in the list
    And I wait for Sometime
    And verify the amount in invoice is matched with the cart amount
    And Click on Pay Now button from Invoice page
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And I wait for Sometime
    And verify the receipt details of payment via "Payment_Method"
    And I wait for Sometime
    And Navigate to Invoices Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status
    And I wait for Sometime
    Then Click on Logout

  @TC086_verifypartialReceiptByACH_Card_Cheque @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to process partial refund for the order paid via tender amount (ACH,card,Cheque)
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Tender_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Tender_Amount" is done via ACH
    And Enter the deposit Amount "Tender_Amount2" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Tender_Amount2" is done via manual card
    And verify the receipt details of rest amount payment process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the tender transaction receipt details
    And Click on refund button, select the partial refund "Partial_Refund_Amt"  for "Payment_Method" whose "Tender_Amount"
    And Click on the transaction number
    And Verify the partial refund "Partial_Refund_Amt" for "Payment_Method" in transaction history receipt
    And Click on refund button, select the partial refund "Partial_Refund_Amt2"  for "Payment_Method1" whose "Tender_Amount2"
    And Click on the transaction number
    And Verify the partial refund "Partial_Refund_Amt2" for "Payment_Method1" in transaction history receipt
    And Click on refund button, select the partial refund "Partial_Refund_Amt3" for "Payment_Method2"
    And Click on the transaction number
    And Verify the partial refund "Partial_Refund_Amt3" for "Payment_Method2" in transaction history receipt
    And I wait for Sometime
    Then Click on Logout

  @TC087_verifypartialReceiptByCard_Card @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to process full refund after partial refund for the order paid via tender amount (card) and remaining amount with card again
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Tender_Amount" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Tender_Amount" is done via manual card
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And I wait for Sometime
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the tender transaction receipt details
    And Click on refund button, select the full refund for "Payment_Method" whose "Tender_Amount"
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method" and "Tender_Amount" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method"
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method" is displayed in the transaction history
    And I wait for Sometime
    Then Click on Logout

  @TC088_verifyFullRefundReceiptByCard_ACH_Cheque @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to process full refund for the order paid via tender amount (card,ACH,cheque)
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Tender_Amount" in Quick charge
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip",Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when partial payment of "Tender_Amount" is done via manual card
    And Enter the deposit Amount "Tender_Amount2" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Tender_Amount2" is done via ACH
    And I wait for Sometime
    And verify the receipt details of rest amount payment process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the tender transaction receipt details
    And Click on refund button, select the full refund for "Payment_Method" whose "Tender_Amount"
     And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method1" whose "Tender_Amount2"
     And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method1" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method2"
     And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method2" is displayed in the transaction history
    And I wait for Sometime
    Then Click on Logout

  @TC089_verifyTipRefundReceiptByACH_Cheque_Card @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to process Tip refund for the order paid via tender amount (ACH,cheque,card)
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Deposit_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Deposit_Amount" is done via ACH
    And Enter the deposit Amount "Deposit_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Deposit_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the tender transaction receipt details
    And Click on refund button, select the Tip refund of "Payment_Method3" type and verify the refund status is diplayed in transaction
    And Click on the transaction number
    And Verify the Tip refund Amount in transaction history
    And I wait for Sometime
    Then Click on Logout

  @TC090_verifyTip_Partial_FullRefundReceiptByACH_Cheque_CardwithDiscountAMT @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to process Tip,partial and full refund for the order paid via tender amount (ACH,cheque,card) with discount amount
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount amount "Discount_Amount" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Tender_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Tender_Amount" is done via ACH
    And Enter the deposit Amount "Tender_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Tender_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the tender transaction receipt details
    And Click on refund button, select the Tip refund of "Payment_Method3" type and verify the refund status is diplayed in transaction
    And Click on the transaction number
    And Verify the Tip refund Amount in transaction history
    And Click on refund button, select the partial refund "Partial_Refund_Amt"  for "Payment_Method" whose "Tender_Amount"
    And Verify the partial refund "Partial_Refund_Amt" for "Payment_Method" in transaction history receipt
    And Click on refund button, select the partial refund "Partial_Refund_Amt2"  for "Payment_Method2" whose "Tender_Amount2"
    And Click on the transaction number
    And I wait for Sometime
    And Verify the partial refund "Partial_Refund_Amt2" for "Payment_Method2" in transaction history receipt
    And Click on refund button, select the partial refund "Partial_Refund_Amt3" for "Payment_Method3"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the partial refund "Partial_Refund_Amt3" for "Payment_Method3" in transaction history receipt
    And Click on refund button, select the full refund for "Payment_Method" whose "Tender_Amount"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method2" whose "Tender_Amount2"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method2" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method3"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method3" is displayed in the transaction history
    And I wait for Sometime
    Then Click on Logout
    
     @TC091_verifyTip_Partial_FullRefundReceiptByACH_Cheque_CardwithDiscountPercent @ChargeTestCases @developmentScenarios
  Scenario: Verify user is able to process Tip,partial and full refund for the order paid via tender amount (ACH,cheque,card) with discount percent
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Navigate to Virtual terminal Section
    And Enter the Quick charge "QuickCharge_Amount" amount and click on add cart icon
    And Verify the Quick item "Item_Name" is displayed into the cart or not
    And Verify the Sub Total Amount is correct as per the items value added in the cart
    And Enter the discount percentage "Discount_Percent" to the cart value and verify the discount amount
    And verify cart details on cart Page
    And Click on the Charge button and Continue Partial payment
    And Enter the deposit Amount "Tender_Amount" in Quick charge
    And I wait for Sometime
    And Continue the partial Payment via ACH ,add "Tip" and Enter the account details "AccountType" "Account_Number" "Account_Holder" "Routing_Number" "Account_Description"
    And I wait for Sometime
    And verify the receipt details when partial payment of "Tender_Amount" is done via ACH
    And Enter the deposit Amount "Tender_Amount2" in Quick charge
    And I wait for Sometime
    And verify the receipt details of partial amount "Tender_Amount2" process via Cheque "Payment_Method2" and "Cheque_Number"
    And I wait for Sometime
    And Continue the Payment via Manual card ,add "Tip" and Enter the card details "CardNumber" "CardExpMonth" "CardExpYear" "CardCVV" "CardHolderName"
    And verify the receipt details when payment of complete balance amount is done via Manual card
    And Navigate to Transaction history Section
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And Click on the transaction and verify the tender transaction receipt details
    And Click on refund button, select the Tip refund of "Payment_Method3" type and verify the refund status is diplayed in transaction
    And Click on the transaction number
    And Verify the Tip refund Amount in transaction history
    And Click on refund button, select the partial refund "Partial_Refund_Amt"  for "Payment_Method" whose "Tender_Amount"
    And Verify the partial refund "Partial_Refund_Amt" for "Payment_Method" in transaction history receipt
    And Click on refund button, select the partial refund "Partial_Refund_Amt2"  for "Payment_Method2" whose "Tender_Amount2"
    And Click on the transaction number
    And I wait for Sometime
    And Verify the partial refund "Partial_Refund_Amt2" for "Payment_Method2" in transaction history receipt
    And Click on refund button, select the partial refund "Partial_Refund_Amt3" for "Payment_Method3"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the partial refund "Partial_Refund_Amt3" for "Payment_Method3" in transaction history receipt
    And Click on refund button, select the full refund for "Payment_Method" whose "Tender_Amount"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method2" whose "Tender_Amount2"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method2" is displayed in the transaction history
    And Click on refund button, select the full refund for "Payment_Method3"
    And I wait for Sometime
    And Click on the transaction number
    And Verify the full refund Amount with "Payment_Method3" is displayed in the transaction history
    And I wait for Sometime
    Then Click on Logout
