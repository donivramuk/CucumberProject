package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {
	public WebDriver driver;
	
	public WaitHelper(WebDriver dr) {
		
		this.driver=dr;
	}
	
	public void WaitForElement(WebElement elemment,int time ) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(elemment));
		
	}
	

}
