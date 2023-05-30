import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		
		List<WebElement> checkUrls = driver.findElements(By.cssSelector("div[id='gf-BIG'] a"));
		SoftAssert sa = new SoftAssert();
		
	
		
		for(WebElement eachURL:checkUrls){
			
			String url = eachURL.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode =	conn.getResponseCode();
			System.out.println(respCode);
			
			sa.assertTrue(respCode<400, "Response of URL " + eachURL.getText() + "is Broken with code::" +respCode);
		
			
		}
		
		sa.assertAll();
				
		
	}

}
