package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.Step_def.Hooks.driver;

public class P02_login {

    public WebElement login_after_username_password() {  //login icon after
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
    }
    public WebElement username(){ //Username

        return driver.findElement(By.name("username"));
    }
    public WebElement password(){ //password
        return driver.findElement(By.name("password"));
    }
    public WebElement invalidation_ERROR_massage(){
        return driver.findElement(By.className("error"));
    }
}
