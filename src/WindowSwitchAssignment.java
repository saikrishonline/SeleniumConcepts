import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitchAssignment {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//div/h3/following-sibling::a")).click();
		
		Set<String> windowTabs =  driver.getWindowHandles();
		Iterator<String> getWindowID = windowTabs.iterator();
		
		String parentID = getWindowID.next();
		String childID = getWindowID.next();
		
		driver.switchTo().window(childID);
		
		String childWindowString = driver.findElement(By.cssSelector("div h3")).getText();
		System.out.println(childWindowString);
		
		driver.switchTo().window(parentID);
		String parentWindowString = driver.findElement(By.cssSelector("div h3")).getText();
		System.out.println(parentWindowString);
		
		
		
		
		
		
		
		
		
	}

}
