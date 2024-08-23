package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_def.Hooks.driver;

public class P03_Account_Balance {
    public WebElement Account_overview() {  //login icon before
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[2]/a  "));
    }
    public WebElement Title() {  //valid that the enquiry display
        return driver.findElement(By.className("title"));
    }
    public WebElement username(){ //Username

        return driver.findElement(By.name("username"));
    }
    public WebElement password(){ //password
        return driver.findElement(By.name("password"));
    }
    public WebElement login_after_username_password() {  //login icon after
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
    }
}
