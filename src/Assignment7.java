import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment7 {

	public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement selectCheckBox = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input"));
		
		String selectedCheckBoxValue = selectCheckBox.getAttribute("value");
		
		System.out.println(selectedCheckBoxValue); 
		selectCheckBox.click();
		
		
		WebElement staticDropDown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select select = new Select(staticDropDown);
		select.selectByValue(selectedCheckBoxValue);
		
		driver.findElement(By.id("name")).sendKeys(selectedCheckBoxValue);
		driver.findElement(By.id("confirmbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		String confirmOption = alertText.split("Hello")[1].split(",")[0].trim();
		System.out.println(confirmOption);
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(selectedCheckBoxValue,confirmOption);
		
		
				
		
		
		

	}

}
