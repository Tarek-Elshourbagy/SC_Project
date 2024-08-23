package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.net.URL;
import java.sql.SQLOutput;

import static org.example.Step_def.Hooks.driver;
public class TC01_Registeration {
    String username = "Tarek Elshourbagy";
    P01_Register registeration = new P01_Register();

    @Given("Enter the URL to navigate to the website") //open the website
    public void enter_the_url_to_navigate_to_the_website() {
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm;jsessionid=0525B9CB7400C550508FA4641387B8BD");
    }

    @When("Press for icon register to Create new account to go to the sign up page") //press on register icon before
    public void press_for_icon_create_new_account_to_go_to_the_sign_up_page() {
        driver.navigate().to("https://parabank.parasoft.com/parabank/register.htm");
    }

    @And("Enter the first name {string}") //choose your first name
    public void enter_the_first_name(String m) {
        registeration.First_Name().sendKeys(m);
    }

    @And("Enter the last name {string}") //choose your last name
    public void enter_the_last_name(String last) {
        registeration.Last_Name().sendKeys(last);
    }

    @And("Enter your Address {string}") //valid Address
    public void enter_your_address(String address) {
        registeration.Address().sendKeys(address);
    }

    @And("Enter your city {string}") //enter your city
    public void enter_company_name(String city) {
        registeration.city().sendKeys(city);
    }

    @And("Enter your State {string}") //enter your state
    public void Click_on_newsletter(String state) {
        registeration.state().sendKeys(state);
    }

    @And("Enter Zipcode {string}") //enter zip code
    public void Enter_Zipcode(String zipcode) {
        registeration.zipcode().sendKeys(zipcode);
    }

    @And("Enter phone number {string}") //Enter phone number
    public void Enter_phone_number(String phone) {
        registeration.Phone_number().sendKeys(phone);
    }

    @And("Enter S SN {string}") //Enter S SN
    public void Enter_SC_CODE(String S_CODE) {
        registeration.Ssn().sendKeys(S_CODE);
    }

    @And("Enter Username") //Enter Username
    public void Enter_Username() {
        registeration.Username().sendKeys(username);
    }

    @And("Enter a new valid password {string}") // enter your valid password
    public void enter_a_new_valid_password(String password) {
        registeration.New_password().sendKeys(password);
        registeration.Confirm_password().sendKeys(password);
    }

    @Then("Press on register icon to go for the next page") //clicking on register icon after
    public void registeration_icon() {
        registeration.RegisterIcon_after().click();
    }
    @And ("click om signin to go to home page of the website will open successfully") //check the validation by color of message
    public void click_om_signin_to_go_to_home_page_of_the_website_will_open_successfully() {
        String URl = driver.getCurrentUrl();
        Assert.assertTrue(URl.contains("https://parabank.parasoft.com/parabank/register.htm"));
        String MSG = registeration.Validation_message().getText();
        Assert.assertTrue(MSG.contains("Welcome "+username));
    }
}
