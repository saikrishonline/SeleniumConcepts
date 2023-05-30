import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterUsingStreams {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
		
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredVeggieList = veggies.stream().filter(v->v.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies, filteredVeggieList);
		
	}

}
