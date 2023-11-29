package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver driver;
	JavascriptExecutor js ; 
	public AddCustomerPage(WebDriver dr) 
	{
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}
	
	By customermenu =By.xpath("//a[@href='#']/p[contains(text(),'Customers')]");
	By customermenuitem = By.xpath("//a[@href='/Admin/Customer/List']/p[contains(text(),' Customers')]");
	By Customerlink = By.xpath("//a[@href='/Admin/Customer/Create']");
	By CustomerEmail =By.id("Email");
	By Customerpass =By.name("Password");
	By Cfirstname =By.id("FirstName");
	By Clastname =By.name("LastName");
	By CgenderM = By.xpath("//input[@id='Gender_Male']");
	By CgenderF = By.xpath("//input[@id='Gender_Female']");
	By Cdob = By.id("DateOfBirth");
	By cname =By.name("Company");
	By isexmpt =By.id("IsTaxExempt");
	By newsletter =By.xpath("//*[@id='customer-info']/div[2]/div[9]/div[2]/div/div[1]/div/div");
	By croles =By.xpath("//*[@id='customer-info']/div[2]/div[10]/div[2]/div/div[1]/div");
	By admintext =By.xpath("//li[contains(text(),'Administrators')]");
	By clear = By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");	
	By register =By.xpath("//li[contains(text(),'Registered')]");

	By vendor =By.xpath("//li[contains(text(),'Vendors')]");

	By guest =By.xpath("//li[contains(text(),'Guests')]");
	By managervendor = By.xpath("//select[@id='VendorId']");
	By commentarea = By.xpath("//textarea[@id='AdminComment']");
	By savebtn =By.xpath("//button[@name='save']");
	
	//Action methods
	
	public String getpagetitle() 
	{
		return driver.getTitle();
	}
	
	public void Customermenu() 
	{
		driver.findElement(customermenu).click();
	}
	public void Customermenuitem() 
	{
		driver.findElement(customermenuitem).click();
	}
	public void Customerlink() 
	{
		driver.findElement(Customerlink).click();
	}
	
	public void SetEmail(String uname) 
	{
		driver.findElement(CustomerEmail).sendKeys(uname);
	}
	public void Setpass(String password) 
	{
		driver.findElement(Customerpass).sendKeys(password);
		
	}
	
	public void SetFirstName(String fname) 
	{
		driver.findElement(Cfirstname).sendKeys(fname);
	}
	
	public void SetLastName(String lname) 
	{
		driver.findElement(Clastname).sendKeys(lname);
	}
	
	public void Setgender (String gender)
	{
		if(gender.equals("Male")) 
		{
			driver.findElement(CgenderM).click();
		}else if(gender.equals("Female"))
		{
			driver.findElement(CgenderF).click();
		}else {
			driver.findElement(CgenderM).click();
		}
	}
	
	
	public void SetDob(String dob) 
	{
		driver.findElement(Cdob).sendKeys(dob);
		js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void Setcompanyname(String company) 
	{
		driver.findElement(cname).sendKeys(company);
	}
	public void Setexampt() 
	{
		driver.findElement(isexmpt).click();
	}
	
	public void setCustomRoles(String role) 
	{
		driver.findElement(clear).click();
		driver.findElement(croles).click();
		
		WebElement listitem = null;
		if(role.equals("Administrators")) 
		{
			listitem= driver.findElement(admintext);
			
		}else if(role.equals("Registered")) 
		{
			listitem= driver.findElement(register);
		}else 
		{
			listitem= driver.findElement(guest);
		}
		//listitem.click();
		
		
		js.executeScript("arguments[0].click();",listitem);
		
		
	}
	
	public void SetVendorManger(String vendomgr) 
	{
		Select sel = new Select(driver.findElement(managervendor));
		sel.selectByVisibleText(vendomgr);
	}
	public void SetCommenttext(String content)
	{
		driver.findElement(commentarea).sendKeys(content);
	}
	public void Savebtn() 
	{
		js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)");

		driver.findElement(savebtn).click();
	}
	
	

}
