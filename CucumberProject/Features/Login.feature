Feature: Login
@sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch the Chrome Browser
    When  Open the URL "https://admin-demo.nopcommerce.com"
    And   User Enter the Username as "admin@yourstore.com" and Password as "admin"
    And   User click on Login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When  User click on logout button
    Then  Page title should be "Your store. Login"
		And   Close the Browser
		
 @regression
 Scenario Outline: Login Data Driven
 Given User Launch the Chrome Browser
    When  Open the URL "https://admin-demo.nopcommerce.com"
    And   User Enter the Username as "<email>" and Password as "<password>"
    And   User click on Login button
    Then  Page title should be "Dashboard / nopCommerce administration"
    When  User click on logout button
    Then  Page title should be "Your store. Login"
		And   Close the Browser
		
		Examples:
		|email|password|
		|admin@yourstore.com|admin|
		|admin@yourstore.com1|admin1|
		
		