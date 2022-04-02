# new feature
# Tags: optional

Feature: Shopping cart
  As a user of the page
  I want to add products to the cart
  To make the purchase


  Scenario: successful bank transfer
    Given I am logged into my account
    When I add products to the cart and choose payment by transfer
    Then the system should show successful purchase message