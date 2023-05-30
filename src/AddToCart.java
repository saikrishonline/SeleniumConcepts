import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.Assert;

public class AddToCart {
	
	private static Logger log = LogManager.getLogger(AddToCart.class.getName());

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		

		// create array to store the list of items to add

		String[] itemsNeeded = { "Cucumber", "Brocolli" };

		addItemsToCart(driver,itemsNeeded);
		
}
	
	
	public static void addItemsToCart(WebDriver driver, String[] itemsNeeded) {
		
		// get all the list of product names...
		List<WebElement> VeggiesList = driver.findElements(By.cssSelector("h4.product-name"));
		log.debug("getting all the veggie list and assigning to List Webelement");

		// Covert the array to ArrayList for easy code management.
		List itemsNeededAL = Arrays.asList(itemsNeeded);
		System.out.println("ArrayListSize" + itemsNeededAL.size());

		// iterate and check if the product matches with the desired item and click
		int j = 0;
		for (int i = 0; i < VeggiesList.size(); i++) {

			String[] productName = VeggiesList.get(i).getText().split("-");

			String trimmedProductName = productName[0].trim();
			System.out.println(trimmedProductName);

			if (itemsNeededAL.contains(trimmedProductName)) {
				
				log.debug("product name matched with user provided Array list. inside if Condition");
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

				j++;
				if (j == itemsNeededAL.size()) {
					break;
				}

			}

		}
		
		//explicit wait ....
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			
		//checkout feature
		
			driver.findElement(By.cssSelector("img[alt='Cart']")).click();
			driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
			
		
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("button[class='promoBtn']")));
		//Apply promocode	
			driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
			log.info("Passed the promo code");
			driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
			log.info("Clicked the promo button");
			
			
			
			
			
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='promoInfo']")));
			//explicit wait...
			
			String appliedCodeStatus = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
			Assert.assertEquals(appliedCodeStatus, "Code applied ..!");
			
			driver.findElement(By.xpath("//div/following-sibling::button[1]")).click();
			
			WebElement getCountries = driver.findElement(By.cssSelector("select"));
			Select select = new Select(getCountries);
			select.selectByValue("India");
			
/*	 Alternate approach using "for" loop	
 
// List<WebElement> getCountryList = driver.findElements(By.xpath("//div/select/option"));
//			
//			for(WebElement getCountry: getCountryList ) {
//				
//				getCountry.findElement(By.xpath("//div/select/option[@value='India']")).click();
//	
//			}
	
*/				
				
			driver.findElement(By.className("chkAgree")).click();
			
			if(driver.findElement(By.className("chkAgree")).isSelected()) {
				
				
				driver.findElement(By.xpath("//div/button")).click();
				
				log.info("Clicked the submit button");
			}
			
			
			}
			
			
			
	}


