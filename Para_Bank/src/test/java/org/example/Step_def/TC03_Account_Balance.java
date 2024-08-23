package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_Account_Balance;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.Step_def.Hooks.driver;
public class TC03_Account_Balance {
    //Objects
    P03_Account_Balance Account_Balance = new P03_Account_Balance();

    @Given("go to the website") //open the website
    public void enter_the_url_to_navigate_to_the_website() {
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
    }

    @And("make sure that you enter a valid password and Email to enter to the home page successfully {string} {string}")
    public void login_by_valid_data(String username, String password) {
        Account_Balance.username().sendKeys(username);
        Account_Balance.password().sendKeys(password);
        Account_Balance.login_after_username_password().click();
    }

    @Then("press to overview account balance")
    public void preess_account_balance() {
        Account_Balance.Account_overview().click();
        String Title = Account_Balance.Title().getText();
        Assert.assertTrue(Title.contains("Accounts Overview"));
    }
}
