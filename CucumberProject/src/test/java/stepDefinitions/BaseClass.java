package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import PageObjects.SearchCustomer;
import PageObjects.AddCustomerPage;


public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomer searchcust;
	public Properties prop;
	public static Logger logger;
	public static String RandomString() 
	{
		String generatedstring = RandomStringUtils.randomAlphanumeric(6);
		return generatedstring;
	} 
	
	public static void ScrollPage(WebDriver driver,long num)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+num+");");
	}
	
	
	
}
