Feature:
  TradeMe API tests

  Scenario Outline: Verify availability of "St John" in the list of Charities
    When GET operation is performed to get a list of charities
    Then the status code is <statusCode>
    And the charities list should include <name>
    Examples:
      | statusCode | name      |
      | 200        | "St John" |

  Scenario Outline: Verify attributes of a book listing
    When I send a GET request to retrieve details of a <bookListing>
    Then the status code of the response is 200
    And the listing has "Title"
    And the listing has "Subtitle"
    And the listing has "PriceDisplay"
    And the listing has "Body"
    Examples:
      |bookListing  |
      |2149308160   |
      |2149308855   |
