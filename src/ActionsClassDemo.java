import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		WebElement acctList = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(acctList).contextClick().build().perform();
		
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("alexa").doubleClick().build().perform();
	
		
	}

}
