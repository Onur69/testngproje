package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {
    public void giris(){//normal method olarak olusturduk ve testlerin icinden cagirabilecegiz.
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void tumSatirlar() throws InterruptedException {
        giris();
        Thread.sleep(3000);
        //body deki tum satirlarin rakamsal olarak sayisini bulmak
        List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
            System.out.println("Tabloda " + tumSatirlar.size() + " tane satir vardir.");

            //3. satirdaki tum elemanlari bulmak
            List<WebElement> ucuncuSatir = driver.findElements(By.xpath("//tbody/tr[3]"));
            for (WebElement satir:ucuncuSatir ) {
                System.out.println(satir.getText());

            }
        }
    }


