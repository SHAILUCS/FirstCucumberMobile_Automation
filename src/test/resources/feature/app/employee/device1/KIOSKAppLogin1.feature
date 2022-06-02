
@app # this is only used to display in report
Feature: Amplify KIOSK App Login Feature testing on parallel 1

Background: KIOSK App Brand id is selected
	Given KIOSK App Brand id should be selected and landing screen should be displayed

 	@run
  Scenario: 1.1 Amplify KIOSK App Valid Login
    Given Customer KIOSK Login Screen is opened
    And Perform Employee Login on KIOSK
    
