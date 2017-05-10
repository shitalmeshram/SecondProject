package com.LiveiNews.Data;

import com.LiveiNews.Resources.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by shail on 5/9/2017.
 */
public class DataProviderClass {
    DataGenerator dataGenerator = new DataGenerator();



    @DataProvider(name ="LoginData")
        /*public static Object[][] getData() {

            // The number of times data is repeated, test will be executed the same no. of times

            // Here it will execute 2 times
            Object[][] data = new Object[2][2];
            // 1st row
            data[0][0]="wonder";
            data[0][1]="abcde";
            //2nd row
            data[1][0]="cool";
            data[1][1]="12345";

            return data;

    }*/
    public static Object[][] getData(Method m) {
        if(m.getName().equalsIgnoreCase("LoginTest1")){
            // Here it will execute 1 time
            Object[][] data = new Object[1][2];
            // 1st row
            data[0][0]="cool";
            data[0][1]="12345";
            return data;
        }
        else  {
            // Here it will execute 2 times
            Object[][] data = new Object[2][2];
            // 1st row
            data[0][0]="wonder";
            data[0][1]="abcde";
            //2nd row
            data[1][0]="cool";
            data[1][1]="12345";
            return data;

        }


        }

}
