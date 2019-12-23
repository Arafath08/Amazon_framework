package com.amazon.qa.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.amazon.qa.BaseClass.TestBase;
import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginTestCase_1 extends TestBase
{
	WebDriver driver;
	LoginPage login;
	HomePage homePage;
	
	@Given("^User is already on Login Page$")
	public void user_is_already_on_Login_Page() throws Throwable
	{
		initialization();
		Log.info("Browser Launched Successfully");
	}

	@When("^Title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable 
	{
		login = new LoginPage();
		String loginPageTitle = login.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Log.info("Login Page Title Verified");
	}

	@Then("^User enters username and password and click on login button$")
	public void user_enters_username_and_password() throws Throwable 
	{
		login.login(property.getProperty("Username"), property.getProperty("Password"));
		Log.info("Successfully Logged into CRM Application");
	}

	@Then("^User is on home page$")
	public void user_is_on_home_page() throws Throwable 
	{
		homePage = new HomePage();
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"); 
		Log.info("User is on Home Page");
	}
}
