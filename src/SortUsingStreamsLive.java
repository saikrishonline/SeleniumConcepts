import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortUsingStreamsLive {

	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers/");
		
		driver.findElement(By.xpath("//tr/th[1]")).click(); //This will sort the list in ascending order
		
		List<WebElement> myList1 = driver.findElements(By.xpath("//tr/td[1]")); //collecting all the items in the list
		
		List<String> newList =	myList1.stream().map(s->s.getText()).collect(Collectors.toList()); // getting the text of the list and assigning to the new List

		
		System.out.println(newList);
		
		List<String> newStreamList=	newList.stream().sorted().collect(Collectors.toList()); //sorting the original list and assigning to new List
		
		Assert.assertEquals(newList, newStreamList); //comparing the collections
		//Assert.assertTrue(newList.equals(newStreamList));
		
		System.out.println(newStreamList);
		
		
	//	Requirement::: to find the price of the given Veggie.
		
		//Take all veggies list
		//filter the veggies to get the text of only "Beans"
		//Use map operator and create custom function to find the price of the beans
		//collect the result into a list
		
		
		List<String> price;
		
		
		do {
		List<WebElement> myList = driver.findElements(By.xpath("//tr/td[1]"));	
		price = myList.stream().filter(s->s.getText().contains("Wheat")).map(s->getPrice(s)).collect(Collectors.toList());	
		price.forEach(s->System.out.println(s));
		System.out.println(price.size()); 
		
			if(!(price.size()>0)) {
			
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
				
			} 
		
			}while(!(price.size()>0));
		
		
		

	}

	private static String getPrice(WebElement s) {
		
		String cost = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		
		return cost;
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
