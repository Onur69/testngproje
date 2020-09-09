package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

    public void giris(){//normal method olarak olusturduk ve testlerin icinden cagirabilecegiz.
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void table() throws InterruptedException {
        giris();
        Thread.sleep(3000);
        //tbody deki butun elementleri alalim ve yazdiralim
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement baslik : basliklar) {
            System.out.println("======================");
            System.out.println(baslik.getText());
        }
    }
        @Test
        public void tumSatirlar() throws InterruptedException {
            giris();
            Thread.sleep(3000);
            List<WebElement> tumSatirlar = driver.findElements(By.xpath("//tbody/tr"));
            for (WebElement satirlar : tumSatirlar) {
                System.out.println(satirlar.getText());
            }
        }
        @Test
        public void tumBody() throws InterruptedException {
            giris();
            Thread.sleep(3000);
            List<WebElement> tumHucreler = driver.findElements(By.xpath("//tbody/tr/td"));
            for (WebElement hucreler:tumHucreler) {
                System.out.println(hucreler.getText());
            }

        }
        @Test
        public void belirliBirSutunuYazdirma() throws InterruptedException {
            giris();
            Thread.sleep(3000);

            // //tbody/tr/td[4] -> Burada 4. sütun'u yazdırıyoruz.
            // buradaki 4 sayısını değiştirerek istediğimiz kolon(sütun)'u yazdırabiliriz.
            List<WebElement> nameSutunu = driver.findElements(By.xpath("//tbody/tr/td[4]"));//matrisler gibi 1. sira 4. sutun
            for (WebElement sutun:nameSutunu) {
                System.out.println(sutun.getText());
            }
        }
        @Test
        public void calistir() throws InterruptedException {
        giris();
        Thread.sleep(3000);
        hucreYazdir(3,5);
        hucreYazdir(5,2);
        hucreYazdir(2,5);
        hucreYazdir(6,4);
        }
        public void hucreYazdir(int satir, int sutun){//dinamik yapmak icin normal method olusturduk ve @Test ten cagirdik
            //tbody/tr[satir]/td[sutun]
            String xpathDegerim = "//tbody/tr["+ satir +"]/td["+ sutun +"]";
                                  //tbody/tr[3]/td[5]
            WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
            System.out.println(hucre.getText());
        }

    }


