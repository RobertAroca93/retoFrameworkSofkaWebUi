
# language: en
@FeatureName:createAnAccount
Feature: : Create new account
  As a possible user of the page
  I want to create an account
  to be able to make purchases online.

  @ScenarioName:createAnAccount
  Scenario: Create a successful account
    Given  that the client is on the registration page
    When  the customer enters their data to create an online account
    Then  As a result, the user will be logged into their respective session.