package com.techproed.tests;

import com.techproed.pages.FhcTripCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripCreateTest extends TestBase {
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);
    }
    @Test (groups = {"fhctrip"})
    public void kayit() throws InterruptedException {
        giris();

        FhcTripCreatePage fhcTripCreatePage = new FhcTripCreatePage(driver);
        fhcTripCreatePage.code.sendKeys("1234");
        fhcTripCreatePage.name.sendKeys("onur");
        fhcTripCreatePage.adres.sendKeys("adana");
        fhcTripCreatePage.telefon.sendKeys("3737374");
        fhcTripCreatePage.mail.sendKeys("sgsgdg@gamil.com");

        Select select = new Select(fhcTripCreatePage.grup);//parantez icinde dropDown WebElementi var
        select.selectByIndex(1);
        Thread.sleep(3000);
        fhcTripCreatePage.saveButonu.click();
    }
}
