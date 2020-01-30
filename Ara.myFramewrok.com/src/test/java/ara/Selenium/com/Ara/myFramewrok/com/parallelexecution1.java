package ara.Selenium.com.Ara.myFramewrok.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelexecution1 {
	//@Test(threadPoolSize=5,invocationCount=5)   
	@Test
    public void atest(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("https://www.google.com/");
            //find user name text box and fill it
            driver.findElement(By.name("q")).sendKeys("Driver 1");
            System.out.println("Driver 1");
            System.out.println("Test Case One with Thread Id:- "
    				+ Thread.currentThread().getId());
            driver.quit();
        }
	@Test
	//@Test(priority=2)   
    public void btest(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("https://www.google.com/");
            //find user name text box and fill it
            driver.findElement(By.name("q")).sendKeys("Driver 2");
            System.out.println("Driver 2");
            System.out.println("Test Case One with Thread Id:- "
    				+ Thread.currentThread().getId());
            driver.quit();
}
	@Test
	//@Test(priority=1)   
    public void ctest(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("https://www.google.com/");
            //find user name text box and fill it
            driver.findElement(By.name("q")).sendKeys("Driver 3");
            System.out.println("Driver 3");
            System.out.println("Test Case One with Thread Id:- "
    				+ Thread.currentThread().getId());
            driver.quit();
}
	@Test
	//@Test(priority=0)   
    public void dtest(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("https://www.google.com/");
            //find user name text box and fill it
            driver.findElement(By.name("q")).sendKeys("Driver 4");
            System.out.println("Driver 4");
            System.out.println("Test Case One with Thread Id:- "
    				+ Thread.currentThread().getId());
            driver.quit();

	}
}
