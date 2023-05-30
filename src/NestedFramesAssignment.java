import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesAssignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");

		driver.switchTo().defaultContent();

		WebElement frame2 = driver.findElement(By.tagName("frameset")).findElements(By.tagName("frame")).get(0);

		driver.switchTo().frame(frame2);

		driver.switchTo().frame(driver.findElement(By.tagName("frameset")).findElements(By.tagName("frame")).get(1));

		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());

		driver.switchTo().defaultContent();

		driver.close();

	}

}
