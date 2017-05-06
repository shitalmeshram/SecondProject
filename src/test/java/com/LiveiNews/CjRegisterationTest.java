package com.LiveiNews;

import com.LiveiNews.Resources.DataProvider;
import com.LiveiNews.Resources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by shail on 5/5/2017.
 */
public class CjRegisterationTest {
    WebDriver driver;
    PageResources pageResources;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://liveinews.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void HomePageTest(){
        pageResources = new PageResources(driver);
        pageResources.getHomePage().signUpLink().click();
    }

    @Test(priority = 2)
    public void CityJournalistRegistrationPageTest() throws InterruptedException {
        pageResources = new PageResources(driver);
        DataProvider dataProvider = new DataProvider();

        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().dropDown().click();
        Select select = new Select(pageResources.getRegistrationPage().dropDown());
        select.selectByVisibleText("City Journalist");

        pageResources.getRegistrationPage().txtEmail().sendKeys(dataProvider.randomEmailChars);
        System.out.println("Email ="+dataProvider.randomEmailChars);

        pageResources.getRegistrationPage().txtPwd().sendKeys(dataProvider.pwdChars);
        System.out.println("Password ="+dataProvider.pwdChars);

        pageResources.getRegistrationPage().txtCpwd().sendKeys(dataProvider.cpwdChars);
        System.out.println("Confirm Pwd ="+dataProvider.cpwdChars);

        pageResources.getRegistrationPage().txtUname().sendKeys(dataProvider.randomUsernameChars);
        System.out.println("Username ="+dataProvider.randomUsernameChars);

        pageResources.getRegistrationPage().firstName().sendKeys(dataProvider.randomFirstNameChars);
        System.out.println("First Name ="+dataProvider.randomFirstNameChars);

        pageResources.getRegistrationPage().lastName().sendKeys(dataProvider.randomLastnameChars);
        System.out.println("Last Name ="+dataProvider.randomLastnameChars);

        pageResources.getRegistrationPage().txtAddress().sendKeys(dataProvider.addressChars);
        System.out.println("Address ="+dataProvider.addressChars);

        pageResources.getRegistrationPage().txtPhone().sendKeys(dataProvider.phoneChars);
        System.out.println("Phone ="+dataProvider.phoneChars);

        pageResources.getRegistrationPage().txtZipCode().sendKeys(dataProvider.zipCodeChars);
        System.out.println("Zip Code ="+dataProvider.zipCodeChars);

        pageResources.getRegistrationPage().selectCountry().click();
        Select select1 = new Select(pageResources.getRegistrationPage().selectCountry());
        select1.selectByVisibleText("Afghanistan");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);

        pageResources.getRegistrationPage().selectState().click();
        Select state = new Select(pageResources.getRegistrationPage().selectState());
        state.selectByVisibleText("Velāyat-e Bādghīs");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);

        pageResources.getRegistrationPage().selectCity().click();
        Select city = new Select(pageResources.getRegistrationPage().selectCity());
        city.selectByVisibleText("Āb-e Garmak");
        Thread.sleep(5000);

        pageResources.getRegistrationPage().txtPayPal().sendKeys(dataProvider.payPalchars);
        System.out.println("PayPal account ="+dataProvider.payPalchars);
        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().nextBtn().click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().chkTerms().click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().nextBtn1().click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().submitBtn().click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Open tab 2 using CTRL + t keys.
        String windowHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        //Open URL In 2nd tab.
        driver.navigate().to("https://app.getnada.com/inbox/"+dataProvider.randomEmailChars);


    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      // driver.close();
       //driver.quit();
    }
}
