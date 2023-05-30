import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLHandlers {

	public static void main(String[] args) {
		
		ChromeOptions ch = new ChromeOptions();
	//	ch.setAcceptInsecureCerts(true);
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver(ch);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
		
		
		
	}

}
