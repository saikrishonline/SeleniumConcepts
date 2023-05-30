import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.name("name"));

		String labelName = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(labelName);
		
		//WebElement passwordLabel = driver.findElement(By.xpath("//div/label[@for='exampleInputPassword1']"));
		WebElement dobLabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		
		//label[@for='dateofBirth']
		
		driver.findElement(with(By.tagName("input")).below(dobLabel)).sendKeys("12/01/2004");
		
	}

}
