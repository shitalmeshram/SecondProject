package com.LiveiNews.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 5/4/2017.
 */
public class RegistrationPage {
     WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement txtEmail(){
        return driver.findElement(By.id("reg_email"));
    }

    public WebElement txtPwd(){
        return driver.findElement(By.id("reg_password"));
    }

    public WebElement txtCpwd(){
        return driver.findElement(By.id("creg_password"));
    }

    public WebElement txtUname(){
        return driver.findElement(By.id("i-e-name"));
    }

    public WebElement nextBtn(){
        return driver.findElement(By.name("register"));
    }

    // Accept terms
    public WebElement chkTerms(){
        return driver.findElement(By.id("acceptterms"));
    }

    public WebElement nextBtn1(){
        return driver.findElement(By.xpath(".//*[@id='terms-modal']/div/p[2]/span"));
    }
    public WebElement submitBtn(){
        return driver.findElement(By.xpath(".//*[@id='registration-form']/p[2]/input"));
    }




}
