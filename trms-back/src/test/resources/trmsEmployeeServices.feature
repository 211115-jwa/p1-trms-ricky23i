Feature: Getting all requests

  Scenario: Employee has requests
    Given the user is on the requests page
    When the user enters a employee id
    Then the approproate information appears

  Scenario: Employee does not have any requests
    Given the user is on the requests page
    When the user enters a incorrect employee id
    Then the appropriate invalid msg should appear
