package com.LiveiNews.Pages;

import com.sun.org.apache.bcel.internal.generic.Select;
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
    //For Media

    public WebElement dropDown()    {
        return driver.findElement(By.id("i-e-type"));

    }
  public WebElement firstName(){
        return driver.findElement(By.name("first_name"));
  }
    public WebElement lastName(){
        return driver.findElement(By.name("last_name"));
    }
    public WebElement txtAddress(){
        return driver.findElement(By.name("address"));
    }
    public WebElement txtPhone(){
        return driver.findElement(By.name("phone"));
    }
    public WebElement txtZipCode(){
        return driver.findElement(By.name("zipcode"));
    }
    public WebElement selectCountry(){
        return driver.findElement(By.name("country"));
    }
    public WebElement selectState(){
        return driver.findElement(By.name("state"));
    }

    public WebElement selectCity(){
        return driver.findElement(By.name("city"));
    }
    public WebElement txtCompanyName(){
        return driver.findElement(By.name("company_name"));
    }
    public WebElement txtEIN(){
        return driver.findElement(By.name("user_eid"));
    }
    public WebElement txtContact(){
        return driver.findElement(By.name("contact"));
    }
    public WebElement txtMainLegalConatct(){
        return driver.findElement(By.name("legal_contact"));
    }
    public WebElement txtPayPal(){
        return driver.findElement(By.name("paypal"));
    }






}
