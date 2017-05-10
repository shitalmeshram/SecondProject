package com.LiveiNews;

import com.LiveiNews.Resources.DataGenerator;
import com.LiveiNews.Resources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
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
    public void CityJournalistRegistrationPageTest() throws InterruptedException, AWTException {
        pageResources = new PageResources(driver);
        DataGenerator dataProvider = new DataGenerator();

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Open tab 2 using CTRL + t keys.
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        //Open URL In 2nd tab.
        // driver.get("https://app.getnada.com/inbox/"+dataProvider.randomEmailChars);
        driver.navigate().to("https://www.mailinator.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageResources.getMailinatorPage().chkBox().sendKeys(dataProvider.randomEmailChars);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getMailinatorPage().goBtn().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageResources.getMailinatorPage().clickLink().click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

        //Login
        pageResources.getLoginPage().enterUname().sendKeys(dataProvider.randomUsernameChars);
        pageResources.getLoginPage().enterPwd().sendKeys(dataProvider.pwdChars);
        //pageResources.getLoginPage().enterUname().sendKeys("cool");
       // pageResources.getLoginPage().enterPwd().sendKeys("12345");
        pageResources.getLoginPage().loginBtn().click();

        //Upload video

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getUploadVideoPage().uploadBtn().click();
        pageResources.getUploadVideoPage().titleBtn().sendKeys(dataProvider.titleChars);
       // pageResources.getUploadVideoPage().chooseFileBtn().click();
        pageResources.getUploadVideoPage().chooseFileBtn().sendKeys("C:\\Users\\shail\\Pictures\\Camera Roll\\WIN_20170428_12_45_04_Pro.mp4");
       /* StringSelection ss = new StringSelection("C:\\Users\\shail\\Pictures\\Camera Roll\\WIN_20170428_12_45_04_Pro.mp4x");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);*/

        pageResources.getUploadVideoPage().descriptionBtn().sendKeys(dataProvider.descriptionChars);

        pageResources.getUploadVideoPage().selectCategory().click();
        Select category = new Select(pageResources.getUploadVideoPage().selectCategory());
        category.selectByVisibleText("Event News");
        //Thread.sleep(5000);

        pageResources.getUploadVideoPage().selectSubCategory().click();
        Select subCategory = new Select(pageResources.getUploadVideoPage().selectSubCategory());
        subCategory.selectByVisibleText("Local");
        //Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       // pageResources.getUploadVideoPage().enterLocation().sendKeys(dataProvider.locationChars);
        pageResources.getUploadVideoPage().enterLocation().sendKeys("s");
        Thread.sleep(5000);
        pageResources.getUploadVideoPage().enterLocation().sendKeys(Keys.DOWN);
        Thread.sleep(5000);
        pageResources.getUploadVideoPage().enterLocation().sendKeys(Keys.RETURN);

        Thread.sleep(5000);
        pageResources.getUploadVideoPage().enterChkBox().click();
        pageResources.getUploadVideoPage().submitBtn().click();








        /*Logout
        String textTitle = pageResources.getLogOutPage().titleText().getText();

        //Assert.assertTrue(textTitle.trim() =="My Account".trim());
        Assert.assertTrue(textTitle.contains("My Account"));
        System.out.println(textTitle);

        pageResources.getLogOutPage().logoutBtn().click();*/


    }

   /* @Test(priority = 3)
    public void UploadVideoPage(){
        pageResources = new PageResources(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getUploadVideoPage().uploadBtn().click();
    }*/

    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      // driver.close();
       //driver.quit();
    }
}
