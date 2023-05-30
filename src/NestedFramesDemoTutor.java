


import java.util.Iterator;

import java.util.List;

import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesDemoTutor {

public static void main(String[] args) {



System.setProperty("webdriver.chrome.driver", "/Users/saikrishna/Documents/ChromeDriver/chromedriver");

WebDriver driver=new ChromeDriver();

driver.get("http://the-internet.herokuapp.com/");

driver.findElement(By.linkText("Nested Frames")).click();

driver.switchTo().frame("frame-top");

driver.switchTo().frame("frame-middle");

System.out.println(driver.findElement(By.id("content")).getText());

}
}
