package com.LiveiNews.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 5/6/2017.
 */
public class LogOutPage {
    WebDriver driver;
    public LogOutPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement titleText(){
        return driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/h1"));
    }

    public WebElement logoutBtn(){
        return driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div[4]/nav/ul/li[7]/a"));
    }
}
