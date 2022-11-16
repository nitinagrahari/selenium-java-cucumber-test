Feature: Track Shipment Feature

  #Mostly Negative scenarios are covered here as we dont have valid tracking Id to track
  Scenario Outline: Track shipment with invalid tracking id
    Given I am on Track Shipment section
    When I track invalid tracking id <trackingID>
    Then I can see error message
    Examples:
      | trackingID |
      | 98745612   |

    Scenario Outline: Track multiple Shipment with Invalid tracking IDs
      Given I am on Track Shipment section
      When I track multiple invalid tracking ids
        | 98745612 |
        | 123456 |
        | 7654321 |
      Then I can see error message <error message> for multiple invalid tracking numbers
      Examples:
        | error message |
        | No information for the following shipments/FedEx Office orders has been received by our system yet |


    Scenario Outline: Track shipment with invalid tracking id from Grid menu on homepage
      Given I came to track shipment section from the grid menu-Tracking
      When I track invalid tracking id from grid menu <trackingID>
      Then I can see error message
      Examples:
        | trackingID |
        | 98745612   |