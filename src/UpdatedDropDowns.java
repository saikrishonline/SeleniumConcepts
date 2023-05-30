import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		
	

		WebElement noOfPassengers = driver.findElement(By.id("hrefIncAdt"));
		WebElement auditCount = driver.findElement(By.id("spanAudlt"));
		
		System.out.println(auditCount.getText()); 
		int i = 1;
		while(i<5) {
			
			noOfPassengers.click();
			i++;
			
		}
		
		
		System.out.println(auditCount.getText()); 
			

		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		
		if(driver.findElement(By.id("spclearDate")).getAttribute("style").contains("display: none;")) {
			
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			
			
		}
	}

	

	
	
}
