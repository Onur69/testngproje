package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {
    @BeforeMethod
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
      }
      @Test
    public void hotelCreate() throws InterruptedException {
          driver.findElement(By.id("Code")).sendKeys("12345");
          driver.findElement(By.id("Name")).sendKeys("Onur Nisanci");
          driver.findElement(By.id("Address")).sendKeys("Ankara/Turkiye");
          driver.findElement(By.id("Phone")).sendKeys("+90 545 555 6578");
          driver.findElement(By.id("Email")).sendKeys("onurnis69@gmail.com");

          Select select = new Select(driver.findElement(By.id("IDGroup")));

          select.selectByVisibleText("Hotel Type1");
          WebElement saveButonu = driver.findElement(By.id("btnSubmit"));
          Thread.sleep(2000);//click'e basmasi icin zaman vermezsek hata aliyoruz.
          saveButonu.click();

          // WebElement basariliYazisi = driver.findElement(By.className("bootbox-body"));
          WebDriverWait wait = new WebDriverWait(driver, 5);
          WebElement basariliYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
          Assert.assertTrue(basariliYazisi.isDisplayed());
      }
}