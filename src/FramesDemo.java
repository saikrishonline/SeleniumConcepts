import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {

		
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//commenting webelement as we can use by index value as well.
	//	WebElement getFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
		
		//getting to know the size of the frames on the browser.
		System.out.println(driver.findElements(By.tagName("iframe")).size());	 
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
		
		
		//Switching back to default content on the browser (getting out of frames)
		driver.switchTo().defaultContent();
		
		
		
	}

}
