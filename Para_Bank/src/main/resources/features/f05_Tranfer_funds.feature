@smoke
  Feature: Make funds transfer between to account
    Scenario: Make funds transfer between to account
      Given move to the website
      When Login with valid data "Tarek Elshourbagy" "123456789"
      And make the transaction
      And Validate that the transaction resukts dispalyed
