
@web # this is just for printing in report
Feature: Amplify Customer Login Feature
  I want to use this template for my feature file

  @run
  Scenario: Amplify Customer Valid Login
    Given Customer Login Page is opened
    And Perform Customer Login
    Then Customer Dashboard is displayed
 
  #
  #Scenario: Amplify Customer Invalid Login
    #Given Customer Login Page is opened
    #And Perform Customer Login
    #Then Customer Dashboard is displayed