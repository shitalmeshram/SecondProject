package com.LiveiNews.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 5/6/2017.
 */
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement enterUname(){
        return driver.findElement(By.name("log"));
    }

    public WebElement enterPwd(){
        return driver.findElement(By.name("pwd"));
    }

    public WebElement loginBtn(){
        return driver.findElement(By.name("wp-submit"));
    }
}
