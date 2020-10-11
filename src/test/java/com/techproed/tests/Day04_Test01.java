package com.techproed.tests;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Day04_Test01 extends TestBase {
    //" https://demoqa.com/dynamic-properties” sayfasina gidin
    //“Visible After 5 Seconds” butonunun gorunun oldugunu test edin

    @Test
    public void explicitlyWaitTest(){

        Driver.getDriver().get("https://demoqa.com/dynamic-properties");

        //WebElement besSnSonraGorunen = driver.findElement(By.id("visibleAfter"));

        // Thread.sleep(5000); kodu yazilan sure kadar bekletir
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // WebElement bulununcaya kadar MAX parantez icine yazilan sure kadar bekler
        // TestBase'de implicitly wait komutu yazildiysa test boyunca her webelkement bulunurken beklemeyi yapar

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        //compiler farkindan dolayi until comutunu gormuyor ve hata veriyor
        //WebElement bekleyipGoreleman = wait.until(ExpectedConditions.visibilityOf(besSnSonraGorunen));
        WebElement bekleyipGoreleman=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(bekleyipGoreleman.isDisplayed());
        Driver.closeDriver();
    }
}