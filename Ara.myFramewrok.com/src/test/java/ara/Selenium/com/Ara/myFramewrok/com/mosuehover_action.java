package ara.Selenium.com.Ara.myFramewrok.com;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class mosuehover_action {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ap82\\SendMavenMail\\Drivers\\chromedriver.exe");
		String baseUrl = "http://www.facebook.com/"; 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));

		Actions action = new Actions(driver);
		action.moveToElement(txtUsername).click();
		action.perform();

		}
}
