@smoke
Feature: Login_ user could login to the system with valid account
  Scenario: Valid login
    Given Navigate to URL website
    When Enter email and password "Tarek vvvvvv" "123456789"
    And Click on login icon
    Then Verify that the user had login successfully

  Scenario: inValid login
    Given Navigate to URL website
    When Enter invalid email and password
    And Click on login icon
    Then Verify that the user had not login successfully

  Scenario: Empty login
    Given Navigate to URL website
    When Enter Empty email and password
    And Click on login icon
    Then Verify that the empty user had not login successfully