import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsvsForLoop {

	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> listOfItems = driver.findElements(By.xpath("//tr/td[1]"));
		
		
		ArrayList<String> myList = new ArrayList<>();

		for (int i = 0; i < listOfItems.size(); i++) {

			String itemName = listOfItems.get(i).getText();

			myList.add(itemName);

		}
		
		
		
		
		
	List<String> newStreamList=	myList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(myList, newStreamList);
		
		System.out.println(newStreamList);
		

	}

}
