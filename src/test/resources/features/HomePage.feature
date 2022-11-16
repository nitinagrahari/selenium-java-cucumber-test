Feature: HomePage Features

  Scenario: Ship tab navigation to login page
    Given I am on homepage
    When I click on Ship tab
    Then Application Login Page is displayed

  Scenario: Verify Shipping drop-down options
    Given I am on homepage
    When I open Shipping drop-down
    Then I should see different Shipping options
    | Ship with account |
    | Ship without account |
    | Get Rates & Transit Times |
    | Schedule & Manage Pickups |
    | E-commerce |
    | Returns |
    | Packaging & Shipping Supplies |
    | Shipping Tools |
    | ALL SHIPPING SERVICES |

  Scenario: Change language of the website
    Given I am on homepage
    When I change language to Nederlands
    Then Homepage language should successfully change to Nederland
