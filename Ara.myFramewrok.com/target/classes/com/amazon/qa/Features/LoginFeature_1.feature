Feature: Free CRM Login Without Examples

  #Without Examples Keyword
  #Logging in Normally - Taking UserName and Password from Property file
  Scenario: Free CRM Login Test Scenario
  Given User is already on Login Page
  When Title of login page is Free CRM
  Then User enters username and password and click on login button
  Then User is on home page
  
