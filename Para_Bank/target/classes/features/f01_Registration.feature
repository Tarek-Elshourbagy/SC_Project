@smoke
Feature: Registration for the new user to create new account
  Scenario: Enter all valid data (user name, password, phone number, first name, last name)
    Given Enter the URL to navigate to the website
    When Press for icon register to Create new account to go to the sign up page
    And Enter the first name "tarek"
    And Enter the last name "sameh"
    And Enter your Address "Maadi"
    And Enter your city "Maadi"
    And Enter your State "Cairo"
    And Enter Zipcode "11728"
    And Enter phone number "1122334455"
    And Enter S SN "1177"
    And Enter Username
    And Enter a new valid password "123456789"
    Then Press on register icon to go for the next page
    And  click om signin to go to home page of the website will open successfully





