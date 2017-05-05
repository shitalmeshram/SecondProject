package com.LiveiNews.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 5/4/2017.
 */
public class HomePage {
     WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
     public WebElement signUpLink(){
        return driver.findElement(By.xpath(".//*[@id='menu-item-1716']/a"));

    }

}
