package com.LiveiNews;

import com.LiveiNews.Data.DataProviderClass;
import com.LiveiNews.Resources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by hishailesh77 on 5/11/2017.
 */
public class UserLoginTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://liveinews.com/");
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"userName","passWord"})
    public void LoginTest1(String username,String pwd){
        PageResources pageResources = new PageResources(driver);
        //Click signup button
        pageResources.getHomePage().signUpLink().click();

        //Enter Username
        pageResources.getLoginPage().enterUname().sendKeys(username);
        System.out.println("Username ="+username);

        //Enter Password
        pageResources.getLoginPage().enterPwd().sendKeys(pwd);
        System.out.println("Password ="+pwd);

        //Click Login button
        pageResources.getLoginPage().loginBtn().click();

        //Verify title
        String textTitle = pageResources.getLogOutPage().titleText().getText();
        Assert.assertTrue(textTitle.contains("My Account"));
        System.out.println("Title ="+textTitle);

        //Click Logout button
       // pageResources.getLogOutPage().logoutBtn().click();
    }



    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
