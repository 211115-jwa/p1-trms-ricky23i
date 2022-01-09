Feature: Request Management

 
  Scenario: Employee has pending requests
    Given the user is on the request management page
    When the user enters a  correct employee id
		Then the approproate alert appears

  Scenario: Employee does not exist
    Given the user is on the request management page
    When the user enters a invalid employee id
		Then the appropriate error alert appears

		Scenario: Request exists
    Given the user is on the request management page
    When the user enters a request id plus selects role
		Then the approproate alert approved
		
		Scenario: Request does not exists
    Given the user is on the request management page
    When the user enters a incorrect request id plus selects role
		Then the appropriate error alert appears
		