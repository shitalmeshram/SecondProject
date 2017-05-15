package com.LiveiNews.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 5/5/2017.
 */
public class MailinatorPage {
    WebDriver driver;
    public MailinatorPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement chkBox(){
        return driver.findElement(By.id("inboxfield"));

    }

    public WebElement inboxTitle(){
        return driver.findElement(By.xpath("//div[@class='col-lg-1 col-md-1 visible-lg visible-md']"));

    }

    public WebElement goBtn(){
        return driver.findElement(By.xpath("html/body/section[1]/div/div[3]/div[2]/div[2]/div[1]/span/button"));

    }
    public WebElement clickLink(){
        return driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div/div/div[2]/div[5]/div"));
        //return driver.findElement(By.linkText("Activation on LiveiNews"));

    }
}
