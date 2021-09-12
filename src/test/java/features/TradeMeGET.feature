Feature:
  TradeMe API tests

  Scenario Outline: Verify availability of "St John" in the list of Charities
    When GET operation is performed to get a list of charities
    Then the status code is <statusCode>
    And the charities list should include <name>
    Examples:
      | statusCode | name      |
      | 200        | "St John" |

