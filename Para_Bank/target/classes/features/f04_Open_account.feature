@smoke
  Feature: Search for product in the website
    Scenario: user could search using product name (book,laptop,nike)
      Given navigate to the website
      When Enter a valid data to login to the home page "Tarek vvvvvv" "123456789"
      And Open new account
      Then Assert the account number is displayed