import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AngularPractice {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.xpath("(//input[contains(@class, 'ng-invalid')])[1]")).sendKeys("Sai Krishna");
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("saikrishna@sai.com");
		
		driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys("12345");
		
		if(driver.findElement(By.id("exampleCheck1")).isSelected()==false) {
			
			driver.findElement(By.id("exampleCheck1")).click();
			
		}
		
		WebElement selectGender = driver.findElement(By.cssSelector("select[id='exampleFormControlSelect1']"));
		
		
		Select select = new Select(selectGender);
		
		select.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		
		if(driver.findElement(By.cssSelector("input[value='option3'")).isDisplayed()) {
			
			
			System.out.println("Radio button is disabled!");
		}
			
			driver.findElement(By.xpath("//div/input[@name='bday']")).sendKeys("24/01/1993");
			
			driver.findElement(By.cssSelector("input[value='Submit'")).click();
			
			System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText()); 
			
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText(),"Success! The Form has been submitted successfully!.");
		
		

	}

}
