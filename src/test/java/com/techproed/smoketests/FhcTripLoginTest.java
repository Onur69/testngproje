package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
    @Test
    public void girisTesti(){
        driver.get(ConfigurationReader.getProperty("fhc_login"));

        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);

        loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.sifreKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.logIn.click();
    }
}
