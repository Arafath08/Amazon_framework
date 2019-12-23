package com.amazon.qa.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.amazon.qa.BaseClass.TestBase;
import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestCase_2 extends TestBase
{
	WebDriver driver;
	LoginPage login;
	HomePage homePage;
	
	@Given("^User is should be on Login Page$")
	public void user_is_already_on_Login_Page() throws Throwable
	{
		initialization();
		Log.info("Browser Launched Successfully");
	}

	@When("^Title of login page should be verified$")
	public void title_of_login_page_is_Free_CRM() throws Throwable 
	{
		login = new LoginPage();
		String loginPageTitle = login.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		Log.info("Login Page Title Verified");
	}

	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\" and clicks on login button$")
	public void user_enters_and_and_click_on_login_button(String Username, String Password) throws Throwable 
	{
		login.login(Username, Password);
		Log.info("Successfully Logged into CRM Application");
	}

	@Then("^User should be on home page$")
	public void user_is_on_home_page() throws Throwable 
	{
		homePage = new HomePage();
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO"); 
		Log.info("User is on Home Page");
	}
}
