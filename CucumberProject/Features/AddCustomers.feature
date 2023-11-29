#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: AddCustomers 
  
 Background: Pre-condition for opening website
  	Given  User Launch the Chrome Browser
    When  Open the URL "https://admin-demo.nopcommerce.com"
    And   User Enter the Username as "admin@yourstore.com" and Password as "admin"
    And   User click on Login button
    Then  User can view the dash board
    
    @sanity  
  Scenario: Add a new customer
    When  User click on customers menu
    And   User click on customer menu item
		And   click on Add New customer button
		Then  User can view the Add customer page
		When  user can enter customer info
		And   click on Save button
		Then  user can view the confirmation message "The new customer has been added successfully"
		And   Close the Browser
		
		@regression
	Scenario: Search a customer by Email
    When  User click on customers menu
    And   User click on customer menu item
		And   Enter the Email
		Then  Click on Search button
		And   User should found Email in the table
		And   Close the Browser
		
		@regression
	Scenario: Search a customer by Name
	  When  User click on customers menu
    And   User click on customer menu item
		And   Enter the FirstName
		And   Enter the LastName
		Then  Click on Search button
		And   User should found Name in the table
		And   Close the Browser
		