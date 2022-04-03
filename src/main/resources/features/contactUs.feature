
# language: en
@FeatureName:contactUsValidation
Feature: contact Us
  As a user of the page
  I want to contact customer service
  To request information about a product


  @ScenarioName:contactUs
  Scenario: ContactUs Successful
  Given I am in the contact us section
    When fill in the required fields correctly
    Then A successful delivery message should be displayed.
