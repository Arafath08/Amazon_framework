Feature: Free CRM Login With Examples

  #Logging in Using Scenario Outline - Achieving Data Driven Approach
  #Taking UserName and Password from Feature file
  Scenario Outline: Free CRM Login Test Scenario
  Given User is should be on Login Page
  When Title of login page should be verified
  Then User enters "<Username>" and "<Password>" and clicks on login button
  Then User should be on home page

  Examples: 
      | Username   | Password  |
      | pavanreddy | Saibaba77 |
      | pavanreddy | Saibaba77 |
