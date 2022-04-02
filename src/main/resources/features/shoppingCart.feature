
# language: en
@FeatureName:shoppinCart
Feature: Shopping cart
  As a user of the page
  I want to add products to the cart
  To make the purchase

  @ScenarioName:bankTransferValidation
  Scenario: successful bank transfer
    Given I am logged into my account
    When I add products to the cart and choose payment by transfer
    Then the system should show successful purchase message


  @ScenarioName:checkPaymentValidation
  Scenario: successful check payment
    Given I am making a purchase
    When I choose payment by check
    Then the system should allow successful purchase