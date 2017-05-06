package com.LiveiNews.Resources;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by shail on 5/4/2017.
 */
public class DataProvider {
    public String randomFirstNameChars = RandomStringUtils.randomAlphabetic(7).toLowerCase();
    public String randomLastnameChars= RandomStringUtils.randomAlphabetic(7).toLowerCase();
    public String randomUsernameChars = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    public String randomEmailChars = randomUsernameChars + "@mailinator.com";

    public String pwdChars = "123456";
    public String cpwdChars = "123456";
    public String addressChars = "123 abc wxyz";
    public String phoneChars = "111-111-1111";
    public String zipCodeChars = "123456";
    public String companyNameChars = "abcdefg";
    public String einChars = "12-2345789";
    public String contactChars = "opqrst";
    public String mainContactChars = "abc123";
    public String payPalchars = "jfk@getnada.com";
}
