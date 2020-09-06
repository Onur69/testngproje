package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {

    @Test
            public void test1(){
        driver.get("http://amazon.com");
        WebElement webElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);

        actions.moveToElement(webElement).perform();

        WebElement startHere = driver.findElement(By.partialLinkText("Start here."));
        startHere.click();

        Assert.assertEquals("Amazon Registration",driver.getTitle());
       }

    @Test (dependsOnMethods = "test1")//driver.get() tekrardan yapmadan test1'e baglayip calistirdik.
    public void test2() {
        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("onur");

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("onurnis@gmail.com");

        WebElement sifre = driver.findElement(By.id("ap_password"));
        sifre.sendKeys("asdfgh");

        //bu sekilde de webelement'i kullanmadan yazabiliriz
        driver.findElement(By.id("ap_password_check")).sendKeys("asdfgh");;


        WebElement onaylama = driver.findElement(By.id("continue"));
        onaylama.click();
    }
}
