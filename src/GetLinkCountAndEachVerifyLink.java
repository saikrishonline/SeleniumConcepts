import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetLinkCountAndEachVerifyLink {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> linkCount = driver.findElements(By.tagName("a"));
		System.out.println(linkCount.size());	
		
		// get count of the links in footer section
		
		WebElement footerLinks = driver.findElement(By.id("gf-BIG"));
	System.out.println(footerLinks.findElements(By.tagName("a")).size());	
	
	
		//get count of links in each column
	
		WebElement column1 = driver.findElement(By.xpath("//div[@id='gf-BIG'] //td[1]/ul"));
	System.out.println(column1.findElements(By.tagName("a")).size());
	
	int column1Size = column1.findElements(By.tagName("a")).size();
	
	
	
	for (int i=1; i<column1Size; i++) {
		
		
		
		String clickPattern = Keys.chord(Keys.COMMAND,Keys.ENTER);
		
		column1.findElements(By.tagName("a")).get(i).sendKeys(clickPattern);
		
		Thread.sleep(5000);
	}
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
			
		}
		
		
		
		
		
		

		
	}

}
