package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public WebDriver driver;
	
	public LoginPage(WebDriver dr) {
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath ="//*[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id='Password']")
	WebElement txtpass;
	
	@FindBy(xpath ="//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
		
	}
	public void setPass(String pass) {
		txtpass.clear();
		txtpass.sendKeys(pass);
		
	}
	public void loginBtn() {
		loginBtn.click();
		
	}
	public void logout() {
		logout.click();
		
	}


}
