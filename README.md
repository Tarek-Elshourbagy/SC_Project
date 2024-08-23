# Selenium Test Automation Project
## Overview
This repository contains Selenium test automation scripts written in Java for application:

Para Bank
#### Link :
[Para Bank](https://parabank.parasoft.com/parabank/index.htm)
The project uses Selenium WebDriver for automation and includes both automated test cases and a traditional test plan.
## Project Structure
```
/selenium-test-automation
├── /src
│   ├── /main
│   │   ├── /java
│   │   ├── /resouces
│   │   │   ├── /Features
│   │   │   │   ├── f01_Registration.feature
│   │   │   │   ├── f02_Login.feature
│   │   │   │   ├── f03_View_Account_balance.feature
│   │   │   │   ├── f04_Open_account.feature
│   │   │   │   ├── f05_Tranfer_funds.feature
│   │   │   ├── /WebDriver
│   ├── /test
│   │   ├── /java
│   │   │   ├── /example
│   │   │   │   ├── /Pages
│   │   │   │   │   ├── P01_Register
│   │   │   │   │   ├── P02_login
│   │   │   │   │   ├── P03_Account_Balance
│   │   │   │   │   ├── P04_Open_account
│   │   │   │   │   ├── P05_Tranfer_fund
│   │   │   │   ├── /Step_Def
│   │   │   │   │   ├── Hooks.java
│   │   │   │   │   ├── TC01_Registeration
│   │   │   │   │   ├── TC02_Login
│   │   │   │   │   ├── TC03_Account_Balance
│   │   │   │   │   ├── TC04_Open_account
│   │   │   │   │   ├── TC05_Tranfer_fund
│   │   │   │   ├── /testRunner
│   │   │   │   │   ├── runner
├── pom.xml

```
## Configuration
### WebDriver Configuration HOOKS FILE
Edit the WebDriverConfig.java file to set the path to your WebDriver executable if it’s not in your system’s PATH:

```
package org.example.Step_def;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class Hooks {
    public static ChromeDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","D:\\TESTING\\projects\\Para_Bank\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void quit() {
        driver.quit();
    }
}
```
## Test Cases
### PARA bank using Cucamber to explain the test cases steps
    f01_Registration.feature
    
    f02_Login.feature
    
    f03_View_Account_balance.feature
    
    f04_Open_account.feature
    
    f05_Tranfer_funds.feature
```
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
```
## Page Object Model (POM)
### i used POM creating all locators in one class for each flow
```
package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.Step_def.Hooks.driver;


public class P01_Register {

    public WebElement First_Name (){
        return driver.findElement(By.id("customer.firstName"));
    }
    public WebElement Last_Name (){
            return driver.findElement(By.id("customer.lastName"));
    }
    public WebElement Address (){
            return driver.findElement(By.id("customer.address.street"));
    }
    public WebElement city (){
            return driver.findElement(By.id("customer.address.city"));
    }
    public WebElement state (){
            return driver.findElement(By.id("customer.address.state"));
    }
    public WebElement Username (){
            return driver.findElement(By.id("customer.username"));
    }
    public WebElement zipcode (){
            return driver.findElement(By.id("customer.address.zipCode"));
    }
    public WebElement Phone_number (){
            return driver.findElement(By.id("customer.phoneNumber"));
    }
    public WebElement Ssn (){
            return driver.findElement(By.id("customer.ssn"));
    }
    public WebElement New_password (){
            return driver.findElement(By.id("customer.password"));
    }
    public WebElement Confirm_password (){
            return driver.findElement(By.id("repeatedPassword"));
    }
    public WebElement RegisterIcon_after (){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input"));
    }
    public WebElement Validation_message (){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/h1"));
    }
}
```
### i linked each POM class with main class where we can provide an action with this locators
```
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
```
## Runner
### used to genarate all test cases to run in sequancy
```
package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = {"src/main/resources/features"},
                glue = {"Step_def"},
                tags = "@smoke",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"
                }
        )


public class runner extends AbstractTestNGCucumberTests {

}
```
