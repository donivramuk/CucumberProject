package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomer;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseClass {
	
	@Before
	public void setup() throws IOException 
	{
		//configuring logger
		logger = logger.getLogger("CucumberProject");
		PropertyConfigurator.configure("log4j.properties");
		
		//reading prpoperties files
		prop = new Properties();
		File src = new File(".//Configuration//config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop.load(fis);
		
		String br = prop.getProperty("browser");
		if(br.equals("Chrome")) 
		{
			driver= new ChromeDriver();
		}else if(br.equals("Firefox")) 
		{
			driver = new FirefoxDriver();
		}
		
		logger.info("------------broweser launched--------------------");
		
	}
	
	
	
	
	
@Given("User Launch the Chrome Browser")
public void user_Launch_the_Chrome_Browser() {
	//driver= new ChromeDriver(); 
	 lp = new LoginPage(driver);
}

@When("Open the URL {string}")
public void open_the_URL(String Url) throws InterruptedException {
	driver.get(Url); 
	driver.manage().window().maximize();
	logger.info("------------opening the URL--------------------");

	Thread.sleep(2000);
  
}

@When("User Enter the Username as {string} and Password as {string}")
public void user_Enter_the_Username_as_and_Password_as(String email, String password) {
    // Write code here that turns the phrase above into concrete actions
	lp.setUserName(email);
	lp.setPass(password);
	logger.info("------------sending User Name and Password--------------------");

}

@When("User click on Login button")
public void user_click_on_Login_button() throws InterruptedException {
	lp.loginBtn();
	Thread.sleep(5000);
	logger.info("------------click on login button--------------------");

}

@Then("Page title should be {string}")
public void successful_login_title_should_be(String title) {
	if(driver.getPageSource().contains("Login was unsuccessful.")) {
		  driver.close();
		  Assert.assertTrue(false);
		  
		  }else 
		  { 
			  Assert.assertEquals(title,driver.getTitle()); 
				logger.info("------------verifying title --------------------");

			  
		   }
}

@When("User click on logout button")
public void user_click_on_logout_button() {
	lp.logout();
	logger.info("------------performing logout--------------------");

}

@Then("Close the Browser")
public void close_Browser() {
	driver.quit();
	logger.info("------------closing the  browser--------------------");

}

//Add customer steps

@Then("User can view the dash board")
public void user_can_view_the_dash_board() throws InterruptedException {
	Thread.sleep(5000);
	addcust = new AddCustomerPage(driver);
	Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getpagetitle());
	logger.info("------------viewing the  dashboard--------------------");

}

@When("User click on customers menu")
public void user_click_on_customers_menu() throws InterruptedException {
	Thread.sleep(3000);
 addcust.Customermenu();  
	logger.info("------------clicking menu--------------------");

}

@When("User click on customer menu item")
public void user_click_on_customer_menu_item() throws InterruptedException {
	Thread.sleep(3000);
 addcust.Customermenuitem();
	logger.info("------------clicking menu item --------------------");

}

@When("click on Add New customer button")
public void click_on_Add_New_customer_button() throws InterruptedException {
	Thread.sleep(3000);
 addcust.Customerlink();
	logger.info("------------clicking new customer button--------------------");

}

@Then("User can view the Add customer page")
public void user_can_view_the_Add_customer_page() throws InterruptedException {
	Thread.sleep(3000);
	Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getpagetitle());
	logger.info("------------verifying the title--------------------");

}

@When("user can enter customer info")
public void user_can_enter_customer_info() throws InterruptedException {
	logger.info("------------entering the customrer info--------------------");

 String Email = RandomString()+"@mailinator.com";
 addcust.SetEmail(Email);
 addcust.Setpass("Test@1234");
 addcust.Setgender("Male");
 addcust.SetFirstName("Rajinth");
 addcust.SetLastName("Kumar");
 addcust.SetDob("05/09/2023");
 Thread.sleep(5000);
 addcust.setCustomRoles("Guests");
 addcust.Setexampt();
 addcust.Setcompanyname("omnicomm");
 addcust.SetVendorManger("Vendor 2");
 Thread.sleep(3000);
 addcust.SetCommenttext("This is for testing------------");
 
}

@When("click on Save button")
public void click_on_Save_button() throws InterruptedException {
	logger.info("------------clicking on Save button --------------------");

 addcust.Savebtn();
 Thread.sleep(2000);
}

@Then("user can view the confirmation message {string}")
public void user_can_view_the_confirmation_message(String string) throws InterruptedException {
	logger.info("------------verifying the message --------------------");

	Thread.sleep(3000);
 Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
}


//Search customer by Email
@When("Enter the Email")
public void enter_the_Email() {
	logger.info("------------enter the email --------------------");


	searchcust = new SearchCustomer(driver);
	searchcust.SetEmail("victoria_victoria@nopCommerce.com");
	
    
}

@Then("Click on Search button")
public void click_on_Search_button() throws InterruptedException {
	logger.info("------------click on search button--------------------");

	searchcust.ClickSearch();
	Thread.sleep(5000);
	ScrollPage(driver, 1000);
	
	
}

@Then("User should found Email in the table")
public void user_should_found_in_the_table() throws InterruptedException {
	logger.info("------------search for the email --------------------");

boolean status=searchcust.SearchByEmail("victoria_victoria@nopCommerce.com");
Thread.sleep(3000);
Assert.assertEquals(true, status);


}

//Search by Name
@When("Enter the FirstName")
public void enter_the_FirstName() {
	searchcust = new SearchCustomer(driver);
	searchcust.SetFirstName("Virat");
    
}

@When("Enter the LastName")
public void enter_the_LastName() {
	searchcust.SetLastName("Kohli");
}

@Then("User should found Name in the table")
public void user_should_found_Name_in_the_table() throws InterruptedException {
	logger.info("------------search for the Name--------------------");

	boolean status =searchcust.SearchByName("Virat Kohli","Virat","Kohli");
	Thread.sleep(3000);
	Assert.assertEquals(true, status);
}






	
	

}
