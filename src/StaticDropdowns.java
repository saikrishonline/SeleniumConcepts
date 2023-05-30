import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdowns {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement webelement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//DropDown with select tag
		
		Select dropDown = new Select(webelement);
		dropDown.selectByIndex(1);
	System.out.println(dropDown.getFirstSelectedOption().getText());
	    dropDown.selectByValue("AED");
	    System.out.println(dropDown.getFirstSelectedOption().getText());
	    dropDown.selectByVisibleText("USD");
	    System.out.println(dropDown.getFirstSelectedOption().getText());
	    
	}

}
