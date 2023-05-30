import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class MultipleTabsDemo {

	public static void main(String[] args) throws IOException {

		

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
	//switching the window control	
	Set<String> getWH =	driver.getWindowHandles();
	Iterator<String> it = 	getWH.iterator();
	String parentID = it.next();
	String childID = it.next();
	
	
	driver.switchTo().window(childID);
	
	driver.get("https://rahulshettyacademy.com");
	
	String courseName = driver.findElement(By.xpath("//a[contains(text(), 'All-Access Membership-Complete Access to 25+')]")).getText();

	driver.switchTo().window(parentID);
	
	WebElement nameField = driver.findElement(By.cssSelector("input[name='name']"));
	
	nameField.sendKeys(courseName);
	
	
	//get height/width dimensions 
	
	int height = nameField.getRect().getHeight();
	
	System.out.println(height);
	int width = nameField.getRect().getWidth();
	
	System.out.println(width);
	
	Dimension dimention = nameField.getRect().getDimension();
	
	System.out.println(dimention);
	
	
	//take screenshot of webElement
	
	File file = nameField.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(file, new File("/Users/saikrishna/Documents/SS/screenshot1.png"));
	
	
	
	driver.close();
	
	
	
	}

}
