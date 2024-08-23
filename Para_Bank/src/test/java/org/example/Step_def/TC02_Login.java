package org.example.Step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.Assert;
import static org.example.Step_def.Hooks.driver;
public class TC02_Login {
    P02_login Login = new P02_login();
    @Given("Navigate to URL website")
    public void navigation(){
        // Navigate to URL
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
    }
    @When("Enter email and password {string} {string}")
    public void valid_email_password(String email ,String password){
        //valid username
        Login.username().sendKeys(email);
        //valid password
        Login.password().sendKeys(password);
    }
    @Then("Verify that the user had login successfully")
    public void success_msg(){
        String new_URL = driver.getCurrentUrl();
        System.out.println("URL : "+ new_URL);
        Assert.assertTrue(new_URL.contains("https://parabank.parasoft.com/parabank/overview.htm"));
    }
    @When ("Enter Empty email and password")
    public void  empty_mail_password(){
        //empty mail
        Login.username().sendKeys("");
        //empty password
        Login.password().sendKeys("");
    }
    @When ("Enter invalid email and password")
    public void  invalid_mail_password(){
        //empty mail
        Login.username().sendKeys("VYVY");
        //empty password
        Login.password().sendKeys("1111NY1");
    }
    @And("Click on login icon")
    public void Clicking_login(){
        // click on login icon after enter username and password
        Login.login_after_username_password().click();
    }

    @Then("Verify that the user had not login successfully")
    public void Login_incorrect_data_insuccess(){
        Assert.assertTrue(Login.invalidation_ERROR_massage().isDisplayed());
    }
    @Then("Verify that the empty user had not login successfully")
    public void Login_empty_insuccess(){
        String Error_msg =Login.invalidation_ERROR_massage().getText();
        Assert.assertTrue(Error_msg.contains("Please enter a username and password."));
    }
}
