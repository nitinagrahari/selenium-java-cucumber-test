Feature: Rate and Transit Feature

  Scenario Outline: Calculate FedEx shipping rates
    Given I am on Calculate FedEx shipping rates section
    When I enter shipment information such as <from>, <to>, <packaging>, <no.of packages>, <weight per package>
    And I click on 'SHOW RATES' button
    Then Calculated rates are displayed along with expected delivery date and time

    Examples:
    | from | to | packaging | no.of packages | weight per package |
    | Hoofddorp,2132DD,Netherlands | Arnhem,6827AS,Netherlands | FedEx Box | 1 | 10 |
    | Arnhem,6827AS,Netherlands | Hoofddorp,2132DD,Netherlands | FedEx Box | 1 | 10 |
