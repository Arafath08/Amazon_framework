package com.amazon.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.BaseClass.TestBase;



public class HomePage extends TestBase
{
	
	@FindBy(xpath="//span[contains(text(),'Hello, Arafath')]")
	@CacheLookup
	WebElement Hello_user;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement Globalsearch;
	
	@FindBy(xpath="//img[@src='https://m.media-amazon.com/images/I/51qayzevaYL._AC_UL320_ML1_.jpg']")
	WebElement clickproduct;
	
	
	
	@FindBy(xpath="//i[@class='hm-icon nav-sprite']")
	WebElement option_btn;
	
	@FindBy(xpath="//div[contains(text(),'Your Orders')]")
	WebElement Yourorder;
	
	@FindBy(xpath="//a[@class='hmenu-item']//div[contains(text(),'Lists')]")
	WebElement Lists;
	

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName()
	{
		return Hello_user.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	/*public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();    
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}*/
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		option_btn.click();
		action.moveToElement(option_btn).build().perform();
		
	}
}
