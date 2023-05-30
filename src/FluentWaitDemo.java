import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div button")).click();
		
		WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']/h4"));
		
		System.out.println(helloWorld.isDisplayed());
		
		Wait<WebDriver>  fObj = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		WebElement foo = fObj.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				
				if(helloWorld.isDisplayed()) {
					
					return helloWorld;
					
				}
				
				else {
					
					return null;
				}
				
			}
			
			
		});
System.out.println(helloWorld.isDisplayed());

System.out.println("Printing foo Variable Value::" +foo);
	}

}
