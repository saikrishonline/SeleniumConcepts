import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/link.html");
		
		driver.findElement(By.xpath("//body/a[1]")).click();
		
		WebDriverWait waitObjc = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitObjc.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("img[alt='Google']")));
		
		
		
		

	}

}
