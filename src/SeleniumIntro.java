import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro   {

	public static void main(String[] args) {
		
		//set chromedriver path
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		//instantiate webdriver class
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.google.com");
		System.out.println(driver.getCurrentUrl()); 
		driver.getPageSource();
		driver.quit();
		

	}

}
