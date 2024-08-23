package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_Tranfer_fund;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Random;

import static org.example.Step_def.Hooks.driver;

public class TC05_Tranfer_fund {
    //objects
    P05_Tranfer_fund Funds_Transfer = new P05_Tranfer_fund();
    Actions Act = new Actions(driver);
    Random rand = new Random();
    int flag;
    int ramd_no;
    String main_name;

    @Given("move to the website")
    public void move_to_the_website() {
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("Login with valid data {string} {string}")
    public void login_with_valid_data(String username,String password) {
        Funds_Transfer.username().sendKeys(username);
        Funds_Transfer.password().sendKeys(password);
        Funds_Transfer.login_after_username_password().click();
    }

    @And("make the transaction")
    public void make_the_transaction() {
        Funds_Transfer.Funds_Transfer_clicking().click();
        Funds_Transfer.Amount().sendKeys("10");
        Select debit_account = new Select(Funds_Transfer.From_Account());
        debit_account.selectByIndex(0);
        Select Credit_account = new Select(Funds_Transfer.To_Account());
        Credit_account.selectByIndex(0);
        Funds_Transfer.submit().click();
        System.out.println(Funds_Transfer.submit().getText());
    }

    @And("Validate that the transaction resukts dispalyed")
    public void validate_that_the_transaction_resukts_dispalyed() {
        System.out.println(Funds_Transfer.MSG_APPEARED().getText());
    }
}


