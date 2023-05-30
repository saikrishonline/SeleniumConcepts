import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		
		
		
		Thread.sleep(2000);
		
		jse.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	
		List<WebElement> amountColumn = driver.findElements(By.xpath("//div[@class='tableFixHead'] //tbody/tr/td[4]"));
		int totalSum = 0;
		
		for(int i=0; i<amountColumn.size(); i++) {
			
			String sum = amountColumn.get(i).getText();
			int parsedSum = Integer.parseInt(sum);
			
			totalSum = totalSum + parsedSum;
			
			
		}
		
		String totalAmount = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		int totalAmountOnUI = Integer.parseInt(totalAmount);
		
		Assert.assertEquals(totalSum, totalAmountOnUI);
		
		System.out.println(totalSum);

	}

}
