package com.LiveiNews.Pages;

import com.LiveiNews.Resources.DataGenerator;
import com.LiveiNews.Resources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by hishailesh77 on 5/11/2017.
 */
public class LiveiNewsHelper {
    public static HashMap UserRegisteration(PageResources pageResources, WebDriver driver){

        pageResources = new PageResources(driver);
        DataGenerator dataProvider = new DataGenerator();
        // To store multiple values in tabular structure
        HashMap hashMap = new HashMap();


        String email = dataProvider.randomEmailChars;
        String userName = dataProvider.randomUsernameChars;
        String pwd = dataProvider.pwdChars;
        String cPwd = dataProvider.cpwdChars;
        hashMap.put("Email",email);
        hashMap.put("Username",userName);
        hashMap.put("Password",pwd);

        pageResources.getRegistrationPage().txtEmail().sendKeys(email);
        System.out.println("Email ="+email);

        pageResources.getRegistrationPage().txtPwd().sendKeys(pwd);
        System.out.println("Password ="+pwd);

        pageResources.getRegistrationPage().txtCpwd().sendKeys(cPwd);
        System.out.println("Confirm Pwd ="+cPwd);

        pageResources.getRegistrationPage().txtUname().sendKeys(userName);
        System.out.println("Username ="+userName);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().nextBtn().click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().chkTerms().click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().nextBtn1().click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().submitBtn().click();
        // To reuse the output (as String email)
        return hashMap;
    }

    public static void MailinatorActivation(PageResources pageResources, WebDriver driver,HashMap hashMap){
        pageResources = new PageResources(driver);
        DataGenerator dataProvider = new DataGenerator();
        String email = (String) hashMap.get("Email");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Open tab 2 using CTRL + t keys.
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        //Open URL In 2nd tab.
        // driver.get("https://app.getnada.com/inbox/"+dataProvider.randomEmailChars);
        driver.navigate().to("https://www.mailinator.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        pageResources.getMailinatorPage().chkBox().sendKeys(email);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getMailinatorPage().goBtn().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getMailinatorPage().clickLink().click();
        //out of all frames
        driver.switchTo().defaultContent();
        //switch to frame
        driver.switchTo().frame("publicshowmaildivcontent");
        //finding the link text
        String linkText = driver.findElement(By.xpath("html/body")).getText();
        System.out.println("Link ="+linkText);
        //index of link text
        int a =  linkText.indexOf("http");
        // sub string begin index & end index
        String subStrLink = linkText.substring(a);
        System.out.println("String Link ="+subStrLink);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        driver.navigate().to(subStrLink);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
