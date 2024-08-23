package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P04_Open_account {
    public WebElement username(){ //Username

        return driver.findElement(By.name("username"));
    }
    public WebElement password(){ //password
        return driver.findElement(By.name("password"));
    }
    public WebElement login_after_username_password() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
    }
    public WebElement type_account(){
        return driver.findElement(By.id("type"));
    }
    public WebElement choose_Account(){
        return driver.findElement(By.id("fromAccountId"));
    }
    public WebElement clicking_open_account(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a"));
    }
    public WebElement submit(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/div/input"));
    }
}
