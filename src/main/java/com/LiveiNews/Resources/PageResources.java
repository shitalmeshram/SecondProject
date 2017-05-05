package com.LiveiNews.Resources;

import com.LiveiNews.Pages.HomePage;
import com.LiveiNews.Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 5/4/2017.
 */
public class PageResources {
     WebDriver driver;
      HomePage homePage;
     RegistrationPage registrationPage;

    public PageResources(WebDriver driver){
        this.driver=driver;
        homePage=new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

}
