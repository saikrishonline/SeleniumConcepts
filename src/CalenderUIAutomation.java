import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderUIAutomation {

	public static void main(String[] args) throws InterruptedException {
	
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://ttbvit1.tau2904.com/ttb/kdw/");
		
		driver.findElement(By.id("frmIBPreLogin_txtUserId")).sendKeys("fiat00010");
		driver.findElement(By.id("frmIBPreLogin_txtPassword")).sendKeys("fiat00010@");
		driver.findElement(By.id("frmIBPreLogin_btnLogIn")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("frmIBPostLoginDashboard_btnMenuMyActivities")).click();
		
		
		WebElement monthSelector = driver.findElement(By.xpath("//select[@id='frmIBMyActivities_cmbMonth']"));
		Select select = new Select(monthSelector);
		
		select.selectByIndex(1);
		
		List<WebElement> getDates = driver.findElements(By.xpath("//div[contains(@id, 'frmIBMyActivities_lbl')]"));
		
		
		for(int i=0; i<getDates.size(); i++) {
			
			if(getDates.get(i).getText().equalsIgnoreCase("30")) {
				
				getDates.get(i).click();
				
			}
			
			
		}
		
		

		
		

	}

}
