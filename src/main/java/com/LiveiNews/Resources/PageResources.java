package com.LiveiNews.Resources;


import com.LiveiNews.Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 5/4/2017.
 */
public class PageResources {
     WebDriver driver;
      HomePage homePage;
      RegistrationPage registrationPage;
      MailinatorPage mailinatorPage;
      LoginPage loginPage;
      LogOutPage logOutPage;

    public PageResources(WebDriver driver){
        this.driver=driver;
        homePage=new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        mailinatorPage = new MailinatorPage(driver);
        loginPage = new LoginPage(driver);
        logOutPage = new LogOutPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public MailinatorPage getMailinatorPage() {
        return mailinatorPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public LogOutPage getLogOutPage() {
        return logOutPage;
    }


}
