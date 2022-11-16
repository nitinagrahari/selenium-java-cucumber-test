Feature: Shipping Feature

  # This scenario is tested till payment section page is displayed. Further steps cannot be added in lack of test data.
  Scenario: Ship without account
    Given I am on FedEx Ship Manager Lite page
    When I provide from address details
    | Name | Country | Address | Postal code | City | Phone |
    | DummySenderName | Netherlands | Marktplein | 2132 DD | HOOFDDORP | 0613996439 |
    And I provide to address details
    | Name | Country | Address | Postal code | City | Phone | IsResidentialAddress |
    | DummyRecieverName | Netherlands | Westervoortsedijk | 6827 AS | ARNHEM | 0613996439 | Yes |
    And I provide Shipment details
    | Package Type | Package Weight | Ship Date |
    | FedEx Box    | 2              | 14-Nov-2022 |
    And I click on Continue button on shipment details section
    Then Payment Section is displayed


