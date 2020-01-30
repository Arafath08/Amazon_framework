package ara.Selenium.com.Ara.myFramewrok.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallelexecution {
    @Test(threadPoolSize=5,invocationCount=1)    
    public void atest(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("http://demo.guru99.com/V4/");
            //find user name text box and fill it
            driver.findElement(By.name("uid")).sendKeys("Driver 1");
            System.out.println("Driver 1");
            System.out.println("Test Case One with Thread Id:- "
    				+ Thread.currentThread().getId());
            
        }
        
    @Test(priority=0)  
        public void btest(){
            //Second session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 2");
        System.out.println("Driver 2");
        System.out.println("Test Case Two with Thread Id:- "
				+ Thread.currentThread().getId());
        
        }
        
    @Test(priority=0) 
        public void ctest(){
            //Third session of WebDriver
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 3");
        System.out.println("Driver 3");
        System.out.println("Test Case Three with Thread Id:- "
				+ Thread.currentThread().getId());
        
        }  
    @Test(priority=0) 
    	public void dtest(){
        //Third session of WebDriver
    	System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        //Goto guru99 site
    	driver.get("http://demo.guru99.com/V4/");
    	//find user name text box and fill it
    	driver.findElement(By.name("uid")).sendKeys("Driver 4");
    	System.out.println("Driver 4");
    	System.out.println("Test Case Four with Thread Id:- "
				+ Thread.currentThread().getId());
    
    }  
    
    @Test(priority=0) 
	public void etest(){
    //Third session of WebDriver
	System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    //Goto guru99 site
	driver.get("http://demo.guru99.com/V4/");
	//find user name text box and fill it
	driver.findElement(By.name("uid")).sendKeys("Driver 5");
	System.out.println("Driver 5");
	System.out.println("Test Case Five with Thread Id:- "
			+ Thread.currentThread().getId());

}    
}
