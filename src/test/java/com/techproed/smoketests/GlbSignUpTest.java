package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    @Test
    public void test() {
        //1. https://www.glbtrader.com/register-2.html adresine gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_url"));
        //* 2. Adım : GlbSignUpPage class'ından nesne üretip, webelementleri kullanalım.
        //* 3. Adım : İçerisine ekleyeceğimiz bilgileri (name, email, phone vs) yine
        //*           ConfigurationReader kullanarak, properties file'dan alalım.
        //* 4. Adım : Sign-Up butonuna tıklayalım.
        //* 5. Adım : Success yazısını görüp görmediğimi Assert ile doğrulayalım.
        GlbSignUpPage signUpPage = new GlbSignUpPage();
        signUpPage.emailKutusu.sendKeys(ConfigurationReader.getProperty("glb_email"));
        signUpPage.mobileKutusu.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        signUpPage.nameKutusu.sendKeys(ConfigurationReader.getProperty("glb_name"));
        signUpPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        signUpPage.rePasswordKutusu.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        signUpPage.signUpButtonu.click();
        System.out.println(signUpPage.successYazisi.getText());
        Assert.assertTrue(signUpPage.successYazisi.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
