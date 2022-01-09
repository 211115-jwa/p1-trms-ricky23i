Feature: Submitting a request


  Scenario: Employee exists
 	Given the user is on the reimbursement request submission page
 	When the user enters the information in all fields
 	Then the messaged submitted apppears

 	Scenario: Employee does not exists
 	Given the user is on the reimbursement request submission page
 	When the user enters the information in all fields incorrectly
 	Then the appropriate error message should appear
