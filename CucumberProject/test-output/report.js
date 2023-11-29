$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/AddCustomers.feature");
formatter.feature({
  "name": "AddCustomers",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Pre-condition for opening website",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch the Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.user_Launch_the_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Open the URL \"https://admin-demo.nopcommerce.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.open_the_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enter the Username as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_Enter_the_Username_as_and_Password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Login button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_click_on_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view the dash board",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_can_view_the_dash_board()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "User click on customers menu",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_click_on_customers_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on customer menu item",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_click_on_customer_menu_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Add New customer button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_Add_New_customer_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view the Add customer page",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_can_view_the_Add_customer_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user can enter customer info",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_can_enter_customer_info()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Save button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_Save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user can view the confirmation message \"The new customer has been added successfully\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_can_view_the_confirmation_message(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the Browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.close_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:Features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch the Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.user_Launch_the_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Open the URL \"https://admin-demo.nopcommerce.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.open_the_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enter the Username as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_Enter_the_Username_as_and_Password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Login button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_click_on_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page title should be \"Dashboard / nopCommerce administration\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.successful_login_title_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on logout button",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_click_on_logout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page title should be \"Your store. Login\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.successful_login_title_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the Browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.close_Browser()"
});
formatter.result({
  "status": "passed"
});
});