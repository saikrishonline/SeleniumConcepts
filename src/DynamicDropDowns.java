import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDowns {

	public static void main(String[] args) {
	
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//div/input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		//driver.findElement(By.xpath("//div/input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		
		//driver.findElement(By.xpath("//div/input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']/following-sibling::div[1]/div/table/tbody/tr[2]/td/div[3]/div/div/ul/li/a[@value='BHO']")).click();
		
		driver.findElement(By.xpath("//td[@class='mapbg'] //a[@value='BLR']")).click();

		
	//	driver.quit();
		
		//(a[@value='AIP'])[2]
	

	}

}
