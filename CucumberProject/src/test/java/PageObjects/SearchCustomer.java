package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomer {
	public WaitHelper helper;
	public WebDriver driver;
	public SearchCustomer(WebDriver dr) {
		this.driver=dr;
		PageFactory.initElements(driver,this);	
		helper = new WaitHelper(driver);
	}
	
	@FindBy (how = How.XPATH,using="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy (how= How.XPATH,using="//*[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	By Fname = By.xpath("//input[@id='SearchFirstName']");
	By LastName = By.xpath("//input[@id='SearchLastName']");
	By Searchbtn = By.xpath("//button[@id='search-customers']");
	
	@FindBy (how= How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tablerows;
	
	@FindBy (how= How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tablecols;
	
	//Action class
	
	public void SetEmail(String email) 
	{
		helper.WaitForElement(txtEmail,30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void SetFirstName(String fname) 
	{
		helper.WaitForElement(driver.findElement(Fname),30);
		driver.findElement(Fname).clear();
		driver.findElement(Fname).sendKeys(fname);
	}
	
	public void SetLastName(String lname) 
	{
		helper.WaitForElement(driver.findElement(LastName),30);
		driver.findElement(LastName).clear();
		driver.findElement(LastName).sendKeys(lname);
	}
	
	public void ClickSearch() 
	{
		driver.findElement(Searchbtn).click();
		helper.WaitForElement(driver.findElement(Searchbtn),30);
	}
	
	public int GetNoOfRows()
	{
		 return(tablerows.size());
 
	}
	public int GetNoOfColumns()
	{
		return(tablecols.size());
		
	}
	
	public boolean SearchByEmail(String email)
	{
		boolean flag= false;
		for (int i = 1; i<=GetNoOfRows(); i++) {
			
		String emailtext =driver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
		//System.out.println("email is "+emailtext);
		if(emailtext.equals(email)) 
		{
			flag = true;
		}
		}	
		return flag;
	}
	
	//Search by FullName
	
	public boolean SearchByName(String Name,String Fname,String Lname)
	{
		boolean flag= false;
		
		for (int i = 1; i<=GetNoOfRows(); i++) {
		String FullName =driver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
		
		String names[] = FullName.split(" ");
		if(names[0].equals(Fname) && names[1].equals(Lname)) 
		{
			flag = true;
		}
		}	
		return flag;
	}
	
	
	
	

}
