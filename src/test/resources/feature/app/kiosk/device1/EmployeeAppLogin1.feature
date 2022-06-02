
@app # this is only used to display in report
Feature: Amplify Employee App Login Feature testing on parallel 1

Background: Employee App Brand id is selected
	Given Employee App Brand id should be selected and landing screen should be displayed

 	@run
  Scenario: 1.1 Amplify Employee App Valid Login
    Given Employee App Login Screen is opened
    And Perform Employee Login on Employee App