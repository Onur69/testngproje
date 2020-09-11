package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {
    @Test
    public void girisTesti(){
        driver.get("http://facebook.com");

        FacebookLoginPage loginPage = new FacebookLoginPage(driver);

        loginPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("fb_email"));
        loginPage.sifreKutusu.sendKeys(ConfigurationReader.getProperty("fb_pass"));

    }
}
