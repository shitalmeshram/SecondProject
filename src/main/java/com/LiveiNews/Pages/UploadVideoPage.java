package com.LiveiNews.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by shail on 5/8/2017.
 */
public class UploadVideoPage {
    WebDriver driver;
    public UploadVideoPage(WebDriver driver){
        this.driver=driver;
    }
    public WebElement uploadBtn(){
        return driver.findElement(By.xpath("//a[@href='/upload-video/']"));
    }

    public WebElement chooseFileBtn(){
        return driver.findElement(By.xpath("//input[@id='the-video-file-field']"));
    }
    public WebElement titleBtn(){
        return driver.findElement(By.xpath("//input[@name='title']"));
    }
    public WebElement descriptionBtn(){
        return driver.findElement(By.xpath("//textarea[@name='description']"));
    }
    public WebElement selectCategory(){
        return driver.findElement(By.xpath("//select[@id='category']"));
    }
    public WebElement selectSubCategory(){
        return driver.findElement(By.xpath("//select[@id='sub_category']"));
    }
    public WebElement enterLocation(){
        return driver.findElement(By.xpath("//input[@id='add-location']"));
    }
    public WebElement enterChkBox(){
        return driver.findElement(By.xpath("//input[@id='other']"));
    }

    public WebElement submitBtn(){
        return driver.findElement(By.xpath("//input[@type='submit'][@class='btn btn-default']"));
    }
}
