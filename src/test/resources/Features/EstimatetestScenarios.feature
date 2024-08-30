@ChargeWebApplication_Estimate
Feature: This feature is for estimate Section.

  @TC_66CreateNewEstimateUsingSavebtnAndverifyStatus @estimateSection @ChargeTestCases
  Scenario: Create New Estimate using Save button and capture the receipt ID and Verify the status
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And I wait for Sometime
    Then Click on Logout

  @TC_67CreateNewEstimateUsingSaveAndSendbtnAndverifyStatus @estimateSection @ChargeTestCases
  Scenario: Create New Estimate using Save and Send button and capture the receipt ID and Verify the status
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    #And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save and Send button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And I wait for Sometime
    Then Click on Logout

  @TC_68deleteDraftStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status draft can be deleted
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Click on Delete button and verify the estimate is deleted from the Estimate List
    And I wait for Sometime
    Then Click on Logout

  @TC_69EditDraftStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status draft can be Edited( estimate edited with Discount applied )
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Click on edit Estimate button
    And I wait for Sometime
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    Then Click on Logout

  @TC_70shareDraftStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status draft can be Share
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Click on Share button and verify the estimate is shared via "Share_Method" and verify the success message
    And I wait for Sometime
    Then Click on Logout

  @TC_71editSentStatus_estimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Sent can be Edited( estimate edited with Discount applied )
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    #And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save and Send button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Click on edit Estimate button
    And I wait for Sometime
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    Then Click on Logout

  @TC_72shareSentStatus_estimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Sent can be Share
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    #And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save and Send button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And I wait for Sometime
     And Click on Share button and verify the estimate is shared via "Share_Method" and verify the success message
    And I wait for Sometime
    Then Click on Logout

  @TC_73deleteSentStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Sent can be deleted
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
     And I wait for Sometime
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save and Send button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Click on Delete button and verify the estimate is deleted from the Estimate List
    And I wait for Sometime
    Then Click on Logout

  @TC_74deleteApprovedStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Approved can be deleted
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on Delete button and verify the estimate is deleted from the Estimate List
    And I wait for Sometime
    Then Click on Logout

  @TC_75EditApprovedStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Approved can be Edited( estimate edited with Discount applied )
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on edit Estimate button
    And I wait for Sometime
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    Then Click on Logout

  @TC_76shareApprovedStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Approved can be Share
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on Share button and verify the estimate is shared via "Share_Method" and verify the success message
    And I wait for Sometime
    Then Click on Logout

  @TC_77convertToInvoice_Estimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Approved can be convert to Invoice
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on send invoice icon
    And Select the "Net_Days" in Net Term Page
    And I wait for Sometime
    And Navigate to Invoices Section
    And Search for "First_Name" in invoices page
    And Enter the date range "Date_From" "Date_To" to display the transaction
    And verify the invoice status for Estimate converted to invoice
    #And Select the "List_Status" and Capture the invoice details shows in the list
    And I wait for Sometime
    Then Click on Logout

  @TC_78deleteDeclinedStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Declined can be deleted
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on Delete button and verify the estimate is deleted from the Estimate List
    And I wait for Sometime
    Then Click on Logout

  @TC_79EditDeclinedStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Declined can be Edited( estimate edited with Discount applied )
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on edit Estimate button
    And I wait for Sometime
    And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    Then Click on Logout

  @TC_80shareDeclinedStatusEstimate @estimateSection @ChargeTestCases
  Scenario: Verify the estimate with the status Declined can be Share
    Given open the browser1
    When Navigate to URL
    And Enter the details "Username" and "Password" and Click on login button
    And Click on customer section
    And Enter the details like "First_Name" "Last_Name" "Email" "Mobile_Number" and click on submit button
    And Verify the customer with "Mobile_Number" is diplayed in the list
    And Navigate to Estimate Section
    And Click on Create New Estimate
    And Enter the invoice details like "ItemName" "ItemPrice" "Quantity"
    And Apply Discount percent on Estimate or Invoice "Discount_Percent"
    And Select the Customer from estimate page
    And Select the customer whose "Mobile_Number" in Search Customer Page
    #And Add a "Estimate_note" in create new Estimate Page
    And Click on Save button in create new Estimate Page
    And I wait for Sometime
    And Capture the receiptID
    And Verify the "Estimate_Status" displayed in the created estimate
    And Set the Newly Created estimate status to "Estimate_Status2"
    And Click on Share button and verify the estimate is shared via "Share_Method" and verify the success message
    And I wait for Sometime
    Then Click on Logout
