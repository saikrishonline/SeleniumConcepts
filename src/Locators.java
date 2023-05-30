import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Locators {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("sai.vaidhyula@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("pass123");
		driver.findElement(By.className("submit")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sai"); //using xpath Tagname
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sai@sai24tech.com"); //using cssSelector tagname
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("sai@sai24Tech.com"); //using xpath tag name with index
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0970829028"); //using xpath traverse method from parent to child index
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click(); 
		
		String password = getPassword(driver);
		
		
		//using css traverse method from parent to child
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); //using xpath traverse using parent class name
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Sai");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//div/span/input[1]")).click();
		driver.findElement(By.xpath("//button[contains (@class,'submit')]")).click();
		
		
	
		//post login..
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	System.out.println(driver.findElement(By.tagName("p")).getText()); 	
		
	Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
	driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	
	driver.close();
	
	
	
	}
	
	public static String getPassword(WebDriver driver) {
		
		
		String resetPasswordText = (driver.findElement(By.cssSelector(("form p"))).getText());
		
		String password = resetPasswordText.split("'")[1].split("'")[0];
		
		
		System.out.println("Temp password is: "+password);
		
		
		
		return password;
		
		
		
	}

}
