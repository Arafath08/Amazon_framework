package ara.Selenium.com.Ara.myFramewrok.com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.BaseClass.TestBase;
import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase{

	
	LoginPage loginpage;
	HomePage homepage;//global variable
	
	public LoginPageTest() {
		super();
		}
	@BeforeMethod
	public void setup() {
		initialization();
		
		 loginpage = new LoginPage();
		
	}
	
	
	/*@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	@Test(priority=2)
	public void validateamazonlogoImage() {
		
		boolean flag=loginpage.validateamazonlogoImage();
		Assert.assertTrue(flag);
	}*/
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException {
		
	  homepage=loginpage.login(property.getProperty("Username"),property.getProperty("Password"));
	  loginpage.validateuser();
	  loginpage.innerframes();
	  
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
