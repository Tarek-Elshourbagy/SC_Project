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
