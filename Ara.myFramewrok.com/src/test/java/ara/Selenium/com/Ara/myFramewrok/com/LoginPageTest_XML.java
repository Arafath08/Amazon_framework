package ara.Selenium.com.Ara.myFramewrok.com;		
import java.io.*;		
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.dom4j.*;		
import org.dom4j.io.SAXReader;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;		

public class LoginPageTest_XML {				
										
// Creating WebDriver Instance		
	 WebDriver driver;
	 @BeforeClass
	    public void startBrowser()
	    {
	/*System.setProperty("webdriver.chrome.driver","C:\\Users\\ap82\\Ara.myFramewrok.com\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();*/
	    	System.out.println("===== browser started======");
	    }
    
	 @Test
	 public void startApp() throws DocumentException {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\ap82\\Ara.myFramewrok.com\\Drivers\\chromedriver.exe");					
    driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.get("https://www.primevideo.com/ref=av_flex");					
    driver.manage().window().maximize();			
// Reading XML File    		
    File inputFile = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\amazon\\qa\\Configuration\\Newconfig.xml");									
    SAXReader saxReader = new SAXReader();					
    Document document = saxReader.read(inputFile);							
    String signin = document.selectSingleNode("//menu/signin").getText();							
    String emailTextBox = document.selectSingleNode("//menu/email").getText();							
    String passwordTextBox = document.selectSingleNode("//menu/password").getText();
    String submit = document.selectSingleNode("//menu/submit").getText();
    System.out.println(signin+"--"+emailTextBox+"--"+passwordTextBox);
    
    String username1 = document.selectSingleNode("//menu/username1").getText();
    String password1 = document.selectSingleNode("//menu/password1").getText();
    System.out.println(username1+password1);
    

//Navigating to Mobile Testing and back		
    driver.findElement(By.xpath(signin)).click();					
    //driver.navigate().back();			
//Entering Form Data
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath(emailTextBox)).sendKeys(username1);
    driver.findElement(By.xpath(passwordTextBox)).sendKeys(password1);
    driver.findElement(By.xpath(submit)).click();
    driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//a[1]")).click();

    
    List<WebElement> myList=driver.findElements(By.xpath("//div[@class='av-grid-wrapper']//a[@class='av-beard-title-link']"));
    //myList contains all the web elements
    //if you want to get all elements text into array list
 
    List<String> all_elements_text=new ArrayList<String>();
    System.out.println(myList.size());

    for(int i=0; i<myList.size(); i++){

        //loading text of each element in to array all_elements_text
        all_elements_text.add(myList.get(i).getText());
       
        //to print directly
        System.out.println(myList.get(i).getText());
       //System.out.println(myList.size()); //list size= 1
       

}
	 }
	 @AfterClass
	 public void closeBrowser()
		{
			
		   // driver.quit();
			System.out.println("===== browser closed======");
		}
		
	 
	}		
		