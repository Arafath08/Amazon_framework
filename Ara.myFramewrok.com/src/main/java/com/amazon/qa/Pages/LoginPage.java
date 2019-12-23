package com.amazon.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.qa.BaseClass.TestBase;
import com.amazon.qa.Utilities.TestUtility;




public class LoginPage extends TestBase 
{
	//Page Factory or Object Repository Where we store all WebElements.
	//@FindBy will automatically do => driver.findElement(By.name(""));
	@FindBy(xpath="//span[contains(text(),'Hello. Sign in')]")
	WebElement Hellosignin0_btn;
	
	@FindBy(xpath="//span[contains(text(),'Hello, Arafath')]")
	WebElement Helloarafath;
	
	
	@FindBy(xpath="//div[contains(text(),'Sign In')]")
	WebElement signin0_btn;
	
	
	@FindBy(xpath="//i[@class='hm-icon nav-sprite']")
	WebElement sideoption_btn;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-logo']")
	WebElement amazonloginpagelogo;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//input[@id='ap_password']") //Custom XPath We are Using here
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signin_submit_btn;
	
	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement AmazonLogo;
	
	
	@FindBy(xpath="//span[contains(text(),'Hello, Arafath')]")
	WebElement Hello_user;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement Globalsearch;
	
	@FindBy(xpath="//img[@src='https://m.media-amazon.com/images/I/51qayzevaYL._AC_UL320_ML1_.jpg']")
	WebElement clickproduct;
	
	
	//Initializing [Page Objects] all Object Repositories Elements with help of Page Factory in Constructor
	//We initialize Page Factory Using initElements(driver, this) //This refers to Current Class Object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Verify the Title of the Login Page
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void  validateuser()
	{
		  String variable = "";
		  highlight(driver,Helloarafath);
		   variable = Helloarafath.getText();
		  System.out.println("*********"+variable);
		  String variable1 = "Hello, Arafath";
		  Assert.assertEquals(variable, "Hello, Arafath");
		  if(variable.equalsIgnoreCase(variable1) ) {
			  System.out.println("valid user is displayed");
		  }else
		  {
			  System.out.println("valid user is not displayed");
		  }
		  
	}
	
	public void  innerframes() throws InterruptedException {
	int size = driver.findElements(By.tagName("iframe")).size();
    System.out.println("Total Frames --" + size);
    
	}
	
	public boolean validateAmazonloginpageImage()
	{
		return amazonloginpagelogo.isDisplayed(); //It will return True Or False if the Logo is Present Or No.
	}
	
	public boolean validateamazonlogoImage()
	{
		highlight(driver,AmazonLogo);
		return AmazonLogo.isDisplayed(); //It will return True Or False if the Logo is Present Or No.
	}
	
	public HomePage login(String uname,String pword)
	{
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Hellosignin0_btn);*/
		sideoption_btn.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", signin0_btn);
		highlight(driver,signin0_btn);
		js.executeScript("arguments[0].click();", signin0_btn);
		
		highlight(driver,phonenumber);
		phonenumber.sendKeys(uname);
		highlight(driver,continuebtn);
		continuebtn.click();
		
		highlight(driver,password);
		password.sendKeys(pword);
		highlight(driver,signin_submit_btn);
		signin_submit_btn.click();
		

		highlight(driver,AmazonLogo);
		TestUtility.DisplayedElement1(driver,AmazonLogo);
		
		
				
		return new HomePage(); //Since Login Page is Landing on HomePage
		
		 
		
	}
}

