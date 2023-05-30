import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowNavHandles {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		
		
		Set<String> windowSwtich = driver.getWindowHandles();
		Iterator<String> findTab = windowSwtich.iterator();
		String parentID = findTab.next();
		String childID = findTab.next();
		
		
		driver.switchTo().window(childID);
		
		String loginID = driver.findElement(By.xpath("//div/p/strong/a")).getText();
		
		driver.switchTo().window(parentID);
		
		driver.findElement(By.id("username")).sendKeys(loginID);
		
		Assert.assertEquals(driver.findElement(By.id("username")).getText(), loginID);
		
		
		
	}

}
