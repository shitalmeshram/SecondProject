package com.LiveiNews;

import com.LiveiNews.Resources.DataGenerator;
import com.LiveiNews.Resources.PageResources;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.LiveiNews.Pages.LiveiNewsHelper;         //always use full path
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.io.*;

/**
 * Created by shail on 5/4/2017.
 */
public class UserRegistrationTest {
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
    public void RegisterationPageTest() throws SAXException, ParserConfigurationException {
        pageResources = new PageResources(driver);
        HashMap hashMap = LiveiNewsHelper.UserRegisteration(pageResources,driver);
        String email = (String) hashMap.get("Email");
        String username =  (String) hashMap.get("Username");
        LiveiNewsHelper.MailinatorActivation(pageResources,driver,hashMap);


       String testData = "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\" >\n" +
               "<suite name=\"suiteA-Chrome\">\n" +
               "    <test name=\"TestBidQA\" preserve-order=\"true\">\n" +
               "        <parameter name=\"userName\" value=\""+username+"\"/>\n" +
               "        <parameter name=\"passWord\" value=\"123456\"/>\n" +
               "        <parameter name=\"email\" value=\""+email+"\"/>\n" +
               "        <parameter name=\"browser\" value=\"chrome\"/>\n" +
               "        <parameter name=\"driverName\" value=\"webdriver.chrome.driver\"/>\n" +
               "        <parameter name=\"driverLocation\" value=\"Drivers\\\\chromedriver.exe\"/>\n" +
               "        <classes>\n" +
               "            <class name=\"com.LiveiNews.UserLoginTest\">\n" +
               "\n" +
               "            </class>\n" +
               "\n" +
               "        </classes>\n" +
               "    </test>\n" +
               "\n" +
               "</suite>";

        //C:\Automation\SecondProject\src\test\resources\suite-files\suiteA-Chrome.xml
       //Java File IO
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String randomFileName= RandomStringUtils.randomAlphanumeric(10).toLowerCase();
            String FILENAME = "C:\\Automation\\SecondProject\\src\\test\\resources\\suite-files\\Suite-"+randomFileName+".xml";

            String suiteName = "<suite-file path=\"suite-files/Suite-"+randomFileName+".xml\"/>";
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(testData);

            System.out.println("Done");
            System.out.println(randomFileName+".xml");

            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dct=db.parse(new File("C:\\Automation\\SecondProject\\src\\test\\resources\\testng.xml"));

            Element dataTag = dct.getDocumentElement();
            Element suitesTag =  (Element) dataTag.getElementsByTagName("suite-files").item(0);
            Element newSuite = dct.createElement("suite-file");
            newSuite.setAttribute("path","suite-files/Suite-"+randomFileName+".xml");
          suitesTag.appendChild(newSuite);



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

       DataGenerator dataProvider = new DataGenerator();

       /* pageResources.getRegistrationPage().txtEmail().sendKeys(dataProvider.randomEmailChars);
        System.out.println("Email ="+dataProvider.randomEmailChars);

        pageResources.getRegistrationPage().txtPwd().sendKeys(dataProvider.pwdChars);
        System.out.println("Password ="+dataProvider.pwdChars);

        pageResources.getRegistrationPage().txtCpwd().sendKeys(dataProvider.cpwdChars);
        System.out.println("Confirm Pwd ="+dataProvider.cpwdChars);

        pageResources.getRegistrationPage().txtUname().sendKeys(dataProvider.randomUsernameChars);
        System.out.println("Username ="+dataProvider.randomUsernameChars);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().nextBtn().click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().chkTerms().click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().nextBtn1().click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getRegistrationPage().submitBtn().click();
*/
        /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);*/

                    //Login
       /* pageResources.getLoginPage().enterUname().sendKeys(dataProvider.randomUsernameChars);
        pageResources.getLoginPage().enterPwd().sendKeys(dataProvider.pwdChars);
        pageResources.getLoginPage().loginBtn().click();

        //Logout
        String textTitle = pageResources.getLogOutPage().titleText().getText();

       //Assert.assertTrue(textTitle.trim() =="My Account".trim());
        Assert.assertTrue(textTitle.contains("My Account"));
        System.out.println(textTitle);

        pageResources.getLogOutPage().logoutBtn().click();
*/

           }


    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       //driver.close();
        //driver.quit();
    }
}
