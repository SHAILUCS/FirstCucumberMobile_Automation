
@app # this is only used to display in report
Feature: Amplify Customer App Login Feature testing on parallel 2

  @run
  Scenario: 2.1 Amplify Customer App Valid Login
    Given Customer App Login Screen is opened
    And Perform Customer App Login
    Then Customer App Dashboard is displayed
    
  @run
  Scenario: 2.2 Amplify Customer App Valid Login
    Given Customer App Login Screen is opened
    And Perform Customer App Login
    Then Customer App Dashboard is displayed
