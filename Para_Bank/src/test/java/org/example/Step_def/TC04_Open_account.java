package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_Open_account;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class TC04_Open_account {
    //objects
    P04_Open_account Open_acc = new P04_Open_account();

    @Given("navigate to the website")
    public void navigate_to_the_website() { //open the website
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm;jsessionid=0525B9CB7400C550508FA4641387B8BD");
    }

    @When("Enter a valid data to login to the home page {string} {string}")
    public void enter_a_valid_data_to_login_to_the_home_page(String username ,String password) {
        Open_acc.username().sendKeys(username);
        Open_acc.password().sendKeys(password);
        Open_acc.login_after_username_password().click();
    }
    @And("Open new account")
    public void Open_account(){
        Open_acc.clicking_open_account().click();
        Select dropdown_type = new Select(Open_acc.type_account());
        dropdown_type.selectByIndex(1); // Choose saving_account
        Select dropdown_account = new Select(Open_acc.choose_Account());
        dropdown_account.selectByIndex(0); // Choose first_account
        Open_acc.submit().click();
        System.out.println(driver.getCurrentUrl());
    }
    @Then("Assert the account number is displayed")
    public void Assert_for_account_opening(){
        Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/openaccount.htm"));
    }
}