package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P05_Tranfer_fund {
    public WebElement username(){ //Username

        return driver.findElement(By.name("username"));
    }
    public WebElement password(){ //password
        return driver.findElement(By.name("password"));
    }
    public WebElement login_after_username_password() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
    }
    public WebElement Funds_Transfer_clicking(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[3]/a"));
    }
     public WebElement Amount(){
        return driver.findElement(By.id("amount"));
    }
    public WebElement From_Account(){
        return driver.findElement(By.id("fromAccountId"));
    }
    public WebElement To_Account(){
        return driver.findElement(By.id("toAccountId"));
    }
    public WebElement submit() {
        return driver.findElement(By.cssSelector("input[type='submit'].button"));
    }
    public WebElement MSG_APPEARED(){
        return driver.findElement(By.className("title"));
    }
}
